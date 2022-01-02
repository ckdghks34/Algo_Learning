package com.ssafy.Baekjoon._220102;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main_S5_4673_셀프넘버 {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		boolean[] check = new boolean[10000 + 1];

		for (int i = 1; i < 10000; ++i) {
			int creator = i;

			if (!check[i])
				sb.append(i).append("\n");

			String tmp = Integer.toString(i);

			for (int j = 0; j < tmp.length(); ++j) {
				creator += tmp.charAt(j) - '0';
			}

			if (creator < 10001)
				check[creator] = true;
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
