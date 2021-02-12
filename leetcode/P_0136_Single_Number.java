package leetcode;

public class P_0136_Single_Number {
	public int singleNumber(int[] nums) {
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor ^= nums[i];
		}
		return xor;
	}

	public static void main(String[] args) {
		P_0136_Single_Number handler = new P_0136_Single_Number();
		int [] nums = new int []{2,2,1,3,3};
		int res = handler.singleNumber(nums);
		System.out.println(res);
		System.out.println("Correct :"+(res ==1));
	}

}
