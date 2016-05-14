package leetcode.easy;

import java.util.Stack;

public class E155_Min_Stack {

	private Stack<Integer> nums;
	private Stack<Integer> mins;

	/** initialize your data structure here. */
    public E155_Min_Stack() {
        nums = new Stack<>();
        mins = new Stack<>();
    }

	public void push(int x) {
		nums.push(x);
		if (mins.isEmpty()) {
			mins.push(x);
		} else {
			mins.push(Math.min(mins.peek(), x));
		}
	}

	public void pop() {
		nums.pop();
		mins.pop();
	}

	public int top() {
		return nums.peek();
	}

	public int getMin() {
		return mins.peek();
	}
}
