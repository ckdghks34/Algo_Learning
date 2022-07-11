package com.ssafy.Baekjoon._220711;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;

public class Main_B1_9933_민균이의비밀번호_HashMap {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 결과 변수 초기화
		int resultlen = 0;
		char resultalp = ' ';
		
		// 목록 개수 입력
		int N = Integer.parseInt(br.readLine());
		HashMap<String, String> list = new HashMap<>();
		
		// 목록 저장
		for(int i =0 ;i < N; ++i)
		{
			String str = br.readLine();
			list.put(str,str);
		}
		
		Iterator<String> it = list.values().iterator();
		while(it.hasNext())
		{
			sb.append(it.next());
			String reverse = sb.reverse().toString();
			
			if(list.containsValue(reverse))
			{
				resultlen = reverse.length();
				resultalp = reverse.charAt(resultlen/2);
				break;
			}
			sb.setLength(0);
		}
		
		sb.setLength(0);
		sb.append(resultlen).append(" ").append(resultalp);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
