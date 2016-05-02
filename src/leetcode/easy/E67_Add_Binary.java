package leetcode.easy;

public class E67_Add_Binary {

	public String addBinary(String a, String b) {
		if (a == null)
			return b;
		if (b == null)
			return a;

		int i = a.length() - 1;
		int j = b.length() - 1;

		StringBuilder sb = new StringBuilder();
		int add = 0;

		while (i >= 0 || j >= 0 || add == 1) {
			int bitA = i >= 0 ? a.charAt(i--) - '0' : 0;
			int bitB = j >= 0 ? b.charAt(j--) - '0' : 0;
			sb.append((bitA + bitB + add) % 2);
			add = (bitA + bitB + add) / 2;
		}

		// while(i >= 0 && j >= 0){
		// int temp = a.charAt(i) - '0' + b.charAt(j) - '0' + add;
		// add = temp/2 ;
		// sb.append(temp%2) ;

		// i--;
		// j--;
		// }

		// while(i >= 0){
		// int temp = a.charAt(i)-'0' + add ;
		// add = temp/2 ;
		// sb.append(temp%2) ;

		// i-- ;
		// }

		// while(j >= 0){
		// int temp = b.charAt(j)-'0' + add ;
		// add = temp/2 ;
		// sb.append(temp%2) ;

		// j-- ;
		// }

		// if(add == 1)
		// sb.append("1");

		return sb.reverse().toString();

	}
}
