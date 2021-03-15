package com.ssafy.Baekjoon._210226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_2304_창고다각형 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int high = 0;
		int width = 1;
		int board = 0;
		int maxhigh = 0;

		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.add(new int[] { x, y });

			if (y > maxhigh) {
				maxhigh = y;
			}
		}
		list.sort((int[] a, int[] b) -> a[0] - b[0]);

		int tmpmaxH = list.get(0)[1];
		int tmpW = list.get(0)[0];

		for (int i = 0; i < N; ++i) {
			int currentHigh = list.get(i)[1];

			if (currentHigh > tmpmaxH) {
				board += (tmpmaxH * (list.get(i)[0] - tmpW));
				tmpW = list.get(i)[0];
				tmpmaxH = currentHigh;
			}
			if (currentHigh == maxhigh) {
				int tmpwidth = 1;
				for(int j = i +1; j < N;++j)
				{
					if(list.get(j)[1] == currentHigh)
						tmpwidth = list.get(j)[0] - list.get(i)[0];
				}
				if(tmpwidth != 1)
					board += (currentHigh*tmpwidth);
				board += currentHigh;
				break;
			}

		}

		tmpmaxH = list.get(list.size() - 1)[1];
		tmpW = list.get(list.size() - 1)[0];
		for (int i = list.size() - 1; i >=0; --i) {
			int currentHigh = list.get(i)[1];

			if (currentHigh > tmpmaxH) {
				board += (tmpmaxH * (tmpW - list.get(i)[0]));
				tmpW = list.get(i)[0];
				tmpmaxH = currentHigh;
			}
			if (currentHigh == maxhigh)
				break;
		}

		System.out.println(board);
	}

}
