package com.ssafy.Baekjoon._221028;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_14940_쉬운최단거리 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = 0;
        int M = 0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] result = new int[N][M];

        Pair start = null;

        for (int i = 0; i < N; ++i) {
//            Arrays.fill(result[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    start = new Pair(j, i);
                    result[i][j] = 0;
                } else if (map[i][j] == 0)
                    result[i][j] = 0;
                else
                    result[i][j] = -1;
            }

        }
        bfs(map, result, N, M, start);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int[][] map, int[][] result, int n, int m, Pair start) {
        Queue<Pair> queue = new LinkedList<>();
        // 동 서 남 북
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        boolean[][] visited = new boolean[n][m];

        queue.add(start);
        visited[start.y][start.x] = true;
        result[start.y][start.x] = 0;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int d = 0; d < 4; ++d) {
                int nextX = cur.x + dx[d];
                int nextY = cur.y + dy[d];

                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n) {
                    if (map[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                        result[nextY][nextX] = result[cur.y][cur.x] + 1;
                        visited[nextY][nextX] = true;
                        queue.offer(new Pair(nextX, nextY));
                    }
                }

            }
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
