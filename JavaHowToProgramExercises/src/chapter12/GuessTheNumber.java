// Grzegorz Koñczak, 25.07.2016
// Exercise number 12.14 page 592
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.security.SecureRandom;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessTheNumber {

	private JFrame frame;
	private JTextField txtEnterYourGuess;
	private final SecureRandom randomNumbers = new SecureRandom();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessTheNumber window = new GuessTheNumber();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuessTheNumber() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 439, 163);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblGuessTheNumber = new JLabel("Guess the number!");

		JLabel lblInfo = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
		frame.getContentPane().add(lblInfo, BorderLayout.NORTH);

		JLabel lblPleaseEnterYour = new JLabel("Please enter your guess: ");
		frame.getContentPane().add(lblPleaseEnterYour, BorderLayout.WEST);

		txtEnterYourGuess = new JTextField();
		txtEnterYourGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int guess = Integer.parseInt(e.getActionCommand());

					if ((distance) >= Math.abs(randomNumber - guess) || distance == 0) {
						distance = Math.abs(randomNumber - guess);
						frame.getContentPane().setBackground(Color.RED);
					} else
						frame.getContentPane().setBackground(Color.BLUE);

					if (guess == randomNumber) {
						lblGuessTheNumber.setText("Correct!");
						frame.getContentPane().setBackground(Color.GREEN);
						txtEnterYourGuess.setEditable(false);
					} else if (guess > randomNumber) {
						lblGuessTheNumber.setText("Too high!");
					} else
						lblGuessTheNumber.setText("Too low...");
				} catch (NumberFormatException exeption) {
					// Show error message about wrong input
					JOptionPane.showMessageDialog(frame, "Input Something! And it should be integer number...",
							"Wrong Input", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtEnterYourGuess.setText("Enter your guess here...");
		frame.getContentPane().add(txtEnterYourGuess, BorderLayout.CENTER);
		txtEnterYourGuess.setColumns(10);

		frame.getContentPane().add(lblGuessTheNumber, BorderLayout.EAST);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				randomNumber = 1 + randomNumbers.nextInt(1000);
				txtEnterYourGuess.setEditable(true);
				frame.getContentPane().setBackground(Color.LIGHT_GRAY);
				distance = 0;
			}
		});
		frame.getContentPane().add(btnNewGame, BorderLayout.SOUTH);
	}

	int randomNumber = 1 + randomNumbers.nextInt(1000);
	int distance = 0;

}
