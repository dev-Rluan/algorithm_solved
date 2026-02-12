import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] points = new int[301];
        int[] dp = new int[301];
        for (int i = 0; i < n; i++) {
            points[i+1] = Integer.parseInt(br.readLine());
        }

        dp[0] = points[0];
        dp[1] = points[1];
        dp[2] = points[1] + points[2];
        for (int i = 0; i <=n; i++) {
            if(i < 3){
                continue;
            }
            dp[i] = Math.max(dp[i-3] + points[i-1], dp[i-2]) + points[i];
        }

        System.out.println(dp[n]);

    }
}
