package com.ssafy.Baekjoon._220722;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S2_6503_망가진키보드 {

    static int[] character = new int[128];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int m = -1;
        while (m != 0) {
            m = Integer.parseInt(br.readLine());

            if (m == 0)
                break;

            String str = br.readLine();

            int start = -1;
            int end = -1;
            int charCnt = 0;
            int maxLength = 0;

            while (start <= end) {
                if(end > str.length()-1)
                    break;

                if (charCnt < m) {
                    if (character[str.charAt(end)] == 0)
                        charCnt++;

                    character[str.charAt(end)]++;
                    end++;
                } else if (charCnt == m) {
                    if(character[str.charAt(end+1)] > 0)
                    {
                        character[str.charAt(end+1)]++;
                        end++;
                    }
                    else{
                        maxLength = Math.max(end - start, maxLength);

                        character[str.charAt(start)]--;

                        if(character[str.charAt(start)] == 0)
                            charCnt--;

                        start++;
                    }
                } else {
                    character[str.charAt(start)]--;

                    if(character[str.charAt(start)] == 0)
                        charCnt--;

                    start++;
                }
                maxLength = Math.max(end - start, maxLength);
            }
            sb.append(maxLength);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
