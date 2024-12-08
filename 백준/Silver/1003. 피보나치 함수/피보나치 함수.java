import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   
    static Integer[][] fiboArr = new Integer[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        fiboArr[0][0] = 1;
        fiboArr[0][1] = 0;

        fiboArr[1][0] = 0;
        fiboArr[1][1] = 1;

        fibonacci(40);

        for (int i = 0; i < 41; i++) {
            fibonacci(i);
        }

        for (int i = 0; i < n; i++) {
            int fibo = Integer.parseInt(br.readLine());;
            sb.append(fiboArr[fibo][0]).append(" ").append(fiboArr[fibo][1]).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static Integer[] fibonacci(int n) {
       if(fiboArr[n][0] == null && fiboArr[n][1] == null){
            fiboArr[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            fiboArr[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
       }
       return fiboArr[n];
    }

}
