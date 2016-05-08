package leetcode.medium;

public class M96_Unique_Binary_Search_Trees {

	/**
	 * 
	 * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
	 * 
	 * In fact G[n] has a direct formula : G[n] = C(n, 2n) / (n + 1), where C(n, 2n) is (2n)! / (n! * n!)
	 * 
	 * https://en.wikipedia.org/wiki/Catalan_number
	 * 
	 */
	public int numTrees(int n) {
		int result[] = new int[n + 1];

		result[0] = 1;
		result[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				result[i] += result[j - 1] * result[i - j];
			}
		}

		return result[n];
	}
}
