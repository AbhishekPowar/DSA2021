package leetcode;

//src : watch Algo made easy. he explains all conditions with examples
public class P_0665_Nondecreasing_Array {
	public boolean checkPossibility(int[] nums) {
		// multiple violation means we cannot fix it
		int pos = -1;
		for (int i = 0; i < nums.length - 1; i++) {
			// more than one violation 
			if (nums[i] > nums[i + 1]) {
				if (pos != -1) {
					return false;
				}
				// One violation can converted into non decreasing order
				pos = i;
			}
		}

		// single violation then? case is tricky
		
		// pos == -1 means no violation to valid

		// pos == 0 means violation at index 0. Change index 0 value to Integer.MIN_VALUE

		// pos == n-2 then change n-1 val greater that n-2 or Integer.MAX_VALUE

		// element at index -1 <= index + 1 : 3 4 2 6 //here at value 4 violation occurs 
		// we can convert this array into valid if we make element at i-1 <= i+1

		// element at index < index + 2 
		// example : 5 7 1 _ _ is easy fix change index 2  to 7 or greater
		// But what if
		// array is 5 7 1 2 3 it is single violation at 7 but we cannot change idnex 2 to whatever we want
		// it is important that violation index +2 >= index so that we can convert it into non decreasing order

		return pos == -1 || pos == 0 || pos == nums.length - 2 || nums[pos - 1] <= nums[pos + 1]
				|| nums[pos] <= nums[pos + 2];

	}

	public static void main(String[] args) {
		int[] ar = new int[] { 7, 50, 3 };
		P_0665_Nondecreasing_Array handler = new P_0665_Nondecreasing_Array();
		boolean ans = handler.checkPossibility(ar);
		System.out.println(ans);
	}

}
