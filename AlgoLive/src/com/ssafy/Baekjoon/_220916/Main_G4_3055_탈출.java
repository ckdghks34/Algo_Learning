package com.ssafy.Baekjoon._220916;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_3055_탈출 {

    static int R;
    static int C;
    static int[][] map;
    static boolean[][] visited;
    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 고슴도치 위치
    static Queue<Pair> hedgehog = new LinkedList<>();
    // 물 위치
    static Queue<Pair> water = new LinkedList<>();

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        boolean valid = false;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        // Map 입력
        for (int i = 0; i < R; ++i) {
            String line = br.readLine();

            for (int j = 0; j < C; ++j) {
                switch (line.charAt(j)) {
                    // 비버 굴
                    case 'D':
                        map[i][j] = 1;
                        break;

                    // 땅
                    case '.':
                        map[i][j] = 0;
                        break;

                    // 물
                    case '*':
                        map[i][j] = -1;
                        water.add(new Pair(j, i));
                        break;

                    // 시작점
                    case 'S':
                        map[i][j] = 2;
                        hedgehog.add(new Pair(j, i));
                        visited[i][j] = true;
                        break;

                    // 돌
                    case 'X':
                        map[i][j] = -2;
                        break;
                }
            }
        }

        while (!hedgehog.isEmpty()) {
            waterFlow();    // 물 이동
            valid = bfs();  // 고슴도치 이동 -> true : 비버굴 도착 O , false : 비버굴 도착 X
            count++;    // 이동 횟수
            if (valid)
                break;
        }

        // 비버굴에 도착하지 못했다면 KAKTUS 출력
        String result = valid ? Integer.toString(count) : "KAKTUS";

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    // 물 이동
    public static void waterFlow() {
        // 현재 라운드에서 이동할 물 갯수
        int count = water.size();

        for (int i = 0; i < count; ++i) {
            Pair current = water.poll();

            for (int d = 0; d < 4; ++d) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                if (checkValid(nx, ny)) {
                    if (map[ny][nx] == 0) {
                        map[ny][nx] = -1;
                        water.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    public static boolean bfs() {
        // 현재 라운드에서 움직일 수 있는 고슴도치 갯수
        int count = hedgehog.size();

        for (int i = 0; i < count; ++i) {
            Pair current = hedgehog.poll();

            for (int d = 0; d < 4; ++d) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                if (checkValid(nx, ny)) {
                    // 다음 이동할 위치가 비버굴일 경우
                    if (map[ny][nx] == 1) {
                        return true;
                    }
                    // 다음 이동할 위치가 땅이고 방문하지 않았으면, 고슴도치 추가
                    else if (map[ny][nx] == 0 && !visited[ny][nx]) {
                        hedgehog.add(new Pair(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return false;
    }

    // 좌표가 Map 내에 위치 여부
    public static boolean checkValid(int x, int y) {
        if (0 <= x && x < C && 0 <= y && y < R)
            return true;
        return false;
    }
}
