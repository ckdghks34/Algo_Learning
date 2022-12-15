package com.ssafy.Programmers._221215;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 순위검색 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        System.out.println(Arrays.toString(new Solution().solution(info, query)));
    }

    static class Solution {

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];

            for (int i = 0; i < info.length; ++i) {
                info[i] = info[i].replaceAll(" and ", " ");
                String[] keyset = info[i].split(" ");
                int value = Integer.parseInt(keyset[keyset.length - 1]);
                keyset = Arrays.copyOf(keyset, keyset.length - 1);
                com(keyset, value, 0, "");
            }

            for (int i = 0; i < info.length; ++i) {
                query[i] = query[i].replaceAll(" and ", "");
                String[] tmp = query[i].split(" ");
                String key = tmp[0];
                int value = Integer.parseInt(tmp[1]);

                answer[i] = FindResult(key, value);
            }

            return answer;
        }

        public int FindResult(String key, int value) {
            int count = 0;
            ArrayList<Integer> valueList = map.get(key);

            if (valueList == null)
                return 0;

            for (int val : valueList)
                if (val >= value)
                    count++;

            return count;
        }

        public void com(String[] keyset, int value, int cnt, String s) {
            if (cnt == 4) {
                if (map.containsKey(s))
                    map.get(s).add(value);
                else {
                    map.put(s, new ArrayList<>());
                    map.get(s).add(value);
                }
                return;
            }

//            for (int i = cnt; i < keyset.length; ++i) {/
            com(keyset, value, cnt + 1, s + "-");
            com(keyset, value, cnt + 1, s + keyset[cnt]);
//            }/
        }
    }
}
