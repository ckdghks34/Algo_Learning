package com.ssafy.Baekjoon._210324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2636_치즈 {

	static int[][] map;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int row;
	static int col;
	static boolean[][] visited;
	static int total; // 총 치즈 갯수
	static int time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		visited = new boolean[row][col];
		time = 0;
		total = 0;
		List<Integer> list = new ArrayList<>();
		// map 입력
		for (int i = 0; i < row; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < col; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					total++;
			}
		}
		list.add(total);

		while (bfs()) {
			list.add(total);
			visited = new boolean[row][col];
		}

		System.out.println(time);
		System.out.println(list.get(list.size() - 1));
	}

	public static boolean bfs() {
		Queue<int[]> queue = new LinkedList<>();
		time++;

		queue.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int d = 0; d < 4; ++d) {
				int mx = current[0] + dx[d];
				int my = current[1] + dy[d];

				if (0 <= mx && mx < col && 0 <= my && my < row) {
					if (!visited[my][mx]) {
						if (map[my][mx] == 1) {

							map[my][mx] = 0;
							total--;
						} else {
							queue.offer(new int[] { mx, my });
						}
					}
					visited[my][mx] = true;
				}
			}
		}
		return total > 0 ? true : false;
	}
}
