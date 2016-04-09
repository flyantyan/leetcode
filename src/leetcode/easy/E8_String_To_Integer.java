package leetcode.easy;

/**
 * TestCase: "    0123"
 * @author yanfei
 *
 */
public class E8_String_To_Integer {

	public  int myAtoi(String str) {
        if(str == null || str.trim().length() == 0)
            return 0;
        
        
         //TestCase: "    0123"  
        str = str.trim();
        int startIndex = 0 ;
        int endIndex = str.length() ;
        int op = 1 ;
        
        if('+' == str.charAt(0)){
            startIndex ++ ;    
        }else if('-' == str.charAt(0)){
            startIndex ++ ;
            op = -1 ;
        }
        
        int dotIndex = str.indexOf(".");
        
        if(dotIndex != -1){
        	endIndex = dotIndex ;
        }
        
        long  result = 0;
        for(int i = startIndex ; i < endIndex ; i ++){
        	if(!Character.isDigit(str.charAt(i))){
        		break;
        	}
        	result = result * 10 +(str.charAt(i) - '0');
        	
        	if(result > Integer.MAX_VALUE){
        		if(op == 1)
        			return Integer.MAX_VALUE;
        		else
        			return Integer.MIN_VALUE;
        	}
        }
        
        result *= op ;
        
        if(result < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        
        return (int) result ;
    }
	
	public static void main(String[] args) {
		int a = new E8_String_To_Integer().myAtoi(Integer.MAX_VALUE+"");
		System.out.println(a == Integer.MAX_VALUE);
		System.out.println(a == Integer.MIN_VALUE);
	}
}
