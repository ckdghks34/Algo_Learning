package com.ssafy.Baekjoon._220116;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S5_11723_집합 {
	public static int M;
	public static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		M = Integer.parseInt(br.readLine());

		for (int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			String menu = st.nextToken();
			int data = 0;

			if (!menu.equals("all") && !menu.equals("empty"))
				data = Integer.parseInt(st.nextToken());

			switch (menu) {
			case "add":
				add(data);
				break;
			case "remove":
				remove(data);
				break;
			case "check":
				sb.append(check(data)).append("\n");
				break;
			case "toggle":
				toggle(data);
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void add(int data) {
		int size = list.size();

		for (int i = 0; i < size; ++i) {
			if (list.get(i) == data)
				return;
		}

		list.add(data);
	}

	static void remove(int data) {
		int size = list.size();

		for (int i = 0; i < size; ++i) {
			if (list.get(i) == data) {
				list.remove(i);
				return;
			}
		}
	}

	static int check(int data) {
		int size = list.size();

		for (int i = 0; i < size; ++i) {
			if (list.get(i) == data)
				return 1;
		}

		return 0;
	}

	static void toggle(int data) {
		int size = list.size();

		for (int i = 0; i < size; ++i) {
			if (list.get(i) == data) {
				list.remove(i);
				return;
			}
		}

		list.add(data);
	}

	static void all() {
		list.clear();
		for (int i = 1; i <= 20; ++i)
			list.add(i);
		return;
	}

	static void empty() {
		list.clear();
		return;
	}

}
