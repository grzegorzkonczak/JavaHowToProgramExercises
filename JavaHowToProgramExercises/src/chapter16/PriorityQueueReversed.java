// Grzegorz Koñczak, 22.08.2016
// Exercise number 16.21 page 770
// Exercise from Java:How to program 10th edition

package chapter16;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueReversed {
	public static void main(String[] args) {
		// queue of capacity 11
		PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

		// insert elements to queue
		queue.offer(3.2);
		queue.offer(9.8);
		queue.offer(5.4);

		System.out.print("Polling from queue: ");

		// display elements in queue
		while (queue.size() > 0) {
			System.out.printf("%.1f ", queue.peek()); // view top element
			queue.poll(); // remove top element
		}
	}
}
