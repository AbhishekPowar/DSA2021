package leetcode;

//On a broken calculator that has a number showing on its display, we can perform two operations:
//
//Double: Multiply the number on the display by 2, or;
//Decrement: Subtract 1 from the number on the display.
//Initially, the calculator is displaying the number X.
//
//Return the minimum number of operations needed to display the number Y

public class P_0991_Broken_Calculator {
	// O(logY)
	public int brokenCalc(int X, int Y) {
		int res = 0;
		while (Y > X) {
			res++;
			if ((Y & 1) == 1)
				Y += 1;
			else
				Y >>= 1;

		}
		return res + (X - Y);
	}

	public static void main(String[] args) {
		P_0991_Broken_Calculator handler = new P_0991_Broken_Calculator();
		int res = handler.brokenCalc(4, 17);
		System.out.println("Output : " + res);
	}

}
