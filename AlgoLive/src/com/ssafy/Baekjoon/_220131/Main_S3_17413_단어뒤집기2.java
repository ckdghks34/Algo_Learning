package com.ssafy.Baekjoon._220131;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_S3_17413_단어뒤집기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<>();
		String input = br.readLine();
		int size = input.length();
		boolean check = false;
		String result = "";
		for (int i = 0; i < size; ++i) {
			char cur = input.charAt(i);

			if (cur == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}

				sb.append(cur);
				check = true;
			} else if (cur == '>') {
				sb.append(cur);
				check = false;
			} else if (check) {
				sb.append(cur);
			} else {
				if (cur == ' ') {
					while (!stack.isEmpty())
						sb.append(stack.pop());
					sb.append(cur);
				} else {
					stack.push(cur);
				}
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
