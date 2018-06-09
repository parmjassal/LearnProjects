package org.learn.test.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.learn.ds.segmentTree.InvalidOperandException;
import org.learn.ds.segmentTree.SumOperation;

public class AssociativeTest {

	@Test
	public void testInteger() throws InvalidOperandException {

		SumOperation<Integer> operation = new SumOperation<>();
		assertEquals((int) 30, (int) operation.operate(10, 20));

	}

	@Test
	public void testFloat() throws InvalidOperandException {

		SumOperation<Float> operation = new SumOperation<>();
		assertEquals((float) 30.0, (float) operation.operate(10.0f, 20.0f));

	}

}
