package leetcode;

import java.util.HashMap;
import java.util.Map;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

class P_0138_Copy_List_with_Random_Pointer {
	public Node copyRandomList(Node head) {
		Node headCopy = new Node(0);
		Node cur = head;
		Map<Node, Node> hmap = new HashMap<>();
		Node temp;
		Node next;
		while (cur != null) {
			temp = new Node(cur.val);
			next = cur.next;
			cur.next = temp;
			temp.next = next;
			cur = next;
		}

		cur = head;

		while (cur != null && cur.next != null) {
			temp = cur.next;
			if (cur.random != null)
				temp.random = cur.random.next;
			cur = cur.next.next;
		}
		cur = head;
		Node curCopy = headCopy;
		while (cur != null) {
			temp = cur.next;
			curCopy.next = temp;
			cur.next = temp.next;
			curCopy = curCopy.next;
			temp.next = null;
			cur = cur.next;

		}
		return headCopy.next;
	}
	//Solution with hash Map
	public Node copyRandomListHashMap(Node head) {
		Node headCopy = new Node(0);
		Node cur = head;
		Node curCopy = headCopy;
		Map<Node, Node> hmap = new HashMap<>();
		while (cur != null) {
			curCopy.next = new Node(cur.val);
			hmap.put(cur, curCopy.next);
			cur = cur.next;
			curCopy = curCopy.next;

		}
		headCopy = headCopy.next;

		cur = head;
		curCopy = headCopy;
		while (cur != null) {
			curCopy.random = hmap.get(cur.random);
			cur = cur.next;
			curCopy = curCopy.next;
		}
		return headCopy;
	}
}