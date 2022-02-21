package com.ssafy.Baekjoon._220221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S1_1629_곱셈 {

	public static long A, B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		sb.append(exponentiation(A, B, C));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	/*
		1)
			10^6 = 10^(3+3)
			 	 = 10^3 * 10^3
		2)
			10^11 = 10^(5+5+1)
				  = 10^5 * 10^5 * 10^1
	*/
	public static Long exponentiation(long A, long B, long C) {
		if (B == 1)
			return A % C;

		long pow = exponentiation(A, B / 2, C);

		// (A * B ) % C = (A % C * B % C) % C
		if (B % 2 == 0) {
			return (pow * pow) % C;
		} else {
			// return ((pow % C) * (pow % C) * (A % C)) % C;
			return (((pow * pow) % C) * (A % C)) % C;
		}
	}
}