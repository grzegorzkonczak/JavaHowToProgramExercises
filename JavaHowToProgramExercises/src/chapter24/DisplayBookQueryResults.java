// Grzegorz Koñczak, 14.09.2016
// Exercise number 24.2 page 1146
// Exercise from Java:How to program 10th edition

package chapter24;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.derby.iapi.sql.dictionary.StatementSchemaPermission;

public class DisplayBookQueryResults extends JFrame {
	public DisplayBookQueryResults() {
	}

	// database URL, username and password
	private static final String DATABASE_URL = "jdbc:derby:books";
	private static final String USERNAME = "checkrise";
	private static final String PASSWORD = "checkrise";

	// default query retrieves all data from authors table
	private static final String DEFAULT_QUERY = "SELECT * FROM authors";

	// Prepared statement names
	private static String allAuthors = "Display all authors";
	private static String specificAuthor = "Display all books from specific author";
	private static String specificTitle = "Display all authors for specific book";

	// Array for holding string representation of prepared statements
	private static String[] statementNames = { allAuthors, specificAuthor, specificTitle };

	// Variable for holding user selection of predefined query
	private static Integer choice = 0;

	private static ResultSetTableModel tableModel;

	public static void main(String args[]) {
		// create ResultSetTableModel and display database table
		try {
			// create TableModel for results of query SELECT * FROM authors
			tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);

			// set up JTextArea in which user types queries
			final JTextArea queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);

			JScrollPane scrollPane = new JScrollPane(queryArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			// set up JButton for submitting queries
			JButton submitButton = new JButton("Submit Query");

			// create Box to manage placement of queryArea and
			// submitButton in GUI
			Box boxNorthOne = Box.createHorizontalBox();
			boxNorthOne.add(scrollPane);
			boxNorthOne.add(submitButton);

			// Create JComboBox with names of prepared statements
			JComboBox<String> predefinedQueries = new JComboBox<>();
			for (int i = 0; i < statementNames.length; i++) {
				predefinedQueries.addItem(statementNames[i]);
			}
			// Create label and text field for completing predefined statement
			JLabel variableLabel = new JLabel(" Specify search criteria: ");
			JTextField variableForStatement = new JTextField(10);
			variableForStatement.setEditable(false);
			JButton submitPredefinedQuery = new JButton("Submit");

			// create second Box to manage placement of predefined queries GUI
			// elements
			Box boxNorthTwo = Box.createHorizontalBox();
			boxNorthTwo.add(predefinedQueries);
			boxNorthTwo.add(variableLabel);
			boxNorthTwo.add(variableForStatement);
			boxNorthTwo.add(Box.createHorizontalStrut(5));
			boxNorthTwo.add(submitPredefinedQuery);

			// Combine boxes to create north GUI Panel
			Box boxNorth = Box.createVerticalBox();
			boxNorth.add(boxNorthOne);
			boxNorth.add(Box.createVerticalStrut(5));
			boxNorth.add(boxNorthTwo);
			boxNorth.add(Box.createVerticalStrut(5));

			// create JTable based on the tableModel
			JTable resultTable = new JTable(tableModel);

			JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			Box boxSouth = Box.createHorizontalBox();

			boxSouth.add(filterLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterButton);

			// place GUI components on JFrame's content pane
			JFrame window = new JFrame("Displaying Query Results");
			window.getContentPane().add(boxNorth, BorderLayout.NORTH);
			window.getContentPane().add(new JScrollPane(resultTable), BorderLayout.CENTER);
			window.getContentPane().add(boxSouth, BorderLayout.SOUTH);

			// create event listener for submitButton
			submitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					// perform a new query
					try {
						tableModel.setQuery(queryArea.getText());
					} catch (SQLException sqlException) {
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error",
								JOptionPane.ERROR_MESSAGE);

						// try to recover from invalid user query
						// by executing default query
						try {
							tableModel.setQuery(DEFAULT_QUERY);
							queryArea.setText(DEFAULT_QUERY);
						} catch (SQLException sqlException2) {
							JOptionPane.showMessageDialog(null, sqlException2.getMessage(), "Database error",
									JOptionPane.ERROR_MESSAGE);

							// ensure database connection is closed
							tableModel.disconnectFromDatabase();

							System.exit(1); // terminate application
						}
					}
				}
			}); // end call to addActionListener

			// Get information about query selected by user and store it in
			// variable
			predefinedQueries.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					for (int i = 0; i < statementNames.length; i++) {
						if (statementNames[i].equals(e.getItem())) {
							choice = i;
						}
					}
					if (choice == 0){
						variableForStatement.setText("----------");
						variableForStatement.setEditable(false);
					}else if (choice == 1) {
						variableForStatement.setText("Author?");
						variableForStatement.setEditable(true);
					} else if (choice == 2) {
						variableForStatement.setText("Title?");
						variableForStatement.setEditable(true);
					}

				}
			});

			submitPredefinedQuery.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// perform a new query
					try {
						tableModel.setQuery(choice, variableForStatement.getText());
					} catch (SQLException sqlException) {
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error",
								JOptionPane.ERROR_MESSAGE);

						// try to recover from invalid user query
						// by executing default query
						try {
							tableModel.setQuery(DEFAULT_QUERY);
							queryArea.setText(DEFAULT_QUERY);
						} catch (SQLException sqlException2) {
							JOptionPane.showMessageDialog(null, sqlException2.getMessage(), "Database error",
									JOptionPane.ERROR_MESSAGE);

							// ensure database connection is closed
							tableModel.disconnectFromDatabase();

							System.exit(1); // terminate application
						}
					}
				}
			});

			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);

			// create listener for filterButton
			filterButton.addActionListener(new ActionListener() {
				// pass filter text to listener
				public void actionPerformed(ActionEvent e) {
					String text = filterText.getText();

					if (text.length() == 0)
						sorter.setRowFilter(null);
					else {
						try {
							sorter.setRowFilter(RowFilter.regexFilter(text));
						} catch (PatternSyntaxException pse) {
							JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}); // end call to addActionLister

			// dispose of window when user quits application (this overrides
			// the default of HIDE_ON_CLOSE)
			window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			window.setSize(600, 350);
			window.setVisible(true);

			// ensure database is closed when user quits application
			window.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent event) {
					tableModel.disconnectFromDatabase();
					System.exit(0);
				}
			});
		} catch (SQLException sqlException) {
			JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
			tableModel.disconnectFromDatabase();
			System.exit(1); // terminate application
		}
	}
}
