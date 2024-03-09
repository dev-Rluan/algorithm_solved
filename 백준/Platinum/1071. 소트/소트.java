import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[1002];

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < 1001; i++) {
            if(arr[i] != 0){        // 현재 숫자 번호가 있으면
                if(arr[i+1] != 0){  // 현재 숫자 +1 값이 있으면
                    boolean checkNum = false;
                    for(int j=i+2; j<arr.length; j++){ // 현재 숫자 +2 이상의 값이 있는지 확인
                        if(arr[j] != 0){ // 있으면 값출력하고 현재 값 출력
                            for (int k = 0; k < arr[i]; k++) {
                                sb.append(i).append(" ");
                            }
                            sb.append(j).append(" ");

                            arr[i] = 0;
                            arr[j]--;
                            checkNum = true;// 현재 숫자 +2이상의 값이 있으면 체크
                            break;
                        }
                    }
                    if(!checkNum){
                        for (int j = 0; j < arr[i+1]; j++) {
                            sb.append(i+1).append(" ");
                        }
                        for (int j = 0; j < arr[i]; j++) {
                            sb.append(i).append(" ");
                        }
                        arr[i] = 0;
                        arr[i+1] = 0;
                    }
                }else{
                    for (int j = 0; j < arr[i]; j++) {
                        sb.append(i).append(" ");
                    }
                    arr[i] = 0;
                }
            }

        }
        System.out.println(sb);

    }
}
