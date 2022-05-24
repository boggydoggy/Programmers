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
        rules.put(matchedNumbers, 6);
        for(int i : win_nums) {
            for(int j : lottos) {
                if(i == j) {
                    confirmCount++;
                }
            }
        }
        for(int i : lottos) {
            if(i == 0) {
                zeroCount++;
            }
        }

        int[] answer = new int[2];

        if(confirmCount == 6) {
            answer[0] = 1;
            answer[1] = 1;
        }
        else {
            answer[0] = rules.get(confirmCount + zeroCount);
            answer[1] = rules.get(confirmCount);
        }

        return answer;
    }
}