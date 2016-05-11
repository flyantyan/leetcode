package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class E118_Pascals_Triangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i || i == 0)
					row.add(1);
				else
					row.add(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
			}
			result.add(row);
		}

		return result;
	}
	
	public static void main(String[] args) {
		new E118_Pascals_Triangle().generate(3);
	}
}
