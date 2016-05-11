package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M119_Pascals_Triangle_II {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		for (int i = 1; i < rowIndex+1; i++) {
			for (int j = i - 1; j >= 1; j--) {
				result.set(j, result.get(j - 1) + result.get(j));
			}

			result.add(1);
		}

		return result;
	}
	
	public static void main(String[] args) {
		new M119_Pascals_Triangle_II().getRow(3);
	}
}
