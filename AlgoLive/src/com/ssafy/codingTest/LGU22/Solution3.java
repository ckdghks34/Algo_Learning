package com.ssafy.codingTest.LGU22;

import java.util.HashMap;

public class Solution3 {
    public static void main(String[] args) {
        String[] train = new String[]{"ESS", "EEW", "NNW"};

        System.out.println(solution(train));
    }

    static char[][] map;
    static boolean[][] visited;
    static int count = 0;
    static HashMap<Character, Integer> move = new HashMap<Character, Integer>() {{
        put('E', 0);
        put('W', 1);
        put('S', 2);
        put('N', 3);
    }};

    // 동 서 남 북
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static int solution(String[] train) {
        int answer = -1;
        int r = train.length;
        int c = train[0].length();
        map = new char[r][c];

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                map[i][j] = train[i].charAt(j);
            }
        }

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(j, i);
                }
            }
        }
        return answer;
    }

    static void dfs(int x, int y) {

        int nx = x + dx[move.get(map[y][x])];
        int ny = y + dy[move.get(map[y][x])];

        if (0 <= ny && ny < y && 0 <= nx && nx < x) {
            if(!visited[ny][nx])
            {
                dfs(nx,ny);
            }
        }
    }
}
