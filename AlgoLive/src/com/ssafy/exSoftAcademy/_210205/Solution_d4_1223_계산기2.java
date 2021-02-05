package com.ssafy.exSoftAcademy._210205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_d4_1223_계산기2 {

	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d4_1223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int tc = 1; tc <= 10; ++tc) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			String s = br.readLine();

			for (int i = 1; i <= N; ++i) {
				int tmp = s.charAt(i-1);
				
				if(tmp == '*')
				{
					stack.push(stack.pop()*(s.charAt(i++)-'0'));
				}
				else if(tmp == '+')
					continue;
				else
				{
					stack.push(tmp-'0');
				}
			}
			while(stack.size() != 0)
				sum += stack.pop();
			
			bw.write("#"+tc+" " + sum+"\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}
