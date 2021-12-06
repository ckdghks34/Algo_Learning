package com.ssafy.Baekjoon._211206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_11050_이항계수 {

	public static int N, K, count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		count = 0;
		
		Combination(0,0);
		System.out.println(count);
	}
	private static void Combination(int start,int select) {
		if(select == K)
			count++;
		
		for(int i = start ; i < N;++i)
		{
			Combination(i+1, select+1);
		}
		
	}

}
