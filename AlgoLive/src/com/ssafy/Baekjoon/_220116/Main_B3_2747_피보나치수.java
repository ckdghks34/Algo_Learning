package com.ssafy.Baekjoon._220116;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_B3_2747_피보나치수 {
	static int N;
	static int[] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		data = new int[N + 1];
		data[0] = 0;
		data[1] = 1;

		bw.write(Integer.toString(pivonacci(N)));
		bw.flush();
		bw.close();
		br.close();
	}

	static int pivonacci(int index) {

		if (index == 1)
			return 1;
		if (index == 0)
			return 0;

		if (data[index] != 0)
			return data[index];

		data[index] = pivonacci(index - 1) + pivonacci(index - 2);

		return data[index];

	}
}
