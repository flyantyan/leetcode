package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E266_Palindrome_Permutation {

	public boolean canPermutePalindrome(String s) {
		if (s == null || s.trim().length() == 0)
			return false;

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		boolean flag = false;

		for (Character c : map.keySet()) {
			if(s.length() % 2 == 0 && map.get(c) %2 != 0)
				return false ;
			if(flag && map.get(c) %2!=0)
				return false ;
			if(s.length() %2 != 0 && map.get(c) %2 != 0 ){
				flag = true ;
				continue ;
			}
			
		}
		
		return true ;
	}
	
	public static void main(String[] args) {
		new E266_Palindrome_Permutation().canPermutePalindrome("abc");
	}
}
