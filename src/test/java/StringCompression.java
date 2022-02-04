public class StringCompression {

    public static void main(String[] args) {
        String s = "aabbaccc";
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String value = s.substring(0, i);
            StringBuilder result = new StringBuilder();
            int count = 1;

            for (int j = i; j <= s.length(); j += i) {
                int end = Math.min(j + i, s.length());
                String next = s.substring(j, end);
                if (value.equals(next)) {
                    count++;
                    continue;
                }
                if(count == 1) {
                    result.append(value);
                } else {
                    result.append(count).append(value);
                    count = 1;
                }
                value = next;

            }
            result.append(value);
            answer = Math.min(answer, result.length());
        }
        System.out.println(answer);


    }
}
