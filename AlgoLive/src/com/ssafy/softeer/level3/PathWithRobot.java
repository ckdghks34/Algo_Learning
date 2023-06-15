package com.ssafy.softeer.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class PathWithRobot {

    static int H, W;
    static int[][] map;

    // 북동남서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // L == -1, A == 0, R == 1 ;
    static HashMap<Integer, Character> direction = new HashMap<>() {
        {
            put(0, '^');
            put(1, '>');
            put(2, 'v');
            put(3, '<');

        }
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        List<Point> list = new ArrayList<>();

        for (int h = 0; h < H; ++h) {
            char[] tmp = new String(br.readLine()).toCharArray();

            for (int w = 0; w < W; ++w) {
                if (tmp[w] == '#') {
                    map[h][w] = 1;
                    list.add(new Point(w, h));

                } else
                    map[h][w] = 0;
            }
        }

        for (Point point : list) {
            boolean flag = false;

            for (int d = 0; d < 4; ++d) {
                String orders = bfs(new Robot(point, d, 0, "", new boolean[H][W]), list.size());

                if (orders != null) {
                    sb.append(point.y).append(" ").append(point.x).append("\n");
                    sb.append(direction.get(d)).append("\n");
                    sb.append(orders);
                    flag = true;
                    break;
                }
            }

            if (flag)
                break;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String bfs(Robot robot, int move) {
        PriorityQueue<Robot> queue = new PriorityQueue<>();

        robot.visited[robot.point.y][robot.point.x] = true;
        robot.moveCount = 1;

        queue.offer(robot);

        while (!queue.isEmpty()) {
            Robot current = queue.poll();

            if (current.moveCount == move)
                return current.order.toString();

            for (int o = -1; o < 2; ++o) {
                switch (o) {
                    case -1:

                        int newDir = current.dir == 0 ? 3 : current.dir - 1;
                        queue.offer(new Robot(current.point, newDir, current.moveCount, current.order + "L", current.visited));
                        break;
                    case 0:
                        boolean movePossible = true;

                        for (int m = 1; m <= 2; ++m) {
                            int nx = current.point.x + dx[current.dir] * m;
                            int ny = current.point.y + dy[current.dir] * m;

                            if ((0 <= nx && nx < W && 0 <= ny && ny < H) && map[ny][nx] == 1) {
                                if (current.visited[ny][nx]) {
                                    movePossible = false;
                                    break;
                                }
                            } else {
                                movePossible = false;
                                break;
                            }
                        }

                        if (movePossible) {
                            boolean[][] tmp = new boolean[H][W];
                            for (int i = 0; i < H; ++i)
                                tmp[i] = Arrays.copyOf(current.visited[i], W);

                            int nextX = 0;
                            int nextY = 0;
                            for (int m = 1; m <= 2; ++m) {
                                nextX = current.point.x + dx[current.dir] * m;
                                nextY = current.point.y + dy[current.dir] * m;

                                tmp[nextY][nextX] = true;
                            }

                            queue.offer(new Robot(new Point(nextY, nextX), current.dir, current.moveCount + 2, current.order + "A", tmp));
                        }

                        break;
                    case 1:
                        int d = current.dir == 3 ? 0 : current.dir + 1;
                        queue.offer(new Robot(current.point, d, current.moveCount, current.order + "R", current.visited));
                        break;
                }

            }
        }
        return null;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Robot implements Comparable<Robot> {
        Point point;

        int dir;

        int moveCount;

        String order;

        boolean[][] visited;

        Robot(Point point, int dir, int moveCount, String order, boolean[][] visited) {
            this.point = point;
            this.dir = dir;
            this.moveCount = moveCount;
            this.order = order;
            this.visited = visited;
        }

        public int compareTo(Robot r) {
            if (r.moveCount == this.moveCount)
                return this.order.length() - r.order.length();
            return r.moveCount - this.moveCount;
        }
    }
}
