## 🔖 목차


<br/>

## Spring Franeork
- was위에 servlet가있고 그위에 Sprig을 덮어씌워서 사용을 편리하게만들어주는 프레임워크다.


<br/>

# 1. 특징
- spring 의 큰 특징의 대해 알아보자

- POJO : 우리가만들던 mvc패턴같은것들을 자동으로 만들어준다. 내가만든 구조들을 스프링안에서 사용할수있게 해준다.
- IoC : 제어권이 개발자가아니라 서버에게있는것 (스프링컨테이너)구동시 필요한 객체의 생성부터 생명주기까지 직적 관리를 해준다.
- DI
- AOP

![image](https://github.com/inhoru/TIL/assets/126074577/ccc692c9-4882-4a56-a509-edc898f01776)
![image](https://github.com/inhoru/TIL/assets/126074577/b629ca91-7fce-4cf1-8f10-518bb710edc3)

<br/>




# 3. 폴더구조
- ![image](https://github.com/inhoru/TIL/assets/126074577/8a09d5e8-46b0-428a-a6a4-23d80051b566)
- jvav에는 m,v,c가들어감
- resources에는 각종환경설정
- test 메인과같지만 테스트용 폴더
- libraires : 라이브러리들을 불러온다 자바ee관련 내용들이 들어온다.

<br/>

## src
- webapp/resources : views에서 필요한 css, js , upload , img 등등 이 들어간다.
- webapp아래에있  jsp파일은 외부에서 접근이불가능하다 그렇기때문에 이제부터 맵핑주소로 접속을해야한다.


```java
@Controller
public class HomController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}

}
```

<br/>

- 위에처럼 index를  잘모르겟데ㅏㅣ;;

# 4. loc 






# 5. spring di
- 사용자가 객체를 직접 생성하는게아니라 컨테이너가 빈을 가져와서 객체를 연결해줌
- 이렇게 의존성을 주입할수가 있다.
- 로컬변수에 집어 넣지않고 필드에 집어넣는다

![image](https://github.com/inhoru/TIL/assets/126074577/b4709eaa-cf10-41bc-8333-7b6b60a2fab6)

<br/>

![image](https://github.com/inhoru/TIL/assets/126074577/e343765c-ea0a-458c-ac30-3e9b916330d2)





