package leetcode.medium;

public class M59_Spiral_MatrixII {

	public int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n] ;
        int num = 1 ;
        for(int i = 0 ; i < n/2 ; i ++){
            for(int j = i ; j <= n-1-i ; j ++){
                matrix[i][j] = num++ ;
            }
            for(int j = i+1 ; j <= n-1-i ; j ++){
                matrix[j][n-1-i] = num++ ;
            }
            
            for(int j = n-i-2 ; j >= i ; j --){
                matrix[n-1-i][j] = num++ ;
            }
            
            for(int j = n-i-2 ; j >=i+1 ; j --){
                matrix[j][i] = num++;
            }
        }
        
        return matrix ;
    }
	
	public static void main(String[] args) {
		new M59_Spiral_MatrixII().generateMatrix(5);
	}
}
