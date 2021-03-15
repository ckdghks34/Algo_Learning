package com.ssafy.Baekjoon._210225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2477_참외밭 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxW = Integer.MIN_VALUE;
		int indexW = 0;
		int maxH = Integer.MIN_VALUE;
		int indexH = 0;
		int[][] arr = new int[6][2];
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < 6; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

			if (arr[i][0] == 1 || arr[i][0] == 2) {
				if (maxW < arr[i][1]) {
					maxW = arr[i][1];
					indexW = i;
				}
			} else {
				if (maxH < arr[i][1]) {
					maxH = arr[i][1];
					indexH = i;
				}
			}
		}
		int totalBoard = maxW * maxH;
		int SW = 0;
		int SH = 0;

		if (indexW == 0)
			SH = Math.abs(arr[indexW + 1][1] - arr[5][1]);
		else if (indexW == 5)
			SH = Math.abs(arr[0][1] - arr[indexW - 1][1]);
		else
			SH = Math.abs(arr[indexW - 1][1] - arr[indexW + 1][1]);

		if (indexH == 0)
			SW = Math.abs(arr[indexH + 1][1] - arr[5][1]);
		else if (indexH == 5)
			SW = Math.abs(arr[0][1] - arr[indexH - 1][1]);
		else
			SW = Math.abs(arr[indexH - 1][1] - arr[indexH + 1][1]);

		System.out.println((totalBoard - (SW * SH)) * K);

	}

}
