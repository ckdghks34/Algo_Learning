package com.ssafy.exSoftAcademy._210203;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d3_2805_농작물수확하기_구미_4_허창환 {

	static int[][] farm;
	static int x =0,y =0;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d3_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc = 0; tc <T ; ++tc)
		{
			int N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			x = N/2;
			int result = 0;
			
			for(int i =0; i < N; ++i)
			{
				String tmp = br.readLine();
				for(int j = 0 ; j < N; ++j)
					 farm[i][j] = tmp.charAt(j)-'0';
			}
			
			// 위쪽삼각형
			for(int i = 0; i <= N/2 ; ++i)
			{
				for(int j =0 ; j < N; ++j)
				{
					if(j >= x-i && j <= x+i)
						result += farm[i][j];
				}
			}
			
			// 아래쪽삼각형
			for(int i = x+1; i < N ; ++i)
			{
				int k = N-i-1;
				for(int j = 0; j< N ;++j)
				{
					if(j >= x-k && j <= x+k)
						result += farm[i][j];
				}
			}
			
			
			System.out.println("#"+(tc+1)+" "+result);
			
		}
		
	}

}
