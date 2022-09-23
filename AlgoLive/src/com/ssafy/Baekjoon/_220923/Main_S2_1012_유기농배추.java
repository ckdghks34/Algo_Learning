package com.ssafy.Baekjoon._220923;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * DFS와 BFS 선택
 * DFS : 이동한 정점의 값을 가지고 계속 연산을 하는 경우(재귀적으로 호출되는경우)
 * BFS : 최단거리 문제
 * <p>
 * ex1) 지구 상에 존재하는 모든 친구 관계를 그래프로 표현한 후 Ash 와 Vanessa 사이에 존재하는 경로를 찾는 경우
 * DFS - 모든 친구 관계를 다 살펴봐야할지도 모름
 * BFS - Ash와 가까운 관계부터 탐색
 * <p>
 * 모든 노드를 방문하고자 하는 경우에는 DFS, 가까운 노드부터 탐색하기 위해서는 BFS 사용한다.
 * 검색 속도 자체는 BFS가 빠르지만 DFS가 더 간단하다.
 * <p>
 * 검색 대상 그래프가 크거나 경로의 특징을 저장해둬야 하는 문제는 DFS를,
 * 검색 대상의 규모가 크지 않고 최단거리를 구해야 하는 문제는 BFS가 유리하다.
 */
public class Main_S2_1012_유기농배추 {
    static int R, C, K;
    static int[][] map;
    static boolean[][] visited;

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; ++tc) {
            int result = 0;
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[R][C];
            visited = new boolean[R][C];
            Cabbage[] cabbage = new Cabbage[K];


            for (int i = 0; i < K; ++i) {
                st = new StringTokenizer(br.readLine());

                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                map[r][c] = 1;
                cabbage[i] = new Cabbage(c, r);
            }

            // 배추양 만큼 반복
            for (int i = 0; i < K; ++i) {
                if (!visited[cabbage[i].y][cabbage[i].x]) {
//                    bfs(cabbage[i]);
                    dfs(cabbage[i]);
                    result++;
                }
            }
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 백준 기준
    // 132ms
    static void bfs(Cabbage cabbage) {
        Queue<Cabbage> queue = new LinkedList<>();
        queue.offer(cabbage);
        visited[cabbage.y][cabbage.x] = true;

        while (!queue.isEmpty()) {
            Cabbage cur = queue.poll();

            for (int d = 0; d < 4; ++d) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (0 <= nx && nx < C && 0 <= ny && ny < R) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        queue.offer(new Cabbage(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    // 백준 기준
    // 128ms
    static void dfs(Cabbage cabbage) {
        if (visited[cabbage.y][cabbage.x])
            return;

        visited[cabbage.y][cabbage.x] = true;

        for (int d = 0; d < 4; ++d) {
            int nx = cabbage.x + dx[d];
            int ny = cabbage.y + dy[d];

            if (0 <= nx && nx < C && 0 <= ny && ny < R) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    dfs(new Cabbage(nx, ny));
                }
            }
        }
    }

    static class Cabbage {
        int x;
        int y;

        Cabbage(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
