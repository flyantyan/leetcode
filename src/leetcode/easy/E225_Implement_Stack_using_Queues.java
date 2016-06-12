package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class E225_Implement_Stack_using_Queues {

	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();

	// Push element x onto stack.
	public void push(int x) {
		q1.add(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		while (q1.size() > 1) {
			q2.add(q1.poll());
		}
		q1.poll();
		while (!q2.isEmpty()) {
			q1.add(q2.poll());
		}
	}

	// Get the top element.
	public int top() {
		while (q1.size() > 1) {
			q2.add(q1.poll());
		}
		int num = q1.poll();
		while (!q2.isEmpty()) {
			q1.add(q2.poll());
		}
		q1.add(num);
		return num;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		if (q1.isEmpty()) {
			return q2.isEmpty();
		}
		return false;
	}
}
