package com.ssafy.Live._210316.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6 
 */

public class G2_AdjListTest {
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

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [vertex=").append(vertex).append(", next=").append(next).append("]");
			return builder.toString();
		}

	}

	static int N;
	static ArrayList<Integer>[] adjList;

	static boolean[] isVisted;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int C = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			adjList[i]= new ArrayList<Integer>();
		}
		
		
		StringTokenizer st = null;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}

		bfs();
		System.out.println();
		
		isVisted = new boolean[N];
		dfs(0);
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		int start = 0;
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print((char) (current + 65));

			for (int tmp : adjList[current]) { // tmp : current와 인접정점인 해당정점 번호
				if(!visited[tmp])
				{
					queue.offer(tmp);
					visited[tmp] = true;
				}
			}
		}
	}
	
	private static void dfs(int current) {
		isVisted[current] = true;
		System.out.print((char)(current+65));
		
		for(int tmp : adjList[current])
		{
			if(!isVisted[tmp])
			{
				dfs(tmp);
			}
		}
	}
}