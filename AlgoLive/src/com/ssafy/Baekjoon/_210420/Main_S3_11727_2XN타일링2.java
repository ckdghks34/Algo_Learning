package com.ssafy.Baekjoon._210420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_11727_2XN타일링2 {

	static int[] tile;
	static int p = 10007;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		tile = new int[n + 1];
		tile[0] = 0;
		tile[1] = 1;
		tile[2] = 3;
		for (int i = 3; i <= n; ++i)
			tile[i] = (tile[i - 1] + (tile[i - 2] * 2)) % p;

		System.out.println(tile[n]);
	}

}
