package com.ssafy.Live_210421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_5643_키_순서_DFS3 {

	static int N, M, adj[][];
	static int gtCnt, ltCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1];
			StringTokenizer st;
			int i, j;
			for (int m = 0; m < M; ++m) {
				st = new StringTokenizer(br.readLine(), " ");
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1; // i는 j보다 키가 작다.
			} // 친구 키 관계를 인접행렬 대입
			int ans = 0;
			for (int k = 0; k <= N; ++k) {
				gtCnt = ltCnt = 0;
				gtDFS(k, new boolean[N + 1]); // 자신보다 큰 학생 탐색
				ltDFS(k, new boolean[N + 1]); // 자신보다 작은 학생 탐색
				if (gtCnt + ltCnt == N - 1) // 자신의 키순서를 알수 있는 학생
					++ans;
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static void gtDFS(int cur, boolean[] visited) {
		visited[cur] = true;

		for (int i = 1; i <= N; ++i) {
			if (!visited[i] && adj[cur][i] == 1) {
				gtDFS(i, visited);
				gtCnt++;
			}
		}
	}

	private static void ltDFS(int cur, boolean[] visited) {
		visited[cur] = true;

		for (int i = 1; i <= N; ++i) {
			if (!visited[i] && adj[i][cur] == 1) {
				ltDFS(i, visited);
				ltCnt++;
			}
		}
	}
}
