package com.ssafy.Baekjoon._211216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_S4_2108_통계학 {

	public static int N;
	public static int[] data;
	public static int[] result;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		data = new int[N];
		result = new int[4];

		int sum = 0;
		for (int i = 0; i < N; ++i) {
			data[i] = Integer.parseInt(br.readLine());
			sum += data[i];
		}

//		if (N == 1) {
//			sb.append(data[0]);
//			sb.append("\n");
//			sb.append(data[0]);
//			sb.append("\n");
//			sb.append(data[0]);
//			sb.append("\n");
//			sb.append(0);
//		} else {
		Arrays.sort(data);

		result[0] = (int) Math.round((double) sum / N);
		result[1] = data[N / 2];
		result[2] = mode();
		result[3] = data[N - 1] - data[0];

		sb.append(Integer.toString((int) Math.round((double) sum / N)));
		sb.append("\n");
		sb.append(Integer.toString(data[N / 2]));
		sb.append("\n");
		sb.append(Integer.toString(mode()));
		sb.append("\n");
		sb.append(Integer.toString(data[N - 1] - data[0]));
		sb.append("\n");
//		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int mode() {
		ArrayList<Integer> list = new ArrayList<>();
		int[] count = new int[8001];
		int max = 0;
		for (int i = 0; i < N; ++i) {
			count[data[i] + 4000]++;
			if (count[data[i] + 4000] > max) {
				max = count[data[i] + 4000];
				list.clear();
				list.add(data[i]);
			} else if (count[data[i] + 4000] == max)
				list.add(data[i]);
		}
		Collections.sort(list);
		if (list.size() > 1)
			return list.get(1);
		else
			return list.get(0);
	}
}
