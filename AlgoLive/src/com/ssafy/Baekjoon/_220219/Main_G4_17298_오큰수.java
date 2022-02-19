package com.ssafy.Baekjoon._220219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G4_17298_오큰수 {
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();

		N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		int[] result = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			data[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; ++i) {

			while (!stack.isEmpty()) {
				if (data[stack.peek()] < data[i])
					result[stack.pop()] = data[i];
				else
					break;
			}

			stack.push(i);
		}
		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		for (int i = 0; i < N; ++i) {
			sb.append(result[i]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
