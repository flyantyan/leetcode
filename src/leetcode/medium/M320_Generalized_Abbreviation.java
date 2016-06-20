package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M320_Generalized_Abbreviation {

	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<String>();
		int len = word.length();
		res.add(len == 0 ? "" : String.valueOf(len));
		for (int i = 0; i < len; i++)
			for (String right : generateAbbreviations(word.substring(i + 1))) {
				String leftNum = i > 0 ? String.valueOf(i) : "";
				res.add(leftNum + word.substring(i, i + 1) + right);
			}
		return res;
	}
}
