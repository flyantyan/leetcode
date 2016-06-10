package leetcode.hard;

import java.util.Stack;

public class H84_Largest_Rectangle_in_Histogram {

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i <= heights.length; i++) {
			int num = (i == heights.length ? 0 : heights[i]);
			while ((!stack.isEmpty()) && heights[stack.peek()] > num) {
				int index = stack.pop();
				int area = heights[index] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
		}
		stack.empty();

		return maxArea;
	}

	// Time limt exceeded
	public int largestRectangleArea_1(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;

		int maxArea = 0;

		for (int i = 0; i < heights.length; i++) {
			int left = i;
			int right = i + 1;
			for (int j = i + 1; j < heights.length; j++) {
				if (heights[j] >= heights[i]) {
					right++;
				} else {
					break;
				}
			}
			for (int j = i - 1; j >= 0; j--) {
				if (heights[j] >= heights[i]) {
					left--;
				} else {
					break;
				}
			}

			maxArea = Math.max(maxArea, (right - left) * heights[i]);
		}

		return maxArea;
	}
}