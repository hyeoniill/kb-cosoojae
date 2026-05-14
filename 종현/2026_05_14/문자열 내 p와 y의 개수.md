# 문자열 내 p와 y의 개수 No.12916

스트림의 .count()메서드를 통해서 p와 y의 개수가 같은지 비교할 수 있다.

### 1차

```java
class Solution {
    boolean solution(String s) {
        return s.chars().filter(c->c=='P'||c=='p').count()==s.chars().filter(c->c=='Y'||c=='y').count();
    }
}
```

.toLowerCase()로 비교를 하나로 압축하는 것도 방법

### 최종

```java
class Solution {
    boolean solution(String s) {
        return s.toLowerCase().chars().filter(c->c=='p').count()==s.toLowerCase().chars().filter(c->c=='y').count();
    }
}
```

### 최최종

```java
class Solution {
    boolean solution(String s) {
        return s.toLowerCase().chars().map(c->c=='p'?1:c=='y'?-1:0).sum()==0;
    }
}
```
