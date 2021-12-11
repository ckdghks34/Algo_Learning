package com.ssafy.Baekjoon._211210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_1722_순열의순서 {

	public static StringBuilder sb = new StringBuilder();
	public static int n, m,count;
	public static int[] data;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		count = 1;
		data = new int[n];
		
		for(int i =0 ; i <n;++i)
			data[i] = i+1;
		
		if (m == 1) {
			int k = Integer.parseInt(st.nextToken());
			System.out.println(sb.length() == 0);
			while(sb.length() == 0)
				selectOne(k);
			
		} else {
			int[] select = new int[n];
			for(int i =0; i < n;++i)
				select[i] = Integer.parseInt(st.nextToken());
			while(sb.length() == 0)
				selectTwo(select);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void selectOne(int k) {
		
		int i= n-1;
		while(i>0 && data[i-1] >= data[i])
			--i;
		
		int j = n-1;
		while(data[i-1] >= data[j])
			--j;
		
		swap(i-1,j);
		
		int t = n-1;
		while(t>i)
			swap(t--,i++);
		
		count++;
		
		if(count == k)
		{
			for(int a= 0; a < n;++a)
			{
				sb.append(data[a]);
				sb.append(" ");
			}
		}
	}

	public static void selectTwo(int[] select) {
		int i = n-1;
		while(i > 0 && data[i-1] > data[i])
			--i;
		
		int j = n-1;
		while(data[i-1] > data[j])
			--j;
		
		swap(i-1,j);
		
		int k= n-1;
		while(k>i)
			swap(i++,k--);
		
		count++;
		
		if(Arrays.equals(data, select))
		{
			sb.append(count);
		}
	}
	
	public static void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
