package com.ssafy.codingTest.LGU22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution2 {
    public static void main(String[] args) {
        int[] arr = {112, 1814, 121, 1481, 1184};

        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i) {
            String string = Integer.toString(arr[i]);
            char[] tmp = string.toCharArray();

            Arrays.sort(tmp);
            set.add(new String(tmp));
        }

        answer = set.size();
        return answer;
    }

}
