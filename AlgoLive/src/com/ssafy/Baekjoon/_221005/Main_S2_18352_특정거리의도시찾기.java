package com.ssafy.Baekjoon._221005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_S2_18352_특정거리의도시찾기 {
    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; ++i) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
        }

        bfs();

        Collections.sort(result);

        if (result.size() > 0) {
            for (int i = 0; i < result.size(); ++i)
                sb.append(result.get(i)).append("\n");
        } else
            sb.append("-1");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[N + 1];

        queue.offer(new int[]{X, 0});
        visited[X] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curMove = cur[1];

            if (curMove == K) {
                result.add(curNode);
            } else if (curMove < K) {
                for (int i = 0; i < list.get(curNode).size(); ++i) {
                    int next = list.get(curNode).get(i);

                    if (!visited[next]) {
                        queue.offer(new int[]{next, curMove + 1});
                        visited[next] = true;
                    }
                }
            }
        }
    }
}
