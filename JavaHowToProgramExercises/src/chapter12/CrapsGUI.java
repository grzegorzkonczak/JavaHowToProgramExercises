// Grzegorz Koñczak, 25.07.2016
// Exercise number 12.16 page 592
// Exercise from Java:How to program 10th edition

package chapter12;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CrapsGUI extends JPanel {
	
	CrapsGame game;
	public void setRollOne(String rollOne) {
		this.rollOne.setText(rollOne);
	}

	public void setRollTwo(String rollTwo) {
		this.rollTwo.setText(rollTwo);
	}

	public void setRollSum(String rollSum) {
		this.rollSum.setText(rollSum);
	}

	public void setPoint(String point) {
		this.point.setText(point);
	}

	public void setGameStatus(String gameStatus) {
		this.gameStatus.setText(gameStatus);
	}


	private JTextField rollOne;
	private JTextField rollTwo;
	private JTextField rollSum;
	private JTextField point;
	private JLabel gameStatus;

	/**
	 * Create the panel.
	 */
	public CrapsGUI(CrapsGame parentGame) {
		setLayout(new BorderLayout(0, 0));
		
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.rollDiceClicked();
			}
		});
		add(btnRollDice, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblFirstDie = new JLabel("First Die");
		panel.add(lblFirstDie);
		
		rollOne = new JTextField();
		rollOne.setFont(new Font("SansSerif", Font.PLAIN, 25));
		rollOne.setEditable(false);
		panel.add(rollOne);
		rollOne.setColumns(10);
		
		JLabel lblSecondDie = new JLabel("Second Die");
		panel.add(lblSecondDie);
		
		rollTwo = new JTextField();
		rollTwo.setFont(new Font("SansSerif", Font.PLAIN, 25));
		rollTwo.setEditable(false);
		panel.add(rollTwo);
		rollTwo.setColumns(10);
		
		JLabel lblSum = new JLabel("Sum");
		panel.add(lblSum);
		
		rollSum = new JTextField();
		rollSum.setFont(new Font("SansSerif", Font.PLAIN, 25));
		rollSum.setEditable(false);
		panel.add(rollSum);
		rollSum.setColumns(10);
		
		JLabel lblPoint = new JLabel("Point");
		panel.add(lblPoint);
		
		point = new JTextField();
		point.setFont(new Font("SansSerif", Font.PLAIN, 25));
		point.setEditable(false);
		panel.add(point);
		point.setColumns(10);
		
		gameStatus = new JLabel("Game in Progress");
		gameStatus.setFont(new Font("SansSerif", Font.PLAIN, 25));
		gameStatus.setHorizontalAlignment(SwingConstants.CENTER);
		add(gameStatus, BorderLayout.SOUTH);
		game = parentGame;

	}

}
