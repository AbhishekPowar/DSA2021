package datastructures;

import java.util.Arrays;
import java.util.List;

public class Tree {

	public TreeNode root;

	Tree() {

	}

	public Tree(List<Integer> order) {
		int maxLen = order.size();
		TreeNode[] orderArray = new TreeNode[maxLen];
		for (int index = 0; index < maxLen; index++) {
			if (order.get(index) != null) {
				orderArray[index] = new TreeNode(order.get(index));
			} else {
				orderArray[index] = null;
			}
		}
		int nonNullIndex = -1;
		TreeNode curNode;
		int left, right;
		for (int i = 0; i < maxLen; i++) {
			if (orderArray[i] == null) {
				continue;

			}
			nonNullIndex += 1;
			curNode = orderArray[i];
			left = 2 * nonNullIndex + 1;
			right = 2 * nonNullIndex + 2;

			if (left < maxLen) {
				curNode.left = orderArray[left];
			}
			if (right < maxLen) {
				curNode.right = orderArray[right];
			}

		}
		this.root = orderArray[0];
	}

	public static void printBinaryTree(TreeNode root, int level){
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	        System.out.println("|-------"+root.val);
	    }
	    else
	        System.out.println(root.val);
	    printBinaryTree(root.left, level+1);
	}  
	
	public void print(){
		printBinaryTree(this.root, 0);
	}

	
	
	

}
