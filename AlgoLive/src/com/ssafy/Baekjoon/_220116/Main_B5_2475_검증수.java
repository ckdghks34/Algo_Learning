package com.ssafy.Baekjoon._220116;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B5_2475_검증수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int sum = 0;

		for (int i = 0; i < 5; ++i)
			sum += Math.pow(Integer.parseInt(st.nextToken()), 2);

		bw.write(Integer.toString(sum % 10));
		bw.flush();
		bw.close();
		br.close();

	}

}
