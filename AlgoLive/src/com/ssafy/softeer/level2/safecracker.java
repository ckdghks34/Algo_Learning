package com.ssafy.softeer.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class safecracker {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bagWeight = Integer.parseInt(st.nextToken());
        int productNumber = Integer.parseInt(st.nextToken());
        int result = 0;
        PriorityQueue<Jewelry> queue = new PriorityQueue<>();

        for(int i =0 ;i < productNumber; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            queue.offer(new Jewelry(weight,value));
        }

        while(bagWeight > 0)
        {
            Jewelry curJewelry = queue.poll();

            if(bagWeight >= curJewelry.weight)
            {
                result += (curJewelry.weight * curJewelry.valuePerGram);
                bagWeight -= curJewelry.weight;
            }
            else
            {
                result += (bagWeight * curJewelry.valuePerGram);
                bagWeight = 0;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
    static class Jewelry implements Comparable<Jewelry>{
        int weight;
        int valuePerGram;

        Jewelry(int weight, int valuePerGram){
            this.weight = weight;
            this.valuePerGram = valuePerGram;
        }

        @Override
        public int compareTo(Jewelry o) {
            return o.valuePerGram - this.valuePerGram;
        }
    }
}
