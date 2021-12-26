package com.ssafy.Baekjoon._211226;

import java.util.*;
import java.io.*;

public class Main_S1_1926_그림 {

	public static int N, M;
	public static int areaMax = 0;
	public static int tmparea = 0;
	public static int[][] picture;
	public static boolean[][] visited;

	// 상하좌우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		picture = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; ++j)
				picture[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if(picture[i][j] > 0 && !visited[i][j])
				{
					count++;
					tmparea = 1;
					dfs(i,j);
				}
			}
		}
		sb.append(count).append("\n");
		sb.append(areaMax);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dfs(int y, int x) {
		if(visited[y][x])
			return;
		
		visited[y][x] = true;
		
		for(int i =0 ; i < 4; ++i)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < M && ny < N)
			{
				if(picture[ny][nx] == 1 && !visited[ny][nx])
				{	dfs(ny, nx);
					tmparea++;
				
				}
			}
		}
		
		if(tmparea > areaMax)
			areaMax = tmparea;
	}
}
