package com.ssafy.Baekjoon._220721;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_G5_17609_회문 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= TC;++tc)
        {
            String str = br.readLine();
            int strLen = str.length();

            sb.append(solution(str,0,strLen-1,0)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solution(String str,int start, int end, int cnt){
        int state = 0;

        // 2번 이상 틀린경우는 회문, 유사회문이 될수 없기 때문에 2를 바로 반환
        //
        if(cnt > 1)
            return 2;

        // Palindrome 인지 확인한다.(str 그대로)
        while(start <= end)
        {

            char front = str.charAt(start);
            char back = str.charAt(end);

            // 현재 비교하는 값이 다른 경우
            if(front != back)
            {
                // 앞 또는 뒤 문자를 빼고 나머지를 회문체크를 했을 때
                // 두 문자열 중 하나라도 회문일 경우 유사회문
                // 두 문자열 모두 회문이 아닐 경우는 전체가 회문이 아님.
                // ex) xabba => x와 a가 다르기때문에 첫문자를 제외한 "abba" 과 뒷 문자를 제외한 "xabb"를 회문 체크한다.
                // 둘중에 하나라도 회문일 경우 유사회문이 된다.
                String first = str.substring(start+1,end+1);
                String second = str.substring(start,end);

                // 위의 예시에서, "abba", "xbba"를 다시 재귀로 불러 체크한다.
                // 둘 중에 하나라도 회문일 경우 유사회문 이기때문에 state == 1
                if(solution(first,0,first.length()-1,cnt+1) == 0 || solution(second,0,second.length()-1,cnt+1) == 0)
                    state = 1;
                // 둘다 회문이 아닐 경우 state == 2
                else
                    state = 2;

                break;
            }

            start++;
            end--;
        }

        return state;
    }
}