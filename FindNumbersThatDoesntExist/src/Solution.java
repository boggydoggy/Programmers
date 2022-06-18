import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);

        for(int i = 1; i < 10; i++) {
            if(Arrays.binarySearch(numbers ,i) < 0) { //정렬된 배열에서 원하는 값 찾기, 없으면 insertion position (삽입했을 때 정렬이 필요없는 인덱스 * -1 - 1)
                answer += i;
            }
        }
        return answer;
    }
}