package com.ssafy.Baekjoon._220116;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S5_1476_날짜계산 {

	static int[] data = { 0, 0, 0 };
	static int cnt = 0;
	static int E, S, M;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		while (true) {
			cnt++;
			
			for (int i = 0; i < 3; ++i) {
				data[i]++;
			}
			if (data[0] > 15)
				data[0] = 1;
			if (data[1] > 28)
				data[1] = 1;
			if (data[2] > 19)
				data[2] = 1;
			
			if(data[0] == E && data[1] == S && data[2] == M)
			{
				break;
			}
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
		br.close();
	}

}
