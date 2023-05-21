# 🔖 목차
1.
2.
3.

<br/>

## tomcat
- ### tomcat 다운로드

- [https://tomcat.apache.org/download-90.cgi](https://tomcat.apache.org/download-90.cgi)

- [64-bit Windows zip](https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.75/bin/apache-tomcat-9.0.75-windows-x64.zip) ([pgp](https://downloads.apache.org/tomcat/tomcat-9/v9.0.75/bin/apache-tomcat-9.0.75-windows-x64.zip.asc), [sha512](https://downloads.apache.org/tomcat/tomcat-9/v9.0.75/bin/apache-tomcat-9.0.75-windows-x64.zip.sha512)) 다운

## 환경변수 설정


-  환경변수   새로만들기 이름 JAVA_HOME ojdkbuild, java 17 설정

![환경변수](https://user-images.githubusercontent.com/126074577/239743296-ef12121d-a033-4f31-9598-aeb404f8f882.png)
![환경변수 확인](https://user-images.githubusercontent.com/126074577/239743314-3b437b18-3a35-40c8-8452-89d51c4b0be1.png)

<br/>

- cmd창에서확인

![확인](https://user-images.githubusercontent.com/126074577/239743311-e5ef4bef-10c2-4147-a357-50fb828b3650.png)






<br/>

# 1. tomcat
- `bin = tomcat을실행하는 파일
- startup = 윈도우 배치파일 윈도우에서 실행파일
- startup.sh = sh은 윈도우말고 리눅스나 다른거 실행파일
- stutdown = tomcat 종료


- conf = tomcat이 실행될때 필요한 환경설정파일,xml파일 서버동작환경 설정(sever.xml) ,서버의어플리케이션설정(web.xml)

- lib = jar,필요한 라이브러리 보기

- logs = 필요한lof(기록),에러 접속 파일

- temp,work =tomcat에 작업공간

- webapps = 웹서비스를 배포하는 폴더 배포할때 소스코드를 주는게아니라 패키징을한다(war파일로 패키징한다)


<br/>


# 2. 가상 서버
- 이클립스에서 가상 서버를 만들어서 쉽게서버를 사용할수잇다.
- 사용하기전에 문자들이 깨지지않게하기위한 인코딩처리가 필요하다 과정은 jdbc에서 햇던 utf-8설정이랑 같다.
- workspace
- spelling
- JSP, HTML, CSS

<br/>

## 이클립스

- 이클립스에서 서버를만들어보자
- server 을열어 아래사진처럼 만들자

![이클립스](https://user-images.githubusercontent.com/126074577/239743559-2f67de23-074c-41b9-a6da-3b66965ee77c.png)

- 서버를 만들고 실행버튼을 누루면 아래처럼 콘솔에 뜨면 서버가열린것이다.

![서버열기](https://user-images.githubusercontent.com/126074577/239743563-bf57fb18-4bdc-40ed-adb8-efe4c66e5528.png)

<br/>

# 3. 배포
- 원래 톰캣에 배포할려면 패키징후 이런저런과정이있지만
- 이클립스에서는 add project로 배포할수가있다.



- 다아나믹 web application을 만들어보자

![다이나믹](https://user-images.githubusercontent.com/126074577/239743769-5cf8867d-67f8-4206-b17f-82f3f108688d.png)

- context root: 이름
- ocalhost:포트번호/01_firstweb(이름) 이런식으로 접속을한다.
- content directory : 최상위 폴더

![이름](https://user-images.githubusercontent.com/126074577/239743808-dae28814-5469-4fb5-8eb7-7833df89bc66.png)

- default output folder은 관리하기쉽게 아래처럼 설정한다.

![default](https://user-images.githubusercontent.com/126074577/239743802-72e9ee50-86ee-4fae-ad9a-96a0dc0a30b5.png)

<br/>

## 서버에 add

- 이제 tomcat서버에 배포를해보자
- 아래사진처럼 add를 클릭해서 넣을수가있다.

![add](https://user-images.githubusercontent.com/126074577/239743953-b75352ff-d0a0-4cbd-af06-9221143e0975.png)

- 그후 넣고싶은파일을 add하자

![add2](https://user-images.githubusercontent.com/126074577/239743951-4d62a72c-7e33-47de-a05b-85002b4c6fd0.png)

- remove로 뺄수도있다.

## 서버접속

- 위에 과정이 모두 끝낫다면
- 이제 접속을 해보자 접속 방법은 위에설명햇듯이
- localhost:포트번호/이름 이다.
- 자신의 포트번호는 8080이다.

![접속](https://user-images.githubusercontent.com/126074577/239743949-a06e940f-7ea5-4081-9442-5d4632b267f2.png)

## 이름변경
- 이름을 변경해서 접속할수도있다.
- sever.xml 파일에 리소스를 누르면 코드들을 볼수있는데 거기에 변경할 프로젝트의 path 를 변경하면 그 변경한 이름으로 접속이가능하다.

![path](https://user-images.githubusercontent.com/126074577/239744075-9c9e4dad-a7e1-4f24-aca5-5ab42736a1b1.png)

<br/>


# 4. web 만들기
- wepapp 에 html을 넣는다
- WEB-INF폴더는 jar파일을 모아두는데 이아래잇는것들은 주소로 접속이불가능하다.
- backend 는 javaResources폴데에 코드를 작성한다.

- 대문의 파일명은 index.html로 만든다.

![web](https://user-images.githubusercontent.com/126074577/239744469-07d7791f-b47a-4fff-9bc2-8f4c9647eb1a.png)

![web2](https://user-images.githubusercontent.com/126074577/239744279-b346af91-7469-485e-84a1-840815ab9d0b.png)

<br/>






    




