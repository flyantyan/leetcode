package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M89_Gray_Code {

	// Get information from http://en.wikipedia.org/wiki/Gray_code
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 1 << n; i++) {
			result.add((i >> 1) ^ i);
		}

		return result;
	}
}
