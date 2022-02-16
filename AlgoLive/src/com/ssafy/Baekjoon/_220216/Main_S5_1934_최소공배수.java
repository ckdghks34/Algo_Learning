package com.ssafy.Baekjoon._220216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S5_1934_최소공배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N;
		int A, B;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			sb.append(lcm(A, B)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int lcm(int A, int B) {
		int r, a = A, b = B;

		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}

		return A * B / a;

	}
}
