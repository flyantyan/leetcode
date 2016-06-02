package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class H336_Palindrome_Pairs {

	/**
	 * 利用字典wmap保存单词 -> 下标的键值对
	 * 
	 * 遍历单词列表words，记当前单词为word，下标为idx：
	 * 
	 * 1). 若当前单词word本身为回文，且words中存在空串，则将空串下标bidx与idx加入答案
	 * 
	 * 2). 若当前单词的逆序串在words中，则将逆序串下标ridx与idx加入答案
	 * 
	 * 3). 将当前单词word拆分为左右两半left，right。
	 * 
	 * 3.1) 若left为回文，并且right的逆序串在words中，则将right的逆序串下标rridx与idx加入答案
	 * 
	 * 3.2) 若right为回文，并且left的逆序串在words中，则将left的逆序串下标idx与rlidx加入答案
	 * 
	 * @param words
	 * @return
	 */
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> pairs = new LinkedList<>();
		if (words == null)
			return pairs;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; ++i)
			map.put(words[i], i);
		for (int i = 0; i < words.length; ++i) {
			int l = 0, r = 0;
			while (l <= r) {
				String s = words[i].substring(l, r);
				Integer j = map.get(new StringBuilder(s).reverse().toString());
				if (j != null && i != j
						&& isPalindrom(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l)))
					pairs.add(Arrays.asList(l == 0 ? new Integer[] { i, j } : new Integer[] { j, i }));
				if (r < words[i].length())
					++r;
				else
					++l;
			}
		}
		return pairs;
	}

	// Time Limit Exceeded
	public List<List<Integer>> palindromePairs_1(String[] words) {
		List<List<Integer>> result = new ArrayList<>();
		if (words == null)
			return result;

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (i != j && isPalindrom(words[i] + words[j])) {
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(j);
					result.add(temp);
				}
			}
		}

		return result;
	}

	private boolean isPalindrom(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		new H336_Palindrome_Pairs().palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" });
	}
}
