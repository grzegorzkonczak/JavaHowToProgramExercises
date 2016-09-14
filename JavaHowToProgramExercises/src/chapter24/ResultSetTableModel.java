// Grzegorz Koñczak, 14.09.2016
// Exercise number 24.2 page 1146
// Exercise from Java:How to program 10th edition

package chapter24;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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

	// Creating prepared queries and adding them to array for use in JComboBox
	private PreparedStatement selectAllAuthors;
	private PreparedStatement selectAuthor;
	private PreparedStatement selectTitle;

	// Array for holding prepared statement objects
	private PreparedStatement[] statements = new PreparedStatement[3];

	// keep track of database connection status
	private boolean connectedToDatabase = false;

	// constructor initializes resultSet and obtains its meta data object;
	// determines number of rows
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

		// populate statements array
		statements[0] = selectAllAuthors;
		statements[1] = selectAuthor;
		statements[2] = selectTitle;

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
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1);
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
		// ensure database connection is available
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		
		// Specify query variable if needed
		if (choice != 0) {
			statements[choice].setString(1, variable);
		}

		// specify query and execute it
		resultSet = statements[choice].executeQuery();

		// obtain meta data for ResultSet
		metaData = resultSet.getMetaData();

		// determine number of rows in ResultSet
		resultSet.last(); // move to last row
		numberOfRows = resultSet.getRow(); // get row number

		// notify JTable that model has changed
		fireTableStructureChanged();
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
