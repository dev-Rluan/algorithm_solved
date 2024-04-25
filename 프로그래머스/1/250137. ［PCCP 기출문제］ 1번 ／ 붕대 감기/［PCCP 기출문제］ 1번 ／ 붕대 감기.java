class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int healCnt = 0;
        int attackCnt = 0;
        int lastAttack = attacks[attacks.length -1][0];
        for (int i = 0; i < lastAttack; i++) {
            if(attacks[attackCnt][0] == i+1){ // 공격받으면
                if(answer - attacks[attackCnt][1] < 1){
                    answer = -1;
                    break;
                }else{
                    answer -= attacks[attackCnt][1];
                }
                attackCnt++;
                healCnt = 0;
                continue;
            }
            int heal = bandage[1];
            healCnt++;
            if(healCnt == bandage[0]){
                heal += bandage[2];
                healCnt = 0;
            }
            
            if(answer + heal >= health){
                answer = health;
            } else{
                answer += heal;
            }
        }
        return answer;
    }
}