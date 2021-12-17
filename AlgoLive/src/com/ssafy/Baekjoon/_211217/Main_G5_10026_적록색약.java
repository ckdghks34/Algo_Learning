package com.ssafy.Baekjoon._211217;

import java.io.*;

public class Main_G5_10026_적록색약 {

	public static int N;
	public static int[][] map;
	
	// 상 하 좌 우
	public static int[] dx = { 0,0,-1,1};
	public static int[] dy = { -1,1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int nCount = 0;
		int rgCount = 0;
		boolean[][] nVisited = new boolean[N][N];
		boolean[][] rgVisited = new boolean[N][N];
		
		// 맵 입력
		for (int i = 0; i < N; ++i) {
			String tmp = br.readLine();
			for (int j = 0; j < N; ++j) {
				switch (tmp.charAt(j)) {
				case 'R':
					map[i][j] = 0;
					break;
				case 'G':
					map[i][j] = 1;
					break;
				default:
					map[i][j] = 2;
					break;
				}
			}
		}
		
		// Map을 반복해서 돌면서
		for(int i =0 ;i < N; ++i)
		{
			for(int j =0 ;j < N; ++j)
			{
				// 적록색약이 아닌사람
				// 구역을 체크하지 않았을 경우
				if(!nVisited[i][j])
				{
					nCount++;
					normal(nVisited,i,j,map[i][j]);
				}
				
				// 적록색약인 사람
				// 구역을 체크하지 않았을 경우
				if(!rgVisited[i][j])
				{
					rgCount++;
					rgWeakness(rgVisited, i, j, map[i][j]);
				}
			}
		}
		sb.append(nCount);
		sb.append(" ");
		sb.append(rgCount);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	// 적록색약인 경우 
	// 빨/초, 파 두가지 색으로 구분가능
	public static void rgWeakness(boolean[][] visited,int y, int x,int color) {
		boolean blue = false;
		
		// 현재 구역이 파란색이라면
		if(color == 2)
			blue = true;
		
		visited[y][x] = true;
		
		for(int i =0 ;i < 4; ++i)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N)
			{
				// 현재구역이 파란색이기 때문에 다음구역도 파란색인지 확인해야함.
				if(blue)
				{
					if(map[ny][nx] == 2 && !visited[ny][nx])
						rgWeakness(visited, ny, nx, color);
					
				}
				else
				{
					// 파란색이 아니라면 모두 갈 수 하나의 구역으로 판단.
					if(map[ny][nx] != 2 && !visited[ny][nx])
						rgWeakness(visited, ny, nx, color);
				}
			}
		}
		
	}
	// 적록색약이 아닌 경우
	public static void normal(boolean[][] visited,int y, int x,int color) {
		
		// 구역 방문 처리
		visited[y][x] = true;
		
		for(int i = 0; i < 4; ++i)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// Map을 벗어나지 않았을 경우
			if(nx >= 0 && ny >= 0 && nx < N && ny < N)
			{
				// 빨, 초, 파 모두 구분이 가능
				// 연결되어있고, 같은 색인 구역,방문하지않은 구역 일 경우
				if(map[ny][nx] == color && !visited[ny][nx])
					normal(visited, ny, nx,color);
			}
		}
	}
}
