package com.ssafy.Baekjoon._210209;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1158_요세푸스문제 {

	//static LinkedList<Integer> list = new LinkedList<>();
	//static Queue<Integer> q = new LinkedList<>();
	static Deque<Integer> q = new ArrayDeque<>();
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; ++i) {
			q.offer(i);
		}
		
		sb.append("<");
		
		for(int i = 0 ; i <N;++i)
		{
			for(int j = 0; j < K ; ++j)
			{
				if(j == K-1)
				{
					sb.append(q.pollFirst());
					break;
				}
				q.offerLast(q.pollFirst());
			}
			sb.append(", ");
		}
		
		/*		
		int j = 0;
		for (int i = 1; i <= N; ++i) {
			list.add(i);
		}

		while (!list.isEmpty()) {
			j += K - 1;

			while(j>=list.size())
				j -= list.size();
			
			q.offer(list.remove(j));

		}

		sb.append("<");
		while (!q.isEmpty()) {
			sb.append(q.poll());
			sb.append(", ");
		}
		*/
		
		sb.setLength(sb.length() - 2);
		sb.append(">");
 		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
