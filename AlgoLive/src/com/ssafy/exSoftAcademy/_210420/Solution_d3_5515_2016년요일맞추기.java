package com.ssafy.exSoftAcademy._210420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_5515_2016년요일맞추기 {

	static int[] months = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		int month, day;
		int diff = 0;
		int start = 4;
		for (int tc = 1; tc <= T; ++tc) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");

			diff = start;
			month = Integer.parseInt(st.nextToken());
			day = Integer.parseInt(st.nextToken());

			for (int i = 1; i < month; ++i) {
				diff += months[i];
			}

			diff += (day - 1);

			sb.append(diff % 7);

			System.out.println(sb.toString());

		}
	}

}