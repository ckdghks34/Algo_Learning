package com.ssafy.exSoftAcademy._210208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_5215_햄버거다이어트 {

	static int[][] material;
	static int T;
	static int N;
	static int L;
	static int max;
	static int sum;
	static boolean[] visited;
	
	static void selectedMaterial(int cnt, int s, int k) {
		if (k > L)
			return;

		if (cnt == N) {
			max = Math.max(max, s);
			return;
		}
		
		selectedMaterial(cnt + 1, s + material[cnt][0], k + material[cnt][1]);
	
		selectedMaterial(cnt + 1, s, k);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			material = new int[N][2];
			visited = new boolean[N];

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 2; ++j) {
					material[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			selectedMaterial(0, 0, 0);
			System.out.println("#" + tc + " " + max);
		}
	}
}
