import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OpenChatroom {

    static class User {

        String id;
        String nickname;

        User(String id, String nickname) {
            this.id = id;
            this.nickname = nickname;
        }

        public boolean isSameUser(String id) {
            return this.id.equals(id);
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        List<User> users = new ArrayList<>();

        for (String s : record) {
            recordUser(users,s);
        }
        String[] test = getAnswer(users,record);
        System.out.println(Arrays.toString(test));

    }

    public static void recordUser(List<User> users, String command) {
        String[] splited = command.split(" ");
        String state = splited[0];
        String id = splited[1];
        if(!state.equals("Leave")) {
            if(hasLogged(users,id)) {
                users.stream().filter(user -> user.isSameUser(id))
                        .findAny()
                        .ifPresent(user -> user.setNickname(splited[2]));
                return;
            }
            users.add(new User(id,splited[2]));
        }
    }

    private static boolean hasLogged(List<User> users, String id) {
        return users.stream().anyMatch(user -> user.isSameUser(id));
    }

    public static String[] getAnswer(List<User> users, String[] record) {
        List<String> answer = new ArrayList<>();

        for (String s : record) {
            String[] splited = s.split(" ");
            String nickName = users.stream().filter(user -> user.isSameUser(splited[1])).findAny().get().getNickname();
            if(splited[0].equals("Enter")) {
                answer.add(nickName+"님이 들어왔습니다.");
            }
            if(splited[0].equals("Leave")) {
                answer.add(nickName+"님이 나갔습니다.");
            }
        }
        return answer.toArray(String[]::new);
    }

}
