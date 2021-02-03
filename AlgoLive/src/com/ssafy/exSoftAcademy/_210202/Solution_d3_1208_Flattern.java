package com.ssafy.exSoftAcademy._210202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d3_1208_Flattern {

	static int[] arr = new int[100];
	static int[] result = new int[10];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/ES_input_d3_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 0; tc < 10; ++tc)
		{
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for(int i = 0; i <100; ++i)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < dump; ++i)
			{
				Arrays.sort(arr);
				arr[99]--; 
				arr[0]++;
			}
			
			Arrays.sort(arr);
			result[tc] = arr[99] - arr[0];
		}
		
		for(int i = 0 ; i < 10; ++i)
			System.out.println("#" + (i+1) + " " + result[i]);
	}

}
