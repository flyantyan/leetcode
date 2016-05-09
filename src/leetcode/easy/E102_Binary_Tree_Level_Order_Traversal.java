package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

public class E102_Binary_Tree_Level_Order_Traversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result ;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root) ;
		
		while(!queue.isEmpty()){
			int levelNum = queue.size() ;
			List<Integer> temp = new ArrayList<>();
			
			for(int i = 0 ; i < levelNum ; i ++){
				if(queue.peek().left != null)
					queue.add(queue.peek().left);
				if(queue.peek().right != null)
					queue.add(queue.peek().right);
				temp.add(queue.poll().val);
			}
			result.add(temp);
		}
		return result ;
	}
}
