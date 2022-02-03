package com.ssafy.Baekjoon._220128;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_14503_로봇청소기 {
    public static int N, M;
    public static int r, c, d;
    public static int count;
    public static int[][] map;

    // 상우하좌
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N,M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // r,c,d 입력
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 맵 입력
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void cleaner(int x, int y, int dir) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y, dir, cnt});
        int leftd = dir - 1 >= 0 ? dir - 1 : 3;
        int nx = x + dx[lefd];
        int ny = y + dy[lefd];

        if (nx > 0 && ny > 0 && nx < M - 1 && ny < N - 1) {
            if (map[ny][nx] == 1)
        }
    }
}
