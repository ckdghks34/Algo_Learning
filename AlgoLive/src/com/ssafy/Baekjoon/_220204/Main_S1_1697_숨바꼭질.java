package com.ssafy.Baekjoon._220204;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_S1_1697_숨바꼭질 {
    public static int N, K;
    public static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.offer(new int[]{
                n, 0
        });

        boolean[] visited = new boolean[100001];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int place = current[0];
            int cnt = current[1];

            if (place == K) {
                count = cnt;
                return;
            }
            int down = place - 1;
            int up = place + 1;
            int doub = place * 2;

            if (down >= 0) {
                if (!visited[down]) {
                    queue.offer(new int[]{
                            down, cnt + 1
                    });
                    visited[down] = true;
                }
            }
            if(up < 100001) {
                if (!visited[up]) {
                    queue.offer(new int[]{
                            up, cnt + 1
                    });
                    visited[up] = true;
                }
            }
            if(doub <100001) {
                if (!visited[doub]) {
                    queue.offer(new int[]{
                            doub, cnt + 1
                    });
                    visited[doub] = true;
                }
            }


        }
    }
}
