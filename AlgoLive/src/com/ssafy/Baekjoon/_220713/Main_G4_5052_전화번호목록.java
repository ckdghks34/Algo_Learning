package com.ssafy.Baekjoon._220713;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
//            list.sort(new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    return o1.length() - o2.length();
//                }
//            });

            for (int j = 0; j < n - 1; ++j) {
                if (!checkingCase(list, j)) {
                    valid = false;
                    break;
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

    public static boolean checkingCase(ArrayList<String> list, int index) {
        String current = list.get(index);
        char startChar = current.charAt(0);
        int currentLength = current.length();

        for (int i = index + 1; i < list.size(); ++i) {
            String tmp = list.get(i);
            if(currentLength < tmp.length()) {
                if (startChar == tmp.charAt(0)) {
                    if (current.equals(tmp.substring(0, currentLength)))
                        return false;
                }
            }
        }
        return true;
    }
}
