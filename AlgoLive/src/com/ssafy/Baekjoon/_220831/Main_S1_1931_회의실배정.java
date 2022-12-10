package com.ssafy.Baekjoon._220831;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S1_1931_회의실배정 {

    static class Meeting implements Comparable<Meeting>{
        int startTime;
        int endTime;

        Meeting(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        // 1순위는 끝나는 시간 오름차순
        // 2순위는 시작 시간 오름차순
        @Override
        public int compareTo(Meeting m){
            if(this.endTime == m.endTime)
                return this.startTime - m.startTime;

            return this.endTime - m.endTime;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = 0;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> list = new ArrayList<>();

        for(int i =0 ;i < n;++i)
        {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            list.add(new Meeting(startTime,endTime));
        }
        Collections.sort(list);


        int curTime = 0;
        for(int i = 0; i < n;++i)
        {
            Meeting meeting = list.get(i);
            if(meeting.startTime >= curTime) {
                count++;
                curTime = list.get(i).endTime;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
