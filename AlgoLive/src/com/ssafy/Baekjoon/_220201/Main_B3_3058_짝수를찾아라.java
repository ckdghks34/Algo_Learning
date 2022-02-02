package com.ssafy.Baekjoon._220201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_B3_3058_짝수를찾아라 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> list;

		for (int tc = 1; tc <= T; ++tc) {
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int i = 0; i < 7; ++i) {
				int cur = Integer.parseInt(st.nextToken());

				if (cur % 2 == 0) {
					list.add(cur);
					sum += cur;
				}
			}

			Collections.sort(list);

			sb.append(sum).append(" ").append(list.get(0)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
