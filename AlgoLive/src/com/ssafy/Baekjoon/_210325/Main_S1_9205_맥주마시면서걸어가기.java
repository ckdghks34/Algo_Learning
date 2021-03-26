package com.ssafy.Baekjoon._210325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_9205_맥주마시면서걸어가기 {
	// 우 하 좌 상
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] start = new int[2];
	static int[] end = new int[2];
	static int[][] convenience;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			int conCount = Integer.parseInt(br.readLine()); // 편의점 수
			convenience = new int[conCount][2];
			
			st = new StringTokenizer(br.readLine(), " ");
			// 입력

			// 시작점
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());

			
			// 편의점
			for (int i = 0; i < conCount; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				convenience[i][0] = Integer.parseInt(st.nextToken());
				convenience[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			// 종료지점
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());

			if(bfs())
				System.out.println("haapy");
			else
				System.out.println("sad");

		}
		br.close();
	}

	public static boolean bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		int startX = start[0];
		int startY = start[1];

		// x좌표, y좌표, 맥주 갯수, 이동거리
		queue.offer(new int[] { startX, startY, 20, 50 });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			if (current[2] == 0 && current[3] == 0)
				continue;
			else if (current[2] != 0 && current[3] == 0) {
				current[2]--;
				current[3] = 50;
			}
				for (int d = 0; d < 4; ++d) {
					int nx = current[0] + dx[d];
					int ny = current[1] + dy[d];

					if (0 <= nx && nx <= end[0] && 0 <= ny && ny <= end[1]) {

						// 도착지점에 도착했을 때
						if (checkEnd(nx, ny)) {
							return true;
						}
						// 편의점에 도착했을 때
						else if (checkConven(nx, ny)) {
							queue.offer(new int[] { nx, ny, 20, current[3] - 1 });
						}
						// 도착지점에 도착하지 못했을때
						else {
							queue.offer(new int[] { nx, ny, current[2], current[3] - 1 });
						}
					}
				}
			}
		return false;
	}

	public static boolean checkEnd(int nx, int ny) {
		return nx == end[0] && ny == end[1];
	}

	public static boolean checkConven(int nx, int ny) {
		boolean check = false;
		for (int i = 0; i < convenience.length; ++i) {
			if (nx == convenience[i][0] && ny == convenience[i][1])
				check = true;
		}
		return check;
	}
}
