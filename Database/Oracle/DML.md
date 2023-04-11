# 🔖 목차
1.
2.


<br/>



## DML
- 데이터 조작 언어로 테이블에 값을 
- <CODE>삽입(INSERT)</CODE>, <CODE>수정(UPDATE)</CODE>, <CODE>삭제(DELETE)</CODE>하는 구문을 말함

<BR/>


# 1. INSERT
- 테이블에 데이터(ROW)를 추가하는 명령어
- <CODE>INSERT INTO</CODE> 를사용한다.

<BR/>

## 전체컬럼에 값을 대입하기
- INSERT INTO 테이블명 VALUES(컬럼에 대입합 값,컬럼에 대입할 값....)
- 테이블에 선언된 모든 컬럼수과 동일해야한다.

```SQL
-- 3개의 컬럼이 있다고치자
DEPT_ID   DEPT_TITLE   LOCATION_ID

INSERT INTO TEMP_DEPT VALUES('D0','자바','L1'); 컬럼의 수와 타입맞췃기때문에 저장가능

INSERT INTO TEMP_DEPT VALUES('D1','오라클'); 컬럼의 수를 안맞춰서 저장불가능
```

- 넣을때는 컬럼 순서대로 들어간다.

## 컬럼을 지정해서 값을 대입
- 특정 컬럼을 지정해서 그컬럼에만 값을 넣을수도있다.

```SQL
INSERT INTO TEMP_DEPT(DEPT_ID,LOCATION_ID) VALUES('D2','L3'); --저장가능

-- 이거는 들어갈까?
INSERT INTO TEMP_DEPT(DEPT_ID) VALUES('D3'); -- 불가능하다.
```
- DEPT_ID만 값이 들어가고 나머지는 NULL로 들어간다. 
- 그런데 LOCATION_ID 에는 NOT NULL제약조건이들어가있기떄문에 저장이되지가않는다.
- 그럼어떻게 해야할까?
- DEFAULT 를 이용하면된다.

```SQL
CREATE TABLE TESTINSERT(
    TESTNO NUMBER PRIMARY KEY,
    TESTCONTENT VARCHAR2(200) DEFAULT 'TEST' NOT NULL
);
INSERT INTO TESTINSERT(TESTNO) VALUES(1);
```
- 이렇게 NOT NULL 제약조건이 들어가있는 컬럼에 DEFAULT로 기본값을 정해놓으면
- 값을넣지않아도 NULL이아닌 기본값이 들어가기 때문에 가능하다.

<BR/>

## SELECT문을 이용해서 값대입
- INSERT INTO 이름 (SELECT)

```SQL
INSERT INTO INSERT_SUB(
    SELECT EMP_ID,EMP_NAME,DEPT_TITLE
    FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
    WHERE SALARY>=3000000
);
```
- 기존 방식으로 한개 행추가밖에안된다.
- 그럼 10개를 추가하고싶으면 10개를 만들어야한다 포퍼먼스적으로 비효율적이다.
- 그럴때 SELECT문을 이용해서 기존에잇던 테이블을 복사해서 넣어줄수가있다.


<BR/>

## 지정한 컬럼에 SELECT문으로 데이터저장
- 지정한 컬럼에 SELECT문을 사용을할수가있다.

```SQL
INSERT INTO INSERT_SUB(EMP_ID,EMP_NAME)(SELECT EMP_ID,EMP_NAME FROM EMPLOYEE);
```
- 지정한 컬럼에 SELECT값이들어간다.
- 지정한값이없으면 NULL이들어가구 DEFAULT값이 있을때는 DEFAULT값이 들어간다.
<BR/>

# 2. INSERT ALL
- SELECT문을 이용해서 두개이상의 테이블의 값을 넣을때 사용할수가 있다.
- 먼저 2개의 테이블을만들어주겟다.

```SQL

CREATE TABLE EMP_HIRE_DATE
 AS SELECT EMP_ID, EMP_NAME, HIRE_DATE FROM EMPLOYEE WHERE 1=0;
 
 CREATE TABLE EMP_MANAGER
 AS SELECT EMP_ID,EMP_NAME,MANAGER_ID FROM EMPLOYEE WHERE 1=0;

```
- 아무 값도 들어가있지않은 테이블 2개가만들어졋다.
- 이 2개의 테이블에 동시에 값을 집어넣어보자

```SQL
INSERT ALL 
 INTO EMP_HIRE_DATE VALUES(EMP_ID,EMP_NAME,HIRE_DATE)
 INTO EMP_MANAGER VALUES(EMP_ID,EMP_NAME,MANAGER_ID)
 SELECT EMP_ID, EMP_NAME, HIRE_DATE,MANAGER_ID
 FROM EMPLOYEE;
 ```
 - SELECT 에 조회된 데이터를 VALUES에 각각 컬럼에 맞춰서 데이터를집어넣는다.


 <BR/>
 
 ## INSERT ALL 을 조건에맞춰서 저장시키기
 
 - EMPLOYEE테이블에서 00년 이전 입사자는 EMP_OLD에저장
 - 이후 입사자는 EMP_NEW에 저장하기
```SQL
INSERT ALL
WHEN HIRE_DATE<'00/01/01' THEN INTO EMP_OLD VALUES(EMP_ID,EMP_NAME,HIRE_DATE)
WHEN HIRE_DATE>='00/01/01' THEN INTO EMP_NEW VALUES(EMP_ID,EMP_NAME,HIRE_DATE)
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE;
```
- CASE문과 비슷하게 WHEN에 조건을 쓰고 THEN조건을 만족할때 실행할내용 을적는다.


<BR/>

# UPDATE
- 테이블에 기록된 컬럼 값을 수정하는 구문으로 테이블 전체 행 개수는 변화는없다.
- UPDATE 테이블명 SET 수정할컬럼명 = 수정할값, 수정할컬럼명=수정할값...[WHERE 조건]
- **WHERE절을 생략해두 상과없지만 WHERE절을 사용하지않으면 전체 데이터를 수정한다....**
- **그래서 반드시 WHERE절을 사용해주자.**

```SQL
-- 먼저 값이 있는 테이블을 만들어주자
CREATE TABLE EMP_SALARY
AS SELECT EMP_ID, EMP_NAME,DEPT_CODE, JOB_CODE, SALARY,BONUS
FROM EMPLOYEE;

--전형돈의 급여를 300만원으로 수정하기
UPDATE EMP_SALARY SET SALARY=3000000 WHERE EMP_NAME='전형돈';

-- 다수컬럼값을 수정할 때는 ,  로 구분해서 대입한다
UPDATE EMP_SALARY SET SALARY=2500000,BONUS=0.5 WHERE EMP_NAME = '전형돈';
```

## UPDATE문에서 SELECT문 활용하기
- UPDATE에서도  SELECT 를 사용할수가있다.

```SQL
-- 박명수의 부서, 보너스 를 심봉선과 동일하게 수정하자

SET DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '심봉선'),
    BONUS = (SELECT BONUS FROM EMPLOYEE WHERE EMP_NAME='심봉선')
WHERE EMP_NAME = '방명수';


-- 여러행을 동시에 수정
UPDATE EMP_SALARY
SET (DEPT_CODE,BONUS) = (SELECT DEPT_CODE,BONUS FROM EMPLOYEE WHERE EMP_NAME = '심봉선')
WHERE EMP_NAME='방명수';
```

<BR/>

# 3. DELETE
- 테이블의 ROW를 삭제할수가있다.
- DELETE FROM 테이블명 [WHERE 조건]
- **이것도 마찬가지로 WHERE 를 무조건써주자 아니면 전부다 삭제된다.**

```SQL
DELETE FROM EMP_SALARY WHERE DEPT_CODE = 'D9';
```
- 이런식으로 DEPT_CODE가 D9인사람의 ROW가 삭제된다.

<BR/>

# 4. TRUNCATE 
- TRUNCATE 삭제한다면 ROLLBACK이안된다 ;;;; 넘무 무섭다 왠만하면 쓰지마라
- ROLLBACK란 커밋하기전까지의 데이터를 모두 되돌려주는 명령어인데
- 자세한 트렌젝션 을 참고하자

```SQL
TRUNCATE TABLE EMP_SALARY;
```
<BR/>

# 5. MERGE
- 구조가 같은 두 개의 테이블을 하나의 테이블로 합치는 기능
- 두 테이블에서 지정하는 조건의 값이 존재하면 UPDATE되고조건의 값이 없으면 INSERT함
```SQL
MERGE INTO EMP_M1 USING EMP_M2 ON(EMP_M1.EMP_ID=EMP_M2.EMP_ID)
-- ON 뒤에값이 참일때 밑에있는 WHEN을 실행
WHEN MATCHED THEN 
    UPDATE SET
        EMP_M1.SALARY=EMP_M2.SALARY
-- 일치하지않을때 밑에있는명령어실행
WHEN NOT MATCHED THEN
INSERT VALUES(EMP_M2.EMP_ID, EMP_M2.EMP_NAME, EMP_M2.EMP_NO, EMP_M2.EMAIL, 
EMP_M2.PHONE, EMP_M2.DEPT_CODE, EMP_M2.JOB_CODE, 
EMP_M2.SAL_LEVEL, EMP_M2.SALARY, EMP_M2.BONUS, EMP_M2.MANAGER_ID, 
EMP_M2.HIRE_DATE, EMP_M2.ENT_DATE, EMP_M2.ENT_YN);
```
- 중복값을 같는 EMP_M1의데이터만   EMP_M2의데이터값으로 바뀐다.        

<RB/>








