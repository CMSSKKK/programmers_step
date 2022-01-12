public class ReverseInteger {

    public static void main(String[] args) {


        int x = 1534236469;
        double min = Math.pow(-2,31);
        double max = Math.pow(2,31)-1;

        String strX = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();
        if(strX.charAt(0) == '-') {
            strX = strX.substring(1);
            stringBuilder.append('-');
        }
        int length = strX.length();
        for (int i = length-1; i >=0 ; i--) {
            char temp = strX.charAt(i);
            stringBuilder.append(temp);
        }
        long answer = Long.parseLong(stringBuilder.toString());
        if(answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE) {
            System.out.println(0);
        }

    }


}
