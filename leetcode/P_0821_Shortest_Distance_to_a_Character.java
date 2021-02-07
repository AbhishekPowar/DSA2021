package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_0821_Shortest_Distance_to_a_Character {
	public int[] shortestToCharOG(String s, char c) {
		int[] res = new int[s.length()];
		List<Integer> found = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				found.add(i);
			}
		}
		found.add(Integer.MAX_VALUE / 2);
		int prev = Integer.MIN_VALUE / 2;
		int next = found.get(0);
		int foundIdx = 0;
		for (int i = 0; i < res.length; i++) {
			res[i] = Math.min(i - prev, next - i);

			if (i >= next) {
				foundIdx++;
				prev = next;
				if (foundIdx < found.size()) {
					next = found.get(foundIdx);
				}
			}

		}

		return res;
	}

	public int[] shortestToChar(String s, char c) {
		int[] res = new int[s.length()];
		int prev = Integer.MIN_VALUE / 2;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				prev = i;
			}
			res[i] = i - prev;

		}
		prev = Integer.MAX_VALUE / 2;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == c) {
				prev = i;
			}
			res[i] = Math.min(res[i], prev - i);
		}

		return res;
	}

	public static void main(String[] args) {
		P_0821_Shortest_Distance_to_a_Character handler = new P_0821_Shortest_Distance_to_a_Character();

		String s = "loveleetcode";
		char c = 'e';

		int[] res = handler.shortestToChar(s, c);

		System.out.println(Arrays.toString(res));
	}

}
