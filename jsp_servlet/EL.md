## :bookmark:목차

1. [리터럴값 출력](#1-리터럴값-출력)<br/>
2. [EL연산자 활용](#2-EL연산자-활용)<br/>
3. [메소드호출](#3-메소드호출)<br/>
4. [객체탐색](#4-객체탐색)<br/>
5. [논리연산](#5-논리연산)<br/>
6. [servlet와연동해서 출력](#6-servlet와연동해서-출력)<br/>
7. [파라미터값 출력](#7-파라미터값-출력)<br/>
8. [el에서 추가데이터 출력](#8-el에서-추가데이터-출력)<br/>







<br/>



## EL

- EL <%-- ${ } --%> 로 공용객체에 저장된 데이터를 페이지에 출력
- servlet에서 request, session에 setAttribute()메소드로 저장한 데이터를 자동으로 탐색해서 key값을 기준으로 데이터를 가져옴.
- getter메소드를 호출하지 않고 필드명을 작성하면 EL이 자동으로 getter호출해서 데이터를 출력해줌. 형변환을 하지 않아도 된다.

<br/>



# 1. 리터럴값 출력

- 코드를 ${ value } 형식으로 표현하여 작성



```jsp
<p><%="오랜만에 수업 너무 재미있다." %></p>
<p>${"우와 신기하다" }</p>
<p>나이는 ${19 }</p>

//출력결과
오랜만에 수업 너무 재미있다.

우와 신기하다

나이는 19

```



<br/>



## 내장객체(공용객체) 에 저장된 데이터 출력

- request,session,application(ServletContext)에 저장된 데이터를 출력한다.
- key값으로 출력을 할수가있다.

```jsp
<%
	request.setAttribute("name","강태풍");
	session.setAttribute("age", 19);
	application.setAttribute("test", "기본데이터");
	String email="yoo@yoo.com";
	request.setAttribute("email", email);
%>

<h3>${name }</h3>
<h3>${age }</h3>
<h3>${test }</h3>
<h3>${email }</h3>

//출력결과
강태풍
19
기본데이터
yoo@yoo.com
```

- String 의 변수를 바로 출력하면 출력이되질않는다
- 왜냐하면 key값 기준으로 데이터를 가져오기때문이다.



<br/>



# 2. EL연산자 활용

- EL에서도 연산자를 사용가능하다.
- 자바에서 했던 것과 많이 비슷하다.

```jsp
request.setAttribute("su", 19);
request.setAttribute("su2", 30);
request.setAttribute("su3", 30);
request.setAttribute("testData", "admin");

<h3>산술연산처리하기</h3>
<h4>+연산 : ${su+su2 }</h4>
<h4>-연산 : ${su-su2 }</h4>
<h4>*연산 : ${su*su2 }</h4>
<h4>/연산 : ${su/su2 }</h4>
<h4>%연산 : ${su%su2 }</h4>
<h4>복합산술연산 : ${(su%su2*2)/(3+100)*su3 }</h4>

//출력결과
+연산 : 49
-연산 : -11
*연산 : 570
/연산 : 0.6333333333333333
%연산 : 19
복합산술연산 : 11.067961165048544
```



<br/>



## 비교연산처리

- 비교연산자또한 가능하다.
- < > = 으로 가능하지만 EL만에 다른 연산자가존재한다.
- lt , gt ,le, ge , eq, ne 가존재한다
- 각각의뜻은 아래의 코드를 보자

```jsp
<h4>대소비교하기</h4>
<p>$lt; : ${su<su2 } ${su lt su2 }</p>
<p>$gt; : ${su>su2 } ${su gt su2 }</p>
<p>$le; : ${su<=su2 } ${su le su2 }</p>
<p>$ge; : ${su>=su2 } ${su ge su2 }</p>
<p>범위 논리연산 : ${su<20&&20<su2 }</p>

<h4>동등비교</h4>
<p>==: ${su==su2 } ${s3 eq s2 }</p>
<p>==: ${testData=="admin" } ${testData eq "admin" }</p>
<p>!=: ${su!=su2 } ${su ne su2 }</p>
<p>!=: ${testData != "userId" } ${testData ne "userId" }</p>

<p>논리연산 : ${testData=="admin" && su2>19}</p>

<h4>null값 확인하기</h4>
<p>== : ${testb==null } ${testData==null }</p>

<h4>삼항연산자 활용하기</h4>]
<p>${su>10?"10보다크다":"10보다작다." }</p>
<input type="checkbox" ${su>20?"checked":"" }>체크?
```

- lt : <
- gt : >
- le :  <=
- ge :  >=
- eq :  ==
- ne : !=



<br/>



# 3. 메소드호출



- 자바의 메소드를 호출해서 사용할수도있다.

```jsp
request.setAttribute("testData", "admin");

<p>${testData.length() }</p>
<p>${testData.charAt(0) }</p>
<p>${testData.contains("a")?"있다":"없다"}</p>

//출력결과
5

a

있다
```



<br/>



# 4. 객체탐색

- request,session,application에 저장된 객체의 데이터 를 가져올수가있다.
- 저장된객체는 key값으로 불러와서 처리가 가능, 
- 필드에 있는 값을 불러올때는 getter호출하지않고 필드명으로 불러온다.

```jsp
Snack s=Snack.builder().type("초콜렛").name("M&N").price(1000).weight(50).build();
Snack s2=Snack.builder().type("사탕").name("츄파츕스").price(300).weight(10).build();
Snack s3=Snack.builder().type("젤리").name("하리보").price(2000).weight(60).build();
request.setAttribute("s", s);
request.setAttribute("s2", s2);
request.setAttribute("s3", s3);
request.setAttribute("snacks",List.of(s,s2,s3));
request.setAttribute("map", Map.of("s",s,"s2",s2));

<p>저장된 s불러오기 ${s }</p>
<p>저장된 s 필드값 불러오기 ${s2.type } ${s2.name } ${s2.price }</p>
<p>저장된 s 필드값 불러오기 ${s.type } ${s.name } ${s.price*2 }</p>

//출력결과
저장된 s불러오기 Snack(type=초콜렛, name=M&N, price=1000, weight=50.0)

저장된 s 필드값 불러오기 사탕 츄파츕스 300

저장된 s 필드값 불러오기 초콜렛 M&N 2000
```



<br/>



##  collectgion으로 저장된 객체 출력



- List로 저장된 객체를 가져올때 객체.get(인덱스번호)로 그값을 가져올수가있고
- (객체.get(인덱스번호).필드명) 으로 필드를 가져올수도있다.
- Map 도마찬가지로 키값을통해가져오고 그뒤에 .필드명으로 필드를가져올수있다.

```jsp
Snack s=Snack.builder().type("초콜렛").name("M&N").price(1000).weight(50).build();
Snack s2=Snack.builder().type("사탕").name("츄파츕스").price(300).weight(10).build();
Snack s3=Snack.builder().type("젤리").name("하리보").price(2000).weight(60).build();

request.setAttribute("snacks",List.of(s,s2,s3));

<p>${snacks }</p>
<p>${snacks.get(0).type } ${snacks.get(0).name }</p>
<p>${snacks.get(1).type } ${snacks.get(1).name }</p>

<p>${map } ${map.s.price } ${map.s2.price }</p>

//출력결과
[Snack(type=초콜렛, name=M&N, price=1000, weight=50.0), Snack(type=사탕, name=츄파츕스, price=300, weight=10.0), Snack(type=젤리, name=하리보, price=2000, weight=60.0)]

초콜렛 M&N

사탕 츄파츕스

{s=Snack(type=초콜렛, name=M&N, price=1000, weight=50.0), s2=Snack(type=사탕, name=츄파츕스, price=300, weight=10.0)} 1000 300

```

<br/>



## collection이 빈값을 확인하기

- isEmpty() 로 빈값을 확인할수도있지만

- empty 와 not empty로도 빈값을 확인할수가있다.

  

  

```jsp
<p>${snacks.isEmpty()}</p>
<p>${empty snacks} ${not empty snacks }</p>
```



<br/>



# 5. 논리연산

- 논리연산도 사용이가능한데 기존에사용하던 && , || 뿐만아니라
- and, or 로도 사용이가능하다.



```jsp
<p>${snacks.get(0).type eq "초콜렛" and snacks.get(0).price>5000 }</p>
<p>${snacks.get(0).type eq "초콜렛" or snacks.get(0).price>5000 }</p>

```



<br/>



# 6. servlet와연동해서 출력

- 서버에서 전송한데이터로 출력을할수도있다.

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Snack s=Snack.builder().type("초콜렛").name("M&N").price(1000).weight(50).build();
		Snack s2=Snack.builder().type("사탕").name("츄파츕스").price(300).weight(10).build();
		Snack s3=Snack.builder().type("젤리").name("하리보").price(2000).weight(60).build();
		Snack s4=Snack.builder().type("과자").name("꼬북칩").price(2000).weight(60).build();
		List<Snack> list=List.of(s,s2,s3,s4);
		request.setAttribute("snacks", list);
		
		request.setAttribute("snack", "request과자");
		
		HttpSession session=request.getSession();
		session.setAttribute("snack", "맛있는 과자");
		
		ServletContext context=getServletContext();
		context.setAttribute("snack", "Context영역에 과자");
		
		request.getRequestDispatcher("/views/dataTest.jsp").forward(request, response);
		
	}
```



- 서블릿에서 각각 List ,request,session,cotext,로 데이터를보냇다
- List로보낸 값은 아래처럼 출력을 해준다.



```jsp
<h4>${snacks.get(0).type }${snacks.get(0).name }</h4>
<h4>${snacks.get(1).type }${snacks.get(1).name }</h4>
<h4>${snacks.get(2).type }${snacks.get(2).name }</h4>
<h4>${snacks.get(3).type }${snacks.get(3).name }</h4>

//출력결과
초콜렛M&N
사탕츄파츕스
젤리하리보
과자꼬북칩
```

<br/>



- 같은 키값으로 보냇을때 El에서 내장객체의 데이터를 가져올때 작은범위부터 큰범위로 탐색한다.
- request-> session -> servletContext
- 중복된 키값이 있을때 특정 영역에서 데이터를 찾고 싶으면 EL이제공하는 내장객체를 이용한다.

```jsp
<p>
requestScope : request영역에서만 key검색<br/>
sessionScope : session영역에서만 key검색</br>
applicationScope : ServletContext영역에서만 key검색</br>
</p>
<h4>${requestScope.snack }</h4>
<h4>${sessionScope.snack }</h4>
<h4>${applicationScope.snack }</h4>
<h4>${requestScope.snacks.get(0).name }</h4>

//출력결과
request과자
맛있는 과자
Context영역에 과자
```



<br/>

# 7. 파라미터값 출력

- 별도의 EL객체를 이용해서 출력 -> param객체이용
- 파라미터값이 다수값인 경우 paramValues를 이용한다.

```jsp
<form action="${pageContext.request.contextPath }/dataTest.do">
	<input type="text" name="userId">
	<input type="password" name="password">
	<input type="checkbox" name="hobby" value="운동">운동
	<input type="checkbox" name="hobby" value="독서">독서
	<input type="checkbox" name="hobby" value="코딩">코딩
	<input type="checkbox" name="hobby" value="영화">영화
	<input type="checkbox" name="hobby" value="등산">등산
	<input type="submit" name="제출">
</form>


<h3>${param.userId } ${param.password }</h3>

<h3>${paramValues.hobby[0]}</h3>
<h3>${paramValues.hobby[1]}</h3>
<h3>${paramValues.hobby[2]}</h3>

//출력결과(운동 독서 코딩을 체크햇다는가정)
아이디
비밀번호
운동
독서
코딩

```

<br/>



# 8. el에서 추가데이터 출력

- 컨텍스트에 대한 정보  Cookie 정보 Header정보 등등 을 출력해줄수도있다.

```jsp
	<h2>컨텍스트에 대한 정보</h2>
	<h3>${pageContext.request.contextPath }</h3>
	<h3>${pageContext.request.requestURI }</h3>
	<h3>${pageContext.request.requestURL }</h3>

	<h2>Cookie 정보출력하기</h2>
	<h3>cookie : ${cookie }</h3>
	<h3>cookie : ${cookie.JSESSIONID.name }</h3>
	<h3>cookie : ${cookie.JSESSIONID.value }</h3>

	<h3>Header정보출력하기</h3>
	<h3>${header }</h3>
	<h3>${header["user-agent"] }</h3>
	<h3>${header.host }</h3>
	

```

<br/>
