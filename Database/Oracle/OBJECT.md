# 🔖 목차
1.
2.
3.

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

UPDATE V_EMP SET EMP_NAME = '최주영' WHERE EMP_NAME = '월드컵';
SELECT * FROM EMPLOYEE;

-- 이렇게 V_EMP도 UPDATE가 되었고
-- 원본인 EMPLOYEE에도 변경이되었다.
```

<BR/>









 



  
  







