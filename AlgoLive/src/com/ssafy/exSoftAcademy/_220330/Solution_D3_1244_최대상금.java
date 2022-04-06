package com.ssafy.exSoftAcademy._220330;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금 {
    public static int count;
    public static int[] value;
    public static int max;
    public static String maxValue;
    public static HashSet<String> set = new HashSet<String>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; ++tc) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            value = new int[str.length()];
            for(int i = 0; i < str.length();++i)
                value[i] = str.charAt(i) - '0';
            char[] tmpchar = str.toCharArray();
            Arrays.sort(tmpchar);
            maxValue = new StringBuilder(new String(tmpchar)).reverse().toString();
            count = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;

            dfs(0,0);
            sb.append(max).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int k,int cnt){
        StringBuilder tmp = new StringBuilder();

        for(int i =0 ; i < value.length;++i)
            tmp.append(value[i]);

        if(cnt != 0) {// 중복확인
            if (set.contains(tmp.toString()))
                return;

            if (maxValue.equals(tmp.toString())) {
                int remain = count - cnt;

                if (remain % 2 == 0) {
                    max = Integer.parseInt(tmp.toString());
                    return;
                }
                else
                {
                    char sbswap = tmp.charAt(tmp.length()-1);
                    char sbswap2 = tmp.charAt(tmp.length()-2);
                    tmp.delete(tmp.length()-2,tmp.length());
                    tmp.append(sbswap).append(sbswap2);

                    max = Integer.parseInt(tmp.toString());
                    return;
                }
            }

            set.add(tmp.toString());
        }
        if(cnt == count)
        {
            int cur = Integer.parseInt(tmp.toString());
            max = cur > max ? cur : max;
            return;
        }

        for(int i = k; i < value.length;++i)
        {
            for(int j = i + 1; j < value.length;++j)
            {
                if(value[i] <= value[j]) {
                    swap(i, j);
                    dfs(k, cnt + 1);
                    swap(j, i);
                }
            }
        }
    }

    public static void swap(int i, int j)
    {
        int tmp = value[i];
        value[i] = value[j];
        value[j] = tmp;
    }
}
