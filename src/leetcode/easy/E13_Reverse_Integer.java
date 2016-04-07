package leetcode.easy;

/**
 * 
 * TestCase:
 * 		0  超过Int范围 负数
 * @author yanfei
 *
 */
public class E13_Reverse_Integer {

	public int reverse(int x) {
		/**
		 * 1,符号 ：首先判断正负数 2，数字 ：逆序数字 栈操作 除法
		 * 
		 */
		// Flag for the num if positive num or negative-num
		int flag = (x < 0) ? -1 : 1;
		x = flag * x;
		
		StringBuilder num = new StringBuilder(x+"");
		
		num.reverse();
		try{
			int result = Integer.parseInt(num.toString());
			return result ;
		}catch(Exception e){
			return 0 ;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new E13_Reverse_Integer().reverse(1534236469));
	}
}
