package leetcode.hard;

import java.util.LinkedList;

public class H239_Sliding_Window_Maximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0)
			return new int[] {};

		int[] result = new int[nums.length - k + 1];
		LinkedList<Integer> deque = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
			// Remove First
			if (i - deque.getFirst() == k) {
				deque.removeFirst();
			}
			if (i + 1 >= k) {
				result[i - k + 1] = nums[deque.getFirst()];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		new H239_Sliding_Window_Maximum().maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
	}
}
