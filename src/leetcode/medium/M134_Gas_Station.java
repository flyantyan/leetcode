package leetcode.medium;

public class M134_Gas_Station {

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int end = 0;
		int start = gas.length - 1;

		int sum = gas[start] - cost[start];
		while (start > end) {
			if (sum >= 0) {
				sum += (gas[end] - cost[end]);
				end++;
			} else {
				start--;
				sum += (gas[start] - cost[start]);
			}
		}

		if (sum >= 0)
			return start;
		return -1;
	}

	// Time Limit Exceeded
	public int canCompleteCircuit_1(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length)
			return -1;

		int n = gas.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = gas[i];
			if (gas[i] < cost[i]) {
				continue;
			}
			sum -= cost[i];
			for (int j = 1; j <= n; j++) {
				int index = (i + j) % n;
				sum += gas[index];
				sum -= cost[index];
				if (sum < 0) {
					break;
				}
			}
			if (sum > 0)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		new M134_Gas_Station().canCompleteCircuit(new int[] { 1, 2, 3, 3 }, new int[] { 2, 1, 5, 1 });
	}
}
