package leetcode.medium;

public class M289_Game_of_Life {

	public void gameOfLife(int[][] board) {
		// state 0: dead->dead
		// state 1: live->dead
		// state 10:dead->live
		// state 11:live->live
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int x = genearNext(board, i, j);
				if (board[i][j] == 0) {
					if (x == 3)
						board[i][j] += 10;
				} else if (board[i][j] == 1) {
					if (x == 2 || x == 3) {
						board[i][j] += 10;
					}
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] / 10 == 1)
					board[i][j] = 1;
				else {
					board[i][j] = 0;
				}

			}
		}
	}

	private int genearNext(int[][] board, int x, int y) {
		int count = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || (i == x && j == y)) {
					continue;
				}
				if (board[i][j] % 10 == 1) {
					count++;
				}
			}
		}
		return count;
	}
}
