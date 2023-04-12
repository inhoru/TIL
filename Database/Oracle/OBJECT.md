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



<BR/>



 



  
  







