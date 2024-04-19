import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * boj15711 환상의 짝꿍
 * 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 * 1 초	256 MB	6862	1233	848	16.495%
 *
 * input
 * - 테스트 케이스의 수 : 1 < T < 500
 * - T개줄에 두 사람이 가지고 있는 끈의 길이를 나타내는 정수 A,B가 공백으로 구분되어 주어짐
 * -> (1 <= A,B <= 2*10^12)
 *
 * output
 * -> 내용
 *  - 테스트 케이스마다 한줄씩 두 사람의 끈을 이어 붙이고 그 끈을 다시 길이가 소수인 두개의 끈으로 정확히 나눌수 있다면 YES, NO를 출력
 *  : 시간 1초 -> 1억번 연산
 *  : 테스트 케이스의 수 20억 * 500 -> 일반적인 탐색으로는 불가능
 *  : 소수 이론 1 -> 골드바흐의 추측 2보다 큰 모든 짝수는 두개의 소수의 합으로 표시할수 있음
 *  : 소수 이론 2 -> 에라토스테네스의 체로 소수판별
 *  -> 정리
 *  : 합이 4보다 작으면 소수가안됨
 *  : 짝수는 무조건 가능
 *  : 홀수일경우
 *  -> 짝수인 소수는 2만 존재하기에 합-2의 값이 소수인지 판별하면됨
 *  -> 소수를 구하는 공식은 에라토스테네스의 체를 이용 10억의 제곱근인 200만 * 500 = 1000만이므로 시간 가능
 */

public class Main {
    public static ArrayList<Integer> primeList = new ArrayList<>();
    public static boolean[] prims = null;
    public static int N = 2_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        // 10^12의 제곱수만큼 소수 미리구하기

        prims = ersto(2_000_001);

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long sum = a+b;
            if(sum < 4){
                sb.append("NO").append("\n");
            }else if(sum%2 == 0){
                sb.append("YES").append("\n");
            }else{
                if(isPrime(sum-2, N)){
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);

    }
    public static boolean[] ersto(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        // n의 제곱근까지 나눈다.
        for(int i = 2; i < n; i++) {
            if(prime[i]){// 소수가 아니면
                primeList.add(i);
                for(int j=i*2; j<n; j += i){
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    public static boolean isPrime(long value, int n){
        if(value <= n){
            return prims[(int)value];
        }
        for (int i = 0; i < primeList.size(); i++) {
            if(value % primeList.get(i) == 0){
                return false;
            }
        }
        return true;
    }
}
