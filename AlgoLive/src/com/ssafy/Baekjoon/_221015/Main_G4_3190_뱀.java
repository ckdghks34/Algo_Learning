package com.ssafy.Baekjoon._221015;

import java.io.*;
import java.util.*;

public class Main_G4_3190_뱀 {
    static int N, K;
    static int[][] map;
    static Queue<Direction> dirList = new LinkedList<>();
    static Deque<Snake> snake = new LinkedList<>();

    // 동 남 서 북
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 2;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; ++i) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);

            dirList.offer(new Direction(sec, direction));
        }
        map[1][1] = 1;
        snake.offer(new Snake(1, 1));
        int time = 1;

        while (move()) {
            if (!dirList.isEmpty()) {
                if (time == dirList.peek().sec) {
                    Direction curDir = dirList.poll();
                    if(curDir.dir == 'D')
                        snake.peekFirst().turnRight();
                    else
                        snake.peekFirst().turnLeft();
                }
            }
            time++;
        }

        bw.write(Integer.toString(time));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean move() {
        Snake head = snake.peekFirst();
        Snake tail = snake.peekLast();

        int nextX = head.x + dx[head.dir];
        int nextY = head.y + dy[head.dir];

        if (0 < nextX && nextX <= N && 0 < nextY && nextY <= N) {
            if (map[nextY][nextX] == 2) {
                map[nextY][nextX] = 1;
                snake.offerFirst(new Snake(nextX, nextY, head.dir));
                return true;
            } else if (map[nextY][nextX] == 0) {
                map[nextY][nextX] = 1;
                map[tail.y][tail.x] = 0;
                snake.offerFirst(new Snake(nextX, nextY, head.dir));
                snake.pollLast();
                return true;
            }
        }

        return false;
    }

    static class Direction implements Comparable<Direction> {
        int sec;
        char dir;

        public Direction(int sec, char dir) {
            this.sec = sec;
            this.dir = dir;
        }

        @Override
        public int compareTo(Direction o1) {
            return sec - o1.sec;
        }
    }

    static class Snake {
        int x;
        int y;
        int dir;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
            this.dir = 0;
        }

        public Snake(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public void turnRight() {
            this.dir = (dir + 1) % 4;
        }

        public void turnLeft() {
            this.dir = (dir - 1) < 0 ? 3 : dir - 1;
        }
    }
}
