package com.ssafy.codingTest.KaKao2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(solution(n, m, x, y, r, c, k));
        bw.flush();
        bw.close();
        br.close();
    }

    // 하좌우상
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[][] map;
    static HashMap<Integer, String> direction = new HashMap<Integer, String>() {
        {
            put(0, "d");
            put(1, "l");
            put(2, "r");
            put(3, "u");
        }
    };

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        map = new char[n + 1][m + 1];

        for (int i = 0; i < n; ++i)
            Arrays.fill(map[i], '.');

        map[x][y] = 'S';
        map[r][c] = 'E';


        answer = bfs(n, m, x, y, r, c, k);

        if (answer.equals(""))
            answer = "impossible";

        return answer;
    }

    public static String bfs(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder builder = new StringBuilder();

        PriorityQueue<Position> queue = new PriorityQueue<>();
        queue.offer(new Position(x, y, 0));

        while (!queue.isEmpty()) {
            Position cur = queue.poll();

            if (cur.val == k && map[cur.x][cur.y] == 'E') {
                return cur.move;
            }

            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 < nx && nx <= n && 0 < ny && ny <= m) {
                    if (cur.val < 5) {
                        queue.offer(new Position(nx, ny, cur.val + 1, cur.move + direction.get(i)));
                    }
                }
            }
        }
        return "";
    }

    static class Position implements Comparable<Position> {
        int x;
        int y;
        int val;
        String move = "";

        Position(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        Position(int x, int y, int val, String move) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.move = move;
        }

        public int compareTo(Position p) {
            return p.val - this.val;
        }
    }
}
