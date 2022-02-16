package com.ssafy.Baekjoon._220216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S5_2609_최대공약수와최대공배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N, M;
		int gcd, lcm;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

//		gcd = GCD(N, M);
		gcd = GCD_WHILE(N, M);
		lcm = N * M / gcd;
		sb.append(gcd).append("\n").append(lcm);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// while반복이 Recursive보다 빠르다.
	public static int GCD_WHILE(int n, int m) {
		int r;

		while (m != 0) {
			r = n % m;
			n = m;
			m = r;
		}
		return n;
	}
	
	// Recursive
	public static int GCD(int n, int m) {
		if (m == 0)
			return n;
		else
			return GCD(m, n % m);
	}
}
