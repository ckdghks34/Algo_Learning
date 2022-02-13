package com.ssafy.Baekjoon._220213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_G5_2565_전깃줄 {
	public static int N, count;
	public static int[] dp;
	public static ArrayList<int[]> map = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		count = 0;
		dp = new int[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			map.add(new int[] { left, right });
		}

		Collections.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < N; ++i) {
			dp[i] = 1;
			find(i);
		}

		bw.write(Integer.toString(N - count));
		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int x) {
		if (dp[x] > 1)
			return dp[x];

		for (int i = x - 1; i >= 0; --i) {
			if (map.get(i)[1] < map.get(x)[1]) {
				dp[x] = Math.max(dp[x], find(i) + 1);
			}
		}
		count = Math.max(dp[x], count);

		return dp[x];
	}
}
