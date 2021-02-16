package com.ssafy.Live._210215.compare;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// Comparable을 구현하게되면 우선적으로 적용된다.
		PriorityQueue<Student> pQueue = new PriorityQueue<>();
		pQueue.offer(new Student(4,20));
		pQueue.offer(new Student(3,50));
		pQueue.offer(new Student(1,60));
		
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
	}

}
