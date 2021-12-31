package com.ssafy.Baekjoon._211231;

import java.io.*;
import java.util.*;

public class Main_G5_1916_최소비용구하기 {

	public static int N, M;
	public static int[][] map;
//	public static final int Inf = 100001;
//	public static final int Inf = Integer.MAX_VALUE/2;
	public static final int Inf = (100000 * 100000);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N + 1];

		// 모든 경로를 Inf로 초기화
		// 단, 같은곳에서 같은곳으로 가는 경로는 0
		for (int i = 0; i < N + 1; ++i) {
			Arrays.fill(map[i], Inf);
			map[i][i] = 0;
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if (map[from][to] != Inf) {
				map[from][to] = map[from][to] < weight ? map[from][to] : weight;
			} else {
				map[from][to] = weight;
			}
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; ++i)
			distance[i] = map[start][i];

		visited[start] = true;

		for (int i = 0; i <= N; ++i) {
			int min = Inf, current = 1;

			// 가장 가까운 정점 찾기
			for (int j = 0; j < N + 1; ++j) {
				if(!visited[j] && distance[j] < min) {
					current = j;
					min = distance[j];
				}
			}
			
			visited[current] = true;
			
			for(int j = 0; j < N+1;++j)
			{
				if(map[current][j] != Inf && map[current][j] + distance[current] < distance[j])
					distance[j] = map[current][j] + distance[current];
			}
		}

		sb.append(distance[end]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
