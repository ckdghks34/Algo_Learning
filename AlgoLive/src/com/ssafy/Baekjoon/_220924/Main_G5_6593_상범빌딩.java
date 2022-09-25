package com.ssafy.Baekjoon._220924;

import java.util.*;
import java.io.*;

public class Main_G5_6593_상범빌딩 {
    static int L, R, C;
    static char[][][] map;
    static boolean[][][] visited;
    static int result;
    static Position start, end;

    // 상 하 좌 우 위 아래
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0)
                break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];
            result = 0;

            for (int i = 0; i < L; ++i) {
                for (int j = 0; j < R; ++j) {
                    String tmp = br.readLine();
                    for (int k = 0; k < C; ++k) {
                        map[i][j][k] = tmp.charAt(k);

                        if (map[i][j][k] == 'S')
                            start = new Position(k, j, i, 0);
                        else if (map[i][j][k] == 'E')
                            end = new Position(k, j, i);
                    }
                }
                br.readLine();
            }

            bfs();

            if (result == 0)
                sb.append("Trapped!").append("\n");
            else
                sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        PriorityQueue<Position> queue = new PriorityQueue<>();

        queue.offer(start);
        visited[start.z][start.y][start.x] = true;

        while (!queue.isEmpty()) {
            Position cur = queue.poll();

            if (map[cur.z][cur.y][cur.x] == 'E') {
                result = cur.val;
                return;
            }

            for (int d = 0; d < 6; ++d) {
                int nz = cur.z + dz[d];
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (0 <= nz && nz < L && 0 <= nx && nx < C && 0 <= ny && ny < R) {
                    if (!visited[nz][ny][nx] && (map[nz][ny][nx] == '.' || map[nz][ny][nx] == 'E')) {
                        queue.offer(new Position(nx, ny, nz, cur.val + 1));
                        visited[nz][ny][nx] = true;
                    }
                }

            }
        }
    }

    static class Position implements Comparable<Position> {
        int x;
        int y;
        int z;
        int val;

        public Position(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Position(int x, int y, int z, int val) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.val = val;
        }

        public int compareTo(Position position) {
            return this.val - position.val;
        }
    }
}
