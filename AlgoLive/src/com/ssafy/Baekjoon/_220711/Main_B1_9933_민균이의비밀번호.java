package com.ssafy.Baekjoon._220711;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_B1_9933_민균이의비밀번호 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 결과 변수 초기화
		int resultlen = 0;
		char resultalp = ' ';
		
		// 목록 개수 입력
		int N = Integer.parseInt(br.readLine());
		String[] list = new String[N];
		
		// 목록 저장
		for(int i =0 ;i < N; ++i)
			list[i] = br.readLine();
		
		for(int i =0 ;i < N; ++i)
		{
			// 항상 답이 유일한 경우만 입력으로 주어지기 때문에
			// resultlen 값이 바뀌었다면 이미 답을 찾은것.
			// 불필요한 반복을 줄이기 위해 반복문 종료.
			if(resultlen != 0)
				break;
			
			sb.append(list[i]);
			
			String reverse = sb.reverse().toString();
			
			for(int j= 0; j < N ; ++j)
			{
				if(list[j].equals(reverse))
				{
					resultlen = reverse.length();
					resultalp = reverse.charAt(resultlen/2);
					break;
				}
			}
			
			// StrinBuilder 초기화
			sb.setLength(0);
		}
		sb.append(resultlen).append(" ").append(resultalp);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
