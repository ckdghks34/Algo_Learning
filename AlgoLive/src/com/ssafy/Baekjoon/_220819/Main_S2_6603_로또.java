package com.ssafy.Baekjoon._220819;

import com.ssafy.Live._210202.exhaustive.CombinationTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_6603_로또 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N;
        int[] numbers;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if (N == 0)
                break;

            numbers = new int[N];

            for (int i = 0; i < N; ++i)
                numbers[i] = Integer.parseInt(st.nextToken());

            Combination(N, 0, 0, numbers, new int[6]);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Combination(int N, int start, int cnt, int[] numbers, int[] selected) {
        if (cnt == 6) {
            for (int i = 0; i < 6; ++i)
                sb.append(selected[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; ++i) {
            selected[cnt] = numbers[i];
            Combination(N, i + 1, cnt + 1, numbers, selected);
        }
    }
}
