package org.learn.ds.intervalTree;

public class IntervalTree<T extends Comparable<T>> implements Overlap<T>, RangeTree<T> {

	Node<T> root = null;

	@Override
	public int noOfOverlap(T tlow, T thigh) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isOverlap(T tlow, T thigh) {
		// TODO Auto-generated method stub
		Node<T> temp = root;
		Node<T> node = new Node<T>(tlow, thigh);
		
		while(temp!=null) {
			if(temp.isOverlap(node))
				return true;
			if(temp.getLeft()!=null && temp.getLeft().getMax().compareTo(node.gettLow())>0)
				temp = temp.getLeft();
			else
				temp = temp.getRight();
		}
		return false;
	}

	@Override
	public void addTree(T tLow, T tHigh) {
		// TODO Auto-generated method stub
		Node<T> node = new Node<T>(tLow, tHigh);

		if (root == null)
		{
			root = node;
			return ;
		}
		addNode(node);
	}

	private void addNode(Node<T> node) {
		int max = Integer.MIN_VALUE;
		Node<T> temp = root;

		while (temp != null) {
			if (node.gettHigh().compareTo(temp.getMax()) > 0)
				temp.setMax(node.gettHigh());

			if (temp.gettLow().compareTo(node.gettLow()) > 0) {
				if (temp.getLeft() != null)
					temp = temp.getLeft();
				else
				{
					temp.setLeft(node);
					return;
				}
			} else {
				if (temp.getRight() != null)
					temp = temp.getRight();
				else
				{
					temp.setRight(node);
					return;
				}
			}

		}
	}

	private class Node<T extends Comparable<T>> {

		T tLow;
		T tHigh;
		T max;

		Node<T> left;
		Node<T> right;

		public Node(T tLow, T tHigh) {
			super();
			this.tLow = tLow;
			this.tHigh = tHigh;
			this.max = tHigh;
		}

		public T getMax() {
			return max;
		}

		public void setMax(T max) {
			this.max = max;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

		public T gettLow() {
			return tLow;
		}

		public T gettHigh() {
			return tHigh;
		}

		public boolean isOverlap(Node<T> n) {
			if(this.tLow.compareTo(n.tHigh) * this.tHigh.compareTo(n.tLow)<0)
				return true;
			
			return false;
		}
		
	}

}
