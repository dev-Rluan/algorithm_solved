import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());  // n은 랜선의 개수
        long k = Long.parseLong(st.nextToken());  // k는 필요한 랜선의 개수

        long[] lanson = new long[(int)n];  // 각 랜선의 길이 배열

        long maxLen = 0;
        for (int i = 0; i < n; i++) {
            lanson[i] = Long.parseLong(br.readLine());  // 각 랜선의 길이 입력
            if (lanson[i] > maxLen) {
                maxLen = lanson[i];  // 가장 긴 랜선 길이 찾기
            }
        }

        long start = 1;  // 최소 길이
        long end = maxLen;  // 최대 길이는 가장 긴 랜선 길이
        long result = 0;

        // 이진 탐색
        while (start <= end) {
            long mid = (start + end) / 2;
            long cutCnt = 0;

            // mid 길이로 잘랐을 때 만들 수 있는 랜선의 개수를 계산
            for (long len : lanson) {
                cutCnt += len / mid;
            }

            // 랜선의 개수가 k보다 적으면 길이를 줄여야 함
            if (cutCnt >= k) {
                result = mid;  // 가능한 길이 중 최대로 가능한 값 기록
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);  // 가장 긴 랜선 길이 출력
    }
}
