class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int multi = 0;

        for(int i = 0; i < a.length; i++) {
            multi = a[i] * b[i];
            answer += multi;
        }

        return answer;
    }
}