package leetcode.medium;

public class M63_Unique_Paths_II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[] path = new int[obstacleGrid[0].length];
		path[0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1)
					path[j] = 0;
				else if (j > 0)
					path[j] += path[j - 1];
			}
		}
		return path[path.length - 1];

	}
}
