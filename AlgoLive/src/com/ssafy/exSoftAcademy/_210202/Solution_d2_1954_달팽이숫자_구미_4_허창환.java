package com.ssafy.exSoftAcademy._210202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_d2_1954_달팽이숫자_구미_4_허창환 {

	static int x, y;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/ES_input_d2_1954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int num;

		for (int tc = 0; tc < T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			num = 1;
			int width = N;
			int height = N - 1;
			x = 0;
			y = -1;

			while (num <= N * N) {
				for (int i = 0; i < width; ++i)
					arr[x][++y] = num++;
				width--;

				for (int i = 0; i < height; ++i)
					arr[++x][y] = num++;
				height--;

				for (int i = 0; i < width; ++i)
					arr[x][--y] = num++;
				width--;

				for (int i = 0; i < height; ++i)
					arr[--x][y] = num++;
				height--;
			}
			
			System.out.println("#"+(tc+1));
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (j == N - 1) {
						System.out.print(arr[i][j]);
						continue;
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
