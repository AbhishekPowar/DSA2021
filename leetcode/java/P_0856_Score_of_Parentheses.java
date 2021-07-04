package leetcode;

import java.util.ArrayDeque;

import TestRunner.Input;
import TestRunner.Output;
import TestRunner.Test;

public class P_0856_Score_of_Parentheses {
	public int scoreOfParentheses(String S) {
		int res = 0;
		ArrayDeque<String> stk = new ArrayDeque<>();
		for (int i = 0; i < S.length(); i++) {
			Character ch = S.charAt(i);
			if (ch == '(') {
				stk.addLast(ch.toString());
			} else {
				Integer curSum = 0;
				while (!stk.isEmpty() && !stk.peekLast().equals("(")) {
					Integer num = Integer.parseInt(stk.removeLast().toString());
					curSum += num;
				}
				if (curSum == 0) {
					curSum = 1;
				} else if (curSum > 0)
					curSum <<= 1;
				stk.removeLast();
				stk.addLast(curSum.toString());

			}
		}

		while (stk.isEmpty() == false) {
			res += Integer.parseInt(stk.removeFirst());
		}
		return res;
	}

	public static void main(String[] args) {
		P_0856_Score_of_Parentheses handler = new P_0856_Score_of_Parentheses();
		String S = "()()";

		boolean test = true;
		if (!test) {
			int res = handler.scoreOfParentheses(S);
			System.out.println(res);
		} else {
			Input input = Input.getInstance();
			Output<Integer> expOutput = Output.getInstance();
			Test.minimal = false;
			input.add("()");
			expOutput.add(1);
			input.add("()()");
			expOutput.add(2);
			input.add("(())");
			expOutput.add(2);
			input.add("(()())");
			expOutput.add(4);
			input.add("((())())");
			expOutput.add(6);

			Test.run(input, expOutput, P_0856_Score_of_Parentheses.class, "scoreOfParentheses");

		}

	}

}
