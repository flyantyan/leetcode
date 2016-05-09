package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

public class M103_Binary_Tree_Zigzag_Level_Order_Traversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				if (queue.peek().left != null)
					queue.add(queue.peek().left);
				if (queue.peek().right != null)
					queue.add(queue.peek().right);

				if (level % 2 == 0)
					temp.add(0, queue.poll().val);
				else
					temp.add(queue.poll().val);
			}
			result.add(temp);
			level++;
		}
		return result;
	}
}
