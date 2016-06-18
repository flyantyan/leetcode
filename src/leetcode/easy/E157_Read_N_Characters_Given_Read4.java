package leetcode.easy;

public class E157_Read_N_Characters_Given_Read4 {

	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		if (buf == null || n < 0)
			return 0;
		int index = 0;
		while (n > 0) {
			char[] temp = new char[4];
			int i = read4(temp);
			int t = i;
			int j = 0;
			while (n > 0 && t > 0) {
				buf[index++] = temp[j++];
				t--;
				n--;
			}
			if (i < 4)
				break;
		}
		return index;
	}
	
	
	public int read4(char[] temp){
		return 0 ;
	}
}
