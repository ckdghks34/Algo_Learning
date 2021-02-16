package com.ssafy.Baekjoon._210216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_BJ_2839_설탕배달 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		bw.write(Integer.toString(getMin(N)));
		bw.flush();
		
		br.close();
		bw.close();
	}

	static int getMin(int sugar) {
		int min = 0;
		
		
		if (sugar == 4 || sugar == 7)
			return -1;
		
		if(sugar == 3)
			return 1;
		
		if(sugar >= 5)
		{
			if(sugar % 5 == 0)
				min = sugar/5;
			else
			{
				if(sugar % 5 == 1 || sugar % 5 == 3)
					min = sugar/5 +1;
				else
					min = sugar/5 +2;
			}
		}
		
		return min;
	}
}
