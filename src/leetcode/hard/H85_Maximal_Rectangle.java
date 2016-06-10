package leetcode.hard;

import java.util.Arrays;
import java.util.Stack;

public class H85_Maximal_Rectangle {

	public int maximalRectangle_1(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int[] height = new int[matrix[0].length];
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
				} else {
					height[j] = 0;
				}
			}

			stack = new Stack<>();
			for (int j = 0; j <= height.length; j++) {
				int num = (j == height.length ? 0 : height[j]);
				while ((!stack.isEmpty()) && num < height[stack.peek()]) {
					int area = height[stack.pop()] * (stack.isEmpty() ? j : j - stack.peek() - 1);
					maxArea = Math.max(area, maxArea);
				}
				stack.push(j);
			}
		}

		return maxArea;
	}

	/**
	 * <p>
	 * height
	 * </p>
	 * counts the number of successive '1's above (plus the current one). The
	 * value of left & right means the boundaries of the rectangle which
	 * contains the current point with a height of value height.
	 * 
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int[] height = new int[matrix[0].length];
		int[] left = new int[matrix[0].length];
		int[] right = new int[matrix[0].length];
		Arrays.fill(height, 0);
		Arrays.fill(left, 0);
		Arrays.fill(right, matrix[0].length);
		int maxArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			int currentLeft = 0;
			int currentRight = matrix[0].length;
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
					left[j] = Math.max(currentLeft, left[j]);
				} else {
					height[j] = 0;
					left[j] = 0;
					currentLeft = j + 1;
				}
			}

			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(currentRight, right[j]);
				} else {
					currentRight = j;
					right[j] = matrix[0].length;
				}
				maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		// maximalRectangle(new char[][] { { '0', '1' } });
	}
}
