package com.ssafy.Baekjoon._220225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_1654_랜선자르기 {
	public static int N, K;
	public static long[] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		data = new long[K];

		for (int i = 0; i < K; ++i)
			data[i] = Integer.parseInt(br.readLine());

		Arrays.sort(data);

		long left = 1;
		long right = data[K - 1];

		while (left <= right) {
			long center = (left + right) / 2;
			long count = 0;

			for (int i = 0; i < K; ++i) {
				count += data[i] / center;
			}

			// 갯수가 K보다 작으면 자른 길이기 길기 때문에 더 잘게 잘라야함
			if (count < N)
				right = center - 1;
			else {
				left = center + 1;
			}
		}

		sb.append(right);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
