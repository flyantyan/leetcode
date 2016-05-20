package leetcode.easy;

import java.util.HashSet;

public class M349_Intersection_of_Two_Arrays {

	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> result = new HashSet<>();
		for (int temp : nums1) {
			set1.add(temp);
		}
		for (int num : nums2) {
			if (set1.contains(num)) {
				result.add(num);
			}
		}
		int[] r = new int[result.size()];
		int i = 0;
		for (int num : result) {
			r[i++] = num;
		}

		return r;
	}
}
