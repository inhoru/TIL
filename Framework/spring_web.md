## 🔖 목차
1. [페이징처리](#1-페이징처리)<br/>


<br/>


# 1. 페이징처리
게시판 기능을 spring으로만들기 

<br/>

- 페이징처리

지금까지 페이징처리를 할때 메소드 하나 하나마다 페이지처리 코드를 일일히 적어줫지만

페이징처리 클래스를 하나만들어서 불러오도록 만들수가 있다.

- 페이징처리 클래스
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
<br/>

- controller

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


