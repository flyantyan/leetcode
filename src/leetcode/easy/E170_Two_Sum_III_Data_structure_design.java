package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E170_Two_Sum_III_Data_structure_design {

	private Map<Integer, Integer> map = new HashMap<>();

	// Add the number to an internal data structure.
	public void add(int number) {
		if (map.containsKey(number))
			map.put(number, map.get(number) + 1);
		else
			map.put(number, 1);
	}

	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		for (int num : map.keySet()) {
			if (map.containsKey(value - num))
				if (value - num != num || (value - num == num && map.get(value - num) >= 2))
					return true;
		}
		return false;
	}
}
