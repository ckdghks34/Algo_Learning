package com.ssafy.Baekjoon._221015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_S1_1446_지름길 {
    static int N, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        PriorityQueue<Shortcut> queue = new PriorityQueue<>();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (end - start < distance || end > D)
                continue;

            queue.offer(new Shortcut(start, end, distance));
        }

        int[] dp = new int[D + 1];
        int location = 0;
        int value = 0;
        while (!queue.isEmpty()) {
            Shortcut curShort = queue.poll();

            if (location == D)
                break;

            if (location < curShort.start) {
                value += curShort.start - location;
                value += curShort.distance;

                location = curShort.end;
            } else if (location == curShort.start) {
                value += curShort.distance;
                location = curShort.end;
            }
        }

        if (location != D)
            value += D - location;


        bw.write(Integer.toString(value));
        bw.flush();
        bw.close();
        br.close();
    }

    static class Shortcut implements Comparable<Shortcut> {
        int start;
        int end;
        int distance;

        Shortcut(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        public int compareTo(Shortcut sc) {
            if (this.start == sc.start) {
//                if (this.distance == sc.distance)
//                    return this.end - sc.end;
                return this.distance - sc.distance;
            }
            return this.start - sc.start;
        }
    }
}
