package com.ssafy.Baekjoon._220129;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_S2_2504_괄호의값 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine();
		Stack<String> stack = new Stack<>();

		int size = line.length();
		for (int i = 0; i < size; ++i) {
			String current = Character.toString(line.charAt(i));

			if (current.equals("(") || current.equals("["))
				stack.push(current);
			else {
				if (stack.size() == 0) {
					bw.write("0");
					bw.flush();
					bw.close();
					br.close();
					return;
				}
				if (current.equals(")")) {
					if (stack.peek().equals("(")) {
						stack.pop();
						stack.push("2");
					} else {
						int data = 0;

						while (!stack.isEmpty()) {
							if (stack.peek().equals("[")) {
								bw.write("0");
								bw.flush();
								bw.close();
								br.close();
								return;
							} else if (stack.peek().equals("(")) {
								data *= 2;
								stack.pop();
								stack.push(Integer.toString(data));
								break;

							} else {
								data += Integer.parseInt(stack.pop());
							}
						}
					}

				} else if (current.equals("]")) {

					if (stack.peek().equals("[")) {
						stack.pop();
						stack.push("3");
					} else {
						int data = 0;
						while (!stack.empty()) {
							if (stack.peek().equals("(")) {
								bw.write("0");
								bw.flush();
								bw.close();
								br.close();
								return;
							} else if (stack.peek().equals("[")) {
								data *= 3;
								stack.pop();
								stack.push(Integer.toString(data));
								break;
							} else {
								data += Integer.parseInt(stack.pop());
							}
						}
					}
				}
			}
		}

		int result = 0;
		while (!stack.isEmpty()) {
			String tmp = stack.pop();

			if (tmp.equals("(") || tmp.equals("[")) {
				bw.write("0");
				bw.flush();
				bw.close();
				br.close();
				return;
			}

			result += Integer.parseInt(tmp);
		}
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}

}
