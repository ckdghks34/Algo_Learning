package com.ssafy.Baekjoon._211223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S2_2644_촌수계산 {
	public static int N, M, start, end;
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static boolean[] visited;
	public static int result = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		st = new StringTokenizer(br.readLine(), " ");

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; ++i)
			list.add(new ArrayList<Integer>());

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());

			list.get(parent).add(child);
			list.get(child).add(parent);
		}
		dfs(start, end, 0);
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int start, int end, int count) {
		if (start == end) {
			result = count;
			return;
		}

		visited[start] = true;
		for (int i = 0; i < list.get(start).size(); ++i) {
			if (!visited[list.get(start).get(i)])
				dfs(list.get(start).get(i), end, count + 1);
		}

	}
}