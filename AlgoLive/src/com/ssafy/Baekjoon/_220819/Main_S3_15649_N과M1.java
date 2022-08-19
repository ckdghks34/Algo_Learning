package com.ssafy.Baekjoon._220819;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S3_15649_N과M1 {
    static int N, M;
    static int[] number;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        number = new int[M + 1];

        Permutation(1, new boolean[N + 1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Permutation(int cnt, boolean[] selected) {
        if (cnt == M+1) {
            for (int i = 1; i <= M; ++i)
                sb.append(number[i]).append(" ");
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; ++i) {
            if (!selected[i]) {
                selected[i] = true;
                number[cnt] = i;
                Permutation(cnt+1, selected);
                selected[i] = false;
            }
        }
    }
}
