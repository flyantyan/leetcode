package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class M166_Fraction_to_Recurring_Decimal {

	 //Consider all case:
    //1. Negative num
    //2. overflow      -2147483648
	public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0" ;
        
        StringBuilder result = new StringBuilder();
        
        result.append((numerator > 0) ^ (denominator > 0)? "-" : "");
        
        long nume = Math.abs((long)numerator) ;
        long deno = Math.abs((long)denominator) ;
        
        result.append(nume/deno) ;
        
        nume %= deno ;
        
        if(nume == 0){
            return result.toString() ;
        }
        result.append(".");
        Map<Long , Integer> map = new HashMap<>();
        map.put(nume , result.length());
        while(nume != 0){
            nume *= 10 ;
            result.append(nume/deno) ;
            nume %= deno ;
            if(map.containsKey(nume)){
                Integer index = map.get(nume) ;
                result.insert(index , "(");
                result.append(")") ;
                break ;
            }else{
                map.put(nume , result.length());
            }
        }
        
        
        return result.toString() ;
	}
	
	public static void main(String[] args) {
		new M166_Fraction_to_Recurring_Decimal().fractionToDecimal(-1, -2147483648);
	}
}
