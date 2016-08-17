// Grzegorz Koñczak, 17.08.2016
// Exercise number 14.26 page 683
// Exercise from Java:How to program 10th edition

package chapter14;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CookingWithHealthierIngredients extends JPanel {

	private JTextArea textArea = new JTextArea("Paste recipe hear...");
	private JButton action = new JButton("Replace");
	private LayoutManager layout = new BorderLayout();
	private String[] tokenizedRecipe;
	private List<String> keySentences = new ArrayList<>();
	private List<String> replacements = new ArrayList<>();
	private String[] keyMesurments = { "cup", "teaspoon", "egg" };
	private String[] keyIngredients = { "sour", "milk", "lemon", "sugar", "butter", "flour", "mayonnaise", "oil",
			"bread" };

	public CookingWithHealthierIngredients() {
		this.setLayout(layout);
		this.add(textArea, BorderLayout.CENTER);
		this.add(action, BorderLayout.SOUTH);

		action.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tokenizedRecipe = textArea.getText().split("\\s");
				keySentences = searchForKeySentences(tokenizedRecipe);
				replacements = searchForReplacments(keySentences);
				displayInformations(keySentences, replacements);
				keySentences.removeAll(keySentences);
				replacements.removeAll(replacements);
			}

			private void displayInformations(List<String> keySentences, List<String> replacements) {
				textArea.setText("Warning!\nYou should contact doctor before changing diet!\n");
				for (int i = 0; i < replacements.size(); i++) {
					textArea.append("You can replace " + keySentences.get(i) + " with " + replacements.get(i) + ".\n");
				}

			}

			private List<String> searchForReplacments(List<String> keySentences) {
				for (String string : keySentences) {

					if (keySentences.get(0).equals("nothing")) {
						replacements.add("nothing");
						return replacements;
					}
					String[] words = string.split("\\s");
					String replacement;

					if (words.length == 3) {
						switch (words[2]) {
						case "sour":
							replacement = words[0] + " " + words[1] + " yougurt";
							replacements.add(replacement);
							break;
						case "milk":
							replacement = Double.parseDouble(words[0]) / 2 + " " + words[1] + " of evaporated milk and "
									+ Double.parseDouble(words[0]) / 2 + " " + words[1] + " of water";
							replacements.add(replacement);
							break;
						case "lemon":
							replacement = words[0] + " " + words[1] + " vinegar";
							replacements.add(replacement);
							break;
						case "sugar":
							replacement = Double.parseDouble(words[0]) / 2 + " " + words[1] + " of honey or " + words[0]
									+ " " + words[1] + " of molasses or " + Double.parseDouble(words[0]) / 4 + " "
									+ words[1] + " of agave nectar";
							replacements.add(replacement);
							break;
						case "butter":
							replacement = words[0] + " " + words[1] + " margarine or yougurt";
							replacements.add(replacement);
							break;
						case "flour":
							replacement = words[0] + " " + words[1] + " rye or rice flour";
							replacements.add(replacement);
							break;
						case "mayonnaise":
							replacement = words[0] + " " + words[1] + " cottage cheese or " + Double.parseDouble(words[0]) / 8 + " " + words[1] + " of mayonnaise and "
									+ (Double.parseDouble(words[0]) / 8) * 7 + " " + words[1] + " of yougurt";
							replacements.add(replacement);
							break;
						case "oil":
							replacement = words[0] + " " + words[1] + " applesauce";
							replacements.add(replacement);
							break;
						default:
							break;
						}
					} else {
						switch (words[1]) {
						case "egg":
							replacement = Integer.parseInt(words[0]) * 2 + " " + "egg whites";
							replacements.add(replacement);
							break;
						case "bread":
							replacement = "whole-grain bread";
							replacements.add(replacement);
							break;

						default:
							break;
						}
					}
				}
				return replacements;
			}

			private List<String> searchForKeySentences(String[] tokenizedRecipe) {
				for (int i = 0; i < tokenizedRecipe.length; i++) {
					if (!tokenizedRecipe[i].isEmpty()) {
						if (Character.isDigit(tokenizedRecipe[i].charAt(0))) {
							for (String string : keyMesurments) {
								if (tokenizedRecipe[i + 1].equals(string)) {
									for (String ingredient : keyIngredients) {
										if (!tokenizedRecipe[i + 1].equals("egg")
												&& tokenizedRecipe[i + 2].equals(ingredient)) {
											String sentence = tokenizedRecipe[i] + " " + tokenizedRecipe[i + 1] + " "
													+ tokenizedRecipe[i + 2];
											if (!keySentences.contains(sentence)) {
												keySentences.add(sentence);
											}
										} else if (tokenizedRecipe[i + 1].equals("egg")) {
											String sentence = tokenizedRecipe[i] + " " + tokenizedRecipe[i + 1];
											if (!keySentences.contains(sentence)) {
												keySentences.add(sentence);
											}
										}
									}
								}
							}
						}
						if (tokenizedRecipe[i].equals("bread") && tokenizedRecipe[i - 1].equals("white")) {
							String sentence = tokenizedRecipe[i - 1] + " " + tokenizedRecipe[i];
							if (!keySentences.contains(sentence)) {
								keySentences.add(sentence);
							}
						}
					}
				}
				if (keySentences.isEmpty()) {
					keySentences.add("nothing");
					return keySentences;
				}
				return keySentences;
			}
		});
	}
}
