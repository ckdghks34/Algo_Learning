package com.ssafy.exSoftAcademy._210202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_1210_Ladder1 {
	static int[][] map = new int [100][100];
	static int x= 0, y = 0;
	static int size = 100;
	static int[] result = new int[10];
	
	static boolean leftcheck() {
		if(y == 0)
			return false;
		
		if(map[x][y-1]==1)
			return true;
		
		return false;
	}
	
	static boolean rightcheck() {
		if(y == size-1)
			return false;
		
		if(map[x][y+1]==1)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/ES_input_d4_1210.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 0; tc < 10; ++tc)
		{
			boolean[][] visit = new boolean[100][100];
			
			int t = Integer.parseInt(br.readLine());
			
			// map 입력
			for(int i = 0; i < size; ++i)
			{
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				
				for(int j = 0; j < size ; ++j)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j] == 2)
					{
						x = i;
						y = j;
					}
				}
			}
			
			// 배열의 값이 2 위치부터 위로 올라간다.
			while(x != 0)
			{
				// 현재 위치 방문
				visit[x][y] = true;
				
				// 현재 위치에서 왼쪽 값이 1 이고 방문하지 않았다면
				if(leftcheck() && !visit[x][y-1] ) 
					y -= 1;
				// 현재 위치에서 오른쪽 값이 1 이고 방문하지 않았다면
				else if(rightcheck() && !visit[x][y+1])
					y += 1;
				else
					x -= 1;
			}
			
			result[t-1] = y;
		}
		
		for(int i=1;i<=10;++i)
			System.out.println("#"+ i + " " + result[i-1]);	
	}
}
