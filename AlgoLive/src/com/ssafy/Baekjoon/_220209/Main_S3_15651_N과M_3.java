package com.ssafy.Baekjoon._220209;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S3_15651_N과M_3 {
	public static int N, M;
	public static int[] select;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		select = new int[M];

		duplicate_Permutation(0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void duplicate_Permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; ++i) {
				sb.append(select[i]).append(" ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 1; i <= N; ++i) {
			select[cnt] = i;
			duplicate_Permutation(cnt + 1);
		}
	}
}
