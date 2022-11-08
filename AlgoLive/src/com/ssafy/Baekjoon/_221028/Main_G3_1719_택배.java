package com.ssafy.Baekjoon._221028;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_1719_택배 {
    static final int Inf = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int edgeLength = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];
        int[][] result = new int[N + 1][N + 1];
        for (int i = 0; i <= N; ++i) {
            Arrays.fill(map[i], Inf);
            map[i][i] = 0;
        }

        for (int i = 0; i < edgeLength; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from][to] = weight;
            map[to][from] = weight;

            result[to][from] = from;
            result[from][to] = to;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (i == j && j == k)
                        continue;

                    // 기존 j -> k까지의 거리와, i번째 노드를 거쳐가는 거리를 비교해 최단거리 갱신
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                        result[j][k] = result[j][i];
                    }
                }
            }
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (result[i][j] != 0)
                    sb.append(result[i][j]);
                else
                    sb.append("-");

                sb.append(" ");
            }
            sb.append("\n");
        }

//        맵 출력
//        for (int i = 1; i <= N; ++i) {
//            for (int j = 1; j <= N; ++j) {
//                if (map[i][j] != Inf)
//                    sb.append(map[i][j]);
//                else
//                    sb.append("-");
//
//                sb.append(" ");
//            }
//            sb.append("\n");
//        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
