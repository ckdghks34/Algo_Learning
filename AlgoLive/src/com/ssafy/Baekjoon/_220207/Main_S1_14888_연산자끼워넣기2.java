package com.ssafy.Baekjoon._220207;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S1_14888_연산자끼워넣기2 {
	public static int N;
	public static int[] data;
	public static char[] oper;
	public static char[] select;
	public static boolean[] visited;
	public static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		data = new int[N];
		visited = new boolean[N];
		oper = new char[N - 1];
		select = new char[N - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			data[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int index = 0;
		for (int i = 0; i < 4; ++i) {
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; ++j) {
				switch (i) {
				case 0:
					oper[index++] = '+';
					break;
				case 1:
					oper[index++] = '-';
					break;
				case 2:
					oper[index++] = '*';
					break;
				case 3:
					oper[index++] = '/';
					break;
				}
			}
		}

		com(0);

		sb.append(max).append("\n").append(min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void com(int cnt) {
		if (cnt == N - 1) {
			int sum = data[0];

			for (int i = 0; i < N-1; ++i) {
				switch (select[i]) {
				case '+':
					sum += data[i + 1];
					break;
				case '-':
					sum -= data[i + 1];
					break;
				case '*':
					sum *= data[i + 1];
					break;
				case '/':
					if (sum < 0)
						sum = -(Math.abs(sum) / data[i + 1]);
					else
						sum = sum / data[i + 1];

					break;
				}
			}

			max = Math.max(sum, max);
			min = Math.min(sum, min);
		}
		for (int i = 0; i < N - 1; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				select[cnt] = oper[i];
				com(cnt + 1);
				visited[i] = false;
			}

		}

	}
}
