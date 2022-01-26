import java.util.List;


public class Diagonal {

    public static void main(String[] args) {
        //3
        //11 2 4
        //4 5 6
        //10 8 -12
        List<Integer> list1 = List.of(11,2,4);
        List<Integer> list2 = List.of(4,5,6);
        List<Integer> list3 = List.of(10,8,-12);

        List<List<Integer>> arr = List.of(list1,list2,list3);
        int left = 0;
        int right = 0;
        int count = arr.size();
        for (int i = 0, j = count -1; i < count; i++, j--) {
            left += arr.get(i).get(i);
            right += arr.get(i).get(j);
        }

        System.out.println(Math.abs(left-right));

    }
}
