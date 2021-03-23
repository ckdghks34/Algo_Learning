package com.ssafy.exSoftAcademy._210316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWTest_1238_Contact {

	static class Node {
		int vertex;
		Node next;

		public Node(int vertex) {
			this.vertex = vertex;
		}

		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}

	}

	static int length, start;
	static int index, max;
	static Node[] list;

	static boolean[] isVisted;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			max = Integer.MIN_VALUE;
			index = -1;
			length = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			list = new Node[101];
			st = new StringTokenizer(br.readLine()," ");
			
			for(int i =0, size = length/2; i < size;++i)
			{
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				list[from] = new Node(to,list[from]);
			}
			bfs();
			System.out.println("#"+tc+" "+index);
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);

		int[] visited = new int[101];
		visited[start] = 1;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			
			if (visited[current] > max) {
				max = visited[current];
				index = current;
			}
			if (visited[current] == max)
				index = Math.max(index, current);
			for (Node tmp = list[current]; tmp != null; tmp = tmp.next) {
				if (visited[tmp.vertex] == 0) {
					queue.offer(tmp.vertex);
					visited[tmp.vertex] = visited[current] + 1;
				}
			}
		}

	}
}
