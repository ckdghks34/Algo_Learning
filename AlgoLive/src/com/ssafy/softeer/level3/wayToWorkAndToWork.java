package com.ssafy.softeer.level3;

import java.io.*;
import java.util.*;

public class wayToWorkAndToWork {

    static Set<Integer> toWork = new TreeSet<>();
    static Set<Integer> toHome = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;

        int[][] map = new int[n][n];
        int[][] mapReverse = new int[n][n];

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            map[from][to] = 1;
            mapReverse[to][from] = 1;
        }
        st = new StringTokenizer(br.readLine());
        int home = Integer.parseInt(st.nextToken()) - 1;
        int work = Integer.parseInt(st.nextToken()) - 1;

        addVertex(home, work, 0, map, new boolean[n]);
        addVertex(work, home, 1, map, new boolean[n]);
        addVertex(home, work, 1, mapReverse, new boolean[n]);
        addVertex(work, home, 0, mapReverse, new boolean[n]);

        for (int v : toWork) {
            if (toHome.contains(v))
                result++;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();


    }

    // way == 0 : 출근길, way == 1 : 퇴근길
//    public static void addVertex(int current, int end, int way, int[][] map, List<Integer> passedBy, boolean[] visited) {
//        if (current == end) {
//            for (int v : passedBy) {
//                if (way == 0) {
//                    if (!toWork.contains(v))
//                        toWork.add(v);
//                } else {
//                    if (!toHome.contains(v))
//                        toHome.add(v);
//                }
//            }
//            return;
//        }

    // way == 0 : 출근길, way == 1 : 퇴근길
    public static void addVertex(int current, int end, int way, int[][] map, boolean[] visited) {
        if (current == end) {
            return;
        }

        visited[current] = true;
        if (way == 0) {
            toWork.add(current);
        } else {
            toHome.add(current);
        }

        for (int i = 0; i < map.length; ++i) {
            if (map[current][i] == 1 && !visited[i]) {

                addVertex(i, end, way, map, visited);
            }
        }
    }
}
