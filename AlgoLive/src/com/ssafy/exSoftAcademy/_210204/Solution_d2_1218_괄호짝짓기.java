package com.ssafy.exSoftAcademy._210204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_d2_1218_괄호짝짓기 {

	static Stack<Character> s;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d2_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; ++tc) {
			int N = Integer.parseInt(br.readLine());
			s = new Stack<Character>();
			char[] c = br.readLine().toCharArray();
			int vaild = 1;

			for (int i = 0; i < N; ++i) {
				if (c[i] == '(' || c[i] == '{' || c[i] == '[' || c[i] == '<')
					s.push(c[i]);

				else {
					switch (c[i]) {
					case ')':
						vaild = s.pop() == '(' ? 1 : 0;
						break;
					case '}':
						vaild = s.pop() == '{' ? 1 : 0;
						break;
					case ']':
						vaild = s.pop() == '[' ? 1 : 0;
						break;
					case '>':
						vaild = s.pop() == '<' ? 1 : 0;
						break;
					}

					if (vaild == 0)
						break;
				}
			}
			System.out.println("#" + tc + " " + vaild);
		}
	}
}
