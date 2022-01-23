package com.ssafy.Baekjoon._220124;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G5_1068_트리 {
	public static int N = 0, R = 0, Root = 0, Leaf = 0;
	public static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	public static int count;
	public static final int REMOVE_DATA = Integer.MIN_VALUE / 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i)
			tree.add(new ArrayList<>());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; ++i) {
			int parent = Integer.parseInt(st.nextToken());

			if (parent == -1)
				Root = i;
			else {
				tree.get(i).add(parent);
				tree.get(parent).add(i);
			}
		}

		R = Integer.parseInt(br.readLine());

		if (R != Root) {
			boolean[] visited = new boolean[N];
			dfs(Root, visited);
		}

		bw.write(Integer.toString(Leaf));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int node, boolean[] visited) {
		int children = 0;
		visited[node] = true;

		for (int i = 0; i < tree.get(node).size(); ++i) {
			int nextNode = tree.get(node).get(i);
			if (!visited[nextNode]) {
				if (nextNode != R) {
					children++;
					dfs(nextNode, visited);
				}
			}
		}

		if (children == 0)
			Leaf++;

	}
}
