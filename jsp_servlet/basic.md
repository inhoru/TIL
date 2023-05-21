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


- 실행창(윈도우+r) → sysdm.cpl 검색 → 고급, 환경변수 → 시스템변수, 새로만들기 → 변수 이름 : JAVA_HOME, 디렉터리 찾아보기 → 내 pc, c드라이브, program files, ojdkbuild, java 17, 

![환경변수](https://user-images.githubusercontent.com/126074577/239743296-ef12121d-a033-4f31-9598-aeb404f8f882.png)
![환경변수 확인](https://user-images.githubusercontent.com/126074577/239743314-3b437b18-3a35-40c8-8452-89d51c4b0be1.png)

<br/>

- cmd창에서확인

![확인](https://user-images.githubusercontent.com/126074577/239743311-e5ef4bef-10c2-4147-a357-50fb828b3650.png)






<br/>

# 1. tomcat 파일
- `bin = tomcat을실행하는 파일
- startup = 윈도우 배치파일 윈도우에서 실행파일
- startup.sh = sh은 윈도우말고 리눅스나 다른거 실행파일
- stutdown = tomcat 종료


- conf = tomcat이 실행될때 필요한 환경설정파일,xml파일 서버동작환경 설정(sever.xml) ,서버의어플리케이션설정(web.xml)

- lib = jar,필요한 라이브러리 보기

- logs = 필요한lof(기록),에러 접속 파일

- temp,work =tomcat에 작업공간

- webapps = 웹서비스를 배포하는 폴더 배포할때 소스코드를 주는게아니라 패키징을한다(war파일로 패키징한다)




