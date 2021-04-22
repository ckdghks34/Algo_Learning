package com.ssafy.Live_210421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_5643_키_순서_DFS_GT {

	static int N, M, adj[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N + 1][N + 1];

			for (int i = 0; i <= N; ++i)
				adj[i][0] = -1; // 자신보다 큰 학생을 아직 탐색하지 않은 상태의 초기값

			StringTokenizer st;
			for (int m = 0; m < M; ++m) {
				st = new StringTokenizer(br.readLine(), " ");
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1; // i는 j보다 키가 작다.
			} // 친구 키 관계를 인접행렬 대입

			int ans = 0;

			for (int k = 1; k <= N; ++k) {
				// 메모의 상태를 보고 탐색전이면 자신보다 큰 학생 탐색
				if (adj[k][0] == -1)
					DFS(k);
			}

			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					adj[0][j] += adj[i][j];
				}
			} // 자신보다 작은 학생의 수 카운팅

			for (int k = 1; k <= N; ++k) {
				if (adj[k][0] + adj[0][k] == N - 1)
					++ans;
			}

			System.out.println("#" + tc + " " + ans);
		}

	}

	private static void DFS(int cur) {
		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] == 1) {

				// 아직 탐색하지 않은 학생이면 탐색하러 가기
				if (adj[i][0] == -1)
					DFS(i);

				// i 학생을 탐색하고 왔거나, 이미 탐색이 되어있어서 탐색하지 않고 내려옴.
				if (adj[i][0] > 0) // i 학생보다 큰 학생이 있다면
				{
					for (int j = 0; j <= N; ++j) {
						if (adj[i][j] == 1)
							adj[cur][j] = 1;
					}
				}

			}
		}

		int cnt = 0;
		for (int i = 1; i <= N; ++i)
			cnt += adj[cur][i];

		adj[cur][0] = cnt;
	}
}
