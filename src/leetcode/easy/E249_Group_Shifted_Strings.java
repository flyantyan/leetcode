package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E249_Group_Shifted_Strings {

	public List<List<String>> groupStrings(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String key = "";
			char first = str.charAt(0);
			for (char c : str.toCharArray())
				key += (c - first < 0 ? c - first + 26 : c - first) + ",";
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(str);
		}
		for (String key : map.keySet())
			Collections.sort(map.get(key));
		return new ArrayList<List<String>>(map.values());
	}
}
