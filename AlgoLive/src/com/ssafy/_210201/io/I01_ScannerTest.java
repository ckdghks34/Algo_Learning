package com.ssafy._210201.io;

import java.util.Scanner;

public class I01_ScannerTest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		System.out.println("정수,실수,문자열을 차례대로 입력하세요.");
		
		System.out.println("읽은 정수 : "+sc.nextInt());
		System.out.println("읽은 실수 : "+sc.nextDouble());
		System.out.println("읽은 문자열 : "+sc.next());
		System.out.println("읽은 문자열 : "+sc.nextLine());
	}

}
