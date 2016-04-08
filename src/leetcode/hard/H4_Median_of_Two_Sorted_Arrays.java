package leetcode.hard;

import java.util.Arrays;

public class H4_Median_of_Two_Sorted_Arrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length + nums2.length];
		int i = 0, j = 0;
		while (nums1.length > 0 && i < nums1.length) {
			result[j++] = nums1[i++];
		}
		i = 0;
		while (nums2.length > 0 && i < nums2.length) {
			result[j++] = nums2[i++];
		}

		Arrays.sort(result);

		return result.length % 2 == 0 ? (result[result.length / 2] + result[result.length / 2 - 1]) / 2.0
				: result[result.length / 2];
	}
}
