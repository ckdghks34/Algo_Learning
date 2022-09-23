package com.ssafy.Baekjoon._220923;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_S2_1260_DFS와BFS {

    static int node, edge, start;
    static int[][] map;
    static boolean[] visited;
    static StringBuilder tmpBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        map = new int[node + 1][node + 1];

        for (int i = 0; i < edge; ++i) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            map[first][sec] = 1;
            map[sec][first] = 1;
        }

        visited = new boolean[node + 1];
        dfs(start);
        tmpBuilder.append("\n");

        visited = new boolean[node + 1];
        bfs();

        bw.write(tmpBuilder.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static public void dfs(int cur) {
        if (visited[cur])
            return;

        visited[cur] = true;
        tmpBuilder.append(cur).append(" ");

        for (int i = 0; i < node + 1; ++i) {
            if (map[cur][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    static public void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;
        tmpBuilder.append(start).append(" ");

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < node + 1; ++i) {
                if (!visited[i] && map[cur][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    tmpBuilder.append(i).append(" ");
                }
            }
        }
    }
}
