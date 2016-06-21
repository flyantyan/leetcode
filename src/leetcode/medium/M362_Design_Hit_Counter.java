package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class M362_Design_Hit_Counter {
	Queue<Integer> q = null;

	/** Initialize your data structure here. */
	public M362_Design_Hit_Counter() {
		q = new LinkedList<Integer>();
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		q.offer(timestamp);
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		while (!q.isEmpty() && timestamp - q.peek() >= 300) {
			q.poll();
		}
		return q.size();
	}
}
