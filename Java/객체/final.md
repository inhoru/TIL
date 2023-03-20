# 🔖 목차

1. [클래스간상속](#1-클래스간상속)<br/>
2. [메소드 오버라이딩 불가](#2-메소드-오버라이딩-불가)<br/>


<br/>


## final

- 클래스 간 상속이 가능하다면 그 반대인 클래스 간 상속을 막아 놓는 것이 있다.
- 그역할을 해주는 키워드가 final 예약어이다.
- final은 2가지경우로 사용이 가능하다.
  - 첫번째는 클래스간 상속금지
  - 두번째는 메소드 오버라이딩 금지


# 1. 클래스간상속

-  먼저 쓰는방법을알아보자

```java
public final class FinalTestClass {
```

- 이런식으로 예약어에 <code>final</code> 을붙인다면 이제 이클래스는 상속이 불가능하다라는뜻이다.

<br/>


- 그렇다면 final 을 사용했다면 이클래스는 사용이 불가능한건가?
- 아니다 상속만 불가능한거지 사용하는건 문제가없다.

```java
public final class FinalTestClass {
	private String test;
	
	public void setTest(String test) {
		this.test=test;
	}
	public String getTest() {
		return test;
	}
  ------------------------------------------------------
  FinalTestClass ftc= new FinalTestClass();
		 
		 ftc.setTest("사용문제없음");
		 System.out.println(ftc.getTest());
	}
	
}
//출력결과
//사용문제없음
```

- 이렇게 문제없이 사용이가능하다.
- **상속만 불가능하다.**

<br/>

# 2. 메소드 오버라이딩 불가

- 말그대로 상속시 오버라이딩이 불가능한 메소드로 만들어준다.
- 예시를 보자

```java
public final void printMsgg() {
		System.out.println("어노테이션으로 오버라이드");
	}
  -------------------------------------------------------------
  @Override
	public void printMsgg() {
		System.out.println("파이널메소드");
	}
  //출력결과
  //오류 오버라이딩 불가능
  ```
  
  - 이렇게 부모 메소드 <code>final</code>가 붙어있으면 **자식은 오버라이딩이불가능하다.**

