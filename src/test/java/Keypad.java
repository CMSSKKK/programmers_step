public class Keypad {


    public static int[][] keypad = new int[][]{ {1,2,3}, {4,5,6}, {7,8,9}, {-1,0,-1}};

    public String solution(int[] numbers, String hand) {
        String answer = new User(hand).memorize(numbers);
        return answer;
    }

    public static class User {

        StringBuilder stringBuilder;
        String majorHand;
        int[] leftPosition;
        int[] rightPosition;

        User(String majorHand) {
            stringBuilder = new StringBuilder();
            this.majorHand = majorHand;
            leftPosition = new int[]{3, 0};
            rightPosition = new int[]{3, 2};
        }

        String memorize(int[] numbers) {
            for (int number : numbers) {
                stringBuilder.append(findPosition(number));
            }
            return stringBuilder.toString();
        }

        // 열이 0이면 1,4,7
        boolean isLeftHand(int col) {
            return col == 0;
        }
        // 열이 2이면 3,6,9
        boolean isRightHand(int col) {
            return col == 2;
        }

        String moveLeftHand(int row, int col) {
            leftPosition[0] = row;
            leftPosition[1] = col;
            return "L";
        }

        String moveRightHand(int row, int col) {
            rightPosition[0] = row;
            rightPosition[1] = col;
            return "R";
        }

        String findPosition(int number) {
            int row = 0;
            int col = 0;
            for (int i = 0; i < keypad.length; i++) {
                int length = keypad[i].length;
                for (int j = 0; j < length ; j++) {
                    if(keypad[i][j] == number) {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }
            if(isLeftHand(col)) {
                return moveLeftHand(row,col);
            }
            if(isRightHand(col)) {
                return moveRightHand(row,col);
            }

            return findHand(row,col);
        }

        String findHand(int row, int col) {
            int leftDistance = Math.abs(leftPosition[0] - row) + Math.abs(leftPosition[1] - col);
            int rightDistance = Math.abs(rightPosition[0] - row) + Math.abs(rightPosition[1] - col);


            if(leftDistance > rightDistance) {
                return moveRightHand(row,col);
            }

            if (leftDistance < rightDistance) {
                return moveLeftHand(row,col);
            }

            return isMajorHand(row, col);

        }

        String isMajorHand(int row, int col) {
            if(majorHand.equals("left")) {
                return moveLeftHand(row,col);
            }
            return moveRightHand(row,col);
        }

    }




}
