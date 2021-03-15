package com.ssafy.Baekjoon._210225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_BJ_2851_슈퍼마리오 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] map = new int[10];
		int sum = 0;

		for (int i = 0; i < 10; ++i)
			map[i] = Integer.parseInt(br.readLine());

		for (int i = 0; i < 10; ++i) {
			int tmp = sum + map[i];
			
			if (tmp == 100) {
				sum = tmp;
				break;
			} else if (tmp < 100) {
				sum = tmp;

			} else {
				if (tmp - 100 <= 100 - sum)
					sum = tmp;
				break;
			}
		}

		System.out.println(sum);
		bw.close();
		br.close();
	}

}