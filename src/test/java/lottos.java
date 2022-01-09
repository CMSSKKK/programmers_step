import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

public class lottos {
    static Map<Integer, Integer> gradeMap = Map.of(6, 1,
            5, 2,
            4, 3,
            3, 4,
            2, 5,
            1, 6,
            0, 6);

    static int[] findNums(int[] lottos, int[] winNums) {
        int zeroCount = 0;
        int matchCount = 0;
        for (int lotto : lottos) {
            matchCount += (int) Arrays.stream(winNums).filter(winNum -> winNum == lotto).count();
            if (lotto == 0) {
                zeroCount++;
            }
        }
        return new int[]{findGrade(matchCount + zeroCount), findGrade(matchCount)};
    }

    static int findGrade(int count) {
        int grade = gradeMap.get(count);
        return grade;
    }

    @Test
    void test1() {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] nums = {31, 10, 45, 1, 6, 19};
        Assertions.assertArrayEquals(findNums(lottos, nums), new int[]{3, 5});
    }

    @Test
    void test2() {
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] nums = {38, 19, 20, 40, 15, 25};
        Assertions.assertArrayEquals(findNums(lottos, nums), new int[]{1, 6});
    }

    @Test
    void test3() {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] nums = {20, 9, 3, 45, 4, 35};
        Assertions.assertArrayEquals(findNums(lottos, nums), new int[]{1, 1});
    }

}
