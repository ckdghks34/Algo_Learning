package com.ssafy.Baekjoon._220128;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S3_10974_모든순열 {

    public static int N;
    public static StringBuilder sb = new StringBuilder();
    public static int[] selected;
    public static boolean[] visisted;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        selected = new int[N];
        visisted = new boolean[N];

        permutation(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void permutation(int count) {
        if (count == N) {
            for (int i = 0; i < N; ++i) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; ++i) {
            if (!visisted[i - 1]) {
                visisted[i - 1] = true;
                selected[count] = i;
                permutation(count + 1);
                visisted[i - 1] = false;
            }
        }
    }
}
