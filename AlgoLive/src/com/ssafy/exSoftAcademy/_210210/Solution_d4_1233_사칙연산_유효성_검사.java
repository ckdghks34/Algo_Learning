package com.ssafy.exSoftAcademy._210210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_d4_1233_사칙연산_유효성_검사 {

	static char[] arr;
	static int check;

	public static void main(String[] args) throws IOException, NumberFormatException {
		System.setIn(new FileInputStream("res/ES_input_d4_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 10;
		int N = 0;

		for (int tc = 1; tc <= T; ++tc) {
			check = 1;
			N = Integer.parseInt(br.readLine());
			arr = new char[N + 1];

			for (int i = 1; i <= N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int index = Integer.parseInt(st.nextToken());
				char tmp = st.nextToken().charAt(0);
				if(tmp >='0' && arr[i] <= '9')
				{
					if(i*2 <=N || i*2+1 <=N)
						check =0;
				}

			}

			for (int i = 1; i <= N; ++i) {
				if (arr[i] >= '0' && arr[i] <= '9') {
					int preindex = i * 2;
					int nextindex = i * 2 + 1;

					if (preindex <= N || nextindex <= N) {
						check = 0;
						break;
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(check).append("\n");
			bw.write((sb.toString()));
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
