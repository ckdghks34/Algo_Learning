package com.ssafy.Baekjoon._210317;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14889_스타트와링크 {

	static int[][] map;
	static int[] select;
	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		select = new int[N / 2];
		
		StringTokenizer st;

		
		// 입력
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		com(0,0);
		System.out.println(min);
	}

	public static void com(int start, int cnt) {
		if (cnt == N / 2) {
			int[] team1 = new int[N/2];
			int[] team2 = new int[N/2];
			boolean[] checkselect = new boolean[N];
			int a = 0, b = 0;
			int index1 = 0,index2 = 0;
			
			for (int i = 0; i < N/2; i++) 
				checkselect[select[i]] = true;
			
			for(int i = 0; i < N;++i)
			{
				if(checkselect[i])
					team1[index1++] = i;
				else
					team2[index2++] = i;
			}
			
			for (int i = 0; i < N/2; i++) {
				for(int j = i+1 ; j < N/2;++j) {
					a += map[team1[i]][team1[j]] + map[team1[j]][team1[i]];
					b += map[team2[i]][team2[j]] + map[team2[j]][team2[i]];
				}
			}
			
			min = Math.min(min, Math.abs(b-a));
			return;
		}

		for (int i = start; i < N; ++i) {
			select[cnt] = i;
			com(i + 1, cnt + 1);
		}

	}
}
