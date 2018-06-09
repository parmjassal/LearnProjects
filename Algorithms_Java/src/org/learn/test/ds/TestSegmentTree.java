package org.learn.test.ds;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.learn.ds.segmentTree.AssociativeOperation;
import org.learn.ds.segmentTree.InvalidOperandException;
import org.learn.ds.segmentTree.SegmentTree;
import org.learn.ds.segmentTree.SumOperation;

class TestSegmentTree {

	int array[];
	AssociativeOperation<Integer> operation;
	SegmentTree<Integer> segmentTree;
	
	public void setUp() throws Exception {
		array = new int[8];
		for(int i=0;i<8;i++)
			array[i]=i+1;
		operation = new SumOperation<>();
		segmentTree = new SegmentTree<>(operation, array.length, Integer.class);
	}

	@Test
	public void test() throws Exception {
		setUp();
		addArray();
		assertEquals((int)36, (int)segmentTree.query(0, 7));
	}
	
	private void addArray() throws InvalidOperandException {
		for(int i=0;i<array.length;i++)
			segmentTree.add(i, array[i]);
	}

}
