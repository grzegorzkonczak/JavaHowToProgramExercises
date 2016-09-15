// Grzegorz Koñczak, 14/15.09.2016
// Exercise number 24.2/3 page 1146/1147
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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.BorderFactory;
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
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
		// Set look and feel to Nimbus
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

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

			// Create bottom panel

			// Create filtering Gui components
			JLabel filterLabel = new JLabel("Filter:");
			final JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			Box boxSouthOne = Box.createHorizontalBox();

			boxSouthOne.add(filterLabel);
			boxSouthOne.add(filterText);
			boxSouthOne.add(filterButton);

			// Create components responsible for adding new author
			JLabel firstName = new JLabel("First Name: ");
			JTextField firstNameText = new JTextField(10);
			JLabel lastName = new JLabel("Last Name: ");
			JTextField lastNameText = new JTextField(10);
			JButton addAuthor = new JButton("Add Author");
			Box boxSouthTwo = Box.createHorizontalBox();

			boxSouthTwo.add(firstName);
			boxSouthTwo.add(firstNameText);
			boxSouthTwo.add(lastName);
			boxSouthTwo.add(lastNameText);
			boxSouthTwo.add(addAuthor);
			boxSouthTwo.setBorder(BorderFactory.createTitledBorder("Add Author"));

			// Create components responsible for adding new title
			JLabel title = new JLabel("Title: ");
			JTextField titleText = new JTextField(10);
			JLabel editionNumber = new JLabel("Edition Number: ");
			JTextField editionNumberText = new JTextField(10);
			JLabel copyright = new JLabel("Year Published: ");
			JTextField copyrightText = new JTextField(10);
			JLabel isbn = new JLabel("ISBN: ");
			JTextField isbnText = new JTextField(10);
			JButton addTitle = new JButton("Add Title");
			Box boxSouthThree = Box.createHorizontalBox();

			boxSouthThree.add(title);
			boxSouthThree.add(titleText);
			boxSouthThree.add(editionNumber);
			boxSouthThree.add(editionNumberText);
			boxSouthThree.add(copyright);
			boxSouthThree.add(copyrightText);
			boxSouthThree.add(isbn);
			boxSouthThree.add(isbnText);
			boxSouthThree.add(addTitle);
			boxSouthThree.setBorder(BorderFactory.createTitledBorder("Add Title"));

			// Create components for editing information about author
			JLabel authorID = new JLabel("Author ID: ");
			JTextField authorIdText = new JTextField(10);
			JLabel editAuthorFirstName = new JLabel("First Name: ");
			JTextField editAuthorFirstNameText = new JTextField(10);
			JLabel editAuthorLastName = new JLabel("Last Name: ");
			JTextField editAuthorLastNameText = new JTextField(10);
			JButton editAuthor = new JButton("Edit Author");
			Box boxSouthFour = Box.createHorizontalBox();

			boxSouthFour.add(authorID);
			boxSouthFour.add(authorIdText);
			boxSouthFour.add(editAuthorFirstName);
			boxSouthFour.add(editAuthorFirstNameText);
			boxSouthFour.add(editAuthorLastName);
			boxSouthFour.add(editAuthorLastNameText);
			boxSouthFour.add(editAuthor);
			boxSouthFour.setBorder(BorderFactory.createTitledBorder("Edit Author"));

			// Create components for linking author with book
			JLabel linkAuthorId = new JLabel("Author ID: ");
			JTextField linkAuthorIdText = new JTextField(10);
			JLabel linkBookISBN = new JLabel("Book ISBN: ");
			JTextField linkBookIsbnText = new JTextField(10);
			JButton linkTitile = new JButton("Link");
			Box boxSouthFive = Box.createHorizontalBox();

			boxSouthFive.add(linkAuthorId);
			boxSouthFive.add(linkAuthorIdText);
			boxSouthFive.add(linkBookISBN);
			boxSouthFive.add(linkBookIsbnText);
			boxSouthFive.add(linkTitile);
			boxSouthFive.setBorder(BorderFactory.createTitledBorder("Link Author With Title"));

			// Create bottom panel
			Box boxSouth = Box.createVerticalBox();
			boxSouth.add(boxSouthOne);
			boxSouth.add(Box.createVerticalStrut(10));
			boxSouth.add(boxSouthTwo);
			boxSouth.add(Box.createVerticalStrut(10));
			boxSouth.add(boxSouthThree);
			boxSouth.add(Box.createVerticalStrut(10));
			boxSouth.add(boxSouthFour);
			boxSouth.add(Box.createVerticalStrut(10));
			boxSouth.add(boxSouthFive);

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
					if (choice == 0) {
						variableForStatement.setText("----------");
						variableForStatement.setEditable(false);
					} else if (choice == 1) {
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

			// Listener for executing author adding to database by invoking table model method update
			addAuthor.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					List<String> variables = new ArrayList<>();
					variables.add(firstNameText.getText());
					variables.add(lastNameText.getText());
					try {
						tableModel.update(3, variables);
					} catch (SQLException sqlException) {
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			});
			
			// Listener for executing title adding to database by invoking table model method update
			addTitle.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					List<String> variables = new ArrayList<>();
					variables.add(titleText.getText());
					variables.add(editionNumberText.getText());
					variables.add(copyrightText.getText());
					variables.add(isbnText.getText());
					try {
						tableModel.update(4, variables);
					} catch (SQLException sqlException) {
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			// Listener for executing author editing in database by invoking table model method update
			editAuthor.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					List<String> variables = new ArrayList<>();
					variables.add(editAuthorFirstNameText.getText());
					variables.add(editAuthorLastNameText.getText());
					variables.add(authorIdText.getText());
					try {
						tableModel.update(5, variables);
					} catch (SQLException sqlException) {
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error",
								JOptionPane.ERROR_MESSAGE);
					}

					
				}
			});
			
			linkTitile.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					List<String> variables = new ArrayList<>();
					variables.add(linkAuthorIdText.getText());
					variables.add(linkBookIsbnText.getText());
					try {
						tableModel.update(6, variables);
					} catch (SQLException sqlException) {
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error",
								JOptionPane.ERROR_MESSAGE);
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
			window.setSize(750, 700);
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
