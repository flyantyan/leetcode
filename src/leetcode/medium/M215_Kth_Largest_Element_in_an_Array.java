package leetcode.medium;

public class M215_Kth_Largest_Element_in_an_Array {

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		int left = 0;
		int right = nums.length - 1;
		k = nums.length - k;
		while (left < right) {
			int index = partition(nums, left, right);
			if (index < k) {
				left = index + 1;
			} else if (index > k) {
				right = index - 1;
			} else {
				break;
			}
		}
		return nums[k];
	}

	private int partition(int[] a, int lo, int hi) {

		int i = lo;
		int j = hi + 1;
		while (true) {
			while (i < hi && less(a[++i], a[lo]))
				;
			while (j > lo && less(a[lo], a[--j]))
				;
			if (i >= j) {
				break;
			}
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private boolean less(int v, int w) {
		return v < w;
	}

	public static void main(String[] args) {
		int i = new M215_Kth_Largest_Element_in_an_Array().findKthLargest(new int[] { 3, 2, 1, 5, 6, 1 }, 2);
		System.out.println(i + "");
	}
}
