package com.ssafy.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.lang.*;

public class Main {
    static int n, r;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        int result = 0;
        for (int i = 0; i < r; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s][e] = 1;
            map[e][s] = 1;
        }

        result = bfs(map, start);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static private int bfs(int[][] map, int start) {
        PriorityQueue<Route> queue = new PriorityQueue<>(new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                return o1.routeString.compareTo(o2.routeString);
            }
        });

        int count = 0;
        queue.add(new Route(start, Integer.toString(start), new boolean[n][n]));

        while (!queue.isEmpty()) {
            Route curRoute = queue.poll();

            if (curRoute.routeString.length() > r * 2 + 1)
                continue;

            if (curRoute.routeString.length() == r * 2 + 1) {
                if (curRoute.current == start) {
                    count++;
                    continue;
                }
            } else {
                for (int i = 0; i < n; ++i) {
                    if (curRoute.current == i)
                        continue;

                    if (map[curRoute.current][i] == 1) {
                        if (!curRoute.visited[curRoute.current][i]) {
                            boolean[][] tmp = new boolean[n][n];
                            for (int j = 0; j < n; ++j)
                                tmp[j] = curRoute.visited[j].clone();

                            tmp[curRoute.current][i] = true;

                            queue.add(new Route(i, new String(curRoute.routeString + Integer.toString(i)), tmp));
                        }
                    }
                }
            }
        }
        return count;
    }

    static class Route {
        int current;
        String routeString = "";
        boolean[][] visited;

        public Route(int current, boolean[][] visited) {
            this.current = current;
            this.visited = visited;
        }

        public Route(int current, String routeString, boolean[][] visited) {
            this.current = current;
            this.routeString = routeString;
            this.visited = visited;
        }
    }
}
