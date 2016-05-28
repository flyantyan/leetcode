package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

public class M199_Binary_Tree_Right_Side_View {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return result;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if (i == 0)
					result.add(temp.val);
				if (temp.right != null)
					queue.offer(temp.right);
				if (temp.left != null)
					queue.offer(temp.left);
			}
		}

		return result;

	}
}
