import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] bingSan;
    static int[][] visit;
    static int[] dCol = {1,0,-1,0};
    static int[] dRow = {0,-1,0,1};
    static int N;
    static int M;
    static int[][] delArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bingSan = new int[N][M];
        delArr = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                bingSan[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = -1; // visit 초기화
            }
        }
        int years = 0;
        while (true) {
            int count = checkLandCnt(years); // 빙산 덩어리 개수 확인

            if (count >= 2) {
                System.out.println(years);
                break;
            } else if (count == 0) {
                System.out.println(0);
                break;
            }

            meltBingSan(); // 빙산 녹이기
            years++;

        }
    }
    static void meltBingSan(){
        // 완탐으로 빙산 지울 카운트 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(bingSan[i][j] != 0){
                    delArr[i][j] = checkDelBingSanCnt(i,j);
                }
            }
        }
        // 완탐으로 빙산 지우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bingSan[i][j] = bingSan[i][j] - delArr[i][j] <= 0 ? 0 : bingSan[i][j] - delArr[i][j];
            }
        }
    }

    // 빙산 줄이는 함수
    static int checkDelBingSanCnt(int cols, int rows){

        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nCol = cols + dCol[i];
            int nRow = rows + dRow[i];
            if(isInBounds(nCol, nRow) && bingSan[nCol][nRow] == 0){
                cnt++;
            }
        }
        return cnt;
    }

    // 카운트 체크 함수
    static int checkLandCnt(int year){

        int cnt = 0;
        for (int i = 0; i < bingSan.length; i++) {
            for (int j = 0; j < bingSan[0].length; j++) {
               if(visit[i][j] != year && bingSan[i][j] != 0){
                    cnt++;
                    bfs(i, j, year);
               }
            }
        }
        return cnt;
    }
    // 빙산 탐색 함수
    static void bfs(int cols, int rows, int year){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cols, rows});
        visit[cols][rows] = year;

        while(!queue.isEmpty()){
            int[] currentBingSan = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nCol = currentBingSan[0] + dCol[i];
                int nRow = currentBingSan[1] + dRow[i];
                if(isInBounds(nCol, nRow)){
                    if(visit[nCol][nRow] != year && bingSan[nCol][nRow] != 0){
                        visit[nCol][nRow] = year;
                        queue.add(new int[]{nCol, nRow});
                    }
                }
            }
        }
    }
    // 범위 확인 함수
    static boolean isInBounds(int col, int row) {
        return col >= 0 && col < N && row >= 0 && row < M;
    }


}
