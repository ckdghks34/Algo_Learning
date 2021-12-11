package com.ssafy.Baekjoon._211212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S3_2606_바이러스 {

	public static int[][] computer;
	public static boolean[] visited;
	public static int max = 0;
	public static int N, pair;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];

		computer = new int[pair + 1][2];

		for (int i = 1; i <= pair; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			computer[i][0] = j;
			computer[i][1] = k;
		}
		visited[1] = true;
		for (int i = 1; i <= pair; ++i) {
			if (computer[i][0] == 1)
				dfs(computer[i][1]);
		}

		System.out.println(max);
	}

	public static void dfs(int i) {
		if (visited[i])
			return;

		visited[i] = true;
		max++;
		for (int j = 1; j <= pair; ++j) {
			// 양방향으로 연결되어 있기 때문에, computer[i] 양쪽을 둘 다 확인해야함.
			if(computer[j][0] == i)
				dfs(computer[j][1]);
			if(computer[j][1] == i)
				dfs(computer[j][0]);
		}
	}

}
