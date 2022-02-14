package com.ssafy.Baekjoon._220214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S2_1931_회의실배정 {
	public static int N, count;
	public static int[][] meeting;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		meeting = new int[N][2];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			meeting[i][0] = Integer.parseInt(st.nextToken()); // 시작하는 시간
			meeting[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
		}

		// 종료시간을 기준으로 오름차순 정렬을 하고, 종료시간이 같다면 시작시간 기준으로 오름차순으로 정렬한다.
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] - o2[1] == 0)
					return o1[0] - o2[0];

				return o1[1] - o2[1];
			}
		});

		// 가장 먼저 끝나는 시간을 시작으로 함
		int end = meeting[0][1];
		count = 1;

		for (int i = 1; i < N; ++i) {
			// 종료시간이 다음 시작시간보다 작거나 같으면
			if (end <= meeting[i][0]) {
				// 종료시간을 바꿔줌
				end = meeting[i][1];
				count++;
			}
		}

		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
