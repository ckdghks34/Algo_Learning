package com.ssafy.exSoftAcademy._210201;

import java.io.FileInputStream;
import java.util.Scanner;

public class Soultion_d3_1289_원재의메모리복구하기_4_허창환 {

	public static void main(String[] args) throws Exception {
		// TODO 자동 생성된 메소드 스텁
		System.setIn(new FileInputStream("res/ES_input_d3_1289.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] result = new int[T];
		for(int tc = 1; tc <= T ; tc++)
		{
			String s = sc.next();
			int count = 0;
			for(int i = 0 ; i < s.length()-1;++i)
			{
				if(i == 0 && s.charAt(0) == '1') count++;
				if(Character.getNumericValue(s.charAt(i)) != Character.getNumericValue(s.charAt(i+1)))
					count++;
			}
			
			result[tc-1] = count;
		}
		
		
		for(int i = 0 ; i < T; ++i)
		{
			System.out.println("#"+(i+1)+" " +result[i]);
		}
		
		sc.close();
	}

}
