import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> reportCount = new HashMap<>();
        HashMap<String, HashSet<String>> reportList = new HashMap<>(); //신고당한 자(key)와 신고자(value)

        for(String id : id_list) {
            reportCount.put(id, 0); //신고한 횟수 초기화
            reportList.put(id, new HashSet<>());
        }
        for(String rp : report) {
            String[] reported = rp.split(" ");
            reportList.get(reported[1]).add(reported[0]); // 신고당한 자에게 누가 신고했는지 추가
        }
        for(String key : reportList.keySet()) {
            HashSet<String> hs = reportList.get(key);
            if(hs.size() >= k) { //제재 기준을 넘겼는지 판단
                for(String rp : hs) {
                    Integer num = reportCount.get(rp); //신고자에게 몇 명이 제재 되었는지 카운트
                    reportCount.put(rp, ++num);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = reportCount.get(id_list[i]);
        }
        return answer;
    }
}