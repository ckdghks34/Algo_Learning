package com.ssafy.softeer.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Transmissions8th {
    static final String asc = "ascending";
    static final String desc = "descending";
    static final String mix = "mixed";
    static final int inputMax = 8;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력값 형태가 8개의 숫자를 고정적으로 제공하기 때문에 array 사용
        int[] input = new int[inputMax];
        String result = "";
        for (int i = 0; i < inputMax; ++i)
            input[i] = Integer.parseInt(st.nextToken());

        // 첫번째 index와 두번째 index를 비교하여 현재 상태값 결정
        // 첫번째 index값이 두번째 index값 보다 작으면 asc, 크면 desc
        if (input[0] < input[1])
            result = asc;
        else
            result = desc;

        for (int i = 3; i < inputMax; ++i) {
//            if (input[i - 1] < input[i]) {
//                if (result.equals(desc))
//            }
            if (!result.equals(compareTransmisson(input[i - 1], input[i]))) {
                result = mix;
                break;
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    static public String compareTransmisson(int pre, int cur) {
        return cur - pre > 0 ? asc : desc;
    }
}
