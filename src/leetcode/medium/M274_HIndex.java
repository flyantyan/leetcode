package leetcode.medium;

import java.util.Arrays;

public class M274_HIndex {

	public int hIndex(int[] citations) {
		if (citations == null)
			return 0;
		Arrays.sort(citations);
		int count = 0;
		for (int i = citations.length - 1; i >= 0; i--) {

			if (citations[i] <= count) {
				return count;
			}
			count++;
		}
		return citations.length;
	}
}
