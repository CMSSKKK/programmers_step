public class TwoSum {

    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        int target = 9;
        int length = num.length;

        for (int i = 0; i < length; i++) {
            int curNum = num[i];
            if(isOutOfSize(curNum,target)) {
                continue;
            }

            for (int j = i+1; j < length ; j++) {
                int temp = num[j];
                if(isOutOfSize(temp,target)) {
                    continue;
                }
                if(sumCheck(curNum,temp,target)) {
                    int[] answer = new int[] {i,j};
                    System.out.println(answer[0]);
                    System.out.println(answer[1]);
                    System.exit(0);
                }
            }
        }

    }

    static boolean isOutOfSize(int number, int target) {
        if(target <= number) {
            return true;
        }
        return false;
    }


    static boolean sumCheck(int number1, int number2, int target) {

        int sum = number1+number2;
        if(sum == target) {
            return true;
        }

        return false;
    }

}
