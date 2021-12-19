package com.ssafy.Baekjoon._211219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2178_미로탐색 {
	public static int N, M;
	public static int[][] map;
	public static boolean[][] visited;

	// 상 하 좌 우
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		// Map 입력
		for (int i = 0; i < N; ++i) {
			String tmp = br.readLine();
			for (int j = 0; j < M; ++j)
				map[i][j] = tmp.charAt(j) - '0';
		}

		// 시작좌표를 매개변수로 전달
		bfs(0, 0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();

		int min = Integer.MAX_VALUE; // 도착지점까지의 최단 거리를 저장하는 변수

		queue.add(new int[] { x, y, 1 }); // 시작점을 Queue에 추가 {x좌표,y좌표,거리}
		visited[y][x] = true; // 시작점을 미리 방문처리함.

		while (!queue.isEmpty()) {
			int[] current = queue.poll(); // 현재 위치한 좌표
			int count = current[2]; // 현재 좌표까지의 이동 거리

			// 현재 좌표가 목표 지점일 때 (x = M / y = N) 기존의 최솟값과 비교
			if (current[0] == M - 1 && current[1] == N - 1) {
				min = Math.min(count, min);
			}

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + dx[i]; // 다음 이동할 x좌표
				int ny = current[1] + dy[i]; // 다음 이동할 y좌표

				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {

					// 이동할 좌표값이 이동가능(1)하고, 방문하지 않았다면
					if (map[ny][nx] == 1 && !visited[ny][nx]) {
						// 다음 이동할 좌표를 추가하기전에 방문처리 (이유는 아래 주석 참고)
						visited[ny][nx] = true;
						// 이동할 좌표 추가
						queue.add(new int[] { nx, ny, count + 1 });
					}
				}
			}
		}

		sb.append(min);
	}
	/*
	 * 처음 작성한 코드 메모리 초과 에러 발생 Queue에 추가해주면서 Visited 처리를 하지 않았기 때문에 똑같은 좌표가 Queue에
	 * 지속적으로 들어감 ex) Map이 아래와 같을때 (0,1)/(1,0) 일때 (1,1)이 Queue에 들어감. 아직 방문처리를 하지 않았기
	 * 때문에 1111 1111 1111 시작점을 미리 Visited 처리를 하고, Queue에 add 하기 전 Visited 처리 후 add
	 * 해서 해결함. public static void bfs(int x, int y) { Queue<int[]> queue = new
	 * LinkedList<int[]>(); int min = Integer.MAX_VALUE; queue.add(new int[] { x, y,
	 * 1 });
	 * 
	 * while (!queue.isEmpty()) { int[] current = queue.poll(); int count =
	 * current[2]; visited[current[1]][current[0]] = true;
	 * 
	 * if (current[0] == M - 1 && current[1] == N - 1) { min = Math.min(count, min);
	 * break; }
	 * 
	 * for (int i = 0; i < 4; ++i) { int nx = current[0] + dx[i]; int ny =
	 * current[1] + dy[i];
	 * 
	 * if (nx >= 0 && ny >= 0 && nx < M && ny < N) { if (map[ny][nx] == 1 &&
	 * !visited[ny][nx]) queue.add(new int[] { nx, ny, count + 1 }); } } }
	 * 
	 * sb.append(min); }
	 */
}
