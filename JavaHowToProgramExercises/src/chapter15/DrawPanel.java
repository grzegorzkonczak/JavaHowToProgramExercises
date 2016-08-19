// Grzegorz Koñczak, 19.08.2016
// Exercise number 15.9 page 725
// Exercise from Java:How to program 10th edition

package chapter15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	// Initializing members of class
	private MyShape[] shapes;
	private int shapeCount;
	private int shapeType;
	private MyShape currentShape;
	private Color currentColor;
	private boolean filledShape;
	private JLabel statusLabel;
	private ObjectOutputStream output;
	private ObjectInputStream input;

	/**
	 * Create the panel.
	 */
	public DrawPanel(JLabel label) {
		statusLabel = label;
		shapes = new MyShape[100];
		shapeCount = 0;
		shapeType = 0;
		currentShape = null;
		currentColor = Color.BLACK;
		setBackground(Color.WHITE);
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}

	// Set methods for drawing
	public void setShapeType(int shapeType) {
		this.shapeType = shapeType;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	public void setFilledShape(boolean filledShape) {
		this.filledShape = filledShape;
	}

	// Clearing methods removing last or all shapes
	public void clearLastShape() {
		if (shapeCount > 0)
			shapeCount--;
		repaint();
	}

	public void clearDrawing() {
		shapeCount = 0;
		repaint();
	}

	// Saving drawing as serialized file for shapes array
	public void saveDrawing() {
		// Create and show to user file chooser menu
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showSaveDialog(this);
		
		// Open file if not canceled
		try {
			if (result != JFileChooser.CANCEL_OPTION) {
				output = new ObjectOutputStream(Files.newOutputStream(fileChooser.getSelectedFile().toPath()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// write object array of shapes to file
		try {
			if (result != JFileChooser.CANCEL_OPTION) {
				output.writeObject(shapes);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// close file if it was opened
		try {
			if (output != null) {
				output.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Loading drawing as serialized file for shapes array
	public void loadDrawing() {
		// Create and show to user file chooser menu
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);

		// Open file if not canceled
		try {
			if (result != JFileChooser.CANCEL_OPTION) {
				input = new ObjectInputStream(Files.newInputStream(fileChooser.getSelectedFile().toPath()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Load array from file and update shapeCount variable to proper number
		// (number of non null positions in array)
		try {
			if (result != JFileChooser.CANCEL_OPTION) {
				shapes = (MyShape[]) input.readObject();
				shapeCount = 0;
				for (MyShape myShape : shapes) {
					if (myShape != null){
						shapeCount++;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Close file if it was opened
		try {
			if (input != null) {
				input.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Paint component redraws all shapes that were drawn earlier and current
	// shape
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < shapeCount; i++) {
			shapes[i].draw(g);
		}
		if (currentShape != null) {
			currentShape.draw(g);
		}
	}

	// Mouse handler for drawing shapes
	private class MouseHandler extends MouseAdapter implements MouseMotionListener {

		// Start to draw shape
		@Override
		public void mousePressed(MouseEvent e) {
			if (shapeType == 0) {
				currentShape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(), currentColor);
			} else if (shapeType == 1) {
				currentShape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);
			} else if (shapeType == 2) {
				currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);
			}

		}

		// End drawing shape
		@Override
		public void mouseReleased(MouseEvent e) {
			currentShape.setX2(e.getX());
			currentShape.setY2(e.getY());
			shapes[shapeCount] = currentShape;
			shapeCount++;
			currentShape = null;
			repaint();
		}

		// Update shape as it is being drawn
		@Override
		public void mouseDragged(MouseEvent e) {
			currentShape.setX2(e.getX());
			currentShape.setY2(e.getY());
			repaint();
			statusLabel.setText(String.format("%d: %d:", e.getX(), e.getY()));

		}

		// Update mouse coordinates in label
		@Override
		public void mouseMoved(MouseEvent e) {
			statusLabel.setText(String.format("%d: %d:", e.getX(), e.getY()));

		}

	}
}
