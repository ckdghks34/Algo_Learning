package com.ssafy.Baekjoon._220924;
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1753_최단경로_PQ {
    /**
     * Input
     * 5 6
     * 1
     * 5 1 1
     * 1 2 2
     * 1 3 3
     * 2 3 4
     * 2 4 5
     * 3 4 6
     */

    /**
     * Output
     * 0
     * 2
     * 3
     * 7
     * INF
     */

    final static int INFINITY = Integer.MAX_VALUE / 2;

    private static class Node implements Comparable<Node> {
        int vertex;
        int totalDistance;

        public Node(int vertex, int totalDistance) {
            this.vertex = vertex;
            this.totalDistance = totalDistance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(totalDistance, o.totalDistance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int V = Integer.parseInt(st.nextToken()); // 정점 갯수
        int E = Integer.parseInt(st.nextToken()); // 간선 갯수
        int start = Integer.parseInt(br.readLine()); // 시작점 인덱스

        int[][] matrix = new int[V + 1][V + 1]; // 인접행렬 생성
        int[] distance = new int[V + 1];    // 각 정점까지의 최단 거리 저장 할 곳
        boolean[] visited = new boolean[V + 1];  // 방문여부

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            matrix[row][col] = val;

        }

        Arrays.fill(distance, INFINITY);

        // 현재 정점에서 현재정점으로 가는 거리는 0이기 때문에 초기화
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, distance[start]));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visited[current.vertex])
                continue;

            visited[current.vertex] = true; // 선택 정점 방문 처리

            // step2: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
            for (int c = 0; c < V; ++c) {
                if (!visited[c] && matrix[current.vertex][c] != 0
                        && distance[c] > current.totalDistance + matrix[current.vertex][c]) {
                    distance[c] = current.totalDistance + matrix[current.vertex][c];
                    queue.offer(new Node(c, distance[c]));
                }
            }
        }

        for (int i = 1; i <= V; ++i) {
            if (distance[i] == INFINITY)
                sb.append("INF");
            else
                sb.append(distance[i]);

            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

