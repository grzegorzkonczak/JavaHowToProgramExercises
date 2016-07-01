// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.2 page 232
// Exercise from Java:How to program 10th edition

package chapter5;

import javax.swing.JPanel;
import java.awt.Graphics;

public class BarChartGraphic extends JPanel{

	private int bar1; // user's choice about length of bar
	private int bar2; // user's choice about length of bar
	private int bar3; // user's choice about length of bar
	private int bar4; // user's choice about length of bar
	private int bar5; // user's choice about length of bar
	private int separator = 40; // separates individual bars

	// constructor set's the length
	public BarChartGraphic(int bar1, int bar2, int bar3, int bar4, int bar5) {
		this.bar1 = bar1;
		this.bar2 = bar2;
		this.bar3 = bar3;
		this.bar4 = bar4;
		this.bar5 = bar5;
	}

	public void paintComponent(Graphics g) {
		
		g.fillRect(0, 5, bar1 * 10, 30);
		g.fillRect(0, 5 + separator, bar2 * 10, 30);
		g.fillRect(0, 5 + separator * 2, bar3 * 10, 30);
		g.fillRect(0, 5 + separator * 3, bar4 * 10, 30);
		g.fillRect(0, 5 + separator * 4, bar5 * 10, 30);
	}

}
