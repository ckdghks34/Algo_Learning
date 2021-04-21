package com.ssafy.exSoftAcademy._210421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1
6
5
2 1
3 1
4 1
5 1
6 2
 */
/*
1
6
6
1 5    
3 4    
5 4
4 2
4 6
5 2
 */
public class Solution_D4_5643_키_순서 {
	static int N, M, count;
	static int[][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			sb = new StringBuilder();

			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			check = new int[N + 1][N + 1];
			count = 0;

			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine(), " ");

				int x = Integer.parseInt(st.nextToken()); // 작은 값
				int y = Integer.parseInt(st.nextToken()); // 큰값

				check[x][y] = 1;
			}

			for (int i = 1; i < N + 1; ++i)
				bfs(i);

			sb.append(count);
			System.out.println(sb.toString());
		}
	}

	public static void bfs(int index) {
		boolean[] isSelected = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(index);
		isSelected[index] = true;
		int cnt = 1;

		while (!queue.isEmpty()) {
			if (cnt == N) {
				count++;
				return;
			}
			int current = queue.poll();

			for (int i = 1; i < N + 1; ++i) {
				if (check[i][current] == 1 && !isSelected[i]) {
					queue.add(i);
					isSelected[i] = true;
					cnt++;
				}
			}
		}

		queue.offer(index);

		while (!queue.isEmpty()) {
			if (cnt == N) {
				count++;
				return;
			}
			int current = queue.poll();

			for (int i = 1; i < N + 1; ++i) {
				if (check[current][i] == 1 && !isSelected[i]) {
					queue.add(i);
					isSelected[i] = true;
					cnt++;
				}
			}
		}

		if (cnt == N)
			count++;
	}
}
