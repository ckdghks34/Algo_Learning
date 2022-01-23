package com.ssafy.Baekjoon._220123;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_S1_1325_효율적인해킹 {
	public static int N, M;
	public static int count = 0;
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static int[] answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[N + 1];

		boolean[] visited;

		for (int i = 0; i <= N; ++i)
			list.add(new ArrayList<>());

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list.get(to).add(from);
		}

		for (int i = 1; i <= N; ++i) {
			visited = new boolean[N + 1];
			visited[i] = true;
			dfs(i, i, visited);

			count = answer[i] > count ? answer[i] : count;
		}

		for (int i = 1; i <= N; ++i) {
			if (count == answer[i])
				sb.append(i).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int node, int start, boolean[] visited) {

		for (int i = 0; i < list.get(node).size(); ++i) {
			if (!visited[list.get(node).get(i)]) {
				visited[list.get(node).get(i)] = true;
				dfs(list.get(node).get(i), start, visited);
				answer[start]++;
			}
		}
	}
}
