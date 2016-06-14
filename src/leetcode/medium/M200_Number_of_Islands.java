package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class M200_Number_of_Islands {

	public int numIslands(char[][] board) {
		if (board == null || board.length == 0)
			return 0;
		int rows = board.length, columns = board[0].length;
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int count = 0;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++) {
				if (board[i][j] == '1') {
					count++;
					Queue<Point> queue = new LinkedList<>();
					board[i][j] = 'B';
					queue.offer(new Point(i, j));
					while (!queue.isEmpty()) {
						Point point = queue.poll();
						for (int k = 0; k < 4; k++) {
							int x = direction[k][0] + point.x;
							int y = direction[k][1] + point.y;
							if (x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == '1') {
								board[x][y] = 'B';
								queue.offer(new Point(x, y));
							}
						}
					}
				}
			}
		return count;
	}

}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
