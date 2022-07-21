package com.ssafy.Baekjoon._220718;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_G5_12904_A와B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        String s = br.readLine();
        String t = br.readLine();
        boolean valid = false;

        int sLen = s.length();
        int tLen = t.length();

        StringBuilder sb = new StringBuilder();
        sb.append(t);

        while(sb.length() > sLen){
            int lastidx = sb.length()-1;

            if(sb.charAt(lastidx) == 'A')
                sb.setLength(lastidx);
            else
            {
                sb.setLength(lastidx);
                sb = sb.reverse();
            }

            if(sb.toString().equals(s)) {
                valid = true;
                break;
            }
        }



//        queue.add(s);


//        while (!queue.isEmpty()) {
//            String cur = queue.poll();
//
//            if (cur.equals(t)) {
//                valid = true;
//                break;
//            }
//
//            if (cur.length() >= tLen)
//                continue;
//
//            queue.add(first(cur));
//            queue.add(second(cur));
//        }

        if (valid)
            bw.write("1");
        else
            bw.write("0");
        bw.flush();
        bw.close();
        br.close();
    }

}
