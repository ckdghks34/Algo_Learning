package com.ssafy.exSoftAcademy._210315;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_d4_8382_방향전환_4_허창환 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		System.setIn(new FileInputStream("./res/ES_input_d4_8382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[4];
		
		
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			int min = Integer.MAX_VALUE;
			
			boolean verticalMove = true;

			for (int i = 0; i < 4; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= 2; ++i) {
				int x = arr[0];
				int y = arr[1];
				int cnt = 0;
				verticalMove = (i == 1 ? true:false);
				
				while (x != arr[2] || y != arr[3]) {
					if(verticalMove)
					{
						if(y <= arr[3])
							y++;
						else
							y--;
						verticalMove = false;
						cnt++;
					}
					else
					{
						if(x <= arr[2])
							x++;
						else
							x--;
						
						verticalMove = true;
						cnt++;
					}
				}
				min = Math.min(min, cnt);
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			bw.write(sb.toString());
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}
