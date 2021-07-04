package leetcode;

public class P_0906_Super_Palindromes {
	public boolean isPalindrome(Long num) {
		Long rev = 0L;
		Long oldNum = num;
		for (; oldNum > 0; oldNum /= 10) {
			rev = rev * 10 + oldNum % 10;
		}
		return rev.equals(num);
	}

	public int superpalindromesInRange(String left, String right) {
		int palindromeCount = 0;
		Long low = Long.valueOf(left);
		Long high = Long.valueOf(right);
		// even len palindrome
		String strInt;
		Long bigNum, smallNum;
		for (int i = 0; i < 100000; i++) {
			strInt = Integer.toString(i);
			smallNum = Long.valueOf(strInt + new StringBuilder(strInt).reverse().toString());
			bigNum = smallNum * smallNum;

			if (bigNum > high) {
				break;
			}
			if (bigNum >= low && isPalindrome(bigNum)) {
				palindromeCount++;
				System.out.println("hit");
			}
		}
		// odd len Palindrome
		for (int i = 1; i < 100000; i++) {
			strInt = Integer.toString(i);
			smallNum = Long
					.valueOf(strInt + new StringBuilder(strInt.substring(0, strInt.length() - 1)).reverse().toString());
			bigNum = smallNum * smallNum;
			if (bigNum > high) {
				break;
			}
			if (bigNum >= low && isPalindrome(bigNum)) {
				palindromeCount++;

			}
		}

		return palindromeCount;
	}

	public static void main(String[] args) {
		P_0906_Super_Palindromes handler = new P_0906_Super_Palindromes();
		String left = "40000000000000000";
		String right = "50000000000000000";

		System.out.println("Super Palindrome count " + handler.superpalindromesInRange(left, right));

	}

}
