import java.util.Arrays;

public class KthNumber {

    public static void main(String[] args) {
//        int[] origin = {0,1,2,3,4,5,6,7,8};
//        int[] copied = copyOfRangeArray(origin,2,5);
//        int[] realCopied = Arrays.copyOfRange(origin,2,5);
//        System.out.println(Arrays.toString(copied));
//        System.out.println(Arrays.toString(realCopied));


    }

    private static int[] copyOfRangeArray(int[] arr, int start, int end) {
        // 0 1 2 3 4 5
        int[] copied = new int[end-start];
        int index = 0;
        for (int i = start; i < end ; i++) {
            copied[index++] = arr[i];
        }
        return copied;
    }
}
