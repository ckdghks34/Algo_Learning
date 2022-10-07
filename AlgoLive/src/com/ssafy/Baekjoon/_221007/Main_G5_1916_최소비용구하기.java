package com.ssafy.Baekjoon._221007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1916_최소비용구하기 {
    static final int Inf = Integer.MAX_VALUE / 2;

    static int N, M;
    static int[][] map;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; ++i) {
            Arrays.fill(map[i], Inf);
            map[i][i] = 0;
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from][to] = Math.min(map[from][to], weight);
        }


        st = new StringTokenizer(br.readLine());

        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        Dijkstra(startNode, endNode);

        bw.write(Integer.toString(distance[endNode]));
        bw.flush();
        bw.close();
        br.close();
    }

    static void Dijkstra(int startNode, int endNode) {

        // 시작 지점으로부터 각 지점 거리 업데이트
        for (int i = 1; i <= N; ++i)
            distance[i] = map[startNode][i];

        // 시작 지점 방문처리
        visited[startNode] = true;

        for (int i = 1; i <= N; ++i) {
            int min = Inf, current = 1;

            for (int j = 1; j <= N; ++j) {
                if (!visited[j] && distance[j] < min) {
                    current = j;
                    min = distance[j];
                }
            }

            visited[current] = true;

            for (int j = 1; j <= N; ++j) {
                if (map[current][j] != Inf && map[current][j] + distance[current] < distance[j])
                    distance[j] = map[current][j] + distance[current];
            }

            if (current == endNode)
                return;
        }
    }

}
