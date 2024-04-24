// 최종 목표
// 주어진 간선 정보로
//-> 생성한 정점의 번호
//-> 정점을 생성하기 전 도넛모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수를 구해야한다.
// 헷갈리는점
// 정점을 생성하기 전? 이라는 것은? 여러 모양의 그래프는 마지막에 찍은 하나의 정점에서 나간다. 다른 그래프의 정점에 연결됨 
// 그렇다면
// -> 정점은 들어오는 선이 없음 
// -> 정점에서 나가는 선은 그래프 시작점
// -> 그래프 모양에따라 카운트 세주면 될듯?
// 도넛 모양 그래프 
// n개의 정점과 n개의 간선이 있음
// 도넛모양 식 (인입간선 2개 아웃 > 0)
// 마지막에서 다시 돌아와야함 
// 막대모양 식 (인입간선 1개 아웃 > 1)
// 한번만 인입있고 그 이후는 없음 마지막까지 추가하면됨
// 8자 모양은 (인입간선 3개 아웃 2)
import java.util.HashMap;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
            HashMap<Integer, Integer> outMap = new HashMap<>();
            HashMap<Integer, Integer> inMap = new HashMap<>();

            for (int[] edge : edges) {
                outMap.put(edge[0], outMap.getOrDefault(edge[0],0) + 1);
                inMap.put(edge[1], inMap.getOrDefault(edge[0],0) + 1);
            }
            // 정점 out에 있고 in이 없는것들
            for (Integer i : outMap.keySet()) {
                // 나가는 간선의 수가 2보다 크고 들어오는 정점이 없으면 정점
                if(outMap.get(i) > 1){
                    if(!inMap.containsKey(i)) {
                        answer[0] = i;
                    } else {
                        answer[3] +=1;
                    }
                }
            }
            for (Integer i : inMap.keySet()) {
                // 받은것만있고 나가는것 없으면 막대
                if(!outMap.containsKey(i)){
                    answer[2] += 1;
                }
            }
            // 정점에서 나간것에서 8자와 막대 빼면 도넛
            answer[1] = outMap.get(answer[0]) - answer[2] - answer[3];

            return answer;
    }
}