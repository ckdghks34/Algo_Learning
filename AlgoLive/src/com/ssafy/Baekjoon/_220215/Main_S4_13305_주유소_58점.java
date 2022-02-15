package com.ssafy.Baekjoon._220215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S4_13305_주유소_58점 {
	public static int N;
	public static int[] cost;
	public static int[] distance;
	public static Long sum = 0l;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		distance = new int[N - 1];
		cost = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; ++i)
			distance[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			cost[i] = Integer.parseInt(st.nextToken());

		int cur = cost[0];
		int curindex = 0;
		for (int i = 1; i <= N - 1; ++i) {
			if (i != N - 1) {
				if (cur < cost[i])
					continue;

				for (int j = curindex; j < i; ++j) {
					sum += cur * distance[j];
				}
				cur = cost[i];
				curindex = i;
			}
			if (i == N - 1) {
				if (curindex != N - 1)
					for (int j = curindex; j < i; ++j) {
						sum += cur * distance[j];
					}
			}
		}

		bw.write(Long.toString(sum));
		bw.flush();
		bw.close();
		br.close();
	}
}
