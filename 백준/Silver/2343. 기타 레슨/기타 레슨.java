import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n개의 강의를
        // m개의 블루레이안에 하나씩 넣기

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        int end = 0;
        int left = 0;
        // 강의별 시간(분) 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            left = Math.max(left, arr[i]);
        }

        // m개의 블루레이에 값을 담아야함
        // 가능한 블루레이의 크기는 arr에서 가장 큰 값 ~ 배열 전체 합까지

        while(left <= end){
            int mid = (left + end) / 2;
            int raySum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if(raySum + arr[i] > mid){
                    cnt++;
                    raySum = 0;
                }
                raySum = raySum + arr[i];
            }
            if(raySum != 0){
                cnt++;
            }
            if(cnt > m){
                left = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(left);


    }
}
