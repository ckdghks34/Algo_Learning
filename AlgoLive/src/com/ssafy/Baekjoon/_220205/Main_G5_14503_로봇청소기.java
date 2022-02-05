package com.ssafy.Baekjoon._220205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_G5_14503_로봇청소기 {
    public static int N, M;
    public static int r, c, d;
    public static int count;
    public static int[][] map;
    // 북동남서
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N,M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 할당
        map = new int[N][M];

        // r,c,d 입력
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 맵 입력
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처음 시작하는 자리 청소해야하기 때문에 1부터 시작
        count = 1;

        // 청소 시작
        cleaner(c, r, d);

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void cleaner(int x, int y, int dir) {
        // 현재 자리 청소
        map[y][x] = 2;
        int nd = dir;

        for (int i = 0; i < 4; ++i) {
            // 현재 바라보고 방향 기준 왼쪽 방향
            nd = nd - 1 >= 0 ? nd - 1 : 3;

            int nx = x + dx[nd];
            int ny = y + dy[nd];

            // 첫번째 열,행 마지막 열,행 은 무조건 벽이므로 없다고 생각
            if (nx > 0 && ny > 0 && nx < M - 1 && ny < N - 1) {
                // 청소해야하는 구역이라면
                if (map[ny][nx] == 0) {
                    // 청소한 구역 갯수 ++
                    // DFS() 호출 시 count++ 를 하지않고 부르기 전에 하는 이유 :
                    // 후진을 하기 때문에 이미 청소한 자리에 갈 수 있기 때문에, 호출이된다고 Count를 하면 안됨.
                    count++;

                    cleaner(nx, ny, nd);
                    return;
                }
            }
        }

        // 현재 바라보는 방향 기준 뒷방향
        int backd = (nd + 2) % 4;
        int backx = x + dx[backd];
        int backy = y + dy[backd];

        if (backx > 0 && backy > 0 && backx < M - 1 && backy < N - 1) {
            if (map[backy][backx] != 1)
                // 방향을 유지해야하기 때문에 backd 를 보내는 것이 아니라 현재 바라보고있는 방향 nd 값을 전달해야함
                // backd 를 보낼경우 무한루프에 빠져 StackOverFlow 발생
                cleaner(backx, backy, nd);
        }
    }
}
