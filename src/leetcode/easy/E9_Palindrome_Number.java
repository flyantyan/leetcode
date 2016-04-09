package leetcode.easy;

public class E9_Palindrome_Number {

//	public boolean isPalindrome(int x) {
//        if(x < 0)
//            return false ;
//        if(x == 0)
//            return true ;
//        
//        //Get the length of input num
//        int len = 0 ;
//        int tmp = x ;
//        while(tmp != 0){
//            len++;
//            tmp/=10;
//        }
//        int tmp1 = x ;
//        int tmp2 = x ;
//        for(int i = 1 ; i <= (len+1)/2 ; i ++){
//            int num1 = tmp1%10 ;
//            int num2 = tmp2/(int)Math.pow(10 , len-i);
//            
//            if(num1 != num2)
//                return false;
//            
//            tmp1/=10 ;
//            tmp2 %= (int)Math.pow(10 , len-i);
//            
//        }
//        
//        return true;
//    }
	
	
	public boolean isPalindrome(int x) {
	    if (x<0 || (x!=0 && x%10==0)) return false;
	    int rev = 0;
	    while (x>rev){
	        rev = rev*10 + x%10;
	        x = x/10;
	    }
	    return (x==rev || x==rev/10);
	}
	public static void main(String[] args) {
		new E9_Palindrome_Number().isPalindrome(121);
	}
}
