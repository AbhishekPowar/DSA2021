package leetcode;

import java.util.Stack;

public class P_0071_Simplify_Path {
	public String simplifyPath(String path) {
		StringBuilder sb = new StringBuilder();
		String[] folders = path.split("/");
		Stack<String> stk = new Stack<>();
		for (String folder : folders) {
			if (folder.equals(".") || folder.length() == 0) {
				continue;
			} else if (folder.equals("..")) {
				if (!stk.isEmpty()) {
					stk.pop();
				}
			} else {
				stk.push(folder);
			}
		}

		for (String folder : stk) {
			sb.append("/");
			sb.append(folder);

		}
		if (sb.length() == 0) {
			return "/";
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		String path = "/a//./b/../../c/";
		// String path = "/a//b////c/d//././/..";
		System.out.println(path);

		P_0071_Simplify_Path handler = new P_0071_Simplify_Path();

		String cpath = handler.simplifyPath(path);
		System.out.println(cpath);

	}

}
