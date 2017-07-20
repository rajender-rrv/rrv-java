package com.ds.algorithms.test;

import com.ds.algorithms.list.LinkedList;
import com.ds.algorithms.list.LinkedList.Node;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		list.add("seven");
		list.add("eight");
		list.add("nine");

		printLinkedList(list);

		Object middleValue = findMiddle(list);
		System.out.println("middleValue: " + middleValue);

		Object findIndexedNodeFromLast = findIndexedNodeFromLast(list, list.size() - 1);
		System.out.println("findIndexedNodeFromLast: " + findIndexedNodeFromLast);

		list.reverseLinkedList();

		System.out.println("Reversed list: ");
//		printLinkedList(list);

	}



	private static void printLinkedList(LinkedList<String> list) {
		if (list == null || list.size() == 0) {
			System.out.println("No Data Found");
			return;
		}
		if (list.size() == 1) {
			System.out.println(list.get().getValue());
			return;
		}

		Node node = list.get();
		while (node != null) {
			Object value = node.getValue();
			System.out.println(value);
			node = node.getNext();
		}
	}

	private static Object findIndexedNodeFromLast(LinkedList<String> list, int lastIndex) {

		if (list == null || list.size() == 0) {
			return null;
		}
		if (lastIndex == list.size() - 1) {
			return list.get().getValue();
		}
		Node node = list.get();
		Node resultNode = list.get();

		int count = 0;
		while (node != null) {
			if (++count > lastIndex) {
				resultNode = resultNode.getNext();
			}
			node = node.getNext();
		}
		return resultNode.getValue();
	}

	private static Object findMiddle(LinkedList<String> list) {
		Node node = list.get();
		Node middleNode = list.get();

		int count = 0;
		while (node != null) {
			if (++count % 2 == 0) {
				middleNode = middleNode.getNext();
			}
			node = node.getNext();
		}
		return middleNode.getValue();
	}

}
