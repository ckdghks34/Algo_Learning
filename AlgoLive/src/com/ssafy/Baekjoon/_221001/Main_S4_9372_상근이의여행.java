package com.ssafy.Baekjoon._221001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S4_9372_상근이의여행 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; ++tc) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            for (int i = 0; i <= N; ++i) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());
                int departure = Integer.parseInt(st.nextToken());
                int arrival = Integer.parseInt(st.nextToken());

                list.get(departure).add(arrival);
                list.get(arrival).add(departure);
            }

            sb.append(bfs()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(1);
        visited[1] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            count++;

            for (int i = 0; i < list.get(cur).size(); ++i) {
                if (!visited[list.get(cur).get(i)]) {
                    queue.offer(list.get(cur).get(i));
                    visited[list.get(cur).get(i)] = true;
                }
            }
        }
        return count - 1;
    }
}
