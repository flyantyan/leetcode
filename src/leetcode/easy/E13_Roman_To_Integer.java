package leetcode.easy;

import java.util.HashMap;

/**
计数规则：
相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
正常使用时，连续的数字重复不得超过三次
在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）

其次，罗马数字转阿拉伯数字规则（仅限于3999以内）：

从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数
 */
public class E13_Roman_To_Integer {
	public int romanToInt(String s) {
		HashMap<Character, Integer> table = new HashMap<>();
		table.put('I', 1);
		table.put('V', 5);
		table.put('X', 10);
		table.put('L', 50);
		table.put('C', 100);
		table.put('D', 500);
		table.put('M', 1000);

		/**
		 * 从头开始遍历： 如果当前数值比前一个小，则加上当前数值
		 * 如果当前数值比前一个大，则减去前一个*2（因为之前已经计算过一次，要将其去掉），再加上当前数值
		 */
		int total = table.get(s.charAt(0));
		int pre, cur;
		for (int i = 1; i < s.length(); i++) {
			pre = table.get(s.charAt(i - 1));
			cur = table.get(s.charAt(i));

			if (pre < cur) {
				total -= pre * 2;
			}
			total += cur;
		}

		return total;

	}
}
