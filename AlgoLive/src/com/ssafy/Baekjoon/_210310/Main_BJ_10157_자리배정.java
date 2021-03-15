package com.ssafy.Baekjoon._210310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10157_자리배정 {

	// 하 우 상 좌
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		int r = 0;
		int c = 0;
		int num = 1;
		int last = R * C; // 마지막 숫자

		if (K > last) {
			System.out.println(0);
			return;
		}

		ex: while (num < last) {
			for (int i = 1; i < R; ++i) {
				if (num == K) {
					System.out.println((c + 1) + " " + (r + 1));
					break ex;
				}
				r++;
				num++;
			}
			for (int i = 1; i < C; ++i) {
				if (num == K) {
					System.out.println((c + 1) + " " + (r + 1));
					break ex;
				}
				c++;
				num++;
			}
			for (int i = 1; i < R; ++i) {
				if (num == K) {
					System.out.println((c + 1) + " " + (r + 1));
					break ex;
				}
				r--;
				num++;
			}
			for (int i = 1; i < C; ++i) {
				if (num == K) {
					System.out.println((c + 1) + " " + (r + 1));
					break ex;
				}
				c--;
				num++;
			}
			r++;
			c++;
			R -= 2;
			C -= 2;
		}
	}
}
