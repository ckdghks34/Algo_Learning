package com.ssafy.exSoftAcademy._210419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_5607_조합_fermat_다시보기 {
	static int p = 1234567891;
	static int N;
	static long[] factorial;

	static int R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			factorial = new long[N + 1];
			factorial[0] = 1;
			for (int i = 1; i <= N; i++)
				factorial[i] = (factorial[i - 1] * i) % p;

			long numerator = factorial[N] % p;
			long denominator = ((factorial[N - R] % p) * (factorial[R] % p)) % p;

			long moveToTop = pow(denominator, p - 2);

			System.out.println("#" + tc + " " + ((numerator * moveToTop) % p));
		}
	}

	static long pow(long num, int num2) {
		if (num2 == 0)
			return 1;

		long half = pow(num, num2 / 2);

		if (num2 % 2 == 0) {
			return ((half % p) * (half % p)) % p;
		} else
			return (((half * num) % p) * (half % p)) % p;
	}
}
