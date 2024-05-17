import java.util.*;
class Solution {
    public int solution(int[][] land) {
        
        int rows = land.length;
        int cols = land[0].length;

        int[] moveRow = {-1, 0, 1, 0};
        int[] moveCol = {0, 1, 0, -1};

        int cnt[] = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(land[i][j] == 0) continue;
                Set<Integer> set = new HashSet<>();
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                int size = 1;
                land[i][j] =0;
                set.add(j);
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];

                    for (int k = 0; k < 4; k++) {
                        int nr = cr + moveRow[k];
                        int nc = cc + moveCol[k];
                        if(nr<0||nr>=rows||nc<0||nc>=cols||land[nr][nc]==0){
                            continue;
                        }
                        size++;
                        land[nr][nc] = 0;
                        set.add(nc);
                        q.add(new int[]{nr, nc});
                    }
                }
                for (int integer : set) {
                    cnt[integer] += size;
                }
            }
        }
        return Arrays.stream(cnt).max().getAsInt();
    }
}