## 🔖 목차
1. [spring 서블릿처럼 사용](#1-spring-서블릿처럼-사용)<br/>


<br/>

# 1. spring 서블릿처럼 사용
- spring에서 서블릿처럼 사용하는방법을 알아보겟다.
- 지금까지 우리는 서블릿을 만들어서 사용했는데 이제부턴 클래스만 만들어서 사용한다.
- Controller에서는 하나의Mapping메소드가 하나의 서블릿이라고 생각하면된다.

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="요청처리테스트" />
</jsp:include>
<section id="content">
	<div id="demo-container">
		<form id="devFrm" method="post">
	<div class="form-group row">
				<div class="col-sm-12">
					<button type="button" class="col-sm-12 btn btn-outline-premary"
						onclick="requestSend('demo/demo1.do')">spring 메소드
						서블릿처럼이용하기</button>
				</div>
			</div>
</section>

<script>
	const requestSend=(url)=>{
		$("#devFrm").attr("action","${path}/"+url);
		$("#devFrm").submit();
	}
</script>

```

- 서블릿과 똑같이 demo/demo1.do 에 요청을보낸다.

<br/>

![image](https://github.com/inhoru/TIL/assets/126074577/f795323b-3c9a-46da-9848-b76d498d0e59)

```java
//xml
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
</beans:bean>

public class DemoController {
	@RequestMapping("/demo/demo.do")
	public String demo(){
		return "demo/demo";
	}
```
- 위와 같은방식으로  서블릿을 만들지않고 jsp를 불러올수가있다.

<br/>

## 메소드선언
- 위에서 하나에 Mapping메소드는 하나의 서블릿이라고 생각하면된다고 했다.
- 그렇다면 메소드를 선언하는방법에대해 알아보자

<br/>


## return 반환형
- 반환형는 4가지가 있다.
- String : ViewResolver에 의해서 view화면을 출력해줌 * 기본적으로 많이 사용
- void : HttpServletResponse객체로 직접 응답메세지를 작성할때 사용
- ModelAndView: 화면에 전달할 데이터와 view 내용을 저장하는 객체 spring제공해줌
- 클래스타입 : json으로 데이터를 반환할때 많이 사용 Restful하게 서버를 구성했을때 많이사용
  - *ResponesEntity<클래스타입>

<br/>

## 매개변수 선언 타입
- 매개변수 선언할수있는 타입에대해 알아보겟다.
- HttpServletRequest : servlet처럼 사용가능
- HttpServletResopnse: servlet처럼 사용가능
- HttpSession : servlet처럼 사용가능
- java.util.Locale : 서버의 로케일정보 저장한 객체
- InpitStream/Reader : 파일 읽어올때 사용하는 stream
- OutputStream.Writer : 파일을 보낼때 사용하는 stream
- 기본자료형 변수  : 클라이언트가 보낸 parameter데이터랑 선언한 변수 이름이 동일하면 자동으로 매핑해준다. 선언이름과 파라미터이름이 다를경우 @RequestParam어노테이션을 이용해서 연결할 수 있음 @RequestParam은 매핑, 기본값설정,필수여부설정
- 클래스변수 : Command라고 함, parameter데이터를 필드에 넣어서 객체를 전달 * parmaeter이름과 필드명이 같은 데이터를 대입해줌.
- java.uilt.Map : @RequestParam 어노테이션이랑 같이 사용, parameter값을 map으로 선언
- @RequestHeader(name값)와 기본자료형을 작성하면 header정보를 받을 수 있음
- @CookieValue(name값)와 기본자료형을 작성하면 Cookie에 저장된 값들 받을수 있음
- Model : request와 비슷하게 데이터를 key/value형식으로 저장할 수 있는 객체
- ModelAndView : model과 view를 동시에 저장하는 객체

<br/>

## 메소드 어노테이션
- @ResponseBody -> Rest방식으로 클래스를 json으로 전송할때
- @RequestBody -> Json방식으로 전송된 parameter를 클래스로 받을때 사용
- @GetMapping,@postMapping,@DeleteMapping...

<br/>

## 서블릿 방식으로 매핑메소드 이용하기
- 이제 서블릿 방식으로 메소드를 만드는걸해보자

```java
@RequestMapping("/demo/demo1.do")
	public void demo1(HttpServletRequest req, HttpServletResponse res) throws SecurityException,IOException, ServletException{
		String devName=req.getParameter("devName");
		int devAge=Integer.parseInt(req.getParameter("devAge"));
		String devGender=req.getParameter("devGender");
		String devEmail=req.getParameter("devEmail");
		String[] devLang=req.getParameterValues("devLang");
		
		Demo d=Demo.builder().devName(devName).devAge(devAge).devEmail(devEmail).devGender(devGender).devLang(devLang).build();

    // 예외처리를 해줘야한다
		req.setAttribute("demo", d);
		req.getRequestDispatcher("/WEB-INF/views/demo/demoResult.jsp").forward(req, res);

    //한글을 사용하기위한 인코딩처
		res.setContentType("text/html;charset=-utf-8");
		PrintWriter out=res.getWriter();
		out.print("<h2>"+devName+devAge+devGender+devEmail+"</h2>");
	}
```

<br/>

## jstl.jsp 탬플릿
- jsp에 작성해야하는 것들을 미리 탬플릿에 적어놓고 불러올수가있다.

- jstl
![image](https://github.com/inhoru/TIL/assets/126074577/be7b239c-7b26-46f9-b42a-bd24a0043cfe)

<br/>

# 2. 1대1매칭
- 매핑메소드의 매개변수에 파라미터로 전송되는 name과 동일한 이름의 변수를 선언한다.
- 매개변수의 타입은 사용할 타입으로 설정해야한다
	- 예를들어 age타입으로 선언했을때 사용자가 19가아닌 19살로 전송했을때 그거를 처리할수있게 프론트에서 하거나 파싱해서 처리해야한다.
- 선언된 매개변수의 이름과 파라미터값이 일치해야한다.
- 매개변수의 데이터값은 모두 들어와있어야한다. 그러지않으면 오류가발생한다 하지만 String값은 오류가 발생하지않는다.
- 이유는 String은 값이없으면 null이나오는데 spring null값은 처리해주기때문에 오류가발생하지않는다.
- int타입은 값이 없다면 0이나오기때문에  java.lang.NumberFormatException 오류가발생한다.

<br/>


  

## 배열db저정
- 배열을 그대로 db에저장할수는 없다.
- 그렇기때문에 배열자체를 String로 변환후 db에저장하고 꺼내올때는 String를 파싱해서 List로 담아서 보내는 방법이있다.
- spring에서 사용하는법을 알아보겟다.


<br/>


## spring 비밀번호 암호화

- 스프링에서 암호화 모듈을 제공한다.
- spring-security모듈을 이용해서 암호화처리를한다.
- 단 단방향 암호화만 지원을한다.
- Meven Repository 에서 spring security core, spring security web , spring security confing 를받는다.

<br/>

![image](https://github.com/inhoru/TIL/assets/126074577/62ba56a7-b05a-4321-9876-db65ac84cce5)
- pom.xml에 jar파일 설정하듯이 dependency 에적어주면된다.
- spirng프레임워크랑 버전을 맞춰주면좋다.

## security-context.xml
- 위와같이 설정을했다면  security-context.xml 파일을만들어준다.
- bean configuration 파일을 만들었다면
- web.xml에 아래처럼 설정을 해줘야한다.
![image](https://github.com/inhoru/TIL/assets/126074577/41962d26-2935-4614-8d58-019144114f6d)
- 그럼이제 controller 에서 사용할준비가 된거다

<br/>


## Controller
- Controller 에서 비밀번호 암호화를 사용해주기위해서는
- 먼저 @Autowired private BCryptPasswordEncoder passwordEncoder; 을선언해준다.
- 그후 password값을 가져와서 passwordEncoder.encode에 넣어주면 끝난다.


```java

@Autowired
private MemberService service;

@Autowired
private BCryptPasswordEncoder passwordEncoder;

@RequestMapping("/enrollMember.do")
public String enrollMemberMove() {
	return "member/member";
}

@RequestMapping(value="/insertMember.do",method=RequestMethod.POST) 
public String insertMember(Member m,Model md) {
	//패스워드를 암호화해서 처리하자.
	String oriPassword=m.getPassword();
	System.out.println(oriPassword);
	String encodePassword=passwordEncoder.encode(oriPassword);
	System.out.println(encodePassword);
	m.setPassword(encodePassword);
	
	
	int result=service.insertMember(m);
	md.addAttribute("msg", result>0?"회원가입성공":"회원가입실패");
	return "common/msg"; 
}
```

![image](https://github.com/inhoru/TIL/assets/126074577/9a82e646-be43-4447-b476-258347cbf69d)
- 이런식으로 비밀번호를 암호화할수가있다.
- 여기서 하나 주의할점은 같은 비밀번호의 회원이 회원가입을했을 비밀번호 암화한 값 같을거라 생각하지만 다르게나온다 sort값때문에 암호화처리한값이 달라진다.
- 그렇다면 로그인할때 어떻게 구별해서 로그인을 할까?

<br/>

## 암호화된값 비교
- 암호화된값을 비교하기 위해서는 BCrptPasswordEncoder가 제공하는 메소드를 이용해햐한다.




<br/>

## log

- import 는slf4j를쓴다.
![image](https://github.com/inhoru/TIL/assets/126074577/d35e5842-38f6-4b28-acf8-d77c2303d28e)

<br/>

## log4j패턴
- 기본 패턴설정 : %-5p: %c - %m%n
- 이벤트명, 카테고리명, 로그전달메세지 개행
* %c : 카테고리명(logger이름)을 표시
	* 카테고리명이 a.b.c일때, %c{2}는 b.c를 출력
* %C : 클래스명을 표시함.	
	* 풀 클래스 명이 com.kh.logger일때, %C{2}는 kh.logger를 출력
* %d : 로그 시간을 출력한다. java.text.SimpleDateFormat에서 적절한 출력 포맷을 지정할 수 있다. 
	* %d{HH:mm:ss, SSS}
	* %d{yyyy MMM dd HH:mm:ss, SSS}
	* %d{ABSOLUTE} 
	* %d{DATE} 
	* %d{ISO8601}
* %F : 파일명을 출력. 로그시 수행한 메소드, 라인번호가 함께 출력된다.
* %l : 로깅이 발생한 caller의 위치정보. 자바파일명:라인번호(링크제공) 
* %L : 라인 번호만 출력한다(링크없음)
* %m : 로그로 전달된 메시지를 출력한다.
* %M : 로그를 수행한 메소드명을 출력한다. 
* %n : 플랫폼 종속적인 개행문자가 출력. rn 또는 n
* %p : 로그 이벤트명등의 priority 가 출력(debug, info, warn, error, fatal )
* %r : 로그 처리시간 (milliseconds)
* %t : 로그이벤트가 발생된 쓰레드의 이름을 출력
* %% : % 표시를 출력. escaping
* %r : 어플리케이션 시작 이후 부터 로깅이 발생한 시점의 시간(milliseconds)
* %X : 로깅이 발생한 thread와 관련된 MDC(mapped diagnostic context)를 출력합니다. %X{key} 형태.


  





