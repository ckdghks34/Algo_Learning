package com.ssafy.exSoftAcademy._210205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d3_3499_퍼펙트셔플 {
	
	static Queue<String> q = new LinkedList<String>();
	static Queue<String> q1 = new LinkedList<String>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d3_3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; ++tc)
		{
			int N = Integer.parseInt(br.readLine());
			int size = N%2 == 0? (N/2)-1:N/2;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			while(st.hasMoreTokens())
			{
				if(q.size() <= size)
					q.offer(st.nextToken());
				else
					q1.offer(st.nextToken());

			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+" ");
			while(q.size() != 0 && q.size() != 0)
			{
				if(q.size() >0)
					sb.append(q.poll() + " ");
				if(q1.size() > 0)
					sb.append(q1.poll() + " ");
			}
			sb.append("\n");
			bw.write(sb.toString());
			bw.flush();
			//System.out.println();
		}
		br.close();
		bw.close();
	}
}
