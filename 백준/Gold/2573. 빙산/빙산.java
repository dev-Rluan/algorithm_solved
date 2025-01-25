import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, melt;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;

        while (true) {
            int count = countIcebergs(); // 빙산 덩어리 개수 확인

            if (count >= 2) {
                System.out.println(years);
                break;
            } else if (count == 0) {
                System.out.println(0);
                break;
            }

            meltIcebergs(); // 빙산 녹이기
            years++;
        }
    }

    // 빙산 덩어리의 개수를 세는 메서드
    static int countIcebergs() {
        visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    bfs(i, j); // BFS 탐색
                    count++;
                }
            }
        }

        return count;
    }

    // BFS 탐색
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 빙산 녹이기
    static void meltIcebergs() {
        melt = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int seaCount = 0;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                            seaCount++;
                        }
                    }

                    melt[i][j] = seaCount; // 인접한 바다의 수 저장
                }
            }
        }

        // 실제로 녹이기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] -= melt[i][j];
                if (map[i][j] < 0) {
                    map[i][j] = 0; // 빙산 높이는 0 이하가 될 수 없음
                }
            }
        }
    }
}