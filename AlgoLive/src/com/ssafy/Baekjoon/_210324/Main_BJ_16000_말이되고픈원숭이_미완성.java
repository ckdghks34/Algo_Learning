package com.ssafy.Baekjoon._210324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16000_말이되고픈원숭이_미완성 {

	static int[][] map;
	static int W, H;

	// 우 하
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };
	// 좌좌상 좌상상 우상상 우우상 우우하 우하하 좌하하 좌좌하
	static int[] diax = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] diay = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		visited = new boolean[H][W];
		for (int i = 0; i < H; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void bfs(int K) {
		Queue<int[]> queue = new LinkedList<>();
		int k = K;

		// x좌표, y좌표, 말처럼 움직일 수 있는 횟수, 이동횟수
		queue.offer(new int[] { 0, 0, k, 0 });
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (current[0] == W && current[0] == H)
				return;

			if (k != 0) {
				for(int d =0 ; d < 8; ++d)
				{
					int nx = current[0] + diax[d];
					int ny = current[1] + diay[d];
					
					if(0 <= nx && nx < W && 0 <= ny && ny < H)
					{
						if(!visited[ny][nx])
						{
							if(map[ny][nx] == 0)
							{
							}
						}
					}
				}
				
			}
			// k 가 0이 아니라면 말처럼 움직인다
			// 말처럼 움직일 좌표로 이동 할 수 있다면
			// 이동

			// 말처럼 움직였을 때 이동 할 수 없다면
			// 후 or 우 이동 할 수 있는지 확인
			// 이동 할 수 있으면 이동
			// 이동 할 수 없다면 return;
		}
	}
}
