import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewIdRecommend {

    public static void main(String[] args) {
        String id = "...!@BaT#*..y.abcdefghijklm";
        RecommendId recommendId = new RecommendId(id)
                .step1()
                .step2()
                .step3()
                .step4()
                .step5()
                .step6()
                .step7();

        System.out.println(recommendId.getId());
    }
    private static class RecommendId {
        private String id;

        private RecommendId(String id) {
            this.id = id;
        }
        private RecommendId step1() {
            id = id.toLowerCase();
            return this;
        }

        private RecommendId step2() {
            id = id.replaceAll("[^a-z0-9-_.]","");
            return this;
        }

        private RecommendId step3() {
            id= id.replaceAll("[.]{2,}",".");
            return this;
        }

        private RecommendId step4() {
            if(id.charAt(0) == '.') {
                id = id.substring(1);
            }
            return this;
        }

        private RecommendId step5() {
            if(id.isEmpty()) {
                id+= "a";
            }
            return this;
        }

        private RecommendId step6() {
            if(id.length() > 15) {
                id = id.substring(0,15);
            }
            int index = id.length()-1;
            if(id.charAt(index)=='.') {
                id =id.substring(0,index);
            }
            return this;
        }

        private RecommendId step7() {
            int lastIndex = id.length()-1;
            while(id.length() < 3) {
                id += id.charAt(lastIndex);
            }
            return this;
        }

        private String getId() {
            return id;
        }
    }



    @Test
    void step1() {
        String id = "...!@BaT#*..y.abcdefghijklm";
        id = id.toLowerCase();
        Assertions.assertEquals(id,"...!@bat#*..y.abcdefghijklm");

    }

    @Test
    void step2() {
        String id = "...!@bat#*..y.abcdefghijklm";
        id = id.replaceAll("[^a-z0-9-_.]","");
        Assertions.assertEquals(id,"...bat..y.abcdefghijklm");
    }

    @Test
    void step3() {
        String id = "...a..y.abcdefghijklm";
        id = id.replaceAll("[.]{2,1000000000}",".");
        Assertions.assertEquals(id,".a.y.abcdefghijklm");
    }

    @Test
    void step4() {
        String id = ".a.y.abcdefghijklm";
        if(id.charAt(0) == '.') {
            id = id.substring(1);
        }
        Assertions.assertEquals(id,"a.y.abcdefghijklm");
    }

    @Test
    void step5() {
        String id = "";
        String id1 = "a.y.abcdefghijklm";
        if(id.isEmpty()) {
            id+= "a";
        }
        Assertions.assertEquals(id,"a");
    }

    @Test
    void step6() {
        String id1 = "a.y.abcdefghijklm";
        if(id1.length() > 15) {
            id1 = id1.substring(0,15);
        }
        Assertions.assertEquals(id1,"a.y.abcdefghijk");
    }

    @Test
    void step7() {
        String id1 = "a.y.abcdefghijk.";
        int index = id1.length()-1;
        if(id1.charAt(index)=='.') {
           id1 =id1.substring(0,index);
        }
        Assertions.assertEquals(id1,"a.y.abcdefghijk");
    }

    @Test
    void step8() {
        String id1 = "a";
        int lastIndex = id1.length()-1;
        while(id1.length() < 3) {
            id1 += id1.charAt(lastIndex);
        }
        Assertions.assertEquals(id1,"aaa");
    }



}


