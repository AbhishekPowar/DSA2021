import java.util.ArrayList;

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