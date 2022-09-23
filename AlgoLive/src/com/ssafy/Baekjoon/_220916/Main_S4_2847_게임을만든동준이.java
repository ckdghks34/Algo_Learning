package com.ssafy.Baekjoon._220916;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S4_2847_게임을만든동준이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        // 삽입삭제 연산이 아닌 탐색연산을 많이 하기때문에 Array를 사용하는것이 더욱 효율적일것
        int[] score = new int[N];

        for (int i = 0; i < N; ++i)
            score[i] = Integer.parseInt(br.readLine());

        for (int i = N - 2; i >= 0; --i) {
            if (score[i] >= score[i + 1]) {
                int value = score[i] - score[i + 1] + 1;
                score[i] -= value;
                result += value;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
