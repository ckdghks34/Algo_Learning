package com.ssafy.exSoftAcademy._210325;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d6_1263_사람네트워크2 {
	
	static final int INF = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./res/ES_input_d6_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			
			int min = Integer.MAX_VALUE;
			int[][] map = new int[n][n];

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && map[i][j] == 0)
					{
						map[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < n; ++k) {
				for (int i = 0; i < n; i++) {
					if(i==k) continue;
					for (int j = 0; j < n; j++) {
						if(i==j || k==j) continue;
						if (map[i][k] != INF && map[k][j] != INF && map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] =	 map[i][k] + map[k][j];
						}
					}
				}
			}
			
			for(int i =0 ; i < n; ++i)
			{
				int sum = 0;
				for(int j = 0; j < n; ++j)
				{
					if(map[i][j] != INF)
						sum += map[i][j];
				}
				
				min = Math.min(min, sum);
			}
			
			sb.append(min);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}

}
