package leetcode;

//Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
//
//A string is homogenous if all the characters of the string are the same.
//
//A substring is a contiguous sequence of characters within a string.
public class P_1759_Count_Number_of_Homogenous_Substrings {
	// simple version /less line of code
	// int res = 0, cur = 0, count = 0, mod = 1_000_000_007;
	// for (int i = 0; i < s.length(); ++i) {
	// count = s.charAt(i) == cur ? count + 1 : 1;
	// cur = s.charAt(i);
	// res = (res + count) % mod;
	// }

	// Original solution for contest. TC O(n) Space constant
	// Above solution is well written by Lee215
	public int countHomogenous(String s) {
		if (s.length() < 2)
			return s.length();

		long MOD = 1_000_000_007;
		double res = 0;
		long count = 1;

		char lastChar = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == lastChar) {
				count++;
			} else {
				res += (count * (count + 1)) / 2;
				res %= MOD;
				count = 1;
				lastChar = s.charAt(i);
			}
		}
		res += (count * (count + 1)) / 2;
		res %= MOD;
		return (int) res;
	}

	public static void main(String[] args) {
		String s = "abcdd";

		P_1759_Count_Number_of_Homogenous_Substrings handler = new P_1759_Count_Number_of_Homogenous_Substrings();
		System.out.println(s);
		int res = handler.countHomogenous(s);
		System.out.println(res);
	}

}
