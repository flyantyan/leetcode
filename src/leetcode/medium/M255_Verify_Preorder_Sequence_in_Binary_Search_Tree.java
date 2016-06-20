package leetcode.medium;

public class M255_Verify_Preorder_Sequence_in_Binary_Search_Tree {

	public boolean verifyPreorder(int[] preorder) {
		if (preorder == null)
			return true;

		return isValid(preorder, 0, preorder.length - 1);
	}

	private boolean isValid(int[] preorder, int start, int end) {
		if (start >= end)
			return true;

		int num = preorder[start];
		int bigger = -1;
		for (int i = start + 1; i <= end; i++) {
			if (bigger == -1 && preorder[i] > num)
				bigger = i;
			if (bigger != -1 && preorder[i] < num)
				return false;
		}

		if (bigger == -1)
			return isValid(preorder, start + 1, end);
		else
			return isValid(preorder, start + 1, bigger - 1) && isValid(preorder, bigger, end);
	}
}
