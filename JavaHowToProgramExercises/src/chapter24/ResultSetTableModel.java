// Grzegorz Koñczak, 14/15.09.2016
// Exercise number 24.2/3 page 1146/1147
// Exercise from Java:How to program 10th edition

package chapter24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

// ResultSet rows and columns are counted from 1 and JTable 
// rows and columns are counted from 0. When processing 
// ResultSet rows or columns for use in a JTable, it is 
// necessary to add 1 to the row or column number to manipulate
// the appropriate ResultSet column (i.e., JTable column 0 is 
// ResultSet column 1 and JTable row 0 is ResultSet row 1).
public class ResultSetTableModel extends AbstractTableModel {
	private final Connection connection;
	private final Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	private List<ArrayList<Object>> results;

	// Creating prepared queries and adding them to array for use in JComboBox
	private PreparedStatement selectAllAuthors;
	private PreparedStatement selectAuthor;
	private PreparedStatement selectTitle;
	private PreparedStatement addAuthor;
	private PreparedStatement addTitle;
	private PreparedStatement editAuthor;
	private PreparedStatement link;

	// Array for holding prepared statement objects
	private PreparedStatement[] statements = new PreparedStatement[7];

	// keep track of database connection status
	private boolean connectedToDatabase = false;

	// constructor creates all prepared statements and initializes default query executed on application start
	public ResultSetTableModel(String url, String username, String password, String query) throws SQLException {
		// connect to database
		connection = DriverManager.getConnection(url, username, password);

		// create query that selects all entries in the authors
		selectAllAuthors = connection.prepareStatement("SELECT * FROM authors", ResultSet.CONCUR_READ_ONLY,
				ResultSet.TYPE_SCROLL_INSENSITIVE);

		// create query that selects entries with a specific last name
		selectAuthor = connection.prepareStatement(
				"SELECT FirstName, LastName, Title, titles.isbn, Copyright" + " FROM authors INNER JOIN authorISBN ON"
						+ " authors.authorID = authorISBN.authorID INNER JOIN titles"
						+ " ON authorISBN.isbn = titles.isbn" + " WHERE LastName = ? ORDER BY" + " LastName, FirstName",
				ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);

		// create query that selects entries with a specific title
		selectTitle = connection.prepareStatement(
				"SELECT Title, FirstName, LastName "
						+ "FROM titles INNER JOIN authorISBN ON titles.isbn = authorISBN.isbn "
						+ "INNER JOIN authors ON authorISBN.authorID = authors.authorID "
						+ "WHERE title LIKE ? ORDER BY LastName, FirstName",
				ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);

		// create statement that adds new author to database
		addAuthor = connection.prepareStatement("INSERT INTO authors " + "(FirstName, LastName) " + "VALUES (?, ?)");

		// create statement that adds new title to database
		addTitle = connection
				.prepareStatement("INSERT INTO titles (Title, EditionNumber, Copyright, ISBN) VALUES (?, ?, ?, ?)");

		// create statement that edits existing author
		editAuthor = connection.prepareStatement("UPDATE authors SET FirstName = ?, LastName = ? WHERE authorID = ?");

		// create statement that links author with title by inserting proper
		// values to authorISBN table
		link = connection.prepareStatement("INSERT INTO authorISBN (authorID, isbn) VALUES (?, ?)");

		// populate statements array
		statements[0] = selectAllAuthors;
		statements[1] = selectAuthor;
		statements[2] = selectTitle;
		statements[3] = addAuthor;
		statements[4] = addTitle;
		statements[5] = editAuthor;
		statements[6] = link;

		// create Statement to query database
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// update database connection status
		connectedToDatabase = true;

		// set query and execute it
		setQuery(query);
	}

	// get class that represents column type
	public Class getColumnClass(int column) throws IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// determine Java class of column
		try {
			String className = metaData.getColumnClassName(column + 1);

			// return Class object that represents className
			return Class.forName(className);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return Object.class; // if problems occur above, assume type Object
	}

	// get number of columns in ResultSet
	public int getColumnCount() throws IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// determine number of columns
		try {
			return metaData.getColumnCount();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return 0; // if problems occur above, return 0 for number of columns
	}

	// get name of a particular column in ResultSet
	public String getColumnName(int column) throws IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// determine column name
		try {
			return metaData.getColumnName(column + 1);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return ""; // if problems, return empty string for column name
	}

	// return number of rows in ResultSet
	public int getRowCount() throws IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		return numberOfRows;
	}

	// obtain value in particular row and column
	public Object getValueAt(int row, int column) throws IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// obtain a value at specified ResultSet row and column
		try {
			if (resultSet.absolute(row + 1)) {
				return resultSet.getObject(column + 1);
			} else {
				return results.get(row).get(column);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return ""; // if problems, return empty string object
	}

	// set new database query string
	public void setQuery(String query) throws SQLException, IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// specify query and execute it
		resultSet = statement.executeQuery(query);

		// obtain meta data for ResultSet
		metaData = resultSet.getMetaData();

		// determine number of rows in ResultSet
		resultSet.last(); // move to last row
		numberOfRows = resultSet.getRow(); // get row number

		// notify JTable that model has changed
		fireTableStructureChanged();
	}

	// set new database query with prepared statement
	public void setQuery(Integer choice, String variable) throws SQLException, IllegalStateException {
		// initialize new Array List for storing results
		results = new ArrayList<>();

		// ensure database connection is available
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// Specify query variable if needed
		if (choice != 0) {
			statements[choice].setString(1, variable);
		}

		// specify query and execute it
		resultSet = statements[choice].executeQuery();

		// obtain meta data for ResultSet and number of columns for generating
		// variable results
		metaData = resultSet.getMetaData();
		int columnCount = metaData.getColumnCount();

		// determine number of rows in ResultSet and store results in array list
		// of array lists
		numberOfRows = 0;
		while (resultSet.next()) {
			ArrayList<Object> row = new ArrayList<>();
			for (int i = 0; i < columnCount; i++) {
				row.add(resultSet.getObject(i + 1));
			}
			results.add(row);
			numberOfRows++;
		}

		// notify JTable that model has changed
		fireTableStructureChanged();
	}

	public void update(int option, List<String> variables) throws SQLException {
		int count = 0;
		String message = "";
		// ensure database connection is available
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		switch (option) {
		// Adding new author
		case 3:
			statements[option].setString(1, variables.get(0));
			statements[option].setString(2, variables.get(1));
			count = statements[option].executeUpdate();
			message = "Added " + count + " new author.";
			JOptionPane.showMessageDialog(null, message, "Confirmation", JOptionPane.PLAIN_MESSAGE);
			break;
		// Adding new title
		case 4:
			statements[option].setString(1, variables.get(0));
			statements[option].setInt(2, Integer.parseInt(variables.get(1)));
			statements[option].setString(3, variables.get(2));
			statements[option].setString(4, variables.get(3));
			count = statements[option].executeUpdate();
			message = "Added " + count + " new title.";
			JOptionPane.showMessageDialog(null, message, "Confirmation", JOptionPane.PLAIN_MESSAGE);
			break;
		// Editing existing author
		case 5:
			statements[option].setString(1, variables.get(0));
			statements[option].setString(2, variables.get(1));
			statements[option].setInt(3, Integer.parseInt(variables.get(2)));
			count = statements[option].executeUpdate();
			message = "Edited " + count + " existing author.";
			JOptionPane.showMessageDialog(null, message, "Confirmation", JOptionPane.PLAIN_MESSAGE);
			break;
		// Linking author with title
		case 6:
			statements[option].setString(1, variables.get(0));
			statements[option].setString(2, variables.get(1));
			count = statements[option].executeUpdate();
			message = "Linked " + count + " author with book.";
			JOptionPane.showMessageDialog(null, message, "Confirmation", JOptionPane.PLAIN_MESSAGE);
			break;
		}

	}

	// close Statement and Connection
	public void disconnectFromDatabase() {
		if (connectedToDatabase) {
			// close Statement and Connection
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			} finally // update database connection status
			{
				connectedToDatabase = false;
			}
		}
	}

}
