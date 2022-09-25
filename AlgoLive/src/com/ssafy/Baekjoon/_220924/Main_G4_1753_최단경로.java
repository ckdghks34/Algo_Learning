package com.ssafy.Baekjoon._220924;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1753_최단경로 {
    /**
     * Input
     * 5 6
     * 1
     * 5 1 1
     * 1 2 2
     * 1 3 3
     * 2 3 4
     * 2 4 5
     * 3 4 6
     */

    /**
     * Output
     * 0
     * 2
     * 3
     * 7
     * INF
     */

    final static int INFINITY = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int V = Integer.parseInt(st.nextToken()); // 정점 갯수
        int E = Integer.parseInt(st.nextToken()); // 간선 갯수
        int start = Integer.parseInt(br.readLine()); // 시작점 인덱스

        int[][] matrix = new int[V + 1][V + 1]; // 인접행렬 생성
        int[] distance = new int[V + 1];    // 각 정점까지의 최단 거리 저장 할 곳
        boolean[] visited = new boolean[V + 1];  // 방문여부

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            matrix[row][col] = val;

        }

        Arrays.fill(distance, INFINITY);

        // 현재 정점에서 현재정점으로 가는 거리는 0이기 때문에 초기화
        distance[start] = 0;

        int min = 0, current = 0;

        for (int i = 1; i <= V; ++i) {
            // step1: 방문하지 않은 정점들 중 최소가중치의 정점 선택
            min = INFINITY;
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    current = j;
                }
            }

            visited[current] = true; // 선택 정점 방문 처리

            // step2: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
            for (int j = 0; j <= V; j++) {
                if (!visited[j] && matrix[current][j] != 0 && distance[j] > min + matrix[current][j]) {
                    distance[j] = min + matrix[current][j];
                }
            }
        }

        for (int i = 1; i <= V; ++i) {
            if (distance[i] == INFINITY)
                sb.append("INF");
            else
                sb.append(distance[i]);

            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

