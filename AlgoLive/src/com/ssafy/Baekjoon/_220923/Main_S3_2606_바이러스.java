package com.ssafy.Baekjoon._220923;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S3_2606_바이러스 {

    static int result = 0;
    static int N;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        int r = Integer.parseInt(br.readLine());

        for (int i = 0; i < r; ++i) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            map[first][sec] = 1;
            map[sec][first] = 1;
        }

//        dfs(1);
//        result--;
        bfs(1);


        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start) {
        if (visited[start])
            return;

        visited[start] = true;
        result++;

        for (int i = 0; i <= N; ++i) {
            if (map[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < N; ++i) {
                if (!visited[i] && map[cur][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    result++;
                }
            }
        }
    }
}
