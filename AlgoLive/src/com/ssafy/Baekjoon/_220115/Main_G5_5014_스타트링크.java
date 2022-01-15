package com.ssafy.Baekjoon._220115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_5014_스타트링크 {
	public static int F, S, G, U, D;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		/*
		 * F : 건물 전체 층수
		 * S : 현재 층수
		 * G : 스타트링크 층수
		 * U : 한번에 올라가는 층수
		 * D : 한번에 내려가는 층수
		 */
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new boolean[F + 1];

		int res = bfs(S);
		String result = res == -1 ? "use the stairs" : Integer.toString(res);

		bw.write(result);
		bw.flush();
		bw.close();
		br.close();

	}

	public static int bfs(int start) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		queue.offer(new int[] { start, 0 });
		visited[start] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int floor = current[0];
			int count = current[1];

			if (floor == G)
				return count;

			int nextUpFloor = floor + U;
			int nextDownFloor = floor - D;

			if (nextUpFloor <= F) {
				if (!visited[nextUpFloor]) {
					queue.offer(new int[] { nextUpFloor, count + 1 });
					visited[nextUpFloor] = true;
				}
			}

			if (nextDownFloor > 0)
				if (!visited[nextDownFloor]) {
					queue.offer(new int[] { nextDownFloor, count + 1 });
					visited[nextDownFloor] = true;
				}
		}
		return -1;
	}
}
