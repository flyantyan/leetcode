package leetcode.easy;

public class E88_Merge_Sorted_Array {

	public void merge(int[] A, int m, int[] B, int n) {
		// while(n > 0){
		// nums1[m+n-1] = (nums1[m-1] > nums2[n-1])? nums1[--m] : nums2[--n];
		// }

		while (n > 0)
			A[m + n - 1] = (m == 0 || B[n - 1] > A[m - 1]) ? B[--n] : A[--m];

	}
}
