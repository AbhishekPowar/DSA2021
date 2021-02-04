package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_0594_Longest_Harmonious_Subsequence {
	public int findLHS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (Integer key : hmap.keySet()) {
			cur = hmap.get(key);
			if (hmap.containsKey(key + 1)) {
				cur += hmap.get(key + 1);
			} else {
				cur = 0;
			}
			max = Math.max(max, cur);
		}
		return max;
	}

	public static void main(String[] args) {

		int[] ar = new int[] { 1, 1, 1, 1 };
		P_0594_Longest_Harmonious_Subsequence handler = new P_0594_Longest_Harmonious_Subsequence();
		int ans = handler.findLHS(ar);
		System.out.println(ans);
	}

}
