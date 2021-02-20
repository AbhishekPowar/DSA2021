package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_0013_Roman_to_Integer {
	public int romanToInt(String s) {
		Map<Character, Integer> hmap = new HashMap<Character, Integer>();

		hmap.put('I', 1);
		hmap.put('V', 5);
		hmap.put('X', 10);
		hmap.put('L', 50);
		hmap.put('C', 100);
		hmap.put('D', 500);
		hmap.put('M', 1000);

		int max = -1;
		int sum = 0;
		int curVal;
		for (int i = s.length() - 1; i >= 0; i--) {
			curVal = hmap.get(s.charAt(i));
			if (curVal >= max) {
				sum += curVal;
			} else {
				sum -= curVal;
			}
			max = Integer.max(max, curVal);
		}
		return sum;
	}

	public static void main(String[] args) {
		P_0013_Roman_to_Integer handler = new P_0013_Roman_to_Integer();
		List<String> input = new ArrayList<String>(Arrays.asList("III","IX","XV"));
		List<Integer> output = new ArrayList<Integer>(Arrays.asList(3,9,15));
		
		for (int i = 0; i < input.size(); i++) {
			System.out.println("Input : "+input.get(i));
			System.out.println("Output : "+handler.romanToInt(input.get(i)));
			System.out.println("Exp Output : "+output.get(i));
		}
	}

}
