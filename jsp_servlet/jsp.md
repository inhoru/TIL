# :bookmark: 목차

1. [태그](#1-태그)<br/>

2. [선언문 활용하기](#2-선언문-활용하기)<br/>

3. [스크립트릿이용하기](#3-스크립트릿이용하기)<br/>
4. [jsp내장객체](#4-jsp내장객체)<br/>
5. [include](#5-include)<br/>
6. [page](#6-page)<br/>





## jsp

- html코드를 java코드에 넣어서 생성하는 도구이다.
- 우리가 html코드를 작성해서 넣으면 서버에서 자동으로 변환되며 동작을한다.
- 화면 로직 처리에 적합하다.

<br/>



## jsp특징

- JSP파일이 변경되지 않는다면 ‘.jsp’파일에 대한 컴파일은 다시 일어나지 않음
- JSP파일이 변경될 때마다 Web Container는 translation, compile, load, initialization과정 수행
- . JSP파일의 배포 환경(위치)은 HTML과 동일(WEB ROOT 폴더 하단)



<br/>



##  표기법

- 기본적으로 jsp표기법은 <% 내용%> 이런식으로 표기한다.
- jsp파일을 만들면 맨처음에는 **지시자**부터나온다.



![표기법](https://user-images.githubusercontent.com/126074577/240469116-e822b44e-8140-4f24-9875-80e509c05783.png)



<br/>



# 1. 태그

- jsp가 제공하는 태그에 대해 알아보자

<br/>



## 지시자

- 페이지에 대한 설정을 하는 태그, contenttype, import정보, 언어정보 등을 설정한다.
- 페이지(jsp)내에 다른 페이지(jsp)를 불러올때 사용하는 태그이다.
- taglib : jsp에 적용할외부라이브러리 등록(JSTL, springform)한다

```jsp
 <%-- <%@ 태그명 속성설정(속성명="속성값") %> --%>
```

<br/>

## 선언문

- 자바클래스 구현부에 작성하는 코드 클래스 중괄호부분에 들어갈 코드를 작성할때 사용한다
- 메소드선언, 멤버변수선언 이용할때 사용 거의사용하지않는다.
- 조건문, 반복문 등은 사용이 불가능하다.

```jsp
 <%-- <%! 자바코드 %> --%>
```



<br/>



## 스트립트릿

- 자바의 메소드내부에 들어갈 코드 작성할때 사용한다.
- 이코드를 가장많이사용한다.
- 그이유는 지역변수와 반복문 과 조건문을 사용할수있기때문에 주요 로직을짤때 많이사용한다.

```jsp
<%-- <% 자바코드 %> --%>
```

<br/>



## 표현식

- html 화면에 변수나, 메소드 실행결과를 출력할때 사용한다.
- 이거또한 출력기능이기때문에 많이사용한다.

```jsp
<%-- <%= 출력할문구||변수명||메소드호출 %> --%>
```

<br/>



# 2.  선언문 활용하기

- 멤버변수가, 멤버메소드를 선언할때 사용한다.
- 조건문과 반복문을 사용할수는없다.

```jsp
String testData;
	public int age = 19;

	public String getMsg() {
		return "안녕하세요";
	}
```



<br/>



## 선언문에서 작성한 내용이해하기

- 선언문에서 작성한애용을 표혀식으로 출력해보자

```jsp
testData : <%=testData %>
age : <%=age %>
getMsg() : <%=getMsg() %>
```



<br/>



# 3. 스크립트릿이용하기

- 자바코드를 작성하는 부분
- jspservice()메소드 내부에 작성됨.

- public double height=180.5; 은 사용불가능하다. 왤까?
- 위에서 설명햇듯이 접근제한자(public) 사용불가능하다. 



<br/>



```jsp
<%
    	//자바코드를 작성하는 부분
    	//_jspservice()메소드 내부에 작성됨.
    	String msg="이제 곧 점심시간!";
    	//접근제한자 사용불가능
    	//public double height=180.5;
    	int rndNum=(int)(Math.random()*10+1);
    	if(rndNum>3){
    		out.print("3보다크다!");
    	}
    	for(int i=0;i<10;i++){
    		out.println("출력"+i+"<br/>");
    	}
    %>
	<h3><%=msg%></h3>
	<h3>
		램덤수 :
		<%=rndNum %></h3>
	<% 
    	String[] names={"강태풍","최바람","이지진","김해일","허상호","김치니"};
    %>
	<ul>
		<%for(String name:names){ %>
		<li><%= name %></li>
		<% } %>

	</ul>
	<% if(msg.contains("점심")){ %>
	<h1>점심 마싯게 드세요!</h1>
	<%} %>
		<!-- 배열로 체크박스만들기 -->
	<% 
    	String[] hobby={"코딩","독서","게임","등산","취침"};
    %>
	<%for(String hobbys:hobby){ %>
	<Label><%=hobbys%><input type="checkbox" value="<%=hobbys%>"
		<%=hobbys.equals("코딩")?"checked":""%>></Label>
	<%} %>
```

<br/>





# 4. jsp내장객체

- 서블릿에서 데이터를 저장하거나 정보를 가져왔던 객체를 지역변수로 가지고 있음
- HttpServletRequest : request 
- HttpServletResponse : response 
- HttpSession : session

- ServletContext : application 
- Cookie : request.getCookies() 
- Header : request.getHeader()
- PrintWriter : out

- 오른쪽이 jsp에서 사용하는 명령어이다.



## contextRoot

- contextRoot도 jsp명령어가있다.

```jsp
contextRoot는 <%=request.getContextPath() %>
	
요청주소 :<%=request.getRequestURI() %>

```



<br/>



## 내장객체에 저장된 데이터 활용하기



- 내장객체를 jsp view방식으로 저장해서 활용해보자

```jsp
<a href="<%=request.getContextPath()%>/views/datasave.jsp">데이터저장</a>
```

- 이제는 getContextPath()로 주소값을 가져온다 그래야 주소값이 변해도 적용이되니깐

- 먼저 vo객체를 만들고 그값들을 내부객체에 저장해서 활용해보자

```jsp
public class Animal implements Serializable{
	
	private static final long serialVersionUID = 207251685964143194L;
	
	private String name;
	private int age;
	private String gender;
	private double weight;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String name, int age, String gender, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
......
```

- 길어서 나머지부분은 생략하겟다.

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.data.model.vo.Animal"%>
 <%
 	List<Animal> animals=List.of(
 			new Animal("뽀송이",2,"여",4.7),
 			new Animal("뽀삐",2,"남",7.2),
 			new Animal("유미",5,"여",10.2),
 			new Animal("톰켓",2,"남",8.5)
 			);
 	request.setAttribute("animals", animals);
 	session.setAttribute("loginId", "admin");
 	application.setAttribute("contextData", "data");
 	
 	/* request.getRequestDispatcher("datacheck.jsp").forward(request, response); */
 	response.sendRedirect(request.getContextPath()+"/views/datacheck.jsp");
 %>		

```

- 객체를 초기화해서 각 내장객체에 값을 넣어주자.

- forward로 보내도되지만 이미 객체에 저장되있어서 페이지만 넘겨줘도된다.

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List,com.data.model.vo.Animal" %>
    
<%
	List<Animal> list=(List)request.getAttribute("animals");
	String sessiondate=(String)session.getAttribute("loginId");
	String context=(String)application.getAttribute("contextData");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>내장객체 저장된 데이터 불러오기</h2>
	<h3>session : <%=sessiondate %></h3>
	<h3>context : <%=context %></h3>
	<%if(list!=null&&!list.isEmpty()){ 
		for(Animal a : list){%>
		<p><%=a %></p>
		<%}
		}%>

</body>
</html>
```

- getAttribute로 animals객체를 가져와서 List에저장해준다.
- 나머지도 똑같이 getAttribute로 불러와서 사용한다.



<br/>

# 5. include 

- include 태그 이용하기
- include태그는 다른 jsp내용을 합쳐서 출력하는것

- 보통페이지를 반열할때 사용(header, footer,aside)
- 여기서 header,footer를 공통으로 사용하는 페이지들이많을거다
- 그렇다면 header이 변경될때마다 모든페이지에 가서  header을 수정하려면 엄청난 시간이든다.
- 그래서 header 랑 footer를 따로만들어서 main(aside)에 inclued를 해서 합쳐서 사용할수가있다.



<br/>



## header

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String headerData="header선언데이터";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src=""></script>
<style>
	header>nav>ul{
		display:flex;
		list-style: none;
		justify-content: space-between;
	}
	li>a{
		font-size: 30px;
		font-weight: bolder;
		text-decoration: none;
		color: black;
	}
	section{
		height: 500px;
		width: 100%;
	}
</style>
</head>
<body></body>
	<header>
		<h1>sample header</h1>
		<nav>
			<ul>
				<li><a href="<%=request.getContextPath()%>">메인화면</a></li>
				<li><a href="">공지사항</a></li>
				<li><a href="<%=request.getContextPath()%>/views/board.jsp">게시판</a></li>
				<li><a href="">자료실</a></li>
				<li>추가메뉴</li>
			</ul>
		</nav>
	</header>
```





<br/>



## footer

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer>
	<h2>나의 홈페이지</h2>
</footer>

</body>
</html>

```



<br/>



## aside

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include태그를 이용해서 공용페이지 불러오기  -->
<%@ include file="/views/common/header.jsp" %>
	<section>
		<h2>본문내용</h2>
		<p><%=headerData %></p>
	</section>
<%@ include file="/views/common/footer.jsp" %>	
```

- 헤더와 푸터를 include를 해서 공통적인 페이지를 만들어낼수가있다.

<br/>



# 6. page

- page태그 속성알아보자
- import : 외부패키지에 있는 클래스를 이용할때 import해줘야한다. 
  - ""안에 작성, 여러클래스를 호출할때 ,로 구분한다.
- errorPage : 페이지에서 에러가 발생했을때(500) 연결될 페이지지정할때 사용
- isErrorPage : 에러를 출력하는 페이지에 설정, 설정하면 exception객체를 이용할수 있다.
- session : 세션객체를 자동생성할지 생성하지 않을지 결정



<br/>



## import

- jsp의 외부 파일을 가져올때 임포트를 해야할경우가 있는데
- 그럴때 맨상단에 적는다

```jsp
<%@page import="java.awt.Label"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.awt.Label"%>
```



- 위에 방식처럼 따로 만들어서 해도되고 이어서 작성해도된다.



<br/>



##  error

- 우리가 에러가 발생했을경우
- 그에러에따라 어느페이지로 이동시킬지 정할수가있다.

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error/500error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = null;
	name.length();
	%>

</body>
</html>
```

- 이렇게 먼저 널포인트에러가 뜨게만든다.
- 그런후  errorPage="error/500error.jsp" 선언해서 에러가방생했을때 나올 페이지를 적어준다.



```jsp
<display-name>05_jsp</display-name>
  <!-- 에러페이지 등록하기  -->
  <error-page>
  	<!-- <error-code>500</error-code> -->
  	</exception-type>java.lang.NullPointerException</exception-type>
  	<location>/views/error/500error.jsp</location>
  </error-page>
```

- xml에 에러 타입을 정하고
- 그에러타입이 발생했을때 이동할페이지를 로케이션에 적어준다.





```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:red">500에러발생</h3>
<p><%=exception.getMessage() %></p>

</body>
</html>
```

- 그리고 에러페이지를 만들어주면 에러가발생했을때 페이지이동을 시켜줄수가있다.



<br/>



## 나만의에러 발생

- 에러가 발생했을 나만의 에러 이름을 정할수도있다.
- 서블릿을 이용한다.
- 먼저 xml부터 수정하자

```jsp
<display-name>05_jsp</display-name>
  <!-- 에러페이지 등록하기  -->
  <error-page>
  	<!-- <error-code>500</error-code> -->
  	<exception-type>com.data.common.exception.MyException</exception-type>
  	<location>/views/error/500error.jsp</location>
  </error-page>
</web-app>
```

- 이렇게 패키지이름부터 전부다 경로를 적어준다.

<br/>



- 그후 서블릿에 나만의예외를 만든후 throw를해준다.

```jsp
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=null;

		throw new MyException("나의 예외발생");
	}

```



- 그후 RuntimeException 상속받아서 클래스만들어서 받아온 예외를 넣어준다.

```java
package com.data.common.exception;

public class MyException extends RuntimeException{
	
	public MyException(String msg) {
		super(msg);
	}

}

```

- 이렇게 하면 자기가만든 에러페이지가 만들어진다.

<br/>



