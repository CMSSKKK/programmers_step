import java.util.*;

public class OpenChatroom {


    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi","Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        Map<String, String> userMap = new HashMap<>();

        for (String s : record) {
            String[] splited = s.split(" ");
            if(splited.length == 3) {
                userMap.put(splited[1],splited[2]);
            }
        }
        List<String> answer = new ArrayList<>();

        for (String s : record) {
            String[] splited = s.split(" ");
            if(splited[0].equals("Enter")) {
                answer.add(userMap.get(splited[1])+"님이 들어왔습니다.");
            }
            if(splited[0].equals("Leave")) {
                answer.add(userMap.get(splited[1])+"님이 나갔습니다.");
            }
        }
        String[] test = answer.toArray(String[]::new);
        System.out.println(Arrays.toString(test));

    }


}
