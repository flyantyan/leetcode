package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E205_Isomorphic_Strings {

	public boolean isIsomorphic(String s, String t) {
		if (s == null)
			return t == null;
		Map<Character, Character> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char s1 = s.charAt(i);
			char t1 = t.charAt(i);
			if (map.containsKey(s1)) {
				if (map.get(s1) != t1)
					return false;
			} else {
				if (set.contains(t1))
					return false;
				map.put(s1, t1);
				set.add(t1);
			}
		} 

		return true;
	}
	
	public static void main(String[] args) {
		boolean flag = new E205_Isomorphic_Strings().isIsomorphic("aa", "ab");
		System.out.println(flag);
	}
	
}
