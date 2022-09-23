package com.ssafy.Baekjoon._220916;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_11000_강의실배정 {
    static class Lecture implements Comparable<Lecture> {
        int startTime;
        int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int compareTo(Lecture l) {
            if (this.startTime == l.startTime)
                return this.endTime - l.endTime;

            return this.startTime - l.startTime;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int result = 1;

        PriorityQueue<Lecture> queue = new PriorityQueue<>();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            queue.add(new Lecture(startTime, endTime));
        }

        int curTime = queue.poll().endTime;

        while (!queue.isEmpty()) {
            Lecture tmp = queue.peek();

            while (!queue.isEmpty() && tmp.startTime < curTime) {
                result++;
                queue.poll();
                tmp = queue.peek();
            }
            if (!queue.isEmpty())
                curTime = queue.poll().endTime;
        }


        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
