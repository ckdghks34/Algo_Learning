package com.ssafy.Baekjoon._220219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G4_17298_오큰수_시간초과 {
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();

		N = Integer.parseInt(br.readLine());
		int[] data = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			data[i] = Integer.parseInt(st.nextToken());

		for (int i = N - 1; i >= 0; --i) {
			int tmp = 0;

			for (int j = i + 1; j < N; ++j) {
				if (data[i] < data[j]) {
					tmp = j;
					break;
				}
			}

			if (tmp != 0)
				stack.push(tmp);
			else
				stack.push(-1);
		}

		while (!stack.isEmpty()) {
			int index = stack.pop();
			if (index == -1)
				sb.append(index).append(" ");
			else
				sb.append(data[index]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
