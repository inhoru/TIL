# 🔖 목차
1.
2.
3.

<br/>


## JDBC
- 자바에서 데이터베이스에 접근할수 있게해주는 API를 말한다.
- 이API를 이용해서 데이터베이스에 저장되어있는 정보를 사용및 수정 등등이 가능하다.

<br/>

- 데이터베이스마다 각기다른 JDBC가있는데 지금은 오라클을쓰고 있으니
- 오라클 JDBC를 먼저 설명하겟다.

## 설치방법
- 먼저 오라클 홈페이지에서 OJDBC를 다운받아야한다.
- https://www.oracle.com/database/technologies/ 이사이트에 OJDBC를 다운받을수있다.
- ojdbc8을 다운받으면된다. 버전마다 다르니 잘알아보고 다운받자.
- 여기서 이클립스에서 설정해줘야하는 것들이있다.
  - 바로 인코딩을 설정해줘야한다. UTF-8로 설정해주면 된다.
  - 밑에 사진을 참고해서 전부다 UTF-8으로 설정해주자

<br/>

- 워크스페이스 인코딩
![워크스페이스](https://user-images.githubusercontent.com/126074577/231723196-d577142b-a0b3-485c-82ab-ff4b4b38fb1b.png)

<br/>

- 문자열 인코딩
![문자열인코딩](https://user-images.githubusercontent.com/126074577/231723220-25481604-0c1c-40f8-8ca2-90b956a17f14.png)

<br/>

- JSP인코딩

![JSP](https://user-images.githubusercontent.com/126074577/231723257-0c23ecaa-dffb-4b44-9c86-adbb15aa6b48.png)

<br/>

- HTML 인코딩
![HTML](https://user-images.githubusercontent.com/126074577/231723272-a4c279ff-04d1-441a-b41e-b147ef599a65.png)

<br/>

- CSS 인코딩
![CSS](https://user-images.githubusercontent.com/126074577/231723292-0fc4531b-140c-459a-84b2-e7b005700e2c.png)

<br/>

- 위에 있는 것들을 전부 해줘야 JDBC의 API를 사용할수가있다.

<br/>



