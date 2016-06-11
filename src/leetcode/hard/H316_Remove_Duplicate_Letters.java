package leetcode.hard;

import java.util.Stack;

public class H316_Remove_Duplicate_Letters {

	public String removeDuplicateLetters(String s) {
		if (s == null || s.trim().length() == 0)
			return s;
		char[] arr = s.toCharArray();

		int[] num = new int[26];

		for (int i = 0; i < arr.length; i++) {
			num[arr[i] - 'a']++;
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty()) {
				stack.push(arr[i] - 'a');
				num[arr[i] - 'a']--;
			} else {
				if (stack.contains(arr[i] - 'a')) {
					num[arr[i] - 'a']--;
				} else {
					while (!stack.isEmpty() && stack.peek() > (arr[i] - 'a') && num[stack.peek()] > 0) {
						stack.pop();
					}
					stack.push(arr[i] - 'a');
					num[arr[i] - 'a']--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append((char) (stack.pop() + 'a'));
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String s = new H316_Remove_Duplicate_Letters().removeDuplicateLetters("bcab");
		System.out.println(s);
	}
}
