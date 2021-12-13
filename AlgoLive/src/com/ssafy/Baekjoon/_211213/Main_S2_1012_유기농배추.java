package com.ssafy.Baekjoon._211213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_1012_유기농배추 {
	public static int T;
	public static int N, M, K;
	public static int[][] map;
	public static boolean[][] visited;
	public static StringBuilder sb= new StringBuilder();
	//상 하 좌 우
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];
			int count = 0;

			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine(), " ");

				int j = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());

				map[k][j] = 1;
			}

			for (int i = 0; i < M; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j] == 1 && !visited[i][j]) {
						count++;
						dfs(i,j);
					}
				}
			}
			sb.append(count);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dfs(int i, int j) {
		
		visited[i][j] = true;
		
		for(int k =0 ; k < 4; ++k)
		{
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if((nx >= 0 && ny >= 0 && nx < M && ny < N) && !visited[nx][ny])
			{
				if(map[nx][ny] == 1)
				dfs(nx,ny);
			}
		}
	}
}
