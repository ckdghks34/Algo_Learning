package com.ssafy.Baekjoon._220105;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_13549_숨바꼭질3 {
	public static int N, K;
	public static int count = 0;
	static final int max = 100001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		count = bfs(N);

		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}

	public static int bfs(int N) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		queue.offer(new int[] { N, 0 });
		
		int min = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int cnt = current[1];
			visited[x] = true;
			
			if (x == K)
				min = min > cnt ? cnt : min;

			// 순간이동 한다면
			if (x * 2 < max && !visited[x * 2]) {
				queue.offer(new int[] { x * 2, cnt });
			}

			// 앞으로 전진
			if (x < max - 1) {
				// K가 x보다 작고 방문하지 않았을 때
				if (x < K && !visited[x + 1]) {
					queue.offer(new int[] { x + 1, cnt + 1 });
				}
			}
			// 뒤로 후진
			if (0 < x) {
				if (!visited[x - 1]) {
					queue.offer(new int[] { x - 1, cnt + 1 });
				}
			}
		}
		return min;
	}
}
