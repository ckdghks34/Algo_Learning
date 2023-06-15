package com.ssafy.softeer.level3;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class wayToWorkAndToWork {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

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

        // 출근길 정방향 탐색
        Set<Integer> toWorkA = new TreeSet<>();
        addVertex(home, work, toWorkA, map, new boolean[n]);
        // 출근길 역방향 탐색
        Set<Integer> toWorkB = new TreeSet<>();
        addVertex(home, work, toWorkB, mapReverse, new boolean[n]);

        Set<Integer> toHomeA = new TreeSet<>();
        addVertex(work, home, toHomeA, map, new boolean[n]);

        Set<Integer> toHomeB = new TreeSet<>();
        addVertex(work, home, toHomeB, mapReverse, new boolean[n]);

        toWorkA.retainAll(toWorkB);
        toHomeA.retainAll(toHomeB);

        toWorkA.retainAll(toHomeA);

//        toWorkA.remove(home);
//        toWorkA.remove(work);
        result = toWorkA.size();
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // way == 0 : 정방향, way == 1 : 역방향
    public static void addVertex(int current, int end, Set<Integer> set, int[][] map, boolean[] visited) {
        if (current == end) {
            return;
        }

        visited[current] = true;

        set.add(current);

        for (int i = 0; i < map.length; ++i) {
            if (map[current][i] == 1 && !visited[i]) {
                addVertex(i, end, set,map, visited);
            }
        }
    }
}
