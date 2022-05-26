import java.util.*;

class Solution {
    public String solution(String new_id) {
        Set<Character> idRules = new HashSet<>();
        idRules.add('-');
        idRules.add('_');
        idRules.add('.');
        for(char i = 97; i < 123; i++) {
            idRules.add(i);
        }
        for(char i = 48; i < 58; i++) {
            idRules.add(i);
        }

        String sub_new_id = new_id.toLowerCase(); //1단계 규칙 적용
        char[] tempString = sub_new_id.toCharArray();
        List<Character> ruleApplied = new ArrayList<>();

        for(char c : tempString) { //2단계 규칙 적용
            if(idRules.contains(c)) {
                ruleApplied.add(c);
            }
        }

        int count = 0;
        for(int i = 0; i < ruleApplied.size(); i++) { //3단계 규칙 적용
            if(ruleApplied.get(i) == '.') {
                if(count < 1) {
                    count++;
                }
                else{
                    i--;
                    ruleApplied.remove(i);
                }
            }
            else {
                if(count >= 1) {
                    count = 0;
                }
            }
        }

        if(ruleApplied.get(0) == '.') { //4단계 규칙 적용
            ruleApplied.remove(0);
        }
        if(ruleApplied.size() > 0 && ruleApplied.get(ruleApplied.size() - 1) == '.') {
            ruleApplied.remove(ruleApplied.size() - 1);
        }

        if(ruleApplied.size() < 1) { //5단계 규칙 적용
            ruleApplied.add('a');
        }

        if(ruleApplied.size() >= 16) { //6단계 규칙 적용
            int num = ruleApplied.size() - 15;
            for(int i = 0; i < num; i++) {
                ruleApplied.remove(ruleApplied.size() - 1);
            }

            if(ruleApplied.get(ruleApplied.size() - 1) == '.') { //6단계에 존재하는 4단계 규칙 적용
                ruleApplied.remove(ruleApplied.size() - 1);
            }
        }

        if(ruleApplied.size() <= 2) { //7단계 규칙 적용
            while(ruleApplied.size() < 3) {
                ruleApplied.add(ruleApplied.get(ruleApplied.size() - 1));
            }
        }

        String answer = "";
        for(int i = 0; i < ruleApplied.size(); i++) {
            answer += ruleApplied.get(i);
        }
        return answer;
    }
}