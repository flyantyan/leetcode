package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

public class E107_Binary_Tree_Level_Order_Traversal_II {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				if (queue.peek().left != null)
					queue.add(queue.peek().left);
				if (queue.peek().right != null)
					queue.add(queue.peek().right);
				temp.add(queue.poll().val);
			}
			result.add(0, temp);
		}
		return result;
	}
}
