package com.ssafy.Baekjoon._220214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S3_11047_동전0 {
	public static int N, K;
	public static int count;
	public static int[] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		data = new int[N];
		for (int i = 0; i < N; ++i)
			data[i] = Integer.parseInt(br.readLine());

		int tmp = K;
		for (int i = N - 1; i >= 0 && tmp != 0; --i) {
			if (data[i] > K)
				continue;

			count += tmp / data[i];
			tmp = tmp % data[i];
		}

		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}

}
