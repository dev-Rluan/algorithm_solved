import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * x가 1보다 큰 제곱수로 나누어떨어지지 않을때 그 수를 제곱ㄴㄴ수라고 한다.
 * 제곱수는 정수의 제곱이다.
 * min과 max가 주어지면, min보다 크거나 같고, max보다 작거나 같은 제곱ㄴㄴ수가 몇 개 있는지 출력한다.
 *
 * input
 * 1 <= min <= 1_000_000_000_000
 * -> int형 정수보다 큼 long
 * min <= max <= min + 1_000_000
 *
 * think
 * -> 결국 최대 100만개의 수를 검증해야함
 * 시간제한이 2초니까 1회당 200번의 연산밖에 기회가 없음
 * 미리 min ~ min + 100만의 제곱수를 미리 연산해놓는다면 빠를것 하지만 숫자가 커서 for문으로 넣기는 불가능
 * 1조의 제곱수는 100만
 * 100만까지의 수를 에라토스테네스의 체로 배열 만들고 그걸로 검증하면 됨
 */
public class Main {

    public static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        long area = max-min+1;
        check = new boolean[(int) area];


        for (long i = 2; i*i <= max; i++) {
            long checkNum = min/(i*i);
            if(checkNum * i * i < min){ // 최소 제곱수를 구했는데 (min/제곱수) * 제곱수 의 값이 min보다 작을때는 다음값 부터 계산
                checkNum++;
            }
            for (long j = checkNum; i*i*j <= max; j++) { // 제곱수 * j가 최대값에 도달하기 전까지 반복
                check[(int)(i*i*j - min)] = true; // 제곱수 * j의 값에 boolean 처리
            }
        }
        int answer = 0;
        for (boolean b : check) {
            if(!b){
                answer++;
            }
        }
        System.out.println(answer);

    }


}
