package leetcode.easy;

public class E28_Implement_strStr {
	public int strStr1(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length())
			return -1;
		int next[] = getNextArr(needle);
		int i = 0;
		int j = 0;

		while (i < haystack.length() && j < needle.length()) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}

		if (j < needle.length())
			return -1;
		else
			return i - j;
	}

	private int[] getNextArr(String needle) {
		if (needle == null || needle.length() == 0)
			return null;

		int[] next = new int[needle.length()];
		next[0] = -1;

		int i = 1;
		int cn = -1;
		while (i < needle.length()) {
			if (cn == -1 || needle.charAt(cn) == needle.charAt(i - 1)) {
				next[i++] = ++cn;
			} else if (cn > -1) {
				cn = next[cn];
			} else {
				next[i++] = 0;
			}
		}

		return next;
	}

	public static void main(String[] args) {
		int i = new E28_Implement_strStr().strStr("sdfsdfsfdsdfsdfsdf", "a");
		System.out.println(i);

	}

	public static int index(String value, String str) {
		return indexOf(value.toCharArray(), value.toCharArray().length, str.toCharArray(), str.toCharArray().length);
	}

	static int indexOf(char[] source,  int sourceCount,
            char[] target,  int targetCount) {
        if (targetCount == 0) {
            return 0;
        }

        char first = target[0];
        int max = (sourceCount - targetCount);

        for (int i = 0 ; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k =  1; j < end && source[j]== target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }
}
