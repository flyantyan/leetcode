package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M49_Group_Anagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		Arrays.sort(strs);
		Map<String, List<String>> t = new HashMap<>();
		for (String str : strs) {
			char temp[] = str.toCharArray();
			Arrays.sort(temp);
			String  key = Arrays.toString(temp);
			if (t.containsKey(key)) {
				List<String> curr = t.get(key);
				curr.add(str);
				t.put(key, curr);
			} else {
				List<String> curr = new ArrayList<>();
				curr.add(str);
				t.put(key, curr);
			}
		}

		return new ArrayList<>(t.values());
	}

	public static void main(String[] args) {
		new M49_Group_Anagrams().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
	}
}
