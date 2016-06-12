package leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeLinkNode;

public class H117_Populating_Next_Right_Pointers_in_Each_Node_II {

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			TreeLinkNode current = null;
			current = queue.poll();
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
			for (int i = 1; i < levelSize; i++) {
				if (queue.peek().left != null)
					queue.add(queue.peek().left);
				if (queue.peek().right != null)
					queue.add(queue.peek().right);
				current.next = queue.peek();
				current = queue.poll();
			}
			// current.next = null ;
		}
	}
}
