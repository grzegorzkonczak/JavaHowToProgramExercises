// Grzegorz Koñczak, 25.07.2016
// Exercise number 12.15 page 592
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DisplayingEvents {

	private JFrame frame;
	private String[] options = {"1", "2", "3", "4", "5"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayingEvents window = new DisplayingEvents();
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
	public DisplayingEvents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnActionListener = new JButton("Action Listener");
		btnActionListener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.toString());
			}
		});
		frame.getContentPane().add(btnActionListener);
		
		JCheckBox chckbxItemListener = new JCheckBox("Item Listener");
		chckbxItemListener.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				System.out.println(arg0.toString());
			}
		});
		frame.getContentPane().add(chckbxItemListener);
		
		JList<String> list = new JList<String>(options);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				System.out.println(arg0.toString());
			}
		});
		list.setVisibleRowCount(3);
		
		JScrollPane scrollPane = new JScrollPane(list);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(arg0.toString());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println(e.toString());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println(e.toString());
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.toString());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println(e.toString());
			}
		});
		frame.getContentPane().add(panel);
		
		JLabel lblMouseListener = new JLabel("Mouse Listener");
		panel.add(lblMouseListener);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				System.out.println(arg0.toString());
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println(e.toString());
			}
		});
		frame.getContentPane().add(panel_1);
		
		JLabel lblMouseMotionListener = new JLabel("Mouse Motion Listener");
		panel_1.add(lblMouseMotionListener);
		
		JTextArea txtrKeyListener = new JTextArea();
		txtrKeyListener.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.toString());
			}
		});
		txtrKeyListener.setText("Key Listener");
		frame.getContentPane().add(txtrKeyListener);
		
	}

}
