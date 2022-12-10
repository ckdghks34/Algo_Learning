package com.ssafy.Baekjoon._220923;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

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
