# 🔖 목차
1.
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

post
  - BODY에 내용을 보내는 방식으로 데이터 크기에 제한이 없고보안이 뛰어남-
  - Servlet이 두 방식 중 하나로 전달 받으면 해당하는 메소드 호출


- html의 <form>에서 method속성을 이용해 방식 결정(default : get)
  
<br/>
  
  
  
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


















