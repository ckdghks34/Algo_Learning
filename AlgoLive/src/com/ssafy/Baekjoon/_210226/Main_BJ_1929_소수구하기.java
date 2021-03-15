package com.ssafy.Baekjoon._210226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_1929_소수구하기 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		boolean flag = true;

		StringBuilder sb = new StringBuilder();

		for (int i = 2; i <= N; ++i) {
			sb = new StringBuilder();
			flag = true;

			if (i == 1)
				continue;
			
			for (int j = 0, size = list.size(); j < size; ++j) {
				if (i % list.get(j) == 0) {
					flag = false;
					break;

				}
			}

			if (flag) {
				list.add(i);
				if(i >= M && i <= N)
				System.out.println(i);
			}
		}
		br.close();
	}

}
