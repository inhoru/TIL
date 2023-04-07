# 🔖 목차

1.[CREATE](#1-CREATE)<BR/>



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
- NOT NULL(C)  : 지정된 컬럼에 NULL값을 허용하지않는 것 *DEFAULT설정 NULLABLE(NULL값이 가능하다)
- UNIQUE(U) : 지정된 컬럼에 중복값을 허용하지 않는 것 
- PRIMARY KEY(P) /PK : 데이터(ROW) 구분하는 컬럼에 설정하는 제약조건 -> NOT NULL, UNIQUE제약조건설(중복도안되고 NULL도안된다) 자동으로 설정됨제약조건이다.
  - 일반적으로 한개테이블에 한개 PK를 설정한다.
  - 다수컬럼에 설장할 수도 있다.(복합키라고한다)

- FOREGIN KEY(R) : 지정된 컬럼의 값을 다른 테이블의 지정된 컬럼에 있는 값만 저장하게 하는 제약조건


  - 다른 테이블에 지정된 컬럼은 중복이 있으면안된다. (UNIQUE제약조건이나 PK제약조건이 설정된컬럼이여야한다)
- CHECK(C) : 지정된 컬럼에 지정된 값을 저장하기 위한 제약조건  

  - 동등값, 범위값을 지정할수가있다.

## 테이블에 설정된 제약조건을 확인하는 명령어
```SQL
SELECT *
FROM USER_CONSTRAINTS;
```
- 이렇게 하면 컬럼명은 나오

  










 
