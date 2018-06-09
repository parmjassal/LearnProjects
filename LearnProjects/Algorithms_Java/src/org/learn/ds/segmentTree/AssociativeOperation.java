package org.learn.ds.segmentTree;

/*
	To support Operations having associative properties
	A+B=B+A (Not true for String's)
	A*B=B*A
	MAX(A,B)=MAX(B,A)
	MIN(A,B)=MIN(B,A)
	
	Each operation will provide it's operate implementation.
	Operation needs to check validity of it's operand as well. Like String can't be used for A+B=B+A 
*/
public interface AssociativeOperation<T> {
	
	T operate(T a,T b) throws InvalidOperandException;
	T getIdentityObject();
}
