# 20220119 알고리즘

* 프로그래머스

* [크레인 인형 뽑기](https://programmers.co.kr/learn/courses/30/lessons/64061)
```java
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> dollStack = new Stack<>();
        // 뽑는 과정
        for(int move : moves ) {
            int index = move-1; // move의 위치는 1부터, board 인덱스는 0부터
            for(int i = 0; i < board.length; i++) {
                // 해당 위치에 인형이 있는지 확인
                int temp = board[i][index];
                if(temp == 0) { // 인형 없음
                    continue;
                }
                // 인형이 뽑았을 때, stack에 있는 인형과 일치하지 않거나 스택이 비어있는 상황
                if(dollStack.isEmpty() || dollStack.peek() != temp) { 
                    board[i][index] = 0;  // board내에 인형을 없애줌
                    dollStack.push(temp); // stack에 인형을 넣어줌
                    break;
                }
                // 뽑은 인형이 stack에 있는 인형과 같을 때
                board[i][index] = 0; // board내에 인형을 없애줌
                dollStack.pop(); // stack에서 삭제
                answer += 2; // 2개의 인형을 터트림을 기록
                break;
                
            }
            
        }
        return answer;
    }
}
```

* [모의고사](https://programmers.co.kr/learn/courses/30/lessons/42840)
```java
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        // 찍는 패턴
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        
        // 점수 저장 맵
        Map<Integer,Integer> score = new HashMap<>();
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == supo1[i%5]) {
                score.put(1,score.getOrDefault(1, 0) + 1);
            }
            if(answers[i] == supo2[i%8]) {
                score.put(2,score.getOrDefault(2, 0) + 1);
            }
            if(answers[i] == supo3[i%10]) {
                score.put(3,score.getOrDefault(3, 0) + 1);
            }            
        }
        // 최고득점 점수 확인
        int max = -1;
        for(int key : score.keySet()){
            if(max < score.get(key)) 
                max = score.get(key);
        }
        // 최고득점자가 몇 명인지 확인
        int cnt = 0;
        for(int key : score.keySet()){
            if(max == score.get(key)) cnt++;
        }
        // 동점자 수 만큼 배열 생성
        answer = new int[cnt];
        
        // 최고득점자(들) 배열에 오름차순으로 넣어주기
        int index = 0;
        for(int key : score.keySet()){
            if(max == score.get(key)){
                answer[index] = key;
                index++;
            }
        }
      
        
        return answer;
    }
}
```

* [이상한 문자 만들기](https://programmers.co.kr/learn/courses/30/lessons/12930)
    * 단순히 `toUpperCase()`, `toLowerCase()`를 사용하려다가 아스키코드를 통한 변환을 직접해보고 싶어졌다.
    * 굉장히 간편하게 풀이할 수 있는 문제였지만, 직접 변환하다보니 메서드가 많이 추가되었다.
```java
class Solution {
    public String solution(String s) {
        String answer = changeStr(s);
        
        return answer;
    }
    
    private String changeStr(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 공백이 있으면 인덱스를 0으로 다시 바꿔준다.
            if(c == ' ') {
                stringBuilder.append(c);
                index = 0;
                continue;
            }
            // 인덱스가 짝수일때는 대문자로
            if(index % 2 == 0) {
                stringBuilder.append(makeUpperCase(c));
                index++;
                continue;
            }
            // 인덱스가 홀수일때는 소문자로
            stringBuilder.append(makeLowerCase(c));
            index++;
        }
        return stringBuilder.toString();
    }
    // 대문자인지 체크
    private boolean checkUpperCase(char c) {
        return 'A' <= c && c <= 'Z';
    }
    // 소문자인지 체크
    private boolean checkLowerCase(char c) {
        return 'a' <= c && c <= 'z';
    }
    // 아스키코드를 활용해서 대문자로 변환
    private char makeUpperCase(char c) {
        if(checkLowerCase(c)) {
            int temp = c - 32;
            c = (char) temp;
        }
        return c;
    }
    // 아스키코드를 활용해서 소문자로 변환
    private char makeLowerCase(char c) {
        if(checkUpperCase(c)) {
            int temp = c + 32;
            c = (char) temp;
        }
        return c;
    }
}
```
* [K번째수](https://programmers.co.kr/learn/courses/30/lessons/42748)
    * `Arrays.copyOfRange()`, `Arrays.sort()` 메서드를 쓰면 쉽게 해결할 수 있는 문제다.
    * 하지만 무언가 직접 구현하고 싶었다. 
    * 오전에 하던 운영체제 공부를 위해서 `copyOfRange()`만 직접 구현해보았다.
    * 정렬은 날잡고 방식마다 다 구현해보기로!
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i< commands.length; i++) {
           int[] copied = copyOfRangeArray(array, commands[i][0] -1, commands[i][1]);
            Arrays.sort(copied);
            answer[i] = copied[commands[i][2]-1];
        }
        return answer;
    }
    
    private static int[] copyOfRangeArray(int[] arr, int start, int end) {
        int[] copied = new int[end-start];
        int index = 0;
        for (int i = start; i < end ; i++) {
            copied[index++] = arr[i];
        }
        return copied;
    }
}
```

## 회고

* 요구사항이 간단한 문제들이다.
* 그냥 슥슥 구현할 수 있는대로 풀어본 문제(모의고사)도 있고,
* 요구사항이 더 복잡해졌을 때를 생각해보면서 풀어본 문제(인형뽑기,이상한 문자 만들기)도 있다.
* 간단한 문제는 슥슥 풀어넘기고 더 어려운 문제들을 연습하는 게 맞을지, 간단한 요구사항이어도 고민해보는게 좋을지 모르겠다. 

