package com.ssafy.Baekjoon._210416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17471_게리맨더링_다시보기 {
	static int N;
	static int[] population, number;
	static int[][] map;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		population = new int[N];
		number = new int[N];
		map = new int[N][N];
		boolean isVisited[] = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; ++i)
			population[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			number[i] = size;

			for (int j = 0; j < size; ++j)
				map[i][Integer.parseInt(st.nextToken()) - 1] = 1;
		}

		for (int count = 1; count <= (N + 1) / 2; ++count)
			subset(count, 0, isVisited);

		if (min == Integer.MAX_VALUE)
			min = -1;

		System.out.println(min);
	}

	private static void subset(int count, int start, boolean isVisited[]) {
		if (count == 0) {
			List<Integer> alist = new ArrayList<Integer>();
			List<Integer> blist = new ArrayList<Integer>();

			int asum = 0;
			int bsum = 0;

			for (int i = 0; i < N; ++i) {
				if (isVisited[i]) {
					alist.add(i);
					asum += population[i];
				} else {
					blist.add(i);
					bsum += population[i];
				}
			}

			if (isConnected(alist) && isConnected(blist)) {
				min = Math.min(min, Math.abs(asum - bsum));
			}
			return;
		}

		for (int i = start; i < N; ++i) {
			isVisited[i] = true;
			subset(count - 1, i + 1, isVisited);
			isVisited[i] = false;
		}
	}

	private static boolean isConnected(List<Integer> list) {
		Queue<Integer> queue = new LinkedList<Integer>();

		int size = list.size();
		int start = 0;
		for (int i = 1; i < size; ++i)
			start = number[i] > number[i - 1] ? i : i - 1;

		boolean visited[] = new boolean[N];
		int count = 1;

		queue.offer(start);
		visited[list.get(0)] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 1; i < size; ++i) {
				if (!visited[list.get(i)] && map[current][list.get(i)] == 1) {
					count++;
					visited[list.get(i)] = true;
					queue.offer(i);
				}
			}
		}

		return count == size ? true : false;
	}
}
