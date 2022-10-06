package com.ssafy.Baekjoon._221005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17070_파이프옮기기1 {
    static int N, result;
    static int[][] map;

    // 오, 오+아래, 아래
    static int[] dx = {1, 1, 0};
    static int[] dy = {0, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = 0;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 종료 지점이 벽이면 무조건 이동불가능
        if (map[N - 1][N - 1] != 1)
            bfs(1, 0);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y) {
        Queue<Pipe> queue = new LinkedList<>();

        queue.offer(new Pipe(x, y));

        while (!queue.isEmpty()) {
            Pipe cur = queue.poll();

            if (cur.x == N - 1 && cur.y == N - 1) {
                result++;
                continue;
            }

            int nx;
            int ny;

            if (cur.direction == 0) {
                // 오른쪽
                nx = cur.x + dx[0];
                ny = cur.y + dy[0];
                if (checkValid(nx, ny, 0))
                    queue.offer(new Pipe(nx, ny, 0));
            } else if (cur.direction == 1) {
                // 오른쪽
                nx = cur.x + dx[0];
                ny = cur.y + dy[0];
                if (checkValid(nx, ny, 0))
                    queue.offer(new Pipe(nx, ny, 0));

                // 아래
                nx = cur.x + dx[2];
                ny = cur.y + dy[2];
                if (checkValid(nx, ny, 2))
                    queue.offer(new Pipe(nx, ny, 2));
            } else {
                // 아래
                nx = cur.x + dx[2];
                ny = cur.y + dy[2];
                if (checkValid(nx, ny, 0))
                    queue.offer(new Pipe(nx, ny, 2));
            }

            // 어느 방향이든 대각선(오른쪽+아래)로 방향 전환 가능
            nx = cur.x + dx[1];
            ny = cur.y + dy[1];
            if (checkValid(nx, ny, 1))
                queue.offer(new Pipe(nx, ny, 1));
        }
    }

    // x, y 는 이미 방향에 따라 이동할 다음 좌표값임.
    static boolean checkValid(int x, int y, int d) {
        if (x < N && y < N) {
            // 대각선(오른쪽 + 아래)일 경우 근처 3개의 값 모두 0 이어야 가능함.
            if (d == 1)
                return map[y][x] == 0 && map[y - 1][x] == 0 && map[y][x - 1] == 0;
            else
                return map[y][x] == 0;
        }
        return false;
    }


    static class Pipe {
        int x;
        int y;
        int direction;

        Pipe(int x, int y) {
            this.x = x;
            this.y = y;
            this.direction = 0;
        }

        Pipe(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

}
