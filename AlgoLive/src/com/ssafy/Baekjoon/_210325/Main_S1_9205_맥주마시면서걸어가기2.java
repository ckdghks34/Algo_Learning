package com.ssafy.Baekjoon._210325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_9205_맥주마시면서걸어가기2 {
	static int N;
	static int arr[][];
	static boolean visited[];
	static ArrayList<Integer> list[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());

			list = new ArrayList[N + 2];
			visited = new boolean[N + 2];
			for (int i = 0; i < N + 2; i++)
				list[i] = new ArrayList<>();

			arr = new int[N + 2][2];

			

			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				arr[i][0] = x;
				arr[i][1] = y;
			}

			for (int i = 0; i < N + 1; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					float dist = (float) ((Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1])) / 50.0);
					if (dist <= 20) {
						list[i].add(j);
						list[j].add(i);
					}
				}
			}

			if (bfs())
				System.out.println("happy");
			else
				System.out.println("sad");

		}
	}

	private static boolean bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0] = true;

		while (!queue.isEmpty()) {
			int index = queue.poll();
			if (index == N + 1)
				return true;

			for (int i = 0; i < list[index].size(); i++) {
				if (!visited[list[index].get(i)]) {
					visited[list[index].get(i)] = true;
					queue.add(list[index].get(i));
				}
			}
		}
		return false;
	}
}
