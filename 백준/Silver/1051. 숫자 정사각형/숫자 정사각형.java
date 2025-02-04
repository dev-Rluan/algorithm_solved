import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        int maxCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxCnt = Math.max(maxCnt, sqCheck(i,j));
            }
        }
        System.out.println((maxCnt+1) * (maxCnt+1));

    }
    static int sqCheck(int col, int row){
        int add = 0;
        int maxAdd = Math.min(N-col-1,M-row-1);
        for (int i = maxAdd; i >= 0 ; i--) {
            int a = arr[col][row];
            int b = arr[col + i][row];
            int c = arr[col][row + i];
            int d = arr[col + i][row + i];
            if (a == b && b == c & c == d) {
                return i;
            }
        }

        return 0;

    }
}
