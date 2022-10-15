package com.ssafy.Baekjoon._221015;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_13549_숨바꼭질3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        int result = 0;


        PriorityQueue<Position> queue = new PriorityQueue<>();
        queue.offer(new Position(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            visited[current.position] = true;

            if (current.position == K) {
                result = current.time;
                break;
            }

            int next = current.position - 1;
            if (0 <= next && !visited[next]) {
                queue.offer(new Position(next, current.time + 1));
            }

            next = current.position + 1;
            if (next <= 100000 && !visited[next]) {
                queue.offer(new Position(next, current.time + 1));
            }

            next = current.position * 2;
            if (next <= 100000 && !visited[next]) {
                queue.offer(new Position(next, current.time));
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static class Position implements Comparable<Position> {
        int position;
        int time;

        Position(int position, int move) {
            this.position = position;
            this.time = move;
        }

        public int compareTo(Position p) {
            return this.time - p.time;
        }
    }

}
