package com.ssafy.Baekjoon._220726;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S5_1769_3의배수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String X = br.readLine();
        int XLen = X.length();
        int cnt = 0;

        if (XLen == 1) {
            sb.append("0").append("\n");
            if (X.equals("3") || X.equals("6") || X.equals("9"))
                sb.append("YES");
            else
                sb.append("NO");
        } else {
            while (XLen > 1) {
                cnt++;

                int sum = 0;
                for (int i = 0; i < XLen; ++i)
                    sum += X.charAt(i) - '0';


                if (sum / 10 == 0) {
                    sb.append(cnt).append("\n");

                    if (sum % 3 == 0)
                        sb.append("YES");
                    else
                        sb.append("NO");
                }

                X = Integer.toString(sum);
                XLen = X.length();
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
