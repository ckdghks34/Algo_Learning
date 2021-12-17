package com.ssafy.Baekjoon._211218;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S1_2583_영역구하기 {

	public static int M, N, K;
	public static int[][] map;
	public static boolean[][] visited;

	// 상 하 좌 우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> list = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];

		int areaCount = 0;

		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			for (int y = y1; y <= y2; ++y) {
				for (int x = x1; x <= x2; ++x) {
					map[y][x] = 1;
				}
			}
		}
		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 0 && !visited[i][j]) {
					areaCount++;
					list.add(dfs(i, j, 1));
				}
			}
		}
		Collections.sort(list);
		sb.append(areaCount).append("\n");
		
		while(!list.isEmpty())
			sb.append(list.poll()).append(" ");
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	public static int dfs(int y, int x, int count) {

		visited[y][x] = true;

		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (map[ny][nx] == 0 && !visited[ny][nx]) {
					count = dfs(ny, nx, count + 1);
				}
			}
		}
		return count;
	}
}
