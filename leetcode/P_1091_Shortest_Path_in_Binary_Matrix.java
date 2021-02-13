package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P_1091_Shortest_Path_in_Binary_Matrix {

	public int shortestPathBinaryMatrix(int[][] grid) {
		int gridLen = grid.length;
		if (grid[0][0] == 1 || grid[gridLen - 1][gridLen - 1] == 1) {
			return -1;
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 1 });
		int[] temp;
		int x, y, distance;
		int row, column;
		grid[0][0] = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			queue.forEach(e -> System.out.print(Arrays.toString(e)));
			System.out.println();
			while (size-- > 0) {
				temp = queue.poll();
				x = temp[0];
				y = temp[1];
				distance = temp[2];
				if (x == (gridLen - 1) && y == (gridLen - 1)) {
					return distance;
				}
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						row = x + i;
						column = y + j;
						if (row >= 0 && column >= 0 && row < gridLen && column < gridLen && grid[row][column] == 0) {
							queue.add(new int[] { row, column, distance + 1 });
							grid[row][column] = 1;

						}
					}
				}
			}

		}
		return -1;

	}

	public static void main(String[] args) {
		P_1091_Shortest_Path_in_Binary_Matrix handler = new P_1091_Shortest_Path_in_Binary_Matrix();
		int[][] grid = new int[][] { { 0, 0, 0, 0 }, { 1, 1, 1, 0 }, { 1, 1, 0, 1}, { 1, 1, 1, 0 } };
		int res = handler.shortestPathBinaryMatrix(grid);

		System.out.println(res);

	}

}
