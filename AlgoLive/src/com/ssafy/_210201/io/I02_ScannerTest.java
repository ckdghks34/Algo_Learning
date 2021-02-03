package com.ssafy._210201.io;

import java.util.Scanner;

public class I02_ScannerTest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String s1 = "안 \n녕\n";
		Scanner sc = new Scanner(s1);
		
		System.out.print("읽은 문자열 : "+sc.next());
		System.out.print("읽은 문자열 : "+sc.next());
		System.out.print("\n===================");
		
		String s2 = "안 녕\n";
		Scanner sc2 = new Scanner(s2);
		
		System.out.print("읽은 문자열 : "+sc2.nextLine());
		
		System.out.print("\n===================");
		
		String s3 = "안 \r    녕\n";
		Scanner sc3 = new Scanner(s3);
		
		System.out.print("읽은 문자열 : "+sc3.nextLine());
		System.out.print(",읽은 문자열 : "+sc3.nextLine());
		
		System.out.print("\n===================");
		/*System.out.println("읽은 정수 : "+sc.nextInt());
		System.out.println("읽은 실수 : "+sc.nextDouble());
		System.out.println("읽은 문자열 : "+sc.next());
		System.out.println("읽은 문자열 : "+sc.nextLine());*/
	}

}
