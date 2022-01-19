import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Crane {

    public static void main(String[] args) {

    }
    int[][] board;
    List<Integer> cranePointer;
    Stack<Integer> dollStack;
    int count;


    Crane(int[][] board) {
        this.board = board;
        cranePointer = new ArrayList<>();
        dollStack = new Stack<>();
        count = 0;
    }

    private void generateCranePoint() {
        int[][] board = this.board;
        for (int i = 0; i < board[0].length; i++) {

            for (int j = 0; j < board.length; i++) {
                int temp = board[j][i];
                if(temp != 0) {
                    cranePointer.add(j);
                    break;
                }
            }
        }
    }

    private void dollCatch(int index) {
        int position = cranePointer.get(index);

        cranePointer.set(index,position+1);
        int target = board[position][index];

        if(dollStack.isEmpty() || dollStack.peek() != target) {
            dollStack.add(target);
            return;
        }

        dollStack.pop();
        count += 2;
        board[position][index] = 0;
    }
}
