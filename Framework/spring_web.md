## 🔖 목차
1. [페이징처리](#1-페이징처리)<br/>
2. [파일업로드](#2-파일업로드)<br/>
3. [트렌젝션](#3-트렌젝션)<br/>
4. [spring에서 ajax요청에대한 응답처리](#4-spring에서-ajax요청에대한-응답처리)<br/>



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

## 트렌젠션 설정 방법

- xml방식 과 어노테이션 방식으로 두가지가있다.

- xml : <tx:config>태그로 트렌젝션관련 설정을한다. <aop :config>트렌젝션을 적용한다.

- 어노테이션 : @Transactional을 메소드 선언부에 선언해준다. , <aop:aspectj-autoproxy/>반드시 설정이 되어 있어야한다.


<br/>

## 트렌젠션 옵션
- propagation : 트렌젝션을 생성하는 방법에 대한 설정 default 이미 시작된값이 있으면 참여, 없으면 트렌젝션을 생성한다.
- isolation : 트렌젝션에 수정내용을 다른 트렌제견에서 사용여부 설정
- timout :
- read-only : select문을 사용할때 사용 읽기전용
- rollback-for,rollbackfor : rollback의 기준을 재설정


<br/>

## 여러개의파일업로드
먼저 어노테이션 방식으로 설정해보겟다.

root-context 에서   <tx:annotation-driven>태그를 설정 해줘야한다.

```xml
        DataSourceTransactionManager클래스를 bean으로 등록
        1. 어노테이션 방식으로 설정하기
        <tx:annotation-driven>태그를 설정 

     <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="proxyDataSource"/>
     </bean>
<tx:annotation-driven transaction-manager="transactionManager"/>
```



이제 여러개의 파일을 업로드하였을때 트렌젝션 처리에대해 알아보겟다.

먼저 첨부파일을 클래스를 만들어줘야한다.


```java
Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attachment {
	private int attachmentNo;
	private int boardNo;
	private String originalFilename;
	private String renamedFilename;
	private Date uploadDate;
	private int downloadCount;
}
```

첨부파일은 여러개가올수가있기때문에 1:다관계를 설정을 게시판클래스에 해주자

```java
Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
	private int boardNo;
	private String boardTitle;
	private Member boardWriter;
	private String boardContent;
	private int boardReadCount;
	private Date boardDate;
	private List<Attachment> file=new ArrayList();
	
	
}
```

첨부파일이 여러개가올수잇으니 ArrayList를 설정해주자


하면서 boardWriter도 1:1관계이기에 Member로 설정해주자

그후 controller에서 객체를 생성해서 사용해주자

```java
@RequestMapping("/boardWrite.do")
	public String insertBoard(Board b, MultipartFile[] upFile, 
			HttpSession session, Model m) {
	      
	      // MultipartFile에서 제공하는 메소드를 이용해서 파일을 저장할 수 있음 -> transferTo()메소드
	      // 절대경로 가져오기
	      String path = session.getServletContext().getRealPath("/resources/upload/board/");
	      // 파일명에 대한 renamed 규칙을 설정
	      // 직접 리네임 규칙을 만들어서 저장해보자.
	      // yyyyMMdd_HHmmssSSS_랜덤값
	      
	      // *** 파일 여러개 등록하기 ***
//	      List <Attachment> files = new ArrayList(); -> Board에서 new 선언해줌
	      if(upFile != null) {
	         for(MultipartFile mf : upFile) {
	            if(!mf.isEmpty()) {
	               // 파일 등록하기
	               String oriName = mf.getOriginalFilename();
	               String ext = oriName.substring(oriName.lastIndexOf(".")); // 확장자명
	               Date today = new Date(System.currentTimeMillis());
	               SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
	               int rdn=(int)(Math.random()*10000) + 1; // 카카오톡처럼 랜덤값 부여
	               String rename = sdf.format(today) + "_" + rdn + ext; // renamed 규칙
	               
	               try {
	                  mf.transferTo(new File(path + rename));   
	               } catch(IOException e) {
	                  e.printStackTrace();
	               }
	               
	               Attachment file = Attachment.builder()
	                     .originalFilename(oriName)
	                     .renamedFilename(rename)
	                     .build();
	               
	               b.getFile().add(file);
	            }
	         }
	      }
	      try {
	         service.insertBoard(b);
	      } catch(RuntimeException e) {
	         // DB 등록 실패 시 파일도 폴더에 저장되면 안됨(삭제해주기)
	         for(Attachment a : b.getFile()) {
	            File delFile = new File(path + a.getRenamedFilename());
	            delFile.delete();
	         }
	         
	         m.addAttribute("msg", "글쓰기 등록 실패! :(");
	         m.addAttribute("loc", "/board/boardWriteMove.do");
	         return "common/msg";
	      }
```

board 클래스에서 미리  첨부파일을 new ArrayList(); 를 해줫기때문에 바로 빌더로 객체를 넣어줄수잇다.

이제 service에서 트렌젝션처리를 해주자

<br/>

먼저 service에 @Transactional 선언해줘야 어노테이션방법으로 트렌젝션 처리가가능하다.

```java
public int insertBoard(Board b){
		log.info("실행 전 {}", b.getBoardNo());
	      int result = dao.insertBoard(session, b); // boardNo는 지금 생성됨 -> Attachment에 boardNo FK로 사용중이라 필요함
	      log.info("실행 후 {}", b.getBoardNo());
	      if(result > 0) {
	         if(b.getFile().size() > 0) {
	            for(Attachment a : b.getFile()) {
	               a.setBoardNo(b.getBoardNo());
	               result += dao.insertAttachment(session, a);

  return result;
```

이런식으로 둘중하나가 실패한다면 바로rollback처리를 해줘서 간단하게 트렌젠셕 처리가 가능해진다.

<br/>

## xml 트렌젠셕
xml방식으로 트렌젠셕처리를 할려면 간단하게 위에코드는 그대로쓰고 root-context에서 설정만바꿔주며된다.

```xml
<!-- 2. xml 방식으로 선언하기(선언적 방식) -->
    <tx:advice id="txadvice" transaction-manager="transactionManager">
       <tx:attributes>
          <tx:method name="insert*"/>
       </tx:attributes>
    </tx:advice>
    
    <aop:config>
       <aop:pointcut expression="within(com.bs.spring..*ServiceImpl)" id="transpo"/>
       <aop:advisor advice-ref="txadvice" pointcut-ref="transpo"/>
    </aop:config>
```


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

<br/>

## json 파싱라이브러리

- json 사용하기전에 파싱을할수있는 라이브러리가존재한다.

![image](https://github.com/inhoru/TIL/assets/126074577/7a1dc65d-e493-4760-aaa0-85437c58b09d)

- porm.xml 에 의존성을 주입해주면 사용이가능하다.

```xml
json 파싱 라이브러리 등록
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.15.2</version>
</dependency>
```

<br/>

## ajax요청
spring에 ajax도 우리가 기존에 쓰던방식이랑 크게다르지않다.

controller에서만 다른점이있다고 생각하면된다.

```html
const basicAjax=()=>{
	$.get('${pageContext.request.contextPath}/ajax/basicTest.do',(data)=>{
		console.log(data)
		$("#ajaxContainer").html("<h2>"+data+"</h2>");
	});
}
```
-  기본 ajax처리방식이다.

```java
@GetMapping("/basicTest.do")
	public void basic(HttpServletRequest req, HttpServletResponse res) throws IOException, SerialException {
		Board b = Board.builder().boardTitle("냉무").boardContent("냉무").build();
		ObjectMapper mapper = new ObjectMapper();
		res.setContentType("text/csv;charset=utf-8");
		res.getWriter().write("test");
		res.setContentType("application/json;charset=utf-8");
		// json방식으로 변환해 보내준다는뜻
		res.getWriter().write(mapper.writeValueAsString(b));
	}
```
- ObjectMapper 클래스를 호출해서 사용할수가있다.
- writeValueAsString메소드를 사용해서 json방식으로 반환해줄수있다.

<br/>

## json받기
json 으로 반환할수있게 처리하기위해서 메소드위에  @ResponseBody 선언해줘야한다.

```java
// 리턴값에 반활할 객체를 선언
// @ResponseBody -> json으로 반환할 수 있게 처리
@GetMapping("/converter")
@ResponseBody
public Board converTest() {
	return Board.builder().boardTitle("spring좋다").boardContent("하하").build();
	
}
```

![image](https://github.com/inhoru/TIL/assets/126074577/0ee8ea48-c00b-45e4-a12b-a004aec9ce3f)

<br/>

## jsp받아오기
json으로 jsp자체를 받아올수있다 하지만추천하지않는다 왠만하면 데이터를 받아서 자바스크립트로 데이터를 파싱해서 사용하자

```java
@GetMapping("/basic2")
	public String basic2() {
		return "demo/demo";
	}
```

<br/>

## json으로받아서 파싱해서 사용하기
json객체를 받아서 파싱해서 html로 만들어줄수가있다 권장하는방법이다.

```html
const selectAll=()=>{
			$.get("${pageContext.request.contextPath}/ajax/selectAll",data=>{
				console.log(data);
				const table=$("<table>");
				const header=["아이디","이름","나이","성별","이메일","전화번호","주소","취미","가입일"];
				const tr=$("<tr>");
				header.forEach(e=>{
					const th=$("<th>").text(e);
					tr.append(th);
				})
				table.append(tr);
				data.forEach(e=>{
					const bodyTr=$("<tr>");
					const userId=$("<td>").text(e.userId);
					const name=$("<td>").text(e.userName);
					const age=$("<td>").text(e.age);
					const gender=$("<td>").text(e.gender);
					const email=$("<td>").text(e.email);
					const phone=$("<td>").text(e.phone);
					const address=$("<td>").text(e.address);	
					const hobby=$("<td>").html(e.hobby.toString());
					const enrollDate=$("<td>").text(new Date(e.enrollDate));
					bodyTr.append(userId).append(name).append(age)
					.append(gender).append(email).append(phone).append(address)
					.append(hobby).append(enrollDate);
					table.append(bodyTr);
				});
				$("#ajaxContainer").html(table);				
			});
		}
```

```java
@GetMapping("/selectAll")
	@ResponseBody
	public List<Member> selectAll() {
		return service.selectAll();
	}
```

<br/>


