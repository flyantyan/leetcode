package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class M244_Shortest_Word_Distance_II {

	private HashMap<String, List<Integer>> map = new HashMap<>();

	public M244_Shortest_Word_Distance_II(String[] words) {
        int n = words.length;
        for(int i = 0; i < n; i++){
            if(map.containsKey(words[i]))    map.get(words[i]).add(i);
            else{
                List<Integer> templist = new ArrayList<>();
                templist.add(i);
                map.put(words[i], templist);
            }
        }
    }

	public int shortest(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		int min = Integer.MAX_VALUE;
		int i = 0, j = 0, n1 = list1.size(), n2 = list2.size();
		while (i < n1 && j < n2) {
			min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
			if (list1.get(i) < list2.get(j))
				i++;
			else
				j++;
		}
		return min;
	}
}
