package com.ssafy.Baekjoon._220129;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S4_2960_에라토스테네스의체 {
	public static int N, K;
	public static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 2; i <= N; ++i) {
			list.add(i);
		}

		int count = 0;
		int P = 0;
		boolean reach = false;

		while (!reach) {
			P = list.get(0);

			for (int i = 0; i < list.size(); ++i) {
				if (list.get(i) % P == 0) {
					count++;

					if (count == K) {
						bw.write(Integer.toString(list.get(i)));
						reach = true;
						break;

					}

					list.remove(i--);
				}
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}

}
