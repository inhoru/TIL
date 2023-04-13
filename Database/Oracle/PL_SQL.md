# 🔖 목차 
1.
2.
3.

<br/>

## PL/SQL
- Procedural Language extension to SQL의 약자로
- 오라클 자체에 내장되어 있는 절차적 언어
- SQL의 단점을 보완하여 SQL문장 내에서 변수의 정의, 조건 처리, 반복 처리 등 지원
- PL/SQL구문
  - 1.블록을 이용하기 - > BEGIN~END ;
  - 2.OCEDURE, FUNCTION객체로 생성해서 이용 - > OBJECT안에 작성된 PL/SQL
  - 생성된 OBJECT명으로 재사용이 가능하다.


<BR/>

# 1. 익명블럭
- PL/SQL 구문은 크게 3가지로 나뉜다.
- [선언부] :  DECLARE 예약어를 사용 변수, 상수를 선언
  - 선언방법 : 변수명 타입(기본타입,참조타입,ROWTYBE,TABLE,RECODE);
- [실행부] : BEGIN 구문작성 END;/  
  - 조건문, 반복문 등 실행할 내용에 대해 작성하는 구문
- [예외처리부] : 처리할 예외가 있을때 작성하는 구문

<BR/>

## 프로시저를 사용하여 출력
- 프로시저를 사용하여 출력하는 내용을 화면에 보여주도록 설정하는 환경변수
- 기본 값은 OFF여서 ON으로 변경해야 출력이가능해진다.

```SQL
SET SERVEROUTPUT ON; -- 이녀석이 있어야 스크립트 출력창에 문구를 출력할수가있다.
BEGIN
    -- 프로시저를 이용해서 출력
    DBMS_OUTPUT.PUT_LINE('안녕 나의 첫 PL/SQL구문');
END;
/
----------------------------------------------
안녕 나의 첫 PL/SQL구문


PL/SQL 프로시저가 성공적으로 완료되었습니다.
```

<BR/>

# 2. 변수활용
- 변수는 DECLARE부분에 변수명 자료형 형식으로 선언
- 자료형의 종류

  - 기본자료형  : 오라클에서 제공하는 TYPE들(NUMBER, VARCAHR2,CHAR,DATE....)
  - 참조형 자료형  : 테이블의 특정컬럼에 설정된 타입을 불러와 사용
  - ROWTYPE : 테이블의 한개 ROW를 저장할수 있는 타입


- 타입을 생성해서 활용
  - TABLETYPE :  자바의 배열과 비슷한 타입 -> 인덱스번호가 있고 한개타입만 저장이 가능
  - RECORDE :   자바의 클래스와 비슷한 타입 -> 멤버변수가 있고 다수타입이 저장가능

<BR/>

## 기본자료형 선언과 이용하기
```SQL
DECLARE 
    V_EMPNO VARCHAR2(20);
    V_EMPNAME VARCHAR2(15);
    V_AGE NUMBER := 19;
BEGIN
    V_EMPNO:='010224-1234567';
    V_EMPNAME:='유병승';
    DBMS_OUTPUT.PUT_LINE(V_EMPNO);
    DBMS_OUTPUT.PUT_LINE(V_EMPNAME);
    DBMS_OUTPUT.PUT_LINE(V_AGE);
END;
/
-------------------------------------------
010224-1234567
유병승
19


PL/SQL 프로시저가 성공적으로 완료되었습니다.
```

<BR/>

## 참조형자료형이용하기

```SQL
DECLARE
-- % 사용하면 EMPLOYEE에있는EMP_ID를가져온다
    V_EMPID EMPLOYEE.EMP_ID%TYPE;
-- % 사용하면 EMPLOYEE에있는SALARY를가져온다
    V_SALARY EMPLOYEE.SALARY%TYPE;
BEGIN
    V_EMPID:='200';
    V_SALARY :=1000000;
    DBMS_OUTPUT.PUT_LINE(V_EMPID||' : '||V_SALARY);
    --SQL문과 연동하여 처리하기 
    SELECT EMP_ID, SALARY
    INTO V_EMPID,V_SALARY
    FROM EMPLOYEE
    WHERE EMP_ID = V_EMPID;
    DBMS_OUTPUT.PUT_LINE(V_EMPID||' ' ||V_SALARY);
END;
/
--------------------------------------------------
200 : 1000000
200 8000000


PL/SQL 프로시저가 성공적으로 완료되었습니다.
```

<BR/>

## ROWTYPE

- 테이블에 한개 ROW를저장

```SQL
DECLARE 
    V_EMP EMPLOYEE%ROWTYPE;
    V_DEPT DEPARTMENT%ROWTYPE;
BEGIN
    SELECT * 
    INTO V_EMP
    FROM EMPLOYEE
    WHERE EMP_ID= '&사원번호';
    -- ROWTYPE의 각 컬럼을 출력하려면  .연산자를 이용해서 컬럼명으로 접근한다.
    DBMS_OUTPUT.PUT_LINE(V_EMP.EMP_ID||' '||V_EMP.EMP_NAME||' '||V_EMP.SALARY||' '||V_EMP.BONUS);
    SELECT *
    INTO V_DEPT
    FROM DEPARTMENT
    WHERE DEPT_ID = V_EMP.DEPT_CODE;
    DBMS_OUTPUT.PUT_LINE(V_DEPT.DEPT_ID||' '||V_DEPT.DEPT_TITLE||' '||V_DEPT.LOCATION_ID);
END;
/
------------------------------------------------------------
200 선동일 8000000 .3
D9 총무부 L1
```
- %컬럼명 은 자바에서의 Scanner이랑 똑같다고 보면된다. 입력을 받는다.

<br/>

## 테이블타입
- 생성해서 사용하는 타입중하나이다.
```SQL
DECLARE
    TYPE EMP_ID_TABLE IS TABLE OF EMPLOYEE.EMP_ID%TYPE
    -- 배열이니간 인스바필요
    INDEX BY BINARY_INTEGER;
--      변수명         타입
    MYTABLE_ID EMP_ID_TABLE;
    I BINARY_INTEGER := 0;
BEGIN
    MYTABLE_ID(1):= '100';
    MYTABLE_ID(2):= '200';
    MYTABLE_ID(3):= '300';
    DBMS_OUTPUT.PUT_LINE(MYTABLE_ID(1));
    DBMS_OUTPUT.PUT_LINE(MYTABLE_ID(2));
    DBMS_OUTPUT.PUT_LINE(MYTABLE_ID(3));
    
    FOR K IN (SELECT EMP_ID FROM EMPLOYEE) LOOP
        I := I+1;
        MYTABLE_ID(I) :=K.EMP_ID;
    END LOOP;
    FOR J IN 1..I LOOP
        DBMS_OUTPUT.PUT_LINE(MYTABLE_ID(J));
    END LOOP;        
END;
/
------------------------------------------------
100
200
300
200
201
202
203
204
205
206
207
208
209
210
211
212
213
214
215
216
217
218
219
220
221
222


PL/SQL 프로시저가 성공적으로 완료되었습니다.
```

<BR/>

##  RECORD 타입활용하기
- 클래스와 유사

```SQL
DECLARE
    TYPE MYRECORD IS RECORD(
            ID EMPLOYEE.EMP_ID%TYPE,
            NAME EMPLOYEE.EMP_NAME%TYPE,
            DEPTTITLE DEPARTMENT.DEPT_TITLE%TYPE,
            JOBNAME JOB.JOB_NAME%TYPE
        );
        
        MYDATA MYRECORD;
BEGIN
    SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME
    INTO MYDATA
    FROM EMPLOYEE 
        JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
        JOIN JOB USING(JOB_CODE)
    WHERE EMP_NAME = '&사원명';
    DBMS_OUTPUT.PUT_LINE(MYDATA.ID||MYDATA.NAME||MYDATA.DEPTTITLE||MYDATA.JOBNAME);
END;
/
--------------------------------------------------------
방명수 입력

214방명수인사관리부사원


PL/SQL 프로시저가 성공적으로 완료되었습니다.
```

<BR/>

# 3. 조건문
- PL/SQL 구문에서 조건문 을 사용할수가있다.
- IF문활용

        IF 조건식 
            THEN : 조건식이 TRUE일때  THEN에 있는 구문이 실행됨. 
         END IF;        





















