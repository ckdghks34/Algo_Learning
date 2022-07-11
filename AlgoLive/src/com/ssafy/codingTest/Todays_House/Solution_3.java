package com.ssafy.codingTest.Todays_House;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3 {

	public static HashMap<String, String> variable = new HashMap<>();

	public static void main(String[] args) {
		String tstring = "this is {template} {template} is {state}";
//		String[][] variables = { { "template", "string" }, { "state", "{template}" } };
		String[][] variables = { { "template", "{state}" }, { "state", "{templates}" } };
//		String[][] variables = { { "template", "{state}" }, { "state", "{template}" } };

		System.out.println(solution(tstring, variables));
	}

	public static String solution(String tstring, String[][] variables) {
		String answer = "";
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < variables.length; ++i) {
			variable.put(variables[i][0], variables[i][1]);
		}

		StringTokenizer st = new StringTokenizer(tstring, " ");
		
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (s.charAt(0) != '{')
				sb.append(s).append(" ");
			else {
				HashMap<String, Boolean> visited = new HashMap<>();

				for (int i = 0; i < variables.length; ++i)
					visited.put(variables[i][0], false);

				String tmp = s.substring(1, s.length() - 1);
				sb.append(transpose(tmp, visited)).append(" ");

			}
		}
		sb.setLength(sb.length() - 1);
		answer = sb.toString();
		return answer;
	}

	public static String transpose(String s, HashMap<String, Boolean> visited) {

		StringBuilder sb = new StringBuilder();
		Queue<String> queue = new LinkedList<String>();
		queue.add(s);

		while (!queue.isEmpty()) {
			String cur = queue.poll();

			if (variable.containsKey(cur)) {
				if(!visited.get(cur))
				{
					if(variable.get(cur).charAt(0) == '{')
					{
						visited.replace(cur, true);
						String tmp = variable.get(cur).substring(1,variable.get(cur).length()-1);
						queue.add(tmp);
					}
					else
					{
						return variable.get(cur);
					}
				}
			} else {
				sb.append("{").append(cur).append("}");
			}
		}
		if(sb.length() == 0)
			sb.append("{").append(s).append("}");
		return sb.toString();
		
	}
//	public static boolean checkvisited(HashMap<String, Boolean> visited) {
//		Iterator<String> iter = visited.keySet().iterator();
//		
//		while(iter.hasNext())
//		{
//			if (!visited.get(iter.next()))
//				return false;
//		}
//		
//		return true;
//	}
}
