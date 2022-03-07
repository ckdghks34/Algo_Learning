package com.ssafy.Baekjoon._220307;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_G2_1300_K번째수_다시풀어보기 {
	public static int N, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		long left = 1;
		long right = k;
		long result = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;

			for (int i = 1; i <= N; ++i)
				cnt += Math.min(mid / i, N);

			if (cnt >= k) {
				result = mid;
				right = mid - 1;
			} else
				left = mid + 1;
		}

		bw.write(Long.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}

}
