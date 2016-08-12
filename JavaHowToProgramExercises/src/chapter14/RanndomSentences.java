// Grzegorz Koñczak, 12.08.2016
// Exercise number 14.5 page 679
// Exercise from Java:How to program 10th edition

package chapter14;

import java.security.SecureRandom;

public class RanndomSentences {

	private static final SecureRandom randomNumbers = new SecureRandom();

	public static void main(String[] args) {

		String[] article = { "the", "a", "one", "some", "any" };
		String[] noun = { "boy", "girl", "dog", "town", "car" };
		String[] verb = { "drove", "jumped", "ran", "walked", "skipped" };
		String[] preposition = { "to", "from", "over", "under", "on" };

		for (int i = 0; i < 20; i++) {
			int randomArticle = randomNumbers.nextInt(article.length);
			int randomNoun = randomNumbers.nextInt(noun.length);
			int randomVerb = randomNumbers.nextInt(verb.length);
			int randomPreposition = randomNumbers.nextInt(preposition.length);
			int randomArticle2 = randomNumbers.nextInt(article.length);
			int randomNoun2 = randomNumbers.nextInt(noun.length);
			
			StringBuilder builder = new StringBuilder();
			builder.append(article[randomArticle])
			.append(" ")
			.append(noun[randomNoun])
			.append(" ")
			.append(verb[randomVerb])
			.append(" ")
			.append(preposition[randomPreposition])
			.append(" ")
			.append(article[randomArticle2])
			.append(" ")
			.append(noun[randomNoun2])
			.append(".");
			
			builder.replace(0, 1, Character.toString(Character.toUpperCase(builder.charAt(0))));
			
			System.out.println(builder.toString());
		}
	}
}
