package leetcode;

public class P_0231_Power_of_Two {
	public boolean isPowerOfTwo(int n) {
		if (n < 1)
			return false;
		return (n & (n - 1)) == 0;
	}

	public static void main(String[] args) {
		P_0231_Power_of_Two handler = new P_0231_Power_of_Two();
		int n = 4;

		boolean res = handler.isPowerOfTwo(n);
		System.out.println(res);
	}

}
