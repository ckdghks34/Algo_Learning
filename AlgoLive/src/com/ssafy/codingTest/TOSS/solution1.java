package com.ssafy.codingTest.TOSS;

public class solution1 {
  public static void main(String[] args) {
    int k = 3;
    int m = 50000;
    String[] names = { "msLEE", "jsKim", "jsKIM", "jskiM", "jskim", "John",
        "john", "John", "msLEE", "msLEE", "jsKIM",
        "roy" };
    int[] amounts = { 950, 52524, 1400, 6055, 10000, 4512, 512, 52000, 9000,
        49000, 1400, 50000 };

    // int k = 2;
    // int m = 3451;
    // String[] names = { "abcd", "aBCd", "jsKIM", "rrr", "rrr" };
    // int[] amounts = { 950, 1000, 1400, 4000, 10000 };

    System.out.println(solution(k, m, names, amounts));
  }

  public static int solution(int k, int m, String[] names, int[] amounts) {
    int answer = 0;
    String[] tmp = new String[names.length];
    int size = names.length;
    for (int i = 0; i < size; ++i) {
      tmp[i] = names[i].toLowerCase();
    }

    String lastName = "";
    int lastCount = 0;
    for (int i = 0; i < size; ++i) {
      boolean flag = false;

      if (lastName.equals(tmp[i])) {
        lastCount++;

        if (lastCount >= k) {
          flag = true;
        }

        if (!flag && amounts[i] >= m) {
          flag = true;
        }
      } else {
        lastName = tmp[i];
        lastCount = 1;

        if (amounts[i] >= m) {
          flag = true;
        }
      }

      if (flag) {
        answer++;
      }
    }

    return answer;
  }
}
