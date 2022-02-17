package com.ssafy.Baekjoon._220217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_2004_조합0의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N, M;
		int[] resN = new int[2];
		int result = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		resN[0] = remindFive(N) - (remindFive(M) + remindFive(N - M));
		resN[1] = remindTwo(N) - (remindTwo(M) + remindTwo(N - M));

		result = Math.min(resN[0], resN[1]);
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}

	public static int remindFive(int n) {
		int cnt = 0;
		while (n >= 5) {
			cnt += n / 5;
			n /= 5;
		}

		return cnt;
	}

	public static int remindTwo(int n) {
		int cnt = 0;
		while (n >= 2) {
			cnt += n / 2;
			n /= 2;
		}
		return cnt;
	}
}
