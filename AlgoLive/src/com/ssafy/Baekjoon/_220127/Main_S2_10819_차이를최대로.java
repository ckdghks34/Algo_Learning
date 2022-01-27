package com.ssafy.Baekjoon._220127;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_10819_차이를최대로 {
	public static int N, max;
	public static int[] map;
	public static boolean[] visited;
	public static int[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		select = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			map[i] = Integer.parseInt(st.nextToken());

		per(0);

		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void per(int count) {
		if (count == N) {
			int sum = 0;

			for (int i = 1; i < N; ++i) {
				sum += Math.abs((select[i - 1] - select[i]));
			}

			max = sum > max ? sum : max;
			return;
		}

		for (int i = 0; i < N; ++i) {

			if (!visited[i]) {
				select[count] = map[i];
				visited[i] = true;
				per(count + 1);
				visited[i] = false;
			}

		}
	}
}
