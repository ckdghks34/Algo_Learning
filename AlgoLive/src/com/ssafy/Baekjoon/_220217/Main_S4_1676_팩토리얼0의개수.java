package com.ssafy.Baekjoon._220217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S4_1676_팩토리얼0의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int count = 0;

		while (N >= 5) {
			count += N / 5;
			N /= 5;
		}

		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
