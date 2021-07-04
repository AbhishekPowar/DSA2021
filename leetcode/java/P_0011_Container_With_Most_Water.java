package leetcode;

//Give array of size n
//Each elemet represents coloum wall of length a[i]
//Calculate largest block by area that can be created 
//With 2 columns and x axis 
//X         X     
//X         X   X 
//X X       X   X 
//X X   X   X   X 
//X X   X X X   X 
//X X   X X X X X 
//X X X X X X X X 
//X X X X X X X X X 
//1 8 6 2 5 4 8 3 7 
//Maximize distance b/n colums  * min(a[i],a[j]);
//


public class P_0011_Container_With_Most_Water {
	//O(n)
	public int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
		int l = 0, h = height.length - 1;

		while (l < h) {
			max = Integer.max(max, (h - l) * Integer.min(height[l], height[h]));
			if (height[l] < height[h])
				l++;
			else
				h--;
		}
		return max;
	}
	//O(n^2)
	public int maxArea2(int[] height) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < height.length; i++) {
			for (int j = i; j < height.length; j++) {
				max = Integer.max(max, Math.abs(i - j) * Integer.min(height[i], height[j]));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int [ ] ar= new int []{1,8,6,2,5,4,8,3,7};
		P_0011_Container_With_Most_Water handler = new P_0011_Container_With_Most_Water();
		System.out.println(handler.maxArea2(ar));
	}

}
