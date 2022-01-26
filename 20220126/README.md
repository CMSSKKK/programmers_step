# 20220126_알고리즘



## [Diagonal Difference](https://www.hackerrank.com/challenges/diagonal-difference/problem)

```java
public static int diagonalDifference(List<List<Integer>> arr) {
  	
  	int left = 0;
  	int right = 0;
  	int count = arr.size();
  
  	for (int i = 0, j = count -1; i < count; i++, j--) {
    		left += arr.get(i).get(i);
    		right += arr.get(i).get(j);
  	}

  	return Math.abs(left-right);
}
```

## [Time Conversion](https://www.hackerrank.com/challenges/time-conversion/problem)

```java
 public static String timeConversion(String s) {
        String[] splited = s.split(":");
        int hour = Integer.parseInt(splited[0]);
        int minute = Integer.parseInt(splited[1]);
        int second = Integer.parseInt(splited[2].substring(0,2));
        String meridiem = splited[2].substring(2,4);

        if(meridiem.equals("AM") && hour == 12) {
            hour = 0;
        }
        if(meridiem.equals("PM") && hour < 12) {
            hour += 12;
        }
       
        return  String.format("%02d:%02d:%02d",hour,minute,second);

    }
```

## [Number Line Jumps](https://www.hackerrank.com/challenges/kangaroo/problem)

```java
public static String kangaroo(int x1, int v1, int x2, int v2) {
        if(v1 <= v2) {
            return "NO";
        }
        
        if((x1-x2) % (v2-v1) == 0) {
            return "YES";
        }
        
        return "NO";

    }
```

## [Save the Prisoner!](https://www.hackerrank.com/challenges/save-the-prisoner/problem)

```java
public static int saveThePrisoner(int n, int m, int s) {
        int answer = (s+m-1) % n;
        
        if(answer == 0) {
            answer = n;
        }
        
        return answer;

    }
```

