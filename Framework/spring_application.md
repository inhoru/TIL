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





