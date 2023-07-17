## 🔖 목차
1. [aop사용](#1-aop사용)<br/>


<br/>

## AOP
- spring aop은 관점지향 프로그래밍이다.
- 관점이란 프로그래밍저으로봤을때 핵심내용이라고한다.
- 핵심내용이란 우리가 서비스를 구현할때 보조적인 기능과 핵심기능으로 나눌수가있다.
  - 보조적인 기능은 다수의서비스에대해서 공통적으로 적용하는 기능이다.
  - 설계를 할때 공통적인 기능과 핵식적인 기능의 클래스를 나눠서 사용한다.
- 핵심 로직과 부가 기능을 분리하여 애플리케이션 전체에 걸쳐 사용되는 부가 기능을 모듈화하여 재사용할 수 있도록 지원하는 것


<br/>

## 예시
- 은행이있다고치면 은행의 기능은
- 입금, 출금,  이체, 세금 등등등이 있을것이다.
  - 입금의 핵심기능은 통장에 돈이 + 된다.  계좌 와 비밀번호가있어야가능
  - 출금의 핵심기능은 통장에 돈이 - 된다.  계좌 와 비밀번호가있어야가능
  - 이체의 핵심기능은 통장에 돈이 + 된다.  계좌 와 비밀번호가있어야가능
  - 세금의 핵심기능은 토장에 돈이 - 된다.  계좌 와 비밀번호가있어야가능

<br/>

- 프로그래밍적으로봤을때 계조와 비밀번호는 공통적인 기능이다.
- 그걸 횡단관심사라고하고 핵심기능인 걸 종단 관심사라고한다.

<br/>

# 1. aop사용
- 공통의 관심사(기능)을 저장하는 클래스를 먼저 생성해준다(Aspect)
  - 클래스안에는 pointcut설정을할수가있다 : 어느지점에서 실행할지를 결정하는 것 -> 어떤메소드에서 실행할지(타겟을지정한다) 표현식
  - advisor : 실행할 시점을 설정 한다. -> Before, After, Around, afterRetruning, afterThrowing,
  - 실행할 메소드 : 공통의 로직을 구현한 메소드 JoinPoint클래스 제공 한다
 
<br/>


## xml방식으로 Aop 설정하기
- spring bean configuration.xml에서 제공하는  aop namespace를 설정
- <aop:태그>이용해서 설정을한다.

```xml
<aop:config>
  <aop:aspect ref="beanid">
<aop:pointcut expression="execution(패턴으로 타겟메소드 설정)" id="포인트컷이름"/>
<aop:before||after||around||.. method="메소드명" pointcut-ref="포인트컷이름"/>
</aop:config>
```

- execution()안에 넣을 주소값에따라 적용되는 곳이 달라진다.
- com.bs.spring..select*(..) :com.bs.spring 패키지 및 하위 패키지에 있는 모든 select로 시작하는 메소드의 실행을 선택한다 라는뜻이야 (..)는 매개변수라는뜻
<br/>

## 어노테이션방식
- apect역할 클래스를 생성
- 클래스를 bean으로 등록 @Compomnent(클래스선언부)
- aspect로 등록 @Aspect(클래스선언부)
- \@PointCut(execution("패턴"))으로 포인트컷 설정
- \@befer,@after,@around..... 실행메소드에 설정을한다.
- springbeanconfiguration.xml파일에서 <aop:aspectj-autoproxy/>선언해줌.

<br/>

## mevent dependency
- aspect-weav모듈을 등록을해줘야한다.
- 그래야위에거들이 정상적으로 들어간다.

<br/>


# 2. execution
- excution 표현식 예제를 모아둔 사이트가있다.
- https://docs.spring.io/spring-framework/docs/5.3.29/reference/html/core.html#aop-pointcuts-examples
- 5.4.3 Declaring a Pointcut에 Examples에 가보면 예제들이있다.

<br/>

# 3. 어노테이션
- 어노테이션 방식으로 aop를 사용하는방법에대해 알아보겟다.
- 먼저 Aspect 클래스를 하나만든후 @Aspect어노테이션을 선언해준다.
- 이 클래스가 Aspect를 나타내는 클래스라는 것을 명시하고 @Component를 붙여 스프링 빈으로 등록한다.
- 실행시점 어노테이션을 정해서 작성한다.
```java
@Component
@Aspect
public class AuthenticationCheckAop {
	
	@Before("execution(* com.bs.spring.memo..*(..))")
	public void checkcheck(JoinPoint jp) {
		//spring이 제공하는 RequestContextHolder클래스를 이용해서 session값을 가져올 수 있다.
		HttpSession session=(HttpSession)RequestContextHolder.currentRequestAttributes().resolveReference(RequestAttributes.REFERENCE_SESSION);
		Member loginMember=(Member)session.getAttribute("loginMember");
		if(loginMember==null||!loginMember.getUserId().equals("admin")) {
			throw new AuthenticationException("서비스이용 권한이 부족합니다.");
		}
		
	}

```

- execution(* com.bs.spring.memo..*(..))가 의미하는 바는 com.bs.spring.memo 아래의 패키지 경로의 객체의 모든 메서드에 이 Aspect를 적용하겠다는 의미다.

<br/>















 
 
