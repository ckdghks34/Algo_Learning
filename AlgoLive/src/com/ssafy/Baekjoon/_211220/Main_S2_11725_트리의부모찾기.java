package com.ssafy.Baekjoon._211220;

import java.util.*;
import java.io.*;

public class Main_S2_11725_트리의부모찾기 {

	public static int N;
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visited;
	public static int[] parents;
	public static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		parents = new int[N + 1];
		list = new ArrayList<ArrayList<Integer>>();
		
		// 그래프 저장을 위해 ArrayList 배열 생성
		for(int i = 0; i < N+1;++i) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 1; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			// 양방향 그래프이기 때문에 양쪽 모두에 추가
			list.get(n).add(m);
			list.get(m).add(n);
		}
		
//		dfs(1);
		bfs(1);
		
		// 2번째 줄부터 출력
		for (int i = 2; i <= N; ++i)
			sb.append(parents[i]).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int x) {
		
		// 방문 했다면 종료
		if (visited[x])
			return;

		// 방문처리
		visited[x] = true;

		for (int i = 0; i < list.get(x).size(); ++i) {
			if (!visited[list.get(x).get(i)]) {
				// 루트 (1)에서 Top-bottom 으로 가기 때문에 부모를 알 수 있다.
				parents[list.get(x).get(i)] = x;
				dfs(list.get(x).get(i));
			}
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			visited[current] = true;
			
			for(int i = 0; i < list.get(current).size();++i)
			{
				if(!visited[list.get(current).get(i)])
				{
					parents[list.get(current).get(i)] = current;
					queue.add(list.get(current).get(i));
				}
			}
			
		}
	}
}
