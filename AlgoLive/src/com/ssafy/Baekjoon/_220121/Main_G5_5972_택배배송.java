package com.ssafy.Baekjoon._220121;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_5972_택배배송 {
	public static int N, M;
	public static final int INF = Integer.MAX_VALUE / 2;
	public static ArrayList<ArrayList<int[]>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; ++i)
			list.add(new ArrayList<>());

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new int[] { to, weight });
			list.get(to).add(new int[] { from, weight });
		}

		bw.write(Integer.toString(dijkstra()));
		bw.flush();
		bw.close();
		br.close();
	}

	public static int dijkstra() {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int[] distance = new int[N + 1];
		Arrays.fill(distance, INF);
		distance[1] = 0;
		queue.offer(new int[] { 1, 0 });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			if (current[0] == N)
				return distance[N];

			for (int i = 0; i < list.get(current[0]).size(); ++i) {
				int cost = distance[current[0]] + list.get(current[0]).get(i)[1];

				if (distance[list.get(current[0]).get(i)[0]] > cost) {
					distance[list.get(current[0]).get(i)[0]] = cost;
					queue.offer(new int[] { list.get(current[0]).get(i)[0], cost });
				}
			}

		}

		return distance[N];
	}
}
