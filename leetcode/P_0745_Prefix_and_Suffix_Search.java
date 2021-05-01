package leetcode;

import java.util.ArrayList;

class WordFilter {
	Trie preTr = new Trie();
	Trie suffTr = new Trie();
	public WordFilter(String[] words) {
		int index=0;
		for(String word : words) {
			
			preTr.insert(word, index);
			suffTr.insert(new StringBuilder(word).reverse().toString(),index++);
		}
	}

	public int f(String prefix, String suffix) {
		ArrayList<Integer> preMatch = preTr.startsWith(prefix);
		ArrayList<Integer> suffMatch = suffTr.startsWith(new StringBuilder(suffix).reverse().toString());
	
		int i=preMatch.size()-1;
		int j=suffMatch.size()-1;
		while(i>=0 && j>=0) {
			if (preMatch.get(i).equals(suffMatch.get(j))) {
				return preMatch.get(i);
			}
			else if (preMatch.get(i)>suffMatch.get(j)) {
				i--;
			}
			else {
				j--;
			}
		}
		return -1;
	}
}

class Trie {
	Trie[] t;
	ArrayList<Integer> indexList;

	Trie() {
		t = new Trie[26];
		indexList = new ArrayList<Integer>();
	}

	public void insert(String s, int index) {
		Trie root = this;
		for (Character c : s.toCharArray()) {
			if (root.t[c - 'a'] == null)
				root.t[c - 'a'] = new Trie();
			root = root.t[c - 'a'];
			root.indexList.add(index);

		}
	}

	public ArrayList<Integer> startsWith(String s) {
		Trie root = this;
		for (Character c : s.toCharArray()) {
			if (root.t[c - 'a'] == null)
				return new ArrayList<Integer>();
			root = root.t[c - 'a'];

		}
		return root.indexList;
	}
}
public class P_0745_Prefix_and_Suffix_Search {

	public static void main(String[] args) {
		WordFilter hand = new WordFilter(new String [] {"apple","ape","applet"});
		int ans = hand.f("a", "t");
		System.out.println(ans);
	}

}
