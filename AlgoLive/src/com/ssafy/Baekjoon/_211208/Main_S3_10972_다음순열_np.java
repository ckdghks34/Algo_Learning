package com.ssafy.Baekjoon._211208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S3_10972_다음순열_np {

	public static int n;
	public static int[] data;
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
		
		Permutation();
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void Permutation()
	{
		int i = n-1;
		while(i>0 && data[i-1] >= data[i])
			--i;
		
		if(i == 0)
		{	
			sb.append(-1);
			return;
		}
		
		int j = n-1;
		while(data[i-1] >= data[j])
			--j;
		
		swap(i-1,j);
		
		int k = n-1;
		while(k > i)
		{
			swap(i++,k--);
		}
		
		for(int t = 0; t < n; ++t)
		{
			sb.append(data[t]);
			sb.append(" ");
		}
		
		return;
	}
	
	public static void swap(int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
		
	}
}
