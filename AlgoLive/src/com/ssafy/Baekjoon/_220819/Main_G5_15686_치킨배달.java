package com.ssafy.Baekjoon._220819;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_15686_치킨배달 {
    static class Location {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Location> house = new ArrayList<>();
    static ArrayList<Location> chicken = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; ++j) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 2)
                    chicken.add(new Location(j, i));
                else if (cur == 1)
                    house.add(new Location(j, i));
            }
        }
        Combination(M, 0, 0, new Location[M]);

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Combination(int M, int start, int cnt, Location[] selectedChicken) {
        if (cnt == M) {
            int sum = 0;
            for (int i = 0; i < house.size(); ++i) {
                int distance = Integer.MAX_VALUE;
                Location houseLocation = house.get(i);

                for (int j = 0; j < M; ++j) {
                    int dis = Math.abs(houseLocation.x - selectedChicken[j].x) + Math.abs(houseLocation.y - selectedChicken[j].y);
                    distance = Math.min(distance, dis);
                }
                sum += distance;

                // 이미 합이 최솟값 이상이면 종료
                if(sum >= min)
                    return;
            }

            // 최솟값 업데이트
            min = sum;
            return;
        }
        for (int i = start; i < chicken.size(); ++i) {
            selectedChicken[cnt] = chicken.get(i);
            Combination(M, i + 1, cnt + 1, selectedChicken);
        }
    }
}
