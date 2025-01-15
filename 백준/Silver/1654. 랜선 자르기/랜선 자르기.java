import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] lanson = new long[n];

        long tempMax = 10000000000L;
        long tempMin = 0;

        for (int i = 0; i < n; i++) {
            lanson[i] = Integer.parseInt(br.readLine());
            
        }
        
        long mid = 0;
        while(tempMin < tempMax){
            mid = (tempMax + tempMin)/2;
            long cutCnt =0;
            for (long l : lanson) {
                cutCnt += l/mid;
            }
            if(cutCnt < k){
                tempMax = mid;
            } else{
                tempMin = mid +1;
            }
        }

        System.out.println(tempMin-1); 
    }


}
