package com.ssafy.Baekjoon._211208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_10972_다음순열_1 {

	public static int n;
	public static boolean[] check;
	public static int[] select, data;
	public static boolean finded, complete = false;
	public static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		data = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i =0 ; i< n;++i)
			data[i] = Integer.parseInt(st.nextToken());
		
		check = new boolean[n];
		select = new int[n];
		
		
		Permutation(0);
		if(complete)
			bw.write(sb.toString());
		else
			bw.write("-1");
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static void Permutation(int count)
	{
		if(count == n)
		{
			if(finded)
			{
				for(int i = 0; i< n;++i)
				{
					sb.append(select[i]);
					sb.append(" ");
				}
				complete = true;
			}
			if(Arrays.equals(data, select))
			{
				finded = true;
			}
			
			return;
		}
		
		for(int i = 0;i<n;++i)
		{
			if(complete)
				return;
			if(!check[i])
			{
				select[count] = i+1;
				check[i] = true;
				Permutation(count+1);
				check[i] = false;
			}
		}
	}
}
