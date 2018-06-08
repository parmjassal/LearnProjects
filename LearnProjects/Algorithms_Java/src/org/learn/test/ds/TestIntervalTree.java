package org.learn.test.ds;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learn.ds.intervalTree.IntervalTree;

class TestIntervalTree {

	IntervalTree<Integer> intervalTree;
	
	@BeforeEach
	void setUp() throws Exception {
		
		intervalTree = new IntervalTree<>();
		intervalTree.addTree(15, 20);
		intervalTree.addTree(10, 30);
		intervalTree.addTree(5, 20);
		intervalTree.addTree(12, 15);
		intervalTree.addTree(17, 19);
		intervalTree.addTree(30, 40);
		
	}

	@Test
	void test() {
		
		if(!intervalTree.isOverlap(3, 6) || !intervalTree.isOverlap(39, 60))
			fail("There is overlap");
	}

}
