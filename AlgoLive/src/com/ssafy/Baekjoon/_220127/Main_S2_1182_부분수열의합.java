package com.ssafy.Baekjoon._220127;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main_S2_1182_부분수열의합 {
	public static int N, S, count;
	public static int[] map;
	public static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		count = 0;
		map = new int[N];
		select = new boolean[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; ++i)
			map[i] = Integer.parseInt(st.nextToken());

		subset(0, 0);

		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();

	}

	public static void subset(int cnt, int selected) {
		if (cnt == N) {
			if (selected == 0)
				return;

			int sum = 0;

			for (int i = 0; i < N; ++i) {
				if (select[i])
					sum += map[i];
			}

			if (sum == S)
				count++;

			return;
		}
		select[cnt] = true;
		subset(cnt + 1, selected + 1);

		select[cnt] = false;
		subset(cnt + 1, selected);
	}
}
