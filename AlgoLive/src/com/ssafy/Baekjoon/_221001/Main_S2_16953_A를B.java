package com.ssafy.Baekjoon._221001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S2_16953_A를B {
    static long A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int result = -1;

        PriorityQueue<Number> queue = new PriorityQueue<>();

        queue.add(new Number(A));

        while (!queue.isEmpty()) {
            Number cur = queue.poll();

            if (cur.num < B) {
                queue.offer(new Number(cur.num * 2, cur.val + 1));
                queue.offer(new Number((cur.num * 10) + 1, cur.val + 1));
            } else if (cur.num == B) {
                result = cur.val;
                break;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static class Number implements Comparable<Number> {
        long num;
        int val;

        Number(long num) {
            this.num = num;
            this.val = 1;
        }

        Number(long num, int val) {
            this.num = num;
            this.val = val;
        }

        @Override
        public int compareTo(Number n) {
            return this.val - n.val;
        }
    }

}
