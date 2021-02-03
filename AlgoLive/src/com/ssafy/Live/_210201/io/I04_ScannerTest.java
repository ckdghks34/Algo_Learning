package com.ssafy.Live._210201.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I04_ScannerTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt((in.readLine()));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		for(int i = 0; i< n;++i)
			System.out.println(st.nextToken());
	}

}
