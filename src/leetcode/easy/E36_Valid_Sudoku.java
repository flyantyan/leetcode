package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class E36_Valid_Sudoku {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (isPartialValidSudoku(board, i, 0, i, 9))
				return false;
			if (isPartialValidSudoku(board, 0, i, 9, i))
				return false;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; i < 3; j++) {
				if (isPartialValidSudoku(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2))
					return false;
			}
		}
		return true;
	}

	private boolean isPartialValidSudoku(char[][] board , int startX ,  int startY , int endX ,int endY){
        Set<Character> set = new HashSet<>();
        for(int i = startX ; i <= endX ; i++){
            for(int j = startY ; j <= endY ; j ++){
                if(board[i][j] != '.' && !set.add(board[i][j]))
                    return false ;
            }
        }
        return true ;
    }
}
