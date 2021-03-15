package com.ssafy.Baekjoon._210225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main_BJ_2635_수이어가기 {

	static Queue<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		// 입력
		// 큐 선언
		// 반복
		// 	list에 입력값, i값  add
		// 	현재 (index-2)-(index-1) 값이 크다면 list에 add , 작다면 반복중단
		// 조건
		//  max가 cnt 보다 작으면
		//  max에 cnt값 저장
		//  큐를 비우고 list의 값들을 순서대로 큐에 저장
		// 큐의 원소값 하나씩 출력
		
		int N = Integer.parseInt(br.readLine());
		int max = 0;

		for (int i = 1; i <= N; ++i) {
			int cnt = 2;
			int index = 2;

			List<Integer> list = new ArrayList<>();
			list.add(N);
			list.add(i);

			while (true) {
				if (list.get(index-2) - list.get(index-1) < 0) 
					break;
					
				list.add(list.get(index-2) - list.get(index-1));
				index++;
				cnt++;
			}

			if (cnt > max) {
				max = cnt;
				q.clear();
				for(int j = 0; j < index;++j)
					q.offer(list.get(j));
			}

		}
		StringBuilder sb = new StringBuilder();
		
		int size = q.size();
		sb.append(size).append("\n");
		
		for(int i =0;i<size;++i)
			sb.append(q.poll()).append(" ");
		
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}

}
