package leetcode;

public class P_1342_Number_of_Steps_to_Reduce_a_Number_to_Zero {
	public int numberOfSteps(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			if ((num & 1) == 1)
				num -= 1;
			else
				num >>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		P_1342_Number_of_Steps_to_Reduce_a_Number_to_Zero handler = new P_1342_Number_of_Steps_to_Reduce_a_Number_to_Zero();
		int ans = handler.numberOfSteps(14);
		System.out.println(ans);
	}

}
