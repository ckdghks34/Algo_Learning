package com.ssafy.exSoftAcademy._210419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_5607_조합 {
	static int N, C;
	static boolean[] check;
	static int count;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sb = new StringBuilder();

			sb.append("#").append(tc).append(" ");

			count = 0;
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			check = new boolean[N];

			Com(0, 0);

			sb.append(count);
			
			System.out.println(sb.toString());
		}
	}

	public static void Com(int start, int cnt) {

		if (cnt == C) {
			count++;
			return;
		}

		for (int i = start; i < N; ++i) {
			check[i] = true;
			Com(i + 1, cnt + 1);
			check[i] = false;
		}
	}
}
