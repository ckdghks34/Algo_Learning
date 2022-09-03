package com.ssafy.Baekjoon._220831;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_1026_보물 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        for(int i =0 ;i < 2;++i)
        {
            st = new StringTokenizer(br.readLine());

            if(i == 0)
                for(int j =0 ;j < N;++j)
                {
                    A[j] = Integer.parseInt(st.nextToken());
                }
            else
                for(int j =0 ;j < N;++j)
                {
                    B[j] = Integer.parseInt(st.nextToken());
                }
        }
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for(int i = 0; i < N;++i)
            sum += A[i] * B[(N-1)-i];

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
