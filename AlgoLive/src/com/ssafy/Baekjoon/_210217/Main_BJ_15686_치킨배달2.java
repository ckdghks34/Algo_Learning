package com.ssafy.Baekjoon._210217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15686_치킨배달2 {

	static int N, M;
	static house[] h;
	static chicken[] c;
	static chicken[] sc;
	static int hCnt;
	static int cCnt;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		h = new house[2 * N];
		c = new chicken[13];
		sc = new chicken[M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				int tmp = Integer.parseInt(st.nextToken());

				if (tmp == 1) {
					h[hCnt++] = new house(j,i);
				}
				if (tmp == 2) {
					c[cCnt++] = new chicken(j, i);
				}
			}
		}

		combi(0, 0);

		System.out.println(result);

	}

	static void combi(int start, int cnt) {
		if (cnt == M) {
			int sum = 0;
			for (int i = 0; i < hCnt; ++i) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; ++j) {
					int distance = Math.abs(h[i].x - sc[j].x) + Math.abs(h[i].y - sc[j].y);
					min = Math.min(min, distance);
				}

				sum += min;

				if (sum > result)
					return;
			}
			result = sum;
			return;
		}

		for (int i = start; i < cCnt; ++i) {
			sc[cnt] = new chicken(c[i].x, c[i].y);
			combi(start + 1, cnt + 1);
		}
	}

	static class house {
		int x, y;

		public house(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class chicken {
		int x, y;

		public chicken(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
