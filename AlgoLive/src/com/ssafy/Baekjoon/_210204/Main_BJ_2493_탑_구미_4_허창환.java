package com.ssafy.Baekjoon._210204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_2493_탑_구미_4_허창환 {

	static Stack<int[]> s = new Stack<>();
	static int[] r;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		r = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for(int i = 1; i <= N; ++i)
		{
			int v = Integer.parseInt(st.nextToken());
			
			while(!s.isEmpty())
			{
				if(s.peek()[1] > v)
				{
					r[i-1] = s.peek()[0];
					s.push(new int[] {i,v});
					break;
				}
				else
					s.pop();
			}
			
			if(s.isEmpty())
			{	
				r[i-1] =0;
				s.push(new int[] {i,v});
			}
			
		}
		
		for(int a : r)
			System.out.print(a+" ");
		
		br.close();
	}
}
