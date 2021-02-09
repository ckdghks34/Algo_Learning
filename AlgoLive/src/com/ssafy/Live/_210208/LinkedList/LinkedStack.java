package com.ssafy.Live._210208.LinkedList;

public class LinkedStack implements IStack{

	private Node top;
	
	@Override
	public void push(String data) {
		top = new Node(data,top);
	}

	@Override
	public String pop() {
		if(isEmpty())
		{	
			System.err.println("스택이 비어있기 때문에 삭제할 수 없습니다.");
			return null;
		}
		
		/*Node deletenode = top;
		top = top.link;
		deletenode.link = null;
		return deletenode.data;*/
		
		String data = top.data;
		top = top.link;
		return data;
	}

	@Override
	public String peek() {
		if(isEmpty())
		{	
			System.err.println("스택이 비어있어 조회 불가능합니다.");
			return null;
		}
		
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(Node tmp = top; tmp != null ;tmp =tmp.link)
			builder.append(tmp.data).append("->");
		builder.setLength(builder.length()-2);
//		builder.append("LinkedStack [top=").append(top).append("]");
		return builder.toString();
	}
	
}
