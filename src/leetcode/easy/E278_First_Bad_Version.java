package leetcode.easy;

public class E278_First_Bad_Version extends VersionControl {

	public int firstBadVersion(int n) {
		int low = 1, high = n;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isBadVersion(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

}

class VersionControl {
	boolean isBadVersion(int version) {
		return true ;
	}
}