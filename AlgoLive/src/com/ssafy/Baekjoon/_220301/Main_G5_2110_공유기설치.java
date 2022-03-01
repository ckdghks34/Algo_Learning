package com.ssafy.Baekjoon._220301;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_2110_공유기설치 {
	public static int N, C;
	public static long max;
	public static long[] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		data = new long[N];
		for (int i = 0; i < N; ++i) {
			data[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(data);

		long left = 1;
		long right = data[N - 1] - data[0];

		while (left <= right) {
			long mid = (left + right) / 2;
			int cnt = check(mid);

			if (cnt >= C) {
				left = mid + 1;
				max = Math.max(mid, max);
			} else {
				right = mid - 1;
			}
		}
		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int check(long dis) {
		int count = 0;
		long last = data[0];

		count++;
		for (int i = 1; i < data.length; ++i) {
			long current = data[i];

			long sub = current - last;
			if (dis <= sub) {
				count++;
				last = current;
			}
		}

		return count;
	}
}
