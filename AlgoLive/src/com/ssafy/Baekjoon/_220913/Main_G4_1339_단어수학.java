package com.ssafy.Baekjoon._220913;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_G4_1339_단어수학 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alpabet = new int[26];

        int result = 0;

        // 단어 갯수 N개
        int N = Integer.parseInt(br.readLine());

        // 단어 입력
        for (int i = 0; i < N; ++i) {
            // 입력
            String tmp = br.readLine();
            int tmpLength = tmp.length();

            // 자릿수
            // ABC -> 100A + 10B + C
            int val = (int) Math.pow(10, tmpLength - 1);

            for (int j = 0; j < tmpLength; ++j) {
                alpabet[tmp.charAt(j) - 'A'] += val;
                val /= 10;
            }
        }

        // 오름차 순 정렬
        Arrays.sort(alpabet);

        int value = 9;

        // 오름차순 정렬이기 때문에 뒤에서부터 탐색
        // 문자 개수는 최대 10개이기대문에 16이하의 값은 없을 것임.
        for (int i = 25; i > 15; --i) {
            // 값이 0이면 종료
            if (alpabet[i] == 0)
                break;

            // 최대 큰 수 * value(9,8,7 .. ) 순서대로 곱해서 더해주면 최대값이 나옴.
            result += alpabet[i] * value;
            value--;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
