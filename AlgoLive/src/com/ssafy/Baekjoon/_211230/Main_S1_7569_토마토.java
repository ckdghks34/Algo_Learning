package com.ssafy.Baekjoon._211230;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_7569_토마토 {
	public static int N, M, H;
	public static int[][][] map;
	public static int total;
	public static int result = Integer.MIN_VALUE;
	public static Queue<int[]> queue = new LinkedList<int[]>();
	// 상 하 좌 우 위 아래
	public static int dx[] = { 0, 0, -1, 1, 0, 0 };
	public static int dy[] = { -1, 1, 0, 0, 0, 0 };
	public static int dh[] = { 0, 0, 0, 0, 1, -1 };
	public static boolean visited[][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이

		map = new int[N][M][H];
		visited = new boolean[N][M][H];
		total = N * M * H;
		// 높이 만큼
		for (int h = 0; h < H; ++h) {
			for (int n = 0; n < N; ++n) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; ++m) {
					map[n][m][h] = Integer.parseInt(st.nextToken());

					if (map[n][m][h] == 1)
						queue.add(new int[] { n, m, h, 0 });

					if (map[n][m][h] == -1)
						total--;
				}
			}
		}
		int last = bfs();
		if (total != 0)
			sb.append(-1);
		else
			sb.append(last);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int bfs() {
		int max = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currenty = current[0];
			int currentx = current[1];
			int currenth = current[2];
			int count = current[3];
			total--;
			max = count > max ? count : max;
			for (int i = 0; i < 6; ++i) {
				int nx = currentx + dx[i];
				int ny = currenty + dy[i];
				int nh = currenth + dh[i];
				if (nx >= 0 && ny >= 0 && nh >= 0 && ny < N && nx < M && nh < H) {
					if (!visited[ny][nx][nh] && map[ny][nx][nh] == 0) {
						visited[ny][nx][nh] = true;
						queue.add(new int[] { ny, nx, nh, count + 1 });
					}
				}
			}
		}

		return max;
	}
}
