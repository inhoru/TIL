# :bookmark: 목차

1. [태그](#1-태그)<br/>

2. [선언문 활용하기](#2-선언문-활용하기)<br/>

3. [스크립트릿이용하기](#3-스크립트릿이용하기)<br/>
4. [jsp내장객체](#4-jsp내장객체)<br/>
5. [지시자태그])#5-지시자태그)<br/>



<br/>



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
-  페이지(jsp)내에 다른 페이지(jsp)를 불러올때 사용하는 태그이다.
- taglib : jsp에 적용할외부라이브러리 등록(JSTL, springform)한다

```jsp
 <%-- <%@ 태그명 속성설정(속성명="속성값") %> --%>
```

<br/>

## 선언문

- 자바클래스 구현부에 작성하는 코드 클래스 중괄호부분에 들어갈 코드를 작성할때 사용한다
-  메소드선언, 멤버변수선언 이용할때 사용 거의사용하지않는다.
-  조건문, 반복문 등은 사용이 불가능하다.

```jsp
 <%-- <%! 자바코드 %> --%>
```



<br/>



## 스트립트릿

- 자바의 메소드내부에 들어갈 코드 작성할때 사용한다.
-  이코드를 가장많이사용한다.
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



# 2. 선언문 활용하기

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
-  HttpServletRequest : request 
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

# 5. 지시자태그



