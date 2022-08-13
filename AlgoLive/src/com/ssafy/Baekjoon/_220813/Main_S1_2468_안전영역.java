package com.ssafy.Baekjoon._220813;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2468_안전영역 {
    static int N;
    static int[][] map;

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int HeightMax = 1;
        int safetyMaxSize = 1;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] > HeightMax)
                    HeightMax = Math.max(map[i][j], HeightMax);

            }
        }

        for (int h = HeightMax - 1; h > 0; --h) {
            boolean[][] visited = new boolean[N][N];

            int count = 0;

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (map[i][j] > h && !visited[i][j]) {
                        checkSafety_bfs(visited, i, j, h);
                        count++;
                    }
                }
            }

            safetyMaxSize = Math.max(count,safetyMaxSize);
        }
        bw.write(Integer.toString(safetyMaxSize));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void checkSafety_bfs(boolean[][] visited, int i, int j, int h) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; ++d) {
                int nextX = cur[1] + dx[d];
                int nextY = cur[0] + dy[d];

                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
                    if (!visited[nextY][nextX] && map[nextY][nextX] > h) {
                        queue.add(new int[]{nextY, nextX});
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }
    }
}
