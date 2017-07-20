package com.ds.algorithms.list;


public class LinkedList<N> {
	private int size;
	private Node<N> head;
	private Node<N> current;

	public LinkedList() {
	}

	public LinkedList(int size) {
		this.size = size;
	}

	public Node get() {
		return head;
	}

	public int size() {
		return size;
	}

	public void add(N value) {
		Node<N> newNode = new Node(value, null);
		if (null != current) {
			current.next = newNode;
			current = newNode;
		} else if (null == current) {
			current = newNode;
			head = newNode;
		}
		size++;
	}

	public void addFirst(N value) {
		Node<N> firstNode = new Node<N>(value, null);
		if (null != head) {
			firstNode.next = head;
			head = firstNode;
		} else if (null == current) {
			current = firstNode;
			head = firstNode;
		}
	}

	public boolean add(N value, int index) {
		if (index > size - 1 || index <= 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (null == head) {
			head = new Node<N>(value);
			current = head;
			return true;
		}
		Node node = head.next;
		int count = -1;
		while (null != node) {
			if (count == (index - 1)) {
				Node newNode = new Node<N>(value);
				Node nextNode = node.next;
				node.next = newNode;
				newNode.next = nextNode;
				return true;
			}
			node = node.next;
			count++;
		}
		return false;
	}

	public void reverseLinkedList() {
		Node<N> prevNode = null;
		Node<N> nextNode = null;
		Node<N> node = head;

		if (head == null) {
			return;
		}
		while (null != node) {
			nextNode = node.next;
			node.next = prevNode;
			prevNode = node;
		}
	}

	public class Node<N> {
		N value;
		Node next;

		Node() {

		}

		Node(N value) {
			this.value = value;
		}

		Node(N value, Node next) {
			this.value = value;
			this.next = next;
		}

		public Object getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

	}
}
