## 🔖 목차
1. [페이징처리](#1-페이징처리)<br/>


<br/>


# 1. 페이징처리
게시판 기능을 spring으로만들기 

<br/>

- 페이징처리

지금까지 페이징처리를 할때 메소드 하나 하나마다 페이지처리 코드를 일일히 적어줫지만

페이징처리 클래스를 하나만들어서 불러오도록 만들수가 있다.

## 페이징처리 클래스

```java
public class PageFactory {

	public static String getPage(int cPage, int numPerpage, int totalData,String url) {
		
		//매개변수값을 이용해서 pageBar만들어주는 함수
		StringBuffer pageBar=new StringBuffer();
		
		int totalPage=(int)(Math.ceil((double)totalData/numPerpage));
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		pageBar.append("<ul class='pagination justify-content-center pagination-sm'>");
		
		if(pageNo==1) {
			pageBar.append("<li class='page-item disabled'>");
			pageBar.append("<a class='page-link' href='#'>이전");
			pageBar.append("</a>");
			pageBar.append("</li>");
		}else {
			pageBar.append("<li class='page-item'>");
			pageBar.append("<a class='page-link' href='javascript:fn_paging("+(pageNo-1)+")'>이전");
			pageBar.append("</a>");
			pageBar.append("</li>");
		}
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar.append("<li class='page-item disabled'>");
				pageBar.append("<a class='page-link' href='#'>"+pageNo);
				pageBar.append("</a>");
				pageBar.append("</li>");
			}else {
				pageBar.append("<li class='page-item'>");
				pageBar.append("<a class='page-link' href='javascript:fn_paging("+(pageNo)+")'>"+pageNo);
				pageBar.append("</a>");
				pageBar.append("</li>");
			}
			pageNo++;
		}
		
		if(pageNo>totalPage){
			pageBar.append("<li class='page-item disabled'>");
			pageBar.append("<a class='page-link' href='#'>다음");
			pageBar.append("</a>");
			pageBar.append("</li>");
		}else {
			pageBar.append("<li class='page-item'>");
			pageBar.append("<a class='page-link' href='javascript:fn_paging("+(pageNo)+")'>다음");
			pageBar.append("</a>");
			pageBar.append("</li>");
		}
		pageBar.append("</ul>");
		
		//스트립트문추가
		pageBar.append("<script>");
		pageBar.append("function fn_paging(no){");
		pageBar.append("location.assign('"+url+"?cPage='+no+'&numPerpage="+numPerpage+"');");
		pageBar.append("}");
		pageBar.append("</script>");
		
		return new String(pageBar);
		
	}

```

위와 같은 방식으로 페이징처리 클래스를 만들어놓고 컨트롤러에서 불러오기만하면된다.

페이징처리에대한 자세한 내용설명은.. 차후 업데이트예정

<br/>

## controller

```java

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

	private final BoardService service;

	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping("boardList.do")
	public String boardList(@RequestParam(value="cPage",defaultValue="1") int cPage,@RequestParam(value="numPerpage",defaultValue="20") int numPerpage, Model m){
		List<Board> boards=service.selectBoard(Map.of("cPage",cPage,"numPerpage",numPerpage));
		int totalData=service.selectBoardCount();
		//paging
		m.addAttribute("pageBar", PageFactory.getPage(cPage, numPerpage, totalData,"boardList.do"));
		
		m.addAttribute("totalData",totalData);
		m.addAttribute("board",boards);
		
		return "board/boardList";
	
}
```
- RequestParam의 defaultValue를 이용해서 try catch를 이용하지않고 cPage와 numPerpage를 만들수가있다.
- 그런후 Model에 페이징처리클래스를 불러와서 간단하게 페이징처리를 할수가있다.

<br/>

# 2. 파일업로드
-  파일업로드를 위한 라이브러리가 존재한다.
- commons-io

![image](https://github.com/inhoru/TIL/assets/126074577/8968b98f-8086-4ce3-8cef-a8514fa1f59f)

<br/>

- commons-fileupload

![image](https://github.com/inhoru/TIL/assets/126074577/db44dcfc-d59a-4f60-a666-e4f7f30268f3)

- 위에 라이브러리들을 먼저 의존성 주입을 시켜준다.
```xml
<!-- 
	파일업로드를 위한 라이브러리 등록
	commons-io
	commons-fileupload
-->
<dependency>
	<groupId>commons-io</groupId>
	<artifactId>commons-io</artifactId>
	<version>2.7</version>
</dependency>

<!--
		 -->
<dependency>
	<groupId>commons-fileupload</groupId>
	<artifactId>commons-fileupload</artifactId>
	<version>1.4</version>
</dependency>

```

<br/>

## resolver등록
- spring에서 파일업로드를 처리하기위해서 먼저  bean에 동록해주자
- CommonsMultipartResolver클래스를 빈으로 등록한다.

```xml
 <beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	<beans:property name="maxUploadSize" value="104857600"/>
 </beans:bean>
```

<br/>

## 파일 을 controller에서 받기
- jsp에서 multipart 으로 controller로러 먼저 보내준다.

```jsp
<form name="boardFrm" action="${path }/board/boardWrite.do" method="post" enctype="multipart/form-data" >
```

<br/>

- MultipartFile에서 제공하는 메소드를 이용해서 파일을 저장할 수 있음 -> transferTo() 메소드를 이용 한다.

```java
@RequestMapping("boardWrite.do")
	public String boardWrite(Board b,Model m,MultipartFile upFile,HttpSession session) {
log.info("{}",upFile);

//출력결과
MultipartFile[field="upFile", filename=64 - 복사본.jpg, contentType=image/jpeg, size=285142]
		
```

<br/>

- 파일을 가져왔으면 어느곳에 파일을 저장할지 절대경로를 가져오자

```java
String path=session.getServletContext().getRealPath("/resources/upload/board/");
```

<br/>

- 파일명에 대한 renamed규칙을 설정해서 중복된 파일명을 구별할수있게해주자
- 직접리네임규칙을 만들어서 저장해보자. (yyyyMMdd_HHmmssSSS_랜덤값)
- 확장자명(.png.gif.....)을 찾기위해 원본파일명을가져와서 subString으로 확장자명을가져온다.

```java
String oriName=upFile.getOriginalFilename();
String ext=oriName.substring(oriName.lastIndexOf("."));
Date today=new Date (System.currentTimeMillis());
SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
int rdn=(int)(Math.random()*10000)+1;
String rename=sdf.format(today)+"_"+rdn+ext;
```

- renamed까지 완료 했으면 위에서 설명한 transferTo를 통해 파일을 업로드하자

```java
try{
	upFile.transferTo(new File(path+rename));
}catch(IOException e) {
	e.printStackTrace();
}
```





<br/>


# 3. 트렌젝션
spring에서 트렌젝션을 처리할때 TransactionManaget클래스를 이용해서 처리한다.

Session이 종료되면 기본적으로 실행한 DML구문 commit 처리한다

하지만 SQL문 실행 중 RuntimeException이 발생하면 rollback이된다. ( SQLException 도 RuntimeException이다.)


<br/>

## 트렉젠션 설정 방법

- xml방식 과 어노테이션 방식으로 두가지가있다.

- xml : <tx:config>태그로 트렌젝션관련 설정을한다. <aop :config>트렌젝션을 적용한다.

- 어노테이션 : @Transactional을 메소드 선언부에 선언해준다. , <aop:aspectj-autoproxy/>반드시 설정이 되어 있어야한다.


<br/>

## 트렉젠션 옵션
- propagation : 트렌젝션을 생성하는 방법에 대한 설정 default 이미 시작된값이 있으면 참여, 없으면 트렌젝션을 생성한다.
- isolation : 트렌젝션에 수정내용을 다른 트렌제견에서 사용여부 설정
- timout :
- read-only : select문을 사용할때 사용 읽기전용
- rollback-for,rollbackfor : rollback의 기준을 재설정
- no-rollback-for : 


<br/>

# 4. spring에서 ajax요청에대한 응답처리
- 응답처리에 방식은 3가지가있다.
	- 기존방식 : void response.writer() JSON으로 응답하는것.
 	- Resolver를 이용해서 처리하기 -> Jsonview라이브러리를 이용해서 처리하기
  	- Jackson converter를 이용해서 처리하기 -> @ResponsBody를 이용해서 반환하는값을 JSON
 
<br/>

## 요청
- 요청을 할때 지금까지는 $.ajax,$.get,$.post 라는 걸이용했는데
- javascript 에서 fetch()라는 함수를 지원한다.
