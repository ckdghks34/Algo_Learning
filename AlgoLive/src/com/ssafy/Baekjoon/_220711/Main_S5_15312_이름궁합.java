package com.ssafy.Baekjoon._220711;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main_S5_15312_이름궁합 {
    public static int[] list = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String jongmin = br.readLine();
        String hername = br.readLine();

        int len = jongmin.length() * 2;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0, j = 0; i < len / 2; ++i) {
            queue.add(list[jongmin.charAt(i) - 'A']);
            queue.add(list[hername.charAt(i) - 'A']);
        }

        // 점수가 10의 자리기 때문에 2개될 때 까지 반복
        while (queue.size() > 2) {
            // 현재 값 빼기.
            int cur = queue.poll();
            int strLen = queue.size();

            for (int i = 0; i < strLen; ++i) {
                // 다음 값 꺼내고 더해준다.
                int next = queue.poll();
                queue.add((cur + next) % 10);

                // 현재 값을 다음값으로 변경.
                cur = next;
            }
        }

        sb.append(queue.poll()).append(queue.poll());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
