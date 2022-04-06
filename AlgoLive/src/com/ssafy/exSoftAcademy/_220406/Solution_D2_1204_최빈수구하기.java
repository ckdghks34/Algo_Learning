package com.ssafy.exSoftAcademy._220406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution_D2_1204_최빈수구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; ++tc)
        {
            int testNumber = Integer.parseInt(br.readLine());
            sb.append("#").append(testNumber).append(" ");

            st = new StringTokenizer(br.readLine()," ");
            HashMap<Integer,Integer> map = new HashMap<>();
            while(st.hasMoreTokens())
            {
                int cur = Integer.parseInt(st.nextToken());
                if(map.containsKey(cur))
                    map.replace(cur,map.get(cur)+1);
                else
                    map.put(cur,1);
            }

            ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

            list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if(o2.getValue() - o1.getValue() == 0)
                        return o2.getKey() - o1.getKey();
                    return o2.getValue() - o1.getValue();
                }
            });

            sb.append(list.get(0).getKey()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }
}