import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i = 1; i <= s.length() / 2; i++) { //i: 압축할 문자열 단위
            int zipLevel = 1; //압축된 문자열 개수
            String zipString = s.substring(0, i);
            StringBuilder result = new StringBuilder();

            for(int j = i; j <= s.length(); j += i) {
                //다음 문자열, substring의 out of index 방지
                String nextString = s.substring(j, Math.min(i + j, s.length()));

                //단위만큼 잘라낸 문자열이 다음 문자열과 같을 경우
                if(zipString.equals(nextString)) {
                    zipLevel++;
                }
                else {
                    //압축 결과에 개수와 함께 압축된 문자열 저장
                    result.append(zipLevel != 1 ? zipLevel : "").append(zipString);
                    //다음 문자열을 압축할 문자열로 지정
                    zipString = nextString;
                    zipLevel = 1;
                }
            }

            //압축되지 않은 문자열 저장
            result.append(zipString);
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}