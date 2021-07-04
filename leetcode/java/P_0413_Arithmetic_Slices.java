package leetcode;
//A sequence of numbers is called arithmetic 

//if it consists of at least three elements and 
//if the difference between any two consecutive elements is the same.
//For example, these are arithmetic sequences

//Example:   1 2 3 4 7 10
//Slices = [1,2,3] [2,3,4] [1,2,3,4] [4,7,10]
public class P_0413_Arithmetic_Slices {
	// O(N) OG Solution
	public int numberOfArithmeticSlices(int[] A) {
		if (A.length < 3)
			return 0;

		int res = 0;
		int sum = 1;
		int prev = Integer.MIN_VALUE;

		for (int index = 0; index < A.length - 1; index++) {
			if (prev == (A[index + 1] - A[index])) {
				res += sum;
				sum += 1;
			} else {
				sum = 1;
				prev = A[index + 1] - A[index];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 4, 7, 10 };
		P_0413_Arithmetic_Slices handler = new P_0413_Arithmetic_Slices();
		int res = handler.numberOfArithmeticSlices(A);
		System.out.println(res);
	}

}
