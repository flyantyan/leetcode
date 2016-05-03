package leetcode.medium;

import java.util.LinkedList;

//TestCase: "/..."    避免  aba 多个字母  reverse 反向会名字也会逆向
public class M71_Simplify_Path {
	public String simplifyPath(String path) {
		LinkedList<String> stack = new LinkedList<>();
		// "/..."
		path = path + "/";
		int start = 0;
		int end = path.indexOf('/', 1);

		while (end < path.length() && end != -1) {
			String temp = path.substring(start + 1, end);
			start = end;
			end = path.indexOf('/', end + 1);
			switch (temp) {
			case ".":
				// DO nothing
				break;
			case "..":
				if (!stack.isEmpty())
					stack.removeLast();
				break;
			default:
				if (temp.trim().length() > 0)
					stack.addLast(temp);
				break;
			}
		}

		if (stack.isEmpty())
			return "/";
		StringBuilder sb = new StringBuilder();
		sb.append('/');
		while (!stack.isEmpty()) {
			sb.append(stack.removeFirst() + "/");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static void main(String[] args) {
		new M71_Simplify_Path().simplifyPath("/a/a/a");
	}
}
