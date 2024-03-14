import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = null;

    static Queue<Tomato> queue= new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(num == 1){
                    queue.offer(new Tomato(j, i));
                }
            }
        }
        int answer = -1;
        while(!queue.isEmpty()){
            Tomato t = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int tempX = t.x + dx[i];
                int tempY = t.y + dy[i];
                if(tempX >= 0 && tempX < m && tempY >=0 && tempY < n){
                    if(arr[tempY][tempX] == 0){
                        arr[tempY][tempX] = arr[t.y][t.x] + 1;
                        queue.add(new Tomato(tempX,tempY));
                    }
                }
            }
        }
        if(checkTomato()){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] > answer){
                        answer = arr[i][j];
                    }
                }
            }
            answer--;
        }
        System.out.println(answer);
    }

    static class Tomato{
        private int x;
        private int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }


    }

    // tomato 다 익었는지 확인 함수
    public static boolean checkTomato(){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
