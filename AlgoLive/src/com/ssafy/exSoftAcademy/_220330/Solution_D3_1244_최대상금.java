package com.ssafy.exSoftAcademy._220330;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금 {
    public static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= N;++tc)
        {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            char[] strArray = str.toCharArray();

            for(int i =0 ;i < strArray.length;++i)
            {
                int cur = strArray[i] - '0';
                int max = cur;
                int maxIndex = i;

                if(count == 0)
                    break;

                for(int j = strArray.length-1; j > i;--j)
                {
                    int tmp = strArray[j] - '0';

                    if(max < tmp)
                    {
                        max = tmp;
                        maxIndex = j;
                    }
                }
                if(maxIndex != i) {
                    char swaptmp = strArray[i];
                    strArray[i] = strArray[maxIndex];
                    strArray[maxIndex] = swaptmp;

                    count--;
                }
            }

            if(count != 0&&count % 2 == 1)
            {
                int last = strArray.length - 1;
                char swaptmp = strArray[last];
                strArray[last-1] = strArray[last];
                strArray[last] = swaptmp;
            }

            sb.append("#").append(tc).append(" ").append(new String(strArray)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
