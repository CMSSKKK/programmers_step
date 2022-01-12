# W2

* Leetcode

- [x] [Two Sum](https://leetcode.com/problems/two-sum/)

* 문제의 숫자 범위 조건을 확인하지 않고서 반복 횟수를 조금이라도 줄이기 위해서 배열의 숫자가 `target` 보다 큰 경우 `continue`하도록 조건을 만들었었다.
* 하지만 음수가 나올 수 있었고, 그러한 조건을 삭제했다.
* leetcode에서는 실패한 테스트케이스를 보여줘서 내 실수를 찾기 쉬워서 좋았다.
* leetcode의 솔루션에는 `HashMap`을 활용해서 값을 key에 넣고, index를 value에 넣는 형식으로 해결한 코드가 있다.
* 이중 반복으로 찾아내는 것보다 성능도 훌륭했고, 더 좋은 방식으로 보였다.

```java
class Solution {
    
  	// 두 숫자를 더해서 원하는 숫자가 나오는지 확인
    private boolean sumCheck(int number1, int number2, int target) {
        int sum = number1+number2;
        if(sum == target) {
            return true;
        }

        return false;
    }
    
    public int[] twoSum(int[] nums, int target) {
        int[] answer = {};
        int length = nums.length;
      	// 배열 탐색
        for (int i = 0; i < length; i++) {
            int curNum = nums[i];
            // 현재 인덱스 다음부터 탐색 
            for (int j = i+1; j < length ; j++) {
                int temp = nums[j];
                if(sumCheck(curNum,temp,target)) {
                    answer = new int[] {i,j};
                    return answer;
                }
            }
        }
        return answer;
    }
    
}
```



- [x] [Reverse Integer](https://leetcode.com/problems/reverse-integer/)

* 단순히 숫자를 문자열로 바꾸고 음수인지 양수인지 확인하고 StringBuilder에서 reverse하는 방식도 있지만, 거꾸로 집어넣는 방식으로 구현을 해봤다.
* 왜인지 음수를 양수로 바꾼채로 `String`으로 변환하면 어떤 테스트 케이스에서 넘어가지 않았다.. 다시 한번 후에 디버깅해봐야겠다.
* 그래서 처음부터 `String` 으로 변환해서 구현했다.
* 솔루션에서는  `%`와 `/`를 통한 숫자계산과 범위조건을 통해서 반환하는 방식으로 해결했다.

```java
class Solution {
    public int reverse(int x) {
      	String strX = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();
      	
      	// 음수인지 확인하기
        char first = strX.charAt(0);
        if( first == '-' ) {
            strX = strX.substring(1);
            stringBuilder.append(last);
        }
        
      	// 숫자를 뒤집기 위해서 마지막문자부터 넣기
        int length = strX.length();
        for (int i = length-1; i >=0 ; i--) {
            char temp = strX.charAt(i);
            stringBuilder.append(temp);
        }
        // int 범위를 초과할 수 있어서 long으로 파싱
        long answer = Long.parseLong(stringBuilder.toString());
        
      	// 범위를 초과하면 0을 리턴
        if(answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE) {
            return 0;
        }
    		// 뒤집은 값 int로 파싱해서 리턴
        return Integer.parseInt(stringBuilder.toString());
        
    }
}
```



- [x] [Remove Duplicate from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
- 이런 입력을 받는 문제는 처음이라서 어색했다.(입력값과 반환값이 헷갈렸다)
- 시스템상에 링크드리스트를 가지고 있고, head를 통해서 중복 데이터를 삭제(연결을 바꿔주는 과정)후에 다시 head를 반환하면 시스템에서 다시 head를 가지고서 링크드리스트를 탐색해서 확인하는 것 같다.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 현재 노드
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            // 중복 데이터이면 다음 노드로 연결
          	if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            }
          	// 중복 데이터가 아니면 다음 노드로 이동
            else {
                curNode = curNode.next;
            }
            
            
        }
        return head;
    
    }
}
```



- [x] [Palindrome Number](https://leetcode.com/problems/palindrome-number/)

* 펠린드롬 : 앞에서부터 읽을 때와 뒤에서부터 읽을 때 둘 다 똑같은 단어 (뒤집어도 같은 단어)
* 펠린드롬 문자의 길이가 홀수일 경우, 가장 가운데 문자는 비교대상이 없기 때문에 반복횟수를 단순히 2로 나눈다.

```java
class Solution {
    
  public boolean isPalindrome(int x) {
      	String strX = String.valueOf(x);
    		// 뒤에서부터 시작하는 index
        int reverseIndex = strX.length()-1;
    		// 반복 횟수
        int loopLength = strX.length()/2;
    		// 펠린드롬 숫자인지 확인
        for(int index = 0; index < loopLength; index++, reverseIndex--) {
            if(strX.charAt(index) != strX.charAt(reverseIndex)) {
                return false;
            }
        }
        return true;       
    }
    
}
```

- [x] [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)

* 공통되는 가장 긴 문자열이 아니라 접두사이기 때문에 쉬운 문제였다.
* 아마 공통으로 가장 긴 문자열이라면 dp를 활용해야 할 듯 하다.
* 또 홀린듯 `StringBuilder`를 사용했는데, leetcode 솔루션을 보니 `indexOf`를 활용하는 방식이 있었다.
* 접두사이기때문에 `indexOf`를 사용하면 0을 반환해야 하며, -1을 반환한다면 `substring` 으로 뒤에서부터 문자를 순차적으로 잘라내는 식으로 반복한다.
* 내 코드는 처음부터 같은 문자인지 확인하고 아니라면 일치하는 문자까지 반환해 공통 접두사를 찾아내는 방식이다.

```java
class Solution {
  
     private String findLCP(String str1, String str2) {
       // 반복 횟수
       int length = Math.min(str1.length(), str2.length());
       // LCP를 담을 stringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; i++) {
          	// 문자가 일치하지 않다면 루프 중단
            if(str1.charAt(i) != str2.charAt(i)) {
                break;
            }
          // 문자 추가
            stringBuilder.append(str1.charAt(i));
        }
        return stringBuilder.toString();
    }
  
  	public String longestCommonPrefix(String[] strs) {
        
      	int length = strs.length;
        // 배열이 비어있으면 "" 리턴
      	if(length == 0) {
            return "";
        }
      	// 비교대상 지정
        String answer = strs[0];
        // 다음 문자열부터 비교대상과 비교
        for(int i = 1; i < length; i++ ) {
            // 비교대상을 다시 지정
          	answer = findLCP(answer, strs[i]);
        }
        
        return answer;
        
    }
    
}
```

- [x] [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

* 주어진 linked List가 환형 링크드리스트인지, 단순 링크드리스트인지 확인하는 문제이다.
* 환형 링크드리스트는 단순히 반복문을 돌렸을 시에 무한 루프에 빠져서, 런타임에러가 발생할 것이다.
* 앞의 Two Sum 문제에서 hashMap을 사용한 풀이를 보고난 이후라 자연스럽게 `Set`을 사용하는 풀이가 생각났다.
* 링크드리스트를 계속 탐색하면서 각 노드를 `nodeSet`에 넣어준다.
*  만약 들어가지 않는다면 다시 돌아온 것(원형)이기 때문에 `true`를 반환한다.
* 그리고 단순 연결리스트라면 `while`문이 종료되기 때문에 자연스럽게 `false`를 반환한다.
* 다른 사람의 풀이 중에는 탐색하는 노드를 2개로 지정해서 루프 중 같은 노드일 경우 `true`를 반환하는 형식으로 구현한 것도 있었다.

```java
public class Solution {
    
    public boolean hasCycle(ListNode head) {
      	// 노드를 저장할 set
        Set<ListNode> nodeSet = new HashSet<>();
        // 탐색 노드
      	ListNode temp = head;
        while(temp != null && temp.next != null) {
            // set에 노드를 넣는다.(넣어지지 않으면 이미 탐색한 노드이기때문에 true 리턴)
          	// add메서드의 반환 타입은 boolean
          	if(!nodeSet.add(temp)) {
                return true;
            }
            temp = temp.next;
        }
      	// 루프를 빠져나온다면 환형리스트가 아니다.
        return false;
    }
       
}
```

