package com.ssafy.Baekjoon._220718;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S5_15904_UCPC는무엇의약자일까 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        boolean valid = false;
        for (int i = 0; i < input.length(); ++i) {
            if (cnt == 0 &&input.charAt(i) == 85)
                cnt++;
            else if( cnt == 1 && input.charAt(i) == 67)
                cnt++;
            else if(cnt == 2 && input.charAt(i) == 80)
                cnt++;
            else if( cnt == 3 && input.charAt(i) == 67) {
                valid = true;
                break;
            }
        }

        if (valid)
            bw.write("I love UCPC");
        else
            bw.write("I hate UCPC");

        bw.flush();
        bw.close();
        br.close();
    }
}
