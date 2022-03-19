package com.ssafy.codingTest.SK_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class solution_2 {
  public static void main(String[] args) {
    // String[] arr = { "1", "2", "4", "3", "3", "4", "1", "5" };
    // String[] processes = { "read 1 3 1 2", "read 2 6 4 7", "write 4 3 3 5 2",
    // "read 5 2 2 5", "write 6 1 3 3 9",
    // "read 9 1 0 7" };
    String[] arr = { "1", "1", "1", "1", "1", "1", "1" };
    String[] processes = { "write 1 12 1 5 8", "read 2 3 0 2", "read 5 5 1 2",
        "read 7 5 2 5", "write 13 4 0 1 3",
        "write 19 3 3 5 5", "read 30 4 0 6", "read 32 3 1 5" };

    System.out.println(Arrays.toString(solution(arr, processes)));
  }

  public static String[] solution(String[] arr, String[] processes) {
    String[] answer = {};
    ArrayList<String> result = new ArrayList<String>();

    int time = 1;
    // processes[0] = 'read' or 'write'
    // processes[1] = start time
    // processes[2] = end time
    // processes[3] = start index
    // processes[4] = end index

    PriorityQueue<String[]> process = new PriorityQueue<>(new Comparator<String[]>() {
      @Override
      public int compare(String[] o1, String[] o2) {
        if (o1[1].compareTo(o2[1]) == 0) {
          return o2[0].compareTo(o1[0]);
        }
        return o1[1].compareTo(o2[1]);
      }
    });

    PriorityQueue<String[]> waiting = new PriorityQueue<>(new Comparator<String[]>() {
      @Override
      public int compare(String[] o1, String[] o2) {
        if (o2[0].compareTo(o1[0]) == 0) {
          return o1[0].compareTo(o2[0]);
        }
        return o2[0].compareTo(o1[0]);
      }
    });

    for (int i = 0; i < processes.length; ++i) {
      String[] tmp = processes[i].split(" ");
      process.add(tmp);
    }

    String last = "";
    while (!process.isEmpty()) {
      while (!waiting.isEmpty())
        process.add(waiting.poll());
      String[] cur = process.poll();

      String cur_process = cur[0];
      int start = Integer.parseInt(cur[1]);
      int end = Integer.parseInt(cur[2]);
      int startindex = Integer.parseInt(cur[3]);
      int endindex = Integer.parseInt(cur[4]);

      if (cur_process.equals("read")) {
        if (last.equals("")) {
          last = cur_process;
          time = end;

          StringBuilder sb = new StringBuilder();
          for (int i = startindex; i <= endindex; ++i)
            sb.append(arr[i]);

          result.add(sb.toString());
        } else if (last.equals("read")) {
          if (start <= time) {
            StringBuilder sb = new StringBuilder();
            for (int i = startindex; i <= endindex; ++i)
              sb.append(arr[i]);

            result.add(sb.toString());
            time = Math.max(time, start + end - 1);
          } else {
            waiting.add(cur);
            time++;
          }
        } else {
          if (start <= time) {
            StringBuilder sb = new StringBuilder();
            for (int i = startindex; i <= endindex; ++i)
              sb.append(arr[i]);

            result.add(sb.toString());
            time += end - 1;
          } else {
            waiting.add(cur);
            time++;
          }
        }
      } else {
        String value = cur[5];

        if (last.equals("")) {
          last = cur_process;
          time = end;

          for (int i = startindex; i <= endindex; ++i)
            arr[i] = value;

        } else if (last.equals("write")) {
          if (start <= time) {
            for (int i = startindex; i <= endindex; ++i)
              arr[i] = value;
            time += end - 1;
          } else {
            waiting.add(cur);
            time++;
          }
        } else {
          if (start <= time) {
            for (int i = startindex; i <= endindex; ++i)
              arr[i] = value;
            time += end - 1;
          } else {
            waiting.add(cur);
            time++;
          }
        }
      }
    }
    result.add(Integer.toString(time));
    answer = result.toArray(new String[result.size()]);
    return answer;
  }
}
