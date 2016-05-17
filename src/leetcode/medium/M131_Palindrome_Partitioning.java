package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M131_Palindrome_Partitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();

		dfs(result, new ArrayList<String>(), s, 0);
		return result;
	}

	private void dfs(List<List<String>> result , List<String> temp ,String s ,  int pos){
        if(pos == s.length()){
            result.add(new ArrayList<>(temp));
        }else{
            for(int i = pos ; i < s.length() ; i ++){
                if(isPalindrome(s , pos , i)){
                    temp.add(s.substring(pos , i+1)) ;
                    dfs(result , temp , s , i+1);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

	private boolean isPalindrome(String str, int start, int end) {
		while (start <= end) {
			if (str.charAt(start++) != str.charAt(end--)) {
				return false;
			}
		}

		return true;
	}
}
