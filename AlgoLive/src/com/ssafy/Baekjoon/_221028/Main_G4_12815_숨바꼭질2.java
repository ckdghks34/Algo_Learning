package com.ssafy.Baekjoon._221028;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_12815_숨바꼭질2 {
    static final int max = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE / 2;
        int count = 0;
        boolean[] visited = new boolean[max + 1];

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        queue.offer(new int[]{N, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            visited[cur[0]] = true;

            if (cur[0] == K) {
                if (cur[1] < min) {
                    min = cur[1];
                    count = 1;
                } else if (cur[1] == min) {
                    count++;
                }
            }

            if (cur[0] * 2 <= max && !visited[cur[0] * 2])
                queue.offer(new int[]{cur[0] * 2, cur[1] + 1});

            if (cur[0] + 1 <= max && !visited[cur[0] + 1])
                queue.offer(new int[]{cur[0] + 1, cur[1] + 1});

            if (cur[0] - 1 >= 0 && !visited[cur[0] - 1])
                queue.offer(new int[]{cur[0] - 1, cur[1] + 1});
        }

        bw.write(sb.append(min).append("\n").append(count).toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
