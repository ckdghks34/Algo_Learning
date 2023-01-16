package com.ssafy.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution2 {
    static int length = 0;
    static TreeMap<Character, Integer> treemap = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < 3; ++i) {
            int it = Integer.parseInt(st.nextToken());
            length += it;
            treemap.put((char) ('A' + i), it);
        }
        int lastIdx = length / 2 - 1;
        char[][] result = new char[length / 2][2];

        char winner = br.readLine().charAt(0);
        int continuity = Integer.parseInt(br.readLine());

        for (int i = 0; i < continuity; ++i) {
            result[i][0] = winner;
            treemap.put(winner, treemap.get(winner) - 1);
        }

        int idx = 0;
        while (idx < result.length) {
            ArrayList<Character> maxCharList = findMaxChar(winner);

            for (int i = 0; i < maxCharList.size(); ++i) {
                if (idx == 0) {
                    result[idx][1] = maxCharList.get(i);
                    break;
                } else if (idx == (result.length - 1) - continuity) {
                    if (maxCharList.get(i) == winner)
                        continue;
                } else {
                    if (result[idx - 1][1] == maxCharList.get(i))
                        break;
                }
            }
        }
    }

    static private ArrayList<Character> findMaxChar(Character lastChar) {
        int maxCount = 0;

        ArrayList<Character> list = new ArrayList<>();

        for (Character c : treemap.keySet()) {
            if (c == lastChar)
                continue;

            if (maxCount > list.get(c))
                continue;
            else if (maxCount == list.get(c))
                list.add(c);
            if (maxCount < list.get(c)) {
                maxCount = list.get(c);
                list.clear();
                list.add(c);
            }
        }

        return list;
    }
}
