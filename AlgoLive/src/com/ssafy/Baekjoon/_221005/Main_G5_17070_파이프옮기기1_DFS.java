package com.ssafy.Baekjoon._221005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_G5_17070_파이프옮기기1_DFS {
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
            dfs(new Pipe(1, 0, 0));

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(Pipe pipe) {
        if (pipe.x == N - 1 && pipe.y == N - 1) {
            result++;
            return;
        }

        switch (pipe.direction) {
            // 현재 방향이 가로 일 때
            case 0:
                if (checkValid(pipe.x + 1, pipe.y, 0))
                    dfs(new Pipe(pipe.x + 1, pipe.y, 0));

                break;
            // 현재 방향이 대각선 일 때
            case 1:
                if (checkValid(pipe.x + 1, pipe.y, 0))
                    dfs(new Pipe(pipe.x + 1, pipe.y, 0));

                if (checkValid(pipe.x, pipe.y + 1, 2))
                    dfs(new Pipe(pipe.x, pipe.y + 1, 2));

                break;
            // 현재 방향이 세로 일 때
            case 2:
                if (checkValid(pipe.x, pipe.y + 1, 2))
                    dfs(new Pipe(pipe.x, pipe.y + 1, 2));

                break;
        }

        // 대각선은 무조건 실행
        if (checkValid(pipe.x + 1, pipe.y + 1, 1))
            dfs(new Pipe(pipe.x + 1, pipe.y + 1, 1));
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
