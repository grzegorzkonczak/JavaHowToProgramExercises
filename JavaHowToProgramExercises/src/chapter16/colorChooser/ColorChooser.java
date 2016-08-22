// Grzegorz Koñczak, 22.08.2016
// Exercise number 16.15 page 769
// Exercise from Java:How to program 10th edition

package chapter16.colorChooser;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ColorChooser {

	private Map<String, Color> colors = new HashMap<>();
	
	public ColorChooser(){
		colors.put("Black", Color.BLACK);
		colors.put("Blue", Color.BLUE);
		colors.put("Cyan", Color.CYAN);
		colors.put("Dark Gray", Color.DARK_GRAY);
		colors.put("Gray", Color.GRAY);
		colors.put("Green", Color.GREEN);
		colors.put("Light Gray", Color.LIGHT_GRAY);
		colors.put("Magenta", Color.MAGENTA);
		colors.put("Orange", Color.ORANGE);
		colors.put("Pink", Color.PINK);
		colors.put("Red", Color.RED);
		colors.put("White", Color.WHITE);
		colors.put("Yellow", Color.YELLOW);
	}
	
	public Color getColor(String color){
		Color returnColor = colors.get(color);
		return returnColor;
	}
	
	public String[] getColorNames(){
		Set<String> colorSet = colors.keySet();
		TreeSet<String> sortedColors = new TreeSet<>(colorSet);
		String[] colorNames = sortedColors.toArray(new String[sortedColors.size()]);
		return colorNames;
	}
	
}
