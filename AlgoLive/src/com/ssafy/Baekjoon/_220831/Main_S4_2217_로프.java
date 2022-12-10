package com.ssafy.Baekjoon._220831;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main_S4_2217_로프 {
    static class Rope implements Comparable<Rope> {
        int weight;

        public Rope(int weight){
            this.weight = weight;
        }

        @Override
        public int compareTo(Rope r) {
            return this.weight - r.weight;
        }

    }


    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Rope> list = new ArrayList<>();

        for(int i =0 ;i < N;++i) {
            int w = Integer.parseInt(br.readLine());
            max = Math.max(w,max);

            list.add(new Rope(w));
        }
        Collections.sort(list);
        for(int i =0 ;i < N;++i)
        {
            int maxWeight = list.get(i).weight * (N-i);
            max = Math.max(max,maxWeight);
        }

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }
}