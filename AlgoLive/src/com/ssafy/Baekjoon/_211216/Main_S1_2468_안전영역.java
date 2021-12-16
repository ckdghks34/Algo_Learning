package com.ssafy.Baekjoon._211216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S1_2468_안전영역 {
	public static int N;
	public static int safety;
	public static int max;
	public static int[][] map;
	// 상하좌우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 높이 정보는 1이상 100이하의 정수
		// 강수량이 0일 때 어떠한 지역도 잠기지 않기 때문에 안전지역의 최솟값은 1
		safety = max = 1;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 주어진 지역의 최대 높이 값을 저장한다.
				max = map[i][j] > max ? map[i][j] : max;
			}
		}
		
		// 강수량 max-1 부터 시작하는 이유 : 가장 지역의 최대 높이만큼 강수량이 온 경우는 모든 지역이 잠긴다.
		for (int i = max-1; i > 0; --i) {
			// 방문여부 확인 배열
			boolean[][] visited = new boolean[N][N];
			
			// 강수량이 i 일 때 안전구역 개수
			int count = 0;
			
			for (int j = 0; j < N; ++j) {
				for (int k = 0; k < N; ++k) {
					// 강수량이 i 일 때, 잠기지 않고, 방문하지 않은 지역이라면
					if (map[j][k] > i && !visited[j][k]) {
						dfs(j, k, i, visited);
						count++;
					}
				}
			}
			safety = count > safety ? count : safety;
		}
		bw.write(Integer.toString(safety));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int y, int x, int h, boolean[][] visited) {
//		if (map[y][x] < h && visited[y][x])
//			return;
		
		// 방문 체크
		visited[y][x] = true;
		
		// 상 하 좌 우
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				// 인접한 지역이 잠기지 않는 지역이고, 방문하지 않은 지역이라면
				if (map[ny][nx] > h && !visited[ny][nx])
					dfs(ny, nx, h, visited);
			}
		}
	}
}
