import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Employee> list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Employee(a,b));
            }

            Collections.sort(list);
            int cnt = 1;
            int minInterview = list.get(0).interview;
            for (int j = 1; j < N; j++) {
                if(list.get(j).interview < minInterview){
                    cnt++;
                    minInterview = list.get(j).interview;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static class Employee implements Comparable<Employee> {
        int paper;
        int interview;

        Employee(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }

        @Override
        public int compareTo(Employee o) {
            // 서류 순위를 기준으로 오름차순 정렬
            return this.paper - o.paper;
        }
    }
}
