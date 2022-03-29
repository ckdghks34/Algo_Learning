package com.ssafy.codingTest.TOSS;

public class solution2 {
  public static void main(String[] args) {

  }

  public static int solution(int[] a, int[] b, int duration, int distance) {
    int answer = -1;
    Times A = new Times(a[0], a[1]);
    Times B = new Times(b[0], b[1]);

    if (A.end < B.start || B.start > A.end) {
      return answer;
    }

    return answer;
  }
}

class Times {
  int start;
  int end;
  int remaintime;

  public Times(int start, int end) {
    this.start = start;
    this.end = end;
    this.remaintime = start - end;
  }
}
