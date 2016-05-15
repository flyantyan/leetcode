package leetcode.easy;

public class E342_Power_of_Four {

	public boolean isPowerOfFour_1(int num) {
        while(num >= 4){
            if(num % 4 != 0)
                return false ;
            num /= 4 ;
        }
        return num == 1;
    }
}
