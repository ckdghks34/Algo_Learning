package com.ssafy.Baekjoon._210218;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_1987_알파벳 {
	
	static int R,C;
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int max = Integer.MIN_VALUE;
	static List<Character> ispast = new ArrayList<Character>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0 ; i < R ; ++i)
		{
			String tmps = br.readLine();
			for(int j = 0; j < C; ++j)
			{
				map[i][j] = tmps.charAt(j);
			}
		}
		ispast.add(map[0][0]);
		move(0,0,1);
		bw.write(Integer.toString(max));
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void move(int x, int y, int cnt) {
		
		for(int i = 0; i < 4;++i)
		{
			boolean flag = true;
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<= nx && nx < C && 0<=ny && ny < R)
			{
				for(int j = 0, size = ispast.size(); j < size;++j)
				{
					if(map[ny][nx] == ispast.get(j))
					{
						flag = false;
						break;
					}
				}
				if(flag)
				{
					ispast.add(map[ny][nx]);
					move(nx,ny,cnt+1);
					ispast.remove(ispast.size()-1);
				}
			}
		}
		max = Math.max(max, cnt);
	}
}
