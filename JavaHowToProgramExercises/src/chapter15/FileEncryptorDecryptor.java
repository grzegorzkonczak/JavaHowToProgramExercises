// Grzegorz Koñczak, 19.08.2016
// Exercise number 15.8 page 725
// Exercise from Java:How to program 10th edition

package chapter15;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileEncryptorDecryptor extends JPanel {

	private Scanner input;
	private Formatter output;

	private JTextField inputField;
	private JTextField outputField;
	private JTextField keyField;

	public FileEncryptorDecryptor() {

		// GUI building
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblInputFile = new JLabel("  Input File: ");
		add(lblInputFile);

		inputField = new JTextField();
		add(inputField);
		inputField.setColumns(10);

		JLabel lblOutputFile = new JLabel("  Output File: ");
		add(lblOutputFile);

		outputField = new JTextField();
		add(outputField);
		outputField.setColumns(10);

		JLabel lblEncryptionKey = new JLabel("  Encryption Key: ");
		add(lblEncryptionKey);

		keyField = new JTextField();
		add(keyField);
		keyField.setColumns(10);

		JButton btnEncrypt = new JButton("Encrypt");
		add(btnEncrypt);

		JButton btnDecrypt = new JButton("Decrypt");
		add(btnDecrypt);

		// Listener for encryption
		btnEncrypt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				openFiles();
				encryptDecryptFile();
				closeFiles();
			}
		});

		// Listener for decryption (same as encryption)
		btnDecrypt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openFiles();
				encryptDecryptFile();
				closeFiles();
			}
		});
	}

	// Main method for encrypting/decrypting text files using cipher encryption
	private void encryptDecryptFile() {

		// Initialize two help lists for storing original and
		// encrypted/decrypted words
		List<String> inputWords = new ArrayList<>();
		List<String> outputWords = new ArrayList<>();

		// Extract words from file
		while (input.hasNext()) {
			inputWords.add(input.next());
		}

		// Extract letters from words by traversing all words in help ArrayList
		// of words
		Iterator<String> iterator = inputWords.iterator();
		while (iterator.hasNext()) {
			char[] charactersOriginal = iterator.next().toCharArray();
			char[] charactersEncrypted = new char[charactersOriginal.length];

			// Encrypt individual letters and construct encrypted words
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < charactersOriginal.length; i++) {
				// Obtain encrypted character by passing original character with
				// shift key provided by user
				// to cipher method
				charactersEncrypted[i] = cipher(Character.toLowerCase(charactersOriginal[i]),
						Integer.parseInt(keyField.getText()));
				builder.append(Character.toString(charactersEncrypted[i]));
			}
			// Store encrypted words in help ArrayList (could write directly to
			// file)
			outputWords.add(builder.toString());
		}

		// Output all encrypted words to file
		for (String string : outputWords) {
			output.format("%s ", string);
		}
	}

	// Simple cipher shift encryption method for single character
	private char cipher(char c, int key) {
		char encryptedChar = (char) (c + key);
		if (encryptedChar > 'z') {
			encryptedChar = (char) (encryptedChar - 26);
		} else if (encryptedChar < 'a') {
			encryptedChar = (char) (encryptedChar + 26);
		}
		return encryptedChar;
	}

	// Close all files
	private void closeFiles() {
		input.close();
		output.close();
	}

	// Open necessary files for encryption/decryption
	private void openFiles() {
		try {
			input = new Scanner(Paths.get(inputField.getText()));
		} catch (IOException e) {
			System.err.println("Wrong input file location!");
			e.printStackTrace();
		}

		try {
			output = new Formatter(outputField.getText());
		} catch (FileNotFoundException e) {
			System.err.println("Wrong output file location!");
			e.printStackTrace();
		}
	}
}
