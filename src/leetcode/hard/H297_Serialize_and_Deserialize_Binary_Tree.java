package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.TreeNode;

public class H297_Serialize_and_Deserialize_Binary_Tree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		encode(root, sb);
		return sb.toString();
	}

	private void encode(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#").append(",");
			return;
		}
		sb.append(root.val + ",");
		encode(root.left, sb);
		encode(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
		return decode(list);
	}

	private TreeNode decode(List<String> data) {
		String val = data.get(0);
		data.remove(0);
		if (val.equals("#"))
			return null;

		TreeNode root = new TreeNode(Integer.valueOf(val));
		root.left = decode(data);
		root.right = decode(data);
		return root;
	}
}
