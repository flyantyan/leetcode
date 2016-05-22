package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.hrwhisper.me/leetcode-count-of-range-sum/
public class H315_Count_of_Smaller_Numbers_After_Self {

	class NumberIndex {
		public int val;
		public int index;

		public NumberIndex(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		NumberIndex numsIndex[] = new NumberIndex[nums.length];
		for (int i = 0; i < nums.length; i++) {
			numsIndex[i] = new NumberIndex(nums[i], i);
		}
		Integer smaller[] = new Integer[nums.length];
		Arrays.fill(smaller, 0);
		numsIndex = mergeSort(numsIndex, smaller);
		List<Integer> result = new ArrayList<>();
		result.addAll(Arrays.asList(smaller));
		return result;
	}

	private NumberIndex[] mergeSort(NumberIndex[] nums, Integer[] small) {
		int mid = nums.length / 2;
		if (mid <= 0)
			return nums;
		NumberIndex[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid), small);
		NumberIndex[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length), small);

		int i = 0, j = 0;
		while (i < left.length || j < right.length) {
			if (j == right.length || i < left.length && left[i].val <= right[j].val) {
				nums[i + j] = left[i];
				small[left[i].index] += j;
				i++;
			} else {
				nums[i + j] = right[j];
				j++;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		new H315_Count_of_Smaller_Numbers_After_Self().countSmaller(new int[] { 5, 2, 6, 1 });
	}
}
