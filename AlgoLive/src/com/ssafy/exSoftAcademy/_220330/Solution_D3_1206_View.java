package com.ssafy.exSoftAcademy._220330;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_D3_1206_View {
    public static int N;
    public static int[] map = new int[1001];
    public static void main(String[] args) throws IOException,NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int tc = 1 ; tc <= 10; ++tc) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; ++i)
                map[i] = Integer.parseInt(st.nextToken());

            sb.append("#").append(tc).append(" ").append(countView()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int countView(){
        int count = 0;
        int[] range = {-2,-1,1,2};
        for(int i = 0; i < N;++i)
        {
            int cur = map[i];
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < 4;++j)
            {
                int nextIndex = i + range[j];

                if(nextIndex >= 0 && nextIndex < N) {
                    int next = map[nextIndex];
                    if (cur > next)
                        min = Math.min(cur - next,min);
                    else
                        min = 0;
                }
            }
            if(min != Integer.MAX_VALUE)
                count += min;
        }

        return count;
    }
}
