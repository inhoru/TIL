# 🔖 목차
1. [데이터 전송](#1-데이터-전송)<br/>
2.
3.


<br/>

## servlet
- Server + Applet의 합성어로 JAVA언어를 이용하여 사용자의 요청을 받아처리하고 
- 그 결과를 다시 사용자에게 전송하는 역할의 Class파일을 말함
- 즉 웹에서 동적인 페이지를 java로 구현한 서버 측 프로그램

<br/>

## 설계 규약

- 모든 서블릿은 javax.servlet.Servlet 인터페이스를 상속 받아 구현
- 서블릿 구현 시 Servlet 인터페이스와 ServletConfig 인터페이스를javax.servlet.GenericServlet에 구현
- HTTP프로토콜을 사용하는 서블릿은 javax.servlet.http.HttpServlet 클래스는 javax.servlet.GenericServlet을 상속한 클래스로서블릿은 HttpServlet클래스를 상속 받음
- 서블릿 Exception처리를 하기 위해서는 javax.servlet.ServletException을 상속 받아야 함

<br/>


## 배포 서술자
![배포서술자](https://user-images.githubusercontent.com/126074577/239744884-55b7335d-3da2-4b2e-9d54-1212d59f374f.png)
![배포서술자종류](https://user-images.githubusercontent.com/126074577/239744879-24acc360-a3b1-4258-a3eb-3c9343eae51c.png)

<br/>


# 1. 데이터 전송
- 데이터 전송 방식은 두가지가있다.
- 우리가 form태그를 배울때 사용햇던 get 방식과 post방식이다.

<br/>

- get
  - URL창에 “?” 뒤에 데이터를 입력하는 방법(쿼리스트링)
  - 데이터가 여러 개일 경우 &로 묶어서 보냄
  - 데이터 검색에 많이 사용하고 데이터 크기에 한계가 있으며 보안 취약하다는 단점이있다.
- post
  - BODY에 내용을 보내는 방식으로 데이터 크기에 제한이 없고보안이 뛰어남-
  - Servlet이 두 방식 중 하나로 전달 받으면 해당하는 메소드 호출


- html의 <form>에서 method속성을 이용해 방식 결정(default : get)
	
	
  
  
## 서블릿만들기
  
  
- javax.servlet.http.HttpServlet클래스를 상속받음
- HttpSerlvet에 정의되어있는 메소드를 재정의
  - doGet () :  클라이언트가 get방식으로 요청한 내용을 처리하는 메소드
  - doPost () : 클라이언트가 post방식으로 요청한 내용을 처리하는 메소드
- 서버에서 요청을 받을 수 있게 등록해야한다. -> web.xml파일이용, @어노테이션이
  - 생성한 서블릿클래스는 서버에 등록
  - 서블릿을 실행할 주소를 매핑(연결)시켜준다.
  
  ```java
  public class BasicServletController extends HttpServlet{

	private static final long serialVersionUID = 5412475190290065154L;
	
	
	public BasicServletController() {
		
	}
	
	//throws 두개의 예외처리를 던져줘야한다.
	@Override
	public void  doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		System.out.println("서블릿의 doGet메소드가 실행됨");
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException{
		System.out.println("서블릿의 doPost메소드가 실행됨");
	}
  
  ```
  
  - 이런식으로 일반클래스를 서블릿 클래스로 만들어줄수가있다.
  - 반드시 HttpServlet 상속을 받아야한다.
  
  
  <br/>
  
## 생성한 서블릿 등록
  
  
- 서블릿을 생성햇다면 등록을해야한다.
- \<servlet>태그를 이용해서 생성한 서블릿클래스를 등록함
- \<servlet>태그의 자식으로 
- \<servlet-name> : 서버내에서의 서블릿클래스의 이름 등록
- \<servlet-class> : 클래스를 등록 * 패키지명까지 모두 작성
  

```jsp
<servlet>
    <servlet-name>basicservlet</servlet-name>
    <servlet-class>com.servlet.controller.BasicServletController</servlet-class>
</servlet>
```
  
<br/>

## 매핑
- 등록된 서블릿을 실행할 주소를매핑
- \<servlet-mapping>태그를 이용
- 자식태그로
- \<servlet-name> : 연결할 서블릿 이름
- \<url-pattern> : 매핑주소 *주소작성시에는 반드시 /로 시작

```jsp
<servlet-mapping>
    	<servlet-name>basicservlet</servlet-name>
    	<url-pattern>/basicrequest.do</url-pattern>
</servlet-mapping>	

```
	
- do. 은써도 되고 안써도된다.
	
	
<br/>
	
## 서블릿객체이용
- 이제 객체를 이용해보자
	
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿다루기</title>
</head>
<body>
	<h2>서블릿객체 이용하기</h2>
	<h4>클라이언트 요청응답하기</h4>
	<!--local/host:8080이 앞에 생략이되어있다.
	그래서 href에 /02_servletdata를 적는다. -->
	<h5><a href="/02_servletdata/basicrequest.do">서블릿으로 기본요청처리하기</a></h5>
	<p>
		<form action="/02_servletdata/basicrequest.do" method="post">
			<input type="submit" value="전송">
		</form>
	</p>
</body>
</html>
```
	
![tq](https://user-images.githubusercontent.com/126074577/239745668-f9b36b9f-147b-4cea-aab3-005dd4369d6f.png)

![tq1](https://user-images.githubusercontent.com/126074577/239745680-cfb9b7c7-c5e8-4b15-95d3-368996d0e19b.png)
	
<br/>

- a태그는 기본적으로 get방식으로 보낸다.
	
<br/>
	
# 2. HttpServletRequest
- 요청시 전달된 데이터 보관, 요청에 처리할수있는 내용을가진다.
- 예) 로그인할시 아이디와 비밀번호를 보냄-> 그데이터를 쪼개서 HttpServletRequest 저장한다.
- 내부적으로 서버에서 생성한 정보를 저장하는 기능도수행




## 데이터를 보내는 메소드
- getParameter(String) : 값하나를가져온다.()안에 키값을적는다. input태그라면 name 값를적는다.
- getParameterNames() : 클라이언트가 보낸 키값을 전체 가져올때 사용 
- getParameterValues(String) : 복수에값을 배열로가져올때 사용 
- getParameterMap() : Map객체로 가져온다.

<br/>

## 저장된값을 가져오거나 지울때 사용하는메소드

- setAttribute(String, object) : 키&벨류방식으로 저장 
- getAttribute(String) : set으로 저장된걸 get으로 가져온다.
- removeAttribute(String) : remove즉 삭제한다는 뜻


<br/>

## 요청온 내용의 인코딩방식을정함
- setCharacterEncoding(String) : 인코딩값의 맞춰서 조합을해준다 글씨가깨지지않기위해 사용
- getRequestDispatcher(String) : 컨테이너 내에서 request, response객체를 전송하여처리할 컨포넌트( jsp파일 등)를 불러오는 메소드


![매개변수객체](https://user-images.githubusercontent.com/126074577/239775815-43b4d88b-7c59-4601-b410-3fa171e8c597.png)


<br/>


## 클라이언트가 보낸 데이터 처리하기

- 클라이언트가 보낸 데이터는 HttpServletRequest객체를 이용해서 서버에서 가져올 수 있다.

<br/>

## 먼저 get방식으로 보낼 a태그와 form태그를 만든다.
```html
<h3>
	<a href="/02_servletdata/basicdata.do?testdata=test">
		querystring으로확인 </a>
</h3>
<form action="/02_servletdata/basicdata.do">
	<input type="text" name="testdata">
	<input type="submit" value="데이터전송">
</form>
```

<br/>


## 서블릿 클래스를 만들어준다.
- 클라이언트가 전송한 데이터 받아오기
- HttpServletRequest객체가 제공하는 메소드를 이용해서 받아올수있다.
- getParameter()메소드 -> 클라이언트가 보낸 데이터 한개를 받아온다.
- ()안에 키값을 넣는다. 그리고 벨류값을 가져온다. 

```java
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서블릿 실행");
		String data=req.getParameter("testdata");//무조건 타입은 String이다.
		System.out.println(data);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
```

<br/>

## 서블릿등록
- web.xml에 서블릿을 등록해준다.

```servlet
<servlet>
    	<servlet-name>basicdata</servlet-name>
    	<servlet-class>com.servlet.controller.BasicDataServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
    	<servlet-name>basicdata</servlet-name>
    	<url-pattern>/basicdata.do</url-pattern>
    </servlet-mapping>
```

<br/>



# 3. 어노테이션
- 서블릿을 등록할때 web.xml에 일일히 등록하고 맵핑하지않고
- 어노테이션을 이용하면 서블릿 클래스안에서 바로 등록할수가있다.
- 클래스 선언부에 @WebServlet어노테이션을 선언함
- @Webservlet어노테이션의 속성설정으로 urlpattern, name을 설정할 수 있다.
- 단 외부에서 가져온 서블릿을 사용할때는 web.xml에서 사용해야한다.

<br/>

## html파일
- html 파일을만든후 보낼주소를 정한다.

```html
<h3>당신의 개인취향테스트</h3>
	<p>당신의 취향을 테스트해봐요!</p>
	<form action="/02_servletdata/testperson.do">
		
```

<br/>

## 서블릿 클래스
- 이제 서블릿클래스를 만들건데
- 이곳에 어노테이션을 사용한다.
```java
@WebServlet(name = "paramdata", urlPatterns = {"/testperson.do"})
public class ParameterDataServlet extends HttpServlet {

	private static final long serialVersionUID = -7348993035964273633L;

	public ParameterDataServlet() {

	}
```

- 이런식으로 어노테이션을 선언하면 web.xml에 만들지않아도된다.



<br/>

# 4. 데이터가져오는 여러방법
- 가장많이쓰는 방법인 단일데이터가져오는 getParameter("key")메소드를이용한다.

<br/>

## html
```html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라이언트데이터 전송</title>
</head>
<body>
	<h3>당신의 개인취향테스트</h3>
	<p>당신의 취향을 테스트해봐요!</p>
	<form action="/02_servletdata/testperson.do">
		<ul>
			<li>
				<label>이름 <input type="text" name="name"></label>
			</li>
			<li>
				<label>나이 <input type="number" 
				min="0" name="age"></label>
			</li>
			<li>
				<label>키 <input type="text" name="height"></label>
			</li>
			<li>좋아하는색
				<label><input type="radio" name="color" value="red">빨강</label>
				<label><input type="radio" name="color" value="orange">주황</label>
				<label><input type="radio" name="color" value="yellow">노랑</label>
				<label><input type="radio" name="color" value="green">초록</label>
				<label><input type="radio" name="color" value="blue">파랑</label>
				<label><input type="radio" name="color" value="navy">남색</label>
			</li>
			<li>좋아하는 동물
				<label><input type="checkbox" name="animal" value="강아지">강아지</label>
				<label><input type="checkbox" name="animal" value="고양이">고양이</label>
				<label><input type="checkbox" name="animal" value="펭귄">펭귄</label>
				<label><input type="checkbox" name="animal" value="기린">기린</label>
				<label><input type="checkbox" name="animal" value="토끼">토끼</label>
				<label><input type="checkbox" name="animal" value="코끼리">코끼리</label>
			</li>
			<li>점심메뉴
				<select name="lunch">
					<option value="김치찌개">김치찌개</option>
					<option value="초밥">초밥</option>
					<option value="회">회</option>
					<option value="해물탕">해물탕</option>
					<option value="짬뽕">짬뽕</option>
				</select>
			</li>
			<li>
				<textarea cols="50" rows="10" name="info"></textarea>
			</li>
		</ul>
		<input type="submit" value="제출">
		<input type="reset" value="취소">
	</form>

</body>
</html>
```

<br/>

- 어노테이션을 이용한다.



```java
@WebServlet(name = "paramdata", urlPatterns = {"/testperson.do"})
public class ParameterDataServlet extends HttpServlet {

	private static final long serialVersionUID = -7348993035964273633L;

	public ParameterDataServlet() {

	}

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 클라이언트가 보낸 데이터 확인하기
		// 1. 단일데이터 가져오기
		// HttpServletRequest.getParameter("key")메소드를 이용한다.
		String name = req.getParameter("name");
		//Integer.parseInt 로 형변환을 한다. int로
		int age = Integer.parseInt(req.getParameter("age"));
		double height=Double.parseDouble(req.getParameter("height"));
		String color=req.getParameter("color");
		
		//다수의 데이터가있는건 이렇게 안된다.
		String animals=req.getParameter("animal");
		
		//클라이언트가 동일한 key로 다수의 값을 보낸데이터는
		//HttpServletRequset.getParameterValues() 메소드를 이용한다.
		//getParameterValues는 다수의 값을 String배열로 반환한다!
		String[] animals2=req.getParameterValues("animal");
		
		String lunch=req.getParameter("lunch");
		String info=req.getParameter("info");
		
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("키 : "+height);
		System.out.println("좋아하는 색 : "+color);
		System.out.println("좋아하는 동물 : "+animals);
		System.out.println("동물들....");
		Arrays.asList(animals2).stream().forEach(System.out::print);
//		.forEach(e->System.out.println(e)); 위랑 똑같다.
		System.out.println("점심메뉴 : "+lunch);
		System.out.println("소개 : "+info);
```
		
## 데이터를 입력하지않앗을때
- 데이터를 입력하지않고 데이터를 전송하면
- input을 값을 보내지않으면 공백으로 넘어간다.
- check박스나 radio는 null로 보내버린다.
- **정리하자면 key값이 의 데이터가없으면 에러가 발생하는게아니라 null값을 반환해준다.**


```java
String test =req.getParameter("test"); 
// 키값도 없다면 null을 반환한다.
String name = req.getParameter("name");
// 키값은 있지만 값을넣지않앗다면 공백으로 반환해준다.
```
		
<br/>

## 클라이언트가 보낸 데이터의 key를 모를때..
- 전송된 key값을 가져오는 방법
- HttpServletRequest.getParameterNames()메소드 이용
```java
Enumeration<String> paramName=req.getParameterNames();
		while(paramName.hasMoreElements()) {
			String key=paramName.nextElement();
			System.out.println(key);
			//한개값이든 다수값이든 모두 values를 받는다 한개값이면 0번인덱스에 받을거고 다수값으면 여러인덱에 생긴다.
			String[] value=req.getParameterValues(key);
			System.out.println(Arrays.toString(value));
		}

```

<br/>

## 클라이언트가 보낸 데이터 Map방식으로 가져오기
- Map객체 그대로 가져올수도있다.

```java
Map<String,String[]> param=req.getParameterMap();
		for(String key: param.keySet()) {
			System.out.println(key+" : "+Arrays.toString(param.get(key)));
		}
```

<br/>
		

















# 5. HttpServletResponse
- 요청에 대한 처리 결과를 작성하기 위해 사용하는 객체

- setContentType(String) :  응답한데이터가 뭘의히하는지 알려준다.   MIME type을정하는알려준다.
- setCharacterEncoding(String) : 인코딩 타입을 정해준다. 내가보내는 데이터에따라 브라우저가 뭘로 코딩했는지 를 알려준다.
- getWriter() : 문자열을 전송할때쓴다. 일반적으로html,css ,제이슨 등등 을전송할때 writer을 이용한다.
- getOutputStream() : byte단위로 페이지에 전송을 위한 Stream을가져온다.
- sendRedirect(String) : client가 매개변수의 페이지를 다시 서버에요청하게 하는 메소드

![response](https://user-images.githubusercontent.com/126074577/239776764-d3aa6dc5-6477-453e-9735-3027fd647f0d.png)

<br/>

  
  
  
  
  
  
  
















