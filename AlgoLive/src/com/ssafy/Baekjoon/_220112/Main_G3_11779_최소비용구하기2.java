package com.ssafy.Baekjoon._220112;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G3_11779_최소비용구하기2 {
	public static int N, M;
	public static int start, end;
	public static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
	public static int[] distance;
	public static int[] routes;
	static final int INF = 1000 * 100000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		distance = new int[N + 1];
		routes = new int[N + 1];

		for (int i = 0; i <= N; ++i) {
			list.add(new ArrayList<>());
			distance[i] = INF;
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new int[] { to, weight });
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		distance[start] = 0;

		dijkstra(start);

		int cnt = 0;
		ArrayList<Integer> routeList = new ArrayList<>();
		int current = end;
		while (current != 0) {
			cnt++;
			routeList.add(current);
			current = routes[current];
		}
		sb.append(distance[end]).append("\n");
		sb.append(cnt).append("\n");

		for (int i = routeList.size() - 1; i >= 0; --i)
			sb.append(routeList.get(i)).append(" ");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dijkstra(int start) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] - o2[1] == 0)
					return o1[0] - o2[0];

				return o1[1] - o2[1];
			}
		});

		queue.offer(new int[] { start, 0 });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int node = current[0];
			
			// 도착하면 while 종료
			if(node == end)
				break;
			
			for (int i = 0; i < list.get(node).size(); ++i) {
				int cost = distance[node] + list.get(node).get(i)[1];

				if (cost < distance[list.get(node).get(i)[0]]) {
					distance[list.get(node).get(i)[0]] = cost;
					routes[list.get(node).get(i)[0]] = node;
					queue.offer(new int[] { list.get(node).get(i)[0], cost });
				}
			}
		}
	}
}
