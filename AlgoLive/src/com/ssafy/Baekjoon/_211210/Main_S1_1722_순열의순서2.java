package com.ssafy.Baekjoon._211210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_1722_순열의순서2 {

	public static StringBuilder sb = new StringBuilder();
	public static int n, m, count;
	public static long[] factorial;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());

		// n번째 까지의 factorial 구하기
		factorial = new long[n + 1];
		factorial[0] = 1;
		factorial[1] = 1;

		for (int i = 2; i < n; ++i)
			factorial[i] = factorial[i - 1] * i;

		if (m == 1) {
			long k = Long.parseLong(st.nextToken());
			selectOne(k);
		} else {
			int[] data = new int[n];
			for (int i = 0; i < n; ++i)
				data[i] = Integer.parseInt(st.nextToken());
			selectTwo(data);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void selectOne(long k) {
		boolean[] selected = new boolean[n + 1];

		for (int i = 0; i < n; ++i) {
			for (int j = 1; j < n + 1; ++j) {
				if (selected[j])
					continue;

				if (factorial[n - i - 1] < k)
					k -= factorial[n - i - 1];
				else {
					selected[j] = true;
					sb.append(j);
					sb.append(" ");
					break;
				}
			}
		}
	}

	public static void selectTwo(int[] data) {
		boolean[] selected = new boolean[n + 1];
		long count = 1;

		for (int i = 0; i < n; ++i) {
			for (int j = 1; j < data[i]; ++j) {
				if (selected[j])
					continue;
				else {
					count += factorial[n - i-1];
				}
			}
			selected[data[i]] = true;
		}
		sb.append(count);
	}
}
