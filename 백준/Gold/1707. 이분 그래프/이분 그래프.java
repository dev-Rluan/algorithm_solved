import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] colors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            colors = new int[V +1];
            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            boolean isBipartite = true;
            for (int j = 1; j <= V; j++) {
                if(colors[j] == 0){
                    if(!bfs(j)){
                        isBipartite = false;
                        break;
                    }
                }
            }
            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        colors[start] = 1;
        q.add(start);

        while(!q.isEmpty()){
            int current = q.poll();
            for (int n : graph[current]) {
               if(colors[n] == 0){
                   colors[n] = -colors[current];
                   q.add(n);
               }else if (colors[n] == colors[current]){
                   return false;
               }
            }
        }
        return true;
    }
}
