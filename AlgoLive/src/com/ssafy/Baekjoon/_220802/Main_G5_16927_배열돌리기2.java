package com.ssafy.Baekjoon._220802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_16927_배열돌리기2 {
    static int[][] map;
    // 하 우 상 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        int min = Math.min(M, N);

        for (int j = 0; j < R; ++j) {
            for (int i = 0; i < min / 2; ++i) {
                Rotation(i, 0, new boolean[N][M], M, N);
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Rotation(int startIndex, int dir, boolean[][] isVisited, int M, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startIndex, startIndex, dir, map[startIndex][startIndex + 1]});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[1];
            int curY = cur[0];
            int direction = cur[2];
            int curValue = cur[3];

            if (direction < 4) {
                int nextY = cur[0] + dy[direction];
                int nextX = cur[1] + dx[direction];

                if (startIndex <= nextX && nextX < M - startIndex && startIndex <= nextY && nextY < N - startIndex) {
                    if (!isVisited[nextY][nextX]) {
                        isVisited[nextY][nextX] = true;
                        int nextValue = map[curY][curX];
                        queue.add(new int[]{nextY, nextX, direction, nextValue});
                        map[curY][curX] = curValue;
                    }
                } else {
                    queue.add(new int[]{cur[0], cur[1], direction + 1, curValue});
                }
            }
        }
    }
}
