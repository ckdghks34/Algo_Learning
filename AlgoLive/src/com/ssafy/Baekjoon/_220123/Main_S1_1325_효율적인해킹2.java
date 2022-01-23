package com.ssafy.Baekjoon._220123;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1325_효율적인해킹2 {
	public static int N, M;
	public static int max = 0;
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static int[] answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[N + 1];

		for (int i = 0; i <= N; ++i)
			list.add(new ArrayList<>());

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list.get(from).add(to);
		}

		for (int i = 1; i <= N; ++i) {
			bfs(i);
//			boolean[] visited = new boolean[N + 1];
//			dfs(i, i, visited);
		}

		for (int i = 1; i <= N; ++i)
			max = Math.max(max, answer[i]);

		for (int i = 1; i <= N; ++i) {
			if (max == answer[i])
				sb.append(i).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

//	public static void dfs(int node, int start, boolean[] visited) {
//		visited[node] = true;
//
//		int size = list.get(node).size();
//		for (int i = 0; i < size; ++i) {
//			int next = list.get(node).get(i);
//
//			if (!visited[next]) {
//				dfs(next, start, visited);
//				answer[start]++;
//			}
//		}
//
//	}

	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		visited[node] = true;
		queue.offer(node);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 0; i < list.get(current).size(); ++i) {
				int next = list.get(current).get(i);

				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
					answer[next]++;
				}
			}
		}
	}
}
