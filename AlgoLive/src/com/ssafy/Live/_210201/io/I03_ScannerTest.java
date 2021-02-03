package com.ssafy.Live._210201.io;

import java.util.Scanner;

public class I03_ScannerTest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		System.out.println("기수 : " + sc.nextInt());
		//System.out.println("이름 : " + sc.next());
		sc.nextLine(); // 남은 '\n'을 지우기위한 라인
		System.out.println("이름 : " + sc.nextLine());
	}

}
