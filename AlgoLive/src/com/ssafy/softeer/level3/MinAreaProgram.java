package com.ssafy.softeer.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 10점.. 어떻게 푸는걸까.. 아이고 두야 ㅠㅠ
public class MinAreaProgram {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<List<Point>> list = new ArrayList<>();

        for (int i = 0; i < K; ++i)
            list.add(new ArrayList<>());

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.get(value - 1).add(new Point(x, y, value));
        }

        int result = findMinArea(list, N, K);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();


    }

    public static int findMinArea(List<List<Point>> list, int N, int K) {
        int minArea = Integer.MAX_VALUE / 2;
        for (int i = 0; i < K; ++i) {
            for (int j = 0; j < list.get(i).size(); ++j) {
                Point current = list.get(i).get(j);

                for (int h = 0; h < K; ++h) {
                    for (int k = 0; k < list.get(h).size(); ++k) {
                        if (h != k) {
                            Point next = list.get(h).get(k);

                            if (checkFullColor(current, next, N, K, list)) {
//                                int width = Math.abs(current.x) + Math.abs(next.x);
//                                int height = Math.abs(current.y) + Math.abs(next.y);
                                int width = current.x > next.x ? current.x - next.x : next.x - current.x;
                                int height = current.y > next.y ? current.y - next.y : next.y - current.y;

                                minArea = Math.min(minArea, width * height);
                            }
                        }
                    }
                }
            }
        }
        return minArea;
    }

    public static boolean checkFullColor(Point first, Point second, int N, int K, List<List<Point>> list) {
        Set<Integer> idxList = new HashSet<>();
        idxList.add(first.value);
        idxList.add(second.value);

        int i = 0;
        while (i < K) {
            if (idxList.contains(i+1)) {
                i++;
                continue;
            }
            for (int j = 0; j < list.get(i).size(); ++j) {
                Point cur = list.get(i).get(j);
                if (idxList.contains(cur.value))
                    continue;
                if (first.x < second.x) {
                    if (first.y < second.y) {
                        if (first.x <= cur.x && cur.x <= second.x && first.y <= cur.y && cur.y <= second.y) {
                            idxList.add(cur.value);
                            break;
                        }
                    } else {
                        if (first.x <= cur.x && cur.x <= second.x && second.y <= cur.y && cur.y <= first.y) {
                            idxList.add(cur.value);
                            break;
                        }
                    }
                } else {
                    if (first.y < second.y) {
                        if (second.x <= cur.x && cur.x <= first.x && first.y <= cur.y && cur.y <= second.y) {
                            idxList.add(cur.value);
                            break;
                        }
                    } else {
                        if (second.x <= cur.x && cur.x <= first.x && second.y <= cur.y && cur.y <= first.y) {
                            idxList.add(cur.value);
                            break;
                        }
                    }
                }
            }
            ++i;
        }
        return idxList.size() == K;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int value;

        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Point p) {
            if (this.x == p.x)
                return this.y - p.y;
            return this.x - p.x;
        }
    }
}
