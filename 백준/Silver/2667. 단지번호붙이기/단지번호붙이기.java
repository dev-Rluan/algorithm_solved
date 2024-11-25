import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    //  상, 하, 좌, 우
    static int [] dCol = {0, 0, -1, 1};
    static int [] dRow = {1, -1, 0, 0};
    static int n;
    static int[][] arr;
    static List<Integer> resultList = new ArrayList<>();
    static int cnt = 0;
    static int resultCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i <n ; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = -Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] != 0 && arr[i][j] == -1){
                    resultCnt = 0;
                    dfs(i, j, ++cnt);
                    resultList.add(resultCnt);
                }
            }
        }
        Collections.sort(resultList);
        StringBuilder sb = new StringBuilder();
        sb.append(resultList.size()).append("\n");
        for (Integer i : resultList) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);

    }
    public static void dfs(int col, int row, int cnt){
        arr[col][row] = cnt;
        resultCnt++;
        if(arr[col][row] == 0){
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nCol = col + dCol[i];
            int nRow = row + dRow[i];
            if(nCol >= 0 && nCol < n && nRow >= 0 && nRow < n){
                if(arr[nCol][nRow] != 0 && arr[nCol][nRow] == -1){
                    dfs(nCol, nRow, cnt);
                }
            }
        }
    }

}
