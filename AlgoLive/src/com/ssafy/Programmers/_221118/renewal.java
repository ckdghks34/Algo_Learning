package com.ssafy.Programmers._221118;
import java.util.*;

public class renewal {
  public static void main(String[] args) {

    Solution s = new Solution();
    String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
    String[] orders2 = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
    String[] orders3 = { "XYZ", "XWY", "WXA" };
    int[] course = { 2, 3, 4 };
    int[] course2 = { 2, 3, 5 };
    int[] course3 = { 2, 3, 4 };

    String[] result = s.solution(orders, course);
    String[] result2 = s.solution(orders2, course2);
    String[] result3 = s.solution(orders3, course3);

    System.out.println(Arrays.toString(result));
    System.out.println(Arrays.toString(result2));
    System.out.println(Arrays.toString(result3));

  }

  static class Solution {
    HashMap<String, Integer> menuCombi;
    HashMap<Integer, Integer> maxCombi;

    public String[] solution(String[] orders, int[] course) {
      String[] answer = {};
      menuCombi = new HashMap<>();
      maxCombi = new HashMap<>();

      for (int i = 0; i < orders.length; ++i) {
        char[] order = orders[i].toCharArray();
        Arrays.sort(order);
        for (int j = 0; j < course.length; ++j) {
          Combination(order, new String(), 0, course[j]);
        }
      }

      Iterator<Map.Entry<String, Integer>> it = menuCombi.entrySet().iterator();

      while (it.hasNext()) {
        HashMap.Entry<String, Integer> entry = it.next();
        String key = entry.getKey();
        Integer value = entry.getValue();

        if (maxCombi.get(key.length()) != 1 && maxCombi.get(key.length()) == value) {
          answer = Arrays.copyOf(answer, answer.length + 1);
          answer[answer.length - 1] = key;
        }
      }

      Arrays.sort(answer);
      return answer;
    }

    public void Combination(char[] order, String tmp, int cnt, int selectNum) {
      if (selectNum == tmp.length()) {
        int count = 0;
        if (menuCombi.containsKey(tmp)) {
          menuCombi.put(tmp, menuCombi.get(tmp) + 1);
          count = menuCombi.get(tmp);
        } else
          menuCombi.put(tmp, 1);

        if (maxCombi.containsKey(selectNum)) {
          if (maxCombi.get(selectNum) < count)
            maxCombi.put(selectNum, count);
        } else
          maxCombi.put(selectNum, 1);

        return;
      }
      for (int i = cnt; i < order.length; ++i) {
        Combination(order, tmp + order[i], i + 1, selectNum);
      }
    }
  }
}