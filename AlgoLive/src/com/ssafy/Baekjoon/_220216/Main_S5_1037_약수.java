package com.ssafy.Baekjoon._220216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_1037_약수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		int result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			data[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(data);
		result = data[0] * data[N - 1];

		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}

}
