package com.ssafy.Baekjoon._210225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BJ_10158_개미 {

	// 우하, 좌하, 좌상, 우상
	static int[] dx = { 1, -1, -1, 1 };
	static int[] dy = { 1, 1, -1, -1 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int t = Integer.parseInt(st.nextToken());
		
		
		int tmpx = p + t;
		int tmpy = q + t;
		int rx = 0;
		int ry = 0;
		if((tmpx /w)%2 == 0)
			rx = tmpx%w;
		else
			rx = w - tmpx%w;

		if((tmpy /h)%2 == 0)
			ry = tmpy%h;
		else
			ry = h - tmpy%h;
		

		StringBuilder sb= new StringBuilder();
		sb.append(Integer.toString(rx)).append(" ").append(Integer.toString(ry));
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}

}
