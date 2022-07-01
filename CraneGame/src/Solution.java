import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Integer> bascket = new ArrayList<>();
        int answer = 0;


        for(int i = 0; i < moves.length; i++) { //크레인 움직임
            int check = 0;
            int layer = 0;

            while(check == 0) { //인형이 잡힐 때까지 내려감
                if(board[layer][moves[i] - 1] != 0) {  //인형이 잡히면 해당 칸을 빈칸으로 하고 인형을 저장
                    check = board[layer][moves[i] - 1];
                    board[layer][moves[i] - 1] = 0;
                }
                else {
                    if(layer < board.length - 1) { //크레인이 격자를 넘지 않게 한계 지정
                        layer++;
                    }
                    else {
                        break;
                    }
                }
            }

            if(check != 0) { //크레인이 격자 바닥에 닿지 않고 인형을 잡았을 경우 바구니에 넣음
                bascket.add(check);
            }
            int lastIndex = bascket.size() - 1;
            if(lastIndex > 0 && bascket.get(lastIndex) == bascket.get(lastIndex - 1)) { //바구니에 인형이 2개 이상이고 같은 모양의 인형 두 개가 연속해서 쌓일 경우, 그 인형을 없애고 사라진 인형 개수 증가
                bascket.remove(lastIndex);
                bascket.remove(bascket.size() - 1);
                answer += 2;
            }
        }

        return answer;
    }
}