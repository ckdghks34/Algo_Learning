package com.ssafy.exSoftAcademy._210210;

import java.util.*;
import java.io.*;
 
public class Solution_d4_1233_사칙연산_유효성_검사2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/ES_input_d4_1233.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1;tc<=10;tc++) {
            int N=Integer.parseInt(br.readLine());
            int ans=1;
            for(int i=0;i<N;i++) {
                StringTokenizer st=new StringTokenizer(br.readLine()," ");
                String item=st.nextToken();
                item=st.nextToken();
                int citem=item.charAt(0)-'0';
                 
                if(st.hasMoreTokens()) {
                    if(citem>=0) ans=0;
                }
                else if(citem<0) ans=0;
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}