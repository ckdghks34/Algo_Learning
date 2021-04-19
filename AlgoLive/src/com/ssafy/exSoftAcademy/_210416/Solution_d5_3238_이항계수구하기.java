package com.ssafy.exSoftAcademy._210416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d5_3238_이항계수구하기 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int T = Integer.parseInt(br.readLine());
		long n, r, p;
		long[] factorial;
		
		for (int tc = 1; tc <= T; ++tc) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			
			factorial = new long[Long.valueOf(n).intValue() + 1];
			factorial[0] = 1;
			for (int i = 1; i <= n; i++)
				factorial[i] = (factorial[i - 1] * i) % p;
			
			long numerator = factorial[Long.valueOf(n).intValue()] % p;
			long denominator = ((factorial[Long.valueOf(n).intValue() - Long.valueOf(r).intValue()] % p) * (factorial[Long.valueOf(n).intValue()] % p)) % p;
			
			long moveToTop = pow(denominator, p - 2,p);

			System.out.println("#" + tc + " " + ((numerator * moveToTop) % p));
		}
	}
	static long pow(long num, long num2,long p) {
		if (num2 == 0)
			return 1;

		long half = pow(num, num2 / 2,p);

		if (num2 % 2 == 0) {
			return ((half % p) * (half % p)) % p;
		} else
			return (((half * num) % p) * (half % p)) % p;
	}

}
