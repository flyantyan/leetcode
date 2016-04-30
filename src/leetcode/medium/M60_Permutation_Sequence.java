package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M60_Permutation_Sequence {

	
	public String getPermutation1(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }
	
	
	public String getPermutation(int n, int k) {
		List<Integer> nums = new ArrayList<Integer>();
		int count = 1;
		for (int i = 1; i <= n; i++) {
			nums.add(i);
			count *= i;
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;

		k--;
		while (i < n) {
			count /= (n - i);
			int index = k / count;
			k -= index * count;
			i++;

			sb.append(nums.get(index) + "");
			nums.remove(index);
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		new M60_Permutation_Sequence().getPermutation(4, 1);
	}
}
