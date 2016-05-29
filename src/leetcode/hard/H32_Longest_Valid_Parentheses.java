package leetcode.hard;

import java.util.Stack;

public class H32_Longest_Valid_Parentheses {
	//DP
	public int longestValidParentheses(String s) {
		int[] dp = new int[s.length()];
		int result = 0;
		int leftCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftCount++;
			} else if (leftCount > 0) {
				dp[i] = dp[i - 1] + 2;
				dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
				result = Math.max(result, dp[i]);
				leftCount--;
			}
		}
		return result;
	}

	public int longestValidParentheses_2(String s) {
		if (s == null || s.trim().length() == 0)
			return 0;

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push(i);
			else if ((!stack.isEmpty()) && s.charAt(stack.peek()) == '(')
				stack.pop();
			else
				stack.push(i);
		}

		int result = 0;
		if (stack.isEmpty())
			result = s.length();
		else {
			if (stack.size() == 1)
				return s.length() - 1;
			int index1 = s.length();
			int index2 = s.length();
			while (!stack.isEmpty()) {
				index2 = stack.pop();

				result = Math.max(result, index1 - index2 - 1);
				index1 = index2;
			}
		}
		return result;

	}

	// Time Limit Exceeded
	public int longestValidParentheses_1(String s) {
		if (s == null || s.trim().length() == 0)
			return 0;

		int max = 0;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')')
				continue;
			int j = i;
			max = 0;
			Stack<Character> stack = new Stack<>();
			stack.push(s.charAt(j++));
			while (!stack.isEmpty() && j < s.length()) {
				if (stack.peek() == '(' && s.charAt(j) == ')') {
					j++;
					stack.pop();
					max += 2;
				} else if (s.charAt(j) == '(') {
					stack.push('(');
					j++;
				}
			}
			result = Math.max(result, max);
		}

		return result;
	}
}
