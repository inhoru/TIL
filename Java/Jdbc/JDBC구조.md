# 🔖 목차
1. [Service](#1-Service)<br/>




<br/>


## JDBC 구조
- 우리가 많이사용하던 MVC패턴을 사용을한다.

  - **<code>RUN</code> : 애플리케이션 실행을 위해 main메소드를 가지고 있는 패키지**
  - **<code>VIEW</code> : Client에게 보여주는 화면 담당**
  - **<code>Controller</code> : View에서 전달받은 데이터를 가공처리(데이터 변환, 디코딩) 후 DAO로 전달, DAO로부터 전달 받은 결과에 따라 View를 결정하여 인코딩 후 데이터 전송**
  - **<code>Model</code> : DBMS에서 전송된 데이터 또는 전송할 데이터를 보관할 수 있는 클래스가 있고DBMS와 통신하면서 데이터를 주고 받는 클래스가 있는 패키지**
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

  - **<code>싱글톤 패턴</code> : 객체 사용 시 새로운 객체를 계속 생성해서 사용하는 것이 아니라하나의 객체만 생성하여 공유하는 것*8
  - **<code>Common</code> : 클래스 내부의 중복 코드를 처리하는 클래스가 담겨있는 패키지로Connection 생성, Connection/Statement/PreparedStatement 반환메소드, 트랜잭션(commit, rollback)이 묶여 있음**

    - Connection class 관리 및 객체 반환, 트랜젝션 관리하는 Service 패키지에서 사용
    - 클래스 내부의 중복 코드를 처리하는 클래스가 담겨있는 패키지로Connection 생성, Connection/Statement/PreparedStatement 반환메소드, 트랜잭션(commit, rollback)이 묶여 있음

<br/>

- 구조
![구조](https://user-images.githubusercontent.com/126074577/232840091-f464014b-b3b9-4a5d-83e7-966ca27d6cab.png)

<br/>

- 상세구조

![상세구조](https://user-images.githubusercontent.com/126074577/232840128-930fb3b7-8555-4944-bf5b-0b512f09158e.png)

<br/>


# 1. Service
-  클래스 내부의 중복 코드를 처리하는 클래스가 담겨있는 패키지다.
- DB에 연결하는 Connection객체를 관리 생성과 소멸을 이클래스안에서 한다.
- 트렌젝션처리(commit, rollback)도 여기서 한다.
- 서비스에 해당하는 DAO클래스를 호출해서 연결DB에서 sql문을 실행시키는 기능을한다.
- 커넥션을 열고 닫는거 까지 전부 여기서이용한다.

```java
public List<MemberDTO> selectAllMember(){
		Connection conn= JDBCTemplate.getConnection();
		List<MemberDTO> members = dao.selectAllMember(conn);
		JDBCTemplate.close(conn);
		return members;
		
	}
  --------------------------------------------------------
public List<MemberDTO> selectAllMember(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER";
		List<MemberDTO> members = new ArrayList();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next())
				members.add(getMember(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return members;
    
```

- JDBCTemplate 에는 Connection객체를 생성해주는 기능을 가진 메소드가 들어가있다.
- Service 클래스에서 DB접속을하고 DAO에 보내서 DAO에서 사용을한다.
- 그리고 사용이 다끝난후 Service에서 닫아준다...
- 이렇게 Service에서 Connection을 관리해줄수가있다.
- 코드가 더욱 간결해지고 따로따로 관리해주기가 수월해진다.





