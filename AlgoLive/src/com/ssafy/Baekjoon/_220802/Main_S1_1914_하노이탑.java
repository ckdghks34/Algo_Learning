package com.ssafy.Baekjoon._220802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main_S1_1914_하노이탑 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // N이 최대일 경우 100
        // 2^100 = 1267650600228229401496703205376
        // BigInteger를 사용해야함.
        BigInteger result = (new BigInteger("2").pow(N)).subtract(BigInteger.ONE);
        sb.append(result.toString()).append("\n");

        if (N <= 20) {
            HanoiTop(N, 1, 2, 3);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void HanoiTop(int K, int from, int tmp, int to) {
        if (K == 0)
            return;

        HanoiTop(K - 1, from, to, tmp);
        sb.append(from).append(" ").append(to).append("\n");
        HanoiTop(K - 1, tmp, from, to);
    }

}
