package leetcode;

import java.util.Iterator;

public class P_0284_Peeking_Iterator implements Iterator<Integer> {
	Integer buffer = null;
	Iterator<Integer> iter;

	public P_0284_Peeking_Iterator(Iterator<Integer> iterator) {
		this.iter = iterator;
		if (this.iter.hasNext()) {
			buffer = this.iter.next();
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return buffer;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer temp = buffer;
		if (this.iter.hasNext()) {
			buffer = this.iter.next();
		} else {
			buffer = null;
		}
		return temp;
	}

	@Override
	public boolean hasNext() {
		return buffer != null;
	}
}