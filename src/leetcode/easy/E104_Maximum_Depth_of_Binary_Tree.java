package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode;

public class E104_Maximum_Depth_of_Binary_Tree {

	// Just like Level Order Traversal
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int count = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int levelNum = queue.size();

			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.add(queue.peek().left);
				if (queue.peek().right != null)
					queue.add(queue.peek().right);
				queue.poll();
			}
			count++;
		}
		return count;
	}

	public int maxDepth_Recursive(TreeNode root) {
		if (root == null)
			return 0;

		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
