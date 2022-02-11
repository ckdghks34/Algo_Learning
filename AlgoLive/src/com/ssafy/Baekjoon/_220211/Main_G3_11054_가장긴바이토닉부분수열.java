package com.ssafy.Baekjoon._220211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_G3_11054_가장긴바이토닉부분수열 {
    public static int N;
    public static int[][] dp;
    public static int[] data;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[2][N];
        data = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            data[i] = Integer.parseInt(st.nextToken());
            dp[0][i] = 1;
            // 왼쪽 오른쪽 모두 1로 초기화했을 때, 기준이 되는 vertex가 두번 체크 되기 때문에 한쪽만 초기화 하면됨.
//            dp[1][i] = 1;
        }

        for (int i = 0; i < N; ++i)
            find(i);

        for (int i = 0; i < N; ++i) {
            max = Math.max(max, dp[0][i] + dp[1][i]);
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();

    }

    public static int find_left(int x) {
        if(dp[0][x] > 1)
            return dp[0][x];
        for (int i = x - 1; i >= 0; --i) {
            if (data[x] > data[i]) {
                dp[0][x] = Math.max(find_left(i) + 1, dp[0][x]);
            }
        }

        return dp[0][x];
    }

    public static int find_right(int x) {
        if(dp[1][x] > 1)
            return dp[1][x];

        for (int i = x + 1; i < N; ++i) {
            if (data[x] > data[i]) {
                dp[1][x] = Math.max(find_right(i) + 1, dp[1][x]);
            }
        }
        return dp[1][x];
    }

    public static void find(int x) {
        find_left(x);
        find_right(x);
    }
}
