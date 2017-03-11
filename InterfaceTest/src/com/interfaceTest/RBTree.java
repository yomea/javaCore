package com.interfaceTest;

public class RBTree {
	private RBNode head;

	public RBTree(RBNode head, RBTree leftT, RBTree rightT) {
		this.head = head;
		this.head.leftT.head.father = head;
		this.head.rightT.head.father = head;
	}

	public RBTree(RBNode head) {
		this(head, new RBTree(), new RBTree());
	}

	public RBTree() {
		//因为在调用RBTree构造器之前构造RBNode是不允许的，因为RBNode是RBTree的普通内部类，需要先构造外层对象，才能够使用
		this(new RBNode(), null, null);// No enclosing instance of type RBTree
										// is available due to some intermediate
										// constructor invocation
	}

	public class RBNode {
		private int value;
		private boolean isBlack;
		private RBNode father;
		private RBTree leftT;
		private RBTree rightT;
	}
}