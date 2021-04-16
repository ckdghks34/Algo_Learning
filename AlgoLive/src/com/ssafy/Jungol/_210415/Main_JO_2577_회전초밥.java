package com.ssafy.Jungol._210415;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_2577_회전초밥 {
	static int N, d, k, c;
	static int[] belt;

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		belt = new int[N];
		int[] kind = new int[d + 1];
		int count = 0;
		int max = 0;

		// 값 입력
		for (int i = 0; i < N; ++i) {
			belt[i] = Integer.parseInt(br.readLine());

			if (i < k) {
				if (kind[belt[i]] == 0)
					count++;
				kind[belt[i]]++;
			}
		}

		for (int i = 1; i < N; ++i) {
			if (count >= max) {
				if (kind[c] == 0)
					max = count + 1;
				else
					max = count;
			}

			// 가장 왼쪽 것 빼기
			kind[belt[i - 1]]--;

			// 먹은 초밥의 종류가 0 이면 안먹은거니까 먹은갯수에서 빼기
			// 먹은 초밥의 종류가 0이 아니면 그 이상 먹은것
			if (kind[belt[i - 1]] == 0)
				--count;

			// 마지막 먹은 초밥 오른쪽 초밥을 먹었을 때
			// 먹지 않은 초밥의 종류라면 count++;

			// i+(k-1)%N 이 인덱스인 이유는 : 회전하기 때문
			if (kind[belt[(i + (k - 1)) % N]] == 0)
				++count;

			kind[belt[(i + (k - 1)) % N]]++;

		}

		System.out.println(max);
	}
}
