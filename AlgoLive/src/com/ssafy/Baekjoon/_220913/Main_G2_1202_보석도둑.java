package com.ssafy.Baekjoon._220913;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_G2_1202_보석도둑 {
    static class Jewelry implements Comparable<Jewelry> {
        int price;
        int weight;
        boolean state;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
            this.state = false;
        }

//        public int compareTo(Jewelry j) {
//            if (this.price == j.price)
//                return this.weight - j.weight;
//
//            return j.price - this.price;
//        }

        public int compareTo(Jewelry j) {
            if (this.weight == j.weight)
                return j.price - this.price;

            return this.weight - j.weight;
        }
    }

    static class Bag implements Comparable<Bag> {
        long maxWeight;
        boolean state = false;

        public Bag(long maxWeight) {
            this.maxWeight = maxWeight;
        }

        public int compareTo(Bag b) {
            return (int) (this.maxWeight - b.maxWeight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long sum = 0;

//        ArrayList<Jewelry> jewelries = new ArrayList<>();
        Jewelry[] jewelries = new Jewelry[N];
        Bag[] bags = new Bag[K];


        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
//            jewelries.add(new Jewelry(weight, price));
            jewelries[i] = new Jewelry(weight, price);
        }


        for (int i = 0; i < K; ++i) {
            int maxWeight = Integer.parseInt(br.readLine());
            bags[i] = new Bag(maxWeight);
        }

        Arrays.sort(jewelries);
        Arrays.sort(bags);

        PriorityQueue<Jewelry> tmplist = new PriorityQueue<>(new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                return o2.price - o1.price;
            }
        });
        int j = 0;
        for (int i = 0; i < K; ++i) {
//            ArrayList<Jewelry> tmplist = new ArrayList<>();


            while (j < N) {
//                if (bags[i].maxWeight >= jewelries.get(j).weight && !jewelries.get(j).state)
//                    tmplist.add(jewelries.get(j));
                if (bags[i].maxWeight < jewelries[j].weight)
                    break;

                tmplist.add(jewelries[j++]);
            }
//            Collections.sort(tmplist, new Comparator<Jewelry>() {
//                @Override
//                public int compare(Jewelry o1, Jewelry o2) {
//                    return o2.price - o1.price;
//                }
//            });

            if (!tmplist.isEmpty()) {
                Jewelry cur = tmplist.poll();
                sum += cur.price;
            }
        }

        bw.write(Long.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
