# 🔖 목차

1. [CREATE](#1-CREATE)<BR/>
2. [기본테이블작성](#2-기본테이블작성)<BR/>
3. [COMMENT](#3-COMMENT)<BR/>
4. [제약조건](#4-제약조건)<BR/>
5. [PRIMARY KEY](#5-PRIMARY-KEY)<BR/>
6. [FOREIGN KEY](#6-FOREIGN-KEY)<BR/>
7. [CHECK](#7-CHECK)<BR/>
8. [DEFAULT](#8-DEFAULT)<BR/>
9. [제약조건이름지정 CONSTRAINT](#9-CONSTRAINT)<BR/>
10. [SELECT사용 AS](#10-AS)<BR/>
11. [ALTER](#11-ALTER)<BR/>
12. [DROP](#12-DROP)<BR/>


<BR/>



## DDL
- 데이터 정의 언어로 객체 를 만들고 수정하고 삭제하는 구문을 말한다.
- 생성 : CREATE 오브젝트명 ......
- 수정 : ALTER 오브젝트명 ......
- 삭제 : DROP 오브젝트명


# 1. CREATE
- 테이블생성 :  데이터를 저장할 수 있는 공간을 생성하는것
- 테이블을 생성하기 위해서는 저장공간을 확보하는데 확보할때 TYPE이 필요
- 오라클이 제공하는 타입중 자주 쓰는 타입에 대해 알아보자.
  - 문자형타입 :  CHAR, VARCHAR2, NCHAR, NVARCHAR2, CLOB
  - 숫자형타입 :  NUMBER
  - 날짜형타입 :  DATA, TIMESTAMP

## 문자형 타입
- CHAR(길이) : 고정형 문자열 저장타입으로 길이만큼 공간을 확보하고 저장한다. * 최대 2000바이트저장가능
- VARCHAR2(길이) : 가변형 문자열 저장 타입으로 저장되는 데이터만큼 공간확보하고 저장한다. *최대 4000바이트저장가능

```SQL
CREATE TABLE TBL_STR(
-- 6바이트씩들어감
    A CHAR(6),
    B VARCHAR2(6),
    C NCHAR(6),
    D NVARCHAR2(6)
);
```
- 이런식으로 테이블을 만들수가있다.
- 이제 데이터를 넣어보자

```SQL
INSERT INTO TBL_STR VALUES('ABC','ABC','ABC','ABC');
INSERT INTO TBL_STR VALUES('가나','가나','가나','가나');
SELECT * FROM TBL_STR;
---------------------------------------------------------
ABC   	ABC	ABC   	ABC
가나	가나	가나    	가나
```
- 보면 몇개는 띄어쓰기가 되어있다
- 이유는  NCHAR 는 바이트기반 VARCHAR은 글자수기반 이기때문이다
- 자세히 말할려면 어렵다.
- 그냥 결론적으로 말하겟다

  - **2000자 이하면 그냥 VARCHAR2를 쓰면된다.**

- 하지만 2000이상 엄청긴 문자열을쓴다면
- **CLOB를 사용하면된다 2가까지가능하다**

<BR/>

## 숫자형 자료형
- NUMBER : 실수, 정수 모두 저장이 가능함.
- 선언방법
- NUMBER : 기본값
- NUMBER(PRECISION, SCALE) : 저장할 범위 설정
- PRECISION :  표현할 수 있는 전체 자리수(1~38)
- SCALE : 소수점이하의 자리수(-84 ~ 127)

```SQL
CREATE TABLE TBL_NUM(
    -- 전체다출력
    A NUMBER,
    -- 수서자리는 반올림해서 정수만표현
    B NUMBER(5),
    -- 소수점 한자리만표시후 반올림
    C NUMBER(5,1),
    -- 소수점을 없애고 2칸앞으로 간다 지나온수는 0으로만듬
    D NUMBER(5,-2)
    
);
```
- 이런식으로 테이블을 만들수가있다.
- 이것도 자동형변환이 자유롭다

<BR/>

## 날짜형
- DATE, TIMESTAMP를사용한다


```SQL
CREATE TABLE TBL_DATE(
    BIRTHDAY DATE,
    TODAY TIMESTAMP
);
```
- 이런식으로 테이블을만든다
- 값을 넣어보자

<BR/>

- DATE

```SQL
INSERT INTO TBL_DATE VALUES('98/08/03','98/01/26 15:30:30');
INSERT INTO TBL_DATE VALUES(TO_DATE('98/08/03','RR/MM/DD'),
```

<BR/>

- TIMESTAMP

```SQL
TO_TIMESTAMP('98/01/26 15:30:30','RR/MM/DD HH24:MI:SS'));
```

- 이런형식으로 값을 넣을수가있다.

# 2. 기본테이블작성
- 테이블을 만드는방법을 알아보자
- 방법
  - **CREATE TABLE 테이블명예)BOARD_COMMENT ( 컬럼명 자료형(길이),컬럼명2 자료형....);**

## 회원을 저장하는 테이블 만들기
- 이름 : 문자 
- 회원번호 : 숫자||문자 
- 아이디 : 문자
- 패스워드 : 문자 
- 이메일 : 문자 
- 나이 : 숫자 
- 등록일 : 날짜



```SQL
CREATE TABLE MEMBER(
-- 한글은 한글자식 3바이트 보통 3자리 많으면 5자리니간 20으로 넉넉히 함
MEMBER_NAME VARCHAR2(20),
MEMBER_NO NUMBER,
MEMBER_ID VARCHAR2(15),
MEMBER_PWD VARCHAR2(20),
EMAIL VARCHAR2(30),
AGE NUMBER,
ENROLL_DATE DATE
);
```
- 이렇게 저장하려는 내용따라 타입을과 길이를 정해서 만들수가있다.

<BR/>

# 3. COMMENT
- 생성된 테이블의 컬럼에 설명(COMMENT)를 작성할수가있다.

```SQL
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS '회원이름 최소2글자이상저장';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원아이디 최소4글자이상저장';
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS '회원비밀번호 최소8글자이상저장';
```

## 테이블에 COMMENT작성
- 컬럼에만 작성할수있는게 아닌 테이블에도 작성을 할수가있다.

```SQL
COMMENT ON TABLE MEMBER IS '회원정보저장';

```

## COMMENT 조회

- 컬럼이나 테이블에 작성된 코멘트를 조회할수있는 명령어가있다
<BR/>

- 전체 컬럼 코멘트 조회하기

```SQL
SELECT * 
FROM USER_COL_COMMENTS
```

<BR/>

- 전체 테이블 코멘트 조회하기

```SQL
SELECT *
FROM USER_TAB_COMMENTS;
```
- WHERE을 사용해서 자기가 원하는 테이블이나 컬럼을 찾을수가있다.

<BR/>

# 4. 제약조건
- 테이블에 각 컬럼에 저장되는 데이터의 특성에 따라 제약조건을 설정할 수 있다.
- 오라클이 제공하는 제약조건
- <CODE>NOT NULL(C)</CODE>  : 지정된 컬럼에 NULL값을 허용하지않는 것 *DEFAULT설정 NULLABLE(NULL값이 가능하다)
- <CODE>UNIQUE(U)</CODE> : 지정된 컬럼에 중복값을 허용하지 않는 것 
- <CODE>PRIMARY KEY(P) /PK</CODE> : 데이터(ROW) 구분하는 컬럼에 설정하는 제약조건 -> NOT NULL, UNIQUE제약조건설(중복도안되고 NULL도안된다) 자동으로 설정됨제약조건이다.
  - 일반적으로 한개테이블에 한개 PK를 설정한다.
  - 다수컬럼에 설장할 수도 있다.(복합키라고한다)

- <CODE>FOREGIN KEY(R)</CODE> : 지정된 컬럼의 값을 다른 테이블의 지정된 컬럼에 있는 값만 저장하게 하는 제약조건


  - 다른 테이블에 지정된 컬럼은 중복이 있으면안된다. (UNIQUE제약조건이나 PK제약조건이 설정된컬럼이여야한다)
- <CODE>CHECK(C)</CODE> : 지정된 컬럼에 지정된 값을 저장하기 위한 제약조건  

  - 동등값, 범위값을 지정할수가있다.

## 테이블에 설정된 제약조건을 확인하는 명령어
```SQL
SELECT *
FROM USER_CONSTRAINTS;
```
- 이렇게 하면 제약조건은 나오지만 컬럼명은 나오지않는다

```SQL
SELECT * 
FROM USER_CONS_COLUMNS;
```
- 컬럼명은 나오지만 제약조건이 나오지않는다.
- 컬러명와 제약조건을 함께 확인할려면 
- 둘이 조인해서 사용한다

```SQL
SELECT C.CONSTRAINT_NAME , CONSTRAINT_TYPE, C.TABLE_NAME, SEARCH_CONDITION, COLUMN_NAME
FROM USER_CONSTRAINTS C
    JOIN USER_CONS_COLUMNS CC ON C.CONSTRAINT_NAME=CC.CONSTRAINT_NAME;
```

## 제약조건 설정하기
- 제약조건 설정하는 방법 2가지가있다.
1. **테이블 생성과 동시에 설정**
  - 컬럼 레벨에서 설정

    - CREATE TABLE 테이블명( 컬럼명 자료형 제약조건, 컬럼명2 자료형 제약조건,......)  


  


  - 테이블 레벨에서 설정

    - CREATE TABLE 테이블명( 컬럼명 자료형, 컬럼명2 자료형 제약조건,......)
<BR/>


2. **생성된 테이블에 제약조건 추가하기**

  - ALTER명령어사용

 

<BR/>

  
## NOT NULL 제약조건
- 컬럼레벨에서만 설정이가능하다.
- 제약조건이 설정되지않으면 모든 컬럼에는 NULL값을 허용한다.
- **NOT NULL은 테이블레벨에서는 설정 불가능**

```SQL
CREATE TABLE NN_MEMBER(
MEMBER_NO NUMBER,
MEMBER_ID VARCHAR2(20) NOT NULL,
MEMBER_PWD VARCHAR2(20) NOT NULL,
MEMBER_NAME VARCHAR2(10),
MEMBER_AGE NUMBER
);
```

- 아이디 , 비밀번호는 NULL값을 허용하면안되니 NOT NULL을사용한다.

<BR/>


## UNIQUE
- 컬럼이 유일한값을 유지해야할때 사용한다.
- 입렵값에대한 중복을 제한한다.
- 컬럼과 테이블 레벨에 설정이가능하다.

```SQL
CREATE TABLE NQ_MEMBER(
MEMBER_NO NUMBER,
MEMBER_ID VARCHAR2(20) UNIQUE ,
MEMBER_PWD VARCHAR2(20) NOT NULL ,
MEMBER_NAME VARCHAR2(10),
MEMBER_AGE NUMBER
);

INSERT INTO NQ_MEMBER VALUES(1,'ADMIN',1234,'관리자',44);
-- 유니크로 제약조건을 했으니 중복값이있다면알아서 알려준다.
INSERT INTO NQ_MEMBER VALUES(2,'ADMIN',1234,'유저1',33);
```
<BR/>

## UNIQUE제약조건의 NULL값
- UNIQUE제약조건이 설정된 값에 NULL값에 대한 처리는 어떻게??
- UNIQUE는 중복값만 찾고 NULL값은 찾지않는다.
  - NULL값을 허용하지 않으려면?
  - 제약조건을 추가하면된다.
  - 컬럼뒤에 둘다써주면된다.
  - 그러면 중복값도 허용하지않고 NULL값도 허용하지않는다.

```SQL
CREATE TABLE NQ_MEMBER2(
MEMBER_NO NUMBER,
MEMBER_ID VARCHAR2(20) UNIQUE NOT NULL,
MEMBER_PWD VARCHAR2(20) NOT NULL ,
MEMBER_NAME VARCHAR2(10),
MEMBER_AGE NUMBER
);
```

<BR/>

## UNIQUE 테이블에서 사용
- 다수의 컬럼에 UNIQUE제약조건을 설정할때 사용한다.

```SQL
CREATE TABLE NQ_MEMBER4(
MEMBER_NO NUMBER,
MEMBER_ID VARCHAR2(20)  NOT NULL ,
MEMBER_PWD VARCHAR2(20) NOT NULL ,
MEMBER_NAME VARCHAR2(10),
MEMBER_AGE NUMBER,
UNIQUE(MEMBER_ID,MEMBER_NAME)
);
```

- UNIQUE에 2개컬럼을 묶어서 썻지만
- 2개가 하나의값이라 생각하면된다
- 2개 전부 일치하지 않는다면 UNIQUE가 적용되지않는다

```SQL
UNIQUE(MEMBER_ID,MEMBER_NAME)

-- 아이디는 중복이지만 이름이 중복이아니기때문에 유니크가 적용이안된다.
INSERT INTO NQ_MEMBER4 VALUES(2,'ADMIN','3333','유저1',33);
INSERT INTO NQ_MEMBER4 VALUES(3,'ADMIN','4444','관리자',24);
```


<BR/>


  
# 5. PRIMARY KEY
- PRIMARY KEY 제약 조건을 설정하면, 해당 필드는 NOT NULL과 UNIQUE 제약 조건의 특징을 모두 가진다.
- 따라서 이 제약 조건이 설정된 필드는 NULL 값을 가질 수 없으며, 또한 중복된 값을 가져서도 안 된다.
- 이러한 PRIMARY KEY 제약 조건을 기본 키라고 한.

<BR/>
- PK를 설정하면 자동으로 UNIQUE, NOT NULL제약조건,INDEX가 부여된다.
```SQL
CREATE TABLE PK_MEMBER(
MEMBER_NO NUMBER PRIMARY KEY,
MEMBER_ID VARCHAR2(20) UNIQUE NOT NULL ,
MEMBER_PWD VARCHAR2(20) NOT NULL ,
MEMBER_NAME VARCHAR2(10),
MEMBER_AGE NUMBER,
UNIQUE(MEMBER_ID,MEMBER_NAME)
);

INSERT INTO PK_MEMBER VALUES(NULL,'ADMIN,''1234','관리자',44); --NULL삽입불가
INSERT INTO PK_MEMBER VALUES(1,'ADMIN,''1234','관리자',44); -- 무결성 제약조건위
INSERT INTO PK_MEMBER VALUES(1,'USER01','2222','유저1',22); -- 정상저장
```

<BR/>


## 테이블레벨에 설정
- PK 테이블레벨에서 설정이 가능

```SQL
CREATE TABLE PK_MEMBER1(
MEMBER_NO NUMBER,
MEMBER_ID VARCHAR2(20) UNIQUE NOT NULL ,
MEMBER_PWD VARCHAR2(20) NOT NULL ,
MEMBER_NAME VARCHAR2(10),
MEMBER_AGE NUMBER,
PRIMARY KEY (MEMBER_NO)
);
```
<BR/>

## 다수컬럼 설정 
- PRIMARY KEY를 다수컬럼에 설정할 수  있다.
- 이걸 복합키 라고한다.
- 테이블 레벨에서 설정을한다.

```SQL
CREATE TABLE PK_MEMBER2(
MEMBER_NO NUMBER,
MEMBER_ID VARCHAR2(20),
MEMBER_PWD VARCHAR2(20) NOT NULL ,
MEMBER_NAME VARCHAR2(10),
MEMBER_AGE NUMBER,
PRIMARY KEY (MEMBER_NO,MEMBER_ID)
);

INSERT INTO PK_MEMBER2 VALUES(1,'USER01','1111','유저1',33); --정상
INSERT INTO PK_MEMBER2 VALUES(2,'USER01','2222','유저2',22); --정상
INSERT INTO PK_MEMBER2 VALUES(1,'USER01','2222','유저2',22); -- 불가능
INSERT INTO PK_MEMBER2 VALUES(NULL,'USER01','3333','유저3',33); --NULL은들어갈수없다.
```
- PRIMARY KEY (MEMBER_NO,MEMBER_ID) 안에괄호가 동시에 맞을때만 제약조건이 걸린다.
- 하나라도 틀리면 제약조건이 걸리지않는다.

<BR/>

# 6. FOREIGN KEY
- 다른테이블에 있는 데이터를 가져와 사용하는것(참조)
- 참조관계를 설정하면 부모(참조되는테이블)-자식(참조하는테이블)관계가 설정이 됨.
- FK제약조건은 자식테이블에 설정
- FK제약조건을 설정하는 컬럼은 UNIQUE제약조건이나 PK제약조건이 설정되어있어야 한다.

<BR/>

## 연결
- 게시판을 만든다고치자
- 먼저 게시판을 테이블을만들고 댓글 테이블을 만든다
- 그리고 서로연결을한다.

  - REFERENCES 테이블명(컬럼명)
  - 이렇게 선언한다.

```SQL
-- 게시판
CREATE TABLE BOARD(
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR2(200),
    BOARD_CONTENT VARCHAR2(3000),
    BOARD_WRITER VARCHAR2(10) NOT NULL,
    BOARD_DATE DATE
);

-- 댓글
--레퍼런스로 관계를 설정해서 가져온다
CREATE TABLE BOARD_COMMENT(
    COMMENT_NO NUMBER PRIMARY KEY,
    COMMENT_CONTENT VARCHAR2(800),
    COMMENT_WRITER VARCHAR2(10),
    COMMENT_DATE DATE,
    BOARD_REF NUMBER REFERENCES BOARD(BOARD_NO)
);

SELECT * 
FROM BOARD
    JOIN BOARD_COMMENT ON BOARD_NO=BOARD_REF;
```

<BR/>

## FK가 설정된 컬럼에 NULL
- FK가 설정된 컬렘에는 NULL이 저장이된다.
- 저장이 되지않기 하기위해서는
- NOT NULL 제약조건을 설정해야한다.

<BR/>

## FK 가설정된 테이블 삭제
- FK를 설정해서 테이블간 관계가 설정이 되면 참조되고 있는 부모테이블의
- ROW를 함부로 삭제할 수 없다.

```SQL
SELECT *
FROM BOARD_COMMENT;

-----------------------------------
1	네 없어요!!	관리자	23/04/11	3
2	전 그럴의도가 없어요	최솔	23/04/11	2
3	전 그럴의도가 없어요	최솔	23/04/11	3
4	호호호 금요일즐겨	조장흠	23/04/11	3
------------------------------------------
DELETE FROM BOARD WHERE BOARD_NO=1; -- 참조된값이없기에 가능

DELETE FROM BOARD WHERE BOARD_NO=3; -- 참조된값이 있어서 불가능
```

- 기본적으로 부모테이블에 참조관계가 없어야지만 삭제가가능하다.

<BR/>

## FK설정할때 삭제에 대한 옵션을 설정할 수 있다.
- ON DELETE SET NULL : 부모가삭제되었을때 참조컬럼(자식)을 NULL값으로 수정 
  - 주의할점 참조컬럼(자식)에 NOT NULL 제약조건이 있으면 안된다

- ON DELETE CASCADE : 참조되는 부모데이터가 삭제되면 같이 삭제해버림

```SQL
CREATE TABLE BOARD_COMMENT2(
    COMMENT_NO NUMBER PRIMARY KEY,
    COMMENT_CONTENT VARCHAR2(800),
    COMMENT_WRITER VARCHAR2(10),
    COMMENT_DATE DATE,
    
    -- BOARD_REF NUMBER REFERENCES BOARD(BOARD_NO) ON DELETE SET NULL -- 참조하는값이 지워지면 NULL을넣어라
    
    -- BOARD_REF NUMBER REFERENCES BOARD(BOARD_NO) ON DELETE CASCADE -- 참조하고있는 데이터가 사라지면 자식데이터도 같이 삭제해버림
);
```

<BR/>

## 주의사항

- 참조관계를 설정할때 대상이되는 컬럼에는 반드시 UNIQUE ,PK제약조건이 설정되어있어야한다.
- FK는 한개의 테이블만 가능 다수컬러을 지정할 수 없다.
- FK설정하는 컬럼은 참조하는 컬럼과 타입, 길이(더커도 상관없음)가 일치해야한다.


<BR/>

# 7. CHECK

- 컬럼에 지정한 값만 저장할 수 있게 하는 제약조건
- 컬럼레벨에서 가능

```SQL
CREATE TABLE PERSON(
    NAME VARCHAR2(20),
    AGE NUMBER CHECK(AGE>0) NOT NULL,
    GENDER VARCHAR2(5)  CHECK(GENDER IN('남','여'))  
);

INSERT INTO PERSON VALUES('유병승',19,'남');
INSERT INTO PERSON VALUES('유병승',19,'유');--안됨 남또는여만가능
```
<BR/>


# 8. DEFAULT
- 테이블 생성시 DEFAULT값을 설정할 수 있음
- DEFAULT 예약어 사용

```SQL
CREATE TABLE DEFAULT_TEST(
    TEST_NO NUMBER PRIMARY KEY,
    TEST_DATE DATE DEFAULT SYSDATE,
    TEST_DATA VARCHAR2(20) DEFAULT '기본값'
); 

INSERT INTO DEFAULT_TEST VALUES(1,DEFAULT,DEFAULT); -- 1	23/04/11	기본값
INSERT INTO DEFAULT_TEST VALUES(2,'23/02/04','데이터');-- 2	23/02/04	데이터
INSERT INTO DEFAULT_TEST (TEST_NO) VALUES(3); -- 3	23/04/11	기본값
```

<BR/>


# 9. CONSTRAINT
- 제약조건에 이름을 설정할수가 있다.
- 제약조건을 이름을 설정하지않고 자동으로 생성한다면
- SYS00000으로 자동으로 설정된다.

```SQL
CREATE TABLE MEMBER_TEST(
    MEMBER_NO NUMBER  CONSTRAINT MEMBER_NO_PK PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) CONSTRAINT MEMBER_ID_UQ UNIQUE NOT NULL,
    MEMBER_PWD VARCHAR2(20) CONSTRAINT MEMBER_PWD_NN NOT NULL,
    CONSTRAINT COMPOSE_UQ UNIQUE(MEMBER_NO,MEMBER_ID)
);

SELECT * 
FROM USER_CONSTRAINTS
WHERE TABLE_NAME ='MEMBER_TEST';

--------------------------------------------------------------
SYSTEM	SYS_C008104
SYSTEM	MEMBER_PWD_NN
SYSTEM	MEMBER_NO_PK
SYSTEM	MEMBER_ID_UQ
SYSTEM	COMPOSE_UQ
```
<BR/>

# 10. AS
- 테이블을 생성 할떄 SELECT문을 이용할수도있다.
- 테이블 복사의 개념이다.
- AS SELECT 를사용한다.

```SQL
CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE;
```
- EMP_COPY에 EMPLOYEE 의 모든테이블이 들어갓다.
- SELECT문이기때문에 WHERE,JOIN등등 을사용해서 값을 찾아낼수도있다.

```SQL

CREATE TABLE EMP_SAL
AS SELECT E.*,(SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE=E.DEPT_CODE) AS SAL_DEPT_AVG
    FROM EMPLOYEE E JOIN DEPARTMENT D ON DEPT_ID=DEPT_CODE ;

```

<BR/>

# 11. ALTER
- 테이블에 정의된 내용을 수정할 때 사용하는 데이터 정의어로컬럼의 추가/삭제 
- 제약조건의 추가/삭제 
- 컬럼의 - 자료형 변경
- DEFAULT 값 변경, 테이블 명/컬럼 명/제약조건 명 변경 등을 할 수 있음
- **컬럼의대한 길이를 늘릴때나, 테이블에 컬럼을 추가할때, 제약조건을추가할때 등등등 사용한다.**

## ADD
- 컬럼을 추가할때  ADD를사용한다.
- ALTER TABLE 테이블명 ADD (컬럼명 자료형 [제약조건])
```SQL
ALTER TABLE TBL_USERALTER ADD (USER_NAME VARCHAR2(20))`
```
- 요런식으로 테이블에 USER_NAME 컬럼을 추가했다.

## 테이블에 데이터가 있는 상태에서 컬럼추가

- 이미데이터가 들어가있으면 나머지 데이터는 NULL이들어간다.

```SQL
---------------------
1	ADMIN	1234	관리자
---------------------

ALTER TABLE TBL_USERALTER ADD (NICKNAME VARCHAR2(30));

--------------------------
1	ADMIN	1234	관리자	(NULL)
--------------------------
```

<BR/>

- 이메일 주소 추가할때 NOT NULL제약조건 설정
- 이미 데이터가 들어가있다면 새로만든 컬럼은NULL이들어간다.
- 그렇다면 NOT NULL제약조건을 넣은 컬럼을 넣고싶다면 어떻게해야할까?
- 바로 DEFAULT 값을 이용해주면된다.

```SQL
ALTER TABLE TBL_USERALTER ADD(EMAIL VARCHAR2(40) DEFAULT ' 미설정' NOT NULL);
-----------------------------
1	ADMIN	1234	관리자		 미설정
```
<BR/>

- CHECK 제약조건도 가능하다.

```SQL
ALTER TABLE TBL_USERALTER ADD(GENDER VARCHAR2(10) CONSTRAINT GENDER_CK CHECK (GENDER  IN('남','여')));

----------------------------------------------

2	USER01	USER01	유저1	유저	USER01@USER01.COM	여
```
<BR/>

## 제약조건 추가하기
- 테이블을 만들당시에 제약조건을 넣지않앗을때 제약조건을 추가할수가있다.
- ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건설정

```SQL
ALTER TABLE TBL_USERALTER ADD CONSTRAINT USERID_UQ UNIQUE(USER_ID);
```

<BR/>

## MODIFY

- NULL제약조건같은경우는
- 이미 컬럼에 NULLABLE로 설정이 되어있기 때문에 ADD가 아닌 MODIFY변경 으로 해줘야한다...
```SQL
ALTER TABLE TBL_USERALTER MODIFY USER_PWD CONSTRAINT USER_PWD NOT NULL;
```
<BR/>



## 컬럼 수정하기
- 컬럼의 타입, 크기를 변경할수가있다.
- ALTER TABLE 테이블명 MODIFY컬럼명 자료형

``` SQL
LTER TABLE TBL_USERALTER MODIFY GENDER CHAR(10);
```
- GENDER 를 CHAR(10)으로 변경해줫다.


<BR/>

## 제약조건 수정하기

```SQL
ALTER TABLE TBL_USERALTER
MODIFY USER_PWD CONSTRAINT USER_PWD_UQ UNIQUE;
```
- USER_PWD 를 UNIQUE 수정해줫다.

<BR/>

## 컬럼명 변경하기
- ALTER TABLE 테이블명 RENAME COLUMN 컬럼명 TO 새컬럼명

```SQL
ALTER TABLE TBL_USERALTER RENAME COLUMN USER_ID TO USERID;
```

<BR/>

## 제약조건명 변경하기
- ALTER TABLE 테이블명 RENAME CONSTRAINT 제약조건명 TO 새제약조건명

```SQL
ALTER TABLE TBL_USERALTER RENAME CONSTRAINT SYS_C007472 TO USERALTER_PK;
```

<BR/>

# 12. DROP

- 컬럼삭제하기
- -ALTER TABLE 테이블명 DROP 컬럼명;

```SQL
ALTER TABLE TBL_USERALTER DROP COLUMN EMAIL;
```

## 제약조건 삭제하기
- ALTER TABLE  테이블명 DROP CONSTRAINT 제약조건명;

```SQL
ALTER TABLE TBL_USERALTER DROP CONSTRAINT USERALTER_PK;
```

<BR/>

## 테이블 삭제하기

```SQL
DROP TABLE TBL_USERALTER;
```

- 테이블 삭제할때 FK제약조건이 설정되어있다면 기본적으로 삭제가 불가능하다.

```SQL
CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE;
ALTER TABLE EMP_COPY ADD CONSTRAINT EMP_ID_PK PRIMARY KEY(EMP_ID);

CREATE TABLE TBL_FKTEST(
    EMP_ID VARCHAR2(20) CONSTRAINT FK_EMPID REFERENCES EMP_COPY(EMP_ID),
    CONTENT VARCHAR2(20)
);

DROP TABLE EMP_COPY;
```

- 부모임 EMP_COPY를 삭제할려고해도 TBL_FKTEST가 참조되어있기때문에
- 불가능하다.
- 이럴때 옵션을 설정해서 삭제할수가있다.


```SQL
DROP TABLE EMP_COPY CASCADE CONSTRAINT;
```

- 이렇게 부모 테이블을 삭제가가능하다.
- 이때 부모가 삭제된다면 자식도 삭제될까?
- 아니다. 부모를 삭제해도 자식은 그대로 남아있다.
- 참조만 끊어질뿐이다.

<BR/>

























 
