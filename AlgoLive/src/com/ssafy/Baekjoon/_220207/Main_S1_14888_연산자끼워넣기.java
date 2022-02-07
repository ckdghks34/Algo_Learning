package com.ssafy.Baekjoon._220207;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S1_14888_연산자끼워넣기 {
	public static int N;
	public static int[] data;
	public static int[] oper;
	public static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		data = new int[N];
		oper = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			data[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; ++i) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		com(0, data[0]);

		sb.append(max).append("\n").append(min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void com(int cnt, int sum) {
		if (cnt == N - 1) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}

		for (int i = 0; i < 4; ++i) {
			int res = 0;
			if (oper[i] > 0) {
				oper[i]--;

				switch (i) {
				case 0:
					res = sum + data[cnt + 1];
					break;
				case 1:
					res = sum - data[cnt + 1];
					break;
				case 2:
					res = sum * data[cnt + 1];
					break;
				case 3:
					if (sum < 0)
						res = -(Math.abs(sum) / data[cnt + 1]);
					else
						res = sum / data[cnt + 1];
					break;
				}
				com(cnt + 1, res);
				oper[i]++;
			}
		}

	}
}
