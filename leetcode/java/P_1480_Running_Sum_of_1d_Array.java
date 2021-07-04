package leetcode;
import utility.Utility;

//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//
//Return the running sum of nums.
public class P_1480_Running_Sum_of_1d_Array {
    public int[] runningSum(int[] nums) {
    	int [] rsum = new int [nums.length];
    	int tSum=0;
    	for (int i = 0; i < nums.length; i++) {
			tSum+=nums[i];
			rsum[i]=tSum;
		}
		return rsum;
        
    }
	public static void main(String[] args) {
		
		
		int []ar = new int [] {1,2,3,4,54};
		
		P_1480_Running_Sum_of_1d_Array handler = new P_1480_Running_Sum_of_1d_Array();
		int []ans =handler.runningSum(ar);
		Utility.printArray(ar);

		Utility.printArray(ans);
	}
}
