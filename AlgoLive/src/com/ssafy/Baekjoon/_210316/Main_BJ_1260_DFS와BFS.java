package com.ssafy.Baekjoon._210316;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS {

	static int N, M, V;
	static boolean[][] map;
	static boolean[] isVisited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			map[from][to] = true;
			map[to][from] = true;
		}
		
		isVisited = new boolean[N+1];
		dfs(V);
		
		System.out.println();
		bfs(V);
		
		
		
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			// 현재 정점에 관련된 처리
			System.out.print(current + " ");

			// 인접정점 탐색
			for(int i =0 ; i <= N; i++) {
				if(map[current][i] && !visited[i])
				{
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	private static void dfs(int current) {
		isVisited[current] = true;
		System.out.print(current + " ");
		
		for (int i = 0; i <= N; i++) {
			if(map[current][i]&&!isVisited[i])
				dfs(i);
		}
	}
}
