import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int confirmCount = 0;
        int zeroCount = 0;
        HashMap<Integer, Integer> rules = new HashMap<>();
        int matchedNumbers = 6;

        for(int i = 1; i <= 6; i++) {
            rules.put(matchedNumbers--, i);
        }
        rules.put(matchedNumbers, 6); //1등부터 6등까지의 조건등록

        for(int i : win_nums) {
            for(int j : lottos) {
                if(i == j) {
                    confirmCount++; //같은 수가 있으면 카운트 상승
                }
            }
        }
        for(int i : lottos) {
            if(i == 0) {
                zeroCount++; //0의 갯수 확인
            }
        }

        int[] answer = new int[2];


        answer[0] = rules.get(confirmCount + zeroCount); //맞은 수와 빈 자리의 수 모두 맞을 경우가 최고 등수
        answer[1] = rules.get(confirmCount); //맞은 수만 최종 결과일 경우가 최저 등수


        return answer;
    }
}