import java.util.Objects;
class Solution {

    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        for (int mat : mats) {
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[i].length; j++) {
                    if(Objects.equals(park[i][j], "-1")){
                        if(squareCheck(i,j,park,mat)){
                            answer = Math.max(answer, mat);
                        }
                    }
                }
            }
        }

        return answer;
    }
    
    public boolean squareCheck(int col, int row, String[][] park, int size){
        int nCol = size+col-1;
        int nRow = size+row-1;
        if(park.length <= nCol || park[col].length <= nRow){
            return false;
        }
        for (int i = col; i <= nCol; i++) {
            for (int j = row; j <= nRow; j++) {
                if(!Objects.equals(park[i][j], "-1")){
                    return false;
                }
            }
        }
        return true;
    }
}