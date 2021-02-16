package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a string S, we can transform every letter individually to be 
//lowercase or uppercase to create another string.
//
//Return a list of all possible strings we could create.
//You can return the output in any order.


public class P_0784_Letter_Case_Permutation {
	// Slower than solution 1 
	//Needs some optimisation TC:  O(2^n) but n = number of characters
	public List<String> letterCasePermutation2(String S) {
		List<String> res = new ArrayList<String>();
		char[] s = S.toCharArray();
		int[] charIdx;
		int count = 0;
		for (int i = 0; i < s.length; i++) {
			if (!(s[i] >= '0' && s[i] <= '9')) {
				count++;
			}
		}
		charIdx = new int[count];
		count = 0;
		for (int i = 0; i < s.length; i++) {
			if (!(s[i] >= '0' && s[i] <= '9')) {
				charIdx[count++] = i;
			}
		}
		int n;
		char[] temp;
		for (int idx = 0; idx < Math.pow(2, charIdx.length); idx++) {
			n = idx;
			temp = Arrays.copyOf(s, s.length);
			count = 0;
			while (n > 0) {
				if ((n & 1) == 1) {
					char old = temp[charIdx[count]];
					if (old >= 'a')
						temp[charIdx[count]] = (char) (old - 32);
					else
						temp[charIdx[count]] = (char) (old + 32);
				}
				count++;
				n >>= 1;
			}
			res.add(new String(temp));

		}
		return res;
	}

	public List<String> letterCasePermutation(String S) {
		List<String> res = new ArrayList<>();
		char[] s = S.toCharArray();
		permute(s, 0, res);
		return res;
	}
	//TC : O(2^n)
	public void permute(char[] s, int idx, List<String> res) {
		if (idx < s.length) {
			permute(s, idx + 1, res);
			if (Character.isDigit(s[idx]))
				return;
			s[idx] = Character.isLowerCase(s[idx]) ? Character.toUpperCase(s[idx]) : Character.toLowerCase(s[idx]);
			permute(s, idx + 1, res);
		} else
			res.add(new String(s));

	}

	public static void main(String[] args) {
		P_0784_Letter_Case_Permutation handler = new P_0784_Letter_Case_Permutation();
		List<String> res = handler.letterCasePermutation2("a1b2");
		System.out.println(res);
	}

}
