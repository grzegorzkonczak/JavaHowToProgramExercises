// Grzegorz Koñczak, 22.07.2016
// Exercise number 12.10 page 592
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JRadioButton;

public class PrinterGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrinterGUI window = new PrinterGUI();
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
	public PrinterGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 191);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new MigLayout("", "[67px]", "[26px][][26px][][26px][][26px][]"));
		
		JButton btnOk = new JButton("Ok");
		panel.add(btnOk, "cell 0 1,grow");
		
		JButton btnCancel = new JButton("Cancel");
		panel.add(btnCancel, "cell 0 3,grow");
		
		JButton btnSetup = new JButton("Setup");
		panel.add(btnSetup, "cell 0 5,grow");
		
		JButton btnHelp = new JButton("Help");
		panel.add(btnHelp, "cell 0 7,grow");
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(5);
		textArea.setColumns(5);
		panel_1.add(textArea, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new MigLayout("", "[][]", "[]"));
		
		JLabel lblPrinterMyprinter = new JLabel("Printer: MyPrinter");
		panel_2.add(lblPrinterMyprinter, "cell 0 0");
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new MigLayout("", "[][][grow]", "[]"));
		
		JLabel lblPrintQuality = new JLabel("Print Quality:");
		panel_3.add(lblPrintQuality, "cell 0 0");
		
		JComboBox comboBox = new JComboBox();
		panel_3.add(comboBox, "flowx,cell 2 0,growx");
		
		JCheckBox chckbxPrintToFile = new JCheckBox("Print to File");
		panel_3.add(chckbxPrintToFile, "cell 2 0");
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[52px][57px][40px][66px]", "[18px][18px][37px]"));
		
		JTextArea textArea_1 = new JTextArea();
		panel_4.add(textArea_1, "cell 0 0 1 3,grow");
		
		JCheckBox chckbxImage = new JCheckBox("Image");
		panel_4.add(chckbxImage, "cell 1 0,alignx left,aligny top");
		
		JTextArea textArea_2 = new JTextArea();
		panel_4.add(textArea_2, "cell 2 0 1 3,grow");
		
		JRadioButton rdbtnSelection = new JRadioButton("Selection");
		panel_4.add(rdbtnSelection, "cell 3 0,growx,aligny top");
		
		JCheckBox chckbxText = new JCheckBox("Text");
		panel_4.add(chckbxText, "cell 1 1,growx,aligny center");
		
		JRadioButton rdbtnAll = new JRadioButton("All");
		panel_4.add(rdbtnAll, "cell 3 1,growx,aligny top");
		
		JCheckBox chckbxCode = new JCheckBox("Code");
		panel_4.add(chckbxCode, "cell 1 2,alignx left,aligny center");
		
		JRadioButton rdbtnApplet = new JRadioButton("Applet");
		panel_4.add(rdbtnApplet, "cell 3 2,growx,aligny top");
	}

}
