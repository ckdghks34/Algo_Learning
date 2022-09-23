package com.ssafy.Baekjoon._220913;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_2437_저울 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

//        int result;
        int result;
        int[] scales = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            int weight = Integer.parseInt(st.nextToken());
            scales[i] = weight;
        }

        Arrays.sort(scales);

        result = 0;

        for (int i = 0; i < N; ++i) {
            if (result + 1 < scales[i]) {
                break;
            }
            result += scales[i];
        }

        result++;
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
