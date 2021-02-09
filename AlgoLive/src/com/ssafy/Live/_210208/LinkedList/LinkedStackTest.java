package com.ssafy.Live._210208.LinkedList;

public class LinkedStackTest {

	public static void main(String[] args) {
		IStack s = new LinkedStack();
		
		s.push("이상민");
		s.push("손현주");
		s.push("이지수");
		System.out.println(s);
		System.out.println();
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		
	}

}
