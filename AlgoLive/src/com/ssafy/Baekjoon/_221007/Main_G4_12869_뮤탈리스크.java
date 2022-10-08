package com.ssafy.Baekjoon._221007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_G4_12869_뮤탈리스크 {
    static class SCV implements Comparable<SCV> {
        int[] scv;
        int allHealth;
        int count;

        SCV(int N, int count) {
            this.scv = new int[N];
            this.count = count;
        }

        SCV(int[] scv, int allHealth) {
            this.scv = scv;
            this.allHealth = allHealth;
            this.count = 0;
        }

        public int compareTo(SCV s) {
            return this.count - s.count;
        }
    }

    static int[][] hit = {{1, 3, 9}, {1, 9, 3}, {3, 1, 9}, {3, 9, 1}, {9, 1, 3}, {9, 3, 1}};
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] temp = new int[N];
        st = new StringTokenizer(br.readLine());

        int healthSum = 0;
        for (int i = 0; i < N; ++i) {
            temp[i] = Integer.parseInt(st.nextToken());
            healthSum = temp[i];
        }

        SCV scv = new SCV(temp, healthSum);

        bw.write(Integer.toString(bfs(scv)));
        bw.flush();
        bw.close();
        br.close();


    }

    static int bfs(SCV scv) {
        PriorityQueue<SCV> queue = new PriorityQueue<>();

        queue.offer(scv);

        while (!queue.isEmpty()) {
            SCV cur = queue.poll();

            if (cur.allHealth == 0)
                return cur.count;

            for (int i = 0; i < 6; ++i) {
                SCV tmp = new SCV(N, cur.count);
                for (int j = 0; j < N; ++j) {
                    if (cur.scv[j] > 0) {
                        tmp.scv[j] = cur.scv[j] - hit[i][j];
                        if (tmp.scv[j] < 0)
                            tmp.scv[j] = 0;
                        tmp.allHealth += tmp.scv[j];
                    }
                }
                tmp.count++;
                queue.offer(tmp);
            }
        }

        return 0;
    }
}
