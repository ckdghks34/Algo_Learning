package com.ssafy.Baekjoon._211220;

import java.util.*;
import java.io.*;

public class Main_G4_1520_내리막길 {

	public static int M, N;
	public static int[][] map;
	public static int[][] dp;
	// 상 하 좌 우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		dfs(0,0);
		sb.append(dp[0][0]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int dfs(int y, int x) {
		if(y == M-1 && x == N-1) {
			return 1;
		}
		
		if(dp[y][x] > -1)
			return dp[y][x];
		
		dp[y][x] = 0;
		
		for(int i=0; i < 4;++i)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >=0 && ny >= 0 && nx < N && ny < M)
			{
				if(map[y][x] > map[ny][nx])
					dp[y][x] += dfs(ny,nx);
			}
		}
		return dp[y][x];
	}
}
