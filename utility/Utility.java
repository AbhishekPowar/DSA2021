package utility;

import java.util.Arrays;

public class Utility {
	static public  void printArray(int[] ar) {
		System.out.println(Arrays.toString(ar));
	}

	static public void printArray(int[][] ar) {
		for (int i = 0; i < ar.length; i++) {
			printArray(ar[i]);
		}
	}
	
	public static void main(String[] args) {
		int []ar = new int[]{1,2,3};
		printArray(ar);
	}
}
