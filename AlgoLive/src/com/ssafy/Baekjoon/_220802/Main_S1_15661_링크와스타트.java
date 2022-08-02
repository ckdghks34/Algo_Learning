package com.ssafy.Baekjoon._220802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S1_15661_링크와스타트 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 한 팀의 팀원이 1명일 경우 부터 (선수-1)명 일때까지
        for (int i = 1; i < N; ++i)
            Com(i, 0, 0, new boolean[N]);

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * selectCnt : 팀원 총인원수
     * cnt : 선택된 인원수
     * start : 시작기준
     */
    public static void Com(int selectCnt, int cnt, int start, boolean[] people) {
        // 팀원의 인원수와 선택된 인원이 같으면
        if (cnt == selectCnt) {
            int startSum = 0;
            int linkSum = 0;

            // 둘다 True 이거나  False 이면 같은팀
            // True = start팀
            // false = link 팀
            for (int i = 0; i < N; ++i) {
                for (int j = i + 1; j < N; ++j) {
                    if (people[i] && people[j]) {
                        startSum += map[i][j] + map[j][i];
                    } else if (!people[i] && !people[j]) {
                        linkSum += map[i][j] + map[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(startSum - linkSum));

            return;
        }

        // 조합
        // 선택된 경우 true, 아닐경우 false
        for (int i = start; i < N; ++i) {
            people[i] = true;
            Com(selectCnt, cnt + 1, i + 1, people);
            people[i] = false;
        }
    }
}
