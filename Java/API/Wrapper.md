# 🔖 목차

1. [Wrapper](#1-Wrapper)<br/>
2. [활용](#2-활용)<br/>
3. [여러가지 기능](#3-여러가지-기능)<br/>



<br/>

# 1. Wrapper
- 기본 자료형을 객체로 사용할 수 있게 해주는 클래스
- 자동으로 처리가 된다. 크게신경쓸필요없다.

<br/>

![wrapper](https://user-images.githubusercontent.com/126074577/226907609-1473bd01-184d-4ed2-87e2-b512f0a51bb0.png)

- 이런식으로 맵핑이 가능하다.

<br/>

# 2. 활용

```java
Object obj = 10; 
```
- 원래 이게저장될수가없다.

  - 10은 int형인데 obj는 참조형이다.
  - 주소값이들어가야 하는데  리터럴이들어가니 저장이될수가없다.
  - 하지만  **자동으로변환이 되어서 참조형에 들어간다 int가 integer로 변환된다.**
  - 그래서 객체만 이용할수잇는 저장서도 객체처럼 사용가능하다.



<br/>

- 객체를 대상으로하는 저장소에도 기본자료형을 저장할수있도록 해준다.

```java
Integer age = 19;
int intAge=age;
System.out.println(age);
System.out.println(intAge);
```

- 이렇게 자동으로변환된다.
- int가 아닌것도 가능한가?
- 가능하다

```java
test(19); 
		test(180.5);
		test(true);
		test('a');
```

- 이렇게 다른 것들도 **자동으로변환되서 기본자료형도 저장이가능하다.**

<br/>

# 3. 여러가지 기능
- 문자열을 기본타입으로 변경하는 기능

```java
String test2 = "20";
int change = Integer.parseInt(test2);
System.out.println(change);
//출력결과
//20
```

- <code>parseInt</code> 원하는 자료형으로 바꿔주는 메소드이다.


<br/>

- 값 두개중 큰값을 반환하는 기능

```java
int result =Integer.max(100,200);
System.out.println(result);
//출력결과
//200
```

- 큰값을 반환하는게 있다면 작은값을 반환하는 기능도있겟지?

```java
result = Integer.min(100, 200);
System.out.println(result);
//출력결과
//100
```

- 이런식으로 큰값을 반환하거나 작은값을 반환할수가있다.

