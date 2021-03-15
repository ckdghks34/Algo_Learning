package com.ssafy.exSoftAcademy._210215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_d3_6808_규영이와인영이의카드게임 {

	static int T;
	static int[] gcard = new int[9]; // 규영이가 사용한 카드더미
	static int[] icard1 = new int[9]; // 인영이가 사용할 카드더미
	static int[] score = new int[2]; // index 0 : 이긴 횟수 , index 1 : 진 횟수
	static boolean[] isUsed;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d3_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			score[0] = 0;
			score[1] = 0;
			isUsed = new boolean[19];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 9; ++i) {
				gcard[i] = Integer.parseInt(st.nextToken());
				isUsed[gcard[i]] = true;
			}

			per(0);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(score[0]).append(" ").append(score[1]).append("\n");
			bw.write(sb.toString());
			bw.flush();

		}
		br.close();
		bw.close();
	}

	static void per(int cnt) {
		if (cnt == 9) {
			int gsum = 0;
			int isum = 0;

			for (int j = 0; j < 9; ++j) {
				if (icard1[j] > gcard[j])
					isum += (icard1[j] + gcard[j]);
				else
					gsum += (icard1[j] + gcard[j]);
			}
			if (gsum > isum)
				score[0]++;
				score[1]++;
			return;
		}

		for (int i = 1; i <= 18; ++i) {
			if (isUsed[i])
				continue;

			icard1[cnt] = i;
			isUsed[i] = true;
			per(cnt + 1);
			isUsed[i] = false;

		}
	}

}
