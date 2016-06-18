package leetcode.medium;

public class M294_Flip_Game_II {

	public boolean canWin(String s) {
		return canWin(s.toCharArray());
	}

	private boolean canWin(char[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == '+' && arr[i + 1] == '+') {
				arr[i] = '-';
				arr[i + 1] = '-';
				boolean win = !canWin(arr);
				arr[i] = '+';
				arr[i + 1] = '+';
				if (win)
					return true;
			}
		}
		return false;
	}
}
