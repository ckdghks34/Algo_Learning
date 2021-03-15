package com.ssafy.Baekjoon._210225;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BJ_2527_직사각형_미완성 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] sq1 = new int[4];
		int[] sq2 = new int[4];
		for (int i = 0; i < 4; ++i)
			sq1[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 4; ++i)
			sq2[i] = Integer.parseInt(st.nextToken());

		// a
		// 첫번째 사각형에 두번째 사각형
		if ((sq1[0] < sq2[0] && sq2[0] < sq1[2]) || (sq1[0] < sq2[2] && sq2[2] < sq1[2])) 
		{
		}
		// b

		// c

		// d

	}

	public static class Square {
		int x, y, p, q;

		public Square(int x, int y, int p, int q) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}

	}
}
