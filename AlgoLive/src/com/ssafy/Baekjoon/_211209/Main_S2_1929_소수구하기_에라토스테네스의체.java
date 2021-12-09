package com.ssafy.Baekjoon._211209;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_1929_소수구하기_에라토스테네스의체 {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m+1];
		
		// 소수이면 0, 소수가 아니면 1
		// 0과 1은 소수가 아니기 때문에 미리 변경해준다.
		arr[0] = 1;
		arr[1] = 1;
		
		// 2부터 시작해서 i의 배수를 모두 제외해줌.
		for(int i = 2; i*i <= m; ++i)
		{
			if(arr[i] == 1)
				continue;

			for(int j = i*i; j<=m; j+=i)
			{
				arr[j] = 1;
			}
			
		}
		
		for(int i = n; i <= m;++i)
		{
			if(arr[i] == 0)
				{
					sb.append(i);
					sb.append("\n");
				}
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
