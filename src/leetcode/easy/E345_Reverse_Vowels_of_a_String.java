package leetcode.easy;

public class E345_Reverse_Vowels_of_a_String {

	public String reverseVowels(String s) {
		if (s == null || s.trim().length() == 0)
			return s;
		int left = 0;
		int right = s.length() - 1;
		char[] array = s.toCharArray();
		while (left < right) {
			if (isVowel(array[left]) && isVowel(array[right])) {
				// swap
				char temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			} else {
				if (!isVowel(array[left])) {
					left++;
				}
				if (!isVowel(array[right])) {
					right--;
				}
			}
		}

		return new String(array);
	}

	private boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U')
			return true;
		return false;
	}
}
