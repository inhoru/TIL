## Random


<br/>

# 1. Randoms
 - Random API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 을활용해서 랜덤값을 가져온는 api다
 - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.

<br/>

## 사용법

- 1~9까지 의 램덤수를 가져오는 메소드


```java
 public int createRandomNumber(List<Integer> randomNumbers) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_NUMBER_START,
                    BASEBALL_NUMBER_END);
            if (!randomNumbers.contains(randomNumber)) {
                return randomNumber;
                //return 1;
            }
        }
    }
```

-  Randoms.pickNumberInRange(인수,인수);
-  이런식으로 숫자사이에 랜덤값을 가져온다.
