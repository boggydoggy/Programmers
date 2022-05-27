import java.util.*;

class Solution {
    public int solution(String s) {
        List<Character> conversion = new ArrayList<>(); //String을 하나씩 확인하기 위한 ArrayList
        Set<Character> numbers = new HashSet<Character>(); //숫자들만 뽑기 위한 HashSet
        for(char i = 48; i < 58; i++) {
            numbers.add(i);
        }

        for(int i = 0; i < s.length(); i++) {
            if(numbers.contains(s.charAt(i))) { //해당 인덱스의 문자가 숫자일 경우 빼서 저장
                conversion.add(s.charAt(i));
            }
            else if(s.charAt(i) == 'z') { //영단어일 경우 해당 단어 수만큼 건너뛴 뒤에 변환해서 저장
                i += 3;
                conversion.add('0');
            }
            else if(s.charAt(i) == 'o') {
                i += 2;
                conversion.add('1');
            }
            else if(s.charAt(i) == 't') {
                if(s.charAt(i + 1) == 'w') {
                    i += 2;
                    conversion.add('2');
                }
                else if(s.charAt(i + 1) == 'h') {
                    i += 4;
                    conversion.add('3');
                }
            }
            else if(s.charAt(i) == 'f') {
                if(s.charAt(i + 1) == 'o') {
                    i += 3;
                    conversion.add('4');
                }
                else if(s.charAt(i + 1) == 'i') {
                    i += 3;
                    conversion.add('5');
                }
            }
            else if(s.charAt(i) == 's') {
                if(s.charAt(i + 1) == 'i') {
                    i += 2;
                    conversion.add('6');
                }
                else {
                    i += 4;
                    conversion.add('7');
                }
            }
            else if(s.charAt(i) == 'e') {
                i += 4;
                conversion.add('8');
            }
            else {
                i += 3;
                conversion.add('9');
            }
        }

        String subString = "";
        for(int i = 0; i < conversion.size(); i++) { //숫자로 바꾸기 위해 다시 String으로 합침
            subString += conversion.get(i).toString();
        }


        int answer = 0;
        answer = Integer.parseInt(subString); //숫자로 변환
        return answer;
    }
}