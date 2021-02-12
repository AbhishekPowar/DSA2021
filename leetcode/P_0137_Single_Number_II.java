package leetcode;
//Given a non-empty array of integers nums, 

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//every element appears twice except for one. 
//Find that single one.

class P_0137_Single_Number_II {
	public int singleNumberHashMapSolution(int[] nums) {
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
		}
		for (Integer key : hmap.keySet()) {
			if (hmap.get(key) == 1)
				return key;
		}
		return 0;
	}

	public static void main(String[] args) {
		P_0137_Single_Number_II handler = new P_0137_Single_Number_II();
		int[] nums = new int[] { 6, 6, 6, 3, 1, 1, 1, 2, 2, 2 };
		int res = handler.singleNumberHashMapSolution(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(res);
	}

}
