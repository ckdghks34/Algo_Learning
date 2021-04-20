package com.ssafy.exSoftAcademy._210419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_8458_원점으로집합 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int result = 0;

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[i] = Math.abs(x) + Math.abs(y);
			}
			for (int i = 1; i < N; ++i) {
				if (arr[0] % 2 != arr[i] % 2) {
					result = -1;
					break;
				}
			}
			if (result != 1) {
				int sum = 0;
				Arrays.sort(arr);
				result = arr[arr.length - 1];

				if (result == 0)
					result = 0;

				for (int i = 1; result != 0; ++i) {
					sum += i;
					if (sum >= result && (sum % 2) == (result % 2)) {
						result = i;
						break;
					}
				}
			}
			sb.append(result);
			System.out.println(sb.toString());
		}
	}

}
