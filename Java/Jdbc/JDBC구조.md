# 🔖 목차
1.
2.

<br/>


## JDBC 구조
- 우리가 많이사용하던 MVC패턴을 사용을한다.

  - <code>RUN</code> : 애플리케이션 실행을 위해 main메소드를 가지고 있는 패키지
  - <code>VIEW</code> : Client에게 보여주는 화면 담당
  - <code>Controller</code> : View에서 전달받은 데이터를 가공처리(데이터 변환, 디코딩) 후 DAO로 전달, DAO로부터 전달 받은 결과에 따라 View를 결정하여 인코딩 후 데이터 전송
  - <code>Model<code> : DBMS에서 전송된 데이터 또는 전송할 데이터를 보관할 수 있는 클래스가 있고DBMS와 통신하면서 데이터를 주고 받는 클래스가 있는 패키지
    - vo : 데이터베이스의 각 컬럼 개체(entity) 저장용 클래스가 있는 패키지로DB의 도메인 정보를 Client에게 전달할 때 그 도메인 단위 정보를 VO에 구현
    - DTO : 데이터베이스의 각 컬럼 개체(entity) 저장용 클래스가 있는 패키지로DB의 도메인과 일치하지 않으며 어떤 로직에 사용되는 영속적이지 않은정보를 DTO에 구현
    - DAO : DBMS에 접속하여 실제 데이터를 전송하거나 결과 값을 전달 받는 클래스가있는 패키지

<br>
- 구조 
![구조](https://user-images.githubusercontent.com/126074577/232839232-3eb44fe9-c306-4582-929b-86e7c14a14fc.png)

<br/>

- 상세 구조



![상세구조](https://user-images.githubusercontent.com/126074577/232839252-536e5c3d-5231-4725-a65a-a14406532fb8.png)

<br/>

## 중복코드 클래스 
- DBMD연동, 객체 반환, 트랜잭션 처리 등 중복 코드를 새로운 클래스에서구동될 수 있게 싱글톤 패턴을 적용하여 연동 구조 재설계

  - <code>싱글톤 패턴</code> : 객체 사용 시 새로운 객체를 계속 생성해서 사용하는 것이 아니라하나의 객체만 생성하여 공유하는 것
  - <code>Common</code> : 클래스 내부의 중복 코드를 처리하는 클래스가 담겨있는 패키지로Connection 생성, Connection/Statement/PreparedStatement 반환메소드, 트랜잭션(commit, rollback)이 묶여 있음

    - Connection class 관리 및 객체 반환, 트랜젝션 관리하는 Service 패키지에서 사용
    - 클래스 내부의 중복 코드를 처리하는 클래스가 담겨있는 패키지로Connection 생성, Connection/Statement/PreparedStatement 반환메소드, 트랜잭션(commit, rollback)이 묶여 있음

<br/>

- 구조
![구조](https://user-images.githubusercontent.com/126074577/232840091-f464014b-b3b9-4a5d-83e7-966ca27d6cab.png)

<br/>

- 상세구조

![상세구조](https://user-images.githubusercontent.com/126074577/232840128-930fb3b7-8555-4944-bf5b-0b512f09158e.png)

<br/>







