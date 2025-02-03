import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visit;
    static ArrayList<Integer>[] arr;
    static int max = 0;
    static HashMap<Integer, Integer> map;
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        check = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b].add(a);
        }
        for (int i = 1; i < N+1; i++) {
            visit = new boolean[N+1];
            bfs(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            if(check[i] == max){
                sb.append(i + " ");
            }
        }
        System.out.println(sb);

    }
    static void bfs(int x){
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.add(arr[x]);
        visit[x] = true;
        while (!q.isEmpty()) {
            ArrayList<Integer> temp = q.poll();
            for (int i = 0; i < temp.size(); i++) {
                if(!visit[temp.get(i)]){
                    check[x]++;
                    visit[temp.get(i)] = true; 
                    q.add(arr[temp.get(i)]);
                }
            }
        }
        max = Math.max(max,check[x]);
    }
}
