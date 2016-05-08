package leetcode.easy;

public class E344_Reverse_String {

	public String reverseString(String s) {
        StringBuilder builder = new StringBuilder(s) ;
        return builder.reverse().toString();
    }
	
	public static void main(String[] args) {
		new E344_Reverse_String().reverseString("123123123123");
	}
}
