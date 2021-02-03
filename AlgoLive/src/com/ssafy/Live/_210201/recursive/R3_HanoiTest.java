package com.ssafy.Live._210201.recursive;

import java.util.Scanner;

public class R3_HanoiTest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		hanoi(n,1,2,3);
	}
	
	private static void hanoi(int cnt, int from, int temp, int to) {

		if(cnt == 0)
			return;
		// n-1개 원판 이동
		hanoi(cnt-1,from,to,temp);
		System.out.println(cnt+":"+from+"->"+to);
		// n-1개 원판이동
		hanoi(cnt-1,temp,from,to);
	}

}
