package com.ssafy.Baekjoon._221001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S2_2644_촌수계산 {
    static ArrayList<Integer>[] list;
    static int N, M, result = -1;
    static int start, end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        list = new ArrayList[N + 1];

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; ++i)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        bfs();

        bw.write(Integer.toString(result));
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

        boolean[] visited = new boolean[N + 1];

        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curPerson = cur[0];
            int degree = cur[1];

            if (curPerson == end)
                result = degree;

            for (int i = 0; i < list[curPerson].size(); ++i) {
                int nextPerson = list[curPerson].get(i);
                if (!visited[nextPerson]) {
                    queue.add(new int[]{nextPerson, degree + 1});
                    visited[nextPerson] = true;
                }
            }
        }
    }
}
