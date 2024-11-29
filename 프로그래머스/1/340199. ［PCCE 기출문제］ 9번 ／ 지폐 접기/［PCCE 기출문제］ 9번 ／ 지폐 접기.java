class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int largeWallet = Math.max(wallet[0], wallet[1]);
        int smallWallet = Math.min(wallet[0], wallet[1]);
      
        
        while(largeWallet < Math.max(bill[0],bill[1]) ||smallWallet < Math.min(bill[0],bill[1])){
             // bill 긴 변 찾고 반으로 접기
            int largeIndex = bill[0]<bill[1] ? 1 : 0;
            bill[largeIndex] /= 2;

            // 지폐 접고 횟수 증가
            answer++;
            
            
        }
        return answer;
    }
}