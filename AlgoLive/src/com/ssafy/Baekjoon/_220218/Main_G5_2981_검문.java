package com.ssafy.Baekjoon._220218;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 참고 사이트 : https://st-lab.tistory.com/155
public class Main_G5_2981_검문 {
    public static int[] data;
    public static int N;
    public static int gcd;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        data = new int[N];

        for (int i = 0; i < N; ++i)
            data[i] = Integer.parseInt(br.readLine());

        Arrays.sort(data);
        gcd = data[1] - data[0];

        // A % M = A - ( A / M ) * M
        // B % M = B - ( B / M ) * M
        // A % M = B % M
        // A - (A/M) * M = B - ( B / M ) * M
        // A - B = M {(A/M) - (B/M)}
        // M은 공통되는 약수가 있다는 말

        //
        for (int i = 2; i < N; ++i) {
            gcd = getGCD(gcd, data[i] - data[i - 1]);
        }

        getDivisor(gcd);

        for (int i = 0; i < list.size(); ++i)
            sb.append(list.get(i)).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getGCD(int n, int m) {
        int r = 0;

        while (m != 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }

    public static void getDivisor(int n) {
        for (int i = 2; i <= n; ++i) {
            if (n % i == 0)
                list.add(i);
        }
    }
}
