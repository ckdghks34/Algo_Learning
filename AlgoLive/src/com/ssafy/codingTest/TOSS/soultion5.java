package com.ssafy.codingTest.TOSS;

import java.util.LinkedList;
import java.util.Queue;

public class soultion5 {
  public static void main(String[] args) {

  }

  public static boolean[] solution(String[][] grids) {
    boolean[] answer = {};
    for (int i = 0; i < grids.length; ++i) {
      Queue<int[]> queue = new LinkedList<int[]>();
      for (int j = 0; j < grids[i].length; ++j) {
        if (grids[i][j].equals(".")) {
          queue.add(new int[] { i, j });
        }
      }
    }
    return answer;
  }
}
