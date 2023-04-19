# 🔖 목차
1. [JDBC 사용 객체](#1-JDBC-사용-객체)<br/>
2. [DB접속](#2-DB접속)<br/>
3. [sql문실행](#3-sql문실행)<br/>
4. [ResultSet이용하기](#4-ResultSet이용하기)<br/>
5. [DML](#5-DML)<br/>
6. [공통 클래스사용](#6-공통-클래스사용)<br/>
7. [파일 입출력이용]




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

## 입력받은 데이터로 DML사용하기
- 우리가 sql문에 직접쓰지 않고 스캐너로 입력받은 데이터를 넣어서 DML을구문을 사용할수가있다.

```java
//입력받은 이름으로 데이터찾기
public List<MemberDTO> searchName(String name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberDTO m = null;
		List<MemberDTO> members = new ArrayList();
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE'%" + name + "%'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				members.add(getMember(rs));

			}
---------------------------------------------------------------------
//입력받은정보로 INSERT하기
public int insertMember(MemberDTO m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		String sql = "INSERT INTO MEMBER VALUES('" + m.getMemberId() + "','" + m.getMemberPwd() + "','"
				+ m.getMemberName() + "','" + m.getGender() + "'," + m.getAge() + ",'" + m.getEmail() + "','"
				+ m.getPhone() + "','" + m.getAddress() + "','" + String.join(",", m.getHobby()) + "',DEFAULT)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			if (result > 0) {
				conn.commit();

			} else {
				conn.rollback();

			}
----------------------------------------------------------------------------
//입력받은 데이터로 업데이트하기
public int updateMember(MemberDTO member) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		String sql = "UPDATE MEMBER SET MEMBER_NAME = '" + member.getMemberName() + "',AGE=" + member.getAge()
				+ ",email='" + member.getEmail() + "'," + "address='" + member.getAddress() + "' WHERE MEMBER_ID='"
				+ member.getMemberId() + "'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			if (result > 0) {
				conn.commit();

			} else {
				conn.rollback();

			}
```

- 이런식으로  입력받은 데이터를 문자열로 변환해서 SQL문에 사용할수가있다.

<BR/>



# 6. 공통 클래스사용
- 지금까지 위에서는 하나의 메소드를 만들때마다 계속 무조건 써주어야 햇던것들을 써주곤했다.
- 예를 들어 Connection,Statement,close,commit,rollback......등등 메소드를 만들때마다 써주엇다
- 굉장히 비효율적이고 시간도 오래걸린다.
- 하나의 클래스에 기능들을 분산해서 만들수가있다.
- 이기능들을 static메소드로 만들어서 메소드를 호출하면 사용이가능하도록 만들어서 사용할수가있다.
- JDBCTemplate 라는 클래스를 생성햇다고 치고 거기안에 메소드들을 생성해보겟다.

<br/>

## Connection
```java
public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
```
<br/>

## close
```java
//Connection close
	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//Statement close
	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//ResultSet close
	public static void close(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed())
				rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
```

<br/>

## commit rollback

```java
//commit	
public static void commit(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed())conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
//rollback	
public static void rollback(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed())conn.rollback();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
```

<br/>

## 적용
- 위에있는 메소드를 이용해서 다시한번 DTO를 작성해보겟다.

```java
public List<MemberDTO> selectAllMember() {
		//이런식으로 코드 한줄로 DB에 접근할수있다.
		Connection conn= JDBCTemplate.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER";
		List<MemberDTO> members = new ArrayList();
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 다수값 - > 여러개면 while문, 0~1개로 출력되면 if로 출력
			while (rs.next()) {
} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
			JDBCTemplate.close(conn);
			return members;
		}

	}			

```

- 원래였으면 Class.forName을써서 확인을하고 드라버에서가서 버전정보 등등 전부 써줘야햇지만
- 이미 클래스안에 메소드를 만들어놧기때문에 호출을한다면 쓸필요없이 바로된다.
- close도 마찬가지로 메소드호출만으로 해결이가능하다.

<br/>


# 7. 파일 입출력이용
- 우리는 지금까지 <CODE>Class.forName</CODE> 이나 <CODE>DriverManager.getConnection</CODE>에 직접 버전정보나 아이디 비밀번호를 직접 적엇다.
- 그렇게되면 남이 우리코드를 볼때 아이디나 비밀번호를 볼수가있다.
- 그렇게되면 db에정보를 유출시키게되는것이다.
- 그런걸 방지하기위해 하나의 파일에 정보들을 입력하고 그파일로 실행시키는 걸 할수가있다.
- 우리가 배웟던 파일입출력을 이용해보자

## resources
- resources파일에 우리의 정보들이 담긴파일들을 보관할수가있다.

![resources](https://user-images.githubusercontent.com/126074577/233077268-a3271a1b-f883-4940-97f8-98172b802938.png)

- 이런식으로 resources파일에 파일들을 저장시켯다.
- 이제 이걸이용해보자

```java
// Connection
public static Connection getConnection() {
		Connection conn = null;
		//절대경로가 필요함.
		//driver.properties를 불러올려면 절대경로로 불러와야한다 위치는 bin에있다.
		//클래스에잇는 위치를 가져올려고 getResource를 사용 (JDBCTemplate이 있는 최상위폴더는 bin폴더에있다.)
		String path = JDBCTemplate.class.getResource("/driver.properties").getPath();
		Properties driver = new Properties();
		try (FileReader fr = new FileReader(path)){
			driver.load(fr);
			Class.forName(driver.getProperty("drivername"));
			conn = DriverManager.getConnection(driver.getProperty("url"),driver.getProperty("user"),driver.getProperty("pw"));
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return conn;
--------------------------------------------------------------------------------------------
```
- 이렇게 Connection 에 작성해야하는필수 정보들을 driver.properties 파일에 적어두고
- 불러와서 사용이가능하다.
- **한가지 알아야할점은 FileReader도 닫아줘야하기때문에 try()안에써서 자동으로 닫아주게만들어줘야한다.**



<br/>

## sql파일
- 우리가 쿼리문을 작성하는 sql도 파일에 저장해서 위와같이 사용이가능하다.
- 먼저 파일을불러오구 읽어야하기에 우리가 컬렉션때 배웟던 <code>FileReader</code>을이용한다.
- 먼저 파일내용들을 살펴보자

![파일내용](https://user-images.githubusercontent.com/126074577/233078609-5c571db1-fb87-4291-aad5-097f67a8270a.png)

- 이런식으로 되어있다
- 이걸 읽어와서 안에있는 것들을 하나씩사용이가능하다.

```java
private Properties sql = new Properties();

	{
		try {
			String path = BoardDao.class.getResource("/Board_sql.properties").getPath();
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```
- 반드시 실행되야하기에 초기화블럭에다가 써줄수가있다.
- 먼저 파일에서 load를 해와야 안에있는걸 사용할수있기때문이다.

<br/>

```java
public List<BoardDTO> selectAllBoard(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = this.sql.getProperty("selectAllBoard");
		List<BoardDTO> boards = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next())
				boards.add(getBoard(rs));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return boards;
	}
```
- sql문에 쿼리문대신 파일에있는 걸 호출해서 sql문을 작성할수가있다.

<br/>

# 8. 위치홀더
- 우리는 sql문을 작성할때 계속 DTO에 get/set을이용해서 우리가원하는값을 쿼리문에썻는데
- 이제는 **위치홀더(?)** 를 이용해서 쿼리문을 쓰지않고 위치홀더만 이용해서 값을넣을수가있다.
- <code>PreparedStatement</code> 를이용한다. 

	- 우리가 기존에쓰던 Statement 를 상속받는다
	- 그래서 닫아줄때 Statement로 닫아줘도 닫을수가있다.

<br/>


- 사용방법을 알아보자

```java
public int insertMember(Connection conn,MemberDTO m) {
		PreparedStatement pstmt=null;
		int result=0;
		//String sql="INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";
		String sql=this.sql.getProperty("insertMember");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, String.valueOf(m.getGender()));
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, String.join(",",m.getHobby()));
			
			result=pstmt.executeUpdate();
			
```
- setString() 안에 순서대로 인덱스번호를 쓴후 원하는 값을 넣우주면 ? 안에 우리가 원하는값을 넣을수가있다.
- Statement랑 다른것은 pstmt.executeUpdate(); 안에 sql문 을안넣어줘도된다.
- 이미 저장이되어있기때문에 그냥 써주면 된다.

<br/>

## 위치홀더에 %등등 사용
- 위치홀더를 사용하면 자동으로 문자열양쪽에 '문자열'  이런형태로 생긴다.
- 만약에 LIKE를 사용한다면 % 가 필요한데 자동으로 문자열에만 ''이생기기때문에 %를 ' ' 안에넣을수가없다.
- 그럴땐 두가지방법이있다.

<br/>

## 쿼리문 문자열결합
```java
String sql="SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE '%'||?||'%'";
```
- 쿼리문자체에서 문자열을 결합해준다

<br/>

## setString에서 결합
```java
pstmt.setString(1,"%"+name+"%")
```
- 셋팅하는쪽에서 문자열로 결합해서 위치홀더에 넣어준다

<br/>

## 다중검색
- 우리가 다중검색을할때 조회를 할때 2개 데이터가필요하다.
- 만약에 게시글의 항목(제목,내용,작성자) 조회를한다고햇을때

	- 검색할 항목(컬럼명) 과 검색어 2가지가필요하다.

- 이때 Map을이용해서 우리가 원하는데이터를 보낼수가있다.

```java
public Map inputSearch() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==== 게시글 항목별검색 ====");
		System.out.println("항목 1. 제목 2. 내용 3. 작성자 : ");
		int colCho = sc.nextInt();
		sc.nextLine();
		String col = "";
		switch(colCho) {
			case 1 : col = "board_title";break;
			case 2 : col = "board_content";break;
			case 3 : col = "board_writer";break;
		}
		System.out.print("검색어 : ");
		String keyword = sc.nextLine();
		return Map.of("col",col,"keyword",keyword);
		
		
		
	}
	
```
- 컬럼과 키워드값을 반환시켜준다.

<br/>


```java
public void selectSearchBoard() {
		//검색할 항목(컬럼명), 검색어
		Map param = view.inputSearch();
		List<BoardDTO> boards = service.searchBoard(param);
		view.printBoards(boards);
```
- List로하는 이유는 값이 여러개일수도있기때문이다.

<br/>

```java
public List<BoardDTO> searchBoard(Map param){
		Connection conn = getConnection();
		List<BoardDTO> boards = dao.searchBoard(conn,param);
		close(conn);
		return boards;
	}
``` 
- 서비스 에와서 커넥션을해준후
- dao에 커넥션과 파람을 보내준다.

<br/>
- 여기가 중요하다. dao부분이다.

```java
```java
//sql = selectBoardByCol = SELECT * FROM BOARD WHERE #COL LIKE ?
public List<BoardDTO> searchBoard(Connection conn, Map param){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> boards = new ArrayList<>();
		String sql = this.sql.getProperty("selectBoardByCol");
		//where절에 ?를 사용한다면 '문자열'이되기때문에 재대로 찾을수가없다.
		// 그래서 replace를 이용해서 임의의수를 문자열로 원하는 문자열로 바꿔준다.
		sql = sql.replace("#COL", (String)param.get("col"));
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+(String)param.get("keyword")+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO b = getBoard(rs);
				b.setComments(selectBoardComment(conn, b.getBoardNo()));
				boards.add(b);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return boards;
		
```

<br/>


# 8. 테이블연결
- 객체기반으로 설계를 햇다면 테이블마다 객체를 만들어서 연결해줘야한다.
- 자바에서는 객체간의 참조관계가 없기때문이다
- 그래서 객체를 생성해서 집어넣어줘야한다.
- 그래서 연결할테이블의 DTO 를 만들어서 서로연결해줘야한다.

<br/>

## 게시물과 댓글

- 게시글 을조회 하면서 댓글의 수를 조회해보자
- 먼저 게시글 객체와 댓글 객체를 따로만들자



```java
//Board DTO를 만들엇다고 치자
//게시글

public BoardDTO getBoard(ResultSet rs) throws SQLException {
		BoardDTO b = new BoardDTO();
		b.setBoardNo(rs.getInt("board_no"));
		b.setBoardTitle(rs.getString("board_title"));
		b.setBoardContent(rs.getString("board_content"));
		b.setBoardWriter(rs.getString("board_writer"));
		b.setBoardDate(rs.getDate("board_date"));
		return b;
	}
-------------------------------------------------------------
//BoardComment DTO를 만들엇다고 치자
//댓글
private BoardComment getComment(ResultSet rs) throws SQLException {
		BoardComment bc = new BoardComment();

		bc.setCommentNo(rs.getInt("comment_no"));
		bc.setCommentContent(rs.getString("comment_content"));
		bc.setCommentWriter(rs.getString("comment_writer"));
		bc.setCommentDate(rs.getDate("comment_date"));
		return bc;
	}

------------------------------------------------------------------
// 서로 board_no이랑 board_ref로 연결되있는 상태이다.
//selectBoardCommentByBoardNo 쿼리문은  SELECT * FROM BOARD_COMMENT WHERE BOARD_REF=? 상태이다.
public List<BoardComment> selectBoardComment(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardComment> comments = new ArrayList<>();
		String sql = this.sql.getProperty("selectBoardCommentByBoardNo");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			while (rs.next())
				comments.add(getComment(rs));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return comments;
	}
```

- 이렇게 객체를 만들어서 서로 연결을해줄수가있다.
- Comment가 List인 이유는 댓글은 여러개이기때문이다.

<br/>

- 이제 DTO에선언햇던  Comment에 값을넣어보자

```java
public List<BoardDTO> selectAllBoard(){
		Connection conn = getConnection();
		List<BoardDTO> boards = dao.selectAllBoard(conn);
		for(BoardDTO b : boards) {
			b.setComments(dao.selectBoardComment(conn, b.getBoardNo()));
			
			
		}
		close(conn);
		return boards;
```
- 보드리스트를 을 가져와서 반복문을돌려서 
- 리스트에잇는값을 가지고 Comments 에넣어준것이다.

<br/>








