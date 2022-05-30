import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String leftHand = "*", rightHand = "#";
        List<String> keypad = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"));

        String answer = "";

        for(int i: numbers) {
            switch(i) {
                case 1: //1, 4, 7을 누를 경우
                case 4:
                case 7:
                    answer += "L";
                    leftHand = Integer.toString(i);
                    break;
                case 3: //3, 6, 9를 누를 경우
                case 6:
                case 9:
                    answer += "R";
                    rightHand = Integer.toString(i);
                    break;
                case 2: //2, 5, 8, 0을 누를 경우
                case 5:
                case 8:
                case 0:
                    int temp = keypad.indexOf(leftHand); //왼손의 위치, 오른손의 위치, 숫자의 위치를 찾음
                    int leftRow = temp / 3, leftCol = temp % 3;

                    temp = keypad.indexOf(rightHand);
                    int rightRow = temp / 3, rightCol = temp % 3;

                    temp = keypad.indexOf(Integer.toString(i));
                    int numRow = temp / 3, numCol =  temp % 3;

                    if(Math.abs(leftRow - numRow) + Math.abs(leftCol - numCol) < Math.abs(rightRow - numRow) + Math.abs(rightCol - numCol)) { //행의 차의 절대값과 열의 차의 절대값의 합을 구한 뒤 작은 쪽인 손가락이 이동
                        answer += "L";
                        leftHand = Integer.toString(i);
                    }
                    else if(Math.abs(leftRow - numRow) + Math.abs(leftCol - numCol) > Math.abs(rightRow - numRow) + Math.abs(rightCol - numCol)) {
                        answer += "R";
                        rightHand = Integer.toString(i);
                    }
                    else {
                        if(hand.equals("left")) { //같은 경우 왼손잡이인지 오른손잡이인지에 따라 이동
                            answer += "L";
                            leftHand = Integer.toString(i);
                        }
                        else if(hand.equals("right")) {
                            answer += "R";
                            rightHand = Integer.toString(i);
                        }
                    }
            }
        }

        return answer;
    }
}