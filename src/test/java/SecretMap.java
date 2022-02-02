public class SecretMap {

    public static void main(String[] args) {
       int temp1 = 22;
       int temp2 = 14;
       String test = Integer.toBinaryString(temp1|temp2);
       System.out.println(test);
       String test1 = String.format("%"+6+"s",test);
        System.out.println(test1);
       test1 = test1.replaceAll("1","#");
       test1 = test1.replaceAll("0"," ");
       System.out.println(test1);

    }

    public String[] solve(int length, int[] arr1, int[] arr2) {
        String[] answer = new String[length];

        for (int i = 0; i < length ; i++) {
            answer[i] = drawMap(length, orNumber(arr1[i], arr2[i]));
        }
        return answer;
    }

    public int orNumber(int num1, int num2) {
        return num1 | num2;
    }

    public static String drawMap(int count, int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if((number & 1) == 1) {
                stringBuilder.append("#");
            } else {
                stringBuilder.append(" ");
            }
            number = (number >> 1);
        }
        return stringBuilder.reverse().toString();
    }
}
