package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class M95_Unique_Binary_Search_Trees_II {

	public List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new ArrayList<TreeNode>();
		return generateTrees(1, n);
	}

	
	
	//Recursive solition
	private List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = generateTrees(start, i - 1);
			List<TreeNode> rights = generateTrees(i + 1, end);

			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					result.add(root);
				}
			}
		}

		return result;

	}
}
