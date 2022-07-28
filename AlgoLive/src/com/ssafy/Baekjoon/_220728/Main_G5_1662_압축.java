package com.ssafy.Baekjoon._220728;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_G5_1662_압축 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        Stack<Character> parentheses = new Stack<>();

        String str = br.readLine();
        int length = str.length();
        int result = 0;
        for (int i = 0; i < length; ++i)
            stack.add(str.charAt(i));

        int middle = 0;
        while (!stack.isEmpty()) {
            char cur = stack.pop();

            if (cur == ')') {
                parentheses.add(cur);
            } else if (cur == '(') {
                int front = stack.pop() - '0';

                parentheses.pop();

                if (parentheses.empty()) {
                    result += front * middle;
                    middle = 0;
                } else
                    middle = front * middle;
            } else {
                if (parentheses.isEmpty()) {
                    result++;
                    middle = 0;
                } else {
                    middle++;
                }
            }
        }
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
