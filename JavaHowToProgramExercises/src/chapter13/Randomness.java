// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.10 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class Randomness extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		SecureRandom randomNumbers = new SecureRandom();
		Color[] colors = { Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.CYAN, Color.MAGENTA,
				Color.DARK_GRAY };
		String[] fontNames = { Font.SANS_SERIF, Font.DIALOG, Font.SERIF, Font.MONOSPACED };

		for (int i = 0; i < 300; i++) {
			int randomColor = randomNumbers.nextInt(colors.length);
			g.setColor(colors[randomColor]);

			int randomBold = randomNumbers.nextInt(1);
			int randomItalic = randomNumbers.nextInt(1);
			int randomFont = randomNumbers.nextInt(fontNames.length);
			int randomFontSize = 6 + randomNumbers.nextInt(40);

			Font font;
			if (randomBold == 1 && randomItalic == 1) {
				font = new Font(fontNames[randomFont], Font.BOLD + Font.ITALIC, randomFontSize);
			} else if (randomBold == 1) {
				font = new Font(fontNames[randomFont], Font.BOLD, randomFontSize);
			} else if (randomItalic == 1) {
				font = new Font(fontNames[randomFont], Font.ITALIC, randomFontSize);
			} else {
				font = new Font(fontNames[randomFont], Font.PLAIN, randomFontSize);
			}
			
			g.setFont(font);
			
			int randomX = randomNumbers.nextInt(600);
			int randomY = randomNumbers.nextInt(600);
			g.drawString("CheckRise", randomX, randomY);
		}
	}
}
