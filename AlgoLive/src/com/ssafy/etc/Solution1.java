package com.ssafy.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = null;

        PriorityQueue<Player> queue = new PriorityQueue<>();

        for(int i = 0; i < 8; ++i)
        {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double time = Double.parseDouble(st.nextToken());

            queue.add(new Player(name,time));
        }

        sb.append(queue.poll().name).append("\n");
        for(int i = 1; i < 4;++i)
        {
            sb.append(queue.poll().name).append("\n");
            sb.insert(0,"\n").insert(0,queue.poll().name);
        }
        sb.append(queue.poll().name);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static class Player implements Comparable<Player>{
        String name;
        double time;

        Player(String name, double time){
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Player o) {
            return Double.compare(this.time,o.time);
        }
    }

}
