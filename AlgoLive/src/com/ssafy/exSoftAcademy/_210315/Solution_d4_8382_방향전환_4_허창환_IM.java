package com.ssafy.exSoftAcademy._210315;

import java.io.*;
import java.util.*;

public class Solution_d4_8382_방향전환_4_허창환_IM {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./res/ES_input_d4_8382.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc =1; tc <= T; ++tc)
		{
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int x = Math.abs(x1-x2);
			int y = Math.abs(y1-y2);
			
			if((x+y) % 2 ==0)
				System.out.println(Math.max(x,y)*2);
			else
				System.out.println(Math.max(x, y) *2 -1);
			
			
			System.out.println("#"+tc+" ans");
			
		}
		
		sc.close();
	}

}
