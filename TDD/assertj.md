## AssertJ 

   
<br/>


# 1. assertj
- 테스트를 위한 라이브러리로, JUnit과 함께 사용하면 테스트 코드를 훨씬 가독성 있고 효율적으로 작성할 수 있도록 도와준다.
- org.assertj.core.api 패키지를 사용한다.

## ssertion 객체가 기본적으로 제공하는 인터페이스
- isEqualTo(Object o), isNotEqualTo(Object o) : 실제 값이 주어진 값과 같은지/다른지 확인

- isInstanceOf(Class<?> type), isInstanceOfAny(Class<?> ... types), isNotInstanceOf(Class<?> type), isNotInstanceOfAny(Class<?> ... types) : 실제 값이 주어진 유형의 인스턴스인지 아닌지 확인

- isExactlySameInstanceOf(Class<?> type), isNotExactlyInstanceOf(Class<?> type) : 실제 값이 정확히 주어진 유형의 인스턴스인지 확인

- asList() : 실제 값이 List의 인스턴스인지 확인하고 list Assertion을 반환

- asString() : toString()으로 실제 값에 대한 문자열을 반환

- hasSameClassAs(Object o), doesNotHaveSameClassAs(Object o), hasSameHashCodeAs(Object o), doesNotHaveSameHashCodeAs(Object o) : 실제 값 / 객체가 주어진 객체와 동일한 클래스 / 해시코드를 가지고 있는지 확인 doesNot이 붙은 메소드는 반대로, 가지고 있지 않은지를 확인

- hasToString(String str), doesNotHaveToString(String str) : 실제 actual.toString() 값이 주어진 String과 같은지 확인 doesNot이 붙은 메소드는 반대로, 같지 않은지 확인

- isIn(Iterable<?> v), isIn(Object ... v), isNotIn(Iterable<?> v), isNotIn(Object ... v) : 주어진 iterable 또는 값 배열에 실제 값이 있는지/없는지 확인

- isNull(), isNotNull() : 실제 값이 null인지 확인

- isSameAs(Object o), isNotSameAs(Object o) : == 비교 사용해 실제 값이 주어진 값과 동일한지 아닌지 확인

- as("설명") : Àssertion을 설명하는 메소드. "설명"의 내용이 테스트 결과에 출력되도록 할 수 있다.

<br/>


## 숫자 관련 메소드
- isBetween(start, end) : 실제 값이 start에서 end 값 사이에 있는지 확인함.

- isStrictlyBetween(start, end) : 실제 값이 start에서 end 값 사이에 있는지 확인함.

- isCloseTo(expected, offset), isCloseTo(expected, percentage) : 실제 숫자가 주어진 offset / percentage 내에서 expected에 가까운지 확인. 차이가 offset/percentage와 같으면 Assertion은 유효한 것으로 간주.

- isNotCloseTo(expected, offset), isNotCloseTo(expected, percentage) : 실제 숫자가 주어진 offset/percentage 내에서 expected에 가깝지 않은지 확인. 차이가 offset/percentage와 같으면 Assertion은 실패한 것으로 간주

- isPositive(), isNegative() : 실제 값이 양수인지/음수인지 확인함

- isNotPositive(), isNotNegative() : 실제 값이 양수가 아닌지 (음수이거나 0인지) / 음수가 아닌지 (양수이거나 0인지) 확인함

- isZero(), isNotZero() : 실제 값이 0인지 아닌지 확인

- isOne() : 실제 값이 1과 같은지 확인


<br/>


## 주로쓰는 메소드 에시


contains

```
void containsTest() {
    List<Integer> list = Arrays.asList(1, 2, 3);

    // Success: 모든 원소를 입력하지 않아도 성공
    assertThat(list).contains(1, 2);

    // Success: 중복된 값이 있어도 포함만 되어 있으면 성공
    assertThat(list).contains(1, 2, 2);

    // Success: 순서가 바뀌어도 값만 맞으면 성공
    assertThat(list).contains(3, 2);

    // Fail: List 에 없는 값을 입력하면 실패
    assertThat(list).contains(1, 2, 3, 4);
}
```


String, array, Array, Set에도 사용 가능

```
@Test
void stringContainsTest() {
    String str = "abc";
    assertThat(str).contains("a", "b", "c");
}

@Test
void arrayContainsTest() {
    int[] arr = {1, 2, 3, 4};
    assertThat(arr).contains(1, 2, 3, 4);
}

@Test
void setContainsTest() {
    Set<Integer> set = Set.of(1, 2, 3);
    assertThat(set).contains(1, 2, 3);
}

```

<br/>

- containsOnly : 순서, 중복을 무시하는 대신 원소값과 갯수가 정확히 일치
- containsExactly : 순서를 포함해서 정확히 일치

```

@Test
void containsOnlyTest() {
    List<Integer> list = Arrays.asList(1, 2, 3);

    assertThat(list).containsOnly(1, 2, 3);
    assertThat(list).containsOnly(3, 2, 1);
    assertThat(list).containsOnly(1, 2, 3, 3);
}


@Test
void containsExactlyTest() {
    List<Integer> list = Arrays.asList(1, 2, 3);

    assertThat(list).containsExactly(1, 2, 3);
}

```






