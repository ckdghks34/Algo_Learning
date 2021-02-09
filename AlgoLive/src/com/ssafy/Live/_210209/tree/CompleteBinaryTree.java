package com.ssafy.Live._210209.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	
	private char[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		super();
		SIZE = size;
		nodes = new char[size+1];
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(char e) {
		if(isFull())
		{
			System.err.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		
		if(isEmpty())
			return;
		
		// 탐색 순서번호
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		int current;
		
		while(!queue.isEmpty())
		{
			current = queue.poll();
			System.out.println(nodes[current]);
			if(current * 2 <= lastIndex)
				queue.offer(current*2);
			if(current*2+1 <= lastIndex)
				queue.offer(current*2+1);
		}
	}
	
	public void bfs2() {
		
		if(isEmpty())
			return;
		
		// 탐색 순서번호
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		int current,size,level=0;
		
		while(!queue.isEmpty())
		{
			size = queue.size();
			System.out.print("level " +level +" : ");
			while(--size>=0)
			{
			current = queue.poll();
			System.out.print(nodes[current]);
			
			if(current * 2 <= lastIndex)
				queue.offer(current*2);
			if(current*2+1 <= lastIndex)
				queue.offer(current*2+1);
			}
			System.out.println();
			++level;
		}
	}
	
	public void dfs(int current) {
		if(current>lastIndex) return;
		//VLR
		System.out.println(nodes[current]);
		dfs(current*2);
		dfs(current*2+1);
	}
	
	public void dfs2(int current) {
		if(current>lastIndex) return;
		//LVR
		dfs(current*2);
		System.out.println(nodes[current]);
		dfs(current*2+1);
	}
	public void dfs3(int current) {
		if(current>lastIndex) return;
		//LRV
		dfs(current*2);
		dfs(current*2+1);
		System.out.println(nodes[current]);
	}
	
}
