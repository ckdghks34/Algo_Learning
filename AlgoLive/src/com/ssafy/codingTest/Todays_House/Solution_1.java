package com.ssafy.codingTest.Todays_House;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1 {
	
	public static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		String path = "EEESEEEEEENNNN";
//		String path = "SSSSSSWWWNNNNNN";
		System.out.print(Arrays.toString(solution(path)));

	}

	public static String[] solution(String path) {
		String[] answer = {};

		Queue<Character> queue = new LinkedList<>();
		int time = 0;
		for (int i = 0; i < path.length(); ++i) {
			if (queue.isEmpty()) {
				queue.add(path.charAt(i));
				continue;
			}

			if (queue.peek() == path.charAt(i)) {
				queue.add(path.charAt(i));
			} else {
				if (queue.size() < 5) {
					addMessage(time, queue.size(), queue.peek(), path.charAt(i));
				}
				else
				{
					addMessage(time + queue.size()- 5, 5, queue.peek(), path.charAt(i));
				}
				time += queue.size();
				queue.clear();
				queue.add(path.charAt(i));
			}
		}
		answer = list.toArray(new String[list.size()]);
		return answer;
	}

	public static void addMessage(int time, int dis, char cur, char next) {
		StringBuilder sb = new StringBuilder();
		sb.append("Time ").append(time).append(": ").append("Go straight ").append(dis * 100).append("m ")
				.append("and ").append(direction(cur, next));
		list.add(sb.toString());
	}

	public static String direction(char cur, char next) {
		String dir = "";
		switch (cur) {
		case 'E':
			if (next == 'N')
				dir = "turn left";
			else if (next == 'S')
				dir = "turn right";
			break;
		case 'S':
			if (next == 'E')
				dir = "turn left";
			else if (next == 'W')
				dir = "turn right";
			break;
		case 'W':
			if (next == 'S')
				dir = "turn left";
			else if (next == 'N')
				dir = "turn right";
			break;
		case 'N':
			if (next == 'W')
				dir = "turn left";
			else if (next == 'E')
				dir = "turn right";
			break;
		}
		return dir;
	}
}
