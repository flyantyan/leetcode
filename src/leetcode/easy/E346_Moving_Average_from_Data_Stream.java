package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class E346_Moving_Average_from_Data_Stream {

	private List<Integer> nums = new ArrayList<>();
	int size = 0;
	int index = 0;

	/** Initialize your data structure here. */
	public E346_Moving_Average_from_Data_Stream(int size) {
		this.size = size;
	}

	public double next(int val) {
		nums.add(val);

		int sum = 0;
		int count = 0;
		for (int i = nums.size() - 1; i >= nums.size() - size && i >= 0; i--) {
			sum += nums.get(i);
			count++;
		}

		return (double) sum / count;
	}
}
