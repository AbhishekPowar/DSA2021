package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import datastructures.Tree;
import datastructures.TreeNode;

public class P_0538_Convert_BST_to_Greater_Tree {
	public TreeNode convertBST(TreeNode root) {
		Map<Integer, Integer> hmap= new TreeMap<>();
		this.dfs(root,hmap);
		int sum=0;
		int last=0;
		for(Integer key: hmap.keySet()){
			sum+=key;
			hmap.put(key, sum);
			last=key;
		}
		this.greatSum(root, hmap, last);
		return root;
	}
	public void greatSum(TreeNode root, Map<Integer,Integer> hmap,int last){
		if (root!=null) {
			root.val+= hmap.get(last)-hmap.get(root.val);
			this.greatSum(root.left,hmap, last);
			this.greatSum(root.right,hmap, last);
		}
	}
	public void dfs(TreeNode root,Map<Integer,Integer> hmap){
		if (root!=null) {
			hmap.put(root.val,0);
			this.dfs(root.left,hmap);
			this.dfs(root.right,hmap);
		}
	}

	public static void main(String[] args) {
		Tree t = new Tree(Arrays.asList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8));
		t.print();
		
		
		P_0538_Convert_BST_to_Greater_Tree handler = new P_0538_Convert_BST_to_Greater_Tree();
		TreeNode r =handler.convertBST(t.root);
		Tree greatSum = new Tree();
		greatSum.root=r;
		greatSum.print();
	}

}
