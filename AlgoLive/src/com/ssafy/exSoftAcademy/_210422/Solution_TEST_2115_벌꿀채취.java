package com.ssafy.exSoftAcademy._210422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_TEST_2115_벌꿀채취 {

	static int N, M, C;
	static int[][] map;
	static int[][] arr;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken()); // 전체 벌통 크기
			M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통 크기
			C = Integer.parseInt(st.nextToken()); // 꿀 채취할 수 있는 최대 양

			map = new int[N][N];
			arr = new int[N][N];

			// 맵 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check(j, i);
				}
			}
			System.out.println();
		}
	}

	public static void check(int x, int y) {
		List<Integer> list = new ArrayList<Integer>();

		if (x + M > N)
			return;

		for (int i = x, size = x + M; i < size; ++i) {
			list.add(map[y][i]);
		}

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int max = 0;
		int tmp2 = 0;
		for (int i = 0; i < M; ++i) {
			int tmp = max;

			tmp += list.get(i);

			if (tmp <= C && max < tmp) {
				max = tmp;
				tmp2 += list.get(i) * list.get(i);
			}
		}
		arr[y][x] = tmp2;
	}
}
