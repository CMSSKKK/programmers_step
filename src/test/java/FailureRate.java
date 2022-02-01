

import java.util.*;

public class FailureRate {

    static class Stage {

        int number;
        double rate;

        Stage(int number, double rate) {
            this.number = number;
            this.rate = rate;
        }


    }


    public static void main(String[] args) {

        int N = 5;
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = new int[]{3,4,2,1,5};
        int[] stageUserNumber = new int[N+1];

        for (int i = 0; i <stages.length ; i++) {
            if(stages[i] == N+1) {
                continue;
            }
            stageUserNumber[stages[i]]++;
        }
        int total = stages.length;
        List<Stage> stagesInfo = new ArrayList<>();
        for (int i = 1; i <stageUserNumber.length ; i++) {
            int temp = stageUserNumber[i];
            if(temp == 0) {
                stagesInfo.add(new Stage(i, 0));
                continue;
            }
            stagesInfo.add(new Stage(i, (double) temp/total));
            total -= temp;

        }

        Collections.sort(stagesInfo, (o1, o2) -> Double.compare(o2.rate, o1.rate));

        int[] test = stagesInfo.stream().mapToInt(s -> s.number).toArray();

        System.out.println(Arrays.toString(test));


    }
}
