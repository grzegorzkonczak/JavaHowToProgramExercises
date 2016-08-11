// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.17 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UserCircle extends JPanel{

	private String radiusAsString = JOptionPane.showInputDialog("Enter radius as floting point number.");
	private Double radius = Double.parseDouble(radiusAsString);
	private int xPoint = Integer.parseInt(JOptionPane.showInputDialog("Enter coordinate x."));
	private int yPoint = Integer.parseInt(JOptionPane.showInputDialog("Enter coordinate y."));
	
	private Double diameter = calculateDiameter();
	private Double circumference = calculateCircumference();
	private Double area = caluclateArea();
	
	private String diameterAsString = String.format("Diameter: %.2f", diameter);
	private String circumferenceAsString = String.format("Circumference: %.2f", circumference );
	private String areaAsString = String.format("Area: %.2f", area);
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);


		FontMetrics metrics = g.getFontMetrics(g.getFont());
				
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.draw(new Ellipse2D.Double(xPoint, yPoint, diameter, diameter));
		
		g.drawString(diameterAsString, 1, getHeight() - (metrics.getHeight() * 2) - metrics.getDescent());
		g.drawString(circumferenceAsString, 1, getHeight() - (metrics.getHeight()) - metrics.getDescent());
		g.drawString(areaAsString, 1, getHeight() - metrics.getDescent());
	}

	private Double caluclateArea() {
		Double area = Math.PI * (Math.pow(radius, 2));
		return area;
	}

	private Double calculateCircumference() {
		Double circumference = 2 * Math.PI * radius;
		return circumference;
	}

	private Double calculateDiameter() {
		Double diameter = radius * 2;
		return diameter;
	}
}
