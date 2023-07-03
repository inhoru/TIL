## :bookmark:목차
1. [표준 액션 태그](#1-표준-액션-태그)<br/>



<br/>



## JSP Action Tag

- \<jsp:태그명>으로 표현한다.
-  페이지와 페이지사이의 제어 이동이나 자바빈(좁은 의미)등을 사용하는데 이용된다
-  Action태그의 각 속성값에는 표현식을 이용해 값을 설정 할 수도 있다. 단,지시어에는 불가
-   <%@ include file="<%=pageName%>" %> [x]
-   반드시 종료태그를 사용해야 함



<br/>

![image](https://github.com/inhoru/TIL/assets/126074577/a8a97a26-3808-4049-8f68-50fc51d4a4a9)






<br/>

# 1. 표준 액션 태그

![image](https://github.com/inhoru/TIL/assets/126074577/ba7729e1-db71-4cf1-87e8-86e3751a98f7)


 

<br/>



## jsp :include

- <%@ include file=“파일 명” %>과 쓰임이 동일하나
- jsp파일이 java파일로 변환될 때 삽입되는 <%@ include %>와는 달리
- jsp파일이 java파일로 바뀌고 컴파일이 완료되어 런타임 시 삽입



```jsp
//헤더
<h2><%=request.getParameter("title") %> 페이지입니다.</h2>
<h3>해더내용을 출력하자</h3>

//헤더를 불러올 jsp
<jsp:include page="/views/common/header.jsp" >
	<jsp:param name="title" value="메인화면"/>
</jsp:include> 

```

- 우리가알던 include랑 비슷하다
- jsp :param 을통해 헤더의 내용을 바꿀수가있다.



<br/>



## jsp:forward

- 하나의 JSP페이지에서 다른 JSP페이지로 요청 처리를 전달할 때 사용
- 전달하는 페이지에서 request, response객체가 같이 전달되며URL은 변경되지 않음
- 현재 페이지 접근 시 특정 페이지로 이동 (request.forward() 와 동일하다) 



```jsp
//현재페이지에서 board.jsp로 forward
<jsp:include page="/views/common/header.jsp" >
	<jsp:param name="title" value="메인화면"/>
</jsp:include> 
<section>
	<h3>본문내용을 출력하자...</h3>
	<%-- <p>접속한 회원 : <%=userId %></p> --%>
</section>
	 <jsp:forward page="/views/board.jsp" /> 
</body>
</html>

// board.jsp


<jsp:include page="/views/common/header.jsp">
	<jsp:param name="title" value="board"></jsp:param>
</jsp:include>
<section>
	<h2>게시글 내용</h2>
</section>
</body>
</html>
```



- 현제페이지를 들어가면 board.jsp로 이동한다 



<br/>









