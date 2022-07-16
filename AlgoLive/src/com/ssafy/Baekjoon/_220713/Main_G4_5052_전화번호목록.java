package com.ssafy.Baekjoon._220713;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main_G4_5052_전화번호목록 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int n = 0;
        boolean valid = true;
        for (int i = 1; i <= t; ++i) {
            n = Integer.parseInt(br.readLine());
            ArrayList<String> list = new ArrayList<String>();
            valid = true;

            for (int j = 0; j < n; ++j)
                list.add(br.readLine());

            Collections.sort(list);
            for (int j = 0; j < n - 1; ++j) {
                String cur = list.get(j);
                String next = list.get(j + 1);

                if (cur.length() < next.length()) {
                    if (cur.equals(next.substring(0, cur.length()))) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
