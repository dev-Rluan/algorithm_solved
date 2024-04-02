import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int answer = 1;
        int sum = 1;
        while(end != n){
            if(sum == n){
                answer++;
                end++;
                sum += end;
            }else if(sum > n){
                sum -= start;
                start++;
            }else{
                end++;
                sum += end;
            }
        }
        System.out.println(answer);

    }
}
