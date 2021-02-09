package com.ssafy.Live._210208.LinkedList;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addLastNode("장지은");
		System.out.println(list.getLastNode());
		list.printList();
		
		list.addLastNode("당현아");
		list.printList();
		
		list.addFirstNode("김민정");
		list.printList();
		
		Node prenode = list.getNode("장지은");
		list.insertAfterNode(prenode, "서요셉");
		list.printList();
		
		System.out.println(list.getPreviousNode(list.getNode("당현아")));
		
		list.deleteNode("장지은");
		list.printList();
		list.deleteNode("당현아");
		list.printList();
		list.deleteNode("김민정");
		list.printList();
		list.deleteNode("서요셉");
		list.printList();
		/*prenode = null;
		list.insertAfterNode(prenode, "채승협");*/
	}

}
