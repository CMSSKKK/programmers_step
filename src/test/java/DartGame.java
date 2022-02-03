import java.util.*;
import java.util.stream.Collectors;

public class DartGame {

    public static void main(String[] args) {

        String test = "1D2S#10S";

        Queue<String> queue = Arrays.stream(test.split("")).collect(Collectors.toCollection(LinkedList::new));
        List<Integer> input = new ArrayList<>();
        while(input.size() != 3) {
            saveScore(input,queue);
        }
        int answer = input.stream().reduce(0,(x,y) ->(x+y));
        System.out.println(answer);
    }

    private static void saveScore(List<Integer> scores, Queue<String> input) {
        String strNumber = input.poll();
        if(strNumber.equals("1")) {
            if(input.peek().equals("0")) {
                strNumber += input.poll();
            }
        }
        int number = Integer.parseInt(strNumber);
        int score = 0;
        while (!input.isEmpty()) {

            if(input.peek().matches("[0-9]")) {
                break;
            }

            if(input.peek().matches("S|D|T")) {
                int exponent = findExponent(input.poll());
                score = (int) Math.pow(number,exponent);
                continue;
            }

            if(input.peek().equals("*")) {
                int option = findOption(input.poll());
                score = plusStarOption(scores,score,option);
                continue;
            }

            if(input.peek().equals("#")) {
                int option = findOption(input.poll());
                score = plusAchaOption(score,option);
                continue;
            }

        }
        scores.add(score);
    }

    private static int findExponent(String bonus) {
        if(bonus.equals("S")) {
            return 1;
        }
        if(bonus.equals("D")) {
            return 2;
        }
        if(bonus.equals("T")) {
            return 3;
        }
        throw new IllegalArgumentException();
    }

    private static int findOption(String option) {
        if(option.equals("#")) {
            return -1;
        }
        if(option.equals("*")) {
            return 2;
        }
        throw new IllegalArgumentException();
    }

    private static int plusStarOption(List<Integer> scores, int score, int option) {
        if(!scores.isEmpty()) {
            scores.set(scores.size()-1,scores.get(scores.size()-1)*option);
        }
        return score*option;
    }

    private static int plusAchaOption(int score, int option) {
        return score*option;
    }

}
