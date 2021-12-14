package com.ssafy.Baekjoon._211214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S3_15652_N과M4 {

	public static int N,M;
	public static int[] selected;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		
		permutation(1,0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	public static void permutation(int start, int count) {
		if(count == M)
		{
			for(int i =0 ; i <M;++i)
			{
				sb.append(selected[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N;++i)
		{
			selected[count] = i;
			permutation(i,count+1);
		}
	}
}
