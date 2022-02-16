package com.ssafy.Baekjoon._220216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B3_5086_배수와약수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N, M;

		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			// 약수일 때
			if (N < M) {
				if (M % N == 0)
					sb.append("factor");
				else
					sb.append("neither");

				sb.append("\n");
			}
			// 배수일 때
			else {
				if (N % M == 0)
					sb.append("multiple");
				else
					sb.append("neither");

				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
