# JadenCase 문자열 만들기 No.12951

### 1차
```java
class Solution {
    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();    //알파벳을 모두 소문자로 바꾸어 저장
        boolean isFirst = true;                        //첫글자인지 판단
        StringBuilder sb = new StringBuilder();
        
        for(char c : arr) {
            if(c == ' ') {                             //빈칸이 있으면 다음에 오는 문자는 첫글자이기 때문에 isFirst를 true로 변경
                isFirst = true;
            } else {  
                if(isFirst && c >= 'a' && c <= 'z') {
                    c -= 32;
                }
                isFirst = false;                       //a~z사이가 아니라면 false로 변경
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}
```

`class String`, `class Character`의 메서드 toUpperCase(), toLowerCase()의 경우, 알파벳이 아니면 해당 값을 그대로 반환하기 때문에 굳이 a~z사이인지 확인할 필요가 없다.

<br><br>

### 최종
```java
import java.lang.*;
class Solution {
    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        
        for(char c : arr) {
            sb.append(isFirst ? Character.toUpperCase(c) : c);
            isFirst = c == ' ' ? true : false;
        }        
        return sb.toString();
    }
}
```
