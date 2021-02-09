package com.ssafy.Live._210208.LinkedList;

public class Node {
	public String data;
	public Node link;
	
	public Node(String data) {
		super();
		this.data = data;
	}

	public Node(String data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [data=").append(data).append(", link=").append(link).append("]");
		return builder.toString();
	}
}
