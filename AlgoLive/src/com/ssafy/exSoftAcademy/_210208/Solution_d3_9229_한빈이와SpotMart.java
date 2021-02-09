package com.ssafy.exSoftAcademy._210208;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_9229_한빈이와SpotMart {
	static int T, N, M;
	static int max;
	static int[] snackweight;

	static void seletedSnack(int cnt,int start, int s) {
		if (s > M) {	// 제한된 무게보다 커지면 종료
			return;
		}
		if (cnt == 2) {
			max = Math.max(max, s); // sum과 max를 비교하여 더 큰 값을 max에 넣는다.
			return;
		}

		for (int i = start; i < N; ++i) {
			seletedSnack(cnt + 1, i + 1,s+snackweight[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d3_9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			max = -1;
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			snackweight = new int[N];
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; ++i)
				snackweight[i] = Integer.parseInt(st.nextToken());

			seletedSnack(0, 0,0);
			System.out.println("#" + tc + " " + max);
		}
		br.close();
	}
}
