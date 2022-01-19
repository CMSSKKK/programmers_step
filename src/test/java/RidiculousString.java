public class RidiculousString {

    public static void main(String[] args) {
        String test = "try  hello world";
        System.out.println(changeStr(test));
    }

    public static String changeStr(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == ' ') {
                stringBuilder.append(c);
                index = 0;
                continue;
            }
            if(index % 2 == 0) {
                stringBuilder.append(makeUpperCase(c));
                index++;
                continue;
            }
            stringBuilder.append(makeLowerCase(c));
            index++;
        }
        return stringBuilder.toString();
    }

    private static boolean checkUpperCase(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private static boolean checkLowerCase(char c) {
        return 'a' <= c && c <= 'z';
    }

    private static char makeUpperCase(char c) {
        if(checkLowerCase(c)) {
            int temp = c - 32;
            c = (char) temp;
        }
        return c;
    }

    private static char makeLowerCase(char c) {
        if(checkUpperCase(c)) {
            int temp = c + 32;
            c = (char) temp;
        }
        return c;
    }
}
