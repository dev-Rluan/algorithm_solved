import java.util.HashMap;
class Solution {
     public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        /* 선물 받는 경우의 수
        * 1. 다른사람하고 조회했을때 준게 더 많았을때
        * - 둘이 비교하면 됨
        * 2. 다른사람하고 조회했을때 같으면 선물지수 비교
        * - 선물지수 갖고있어야함
        *
        * 결론 : 선물지수,누구한테 몇개 줬는지 조회하는 함수 필요
        * */
        // 선물지수
        HashMap<String, Integer> giftScore = new HashMap<>();

        // 주고받은 선물
        HashMap<String, Integer> giftExcMap = new HashMap<>();

        HashMap<String, Integer> giftCntMap = new HashMap<>();

        for (String friend : friends) {
            giftCntMap.put(friend,0);
        }

        for (String gift : gifts) {
            String[] s = gift.split(" ");
            giftScore.put(s[0], giftScore.getOrDefault(s[0],0)+1);
            giftScore.put(s[1], giftScore.getOrDefault(s[1],0)-1);
            giftExcMap.put(gift, giftExcMap.getOrDefault(gift, 0)+1);
        }
        /* 현재 사용자가 받는 선물의 수
        * 1. 다른사용자들과 비교했을때
        * 2.
        *  */
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if(i== j){
                    continue;
                }
                // 주고받은 갯수 비교
                int num1 = giftExcMap.getOrDefault(friends[i] + " " + friends[j],0);
                int num2 = giftExcMap.getOrDefault(friends[j] + " " + friends[i],0);

                if(num1 > num2){
                    giftCntMap.put(friends[i], giftCntMap.getOrDefault(friends[i],0)+1);
                }else if(num1 == num2){
                    if(giftScore.getOrDefault(friends[i],0) > giftScore.getOrDefault(friends[j],0)){
                        giftCntMap.put(friends[i], giftCntMap.getOrDefault(friends[i],0)+1);
                    }
                }
            }
        }
        for (Integer value : giftCntMap.values()) {
            if(answer < value){
                answer = value;
            }
        }


        return answer;
    }
}