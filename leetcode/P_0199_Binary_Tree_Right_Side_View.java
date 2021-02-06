package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import datastructures.*;

public class P_0199_Binary_Tree_Right_Side_View {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, 0,res);
		
		return res;
	}

	public void dfs(TreeNode root, int depth, List<Integer> res) {
		if (root!=null) {
			if (depth==res.size()) {
				res.add(root.val);
			}
			dfs(root.right,depth+1,res);
			dfs(root.left,depth+1,res);
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree(Arrays.asList(1, 2, 3, null, 5, null, 4, 7, 8));
		tree.print();
		P_0199_Binary_Tree_Right_Side_View handler = new P_0199_Binary_Tree_Right_Side_View();
		
		List<Integer> res = handler.rightSideView(tree.root);
		System.out.println(res);
	}

}
