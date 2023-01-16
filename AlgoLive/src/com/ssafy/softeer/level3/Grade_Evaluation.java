package com.ssafy.softeer.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Grade_Evaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int participantCount = Integer.parseInt(br.readLine());
        int[] totalScore = new int[participantCount + 1];
        PriorityQueue<Participant> queue = new PriorityQueue<>();

        for (int i = 1; i <= participantCount; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= participantCount; ++j) {
                int value = Integer.parseInt(st.nextToken());
                queue.offer(new Participant(j, value));
                totalScore[j] += value;
            }
            sb.append(evaluation(queue));
        }

        for (int i = 1; i < totalScore.length; ++i) {
            queue.offer(new Participant(i, totalScore[i]));
        }
        sb.append(evaluation(queue));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String evaluation(PriorityQueue<Participant> queue) {
        StringBuilder sb = new StringBuilder();
        int[] scores = new int[queue.size() + 1];
        int curGrade = 1;
        Participant pre = queue.poll();
        scores[pre.index] = curGrade;

        while (!queue.isEmpty()) {
            Participant cur = queue.poll();

            if (pre.score == cur.score) {
                scores[cur.index] = curGrade;
            } else {
                scores[cur.index] = ++curGrade;
                pre = cur;
            }
        }
        for (int i = 1; i < scores.length; ++i) {
            sb.append(scores[i]).append(" ");
        }
        sb.append("\n");

        return sb.toString();
    }

    static class Participant implements Comparable<Participant> {
        int index;
        int score;

        Participant(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Participant p) {
            return p.score - this.score;
        }
    }
}
