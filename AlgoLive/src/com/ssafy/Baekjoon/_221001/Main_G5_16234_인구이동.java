package com.ssafy.Baekjoon._221001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_16234_인구이동 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    // 상 하 좌 우
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        N = Integer.parseInt(st.nextToken()); // 국가 수
        L = Integer.parseInt(st.nextToken()); // 범위 시작점
        R = Integer.parseInt(st.nextToken()); // 범위 끝점

        map = new int[N][N];
        int result = 0;

        // 입력받기
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N]; // 매 턴 마다 초기화를 시켜줘야 몇 번의 이동이 있는지 알 수 있음.
            boolean valid = false;  // 종료 Flag

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (!visited[i][j]) // 방문하지 않은 국가들 -> 주변 국가와 국경이동 가능한지 확인
                        if (bfs(j, i) > 1) // 반환값이 1인 경우는 bfs를 돌릴 국가, 선택된 국가만 있다는 뜻.
                            valid = true;   // 이동가능
                }
            }
            if (!valid) // 이동이 불가능 하다면 종료
                break;
            result++;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        // Open 된 국가 리스트 저장
        ArrayList<int[]> openedCountry = new ArrayList<>();

        // 맵(나라 인구) 값을 바꿔 줘야하기 때문에 저장해야한다.
        int sum = 0;

        // 시작점 Queue, List에 저장
        queue.offer(new int[]{x, y});
        openedCountry.add(new int[]{x, y});

        // 시작지점 방문처리
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curx = cur[0];
            int cury = cur[1];

            // 현재 좌표의 값(인구 수)를 더한다.
            sum += map[cury][curx];

            for (int d = 0; d < 4; ++d) {
                int nx = curx + dx[d];
                int ny = cury + dy[d];

                // 맵 안에 있을 경우
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    // 방문하지 않았을 경우
                    if (!visited[ny][nx]) {
                        // 인구 차이가 L 이상 R이하 라면
                        if (Math.abs(map[cury][curx] - map[ny][nx]) >= L && Math.abs(map[cury][curx] - map[ny][nx]) <= R) {

                            // queue에 저장
                            queue.offer(new int[]{nx, ny});
                            visited[ny][nx] = true; // 방문처리
                            openedCountry.add(new int[]{nx, ny});    // List 저장
                        }
                    }
                }
            }
        }

        // 국경이 열려있는 국가들의 인구수를 바꿔줌
        for (int i = 0; i < openedCountry.size(); ++i) {
            map[openedCountry.get(i)[1]][openedCountry.get(i)[0]] = sum / openedCountry.size();
        }

        // 국가 개수
        return openedCountry.size();
    }
}
