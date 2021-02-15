package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

import utility.Utility;

//Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians)
//, return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
//A row i is weaker than row j, if the number of soldiers in row i is less than the number 
//		of soldiers in row j, or they have the same number of soldiers but i is less than j. 
//		Soldiers are always stand in the frontier of a row, that is, always ones may appear 
//		first and then zeros.
public class P_1337_The_K_Weakest_Rows_in_a_Matrix {
	// O(max(rlogc,rlogr))
	public int[] kWeakestRows(int[][] mat, int k) {
		int row = mat.length;
		int col = mat[0].length;
		int solve[][] = new int[row][2];
		int res[] = new int[k];
		int soldierCount;
		for (int i = 0; i < row; i++) {
			solve[i][0] = CountSoldiers(mat[i]);
			solve[i][1] = i;
		}
		Arrays.sort(solve, 0, row, (a, b) -> a[0] - b[0]);
		for (int i = 0; i < res.length; i++) {
			res[i] = solve[i][1];
		}

		return res;
	}

	public int CountSoldiers(int[] ar) {
		int pos = -1;
		int low = 0;
		int high = ar.length;
		int mid;
		while (low < high) {
			mid = low + (high - low) / 2;
			if (ar[mid] == 1) {
				low = mid + 1;
				pos = mid;
			} else {
				high = mid;
			}
		}
		return pos + 1;
	}

	public int[] heapSolution(int[][] mat, int k) {
		int res[] = new int[k];
		PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}

			return a[0] - b[0];

		});
		for (int i = 0; i < mat.length; i++) {
			minHeap.add(new Integer[] { CountSoldiers(mat[i]), i });
		}

		for (int i = 0; i < res.length; i++) {
			res[i] = minHeap.poll()[1];
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 },
				{ 1, 1, 1, 1, 1 } };
		int k = 3;

		// mat = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, {
		// 1, 0, 0, 0 } };
		// k = 2;

		System.out.println("Input:");
		Utility.printArray(mat);
		System.out.println("K = " + k);
		P_1337_The_K_Weakest_Rows_in_a_Matrix handler = new P_1337_The_K_Weakest_Rows_in_a_Matrix();
		int[] res = handler.kWeakestRows(mat, k);
		System.out.println("Result :");
		System.out.println(Arrays.toString(res));

	}

}
