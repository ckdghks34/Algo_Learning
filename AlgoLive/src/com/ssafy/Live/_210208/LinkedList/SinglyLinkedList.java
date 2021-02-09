package com.ssafy.Live._210208.LinkedList;

public class SinglyLinkedList {

	private Node head;

	// 연결리스트에 첫번째 원소로 삽입하기
	public void addFirstNode(String data) {
		Node newNode = new Node(data, head);
		head = newNode;
	}

	// 연결리스트의 마지막 원소 찾기
	public Node getLastNode() {
		Node CurrNode = head;
		if (CurrNode != null) {
			while (CurrNode.link != null)
				CurrNode = CurrNode.link;
		}
		return CurrNode;
	}

	// 연결리스트에 마지막 원소로 삽입하기
	public void addLastNode(String data) {
		if (head == null) {
			addFirstNode(data);
			return;
		}
		Node lastNode = getLastNode();
		Node newNode = new Node(data);
		lastNode.link = newNode;
	}

	// 연결리스트의 중간에 삽입하기
	public void insertAfterNode(Node preNode, String data) {
		if (preNode == null) {
			System.out.println("선행노드가 없어 삽입이 불가능합니다.");
			return;
		}
		Node newNode = new Node(data, preNode.link);
		preNode.link = newNode;
	}
	public Node getNode(String data) {
		for(Node currNode=head;currNode !=null ; currNode = currNode.link) {
			if(currNode.data.equals(data)) {
				return currNode;
			}
		}
		return null;
	}
	public Node getPreviousNode(Node target) {
		Node currNode = head,nextNode=null;
		
		if(currNode != null) {
			while((nextNode = currNode.link) != null)
			{
				if(nextNode == target) {
					return currNode;
				}
				currNode = nextNode;
			}
		}
		return null;
	}
	
	public void deleteNode(String data)
	{
		if(head == null)
		{
			System.out.println("공백 리스트이기 때문에 삭제가 불가능합니다.");
			return;
		}
		Node targetNode = getNode(data);
		if(targetNode == null) return;
		
		Node preNode = getPreviousNode(targetNode);
		
		if(preNode == null && targetNode == head)
			head = targetNode.link;
		else
			preNode.link = targetNode.link;
		
		targetNode.link = null;
	}
	
	public void printList() {
		System.out.print("L = (");
		for(Node currNode =head; currNode != null; currNode = currNode.link)
			System.out.print(currNode.data +" ");
		System.out.println(")");
	}
}
