package com.ssafy.Baekjoon._221007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_G4_12869_뮤탈리스크 {
    static int[][] hit = {{1, 3, 9}, {1, 9, 3}, {3, 1, 9}, {3, 9, 1}, {9, 1, 3}, {9, 3, 1}};
    static int N;
    static final int maxHealth = 60;

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

//        SCV scv = new SCV(temp, healthSum);

//        bw.write(Integer.toString(bfs(scv)));
        bw.flush();
        bw.close();
        br.close();
    }
}
