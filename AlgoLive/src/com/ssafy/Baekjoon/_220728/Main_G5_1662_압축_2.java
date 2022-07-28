package com.ssafy.Baekjoon._220728;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_G5_1662_압축_2 {
    static Stack<Character> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        stack = new Stack<>();

        String str = br.readLine();
        int length = str.length();
        int result = 0;
        for (int i = 0; i < length; ++i)
            stack.add(str.charAt(i));

        while (!stack.isEmpty()) {
            char cur = stack.pop();

            if (cur == ')')
                result += parentheses();
            else
                result++;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int parentheses() {
        int middle = 0;
        int result = 0;
        while (!stack.isEmpty()) {
            char cur = stack.pop();

            if (cur == '(') {
                int next = stack.pop() - '0';
                result = middle * next;
                break;
            } else if (cur == ')')
                middle += parentheses();
            else
                middle++;
        }

        return result;
    }
}
