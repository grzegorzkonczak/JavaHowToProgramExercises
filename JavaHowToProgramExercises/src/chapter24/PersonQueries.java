// Grzegorz Koñczak, 15.09.2016
// Exercise number 24.7/8 page 1147
// Exercise from Java:How to program 10th edition

package chapter24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries {
	private static final String URL = "jdbc:derby:addressbook";
	private static final String USERNAME = "checkrise";
	private static final String PASSWORD = "checkrise";

	private Connection connection; // manages connection
	private PreparedStatement selectAllPeople;
	private PreparedStatement selectPeopleByLastName;
	private PreparedStatement insertNewPerson;
	private PreparedStatement updatePerson;
	private PreparedStatement deletePerson;

	// constructor
	public PersonQueries() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// create query that selects all entries in the AddressBook
			selectAllPeople = connection.prepareStatement("SELECT * FROM Addresses");

			// create query that selects entries with a specific last name
			selectPeopleByLastName = connection.prepareStatement("SELECT * FROM Addresses WHERE LastName = ?");

			// create insert that adds a new entry into the database
			insertNewPerson = connection.prepareStatement(
					"INSERT INTO Addresses " + "(FirstName, LastName, Email, PhoneNumber) " + "VALUES (?, ?, ?, ?)");

			// create statement that updates entry in database
			updatePerson = connection.prepareStatement(
					"UPDATE Addresses SET FirstName = ?, LastName = ?, Email = ?, PhoneNumber = ? WHERE AddressID = ?");
			
			// create statement that deletes entry from database
			deletePerson = connection.prepareStatement(
					"DELETE FROM Addresses WHERE AddressID = ?");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	} // end PersonQueries constructor

	// select all of the addresses in the database
	public List<Person> getAllPeople() {
		List<Person> results = null;
		ResultSet resultSet = null;

		try {
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectAllPeople.executeQuery();
			results = new ArrayList<Person>();

			while (resultSet.next()) {
				results.add(new Person(resultSet.getInt("addressID"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getString("email"),
						resultSet.getString("phoneNumber")));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			}
		}

		return results;
	}

	// select person by last name
	public List<Person> getPeopleByLastName(String name) {
		List<Person> results = null;
		ResultSet resultSet = null;

		try {
			selectPeopleByLastName.setString(1, name); // specify last name

			// executeQuery returns ResultSet containing matching entries
			resultSet = selectPeopleByLastName.executeQuery();

			results = new ArrayList<Person>();

			while (resultSet.next()) {
				results.add(new Person(resultSet.getInt("addressID"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getString("email"),
						resultSet.getString("phoneNumber")));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			}
		}

		return results;
	}

	// add an entry
	public int addPerson(String fname, String lname, String email, String num) {
		int result = 0;

		// set parameters, then execute insertNewPerson
		try {
			insertNewPerson.setString(1, fname);
			insertNewPerson.setString(2, lname);
			insertNewPerson.setString(3, email);
			insertNewPerson.setString(4, num);

			// insert the new entry; returns # of rows updated
			result = insertNewPerson.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}

		return result;
	}

	public int updatePerson(String fname, String lname, String email, String num, String id) {
		int result = 0;

		// set parameters, then execute updatePerson
		try {
			updatePerson.setString(1, fname);
			updatePerson.setString(2, lname);
			updatePerson.setString(3, email);
			updatePerson.setString(4, num);
			updatePerson.setInt(5, Integer.parseInt(id));

			// update entry; returns # of rows updated
			result = updatePerson.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}

		return result;
	}
	
	public int deletePerson(String id) {
		int result = 0;

		// set parameters, then execute updatePerson
		try {
			deletePerson.setInt(1, Integer.parseInt(id));

			// update entry; returns # of rows updated
			result = deletePerson.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}

		return result;
	}

	// close the database connection
	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
