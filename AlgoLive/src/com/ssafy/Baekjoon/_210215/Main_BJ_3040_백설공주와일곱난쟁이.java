package com.ssafy.Baekjoon._210215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_3040_백설공주와일곱난쟁이 {
	static int cap[] = new int[9];
	static int tmp[] = new int[7];
	static boolean flag;
	public static void main(String[] args) throws IOException,NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i =0 ; i <9 ; ++i)
			cap[i] = Integer.parseInt(br.readLine());
		
		combi(0,0);
		
		for(int a: tmp)
			System.out.println(a);
		
	}
	
	static public void combi(int cnt, int start) {

		if(cnt == 7)
		{
			int sum = 0;
			for(int i = 0; i < 7;++i)
				sum += tmp[i];
			
			if(sum == 100)
				flag = true;
			return;
		}
		
		for(int i = start; i < 9;++i)
		{
			if(flag)
				return;
			
			tmp[cnt] = cap[i];
			combi(cnt+1,i+1);
		}
		
	}

}
