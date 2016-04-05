package leetcode.easy;

/**
 * TestCase :"AB" 3
 * 
 * @author yanfei
 *
 */
public class E6_ZigZag_Conversion {

	public static void main(String[] args) {
//		convert("ABCED", numRows)
	}

	/**
	 * 
	 * Two Solutions: S1: 根据下标的索引关系来拼接整个输出
	 * 
	 * 
	 * 
	 * 
	 * S2: 将输入按照指定的格式储存起来然后遍历输出
	 * 
	 * 
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		if (numRows <= 1)
			return s;
		// 一个排列规律中的数量
		int num = numRows + numRows - 2;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			int index = i;
			int j = 0;  //第几次迭代
			while (index < s.length()) {
				result.append(s.charAt(index));
				if (i > 0 && i < numRows - 1) {
					int temp = j * num + num - i;  //求解下一个坐标
					if (temp > 0 && temp < s.length())
						result.append(s.charAt(temp));
				}
				index = index + num;
				j++;
			}
		}
		return result.toString();
	}

}
