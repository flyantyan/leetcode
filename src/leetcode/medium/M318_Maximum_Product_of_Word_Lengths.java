package leetcode.medium;

public class M318_Maximum_Product_of_Word_Lengths {

	public int maxProduct(String[] words) {
		if (words == null || words.length == 0)
			return 0;

		int nums[] = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			String temp = words[i];
			for (int j = 0; j < temp.length(); j++) {
				nums[i] |= 1 << (temp.charAt(j) - 'a');
			}
		}

		int max = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((nums[i] & nums[j]) == 0 && words[i].length() * words[j].length() > max) {
					max = words[i].length() * words[j].length();
				}
			}
		}

		return max;
	}
}
