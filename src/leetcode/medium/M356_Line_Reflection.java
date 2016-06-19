package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class M356_Line_Reflection {

	int mid = 0;

	public boolean isReflected(int[][] points) {
		if (points.length <= 1)
			return true;
		int min = points[0][0];
		int max = points[0][0];
		for (int[] p : points) {
			min = Math.min(min, p[0]);
			max = Math.max(max, p[0]);
		}
		mid = (min + max) / 2;

		Arrays.sort(points, new myCompare());

		int left = 0, right = points.length - 1;
		while (left <= right) {
			if ((points[left][0] - min) != (max - points[right][0]))
				return false;
			if (points[left][0] == points[right][0])
				return true;
			if (points[left][1] != points[right][1])
				return false;
			++left;
			--right;
		}
		return true;
	}

	public class myCompare implements Comparator<int[]> {
		@Override
		public int compare(int[] p1, int[] p2) {
			if (p1[0] != p2[0])
				return Integer.compare(p1[0], p2[0]);
			if (p1[0] <= mid)
				return Integer.compare(p1[1], p2[1]);
			return Integer.compare(p2[1], p1[1]);
		}
	}
}
