package leetcode.medium;

import leetcode.TreeNode;

public class M98_Validate_Binary_Search_Tree {

	////[10,5,15,null,null,6,20]
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
		if (root == null)
			return true;
		if (root.val >= maxVal || root.val <= minVal)
			return false;
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}
	
	
	
	private TreeNode prev = null;

    public boolean isValidBST_2(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)) return false;
        if(prev != null && root.val <= prev.val) return false;
        prev = root;
        return isValidBST(root.right);
    }
}
