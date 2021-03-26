package com.ssafy.exSoftAcademy._210324;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_다시볼것 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("./res/ES_input_d4_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		int T = Integer.parseInt(br.readLine());
		int N;
		int[][] island;
		double E;

		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());

			island = new int[N][2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][1] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());

			double[][] adjMatrix = new double[N][N];
			boolean[] visited = new boolean[N];
			double[] minEdge = new double[N];

			// 인접 행렬
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;

					// 거리 구해서 값 넣기
					adjMatrix[i][j] = Math.pow(island[i][0] - island[j][0], 2) + Math.pow(island[i][1] - island[j][1], 2);
				}

				minEdge[i] = Double.MAX_VALUE;
			}

			double result = 0;
			minEdge[0] = 0;

			for (int i = 0; i < N; i++) {

				double min = Double.MAX_VALUE;
				int minVertex = 0;
				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > minEdge[j]) {
						min = minEdge[j];
						minVertex = j;
					}
				}

				result += min;
				visited[minVertex] = true;

				for (int j = 0; j < N; j++) {
					if (!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
						minEdge[j] = adjMatrix[minVertex][j];
					}
				}
			}

			sb.append(Math.round(result * E));

			System.out.println(sb.toString());
		}
	}
}
