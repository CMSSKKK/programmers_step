import java.util.*;

public class report {


    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};

        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        report = Arrays.asList(report).stream().distinct().toArray(String[]::new);
        int k = 2;
        // answer = [2,1,1,0]
        List<Id> ids = generateIds(idList);
        report(ids,report);
        checkSuspended(ids,k);
        sendMails(ids);



        int[] answer = ids.stream().mapToInt(id-> id.mails).toArray();
        System.out.println(Arrays.toString(answer));

    }

    public static class Id {
        String name;
        int reportedCount;
        Set<String> reportedBy;
        boolean suspended;
        int mails;

        Id(String name) {
            reportedCount = 0;
            this.name = name;
            reportedBy = new HashSet<>();
            suspended = false;
            mails = 0;
        }

        void reportBy(String id) {
            reportedBy.add(id);
            reportedCount++;
        }

       void isSuspended(int k) {
            if(k <= reportedCount) {
                suspended = true;
            }
        }

        void getMails(Set<String> ids) {
            for (String id : ids) {
                if(id.equals(this.name)) {
                    mails++;
                }
            }
        }
    }

    public static List<Id> generateIds(String[] idList) {
        List<Id> ids = new ArrayList<>();
        for (String id : idList) {
            ids.add(new Id(id));
        }
        return ids;
    }

    private static Id getId(List<Id> ids, String id) {
        for (Id id1 : ids) {
            if(id1.name.equals(id)) {
                return id1;
            }
        }
        return null;
    }

    public static void report(List<Id> ids, String[] reportInfo) {
        for (String report : reportInfo) {
            String[] reportCase = report.split(" ");
            Id reported = getId(ids,reportCase[1]);
            reported.reportBy(reportCase[0]);
        }
    }

    public static void checkSuspended(List<Id> ids,int k) {
        for (Id id : ids) {
            id.isSuspended(k);
        }
    }

    public static void sendMails(List<Id> ids) {
        for (Id id : ids) {
            if(id.suspended == true) {
                Set<String> temp = id.reportedBy;

                for (Id id1 : ids) {
                    id1.getMails(temp);
                }
            }
        }
    }



}
