package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E246_Strobogrammatic_Number {

	public boolean isStrobogrammatic(String num) {
		Map<Character, Character> map = new HashMap<>();
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		map.put('0', '0');
		for (int i = num.length() - 1; i >= 0; i--) {
			Character c = map.get(num.charAt(i));
			if (c == null || c != num.charAt(num.length() - 1 - i))
				return false;

		}
		return true;
	}
}
