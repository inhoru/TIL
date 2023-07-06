## 🔖목차
1. [동작 구조](#1-동작-구조)<br/>
2. [config](#2-config)<br/>
3. [mapper](#3-mapper)<br/>
4. [mapper사용](#4-mapper-사용)<br/>
5. [select](#5-select)<br/>
6. [Map](#6-Map)<br/>



<br/>

## MyBatis

- 데이터의 입력 과 조회 수정 삭제등 보다 편하게 하기위해 만들어 xml이다.
- 기존에 JDBC로 구현했던 상당부분들을 코드와 파라미터 설정 결과매핑을
- xml설저을 통해 쉽게 구현할수 있게해주는 프레임워크다.
- model.vo를 myBatis가 해결을해준다.



<br/>



## 라이브러리 

- myBatis도 라이브러리이기때문에 jar파일을 다운받아서 사용한다.

https://mybatis.org/mybatis-3/ko/index.html 

- 시작하기를 눌러 mybatis.jar파이을 다운 받는다.
- 그후 lib폴더에 jar파일을 추가하면된다.



<br/>



# 1. 동작 구조

- MyBatis는 전용 라이브러리를 이용해서 동작을한다.

- MyBatis활용 객체(Session)를 생성해서 사용을한다

  ![image](https://github.com/inhoru/TIL/assets/126074577/05b6099f-ed57-4f6b-aa69-754d01df2eac)



<br/>







# 2. config

- mybatis 를사용하기위해서는 먼저 config.xml파일을 생성후 설정해야한다.
- ‘resources’라는 Source Folder를 생성하고 mybatis-config.xml 파일 등록
- 여기서 xml파일이름은 어떤이름을해도 상관이없다.

<br/>



## xml설정


- 먼저 xml최상단에 xml형식을 지정해서 위와같은 내요을 작성하여
- mybatis config설정임을 선언해준다.

![image](https://github.com/inhoru/TIL/assets/126074577/630ae601-38bf-4ad7-ab2c-02474f7e5411)


<br/>

## environment
- MyBatis에서 연동할 DataBase 정보를 등록해준다.
- 연결할 DB에 대한 정보를 설정하는 태그 
- 1개 이상의 DB연결정보를 설정할 수 있다.

```xml
<environments default="mybatis">
		<environment id="mybatis">
```
- default db와 id를 정해서 연동할수가있다.

<br/>



## **transactionManager**

- 트랜잭션을 처리하는 방법을 설정해주는 태그다

```xml
<transactionManager type="JDBC"/>
```

<br/>

## **dataSource**

- DB 연결에 필요한 정보를  등록하는 태그
- 드라이버, 2. DB서버 주소, 3. 사용계정, 4. 계정비밀번호  등을 적는다.

```xml
<dataSource type="POOLED">
				<property name="driver" value="oracle.jdbc.driver.OracleDriver"/>
				<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"/>
				<property name="username" value="mybatis"/>
				<property name="password" value="mybatis"/>			
			</dataSource>
```

- 여기까지**environments**에 db 연결정보 설정이다.



## db연동 전체

- db연동 전체코드로 봐보자

```xml
<environments default="mybatis">
		<environment id="mybatis">
		<!-- 트랜잭션을 처리하는 방법설정 -->
			<transactionManager type="JDBC"/>
			<!--
			DB 연결에 필요한 정보를  등록하는 태그
			1. 드라이버, 2. DB서버 주소, 3. 사용계정, 4. 계정비밀번호  
			-->
			<dataSource type="POOLED">
				<property name="driver" value="oracle.jdbc.driver.OracleDriver"/>
				<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"/>
				<property name="username" value="mybatis"/>
				<property name="password" value="mybatis"/>			
			</dataSource>
		 </environment>
	</environments>
	
```

- 이렇게 mybatis에 연동을 시킬수가있다.



<br/>



# 3. mapper

- 사용하고자 하는 쿼리문이 정의된 mapper파일 등록하는 태그이다.

```xml
 <mappers>
		<mapper resource="/mappers/student-mapper.xml"/>
</mappers> 
```

- 이렇게 리소스 파일 밑에 있는 mappers 폴더에있는xml을 등록을 해주는걸로
- config설정을 마친다.
- 아래에서 전체코드로 봐보자

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<!-- 
		연결할 DB에 대한 정보를 설정하는 태그 
		1개 이상의 DB연결정보를 설정할 수 있다.
		environment태그를 이용한다
	-->
	<environments default="mybatis">
		<environment id="mybatis">
		<!-- 트랜잭션을 처리하는 방법설정 -->
			<transactionManager type="JDBC"/>
			<!--
			DB 연결에 필요한 정보를  등록하는 태그
			1. 드라이버, 2. DB서버 주소, 3. 사용계정, 4. 계정비밀번호  
			-->
			<dataSource type="POOLED">
				<property name="driver" value="oracle.jdbc.driver.OracleDriver"/>
				<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"/>
				<property name="username" value="mybatis"/>
				<property name="password" value="mybatis"/>			
			</dataSource>
		 </environment>
	</environments>
	<!-- 실행할 sql문을 설정한 mapper를 등록 -->
	 <mappers>
		<mapper resource="/mappers/student-mapper.xml"/>
	</mappers> 
</configuration>
```





<br/>



# 4. mapper 사용

- 이제설정을 끝마쳣으니 사용법에대해 알아보자
- mapper을 사용하기전에 mybatis만의 내장별칭이있는데
- 자바랑 살짝다르니 알고있자

![image](https://github.com/inhoru/TIL/assets/126074577/10a93fa8-41b4-4bcb-8c78-6b06db3be80e)


<br/>



## Session

- mybatis가 제공하는 SqlSession객체를 통해 쿼리문들을 실행할수가있는데
- 먼저  Template를 만들어줘야한다.
- static로 공용 메소드로 선언을해준다.
- SqlSession객체를 생성하는 방법
  - SqlSessionFactiryBuilder클래스의 build()메소드 이용
  - SqlSessionFactiryBuilder생성
  - build()메소드를 실행, build()메소드의 인수로 mybatis-config.xml파일을 전달

- SqlSessionFactory클래스를 가져올 수 있음
  - openSession()메소드를 이용
  - 인수로 true,false설정 -> autoCommit에 대한 설정
- SqlSession클래스를 가져온다.



<br/>



```java
public class SessionTemplate {
	
	public static SqlSession getSession() {
		SqlSession session=null;
		String file="mybatis-config.xml";

		try(InputStream	is = Resources.getResourceAsStream(file);) {
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			SqlSessionFactory factory=builder.build(is);
			session=factory.openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		
		}
		return session;
		
	}
}
```



- 위와같은 방식으로 SqlSession객체를 생성해줄수가있다.

<br/>



## 사용

- 이제 설정을 모두 마쳤으니 mvc패턴으로 실제로 만들어보겟다
- 기본적으로 jdbc로 햇던것과 비슷하지만 session을 통해 더욱 간단하게 만들수가있다.



<br/>

- controller

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
	Student s=	Student.builder().studentName(name).studentTel(phone).studentEmail(email).studentAddress(address).build();
		int result=new StudentService().insertStudentAll(s);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result>0?"<h2>성공</h2>":"<h2>실패</h2>");
					
	}
```




- service

```java
public int insertStudentAll(Student s) {
	SqlSession session=getSession();
	int result=dao.insertStudentAll(session,s);
	if(result>0)session.commit();
	else session.rollback();
	session.close();
	return result;
}
```

  

- dao
  - dao에서는 기존에사용하던거랑 많이 다르다 
  - sql문을 실행할때 session이 제공하는 메소드를 호출하며된다.
  - selectOne(), selectList(), insert(), update(), delete() 등을 사용한다
  - statement인수는 "mapper namespace값.sql태그id값"
  - 파라미터 매개변수를 객체로 받아서 사용해야한다. (왜냐면 하나밖에 받지못하기때문에)

```java
public int insertStudentAll(SqlSession session,Student s) {
		return session.insert("student.insertStudentAll",s);
		
	}
```

- 위가 같이 코드 한줄로 dao를 마칠수가있다.
- 그렇다면 sql문은 어디에다쓰냐?
- 그건 바로 mappers config.xml에 쓴다
- 바로알아보자



<br/>

## mappers-config.xml

- dao에서 사용할 sql문은 여기서 작성을한다.

- 실행할 sql문에 맞는 태그를 선언하면된다.

- select,insert,update,delect 등등 태그가있다.

  - sql문은 시작태그와 끝태그 사이에 작성  ; 를 작성하지 않는다. 

    

<br/>

- 먼저 mybatis설정과똑같이 상단에 설정해야할게있다.

```jsp
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Maper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="student">
```

- namespace 는 외부에서 접근할수있는 이름이다.
- 그후 그안 작성될태그들을 적는다.

```jsp
<insert id="insertStudent">
		INSERT INTO STUDENT VALUES(SEQ_STUDENT.NEXTVAL,'유지승','01012341234','YOO@YOO.COM','경기도시흥시',DEFAULT)
	</insert>
```

- 이런식으로로 insert문을 작성할수가 있다.

<br/>



## 파라미터

- 파라미터값을 받을때는 type 속성을 적어줘야한다.
- type 속성은 위에서 봣듯이 mybatis 만의 내장별칭을 써줘야한다.
- 그후 #{객체필드이름}  을 써서 사용이가능하다.

```jsp
<!-- preparedStatement 쓰는거랑 똑같다 즉 위치홀더를 쓴거랑 같은거다 -->
	<insert id="insertStudentByName" parameterType="string">
		INSERT INTO STUDENT VALUES(SEQ_STUDENT.NEXTVAL,#{name},'01012341234','YOO@YOO.COM','경기도시흥시',DEFAULT)
	</insert>
```



-  이런식으로 문자열이면 String 숫자면 int 등등 타입을 적어줘야한다.



## 객체

- 객체를 파라미터값으로 받는다면
- 그객체에 패키지이름부터 클래스이름까지전부 적어줘야한다.

```jsp
<!-- type을 작성할때 클래스를 작성하려면 패키지명까지 작성을 해야한다. -->
	<insert id="insertStudentAll" parameterType="com.mybatis.model.vo.Student">
		INSERT INTO STUDENT VALUES(SEQ_STUDENT.NEXTVAL,#{studentName},#{studentTel},#{studentEmail},#{studentAddress},DEFAULT)
	</insert>
```



- #{필드이름}으로 객체의 필드값을 가져와서 사용할수가있다.
-  객체를 사용할때 vo에 만들어서 사용해주면된다.

<br/>



# 5. select

- select문도 사용이가능하지만 살짝다르다

- 반드시 두개의 속성을 작성을해야한다.

  - id -> sql문을 지칭하는 값
  -  resultType||resultMap -> 쿼리문의 실행결과를 반환할 타입을 지정
    -  resultType : java코드로 작성되어있는 타입(기본,클래스타입) 
    - resultMap : mybatis에서 <resultMap>을 이용해서 만든 타입

- 컬럼명과 매핑할 java클래스 필드명이 같으면 resultType 다르면 resultMap만들어서 직접 매핑해줌.

  ​	 클래스간에 연관관계를 설정했을때(has a)사용 한다.





- 조회했을때 값이 한가지만 나온다면  selectOne 을사용하고
- 여러개의 값이나온다selectList 를사용한다.



```java
public Student selectStudent(SqlSession session,int no) {
		return session.selectOne("student.selectStudent", no);
		
	}

	public List<Student> selectStudentAll(SqlSession session){
		return session.selectList("student.selectStudentAll");
	}
```





<br/>



## **resultMap**

- vo객체와 resultest의 컬럼명 불일치할때 resultMap을 이용해서 맵핑 시켜줄수있다.

```jsp
 <resultMap id="구분" type="">
		 <id property="type에설정된 객체의 필드명" column="resultset컬럼명"> 
		 <result> 
		 //has a관게를 사용할떄
		 <associtation>
		 //리스트로객체를가지고있을때 
		 <collection> 
	
```



<br/>



- 필드값과 컬럼명이 다르다고 가정해고 map을 설정해겟다

```jsp
 <resultMap type="com.mybatis.model.vo.Student" id="studentMap">
	 	<id property="studentNo" column="student_no"/>
	 	<result property="studentName" column="student_name"/>
	 	<result property="studentTel" column="student_tel"/>
	 	<result property="studentEmail" column="student_email"/>
	 	<result property="studentAddress" column="student_addr"/>
	 </resultMap>
```
- pk값은 id로 설정해줘야하고
- 나머지 컬럼들은 result로 설정을해준다.
- column이 실제 컬럼값
- property가 필드이름이다.

```jsp
<select id="selectStudent" resultMap="studentMap" parameterType="_int">
		 SELECT * FROM STUDENT WHERE STUDENT_NO=#{no}
	</select>
```

- 주요할점은 resultMap="studentMap" 
- Map이기때문에 type말고 Map으로 속성값을줘야한다.





<br/>

# 6. Map
  - vo 객체를 만들어 두고 MyBatis 에서 맵핑을 해서 쓸수도 있지만
  - vo 객체를 만들지않고도 사용할수가있다.
  - 그렇게된다면 컬럼명과 맵핑이되어 컬럼명이 key값으로 사용을한다.


```java
    //controller
    Map data=new StudentService().selectStudentMap(no);
    request.setAttribute("s", data);
    	
    request.getRequestDispatcher("/views/student.jsp")
      .forward(request, response);
    
    //service
    public Map selectStudentMap(int no) {
      SqlSession session=getSession();
      Map result=dao.selectStudentMap(session,no);
      session.close();
      return result;
    }
    
    //dao
    public Map selectStudentMap(SqlSession session,int no) {
      return session.selectOne("student.selectStudentMap",no);
    }
    
    //mapper
    <select id="selectStudentMap" resultType="map" 
      parameterType="_int">
    	   		SELECT * FROM STUDENT WHERE STUDENT_NO=#{no}
    </select>
    
    //JSP
    <li>학생이름 : <c:out value="${s.STUDENT_NAME }"/></li>
    <li>학생전화번호 : <c:out value="${s.STUDENT_TEL }"/></li>
    <li>학생이메일 : <c:out value="${s.STUDENT_EMAIL }"/></li>
    <li>학생주소 : <c:out value="${s.STUDENT_ADDR }"/></li>
    <li>등록일 : <c:out value="${s.reg_date }"/></li>
    
```


- Map을사용하면 vo객체 생성하지않고 데이터들을 가져올수가있다.
- 여기서는 SELECT * FROM STUDENT 의 컬럼명들이 키값이된다.
- JSP에서 데이터들을 출력할때 키값인 컬럼명으로 불러올수가있다.



<br/>



## 다수의 데이터를 받을때


- 다수의 데이터를 받을때도 객체없이 사용할수있다.
- 다수의데이터를 받을때는 List를 사용하는데 어떻게 Map을보내지?
- List<Map>으로 제네릭선언을해주면 된다.

```java
    //controller
    List<Map> data=new StudentService().selectStudentListMap();
    		
    		data.stream().forEach(System.out::println);
    		
    		request.setAttribute("list", data);
    		
    		request.getRequestDispatcher("/views/student.jsp")
    		.forward(request, response);
    
    //service
    public List<Map> selectStudentListMap(){
    		SqlSession session=getSession();
    		List<Map> result=dao.selectStudentListMap(session);
    		session.close();
    		return result;
    	}
    
    //dao
    public List<Map> selectStudentListMap(SqlSession session){
    		return session.selectList("student.selectStudentListMap");
    	}
    
    //mapper
    
    <select id="selectStudentListMap" resultType="map">
    	 SELECT * FROM STUDENT
    </select>
    
    //jsp
    <c:forEach var="s" items="${list }">
    				<tr>
    					<td>${s['STUDENT_NO'] }</td>
    					<td>${s['STUDENT_NAME'] }</td>
    					<td>${s['STUDENT_TEL'] }</td>
    					<td>${s['STUDENT_EMAIL'] }</td>
    					<td>${s['STUDENT_ADDR'] }</td>
    					<td>${s['REG_DATE'] }</td>
    				</tr>
    
    </c:forEach>
    	 	
```    

- 제네릭을 map으로 설정해서 vo객체없이 리스트를 출력해줄수있다


<br/>














