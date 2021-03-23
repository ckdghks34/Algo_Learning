package com.ssafy.exSoftAcademy._210318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_3289_서로소집합 {

	static int N, M;
	static int[] parents;

	public static void make() {
		for(int i =0 ; i < N;++i)
			parents[i] = i;
	}
	
	public static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)
			return;
		parents[bRoot] = aRoot;
	}
	
	public static int check(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)
			return 1;
		else
			return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			parents = new int[N];
			make();
			
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int select = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				if(select == 0)
					union(a, b);
				else
					sb.append(check(a,b));
			}
			System.out.println(sb.toString());
		}

	}

}
