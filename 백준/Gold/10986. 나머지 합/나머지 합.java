import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] cnt = new long[m]; // 나머지 배열

        st = new StringTokenizer(br.readLine());
        // arr ->  누적합
        long answer = 0;
        long hap = 0;
        for (int i = 0; i < n; i++) {
            hap += Long.parseLong(st.nextToken());
            int temp = (int)(hap%m);
            if(temp == 0){
                answer++;
            }
            cnt[temp]++;
        }
        for (int i = 0; i < m; i++) {
            if(cnt[i] > 1){
                // cnt[i] : 구간합을 m으로 나눈값이 i인것들 모음
                // 계산 cnt[i] 중에서 2개를 뽑는 경우의 수
                answer += (cnt[i] * (cnt[i]-1) / 2);
            }
        }


        System.out.println(answer);
    }
}
