package com.ssafy.Baekjoon._211229;

import java.util.*;
import java.io.*;

public class Main_G4_1967_트리의지름 {
	public static int N;
	public static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
	public static int max, max_index;

	public static boolean[] vertex;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		max_index = 1;

		for (int i = 0; i <= N; ++i)
			list.add(new ArrayList<int[]>());

		for (int i = 0; i < N-1; ++i) {
			st = new StringTokenizer(br.readLine());

			int parents = Integer.parseInt(st.nextToken());
			int children = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(parents).add(new int[] {children,weight});
			list.get(children).add(new int[] {parents,weight});
		}

		vertex = new boolean[N + 1];
		dfs(1, 0);

		vertex = new boolean[N + 1];
		dfs(max_index, 0);

		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int x, int weight) {
		if (vertex[x])
			return;

		if (weight > max) {
			max = weight;
			max_index = x;
		}

		vertex[x] = true;

		for (int i = 0; i < list.get(x).size(); ++i) {
			if (!vertex[list.get(x).get(i)[0]]) {
				dfs(list.get(x).get(i)[0], weight + list.get(x).get(i)[1]);
			}
		}
	}
}
