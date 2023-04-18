# 🔖 목차
1. [JDBC 사용 객체](#1-JDBC-사용-객체)<br/>
2. [DB접속](#2-DB접속)<br/>
3. [sql문실행](#3-sql문실행)<br/>
4. [ResultSet이용하기](#4-ResultSet이용하기)<br/>
5. [DML](#5-DML)<br/>
6. [전체 출력하는 예시](#6-전체-출력하는-예시)<br/>





<br/>


## JDBC
- 자바에서 데이터베이스에 접근할수 있게해주는 API를 말한다.
- 이API를 이용해서 데이터베이스에 저장되어있는 정보를 사용및 수정 등등이 가능하다.
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



## Library 등록

- 전부 설정이 완료됐다면 jar파일을 이클립스 Library에 등록을 해줘야한다.
- 프로젝트를 만들때 랑 만들고나서 전부 다 가능하다 

![프로젝트](https://user-images.githubusercontent.com/126074577/231724939-eb56919a-a2a8-4ecd-84a2-fc063ab2ddba.png)

- 이런식으로 프로젝트를 만들때 Classpath 을 누른후 ADD External JARs... 을눌러서
- jar파일을 등록해주면 된다.

<br/>

# 1. JDBC 사용 객체
- JDBC에서 사용하는 객체는 여러가지가있다.
- <code>DriverManager</code>, <code>Connection</code>, <code>Statement</code>, <code>PreparedStatement</code> , <code>ResultSet</code>

<br/>

## DriverManager 

- 데이터 원본에 JDBC드라이버를 통하여 커넥션을 만드는 역할
- Class.forName() 메소드를 통해 생성되며 반드시 예외처리를 해야 함
- 직접 객체 생성이 불가능하다.


<br/>

## Connection

- 특정 데이터 원본과 연결된 커넥션을 나타내며 Statement객체를 생성할 때도
- Connection객체를 사용하여 createStatement()메소드를 호출하여 생성한다.
- SQL문장을 실행시키기 전에 우선 Connection 객체가 있어야한다.

<br/>

## Statement
- Connection객체에 의해 프로그램에 리턴되는 객체에 의해 구현되는
- 일종의 메소드 집합 정의
- Connection클래스의 createStatement() 메소드를 호출하여 얻어지며
- 생성된 Statement객체로 질의문장을 String객체에 담아
- 인자로 전달하여 executeQuery() 메소드를 호출하여 SQL

<br/>

## PreparedStatement
- Connection객체의 prepareStatement()메소드를 사용하여 객체 생성
- SQL문장이 미리 컴파일 되고 실행 시간 동안 인수 값을 위한 공간을
- 확보한다는 점에서 Statement와 다름
- 각 인수에 대해 위치홀더(?)를 사용해 SQL문장을 정의할 수 있게한다.


<br/>

## ResultSet
- SELECT문을 사용한 질의 성공 시 ResultSet반환
- SQL질의에 의해 생성된 테이블을 담고 있으며
- 커서(cursor)로 특정 행에 대한 참조 조작

# 2. DB접속
- 이제 연동해서 사용하기위해
- DB에접속하는 것부터 배워보자

<br/>


## jar파일등록여부확인

- 먼저 프로젝트에서  DB에 접속할려면
- jar파일이 제공하는 클래스가 있는지 확인해야한다.

```java
try {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  }catch(ClassNotFoundException e) {
			e.printStackTrace();
      
```
- **oracle.jdbc.driver.OracleDriver 는 고정값이기때문에 항상 써줘야한다**
- **그리고 위에서 말햇듯이 ClassNotFoundException 예외처리를 해줘야한다**

<br/>


##  DriverManager클래스를 이용해서 접속하는 객체를 만들어준다.
- DriverManager클래스가 제공하는 getConnection() static메소드를 이용해서
- Connection객체를 가져온다.
- getConnection() 메소드는 Connection객체를 반환한다.
- 이거또한 호출했으면 닫아줘야한다. 
  - getConnection이용하기 - > 3개의 매개변수가 선언되어있음
  - 1. 접속할 DB의 주소, 버전정보, 포트번호 String
  - 2. DB접속 계정명 String
  - 3. DB접속 계정 비밀번호 String

```java
Connection conn = null
try{
  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
  
}catch(SQLException e) {
			e.printStackTrace();  
}finally{
    try {
        if(conn!=null)conn.close();
       }catch (SQLException e) {
				e.printStackTrace();
```

<br/>

## setAutoCommit
- 트렌젝션을 개발자가 직접 하기위해 사용한다.
- 하나만 있으면 안써도 상관업지만
- 여러개가 있을때 하나가 오류가 떠버리면 나머지도 커밋을 해버리기때문에 오류가떳을떄 멈출수잇게 false로 바꿔준다
- setAutoCommit : 자동으로 커밋을 하겟다라는뜻 기본값이 true
- 직접개발자가 커밋할려면

```java
setAutoCommit(false);
```

<br/>

# 3. sql문실행
- DB에 접속을 했으니 접속된 DBsql문을 실행하고 결과를 가져와보자
- sql문을 실행하기 위해서 실행할 객체가 필요하다.
- <code>Statement</code>,<code>PreparedStatement</code> : 문자열로 작성한 sql구문을 연결된 DB에서 실행하는 객체
- sql문을 실행하려면 Statement의 멤버메소드 <code>executeQuery()</code>, <code>excuteUpdate()</code>메소드를 이용한다.
  - SELECT : executeQuery("sql문") 실행 - > ResultSet객체를 반환
  - INSERT, UPDATE , DELETE : executeUpdate("sql")실행 - > int 반환
- **객체들은 close를 통해 닫아줘야하는 것들이있는데**
- **생성한 순서 반대순서로 닫아줘야한다**
<br/>

## 쿼리문 작성
- 문자열 변수에 sql문을 저장할때는 ; 을 생략한다!
- 등록회원 전체를 가져와보자
```java
 String sql = "SELECT * FROM MEMBER";
 ```
 <br/>
 
 ## Statement객체 가져오기
 - Connection클래스가 제공하는 멤버 메소드인 createStatement()메소드를 이용
 
 ```java
 Statement stmt = null;
try{
  stmt =  conn.createStatement();
}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
 ```
 - Statement객체 도 close를 해줘야한다.
 
 <br/>
 
 
## 쿼리문 실행
- Statement제공하는 executeQuery() 실행하고 반환은 ResultSet객체로 받는다.

```java
ResultSet rs = null;
try{
  rs = stmt.executeQuery(sql);
}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
 ```
- ResultSet 또한 close를 해준다.

<br/>

# 4. ResultSet이용하기
- 반환된 SELECT문의 실행결과는 ResultSet객체가 제공하는 메소드를 이용해서 컬럼별 값을 가져온다.
  - next() : 데이터의 row를 지정 - > row데이터를 가져옴 반환형 : boolean
  - get자료형[String,Int,Date]("컬럼명"||인덱스번호)
  - getString() : char,varchar2,nchar,nvarcjar2 자료형을 가져올때
  - getInt() / getDouble() : num자료형을 가져올때
  - getDate() / getTimeStamp() : date, timestamp

## 반복문
- 반환형이 boolean 값이기때문에
- 반복문을통해 한번에 불러올수도있다.

```java
while(rs.next()/*첫번째 row를 지정함*/) {
	        String memberid=rs.getString("member_id");
					String memberPwd=rs.getString("member_pwd");
					int age=rs.getInt("age");
					Date enrollDate= rs.getDate("enroll_date");

```

<br/>

## DB의 row을 가져왔을때 자바에서는 클래스로 저장해서 관리한다.

```java
Member m = new Member();
				if(rs.next()) {
					m.setMemberId(rs.getString("member_id"));
					m.setMemberPwd(rs.getString("member_pwd"));
					m.setMemberName(rs.getString("member_name"));
					m.setGender(rs.getString("gender"));
					m.setEmail(rs.getString("email"));
					m.setPhone(rs.getString("phone"));
					m.setAddress(rs.getString("address"));
					m.setHobby(rs.getString("hobby"));
					m.setEnrollDate(rs.getDate("enroll_date"));
 }
 ```
     
<br/>

## List로 관리
- List로 저장해서 관리도가능하다.

```java
List<Member> members = new ArrayList<Member>();
				while(rs.next()) {
					Member m = new Member();
					m.setMemberId(rs.getString("member_id"));
					m.setMemberPwd(rs.getString("member_pwd"));
					m.setMemberName(rs.getString("member_name"));
					m.setGender(rs.getString("gender"));
					m.setEmail(rs.getString("email"));
					m.setPhone(rs.getString("phone"));
					m.setAddress(rs.getString("address"));
					m.setHobby(rs.getString("hobby"));
					m.setEnrollDate(rs.getDate("enroll_date"));
					members.add(m);
				}
```

<br/>

## 메소드에 저장해서 사용하기

- 위에처럼 사용한다면 컬럼이생길때 마다 일일히 모든 메소드들을 바꿔줘야한다
- 굉장히 비효율적이라고 볼수가있다.
- 그래서 row를 저장하는 메소드를 만든후 그메소드를 이용하는방법이 있다.

```java
//getMember 메소드에 저장하여 사용하
private MemberDTO getMember(ResultSet rs) throws SQLException {
		MemberDTO m = new MemberDTO();
		m.setMemberId(rs.getString("member_id"));
		m.setMemberPwd(rs.getString("member_pwd"));
		m.setMemberName(rs.getString("member_name"));
		m.setGender(rs.getString("gender").charAt(0));
		m.setAge(rs.getInt("age"));
		m.setPhone(rs.getNString("phone"));
		m.setEmail(rs.getString("email"));
		m.setAddress(rs.getString("address"));
		m.setHobby(rs.getString("hobby").split(","));
		m.setEnrollDate(rs.getDate("enroll_Date"));
		return m;

	}
-----------------------------------------------------------------------
// List에저장
public List<MemberDTO> selectAllMember() {
		// DB에 접속해서 member테이블에 있는 전체데이터를 가져오는 기능
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER";
		List<MemberDTO> members = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 다수값 - > 여러개면 while문, 0~1개로 출력되면 if로 출력
			while (rs.next()) {
			// 이거한줄로 가능하다.
			mbers.add(getMember(rs));
-------------------------------------------------------------------------------
//그냥 사용
public MemberDTO searchId(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberDTO m = null;
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID ='" + id + "'";
		// 이렇게도가능
		// List<MemberDTO> members = selectAllMember();
		// members.stream().filter(m1-	>m1.getMemberId().equals(id)).collect(Collectors.toList()).get(0);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				m = getMember(rs);
```

<br/>

# 5. DML
- 이클립스 안에서도 DML구문(insert, update, delete문)을 사용이가능하다.
- 위에서말햇던 <code>executeUpdate</code>를사용한다.
  - sql문을 작성할때 리터럴형태에 맞춰서 작성을 해줘야한다.

```java
sql="INSERT INTO MEMBER VALUES('inhoru','inhoru',"
						+ "'김아무','M',26,'kim@kim.com', "
						+ "'0101234145','도봉구','영화감상,애니감상,코딩',SYSDATE)";

int result = stmt.executeUpdate(sql);
```
- executeUpdate는 숫자로 반환하기때문에 int를 사용한다.

<br/>


# 6. 전체 출력하는 예시
- 위에꺼를 사용해서 전체를 출력하는 코드다,

```java
public class MyjdbcTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Department> departments = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BS", "BS");

			conn.setAutoCommit(false);

			String sql = "SELECT * FROM DEPARTMENT";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Department m = new Department();
				m.setDeptID(rs.getString("dept_id"));
				m.setDeptTitle(rs.getString("dept_title"));
				m.setLocationId(rs.getString("location_id"));
				// 밑에꺼처럼 가능 근대 가독성이 없어서 추천하지않는다.
//				m.setDeptID(rs.getString(1));
//				m.setDeptTitle(rs.getString(2));
//				m.setLocationId(rs.getString(3));
				departments.add(m);
			}
			departments.forEach((e) -> System.out.println(e));

		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
	}
}
```


