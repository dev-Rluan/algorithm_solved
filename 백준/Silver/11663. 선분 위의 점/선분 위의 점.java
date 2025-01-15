import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[] dots = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        dots = new int[n];
        for (int i = 0; i < n; i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dots);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startDot = Integer.parseInt(st.nextToken());
            int endDot = Integer.parseInt(st.nextToken());
            int strIdx = searchDotIdx(true, startDot);
            int endIdx = searchDotIdx(false, endDot);
            sb.append(searchDotIdx(false, endDot) - searchDotIdx(true, startDot) + 1).append("\n");
        }
        System.out.println(sb);

    }
    // 가장 작거나 큰 위치 찾는 로직
    public static int searchDotIdx(boolean isStart, int startNum){
        // 앞뒤로 체크 해나가는 방향
        int left = 0;
        int right = dots.length - 1;
        // 시작점 찾기
        if(isStart){
            while(left <= right){
                int mid = (left + right) / 2;
                if(dots[mid] < startNum){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return left;
        }else{ // 끝점 찾기
            while(left<=right){
                int mid = (left + right) / 2;
                if(dots[mid]>startNum){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            return right;
        }
    }
}
