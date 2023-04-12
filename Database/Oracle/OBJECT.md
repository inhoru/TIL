# 🔖 목차
1. [VIEW](#1-VIEW)<BR/>
2. [OR REPLACE](#2-OR-REPLACE)<BR/>
3. [FORCE NOFORCE](#3-FORCE-NOFORCE)<BR/>
4. [WITH CHECK OPTION](#4-WITH-CHECK-OPTION)<BR/>


<br/>

## OBJECT
- ORACLE에서 제공하는 OBJECT는 다음과같이있다.
- USER, TABLE, VIEW, SEQUENCE, INDEX, SYNONYM, FUNCTION, PROCEDURE, PACKAGE 등등


<BR/>

# 1. VIEW

- SELECT 쿼리의 실행 결과를 화면에 저장한 논리적 가상 테이블
- 실제 테이블과는 다르게 실질적 데이터를 저장하고 있진 않지만
- 사용자는 테이블을 사용하는 것과 동일하게 사용 가능하다.
- **SELECT 문의 결과 RESULT SET 을 하나의 테이블처럼 활용하게 하는것을 VIEW라고한다.**
  - STROE VIEW 생성하기
  - CREATE [옵션] VIEW VIEW 명칭 AS SELECT문
  
<BR/>  

## VIEW 활용
- VIEW테이블을 사용할려면 권한을 부여해줘야한다.
- SYSTEM/ SYS AS SYSDBA(최고관리자계정) 계정으로 부여를한다.

```SQL
GRANT CREATE VIEW TO BS
```
- 이렇게 VIEW테이블을 만든 권한이 생겻다.
- 이제 테이블을 생성해보자

```SQL
CREATE VIEW V_EMP
AS SELECT * FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID;
```
- V_EMP 라는 테이블에 SELECT EMPLOYEE 가 들어가있는 상태로 만들어졋다.
- SELECT문이 들어가기대문에 JOIN이나 UNION등등 다쓸수가있다.

```SQL
-- VIEW테이블을 만들엇을때 AVG같은 컬럼명은 이상하기떄문에 
-- 별칭을 정해줘야한다.

REATE VIEW V_AVG_DEPTJOB
AS 
SELECT DEPT_CODE, AVG(SALARY) AS AVG_SALARY FROM EMPLOYEE GROUP BY ROLLUP(DEPT_CODE)
UNION
SELECT JOB_CODE, AVG(SALARY)FROM EMPLOYEE GROUP BY ROLLUP(JOB_CODE);

월급 평균이 300만원 이상인 사원조회
SELECT * FROM V_AVG_DEPTJOB
WHERE AVG_SALARY >= 3000000  AND DEPT_CODE IS NOT NULL

------------------------------------------------------
D6	3366666.66666666666666666666666666666667
D9	5900000
J1	8000000
J2	4726666.66666666666666666666666666666667
J3	3600000
```
<BR/>

## VIEW에서 DML 사용
- 실제테이블과 연결되어 있는 컬럼을 수정할때는가능하다.
- 하지만 GROUP 처럼 가상 컬럼들을 수정이 불가능하다.

```SQL
-- VIEW테이블로 실제연결되어 있으면은 수정이가능하다.
-- 위에 V_EMP 에는 EMPLOYEE 테이블을 복사해두엇다.

UPDATE V_EMP SET EMP_NAME = 김아무' WHERE EMP_NAME = '월드컵';
SELECT * FROM EMPLOYEE;

-- 이렇게 V_EMP도 UPDATE가 되었고
-- 원본인 EMPLOYEE에도 변경이되었다.
```

<BR/>
- 단일 테이블로 만들어진 VIEW는 INSERT가 가능하다.
-  VIEW에서 값을 넣은것 이외에 컬럼에는 NULL값을 삽입한다. -> NOT NULL 제약조건이 설정되면 안된다.

```SQL
-- VIEW테이블에 대상으로 INSERT로 넣을수있다.
--실질적인 테이블도 변경된다. 지정하지않은 값들은 NULL로 들어간다.

INSERT INTO V_EMPTEST VALUES('997','981011-1234123','홍길동','HONG@HONG.COM','12341234','J1','S1');
```

<BR/>

## JOIN UNION 로 연결된 VIEW는 입력불가능
- JOIN을 사용한 VIEW는 INSERT가 불가능하다.

```
-- V_EMP 는 현재 EMPLOYEE JOIN PARATMENT와 조인을상태이다.
INSERT INTO V_EMP VALUES('999','홍길동','980110-1234567','HONG@HONG.COM','12345','D5','J1','S1',
100,0.2,206,SYSDATE,NULL,'N','D0','되니','L3');

-- 조인된컬럼까지 모드 입력했지만 불가능하다!
```

<BR/>


## DELETE문은 가능한가?
- DELETE는 JOIN이나 UNION이되어있어도 가능하다

```SQL
DELETE FROM V_EMPTEST WHERE EMP_ID = '997';
DELETE FROM V_EMP WHERE EMP_NAME = '옛사람';
```

<BR/>

# 2. OR REPLACE
- VIEW생성시 사용할수있는 옵션중 하나이다.
- <CODE>OR PEPLACE</CODE> 중복되는 VIEW이름이 있으면 덮어쓰기를 해주는 옵션

```SQL
CREATE OR REPLACE VIEW V_EMP
AS SELECT * FROM EMPLOYEE;

-- V_EMP에 값을 EPLOYEE넣은 갚으로 덮어쓰기를 했다.
```

<BR/>

# 3. FORCE NOFORCE
- 실제 테이블이 존재하지않아도 VIEW생성할수 있게 해주는 옵션이다.
- **원래는 테이블이 존재하지않는다면 VIEW를 생성할수없지만**
- **FORCE/NOFORCE 를 사용한다면 먼저 만들수있다.**
- **나중에 테이블을 만들어서 VIEW를 조회하면 조회가된다.**

```SQL

-- VIEW 생성
CREATE  FORCE  VIEW V_TT
AS SELECT * FROM TT;

--테이블생성
CREATE TABLE TT(
    TTNO NUMBER,
    TTNAME VARCHAR2(200)
);    

```
<BR/>

# 4. WITH CHECK OPTION
- SELECT문의 WHERE절에 사용한 컬럼은 수정하지 못하게 만드는 옵션.

```SQL

CREATE OR REPLACE VIEW V_CHECK
AS SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE='D5' WITH CHECK OPTION;

-- WHERE 의 기준이되는 애는 WITH CHECK OPTION 으로인해 수정이불가능
UPDATE V_CHECK SET DEPT_CODE  = 'D6' WHERE EMP_NAME='하이유';

-- WHERE절이 아닌 다른컬럼들은 수정이가능하다.
UPDATE V_CHECK SET EMP_NAME  = '김재훈' WHERE EMP_NAME='하이유';

``` 

<BR/>

# 5. WITH READ ONLY
- VIEW 테이블에서 수정을 불가능하게 하는 옵션 -> 읽기전용

```SQL
CREATE OR REPLACE VIEW V_CHECK
AS SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE='D5' WITH READ ONLY;

-- VIEW자체에서는 아예 수정을 못하게 막아버릴수도 있다.
UPDATE V_CHECK SET EMP_NAME  = '김재훈' WHERE EMP_NAME='하이유';
```







 



  
  







