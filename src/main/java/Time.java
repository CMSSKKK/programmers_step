public class Time {

    public static void main(String[] args) {

        String time = "11:00:00PM";
        String[] splited = time.split(":");

        int hh = Integer.parseInt(splited[0]);
        int mm = Integer.parseInt(splited[1]);
        int ss = Integer.parseInt(splited[2].substring(0,2));
        String meridiem = splited[2].substring(2,4);

        if(meridiem.equals("AM") && hh == 12){
            hh = 0;
        }
        if(meridiem.equals("PM")&& hh < 12) {
            hh += 12;
        }
        String answer = String.format("%02d:%02d:%02d",hh,mm,ss);
        System.out.println(answer);
    }
}
