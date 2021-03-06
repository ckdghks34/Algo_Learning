package com.ssafy.Live._210204.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class St2_StackAPITest {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String input = null;
		String current = "http://www.ssafy.com";

		Stack<String> backward = new Stack<String>();
		Stack<String> forward = new Stack<String>();

		while (true) {
			input = in.readLine();
			if (input.charAt(0) == 'Q')
				break;

			st = new StringTokenizer(input, " ");

			switch (st.nextToken().charAt(0)) {
			case 'V':
				forward.clear();
				backward.push(current);
				current = st.nextToken();
				System.out.println(current);
				break;
			case 'B':
				forward.push(current);
				if (backward.isEmpty())
					System.out.println("Ignored");
				else
					{current = backward.pop();
					System.out.println(current);}
				break;
			case 'F':
				if(forward.isEmpty())
					System.out.println("Ignored");
				else
				{
					backward.push(current);
					current = forward.pop();
					System.out.println(current);
				}
				break;
			}
		}
	}
}
