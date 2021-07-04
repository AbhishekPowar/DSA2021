package leetcode;
//You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
//
//The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
//
//Return the minimum number of operations needed to make s alternating.
public class P_1758_Minimum_Changes_To_Make_Alternating_Binary_String {
	public int minOperations(String s) {
		int count0101 = 0, count1010 = 0;
		for (int idx = 0; idx < s.length(); idx++) {
			// odd Index
			if ((idx & 1) == 1) {
				// O at odd position
				if (s.charAt(idx) == '0') {
					count1010++;
				} else {
					count0101++;
				}
			}
			// even Index
			else {
				// O at even position
				if (s.charAt(idx) == '0') {
					count0101++;
				} else {
					count1010++;
				}
			}

		}
		return s.length() - Integer.max(count0101, count1010);
	}

	public static void main(String[] args) {
		P_1758_Minimum_Changes_To_Make_Alternating_Binary_String handler = new P_1758_Minimum_Changes_To_Make_Alternating_Binary_String();
		String s = "10100110";
		int res = handler.minOperations(s);
		System.out.println(res);
	}

}
