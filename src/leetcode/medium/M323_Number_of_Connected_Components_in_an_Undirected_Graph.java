package leetcode.medium;

public class M323_Number_of_Connected_Components_in_an_Undirected_Graph {

	public int countComponents(int n, int[][] edges) {
		int[] root = new int[n];
		for (int i = 0; i < n; i++)
			root[i] = i;
		for (int[] edge : edges) {
			int root1 = findRoot(root, edge[0]), root2 = findRoot(root, edge[1]);
			// Union
			if (root1 != root2)
				root[root2] = root1;
		}
		// Count components
		int count = 0;
		for (int i = 0; i < n; i++)
			if (root[i] == i)
				count++;
		return count;
	}

	// Find with path compression
	private int findRoot(int[] root, int i) {
		while (root[i] != i) {
			root[i] = root[root[i]];
			i = root[i];
		}
		return i;
	}
}
