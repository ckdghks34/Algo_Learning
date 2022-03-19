package com.ssafy.codingTest.SK_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

class solution_1 {
  public static ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
  public static TreeSet<String> set = new TreeSet<String>();

  public static void main(String[] args) {
    String[] goods = { "pencil", "cilicon", "contrabase", "picturelist" };
    System.out.println(Arrays.toString(solution(goods)));
  }

  public static String[] solution(String[] goods) {
    String[] answer = new String[goods.length];

    for (int i = 0; i < goods.length; ++i) {
      powerset(i, goods[i], new boolean[goods[i].length()], goods[i].length(), 0);
      list.add(new ArrayList<String>(set));

      Collections.sort(list.get(i), new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
          return o1.length() - o2.length();
        }
      });
      set.clear();
    }

    for (int i = 0; i < list.size(); ++i) {
      StringBuilder sb = new StringBuilder();
      int min = goods[i].length();

      for (int j = 0; j < list.get(i).size(); ++j) {
        boolean flag = true;
        for (int k = 0; k < list.size(); ++k) {
          if (k == i)
            continue;
          if (list.get(k).contains(list.get(i).get(j))) {
            flag = false;
            break;
          }
        }
        if (list.get(i).get(j).length() <= min && flag) {
          min = list.get(i).get(j).length();
          sb.append(list.get(i).get(j)).append(" ");
        }
      }

      if (sb.length() > 0)
        sb.setLength(sb.length() - 1);
      else
        sb.append("None");
      answer[i] = sb.toString();
    }

    // }
    return answer;
  }

  public static void powerset(int no, String item, boolean[] checked, int size, int cnt) {
    if (cnt == size) {
      String tmp = "";
      for (int i = 0; i < checked.length; ++i) {
        if (checked[i])
          tmp += item.charAt(i);
        if (!tmp.equals("") && !checked[i])
          break;
      }

      if (tmp != "")
        set.add(tmp);

      return;
    }
    checked[cnt] = true;
    powerset(no, item, checked, size, cnt + 1);

    checked[cnt] = false;
    powerset(no, item, checked, size, cnt + 1);
  }
}