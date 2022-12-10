package com.ssafy.Baekjoon._220916;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G3_16236_아기상어 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[][] map = new int[N][N];

        Shark shark = null;
        PriorityQueue<Fish> fishes = new PriorityQueue<>();


        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; ++j) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 9) {
                    shark = new Shark(new Pair(j, i));
                } else if (value != 0) {
                    fishes.add(new Fish(value, new Pair(j, i)));
                }
            }
        }

        while (!fishes.isEmpty()) {
            Fish cur = fishes.poll();

            if (shark.size > cur.size) {
                int dis = Math.abs(shark.pair.x - cur.pair.x) + Math.abs(shark.pair.y - cur.pair.y);
                result += dis;
                shark.pair.x = cur.pair.x;
                shark.pair.y = cur.pair.y;
                shark.eatCount++;

                if (shark.eatCount == shark.size) {
                    shark.size++;
                    shark.eatCount = 0;
                }
            } else break;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Fish implements Comparable<Fish> {
        int size;
        Pair pair;

        public Fish(int size, Pair pair) {
            this.size = size;
            this.pair = pair;
        }

        public int compareTo(Fish f) {
            if (this.size == f.size) {
                if (this.pair.y == f.pair.y)
                    return this.pair.x - f.pair.x;
                return this.pair.y - f.pair.y;
            }
            return this.size - f.size;
        }
    }

    public static class Shark {
        int eatCount;
        int size;
        Pair pair;

        public Shark(Pair pair) {
            this.eatCount = 0;
            this.size = 2;
            this.pair = pair;
        }
    }
}
