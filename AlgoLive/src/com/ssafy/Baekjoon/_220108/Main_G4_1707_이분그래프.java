package com.ssafy.Baekjoon._220108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_1707_이분그래프 {
	public static int K, V, E;

	public static ArrayList<ArrayList<Integer>> list;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= K; ++tc) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			boolean graphCheck = true;
			// list 초기화
			list = new ArrayList<>();
			visited = new boolean[V+1];

			// list 배열 초기화
			for (int i = 0; i <= V; ++i)
				list.add(new ArrayList<>());

			for (int i = 0; i < E; ++i) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list.get(from).add(to);
				list.get(to).add(from);
			}

			for (int i = 1; i <= V; ++i) {
				if (!bfs(i)) {
					graphCheck = false;
					break;
				}
			}

			String result = graphCheck ? "YES" : "NO";

			sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean bfs(int vertex) {
		Queue<int[]> queue = new LinkedList<>();
		int[] color = new int[V + 1];

		// 꼭지점, 색(Red : 1, Green : -1)
		queue.offer(new int[] { vertex, 1 });
		visited[vertex] = true;
		color[vertex] = 1;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curVertex = current[0];
			int curColor = current[1];

			for (int i = 0; i < list.get(curVertex).size(); ++i) {
				int nextVertex = list.get(curVertex).get(i);

				if (!visited[nextVertex]) {
					color[nextVertex] = curColor * -1;
					visited[nextVertex] = true;
					queue.offer(new int[] { nextVertex, color[nextVertex] });
				} else {
					if (color[curVertex] == color[nextVertex])
						return false;
				}
			}
		}
		return true;
	}
}
