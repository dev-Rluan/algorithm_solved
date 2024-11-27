import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
         if(n==k){
            System.out.println(0);
            return;
        }
        
        // 해당위치 방문여부 확인 및 해당 위치에 도달하기 위한 카운트
        int[] visited = new int[100001];
        // 큐 초기화값
        q.add(n);

        while(!q.isEmpty()){
            int current = q.poll();
            if(current == k){
                System.out.println(visited[current]);
                return;
            }
            
            int[] next = {current - 1, current + 1, current * 2};
            
            for (int pos : next) {
                if(pos >= 0 && pos < 100001 && visited[pos] == 0) {
                    q.offer(pos);
                    visited[pos] =  visited[current]+ 1;
                }
            }
        }

    }

}
