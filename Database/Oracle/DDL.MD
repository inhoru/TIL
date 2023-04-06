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







 
