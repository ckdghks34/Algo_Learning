package com.ssafy.Baekjoon._220713;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main_S5_4659_비밀번호발음하기 {

    // 모음(vowel) 확인 시 반복하는 시간을 줄이기 위해 HashMap에 저장 시킴
    /*
        반복을 통해 값 확인할 때 시간복잡도 O(n), n은 데이터 수
        HashMap의 contains 함수 사용시 시간복잡도 O(1)
     */
   public static HashMap<Character, Character> vowel = new HashMap<Character, Character>() {{
        put('a', 'a');
        put('e', 'e');
        put('i', 'i');
        put('o', 'o');
        put('u', 'u');
    }};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 초기화
        String str = "";
        while (true) {
            str = br.readLine();

            // "end" 문자열 입력 시 반복문 종료
            if (str.equals("end"))
                break;

            sb.append("<").append(str).append(">");

            int len = str.length();

            // 유효 한지 Checking 하는 변수
            boolean valid = true;

            // 첫번째 조건 (모음 1개 이상)을 만족하면 (True)
            if (first(str)) {
                // 문자 수 만큼 반복, 이미 유효하지않으면(valid == false) 일 경우 종료
                for (int i = 0; i < len && valid; ++i) {
                    // 현재 Index 기준 +2 만큼 확인하면 된다.
                    // 남은 문자 수가 2개 보다 작으면 조건 만족
                    // 즉, 문자열 중 뒤에서 2번째 보다 미만이면 실행
                    if (i < len - 2)
                        valid = second(str, i);

                    // 현재 Index 기준 +1 만 확인하면 된다.
                    // 따라서, 마지막 글자가 아니라면 조건 만족
                    // 이미 비밀번호가 유효하지 않으면 실행 하지 않음.
                    // ex) second() = false, third() = true 일 경우 값은 유효하지않지만 유효하다고 변경됨.
                    if (valid && i < len - 1)
                        valid = third(str, i);
                }
            } else
                valid = false;

            // 유효한 비밀번호 였을때,
            if (valid)
                sb.append(" is acceptable.").append("\n");
            else
                sb.append(" is not acceptable.").append("\n");
        }

        // 출력
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static boolean first(String str) {
        int len = str.length();

        for (int i = 0; i < len; ++i) {
            char value = str.charAt(i);

            // 해당 글자가 모음 리스트(HashMap)에 있으면 True 반환
            if (vowel.containsKey(value))
                return true;
        }

        return false;
    }

    public static boolean second(String str, int index) {
        char current = str.charAt(index);
        // 현재 문자가 모음이면 1, 자음이면 0
        int cur = vowel.containsKey(current) ? 1 : 0;

        for (int i = index + 1; i < index + 3; ++i) {
            char nextChar = str.charAt(i);
            // 다음 문자가 모음이면 1, 자음이면 0
            int next = vowel.containsKey(nextChar) ? 1 : 0;

            // 현재 문자와 다음 문자가 다르면 유효한 비밀번호(True)
            if (cur != next) {
                return true;
            }
        }

        // 유효하다면 이미 Return 되었을 것이기 때문에 False 반환
        return false;
    }

    public static boolean third(String str, int index) {
        char current = str.charAt(index);

        // 'e' or 'o' 일 경우는 허용되기 때문에 True 반환
        if (current == 'e' || current == 'o')
            return true;

        char next = str.charAt(index + 1);

        return current != str.charAt(index+1);
    }
}
