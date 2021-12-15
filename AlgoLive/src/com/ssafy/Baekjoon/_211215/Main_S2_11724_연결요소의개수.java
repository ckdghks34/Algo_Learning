package com.ssafy.Baekjoon._211215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_11724_연결요소의개수 {

	public static int N, M;
	public static int[][] map;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 입력값(String) to Int
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// Map 이차원배열 할당 (1부터 시작이기 때문에 입력값+1)
		map = new int[N + 1][N + 1];
		
		// 정점 방문 확인 배열
		visited = new boolean[N + 1];
		
		// 연결된 요소 갯수를 출력
		// ex) 3 5 6 / 1 2 4 << 연결되어 있다고 가정 했을 때 2개
		// ex) 1 2 / 3 4 / 5 6 << 연결된 요소 갯수 : 3개
		int count = 0;

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = 1;
			map[y][x] = 1;
		}

		for (int i = 1; i <= N; ++i) {
			// 아직 정점에 방문하지 않았다면,
			if (!visited[i])
			{
				count++;
				dfs(i);
			}
		}
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int x) {
		// 해당 정점에 방문을 했다면 종료
		if (visited[x])
			return;

		// 정점에 방문
		visited[x] = true;
		
		// 특정 정점과 다른 모든 정점을 비교
		for (int i = 1; i <= N; ++i) {
			// 자기 자신을 연결할 수 없기 때문에 다음으로 넘어감.
			if (i == x)
				continue;
			// 정점끼리 연결되어 있고, 연결된 정점을 방문 하지 않았다면
			if (map[x][i] == 1 && !visited[i])
				dfs(i);
		}
	}
}
