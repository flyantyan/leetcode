package leetcode.medium;

public class M11_Container_With_Most_Water {

	/**
	 * http://images.cnitblog.com/blog/545749/201307/27140406-419b7981438f4738b3f8d629678d0a45.png
	 * 
	 */
	public int maxArea(int[] height) {
		if (height.length < 2)
			return 0;

		int start = 0;
		int end = height.length - 1;
		int max = 0;
		while (start < end) {
			int area = Math.min(height[start], height[end]) * (end - start);
			if (area > max) {
				max = area;
			}
			if (height[start] > height[end]) {
				end--;
			} else {
				start++;
			}
		}

		return max;
	}
}
