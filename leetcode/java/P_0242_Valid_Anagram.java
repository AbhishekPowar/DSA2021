package leetcode;

import java.util.Arrays;

public class P_0242_Valid_Anagram {
	public boolean isAnagram(String s, String t) {

		// return false if length doesn't match
		if (s.length() != t.length())
			return false;

		//Use hashmap if characters unknwon
		int charCount[] = new int[26];

		// Populate map
		for (int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i) - 'a'] += 1;

		}

		// Decrement for every occurance in string 2 : t
		for (int i = 0; i < t.length(); i++) {
			// check if char at idx i is an extra
			if (charCount[t.charAt(i) - 'a'] == 0) {
				return false;
			}
			charCount[t.charAt(i) - 'a'] -= 1;
		}
		return true;
	}

	public static void main(String[] args) {
		P_0242_Valid_Anagram handler = new P_0242_Valid_Anagram();
		String s = "racecar";
		String t = "rraaacce";
		System.out.println(handler.isAnagram(s, t));

	}

}
