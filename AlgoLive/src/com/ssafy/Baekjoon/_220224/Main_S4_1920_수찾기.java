package com.ssafy.Baekjoon._220224;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_1920_수찾기 {

	public static int N, M;
	public static long[] n;
	public static boolean[] res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		n = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			n[i] = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());
		res = new boolean[M];
		st = new StringTokenizer(br.readLine());

		// 데이터 정렬
		Arrays.sort(n);

		for (int i = 0; i < M; ++i) {
			int current = Integer.parseInt(st.nextToken());

			boolean isExist = false;
			int left = 0;
			int right = N - 1;

			while (left <= right) {
				int center = (left + right) / 2;

				if (current == n[center]) {
					isExist = true;
					break;
				} else if (current > n[center])
					left = center + 1;
				else
					right = center - 1;
			}

			sb.append(isExist ? 1 : 0).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
