package com.ssafy.codingTest.LGU22;

import java.util.Stack;

public class Solution1 {
    public static void main(String[] args) {
//        String compressed = "10(p)";
//        String compressed = "2(3(hi)co)";
        String compressed = "2(2(hi)2(co))x2(bo)";

        System.out.println(solution(compressed));
    }

    public static String solution(String compressed) {
        String answer = "";

        Stack<String> stack = new Stack<>();

        for (int i = compressed.length()-1; i >=0 ; --i){
            char curChar = compressed.charAt(i);
            if(curChar != '(')
                stack.add(String.valueOf(curChar));
            else
            {
                String tmpString = "";
                String number = "";
                String s = "";
                while(!stack.peek().equals(")"))
                    tmpString += stack.pop();

                while(i > 0 && Character.isDigit(compressed.charAt(i-1)))
                    number = compressed.charAt(--i) + number;

                for(int j =0 ;j < Integer.parseInt(number);++j)
                    s += tmpString;

                stack.pop();
                stack.add(s);
            }
        }
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
