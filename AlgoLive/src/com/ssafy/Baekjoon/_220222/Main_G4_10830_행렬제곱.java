package com.ssafy.Baekjoon._220222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_G4_10830_행렬제곱 {
	public static long[][] A, result;
	public static int N;
	public static long B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		A = new long[N][N];
		result = new long[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				A[i][j] = Long.parseLong(st.nextToken());
			}
		}

		if (B == 1) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					result[i][j] = A[i][j] % 1000;
				}
			}
		} else
			result = exponentiation(B);

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static long[][] exponentiation(long B) {
		if (B == 1)
			return A;

		long[][] pow = exponentiation(B / 2);

		if (B % 2 == 0) {
			return mul(pow, pow);
		} else
			return mul(mul(pow, pow), A);

	}

	public static long[][] mul(long[][] a, long[][] b) {
		long[][] res = new long[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += a[i][k] * b[k][j];
					res[i][j] %= 1000;
				}
			}
		}

		return res;
	}
}
