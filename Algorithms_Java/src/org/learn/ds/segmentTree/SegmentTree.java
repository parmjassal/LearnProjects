package org.learn.ds.segmentTree;

import java.lang.reflect.Array;

public class SegmentTree<T> {

	private AssociativeOperation<T> operation;
	private int capacity;
	private T segmentArray[];
	private int numOfLeaf;
	
	@SuppressWarnings("unchecked")
	public SegmentTree(AssociativeOperation<T> operation, int capacity,Class<T> classType) {
		super();
		this.operation = operation;
		this.capacity = capacity;
		//Number of leaf required to accommodate capacity. Using Ceiling and will result in some unused leaves.
		numOfLeaf = (int)Math.pow(2,Math.ceil(Math.log(capacity)));
		this.segmentArray = (T[])Array.newInstance(classType, 2*numOfLeaf);
	}
	
	/*
	 *  
	 * 
	*/
	public void add(int index,T toAdd) throws InvalidOperandException {
		for(int i=index+numOfLeaf;i>0;i/=2) {
			segmentArray[i] = operation.operate(segmentArray[i], toAdd);
		}
	}
	
	/*
	 * Both Low and High are inclusive
	*/
	public T query(int low,int high) throws InvalidOperandException {
		return recusiveQuery(low+numOfLeaf, high+numOfLeaf);
	}
	
	private T recusiveQuery(int low,int high) throws InvalidOperandException {
		
		if(low==high)
			return segmentArray[low];
		
		boolean isLowOdd = (low&1)==1?true:false;
		boolean isHighOdd = (high&1)==1?true:false;
		T result = recusiveQuery(isLowOdd? (low+1)/2 : low/2, isHighOdd? high/2: (high-1)/2);
		if(isLowOdd)
			result = operation.operate(segmentArray[low], result);
		if(!isHighOdd)
			result = operation.operate(segmentArray[high], result);
		return result;
	}
	
}
