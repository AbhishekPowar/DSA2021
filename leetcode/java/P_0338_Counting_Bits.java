package leetcode;

import java.util.Arrays;

public class P_0338_Counting_Bits {
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		for (int i = 1; i < res.length; i++)
			res[i] = res[i >> 1] + (i & 1);
		return res;
	}

	public static void main(String[] args) {
		P_0338_Counting_Bits handler = new P_0338_Counting_Bits();
		int num = 16;
		int res[] = handler.countBits(num);
		System.out.println(Arrays.toString(res));
	}

}
