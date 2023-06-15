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
        Robot startRobot = null;
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

        // 시작 지점 찾기
        for (Point p : list) {
            int count = 0;
            int dir = 0;
            for (int d = 0; d < 4; ++d) {
                if (count > 1)
                    break;

                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (0 <= nx && nx < W && 0 <= ny && ny < H) {
                    if (map[ny][nx] == 1) {
                        count++;
                        dir = d;
                    }
                }
            }

            if (count == 1) {
                startRobot = new Robot(p, dir, "");
                break;
            }
        }

        sb.append(startRobot.point.y + 1).append(" ").append(startRobot.point.x + 1).append("\n");
        sb.append(direction.get(startRobot.dir)).append("\n");

        boolean[][] visited = new boolean[H][W];

        sb.append(bfs(startRobot, visited));


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String bfs(Robot robot, boolean[][] visited) {

        PriorityQueue<Robot> queue = new PriorityQueue<>();

        queue.offer(robot);
        visited[robot.point.y][robot.point.x] = true;

        while (!queue.isEmpty()) {
            Robot current = queue.poll();
            char lastChar;
            if(current.order.length() > 1)
                lastChar = current.order.charAt(current.order.length() - 1);
            else
                lastChar = 'A';

            int nx = current.point.x + dx[current.dir];
            int ny = current.point.y + dy[current.dir];
            int nnx = current.point.x + dx[current.dir] * 2;
            int nny = current.point.y + dy[current.dir] * 2;

            if (lastChar == 'L' || lastChar == 'R') {
                visited[ny][nx] = true;
                visited[nny][nnx] = true;

                queue.offer(new Robot(new Point(nnx, nny), current.dir, current.order + "A"));
            } else {
                if ((0 <= nx && nx < W && 0 <= ny && ny < H) && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    visited[nny][nnx] = true;

                    queue.offer(new Robot(new Point(nnx, nny), current.dir, current.order + "A"));
                } else {
                    int nextDir = findDirection(current.point, visited);

                    if (nextDir == -1)
                        return current.order;

                    char nextOrder;
                    if(current.dir == 0 && nextDir == 3)
                        nextOrder = 'L';
                    else if (current.dir < nextDir)
                        nextOrder = 'R';
                    else if (current.dir == 3 && nextDir == 0)
                        nextOrder = 'R';
                    else
                        nextOrder = 'L';
                    queue.offer(new Robot(current.point, nextDir, current.order + nextOrder));
                }
            }
        }
        return null;
    }

    public static int findDirection(Point p, boolean[][] visited) {
        for (int d = 0; d < 4; ++d) {
            int nx = p.x + dx[d];
            int ny = p.y + dy[d];

            if (0 <= nx && nx < W && 0 <= ny && ny < H) {
                if (map[ny][nx] == 1 && !visited[ny][nx])
                    return d;
            }
        }
        return -1;
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

        String order;

        Robot(Point point, int dir, String order) {
            this.point = point;
            this.dir = dir;
            this.order = order;
        }

        public int compareTo(Robot r) {
            return this.order.length() - r.order.length();
        }
    }
}
