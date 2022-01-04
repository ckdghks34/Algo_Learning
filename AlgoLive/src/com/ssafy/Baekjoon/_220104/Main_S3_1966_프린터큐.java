package com.ssafy.Baekjoon._220104;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S3_1966_프린터큐 {

	public static int T;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			ArrayList<int[]> queue = new ArrayList<>();
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int count = 0;
			for (int i = 0; i < N; ++i) {
				int weight = Integer.parseInt(st.nextToken());
				if (i == M)
					queue.add(new int[] { weight, 1 });
				else
					queue.add(new int[] { weight, 0 });
			}

			while (!queue.isEmpty()) {
				int[] current = queue.get(0);
				boolean out = true;
				
				for (int i = 1; i < queue.size(); ++i) {
					if (current[0] < queue.get(i)[0]) {
						queue.remove(0);
						queue.add(current);
						out = false;
						break;
					}
				}

				if (out) {
					queue.remove(0);
					count++;
					if(current[1] == 1)
						break;
				}
			}
			sb.append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
