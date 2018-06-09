package org.learn.test.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.learn.ds.segmentTree.AssociativeOperandRegitry;

public class AssociaticeRegistryTest {
	
	@Before
	public void init() {
		AssociativeOperandRegitry.register(Number.class.getName());
	}
	
	@Test
	public void testInteger() {
		assertEquals(true, AssociativeOperandRegitry.isAssociativeOperand(Integer.class.getName()));
	}

}
