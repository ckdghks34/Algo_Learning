package com.ssafy.Live_210421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_5643_키_순서_DFS2 {

	static int N, M, adj[][];
	static int radj[][];
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1];
			radj = new int[N + 1][N + 1];
			
			StringTokenizer st;
			int i, j;
			for (int m = 0; m < M; ++m) {
				st = new StringTokenizer(br.readLine(), " ");
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				radj[j][i] = adj[i][j] = 1; // i는 j보다 키가 작다.
			} // 친구 키 관계를 인접행렬 대입
			int ans = 0;
			for (int k = 0; k <= N; ++k) {
				cnt = 0;
				DFS(k, adj, new boolean[N + 1]); // 자신보다 큰 학생 탐색
				DFS(k, radj, new boolean[N + 1]); // 자신보다 작은 학생 탐색
				if (cnt == N - 1) // 자신의 키순서를 알수 있는 학생
					++ans;
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static void DFS(int cur, int[][] adj, boolean[] visited) {
		visited[cur] = true;

		for (int i = 1; i <= N; ++i) {
			if (!visited[i] && adj[cur][i] == 1) { // adj에 따라 자신보다 큰 학생을 탐색하거나 자신보다 작은 학생을 탐색하는 의미
				DFS(i, adj, visited);
				cnt++;
			}
		}
	}
}
