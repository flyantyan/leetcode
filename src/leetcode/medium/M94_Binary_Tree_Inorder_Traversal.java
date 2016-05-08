package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;


public class M94_Binary_Tree_Inorder_Traversal {
	
	//Iterative solution
	 public List<Integer> inorderTraversal_1(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        
	        Stack<TreeNode> stack = new Stack<TreeNode>() ;
	        
	        TreeNode current = root;
	        while(current != null || !stack.empty()){
	            while(current != null){
	                stack.push(current);
	                current = current.left ;
	            }
	            current = stack.pop() ;
	            result.add(current.val) ;
	            current = current.right ;
	        }
	        return result ;
	    }

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inorderTraversal(root, result);
		return result;
	}

	//Recursive solution
	private void inorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null)
			return;

		inorderTraversal(root.left, result);
		result.add(root.val);
		inorderTraversal(root.right, result);
	}
}
