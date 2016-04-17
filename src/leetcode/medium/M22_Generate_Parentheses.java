package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M22_Generate_Parentheses {

	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        dfs(result , "" , n , n);
        return result ;
    }
    
	/**
	 * left and right represents the remaining numbers of '(' and ')' that need to be added ;
	 * When left is greater than right ,means that there are more ')' than '('
	 * @param result
	 * @param str
	 * @param left
	 * @param right
	 */
    private void dfs(List<String> result , String str , int left , int right){
        if(left > right){
            return ;
        }
        
        if(left == 0 && right == 0){
            result.add(str);
        }
        
        if(left > 0){
            dfs(result , str+"(" , left-1 , right);
        }
        
        if(right>0){
            dfs(result , str+")" , left , right-1);
        }
    }
}
