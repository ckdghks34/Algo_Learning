package com.ssafy.Baekjoon._221005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_9205_맥주마시면서걸어가기 {
    static int N;   // 편의점 개수
    static int node;    // 노드 갯수
    static ArrayList<Integer>[] NodeList;   // 노드 리스트 초기화

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; ++tc) {
            // 초기화
            N = Integer.parseInt(br.readLine());
            node = N + 2;
            NodeList = new ArrayList[node];

            for (int i = 0; i < node; ++i)
                NodeList[i] = new ArrayList<>();

            // 입력값 저장
            ArrayList<Pair> list = new ArrayList<>();

            for (int i = 0; i < node; ++i) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Pair(x, y));
            }

            // 연결리스트
            for (int i = 0; i < node; ++i) {
                Pair cur = list.get(i);

                for (int j = i + 1; j < node; ++j) {
                    Pair next = list.get(j);

                    // 50미터 병 1개, 1박스 병 20개
                    // 이동거리 / 50 <= 20 : 이동가능
                    if (CalculateDist(cur.x, cur.y, next.x, next.y) <= 20) {
                        NodeList[i].add(j);
                        NodeList[j].add(i);
                    }
                }
            }

            if (bfs())
                sb.append("happy").append("\n");
            else
                sb.append("sad").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 2];

        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int index = queue.poll();

            if (index == node - 1)
                return true;

            for (int i = 0; i < NodeList[index].size(); ++i) {
                int nextIndex = NodeList[index].get(i);

                if (!visited[nextIndex]) {
                    queue.offer(nextIndex);
                    visited[nextIndex] = true;
                }
            }
        }

        return false;
    }

    static double CalculateDist(int curx, int cury, int nextx, int nexty) {
        int dist = Math.abs(curx - nextx) + Math.abs(cury - nexty);

        return dist / 50.0;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
