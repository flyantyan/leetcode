package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M3_Longest_Substring_Without_Repeating_Characters {
	
	
	
	public static int lengthOfLongestSubstring(String s) {
		if(s == null ||  "".equals(s))
			return 0 ;
		
		int startIndex = 0 ;
		int endIndex = 0 ;
		int max = 0 ;
		int currentLength = 0 ;
		
		List<Character> strs = new ArrayList<Character>();
		while(endIndex < s.length()){
			if(strs.contains(s.charAt(endIndex))){
				//Note:  The method of  List.remove() has a overload(int/Object) method ,in which the parameter of int used for index for the object
				strs.remove((Object)s.charAt(startIndex++));
			}else{
				strs.add(s.charAt(endIndex));
				currentLength = endIndex - startIndex + 1;
				if(currentLength > max){
					max = currentLength;
				}
				
				endIndex ++ ;
			}
			
		}
		return max ;
	}
	
	
	
	
	
	//Time Limit Exceeded
//	public static int lengthOfLongestSubstring(String s) {
//		if (s == null && "".equals(s))
//			return 0;
//
//		int max = 0;
//		int currentLength = 0;
//		StringBuilder sb = new StringBuilder();
//
//		for (int i = 0; i < s.length(); i++) {
//			int j = i + 1;
//			currentLength = 1;
//			sb = new StringBuilder();
//			sb.append(s.charAt(i)+"");
//			while (j < s.length() && sb.indexOf(s.charAt(j)+"")==-1){
//				currentLength++;
//				sb.append(s.charAt(j));
//				j++;
//			}
//			if (currentLength > max) {
//				max = currentLength;
//			}
//		}
//		return max;
//	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("aab"));
	}

}
