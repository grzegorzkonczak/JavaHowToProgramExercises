// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.23 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TurtleGraphicsWithGui extends JPanel {

	Turtle turtle = new Turtle();

	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TurtleGraphicsWithGui() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblHowManyUnits = new JLabel("How many units to move: ");
		panel.add(lblHowManyUnits);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnMove = new JButton("Move");
		panel.add(btnMove);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnPenUp = new JButton("Pen Up");
		btnPenUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				turtle.setDrawing(false);
			}
		});
		panel_1.add(btnPenUp);
		
		JButton btnPenDown = new JButton("Pen Down");
		btnPenDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turtle.setDrawing(true);
			}
		});
		panel_1.add(btnPenDown);
		
		TurtlePaintingWindow panel_2 = new TurtlePaintingWindow(turtle);
		panel_2.setBackground(Color.WHITE);
		add(panel_2, BorderLayout.CENTER);
		
		JButton btnTurnLeft = new JButton("Turn Left");
		btnTurnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (turtle.getFacing() == 0){
					turtle.setFacing(1);
				}else if(turtle.getFacing() == 1){
					turtle.setFacing(2);
				}else if(turtle.getFacing() == 2){
					turtle.setFacing(3);
				}else {
					turtle.setFacing(0);
				}
				
				panel_2.repaint();
			}
		});
		panel_1.add(btnTurnLeft);
		
		JButton btnTurnRight = new JButton("Turn Right");
		btnTurnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (turtle.getFacing() == 0){
					turtle.setFacing(3);
				}else if(turtle.getFacing() == 3){
					turtle.setFacing(2);
				}else if(turtle.getFacing() == 2){
					turtle.setFacing(1);
				}else {
					turtle.setFacing(0);
				}
				
				panel_2.repaint();
			}
		});
		panel_1.add(btnTurnRight);

		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turtle.setUnitsToMove(Integer.parseInt(textField.getText()));
				turtle.move();
				panel_2.repaint();
			}
		});
	}

}
