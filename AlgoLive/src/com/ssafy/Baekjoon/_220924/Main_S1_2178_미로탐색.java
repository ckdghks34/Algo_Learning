package com.ssafy.Baekjoon._220924;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2178_미로탐색 {
    static char[][] map;
    static boolean[][] visited;
    static int result, N, M;

    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; ++i) {
            String tmp = br.readLine();

            for (int j = 0; j < M; ++j)
                map[i][j] = tmp.charAt(j);
        }
//        result = 0;
//        bfs();
        result = Integer.MAX_VALUE;
        dfs(new Pair(0, 0, 1));

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        queue.offer(new Pair(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (cur.x == M - 1 && cur.y == N - 1) {
                result = cur.value;
                return;
            }

            for (int d = 0; d < 4; ++d) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if (!visited[ny][nx] && map[ny][nx] == '1') {
                        queue.offer(new Pair(nx, ny, cur.value + 1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    /**
     * DFS로 풀었을 경우 TC 2번에서 오답이 나옴
     * 왜냐하면 DFS로는 최단 거리를 구할수 없기 때문에
     */

    static void dfs(Pair pair) {
        if (visited[pair.y][pair.x])
            return;

        if (pair.x == M - 1 && pair.y == N - 1) {
            result = Math.min(result, pair.value);
        }

        visited[pair.y][pair.x] = true;

        for (int d = 0; d < 4; ++d) {
            int nx = pair.x + dx[d];
            int ny = pair.y + dy[d];

            if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                if (!visited[ny][nx] && map[ny][nx] == '1') {
                    dfs(new Pair(nx, ny, pair.value + 1));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int value;

        Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.value = val;
        }

        public int compareTo(Pair pair) {
            return this.value - pair.value;
        }
    }
}
