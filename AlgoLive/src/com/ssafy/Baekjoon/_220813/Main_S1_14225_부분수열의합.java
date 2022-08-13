package com.ssafy.Baekjoon._220813;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S1_14225_부분수열의합 {
    static HashMap<Integer,Integer> hashmap = new HashMap<>();
    static int N;
    static int[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0 ;i < N;++i) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        subset(0,new boolean[N]);

        int start = 1;
        while(true){
            if(!hashmap.containsKey(start))
            {
                bw.write(Integer.toString(start));
                break;
            }
            start++;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void subset(int start,boolean[] isSelected){
        if(start == N)
        {
            int sum = 0;

            for(int i=0 ;i < N;++i)
                if(isSelected[i])
                    sum+= map[i];

            if(sum != 0)
                hashmap.put(sum,sum);

            return;
        }

        isSelected[start] = true;
        subset(start+1,isSelected);

        isSelected[start] = false;
        subset(start+1,isSelected);
    }
}
