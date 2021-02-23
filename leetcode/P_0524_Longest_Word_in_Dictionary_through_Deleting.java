package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Given a string and a string dictionary, find the longest string in
//the dictionary that can be formed by deleting some characters of the
//given string. If there are more than one possible results,
//return the longest word with the smallest lexicographical order. 
//		If there is no possible result, return the empty string. 

public class P_0524_Longest_Word_in_Dictionary_through_Deleting {

	class SortByLengthLexo implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o2.length() - o1.length();
		}

	}

	public Boolean isCorrect(String main, String small) {
		int mainLen = main.length();
		int smallLen = small.length();

		int mIdx = 0;
		int sIdx = 0;
		while (mIdx < mainLen && sIdx < smallLen) {
			if (main.charAt(mIdx) == small.charAt(sIdx)) {
				mIdx++;
				sIdx++;
			} else {
				mIdx++;
			}
		}
		return sIdx == smallLen;
	}

	public String findLongestWord(String s, List<String> d) {
		String sol = "";
		for (String word : d) {
			if (word.length() < sol.length())
				continue;
			if (word.length() == sol.length() && sol.compareTo(word) < 0)
				continue;
			if (isCorrect(s, word))
				sol = word;
		}
		return sol;
	}

	public String findLongestWordSort(String s, List<String> d) {
		Collections.sort(d, new SortByLengthLexo());
		String sol = "";
		for (String res : d) {
			if (isCorrect(s, res))
				return res;
		}
		return sol;
	}

	public String findLongestWordHeap(String s, List<String> d) {
		String res = null;
		PriorityQueue<String> heap = new PriorityQueue<>(new SortByLengthLexo());
		heap.addAll(d);
		while (!heap.isEmpty()) {
			res = heap.poll();
			if (isCorrect(s, res))
				return res;
		}
		return "";
	}

	@FunctionalInterface
	public interface Function<S, T, R> {
		R apply(S s, T t);
	}

	public static void main(String[] args) {
		P_0524_Longest_Word_in_Dictionary_through_Deleting handler = new P_0524_Longest_Word_in_Dictionary_through_Deleting();
		String s = "apmonpkle";
		List<String> d = new ArrayList<String>();
		Function<String, List<String>, String> func = handler::findLongestWordSort;
		d.addAll(Arrays.asList("monkey", "ale", "apple", "apmon"));
		String res = func.apply(s, d);
		System.out.println(res);

	}

}
