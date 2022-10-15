package com.ssafy.Baekjoon._221015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_G5_5582_공통부분문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String first = br.readLine();
        String second = br.readLine();
        int maxLen = 0;
        int[][] dp = new int[first.length() + 1][second.length() + 1];

        for (int i = 1; i <= first.length(); ++i) {
            for (int j = 1; j <= second.length(); ++j) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        bw.write(Integer.toString(maxLen));
        bw.flush();
        bw.close();
        br.close();
    }
}
