package leetcode.medium;

public class M64_Minimum_Path_Sum {
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int column = grid[0].length;

		int sum[] = new int[column];
		sum[0] = grid[0][0];
		for (int i = 1; i < column; i++) {
			sum[i] = sum[i - 1] + grid[0][i];
		}

		for (int i = 1; i < row; i++) {
			sum[0] += grid[i][0];
			for (int j = 1; j < column; j++) {
				sum[j] = Math.min(sum[j], sum[j-1] ) + grid[i][j];
			}
		}

		return sum[column - 1];
	}
	
	public static void main(String[] args) {
		new M64_Minimum_Path_Sum().minPathSum(new int[][]{{0,0},{0,0}});
	}
}
