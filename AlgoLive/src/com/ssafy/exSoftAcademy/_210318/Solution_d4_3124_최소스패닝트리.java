package com.ssafy.exSoftAcademy._210318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_3124_최소스패닝트리 {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight - o.weight;
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int V, E;
	static int parents[];
	static Edge[] edgeList;

	static void make() { // 크기가 1인 단위집합을 만든다.
		for (int i = 0; i < V; ++i) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("./res/ES_input_d4_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			parents = new int[V];
			edgeList = new Edge[E];

			for (int i = 0; i < E; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				edgeList[i] = new Edge(from, to, weight);
			} // 간선리스트

			// 1. 간선리스트 가중치 기준 오름차순 정렬
			Arrays.sort(edgeList);

			make();
			int result = 0;
			int count = 0; // 선택한 간선 수

			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) // 싸이클이 발생하지 않았다면
				{
					result += edge.weight;
					if (++count == V - 1)
						break;
				}
			}
			sb.append("#").append(tc).append(" ").append(result);
			if(tc == T)
				System.out.print(sb.toString());
			else{
				System.out.println(sb.toString());
			}
		}
	}

}
