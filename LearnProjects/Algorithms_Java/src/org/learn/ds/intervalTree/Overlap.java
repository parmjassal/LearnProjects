package org.learn.ds.intervalTree;

public interface Overlap<T extends Comparable<T>> {
	
	int noOfOverlap(T tlow,T thigh);

	boolean isOverlap(T tlow, T thigh);
	
}
