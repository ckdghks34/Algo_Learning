package com.ssafy.Baekjoon._211206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_6603_로또 {

	public static int k = 1;
	public static int S[];
	public static int select[];
	
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			
			k = Integer.parseInt(st.nextToken());
			if(k == 0)
			{
				break;
			}
			S = new int[k];
			select = new int[k];

			// 숫자 조합 저장
			for (int i = 0; i < k; ++i)
				S[i] = Integer.parseInt(st.nextToken());

			Combination(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void Combination(int start, int count) {
		if (count == 6) {
			for (int i = 0; i < 6; ++i) {
				sb.append(Integer.toString(select[i]));
				sb.append(" ");
			}
			sb.append("\n");
		}
		for (int i = start; i < k; ++i) {
			select[count] = S[i];
			Combination(i + 1, count + 1);
		}
	}
}
