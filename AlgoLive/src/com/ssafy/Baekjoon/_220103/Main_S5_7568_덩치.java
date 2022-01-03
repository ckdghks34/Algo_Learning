package com.ssafy.Baekjoon._220103;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S5_7568_덩치 {

	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			list.add(new int[] { weight, height, 1 });
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (i == j)
					continue;

				if (list.get(i)[0] < list.get(j)[0] && list.get(i)[1] < list.get(j)[1])
					list.get(i)[2]++;
			}
			sb.append(list.get(i)[2]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
