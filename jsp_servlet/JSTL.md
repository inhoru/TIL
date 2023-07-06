## :bookmark:목차

1. [Core Tags](#1-Core-Tags)<br/>
2. [조건문](#2-조건문)<br/>
3. [반복문](#3-반복문)<br/>
4. [forTokens](#4-forTokens)<br/>
5. [그외 코어태그 활용](#5-그외-코어태그-활용)<br/>
6. [fmt](#6-fmt)<br/>
7. [date](#7-date)<br/>
8. [Function](#8-Function)<br/>





<br/>



## JSTL

- JSP Standard Tag Library의 약자로 JSP에서 사용하는 커스텀 태그공통으로 
- 사용하는 코드의 집합을 사용하기 쉽게 태그화 하여표준으로 제공한 것을 말함

- 별도의 라이브러리 설치 필요라이브러리 선언에 맞는 접두어가 붙음

- https://tomcat.apache.org/download-taglibs.cgi 
- jar파일을 다운후 사용가능하다.

![image](https://github.com/inhoru/TIL/assets/126074577/09a421af-92d0-4b7a-b631-b16aef9023ee)


<br/>



## JSTL태그 종류

![image](https://github.com/inhoru/TIL/assets/126074577/7fd3b1a2-028c-4777-878b-8023bda1cb28)


- Core , Formattiong ,Function 을 사용하고 나머지는 사용하지않는다.



<br/>



# 1. Core Tags

- 변수를 선언하고 나서 그 변수에 초기 값 대입
-  자바에서 변수를 선언하는 방식과 비슷
-  Java 변수 선언 방식 : int num = 100; 
- 변수 선언 방식 : <c:set var=“num” value=“100” />

- ${num} * 에서 선언한 변수는 EL 식 안에서 사용 가능하다
- c:out태그 : value속성에 있는 값을 페이지에 출력할 때 사용하는 태그
- c:set태그 : 내장객체영역에 데이터를 key value형식으로 저장할때 사용하는 태그

<br/>

## set

- var : key값(변수명)
- value : key에 저장될 값/ EL표현식, 리터럴 사용
- scope : 변수가 선언될 내장객체를 지정, request, session, application

```jsp
//변수
<c:set var="comment" value="점심 맛있게 먹었나요?"/>
//절대경로 
<c:set var="path" value="${pageContext.request.contextPath }"/>

<p>${comment }</p>
<p>절대경로 : ${path }</p>

<c:set var="test" value="requestData" scope="request"/>
<c:set var="test" value="sessionData" scope="session"/>
<c:set var="test" value="applicationData" scope="application"/>

<p>${test }</p>
<p>${sessionScope.test }</p>
<p>${applicationScope.test }</p>

//출력결과
점심 맛있게 먹었나요?

절대경로 : /09_EL_JSTL

requestData

sessionData

applicationData

```

<br/>



## out

- c:out태그 속성

- value : 출력될 데이터, EL표현식, 리터럴을 사용

- default : 출력될 데이터가 없을때 대체로 출력하는 값

- escapeXml : value속성에 태그형식으로 작성했을때 태그로 해석할지 여부를 선택



```jsp
<p><c:out value="점심은 뭐드셨나요?"></c:out>
<p><c:out value="${path }"></c:out>
    
//출력결과
 점심은 뭐드셨나요?

09_EL_JSTL
```

- 여기서 한가지 의문점이 들텐데
- 그냥 EL 방식으로 출력하는거랑 같은데 뭐가다른지? 라는의문이 들텐데
- 보안상에서 out를 사용해서 출력하는게 좋다

```jsp
<c:set value="<script>location.assign('http://www.naver.com');</script>" var="testData"/>
 <div>${testData }</div> 
```

- 위에 방식대로EL로 출력하면 바로 사이트로 이동하기때문에
- 피싱사이트에 위험에노출된다.

```jsp
<c:set value="<script>location.assign('http://www.naver.com');</script>" var="testData"/>
<!-- xml을 이용해서 스크립트문이왓을때 이동시킬지 말지 정할수가있다. -->
<div><c:out value="${testData }" escapeXml="true"/></div>
<div><c:out value="${testData }" escapeXml="false"/></div>
```



- xml을 이용해서 true면 text
- false면 html를 출력한다.



<br/>



## default 

- out의 값이 null일때 default 을 이용해서 값을 null대신 출력해줄수있다.

```jsp
<p>${test11==null?"없음":test11 }</p>
<c:set value="있는값" var="test11"/>
<p><c:out value="${test11 }" default="없음"/></p>

//출력결과
없음
```



<br/>



## url

- 링크되는 주소값 데이터를 저장하는 태그  c:set

```jsp
<c:url var="cesearch" value="http://search.naver.com/search.naver">
<c:param name="query" value="김찬은"/>
</c:url>
<a href="<c:out value='${cesearch}'/>">검색</a>

```



<br/>



# 2. 조건문

- c : if태그 이용하기
- 자바에서 if문을 사용한것과 동일하다.
- test : 조건식 => true, false EL표현식으로 작성 var : 조건식에 결과를 저장하는 변수

<br/>

```jsp
<c:set var="su" value="10" />
<c:set var="su2" value="20" />
<!-- c:if는 test가 트루일때만 그사이에있는 것들이 실행이된다 -->
<c:if test="${su<su2 }">
    <p>
        <c:out value="${su }" />
        는
        <c:out value="${su2 }" />
        보다 작다
    </p>
    <c:if test="${su<15 }">
        <p>우와재미있다.</p>
    </c:if>
</c:if>

//출력결과
10 는 20 보다 작다

우와재미있다.
```



<br/>

- 리스트값을 이용해서도 if문을 사용해서 출력해줄수있다.

```jsp
<%
	List<String> names = List.of("유지민", "조장중,", "하지현", "검친아", "홍성우");
	request.setAttribute("names", names);
	%>
	<c:if test="${empty names }">
		<p>이름이 저장되지 않았습니다</p>
	</c:if>
	<c:if test="${not empty names }">
		<p>이름이 저장되었습니다.</p>
	</c:if>

	<c:if test="${empty names }" var="result">
	</c:if>
	<p>
		<c:if test="${result }">//false
			<h1>우하하하</h1>
		</c:if>
	</p>

//출력결과
이름이 저장되었습니다.
```



<br/>



## c:choose

- java에서 swtich문을 사용하는것과 비슷, if~else if~else

```jsp
	<c:when test="${su>10 }">
			<p>10보다 크다</p>
		</c:when>
		<c:when test="${su>5 }">
			<p>5보다 크다</p>
		</c:when>
		<c:otherwise>
			<p>그냥수다</p>
		</c:otherwise>
	</c:choose>

//출력결과
5보다 크다
```

<br/>



# 3. 반복문

- c:forEach 태그를 이용

- 기본반복문활용 : i을 순차적으로 출력하는 방법

- 리스트, 배열에 저장된 데이터를 출력(foreach) 등이있다.

  

  

<br/>



## c:forEach태그

- begin : 시작번호
- end : 끝번호
- step : 간격
- var : 변경되는 값을 저장하는 변수
- items : 배열, 리스트
- varStatus : 반복문의 정보를 가지고 있는 객체(index,반복횟수 정보제공)



- 기본반복문을 실행

```jsp
<p>1~10까지 출력하기</p>
	<div>
		<c:forEach begin="1" end="10" step="1" var="i">
			<p>
				<c:out value="${i }" />
			</p>
		</c:forEach>
		<c:forEach begin="1" end="6" step="1" var="i">
			<h ${i }>하하하하하하</h${i }>
		</c:forEach>
	</div>
//출력결과
1

2

3

4

5

6

7

8

9

10

하하하하하하 하하하하하하 하하하하하하 하하하하하하 하하하하하하 하하하하하하
```



<br/>



## 리스트 배열에 저장된 데이터 반복

- 리스트나 배열에 저장된 데이터를 반복할때 items와 varStatus 를이용해서
- 데이터를 반복한다.,



```jsp
<c:forEach var="name" items="${names }" varStatus="vs">
			<li>${vs.first}${vs.last}${vs.index} ${vs.count} ${name }</li>
		</c:forEach>
//출력결과
truefalse0 1 유지승
falsefalse1 2 조조조,
falsefalse2 3 하아니
falsefalse3 4 디니다
falsetrue4 5 홍히지
```



- vs.first 는 배열의첫번째 인덱스
- vs.last 배열의 마지막 인덱스
- vs.count 인덱스의 번호를 나타낸다.



<br/>

## 객체를 가져와서 리스트출력

```jsp
<%
	List<Snack> snack = List.of(Snack.builder().type("초콜렛").name("투유").price(1200).weight(200).build(),
			Snack.builder().type("젤리").name("마이구미").price(1300).weight(60).build(),
			Snack.builder().type("아이스크림").name("뿅따").price(1500).weight(120).build(),
			Snack.builder().type("캔디").name("이클립스").price(2500).weight(30).build(),
			Snack.builder().type("과자").name("맛동산").price(2400).weight(100).build());
	request.setAttribute("snacks", snack);
	%>
	<div>
		<h3>과자현황</h3>
		<table>
			<tr>
				<th>종류</th>
				<th>이름</th>
				<th>가격</th>
				<th>무게</th>
			</tr>
			<c:if test="${empty snacks }">
				<tr>
					<td colspan="5">검색된 과자가 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty snacks }">
				<c:forEach var="s" items="${snacks }" varStatus="vs">
					<c:if test="${s.price>=2000 }">
						<tr
							style="background-color:${vs.first||vs.last?'magenta':'lightgray'}">
							<td><c:out value="${s.type }" /></td>
							<td><c:out value="${s.name }" /></td>
							<td><c:out value="${s.price }" /></td>
							<td><c:out value="${s.weight }" /></td>
							<td><c:out value="0" /></td>
						</tr>
					</c:if>
				</c:forEach>
			</c:if>
		</table>
	</div>
//출력결과

종류	이름	가격	무게
캔디	이클립스2500 30. 00
과자	맛동산	2400 100. 00


```

- 우리가 jsp로 반복문을 돌린거보다 훨씬 간단하게 사용할수있다.



<br/>



# 4. forTokens

- 문자열에 포함된 구분자를 통해 토큰을 분리해 반복 처리

- items속성에는 토큰을 포함하는 문자열을 지정하고

- delims속성에는 토큰을 분리하는데 사용할 구획 문자 기술

- var : 분할된값이 저장되는 변수

- items : 분할할 대상이 되는 문자열

- delims : 기준이되는 기호

  

```jsp
<c:forTokens var="h" items="운동,여행,코딩,게임" delims=",">
		<p>${h }</p>
		
	</c:forTokens>


//출력결과
운동

여행

코딩

게임
```



<br/>

# 5. 그외 코어태그 활용

## c:import태그



- 다른페이지를 불러와 내용을 변수에 저장하는 태그

```jsp
<c:import url="/views/common/header.jsp" var="header1">
		<c:param name="title" value="import" />
	</c:import>
	<div>${header1 }</div>

//출려결과
import 페이지입니다.
해더내용을 출력하자
```



<br/>



## c:catch태그

- try catch와같은 기능

```jsp
	<%
		String name=null;
	%>
	<c:catch var="e">
	<%=name.length() %>
	</c:catch>
	<c:out value="${e }"/>

```



<br/>



## 6. fmt

- 메시지 형식이나 숫자, 날짜 형식과 관련된 포맷 방식 제공
- 표현하고자 하는 숫자의 포맷을 통화 기호, ‘,’ 표시, % 표시 등원하는 쓰임에 맞게 지정 가능하다.

<br/>



##  숫자표현

- 기본fmt 태그 : **fmt:formatNumber** value="" 를 이용해서 출력할수있다.
- 숫자단위 쉼표를 처리하는 속성 : groupingUse="true/false"

```jsp
<fmt:formatNumber value="${numtest }"/>원
<fmt:formatNumber value="${numtest }" groupingUsed="true"/>
<fmt:formatNumber value="${numtest }" groupingUsed="flase"/>

//출력결과
123,456,012원
true: 123,456,012
false:123456012
```

<br/>

## 숫자를 화폐표시하기

- type속성을 currency로설정

```jsp
<p>원화로 표시하기 : <fmt:formatNumber value="${numtest1 }" type="currency"/>
<p>원하는 화폐기호표시 : <fmt:formatNumber value="${numtest1 }" type="currency" currencySymbol="^.~"/>
<fmt:setLocale value="fr_FR"/>
<p>우루과이 원화로 표시하기 : <fmt:formatNumber value="${numtest1 }" type="currency"/>
<p>현재로케일 확인${pageContext.request.locale }</p>

//출력결과
원화로 표시하기 : ₩19,883,000

원하는 화폐기호표시 : ^.~19,883,000

우루과이 원화로 표시하기 : ₩19,883,000

현재로케일 확인ko_KR
```



<br/>



## 퍼센트 표시하기

- \>소수점으로 표시 1-> 100%, 0->0%

```jsp
<p>numtest2 : ${numtest2 }</p>
<p>퍼센트 : <fmt:formatNumber value="${numtest2 }" type="percent"/></p>
<p>퍼센트 : <fmt:formatNumber value="0.5" type="percent"/></p>
<p>퍼센트 : <fmt:formatNumber value="0.25" type="percent"/></p>

//출력결과
numtest2 : 1

퍼센트 : 100%

퍼센트 : 50%

퍼센트 : 25%
```



<br/>



## 패턴으로 숫자표시

- 자리수에 맞춰서 특정문구를 출력한다.
- 0 : 지정한 자리에 수가 없으면 0으로 표시
- \# : 지정한 자리에 수가 없으면 표시를 생략



```jsp
<p>0 : ${numtest3 } -> <fmt:formatNumber value="${numtest3 }" pattern="000,000,000"/></p>
	<p># : ${numtest3 } -> <fmt:formatNumber value="${numtest3 }" pattern="###,###,###"/></p>
	<p>소수점 : ${numtest3 } -> <fmt:formatNumber value="${numtest3 }" pattern="000,000.000000"/></p>
	<p>소수점 : ${numtest3 } -> <fmt:formatNumber value="${numtest3 }" pattern="###,####.######"/></p>

//출력결과
0 : 1234.567 -> 000,001,235

# : 1234.567 -> 1,235

소수점 : 1234.567 -> 001,234.567000

소수점 : 1234.567 -> 1234.567
```

<br/>



## 소수점자리수 설정

- minFractionDigits : 최소소수점자리
- maxFractionDigits : 최대소수점자리

```jsp
<h3><fmt:formatNumber value="123.123" minFractionDigits="2"/></h3>
<h3><fmt:formatNumber value="123.126" maxFractionDigits="2"/></h3>

//출력결과
123.123
123.13
```

<br/>

- max값을 넘어가면 자동으로 반올림이된다.



<br/>



# 7. date

- 날짜데이터도 JSTL로 표현할수가있다.
- Date객체는 jsp로 선언해야한다

```jsp
	<c:set var="today" value="<%=new Date()%>" />
	<h3>
		<c:out value="${today }" />
	</h3>
```



- type: date, time, both값을 설정

- date: 날짜만 출력 년, 월, 일 출력 

- time: 시간만 출력 시, 분, 초 출력

- both: 날짜와 시간을 모두 출력 년,월,일,시,분,초

- dateStyle: 날짜를 출력하는 방식(default, short,long,full)

  

  

  

```jsp
	<h3>
		date :
		<fmt:formatDate value="${today }" type="date" dateStyle="default" />
	</h3>
	<h3>
		short :
		<fmt:formatDate value="${today }" type="date" dateStyle="short" />
	</h3>
	<h3>
		long :
		<fmt:formatDate value="${today }" type="date" dateStyle="long" />
	</h3>
	<h3>
		full :
		<fmt:formatDate value="${today }" type="date" dateStyle="full" />
	</h3>

	<h3>
		medium :
		<fmt:formatDate value="${today }" type="time" timeStyle="medium" />
	</h3>
	<h3>
		short :
		<fmt:formatDate value="${today }" type="time" timeStyle="short" />
	</h3>
	<h3>
		long :
		<fmt:formatDate value="${today }" type="time" timeStyle="long" />
	</h3>
	<h3>
		full :
		<fmt:formatDate value="${today }" type="time" timeStyle="full" />
	</h3>

	<h3>
		두스타일적용하기 :
		<fmt:formatDate value="${today }" type="both" dateStyle="full"
			timeStyle="short" />
	</h3>

//출력결과
date : 2023. 7. 3.
short : 23. 7. 3.
long : 2023년 7월 3일
full : 2023년 7월 3일 월요일
medium : 오후 11:46:01
short : 오후 11:46
long : 오후 11시 46분 1초 KST
full : 오후 11시 46분 1초 대한민국 표준시
두스타일적용하기 : 2023년 7월 3일 월요일 오후 11:46
```

<br/>



## 패턴으로 스타일 커스텀마이징

- yy(년) MM(월) dd(일) hh(시간) mm(분) ss(초) SSS()

```jsp
<h3>
		<fmt:formatDate value="${today }" type="date" pattern="yyyy/MM/dd" />
	</h3>
	<h3>
		<fmt:formatDate value="${today }" type="time" pattern="hh:mm:ss" />
	</h3>
	<h3>
		<fmt:formatDate value="${today }" type="both"
			pattern="yyyy-MM-dd (E) hh:mm:ss" />
	</h3>

//출력결과
2023/07/03
11:46:01
2023-07-03 (월) 11:46:01
```





<br/>



## 시간기준 설정

- 로케일설정은 바꾸면 나라에 맞는 형식으로 날짜를 출력 해준다.



```jsp
<h3>
		<fmt:timeZone value="GMT">
			<fmt:formatDate value="${today }" type="time" />
		</fmt:timeZone>
		<fmt:timeZone value="GMT+9">
			<fmt:formatDate value="${today }" type="time" />
		</fmt:timeZone>
	</h3>
	<h3>
		<fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/>
	</h3>
	<fmt:setLocale value="zh_CN"/>
	<h3>
		<fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/>
	</h3>
		<fmt:setLocale value="fr_FR"/>
	<h3>
		<fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/>
	</h3>

//출력결과
오후 2:46:01 오후 11:46:01
2023년 7월 3일 월요일 오후 11시 46분 1초 대한민국 표준시
2023年7月3日星期一 韩国标准时间 下午11:46:01
lundi 3 juillet 2023 à 23:46:01 heure normale de la Corée
```



<br/>



# 8. Function

- 문자열 처리에 관한 메소드들을 EL형식에서 사용할 수 있게 하는 라이브러리
- 다른 JSTL태그들과는 다르게 ${fn:메소드 명(문자열)}의 형식으로
-  EL태그에직접 대입하여 사용



```jsp
	<c:set var="data" value="How Are you? I am Fine"/>
	<h3><c:out value="${data }"/></h3>
	<h3><c:out value="${fn:toUpperCase(data) }"/></h3>
	<h3><c:out value="${fn:toLowerCase(data) }"/></h3>
	<h3><c:out value="${fn:replace(data,'Fine','Bad') }"/></h3>
	<h3><c:out value="${fn:contains(data,'Fine')?'깝치지마라':'슬프네요' }"/></h3>

//출력결과
How Are you? I am Fine
HOW ARE YOU? I AM FINE
how are you? i am fine
How Are you? I am Bad
깝치지마라
```

<br/>





