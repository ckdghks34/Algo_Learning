package com.ssafy.Baekjoon._220214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S2_1931_회의실배정_Queue {
	public static int N, count;
	public static PriorityQueue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] - o2[1] == 0)
					return o1[0] - o2[0];

				return o1[1] - o2[1];
			}
		});

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			queue.offer(new int[] { start, end });
		}

		// 가장 먼저 끝나는 시간을 시작으로 함
		int end = queue.poll()[1];
		count = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			// 종료시간이 다음 시작시간보다 작거나 같으면
			if (end <= cur[0]) {
				// 종료시간을 바꿔줌
				end = cur[1];
				count++;
			}
		}

		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
