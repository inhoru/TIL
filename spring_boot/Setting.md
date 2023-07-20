## 🔖 목차


<br/>

# 1. boot프로젝트 생성하는 법

## spring.io 홈페이지에서 initializer기능을 이용한다 -> zip파일로 받아 import
- https://start.spring.io/ 사이트에서 다운이가능하다.

![image](https://github.com/inhoru/TIL/assets/126074577/bbcf94cd-f430-4ace-9261-259a8b4bb094)

<br/>

-
<br/>


## IDE 에서 strater프로젝트를 생성한다.

- 프로젝트 생성


![image](https://github.com/inhoru/TIL/assets/126074577/051c0d75-43dd-4657-a1cb-33b296fcc862)

<br/>

- 프로젝트 설정


![image](https://github.com/inhoru/TIL/assets/126074577/eb63eb06-aa39-4cca-9397-93a08496cafc)

- type : 빌드타입을 뜻한다.



<br/>


- 버전설정

![image](https://github.com/inhoru/TIL/assets/126074577/acd7632e-31b0-421a-9906-3ce41b8ae796)


- 사용자의 jdk에따라 버전을 설정해주자
- Spring boot DevToole : 개발의에 필요한 유용한기능을 넣어둔 라이브러리다
- 나중에 프로젝트만들떄 필요한 의존성 필요한 라이브러리가필요할떄 체크해서 넣어주면된다.

<br/>

- 자주쓰는 라이브러리

![image](https://github.com/inhoru/TIL/assets/126074577/442c9d62-2635-4d7e-8357-896185471cac)


<br/>


## application.properties
- 각종설정할수있는곳
- ![image](https://github.com/inhoru/TIL/assets/126074577/1f7705c8-0a16-417a-a63a-9d321f397d6f)


## boot서버관리
![image](https://github.com/inhoru/TIL/assets/126074577/0d825f33-1dab-4b21-a027-fb7f38ea0e5f)


<br/>

## jasper
- 프론트페이지를 jsp로 연결하려면 추가 의존성 등록을 해줘야한다.
- tomcat-emded-jasper 모듈등록

![image](https://github.com/inhoru/TIL/assets/126074577/1b0b348e-2dac-4025-9dfe-7c11a86fc4f9)

- 버전은 아무거나상관없다 버전은 안쓸거기때문이다.
- 의존성등록을 완료했다면 될거같지만 그게끝이아니다.


<br/>

## jsp연결을 위한 viewresolver설정하기
- application.properties 에서 viewresolver에서 설정해줘야한다.

```yml
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

<br/>

