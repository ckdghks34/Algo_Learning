package com.ssafy.Baekjoon._220102;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1316_S5_그룹단어체커 {

	public static int N, count;
	public static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		count = N;

		for (int i = 0; i < N; ++i) {
			str = br.readLine();

			boolean[] check = new boolean[26];

			for (int j = 0; j < str.length(); ++j) {
				char current = str.charAt(j);

				if (j == str.length() - 1) {
					if (check[current - 'a'] == true) {
						count--;
						break;
					}
				} else {
					char next = str.charAt(j + 1);
					
					if (current == next)
						continue;
					else {
						if (check[current - 'a'] == true) {
							count--;
							break;
						}
					}
					check[current - 'a'] = true;
				}

			}
		}

		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}

}
