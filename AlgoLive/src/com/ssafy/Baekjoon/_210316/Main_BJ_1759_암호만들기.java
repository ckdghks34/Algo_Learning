package com.ssafy.Baekjoon._210316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1759_암호만들기 {

	static boolean[] isSelected;
	static char[] pw;
	static char[] arr;
	static int L, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		pw = new char[L];
		isSelected = new boolean[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		System.out.println(arr);
		per(0, 0);

		br.close();
	}

	public static void per(int start, int cnt) {
		if (cnt == L) {
			StringBuilder sb = new StringBuilder();
			int Checkcollection = 0;
			int Checkconsonant = 0;
			for (char c : pw) {
				if (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o')
					Checkcollection++;
				else
					Checkconsonant++;
				
				sb.append(c);
			}

			if (Checkcollection > 0 && Checkconsonant > 1) {
				System.out.println(sb.toString());
			}
			return;
		}

		for (int i = start; i < C; ++i) {
			pw[cnt] = arr[i];
			per(i + 1, cnt + 1);
		}
	}
}
