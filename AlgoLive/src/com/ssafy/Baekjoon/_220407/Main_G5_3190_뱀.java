package com.ssafy.Baekjoon._220407;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_G5_3190_뱀 {
    // 보드 크기, 사과 개수, 방향변환횟수
    public static int N, K, L;
    // 0 : 빈칸 , 1 : 뱀 , 2 : 사과
    public static int[][] map;
    public static Deque<Snake> snakeQueue = new LinkedList<>();
    public static PriorityQueue<Direction> dirlist = new PriorityQueue<>();

    // 동남서북
    public static int dx[] = {1, 0, -1, 0};
    public static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 2;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; ++i) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);

            dirlist.add(new Direction(sec, direction));
        }

        map[1][1] = 1;
        int count = 1;
        snakeQueue.add(new Snake(1,1));

        while(move()) {
            if (!dirlist.isEmpty()) {
                if (dirlist.peek().sec == count) {
                    if (dirlist.peek().dir == 'D')
                        snakeQueue.peekFirst().turnRight();
                    else
                        snakeQueue.peekFirst().turnLeft();

                    dirlist.poll();
                }
            }
            count++;
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean move() {
        Snake curHead = snakeQueue.peekFirst();
        Snake curTail = snakeQueue.peekLast();
        int curHeadx = curHead.x;
        int curHeady = curHead.y;
        int curTailx = curTail.x;
        int curTaily = curTail.y;
        int curdir = curHead.dir;

        int nextHeadx = curHeadx + dx[curdir];
        int nextHeady = curHeady + dy[curdir];

        if (nextHeadx > 0 && nextHeady > 0 && nextHeadx <= N && nextHeady <= N) {
            if (map[nextHeady][nextHeadx] == 2) {
                map[nextHeady][nextHeadx] = 1;
                snakeQueue.addFirst(new Snake(nextHeadx,nextHeady,curHead.dir));
                return true;
            } else if (map[nextHeady][nextHeadx] == 0) {
                map[nextHeady][nextHeadx] = 1;
                map[curTaily][curTailx] = 0;
                snakeQueue.addFirst(new Snake(nextHeadx,nextHeady,curHead.dir));
                snakeQueue.pollLast();
                return true;
            }
        }
        return false;
    }
}

class Direction implements Comparable<Direction> {
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

class Snake{
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