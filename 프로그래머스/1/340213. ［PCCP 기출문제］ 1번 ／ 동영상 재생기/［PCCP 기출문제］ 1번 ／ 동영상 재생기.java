import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
class Solution {
        /**
         기능
         1. 10초 전으로 이동(prev)
         - 현재위치에서 10초전으로 이동
         - 현재위치가 10초 미만인 경우 영상의 처음 위치로 이동
         2. 10초 후로 이동(next)
         - 현재 위치에서 10초 후로 이동
         - 동영상의 남은 시간이 10초 미만일 경우 마지막 위치로 이동
         3. 오프닝 건너뛰기(op_start ~ op_end)
         - 현재 재생 위치가 op_start <= pos <= op_end 인 경우 op_end로 이동

         요구사항
         1. 사용자의 입력이 모두 끝난 후 동영상의 위치 반환
         - mm:ss
         */
    private LocalTime getTime(String[] split) {

        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);

        return LocalTime.of(0, min, sec);
    }
    public LocalTime opening(LocalTime op_start, LocalTime op_end, LocalTime pos) {       
        if(!pos.isBefore(op_start) && !pos.isAfter(op_end)){
            return op_end;
        }
        return pos;
    }
    public LocalTime prev(LocalTime pos) {
        int min = pos.getMinute();
        int sec = pos.getSecond();
        if(min == 0 && sec < 10){
            return LocalTime.of(0,0,0);
        }
        return pos.minusSeconds(10);
    }
    public LocalTime next(LocalTime video_len, LocalTime pos) {
        pos = pos.plusSeconds(10);
        if(pos.isAfter(video_len)){
            return video_len;
        }
        return pos;
    }

        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands)  {
       
        HashMap<String, LocalTime> dateHashMap = new HashMap<>();
        dateHashMap.put("default_len", LocalTime.of(0,0,0));
        // 값 초기화
        dateHashMap.put("video_len", getTime(video_len.split(":")));
        dateHashMap.put("pos", getTime(pos.split(":")));
        dateHashMap.put("op_start", getTime(op_start.split(":")));
        dateHashMap.put("op_end", getTime(op_end.split(":")));
            
       dateHashMap.put("pos",opening(dateHashMap.get("op_start"), dateHashMap.get("op_end"), dateHashMap.get("pos")));

        // 커맨드 반복
        for (int i = 0; i < commands.length; i++) {            
            switch(commands[i]){
                case "prev": // 뒤로가기
                    dateHashMap.put("pos",prev(dateHashMap.get("pos")));
                    break;
                case "next": // 앞으로 가기                    
                    dateHashMap.put("pos",next(dateHashMap.get("video_len"), dateHashMap.get("pos")));
                    break;
                default:break;
            }
            // 오프닝 체크
            dateHashMap.put("pos",opening(dateHashMap.get("op_start"), dateHashMap.get("op_end"), dateHashMap.get("pos")));
        }
        
        // 결과 반환
        return dateHashMap.get("pos").format(DateTimeFormatter.ofPattern("mm:ss"));
    }
        
    }