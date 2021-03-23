package com.ssafy.Baekjoon._210322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1753_최단경로_인접리스트 {

	public static class Node implements Comparable<Node>{
		int vertax;
		int weight;

		public Node(int vertax, int weight) {
			this.vertax = vertax;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(weight, o.weight);
		}
		
		
	}

	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int[] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()) - 1;

		list = new ArrayList[V];
		visited = new boolean[V];
		distance = new int[V];

		for (int i = 0; i < V; ++i)
			list[i] = new ArrayList<Node>();

		Arrays.fill(distance, Integer.MAX_VALUE);
		

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, weight));
		}
		dijkstra(start);
		
		for(int res : distance)
			{
				if(res == Integer.MAX_VALUE)
					System.out.println("INF");
				else
					System.out.println(res);
			}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0)); // 시작점 queue offer
		distance[start] = 0;
		
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			
			if (visited[current.vertax])
				continue;
			
			visited[current.vertax] = true;

			for (Node tmp : list[current.vertax]) {
				if (distance[tmp.vertax] > distance[current.vertax] + tmp.weight) {
					distance[tmp.vertax] = distance[current.vertax] + tmp.weight;
					queue.offer(new Node(tmp.vertax, distance[tmp.vertax]));
				}
			}
		}
	}
}
