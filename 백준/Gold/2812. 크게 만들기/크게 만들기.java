import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // 스택 넣는 기준
            // 1. 배열이 비어 있으면 i번째 수는 바로 집어 넣는다
            // 2. 배열이 비어있지 않고 지울수 있는 횟수가 있으면 삭제하고 넣고 없으면 그냥 추가
            if(!stack.empty()){
                while(!stack.empty() && stack.peek() < chars[i] && k > 0){
                    stack.pop();
                    k--;
                }
            }
            stack.push(chars[i]);
        }
        while(!stack.empty() && k > 0){
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());



    }


}
