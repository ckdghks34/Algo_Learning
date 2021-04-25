package com.ssafy.exSoftAcademy._210423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_TEST_4013_특이한자석 {

	static final int magnet = 4;
	static final int N = 8;
	static int K;
	static int[][] map;
	static int[][] rotation;
	static int[] head;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			K = Integer.parseInt(br.readLine());

			rotation = new int[K][2];
			head = new int[magnet];
			map = new int[magnet][N]; // col : N+1 한 이유 -> head(빨간화살표) 위치 값
			for (int i = 0; i < 4; ++i) {
				st = new StringTokenizer(br.readLine(), " ");

				head[i] = 0;

				for (int j = 0; j < N; ++j)
					map[i][j] = Integer.parseInt(st.nextToken()); // 자석 방향
			}

			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine(), " ");

				rotation[i][0] = Integer.parseInt(st.nextToken()) - 1; // 회전시키는 자석번호
				rotation[i][1] = Integer.parseInt(st.nextToken()); // 회전방향
			}

			for (int i = 0; i < K; ++i) {
				rotate(rotation[i][0], rotation[i][1]);
			}

			int sum = 0;

			for (int i = 0; i < magnet; ++i) {
				if (map[i][head[i]] == 1) {
					sum += Math.pow(2, i);
				}
			}
			sb.append(sum);
			System.out.println(sb.toString());
		}
	}

	public static void rotate(int number, int dir) {
		boolean[] isRotated = new boolean[magnet];
		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] { number, dir });
		isRotated[number] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll(); // [0] : 자석 번호, [1] : 방향
			int pre = current[0] - 1;
			int cur = current[0];
			int next = current[0] + 1;
			int direction = current[1];

			if (0 <= pre) // 이전 자석이 있다면
			{
				// 이전 자석 3번과 현재 자석 7번이 같을 때

				// 이전 자석 3번과 현재 자석 7번이 다를 때
				if (!isRotated[pre] && map[pre][(head[pre] + 2) % N] != map[cur][(head[cur] + 6) % N]) {
					queue.offer(new int[] { pre, direction * -1 });
					isRotated[pre] = true;
				}
			}

			if (next < magnet) // 다음 자석이 있다면
			{
				// 현재 자석 3번과 다음자석 7번이 같을 때

				// 현재 자석 3번과 다음자석 7번이 다를 때
				if (!isRotated[next] && map[cur][(head[cur] + 2) % N] != map[next][(head[next] + 6) % N]) {
					queue.offer(new int[] { next, direction * -1 });
					isRotated[next] = true;
				}
			}

			head[cur] = (head[cur] + (direction * -1));

			if (head[cur] < 0) {
				head[cur] = 7;
			} else {
				head[cur] %= N;
			}
		}
	}
}
