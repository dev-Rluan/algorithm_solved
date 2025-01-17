import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n개의 강의, m개의 블루레이
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int maxLecture = 0, totalSum = 0;

        // 강의 시간을 입력받음
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum += arr[i];
            maxLecture = Math.max(maxLecture, arr[i]);
        }

        // 이분 탐색: 블루레이 크기 탐색
        int left = maxLecture, right = totalSum;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(arr, n, m, mid)) {
                right = mid - 1; // 더 작은 크기를 시도
            } else {
                left = mid + 1; // 더 큰 크기를 시도
            }
        }

        System.out.println(left);
    }

    // 블루레이 크기 `size`로 가능한지 확인
    private static boolean isPossible(int[] arr, int n, int m, int size) {
        int count = 1, currentSum = 0;
        for (int time : arr) {
            if (currentSum + time > size) {
                count++;
                currentSum = 0;
            }
            currentSum += time;
        }
        return count <= m;
    }
}
