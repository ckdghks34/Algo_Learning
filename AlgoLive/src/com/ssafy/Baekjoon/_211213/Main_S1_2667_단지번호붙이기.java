package com.ssafy.Baekjoon._211213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

public class Main_S1_2667_단지번호붙이기 {

	public static StringBuilder sb = new StringBuilder();
	public static int N;
	public static int[][] map;
	public static boolean[][] visited;

	// 상하좌우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Integer> list = new LinkedList<>();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			for (int j = 0; j < N; ++j) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 1)
				{
					int count = dfs(i, j, 0);
					if(count != 0)
						list.add(count);
				}
			}
		}
		Collections.sort(list);
		
		sb.append(list.size());
		sb.append("\n");
		while(!list.isEmpty())
		{
			sb.append(list.poll());
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int dfs(int i, int j, int count) {
		if (visited[i][j])
			return 0;

		visited[i][j] = true;
		count++;
		for (int k = 0; k < 4; ++k) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if ((nx >= 0 && nx < N && ny >= 0 && ny < N) && !visited[nx][ny]) {
				if (map[nx][ny] == 1)
					count = dfs(nx, ny, count);
			}
		}
		return count;
	}
}
