package leetcode.medium;

public class M245_Shortest_Word_Distance_III {

	public int shortestWordDistance(String[] words, String word1, String word2) {
		if (words == null || words.length < 2)
			return 0;

		int p1 = -1;
		int p2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				p1 = i;
			}
			if (words[i].equals(word2)) {
				if (word1.equals(word2)) {
					p1 = p2;
				}
				p2 = i;
			}
			if (p1 != -1 && p2 != -1) {
				min = Math.min(min, Math.abs(p1 - p2));
			}
		}
		return min;
	}
}
