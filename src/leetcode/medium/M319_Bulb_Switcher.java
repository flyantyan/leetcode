package leetcode.medium;

public class M319_Bulb_Switcher {

	public int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}
 
	// Time limited exceeding
	public int bulbSwitch_1(int n) {
		if (n <= 0)
			return 0;
		boolean[] bulbs = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			bulbs[i] = true;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = i; j <= n; j += i) {
				bulbs[j] = !bulbs[j];
			}
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (bulbs[i])
				count++;
		}
		return count;
	}
}
