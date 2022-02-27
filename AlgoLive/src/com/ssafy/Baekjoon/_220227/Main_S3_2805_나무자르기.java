package com.ssafy.Baekjoon._220227;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_2805_나무자르기 {
	public static int N, M;
	public static long max;
	public static long[] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		long left = 0;
		long right = data[N - 1];

		while (left <= right) {
			long mid = (left + right) / 2;
			long len = 0;

			for (int i = 0; i < N; ++i) {
				if (data[i] > mid)
					len += data[i] - mid;
			}

			if (len >= M) {
				left = mid + 1;
				max = Math.max(max, mid);
			} else {
				right = mid - 1;
			}
		}

		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
