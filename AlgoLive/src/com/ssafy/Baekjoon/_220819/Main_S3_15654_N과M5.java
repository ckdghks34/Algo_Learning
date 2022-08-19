package com.ssafy.Baekjoon._220819;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_15654_N과M5 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i)
            numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);

        Permutation(0,0,new boolean[N],new int[M]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Permutation(int start, int cnt, boolean[] selected, int[] selectNumber) {
        if(cnt == M){
            for(int i =0 ;i < M;++i)
                sb.append(selectNumber[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; ++i) {
            if(!selected[i]) {
                selected[i] = true;
                selectNumber[cnt] = numbers[i];
                Permutation(start+1, cnt+1, selected,selectNumber);
                selected[i] = false;
            }
        }
    }
}
