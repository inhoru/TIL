# Console

<br/>

# 1. 설명
- Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Console 을활용해서 랜덤값을 가져온는 api다
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.


<br/>

# 2. 예시

```java
 public static String inputNumber() {
        System.out.print(INPUT_NUMBER);
        String input = Console.readLine();
        validationNumber(input.replaceAll(" ", ""));
        return input;
    }

```
