package com.ssafy.Jungol._210216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_JO_1828_냉장고 {
	static int N;
	static int[][] input;
	static int cnt;
	static int[][] refrigerator;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		input = new int[N][2];
		refrigerator = new int[N][2];
		refrigerator[0][0] = Integer.MAX_VALUE;
		int f = 0;
		boolean flag = false;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; ++i) {
			if (refrigerator[0][0] > input[i][0]) {
				refrigerator[0][0] = input[i][0];
				refrigerator[0][1] = input[i][1];
				f = i;
			} else if (refrigerator[0][0] == input[i][0]) {
				refrigerator[0][1] = Math.max(refrigerator[0][1], input[i][1]);
				f = i;
			}

		}
		cnt++;

		for (int i = 0; i < N; ++i) {
			if (i == f)
				continue;
			for (int j = 0; j < cnt; ++j) {
				if (input[i][0] >= refrigerator[j][0] && input[i][0] <= refrigerator[j][1]) {
					flag = false;
					break;
				}
				flag = true;
			}
			if (flag) {
				refrigerator[cnt][0] = input[i][0];
				refrigerator[cnt][1] = input[i][1];
				cnt++;
			}
		}
		bw.write(Integer.toString(cnt));
		
		br.close();
		bw.close();
	}
}
