package com.ssafy.Baekjoon._220813;

import sun.security.util.Length;

import java.io.*;
import java.util.StringTokenizer;

public class Main_S4_1051_숫자정사각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; ++i) {
            String str = br.readLine();

            for (int j = 0; j < M; ++j)
                map[i][j] = str.charAt(j) - '0';
        }

        int length = Math.min(N, M);
        int max = 1;

        if (length == 1)
            bw.write(Integer.toString(max));
        else {
            while (length > 0) {
                for (int i = 0; i <= N - length; ++i) {
                    for (int j = 0; j <= M - length; ++j) {
                        int standard = map[i][j];

                        if (standard == map[i + length - 1][j] && standard == map[i + length - 1][j + length - 1] && standard == map[i][j + length - 1])
                            max = Math.max(length * length, max);
                    }
                }
                length--;
            }
            bw.write(Integer.toString(max));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
