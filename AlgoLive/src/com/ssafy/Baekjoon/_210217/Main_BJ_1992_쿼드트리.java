package com.ssafy.Baekjoon._210217;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_BJ_1992_쿼드트리 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/BJ_input_1992.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			for (int j = 0; j < N; ++j)
				map[i][j] = s.charAt(j)-'0';
		}
		
		devide(map, N, 0, 0);

	}

	public static void devide(int[][] map, int n,int x, int y) {
		int half = n / 2;
		int tmp = map[y][x];
		boolean flag = false;
		
		for (int i = y; i < y+n; ++i) {
			for (int j = x; j < x+n; ++j) {
				if (tmp != map[i][j]) {
					{
						flag = true;
						break;
					}
				}
			}
			if(flag)
				break;
		}
		
		if(flag)
		{
			System.out.print("(");
			devide(map, half, x,y);
			devide(map, half, x+half,y);
			devide(map, half, x,y+half);
			devide(map, half, x+half,y+half);
			System.out.print(")");
		}
		else
		{
			System.out.print(tmp);
		}
	}
}