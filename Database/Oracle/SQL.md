# 🔖 목차
1. [계정생성 및 권환](#1-계정생성-및-권한)<BR/>
2. [전체조회 SELECT](#2-SELECT)<BR/>
3. [조건 WHERE](#3-WHERE)<BR/>
4. [문자열패턴 LIKE](#4-LIKE)<BR/>
5. [NULL](#5-NULL)<BR/>
6. [다중값비교 IN / NOT IN](#6-IN)<BR/>
7. [날짜 SYSDATE](#7-SYSDATE)<BR/>
8. [길이 LENGTH](#8-LENGTH)<BR/>
9. [바이트 LENGTHB](#9-LENGTHB)<BR/>
10. [위치반환 INSTR](#10-INSTR)<BR/>
11. [공백채움 LPAD/RPAD](#11-LPAD-RPAD)<BR/>
12. [공백삭제 LTRIM/RTRIM](#12-LTRIM-RTRIM)<br/>
13. [열 잘라내기 SUBSTR](#13-SUBSTR)<BR/>
14. [영문자 처리 UPPER,LOWER,INITCAP](#14-UPPER-LOWER-INITCAP)<BR/>
15. [문자열 결합 함수 CONCAT](#15-CONCAT)<BR/>
16. [지정문자 특정문자변경 PEPLACE](#16-PEPLACE)<BR/>
17. [문자열을 거꾸로 REVERSE](#17-REVERSE)<BR/>
18. [매칭되는 문자 변경 TRANSLATE](#18-TRANSLATE)<BR/>
19. [절대값 처리 ABS](#19-ABS)<BR/>
20. [나머지 구하기 MOD](#20-MOD)<BR/>
21. [소수점 반올림 ROUND](#21-ROUND)<BR/>
22. [소수점 버리기 FLOOR](#22-FLOOR)<BR/>
23. [소수점 버리면서 자리수 지정 TRUNC](#23-TRUNC)<BR/>
24. [소수점 올리기 CEIL](#24-CEIL)<BR/>
25. [날짜 심화 SYSDATE](#25-DATE)<BR/>
26. [전달받은 요일중 가까운다음날짜 출력 NEXT_DAY](#26-NEXT_DAY)<BR/>
27. [그달의 마지막날 출력 LASY_DAY](#27-LASY_DAY)<BR/>
28. [개월수 더하기  ADD_MONTHS](#28-ADD_MONTHS)<BR/>
29. [두날짜 개월수 계산 MONTHS_BETWEEN](#29-MONTHS_BETWEEN)<BR/>
30. [날짜 년도,월,일자 따로출력 EXTRACT](#30-EXTRACT)<BR/>
31. [숫자, 날짜 문자형 변경 TO_CHAR](#31-TO_CHAR)<BR/>
32. [NULL 값 처리해주는함수 NVL](#32-NVL)<BR/>
33. [조건에따라 출력값 변경 DECODE](#33-DECODE)<BR/>
34. [조건식 반환 CASE WHEN THEN ELSE](#34-CASE-WHEN-THEN-ELSE)<BR/>
35. [그룹함수 총합 SUM](#35-SUM)<BR/>
36. [그룹함수 평균 AVG](#36-AVG)<BR/>
37. [그룹함수 데이터수 COUNT](#37-COUNT)<BR/>
38. [그룹함수 최소값/최대값 MAX/MIN](#38-MAX-MIN)<BR/>
39. [그룹함수 묶어서 처리  GROUP BY](#39-GROUP-BY)<BR/>
40. [그룹함수 값을구해올 조건설정 HAVING](#40-HAVING)<BR/>
41. [그룹함수 인수의 총계 ROLLUP() CUBE()](#41-ROLLUP()-CUBE())<BR/>
42. [그룹함수 분기처리  GROUPING](#42-GROUPING)<BR/>
43. [정렬 ORDER BY](#43-ORDER-BY)<BR/>
44. [집합연산자 UNION](#44-집합연산자)<BR/>
45. [그룹 절 합치기 GROUPING SET](#45-GROUPING-SET)<BR/>
46. [두개의 테이블 연결 INNER JOIN](#46-INNER-JOIN)<BR/>
47. [두개의 테이블 연결 NULL출력 OUTER JOIN](#47-OUTER-JOIN)<BR/>
48. [모든ROW를 연결 CROSS JOIN](#48-CROSS-JOIN)<BR/>
49. [같은 테이블을 조인하는거 SELF JOIN](#49-SELF-JOIN)<BR/>
50. [비동등조인](#50-비동등조인)<BR/>
51. [다중조인](#51-다중조인)<BR/>




<br/>


# 1. 계정생성 및 권한

- DB는 일단 대문자로 사용하는것이 불문율이다.

## 관리자
- DB를사용하기위해서는 먼저 관리자 계정을 생성해야한다.
- 관리자 계정이없으면 아무것도하지못한다.
- **관리자 계정으로 다른 계정들에게 여러가지 권환을 부여해야지**
- **그제서야 그계정들은 계정생성이나 DB사용을 할수가있다.**

  - 예를 들자면 아파트에 들어가기전에 항상 관리자분이 계시지않은가?
  - 그분이 바로 관리자이다. 
  - 그분의 허락없이 우리는 아파트에 들어갈수가 없다.

<br/>

## 계정생성 명령어
- 관리계정으로 접속을 성공햇다면
- 이제 여러가지 계정들을 만들거나 권한을 부여할수있다.
- 먼저 계정생성하는 법을 알아보자.

```SQL
-- 계정생성하는 명령어
CREATE USER BS IDENTIFIED BY BS DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- 18C버전부터 사용자계정명에 ##을 붙여서 생성해야 한다.
-- ##안붙일 수 있게 설정하기
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
```

- 이렇게 명령어를 실행하면
- BS라는 계정이 생겻다.

<BR/>

##  DB  사용자 조회

- 등록을 했으니 정상적으로 등록이됐는지 확인해보자
```SQL
-- DB에 등록되어 있는 사용자 조회하기
SELECT * FROM DBA_USERS;   
```
  
![DB](https://user-images.githubusercontent.com/126074577/229294188-9c629864-cc14-49b2-8715-6880a7448b28.png)

- 이런식으로 27행에 정상적으로 생성된걸 확인할수가있다.
- **하지만 계정만생성 했을뿐 저계정은 아무것도할수가없다.**
- **왜? 관리자가 권한을 부여하지않앗기때문인다.**

<BR/>
  

## 권환부여

  
- 사용자를 생성하더라도 권환이 없으면 DB를 이용할 수 없다.
- 그렇다면 사용자에게 권한을 부여해보자.
```SQL
-- GRANT 권한 or 롤(역할) TO 사용자계정명
GRANT CONNECT TO BS;
        
-- 테이블을 이용할 수 있는 권한을 부여하기
GRANT RESOURCE TO BS;
        
-- 한꺼번에 두개다 부여할수도있다.

GRANT CONNECT, RESOURCE TO BS;
```
   
- 이로써 BS계정을 사용할수있는 권환이생겻다.

<BR/>

# 2. SELECT
- 이제 권환을 부여했으니  BS계정으로가서 사용해보자.
- <CODE>SELECT</CODE> 명령어를 사용해서 여러가지를 할수가있다.

  - **SELECT가 뭔데?**
  - 데이터를 조회한 결과를 Result Set이라고 하는데 
  - SELECT구문에 의반환된 행들의 집합을 의미한다.
  - Result Set은 0개 이상의 행이 포함될 수 있고 특정 기준에 의해 정렬 가능하다.
  - 한 테이블의 특정 컬럼, 행, 행/컬럼 또는 여러 테이블의 특정 행/컬럼 조회도 가능하다.



## 정보확인
- 테이블에 정보를 확인하는 명령어


```SQL
-- SELECT문을 이용해서 EMPLOYEE테이블의 전체 컬럼 조회하기
SELECT * 
FROM EMPLOYEE;
```

- ( * ) 을사용하면 전체데이터를 확인할수가 있다.

<BR/>

- 컬럼 하나하나도 조회도가능하다.
```SQL
-- 전체 사원의 이름, 월급, 보너스 입사일을 조회하기
SELECT EMP_NAME, SALARY, BONUS, HIRE_DATE
FROM EMPLOYEE;        
```          
- 이런식으로 자기가 원하는 내용을 따로 정보를 조회할수가있다.
- **모든 내용을 확인할때는 SELECT문을 사용한다.**

## SELECT문을 이용한 산술연산

- SELECT문을 사용해서 산술연산도 가능ㅎ다ㅏ.
- 사용법은 이렇다

  - +,-,*,/(사칙연산) -> 피연산자 리터럴, 컬럼값


```SQL
SELECT 10+20, 10-20, 20/3, 5*4
FROM DUAL;
```
 <BR/>
 
 - 그렇다면 이산술연산을 다른데서도사용이가능할까?

  - 가능하다. 
  - 우리가 위에서 사용한 EMPLOYEE에 산술연산을 적용시켜보자
```SQL
SELECT EMP_NAME, SALARY+100, SALARY
FROM EMPLOYEE;  
```  
  
![산술연산](https://user-images.githubusercontent.com/126074577/229294970-c68320e3-5222-40d5-b337-d0c4219fef11.png)


- 이렇게 SALARY에 100이 추가된채로 정보를 출력한다.
- 그렇다면 리터럴 값이아닌 컬럼,컬럼 끼리도 연산이가능할까?

  - 가능하다.
  - 하지만 한가지 주의할점이있다.
  - **NULL값과 연산은 불가능하다** 
  - **결과가 무조건 NULL로 출력되기때문이다.**
```SQL
SELECT EMP_NAME, SALARY+BONUS
FROM EMPLOYEE; 
```

- 이런식으로 컬럼들끼리 모두 숫자면 산술연산이가능하다.

  - **그렇다면 숫자만가능하다면 문자열은 불가능한가?**
  - **맞다 JAVA에서는 가능했을지 몰라도 DB에서는불가능하다.**

<BR/>


## 별칭

- 조회된 컬럼에 별칭을 부여할수가있다.
- **가상컬럼에서 많이사용한다.**

  - 가상컬럼이란?
  - **가상컬럼은 테이블안에 존재하는 컬럼이아닌**
  - **우리가 가상으로 만들어낸 컬럼을 말한다.**
  - 일회성이라는 뜻이다.
  - 위에서 산술연산을 할때 쓰던 <CODE>DUAL;</CODE>도 가상컬럼이다.


- **AS 예약어를 사용한다.**
- 띄어쓰기 도 사용할수있지만 가독성을 위해서
- AS 를 많이 사용한다.


```SQL
SELECT EMP_NAME AS 사원명, SALARY AS 월급, EMAIL AS 이메일
FROM EMPLOYEE;
        
-- AS 를 생략하고 띄어쓰기로 부여할 수 있다.
SELECT EMP_NAME 사원명, SALARY 월급, EMAIL 이메일
FROM EMPLOYEE;        
```

- 그렇다면 별칭에 띄어쓰기 특수기호가 가능할까?
- 가능 하다 
- **별칭명 앞뒤에 ( " " ) 를 사용해주면된다.**

```SQL   
SELECT EMP_NAME AS "사 원 명", SALARY AS "$월$급"
FROM EMPLOYEE;
``` 
 
 ## 문자 연결
 - 위에서 산술연산에는 문자를 연산할수없다고 했는데
 - 그렇다면 문자연결하는법은 뭘까?
 - **자바에선 (" ") 를사용했다면 SQL 은(' ')  을사용한다.**

```SQL      
SELECT '점심'+'맛있다' 
FROM DUAL;
```   

## || 연산
- || 연산은 컬럼을 합칠때 사용하거나 문자를 합칠때 사용한다.
```SQL
SELECT '점심'||'맛없다 FEAT 반장'
FROM DUAL
        
SELECT EMP_NAME||'님의 월급은 '||SALARY||' 보너스'||BONUS
FROM EMPLOYEE;
``` 
  
  # 3. WHERE
  
  - 지정한 조건에 맞는 데이터만 가져올수가있다.
  - <CODE>WHERE</CODE> 조건식을 이용한다.
  - 사용방법

  - SELECT 컬럼, 컬럼...... OR *
  - FROM 테이블명
  - WHERE 조건식



```SQL        
-- 사원 중 월급이 200만원이상인 사원을 조회하기
SELECT * 
FROM EMPLOYEE
WHERE SALARY>=2000000;  
```

- 마치 JAVA에서의 IF문을 보는것같은느낌이다.


<BR/>

## 여러개 비교연산 처리

- 여기서도 <CODE>AND</CODE>,<CODE>OR</CODE> 를 사용한다.


```SQL
-- 사원 중 부서가 D5이고 월급이 300만원 이상인 사원의 이름, 부서코드, 월급 조회하기
         
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5' AND SALARY>=3000000;      
```

        
- 사원 중 부서가 D5이거나 월급이 300만원 이상인 사원의 이름, 부서코드, 월급 조회하기


```SQL        
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5' OR SALARY>=3000000;
```        

- 한가지 알아야 할점이 있다.
- **조건식에 말이안되는 걸 적어도 오라클은 오류를 내지않는다**
- **아무것도 출력이 안될뿐이다.**

<BR/>


## 날짜 대소비교

- **날짜를 대소비교할때는 문자로비교, 문자열 패턴을 맞춰준다.**
- **기본적이 날짜를 표시하는 문자열 패턴 : YY/MM/DD -> 'YY/MM/DD'**

```SQL        
-- 입사일이 2000년 01월 01일 이전이 사원의 이름, 입사일을 조회하기
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE<'00/01/01';
```        
        
- 이렇게 범위값을 조회할수있지만
- 더간단해서 명령어를 통해서 조회하는방법도있다.

## BETWEEN AND
- 범위의 값을 조회할때 BETWEEN AND 연산을 이용하기
- 사용방법
  - 컬럼명 BETWEEN 값 AND 값 ;


```SQL
-- 연봉 2000000 과 3000000 사이 조회
SELECT EMP_NAME, SALARY, BONUS, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 3000000;
        
-- 입사일이 00년01월01부터 02년 12월 31일까지 사이 조회 그리고 D9인사람만
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '00/01/01' AND '02/12/31' AND DEPT_CODE ='D9';
```

<BR/>


# 4. LIKE
- 검색을 문자열 패턴으로 검색하는 기능 -> 부분일치, 포함여부, 원하는 문자열패턴검색
- 문자열 패턴을 나타내는 기호는 <CODE>( % )</CODE> , <CODE>( _ )</CODE>


<BR/>

- **% : 문자가 0개이상 아무문자나 허용할때 사용**
  - 예)  %강% : 강 o, 한강, 두강, 두만강, 한강다리, 강강술래 -> 강이 포함되어있는 문자열
  - %강 : 강으로 끝나는 말
  - 강% : 강으로 시작하는 말

<BR/>

- _ : 문자가 1개 아무문자나 허용할때 사용

  - _강_ : 중간에 강이 있는 세글자
  - _강 : 강으로 끝나는 두글자
  - 강_ : 강으로 시작하는 두글자
  - _강% : 두글자 이상의 두번째자리에 강을 포함하는 문자

<BR/>


-- 사원 중 유씨성을 가진 사원의 이름, 월급, 부서코드를 조회

```SQL
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '유__';

-- 이메일 주소에 yo를 포함하고 있는 사원의 사원명, 이메일 조회하기
```SQL       
SELECT EMP_NAME, EMAIL 
FROM EMPLOYEE
WHERE EMAIL LIKE '%yo%';
```

<BR/>

## NOT

- 명령어 앞에 NOT을 사용한다면
- **일치하지 않는 것들을 찾을수가있다.**
- **JAVA에서 사용했던 ( ! ) 랑같다.**
```SQL
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME NOT LIKE '김%';
```        
        
<BR/>

## 5. NULL
- **NULL값은 여기에선 쓰레기, 아무의미없는 값이다. 연산도 불가능하다.**
- 그렇다면 NULL값을 찾고싶을땐 어떻게 해야할까?
- <CODE>IS NULL</CODE>,<CODE> IS NOT NULL</CODE> 를 사용한다.

         -- 보너스를 받지 않는 사원조회하기
         
         SELECT EMP_NAME,BONUS
         FROM EMPLOYEE
         --WHERE BONUS='(null)';
         WHERE BONUS IS NULL;
         
         -- 보너스를 받고있는 사원의 이름, 보IS너스를 조회하기
          SELECT EMP_NAME,BONUS
          FROM EMPLOYEE
          WHERE BONUS IS NOT NULL;
          
          
<BR/>

         
## NULL 대체하기
- 조회를 할때 아무것도 없을때 NULL로 표시간된다.
- NULL로 표현하고 싶지않고 다른값으로 표현하고싶을떄 사용하는 명려어가있다.
- **NVL(컬럼명,대체값)함수를 이용한다.**

        -- BONUS의 NULL값을 0으로변경
        SELECT EMP_NAME, SALARY, NVL(BONUS,0)
        FROM EMPLOYEE;
        
        
         
<BR/>
 
 
# 6. IN
  
  - 다중값을 동등 비교할때 사용하는 명령어다.
  - 위에서는 다중비교를 할때 <CODE>OR</CODE> 를 사용햇지만 더간편하게가능하다.

        
        SELECT * 
        FROM EMPLOYEE
        WHERE DEPT_CODE NOT IN ('D5','D6','D7','D8');
        
        --WHERE DEPT_CODE='D5' OR DEPT_CODE='D6' OR DEPT_CODE='D7' OR DEPT_CODE='D8';
        
<BR/>

# 7. SYSDATE
- 오늘 날짜를 출력할때 사용한다.
- <CODE>SELECT SYSDATE</CODE>
        
        -- 현재날짜
        SELECT SYSDATE FROM DUAL;
        
        -- 현재날짜에서 10일을 
        SELECT SYSDATE-10 FROM DUAL;
        
        
 <BR/>       
        

# 8. LENGTH
- **저장된 컬럼이나 리터럴값에 대한길이를 출력해주는 함수**
- 사용방법

  -  LENGTH('문자열'||컬럼명)  - > 문자열의 갯수를 출력

        SELECT LENGTH('오늘 월요일 힘내요!')
        FROM DUAL;
        SELECT EMAIL, LENGTH(EMAIL)
        FROM EMPLOYEE;
        //출력결과
        //11

- 컬럼안에 있는 문자열도가능하다.

        SELECT EMAIL, LENGTH(EMAIL)
        FROM EMPLOYEE;        

- 조건을 넣어서 조회도가능하다.

        SELECT EMP_NAME, EMAIL, LENGTH(EMAIL)
        FROM EMPLOYEE
        WHERE LENGTH(EMAIL)>=16;  
        
<BR/>

# 9. LENGTHB
- 차지하는 BYTE를 출력해준다.
- **EXPRESS버전에서 한글은 3BYTE로 저장된다. ENTERPRISE버전에서는 2BYTE로저장된다.**

        SELECT LENGTHB('ABCD'), LENGTHB('월요일')
        FROM EMPLOYEE;      
        //'ABCD/'월요일'
        //4     / 9

<BR/>

# 10. INSTR
- JAVA의 INDEXOF 와 유사한 기능을가지고있다.
- **지정한 위치부터 지정한 숫자 번째로 나타나는 문자의 시작 위치 반환**
- 사용방법

  -  **INSTR('문자열'||컬럼,'찾을 문자'[,시작위치, 찾을번째(횟수)]**
  -  오라클에서는  인덱스 번호는 1부터시작한다.
  -  없는 값을 찾을때는 0을 출력한다.

        
        SELECT INSTR('GD태풍','GD'), INSTR('GD태풍','태'),INSTR('GD태풍','풍')
        FROM DUAL;
        //INSTR('GD태풍','GD'), INSTR('GD태풍','태'),INSTR('GD태풍','병')
              1                     3                         0
              
<BR/>

- 컬럼값을 넣어 찾을수도있다.


        --EMAIL 주소에 j가 포함되어있는 사원찾기
        
        SELECT EMAIL, INSTR(EMAIL,'j')
        FROM EMPLOYEE;
        

<BR/>

## 시작위치를 정해서 검색하기

        SELECT INSTR('GD아카데미 GD게임즈 GD음악사 GD화이팅','GD'),
        
        -- 3번째 부터 시작해서 GD를 찾아라
        INSTR('GD아카데미 GD게임즈 GD음악사 GD화이팅','GD',3),
        
        -- 음수값을 집어넣으면 뒤에서부터찾는다.
        INSTR('GD아카데미 GD게임즈 GD음악사 GD화이팅','GD',-1),
        
        --  1부터시작해서 3번째 GD를 찾아라
        INSTR('GD아카데미 GD게임즈 GD음악사 GD화이팅','GD',1,3)
        FROM DUAL;


- 이것또한 컬럼값을 넣어 찾을수있다.

          -- EMAIL 컬럼에서 @위 위치를 
          
         SELECT EMP_NAME, EMAIL, INSTR(EMAIL,'@')
         FROM EMPLOYEE;

<BR/>

# 11. LPAD RPAD

- **문자열의 길이가 지정한 길이만큼 차지 않았을때 빈공백을 채워주는 함수다.**
- 사용방법

  - LPAD/RPAD(문자열||컬럼,최대길이,대체문자)


## LAPD
- **LPAD 왼쪽부터 빈공간채움**
- 대체문자를 정하지않앗다면 공백으로 출력한다.

        SELECT LPAD('강태풍',10,'*'), LPAD('강태풍',10)
        FROM DUAL;
        //****강태풍   |    강태풍    
        
<BR/>

## RPAD
- **RPAD 오른쪽부터 빈공간채움**
- 대체문자를 정하지않앗다면 공백으로 출력한다.

        SELECT RPAD('강태풍',10,'@')
        FROM DUAL;
        //강태풍@@@@


## 칼럼을 가져와서 사용

        SELECT EMAIL, RPAD(EMAIL,20,'#')
        FROM EMPLOYEE;
        //sun_di@BS.or.kr#####
        
        
<BR/>


# 12. LTRIM RTRIM

- **공백을 제거하는 함수, 특정문자를 지정해서 삭제해주는 함수**
- 공백으로 연달아있는 공백만 지운다.
- 글자사이에 공백은 삭제하지않는다.
- 사용방법

  -  LTRIM/RTRIM('문자열'||컬럼[,'특정문자'])

        SELECT '              태풍',  LTRIM ('             태풍') , RTRIM('                태풍                     ')
        FROM DUAL;
        //        병승|병승     |         병승
        
- 특정 문자를 지정해서 삭제할 수 있다.
- 연달아있는 수만 지우고 다른문구가 들어가있다면 지우지않는다.

        SELECT ' 태풍2222', RTRIM('태풍2222','2'), RTRIM('태풍22122','2'),
        RTRIM('태풍22122','12')
        FROM DUAL;
        //태풍2222|태풍       |태풍221        |태풍
        
<BR/>

## TRIM
- 양쪽에 있는 값을 제거하는 함수, 기본 : 공백, 설정하면 설정값을 제거(한글자만)
- 사용방법

  -  TRIM(문자열||컬럼)
  -  TRIM(LEADING||TRAILING||BOTH '제거할문자' FROM 문자열||컬럼명)
  -  삭제할 문자열은 한글자만가능!
      
        
        SELECT '                    월요일                 ',TRIM( '                    월요일                 ')
        ,'ZZZZZZ마징가ZZZZZZ',TRIM('Z' FROM 'ZZZZZZ마징가ZZZZZZ'),
        TRIM(LEADING 'Z' FROM 'ZZZZZZ마징가ZZZZZZ'),
        TRIM(TRAILING 'Z' FROM 'ZZZZZZ마징가ZZZZZZ'),
        TRIM(BOTH 'Z' FROM 'ZZZZZZ마징가ZZZZZZ')
        FROM EMPLOYEE;

# 13. SUBSTR
-  **열을 잘라내는 기능 * JAVA SUBSTRING메소드와 동일하다**
-  사용방법

  - SUBSTR(문자열||컬럼명,시작인덱스번호,[,길이])


 
        -- 5번째부터 가져오겟다.
        SELECT SUBSTR('SHOWMETHEMONEY',5), 
        
        -- 5번째 중에 2개만 가져오겟다.
        SUBSTR('SHOWMETHEMONEY',5,2),
        
        --뒤에서부터 5번째 2개가져오겟다.
        
        SUBSTR('SHOWMETHEMONEY',-5,2) 
        
<BR/>   

# 14. UPPER LOWER INITCAP
- **영문자를 처리하는 함수**

  - UPPER : 전부 대문자로처리
  - LOWER : 전부 소문자로 처리
  - INITCAP : 문자에 첫자리만 대문자

       SELECT UPPER('Welcome to oRACLE worLd'),
       LOWER('Welcome to oRACLE worLd'),
       INITCAP('Welcome to oRACLE worLd')
       FROM DUAL;
       
<BR/>

# 15. CONCAT
- **문자열을 결합해주는 함수
- ( || )연산자와 동일하다.

        SELECT EMP_NAME ||EMAIL, CONCAT(EMP_NAME, EMAIL)
        ,CONCAT(CONCAT(EMP_NAME, EMAIL),SALARY)
        FROM EMPLOYEE;
        
<BR/>

# 16. PEPLACE
- 대상문자에서 지정문자를 찾아서 특정문자로 변경하는 것
- 사용방법

  - PEPLACE(문자열||컬럼명,'찾을문자','대체문자')

        SELECT EMAIL, REPLACE(EMAIL,'BS','GD')
        FROM EMPLOYEE;    
<BR/>

# 17. REVERSE
- 문자열을 거꾸로 만들어주는 기능
        SELECT EMAIL, REVERSE(EMAIL)
        
<BR/>


# 18. TRANSLATE
- 매칭되는 문자로 변경해주는 함수

        SELECT TRANSLATE ('010-3644-6259','0123456789','영일이삼사오육칠팔구')
<BR/>

# 19. ABS
- 숫자처리 함수
- 절대값을 처리한다.

        SELECT ABS(-10), ABS(10)
<BR/>

# 20. MOD
- 나머지를 구하는 함수
- 자바의 %연산자와 동일한함수


```SQL
SELECT MOD(3,2)
```
<BR/>

# 21. ROUND

- 소수점을 반올림하는함수
- 사용방법

  - ROUND (숫자||컬럼명[,자리수])


        
        SELECT 126.567,ROUND(126.567), ROUND(126.467),ROUND(126.567,2)
        
<BR/>

# 22. FLOOR
- 소수점자리 버리는함수

        SELECT 126.567, FLOOR(126.567)
<BR/>

# 23. TRUNC
- 소수점 자리를 버리면서 자리수를 지정할수가있다.
- **자리수 자리에 음수가나오면 소수점앞으로가면서 지나간숫자들을 0으로 만듬**


        SELECT 126.567, TRUNC(126.567) , TRUNC(126.567,2) ,TRUNC(126.567,-2),
        TRUNC(2123456.32,-2)
        
# 24. CEIL
- 소수점 올리는 함수
        SELECT 126.567, CEIL(126.567),CEIL(126.111)
        //결과 127
<BR/>

# 25. DATE 
- 오라클에서 날짜를 출력할때는 두가지방식이있다.

  - SYSDATE예약어 -> 날짜 년/월/일 오늘 날짜(오라클이 설치되어있는 컴퓨터의 날짜)를 출력해줌.
  - SYSTIMESTAMP예약어 -> 날짜+시간까지 출력해줌

        
        SELECT SYSDATE, SYSTIMESTAMP
        
<BR/>

- **도 산술연산처리가 가능하다. +, - 연산 가능 -> 일수가 차감 , 추가된다.**

        SELECT SYSDATE, SYSDATE-2, SYSDATE+3,SYSDATE+30
<BR/>


# 26. NEXT_DAY
- 매개변수로 전달받은 요일 중 가장 가까운 다음 날짜 출력

        SELECT SYSDATE, NEXT_DAY(SYSDATE,'월'),NEXT_DAY(SYSDATE,'수')
        
        
- **오라클은 외국 기업인데 왜 한글이 들어가도 정삭적으로작동할까?**

  - LOCALE의 값이 한국으로 되어있기에 월요일,수, 등등 가능하다.
  - LOCALE의 값을 가지고 언어선택을 할수가있다.

        
        SELECT * FROM V$NLS_PARAMETERS;
        ALTER SESSION SET NLS_LANGUAGE = 'KOREAN';
        SELECT SYSDATE, NEXT_DAY(SYSDATE,'MON'),NEXT_DAY(SYSDATE,'TUESDAY')

<BR/>

# 27. LASY_DAY
- 그달의 마지막날을 출력한다.

        SELECT SYSDATE, LAST_DAY(SYSDATE), LAST_DAY(SYSDATE+30)
<BR/>


# 28. ADD_MONTHS
- 개월수를 더해주는 함수

            SELECT SYSDATE, ADD_MONTHS(SYSDATE,4)
<BR/>

# 29. MONTHS_BETWEEN
- 두개의 날짜를 받아서 두날짜의 개월수를 계산해주는 함수

        SELECT FLOOR (MONTHS_BETWEEN('23/08/17',SYSDATE))

<BR/>

# 30. EXTRACT
- 날짜의 년도, 월, 일자를 따로 출력할 수 있는 함수

  - EXTRACT(YEAR||MONTH||DAY FROM 날짜)
  - 숫자로 출력해준다.

        -- 현재날짜의 년, 월, 일 출력하기
        
        SELECT EXTRACT(YEAR FROM SYSDATE) AS 년 , EXTRACT(MONTH FROM SYSDATE) AS 월,           EXTRACT(DAY FROM SYSDATE) AS 일

        
- 날짜에 숫자를 더할수가 있다.

        
        SELECT EXTRACT(DAY FROM HIRE_DATE)+100
        
<BR/>

# 31. TO_CHAR
- 숫자, 날짜를 문자형으로 변경해주는 함수

<BR/>

## 날짜를 문자형으로 변경하기

  - 날짜값을 기호로표시해서 문자형으로 변경을 한다.
  - Y : 년, M : 월, D : 일 , H : 시 , MI : 분, ss : 초

        SELECT SYSDATE, TO_CHAR(SYSDATE,'YYYY-MM-DD'), TO_CHAR(SYSDATE,'YYYY-MM-DD              HH24:MI:SS')

<BR/>

## 숫자를 문자형으로 변경하기
- 패턴에 맞춰서 변환 -> 자리수를 어떻게 표현할지 선택
- 0 :  변환대상값의 자리수가 지정한 자리수와 일치하지않을때, 값이 없는 자리에 0을 표시하는 패턴
- 9 :  변환대상값의 자리수가 지정한 자리수와 일치하지않을때, 값이 없는 자리에 생략하는 패턴 
- 통화를 표시하고 싶을때는 L을 표시
- FM을붙이면 공백제거
        
        SELECT 1234567,TO_CHAR(1234567,'000,000,000'), TO_CHAR(1234567,'999,999,999'),
        TO_CHAR(500,'L999,999')
        
## 숫자형으로 변경하기
- TO_NUMBER함수를 이용
- 문자를 숫자형으로 변경하기

        SELECT 1000000+1000000,TO_NUMBER('1,000,000','999,999,999')+1000000,
        TO_CHAR(TO_NUMBER('1,000,000','999,999,999')+1000000,'FML999,999,999') 
  
## 날짜형으로 변경하기
- 숫자를 날짜로 변경
- 문자열을 날짜로 변경

        SELECT TO_DATE('23/12/25','YY/MM/DD')-SYSDATE,                TO_DATE('241225','YYMMDD'),TO_DATE('25-12-25','YY-MM-DD') 
        

- 주의사항
- 년원일을 사용할떄 앞에 000이붙으면 조심해야한다 000은 읽지않기때문이다 그래서 문자열로 변경해서사용한다.

        SELECT TO_DATE(20230405,'YYYY/MM/DD'), TO_DATE(230505,'YYMMDD'), TO_DATE (TO_CHAR(00224,'000000'),'YYMMDD')
        
<BR/>


# 32. NVL

- NULL갑을 처리해주는 함수

  - NVL함수 : NVL(컬럼,대체값)
  - NVL2함수 : NVL2(컬럼,NULL아닐때, NULL일때)

        SELECT EMP_NAME, DEPT_CODE, NVL(DEPT_CODE,'인턴'),
        NVL2(DEPT_CODE,'있음','없음')         

# 33. DECODE

- 조건에 따라 출력할 값을 변경해주는 함수

  - DECODE(컬럼명 || 문자열, '예상값','대체값','예상값2','대체값2',.....)

       
         -- 각 직책코드의 명칭을 출력하기
        -- J1은 대표, J2 부사장, J3 부장, J4 과장
        -- 맨마지막에는 적으면디폴트값이된다.
        SELECT EMP_NAME, DECODE(JOB_CODE,'J1','대표','J2','부사장','J3','부장','J4','과         장','사원') AS 직책
        FROM EMPLOYEE;        

<BR/>

# 34. CASE WHEN THEN ELSE
- 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 결과 값 반환(조건은범위 값 가능)
- 조건 : 해당 값이 참인지 거짓인지 여부 판단
- 결과 : 해당 조건과 일치하는 경우 반환할 값
- DEFAULT : 모든 조건이 불일치 시 반환할 값




  - CASE
  -   WHEN 조건식 THEN 실행내용
  -   WHEN 조건식 THEN 실행내용
  -   WHEN 조건식 THEN 실행내용
  -   ELSE 실행내용 
  -   END

        
          SELECT EMP_NAME, JOB_CODE,
            CASE
                    WHEN JOB_CODE = 'J1' THEN '대표'
                    WHEN JOB_CODE = 'J2' THEN '부사장'
                    WHEN JOB_CODE = 'J3' THEN '부장'
                    WHEN JOB_CODE = 'J4' THEN '과장'
                    ELSE '사원'
            END AS 직책,
            CASE JOB_CODE
                    WHEN 'J1' THEN '대표'
                    WHEN 'J2' THEN '부사장'
            END



<BR/>

# 35. SUM
- 테이블의 특정컬럼에 대한 총합 -> SUM(컬럼(NUMBER))

        SELECT TO_CHAR (SUM(SALARY),'FML999,999,999') FROM EMPLOYEE;

 <BR/>
 
 # 36. AVG
  
- 테이블의 특정컬럼에 대한 평균 -> AVG(컬럼(NUMBER))

         -- D5의 급여 평균을 구하기
        SELECT AVG(SALARY) FROM EMPLOYEE
        WHERE DEPT_CODE = 'D5';

<BR/>

# 37. COUNT
- 테이블의 데이터수(ROW수) -> COUNT(* | | 컬럼)

        -- 테이블의 데이터수 확인하기
        
        SELECT COUNT(*)
        FROM EMPLOYEE;

<BR/>

# 38. MAX MIN
- 테이블의 특정컬럼에 대한 최소값 -> MIN(컬럼명)

        SELECT MAX(SALARY), MIN(SALARY)
        
<BR/>

# 39. GROUP BY
- 그룹함수를 사용했을때 특정기준으로 컬럼값을 묶어서 처리하는 것 -> 묶인 그룹별 그룹함수의 결과가 출력됨.

  - SELECT 컬럼
  - FROM 테이블명
  - [WHERE 조건식]
  - [GROUP BY 컬럼명[,컬럼명,컬럼명,..... ]]
  - [ORDERY BY 컬럼명]


        -- 부서별 급여 합계를 구하시오
        SELECT DEPT_CODE,SUM(SALARY)
        FROM EMPLOYEE
        GROUP BY DEPT_CODE;       

<BR/>

## GROUP BY 절에는 다수의 컬럼을 넣을 수 있다
        
        SELECT DEPT_CODE, JOB_CODE, COUNT(*)
        FROM EMPLOYEE
        GROUP BY DEPT_CODE, JOB_CODE;

<BR/>

## GROUP BY를 사용한 절에서 WHERE 도 사용이 가능하다.

        SELECT DEPT_CODE, SUM(SALARY)
        FROM EMPLOYEE
        WHERE BONUS IS NOT NULL
        GROUP BY DEPT_CODE; 
        
<BR/>

# 40. HAVING
- WHERE 는 그룹함수를 사용할수가없다. WHERE COUNT(*) >=3 <- 불가능
- HAVING 사용한다.   HAVING COUNT(*) >=3;  


        
        -- 직책별 인원수가 3명이상인 직책 출력하기
        
        SELECT JOB_CODE , COUNT(*)
        FROM EMPLOYEE
        GROUP BY JOB_CODE
        HAVING COUNT(*)>=3;
        
<BR/>

# 41. ROLLUP() CUBE()
- 각 그룹별 집계와 총집계를 한번에 출력해주는 함수다.
- <CODE>OLLUP()</CODE> 와 <CODE>CUBE()</CODE> 를사용한다.

  - ROLLUP : 두개이상의 인수를 전달했을때 두개 컬럼의 집계, 첫번째 인수컬럼의 소계, 전체 총계
  - CUBE : 두개이상 인수를 전달했을때 두개 컬럼의 집계, 첫번째 인수컬럼의 소계, 두번째 인수컬럼의 소개 , 전체 총계


## ROLLUP
- 먼저 첫번째 컬럼의 소계를한후 전체총계를한다


```SQL
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL 
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE);
---------------------------------------
D1	J6	6440000
D1	J7	1380000
D1	NULL	7820000
D2	J2	8960000
D2	J4	6520000
D2	NULL	15480000
D5	J3	3500000
D5	J5	8460000
D5	J7	3800000
D5	NULL	15760000
D6	J3	7300000
D6	J4	2800000
D6	NULL	10100000
D8	J6	6986240
D8	NULL	6986240
D9	J1	8000000
D9	J2	9700000
D9	NULL	17700000
NULL	NULL	73846240
```
- 위에결과를 보고 설명하자면
- DEPT_CODE 의 경우의수를 전부 돈다고 생각하면된다.
- D1이면서 J1,J2,J3,.......전부돌고 일치하는값이 있다면 출력된다
- 위를 보면 D1이면서 J6 값과 D1이면서 J7값이 일치한다 그래서 출력이된거다
- 그후 그두개의값을 합친결과가 출력이된다.

<BR/>

## CUBE
- 인수가 2개일때 인수 각각의 경우의 수를 전부돈다.

```SQL
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL 
GROUP BY CUBE(DEPT_CODE, JOB_CODE);

---------------------------------------------------
NULL	NULL	73846240
NULL	J1	8000000
NULL	J2	18660000
NULL	J3	10800000
NULL	J4	9320000
NULL	J5	8460000
NULL	J6	13426240
NULL	J7	5180000
D1	NULL	7820000
D1	J6	6440000
D1	J7	1380000
D2	NULL	15480000
D2	J2	8960000
D2	J4	6520000
D5	NULL	15760000
D5	J3	3500000
D5	J5	8460000
D5	J7	3800000
D6	NULL	10100000
D6	J3	7300000
D6	J4	2800000
D8	NULL	6986240
D8	J6	6986240
D9	NULL	17700000
D9	J1	8000000
D9	J2	9700000
```
- JOB_CODE 의 경우의수 전부 돈후 DEPT_CODE 의경우의수를 돈다음 전체값을 출력한다.

<BR/>

# 42. GROUPING
- GROUPING함수를 이용하면 집계한 결과에 대한 분기처리르 할 수 있다.
- ROLLUP, CUBE로 집계된 ROW에 대한 분기처리
- GROUPING 함수를 실행하면, ROLLUP, CUBE로 집계된 ROW 1을 반환 아니면 0을 반환한다

	- 쉽게 설명하자면
	- 그냥 우리가 컬럼에 AS로 이름을 붙이듯이
	- 그룹에 이름을 붙이는거라고 생각하면된다.
	- **NULL값은 1을 반환 그게아니라면 0을반환한다.**

```SQL
SELECT COUNT(*),DEPT_CODE, JOB_CODE,
CASE
WHEN GROUPING(DEPT_CODE)=0 AND GROUPING(JOB_CODE)=1 THEN '부서별인원'
WHEN GROUPING(DEPT_CODE)=1 AND GROUPING(JOB_CODE)=0 THEN '직책별인원'
WHEN GROUPING(DEPT_CODE)=0 AND GROUPING(JOB_CODE)=0 THEN '부서_직책인원'
WHEN GROUPING(DEPT_CODE)=1 AND GROUPING(JOB_CODE)=1 THEN '총인원'
END AS 결과
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY CUBE(DEPT_CODE, JOB_CODE);
------------------------------------------------------------------------
23			총인원
1	NULL	J1	직책별인원
4	NULL	J2	직책별인원
3	NULL	J3	직책별인원
4	NULL	J4	직책별인원
3	NULL	J5	직책별인원
5	NULL	J6	직책별인원
3	NULL	J7	직책별인원
3	D1	NULL	부서별인원
2	D1	J6	부서_직책인원
1	D1	J7	부서_직책인원
5	D2	NULL	부서별인원
2	D2	J2	부서_직책인원
3	D2	J4	부서_직책인원
6	D5	NULL	부서별인원
1	D5	J3	부서_직책인원
3	D5	J5	부서_직책인원
2	D5	J7	부서_직책인원
3	D6	NULL	부서별인원
2	D6	J3	부서_직책인원
1	D6	J4	부서_직책인원
3	D8	NULL	부서별인원
3	D8	J6	부서_직책인원
3	D9	NULL	부서별인원
1	D9	J1	부서_직책인원
2	D9	J2	부서_직책인원
```
- 총집계의이름을 설정하지않앗으니 둘다 NULL이나오니 1,1을붙인다.

<BR/>

# 43. ORDER BY
- 테이블에서 조회한 데이터를 정렬해준다.
	
	- ORDER BY 구문을 사용함.
	- SELECT 컬럼명.....
	- FROM 테이블명
	- [WHERE 조건식]
	- [GROUP BY 컬럼명]
	- [HAVING 조건식]
	- 정렬방법은 생략가능 디포틀값으로 나옴 디폴트값 = 오름차순
	- [ORDER BY 컬럼명 정렬방식(DESC(내림),ASC(오름, DEFAULT)]

```SQL
-- 이름을 기준으로 정렬하기

--오름차순
SELECT *
FROM EMPLOYEE
ORDER BY EMP_NAME;

--내림차순
SELECT *
FROM EMPLOYEE
ORDER BY EMP_NAME DESC;
```

- 여러개를 쓸수도잇다.
```SQL
-- 부서코드를 기준으로 오름차순정렬하고 값이 같으면 월급이 내림차순으로 정렬하기
SELECT *
FROM EMPLOYEE
ORDER BY DEPT_CODE ASC, SALARY DESC, EMP_NAME ASC;
```
## 정렬햇을때 NULL값에 대한 처리
- ORDER BY BONUS  DESC; -- NULL인 값을 먼저 출력한다.
- ORDER BY BONUS  ASC; -- NULL인 값을 나중에 출력한다.
- 옵션을 설정해서 NULL값출력위치를 변경할 수 있다

```SQL
-- NULL값을 나중출력
SELECT *
FROM EMPLOYEE
ORDER BY BONUS ASC NULLS LAST;

-- NULL값을 먼저 출력
SELECT *
FROM EMPLOYEE
ORDER BY BONUS ASC NULLS FIRST;
```

<BR/>

##  ORDER BY 절에서는 별칭을 사용할 수 있음

```SQL
SELECT EMP_NAME, SALARY AS 월급, BONUS
FROM EMPLOYEE
ORDER BY 월급;
```
- WHERE 에는 쓰지못한다'월급'  FROM을먼저 그다음 WHERE 그다음에 별칭을 부여하기때문에 불가능하다.

<BR/>

## 인덱스번호로 정렬
- SELECT문을 이용해서 데이터를 조회하면 RESULT SET 이 출력되는데
- RESULT SET 에 출력되는 컬럼에는 자동으로 INDEX번호가 1부터 부여가 된다.
- SELECT 는 출력시 컬럼명에 순서대로 인덱스부여한다 그인덱스번호를 사용할수있다.

```SQL
SELECT *
FROM EMPLOYEE
ORDER BY 2;
208	김해술
202	노옹철
215	대북혼
206	박나라
214	방명수
200	선동일
203	송은희
201	송종기
209	심봉선
252	옛사람
251	월드컵
204	유재식
221	유하진
```
- 2를 넣엇으니 2번째칼럼인 이름들이 정렬된다.
- 1을 넣는다면 앞에 숫자들이 정렬이된다.

<BR/>

# 44. 집합연산자
- 여러개의 SELECT문을 한개의 결과(RESULT SET)으로 출력해주는 것
- 첫번째 SELECT문의 컬럼수와 이후 SELECT문의 컬럼수가 같아야한다.
- 각 컬럼별 데이터 타입도 동일해아한다.
- 
- UNION :  두개이상의 SELECT문을 합치는 연산자 중복값이 있을때 하나만 출력된다
- UNION ALL :  중복값이있다면 중복값 포함시킨다
- MINUS : 중복값 포함 하지않는다.
- INTERSECT :  중복값만 가져오다.

<BR/>

## UNION
```SQL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;
------------------------------------------------
200	선동일	D9	8000000
201	송종기	D9	6000000
202	노옹철	D9	3700000
204	유재식	D6	3400000
205	정중하	D6	3900000
206	박나라	D5	1800000
207	하이유	D5	2200000
208	김해술	D5	2500000
209	심봉선	D5	3500000
210	윤은해	D5	2000000
215	대북혼	D5	3760000
217	전지연	D1	3660000
251	월드컵	D2	4480000
252	옛사람	D2	4480000
```

- DEPT_CODE가 D5이고 월급이 3000000 이상인 사람전부 조회
- 중복값은이 있다면 하나만 출력한다.

<BR/>

## UNION ALL
- UNION과 비슷하지만 중복값이 있다면 중복값도 포함을한다.

```SQL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;
---------------------------------------------
206	박나라	D5	1800000
207	하이유	D5	2200000
208	김해술	D5	2500000
209	심봉선	D5	3500000
210	윤은해	D5	2000000
215	대북혼	D5	3760000
200	선동일	D9	8000000
201	송종기	D9	6000000
202	노옹철	D9	3700000
204	유재식	D6	3400000
205	정중하	D6	3900000
209	심봉선	D5	3500000
215	대북혼	D5	3760000
217	전지연	D1	3660000
252	옛사람	D2	4480000
251	월드컵	D2	4480000
```

<BR/>

## MINUS

- 중복값 을 포함하지 않는다
```SQL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;
------------------------------------------
206	박나라	D5	1800000
207	하이유	D5	2200000
208	김해술	D5	2500000
210	윤은해	D5	2000000
```
<BR/>

## INTERSECT
- 중복값만 가져온다.

```SQL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;
------------------------------------------
209	심봉선	D5	3500000
215	대북혼	D5	3760000
```
<BR/>
## 주의할점
- 두개의 SELECT문의 컬럼의 타입을 맞춰야 한다
- 두 SELECT문의 컬럼의 수가 다르면 안된다
- 맞는 컬럼이없을경우 고정값(리터럴값)을 정해서 넣을수도있다.

```SQL
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
UNION
SELECT DEPT_ID, DEPT_TITLE , 10
FROM DEPARTMENT;
```
- 위처럼 SALARY값이없을경우 리터럴 값을 이용해서 사용할수도있다.

<BR/>

# 45. GROUPING SET
- 여러 GROUP BY 절이 있는 구문을 하나로 작성하게 해주는 기능이다
```SQL
-- 부서, 직책, 매니저별 급여평균
SELECT DEPT_CODE, JOB_CODE, MANAGER_ID , AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE,JOB_CODE, MANAGER_ID;

-- 부서, 직책별, 급여평균
SELECT DEPT_CODE, JOB_CODE , AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE,JOB_CODE;

-- 부서, 매니저별 급여평균
SELECT DEPT_CODE,  MANAGER_ID , AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, MANAGER_ID;
```
- 위에있는 걸 전부한번에 조회할수가있다.

```SQL
-- GROUPING SET 을 이용해서 묶어서 사용해줄수있다.

SELECT DEPT_CODE, JOB_CODE, MANAGER_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY GROUPING SETS((DEPT_CODE,JOB_CODE,MANAGER_ID),(DEPT_CODE,JOB_CODE),(DEPT_CODE, MANAGER_ID));
```
<BR/>

# 46.INNER JOIN
- 두개이상의 테이블을 특정컬럼을 기준으로 연결해준, 기능
- JOIN은 두 종류가 있음
- 1. INNER JOIN : 기준되는 값이 일치하는 ROW만 가져오는 JOIN
- 2. OUTER JOIN :  기준이되는 값이 일치하지 않은 ROW도 가져오는 JOIN * 기준이 필요하다
- JOIN을 작성하는 방법 2가지

	- 1. 오라클 조인방식 :  , 와 WHERE로 작성
 	- 2. ANSI 표준 조인방식 :  JOIN, ON | | USING 예약어를 사용해서 작성


```SQL
-- 오라클방식
SELECT*
 FROM EMPLOYEE, DEPARTMENT
 WHERE EMPLOYEE.DEPT_CODE = DEPARTMENT.DEPT_ID;

 -- ANSI 표준으로 JOIN하기
 SELECT *
 FROM EMPLOYEE 
 JOIN DEPARTMENT ON EMPLOYEE.DEPT_CODE = DEPARTMENT.DEPT_ID;
 ```
 <BR/>
 
 
 ## 예제

```SQL
ELECT EMP_NAME, EMAIL, PHONE,DEPT_TITLE
FROM EMPLOYEE 
JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID; 
```

 - 사원에 대해 사운명, 이메일, 전화번호, 부서명 을조회하는데
 - 부서명은 DEPARTMENT 테이블에있다
 - 이때 조인을통해 사용할수가있다.

<BR/>

## JOIN 문에서도 WHERE절 사용하기
 - 부서가 총무부인 사원  사원명, 월급, 보너스, 부서명 조회하기

```SQL
SELECT EMP_NAME, SALARY,BONUS, DEPT_TITLE
 FROM EMPLOYEE
 JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
 WHERE DEPT_TITLE = '총무부';
 ------------------------------------------
 노옹철	3700000	NULL	총무부
송종기	6000000	NULL	총무부
선동일	8000000	0.3	총무부
```

<BR/>

## JOIN 문에서 GROUP BY 절 사용하기
- 부서별 평균급여를 출력하기 부서명, 평균급여

```SQL
SELECT DEPT_TITLE,AVG(SALARY)
 FROM EMPLOYEE
 JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID
 GROUP BY DEPT_TITLE
HAVING AVG(SALARY)>=3000000;
-----------------------------------------
총무부	5900000
회계관리부	3096000
해외영업2부	3366666.66666666666666666666666666666667
```
<BR/>

## JOIN할때 기준이되는 컬럼명이 중복된다면 반드시 별칭을 작성해야한다.
- 사원명, 급여, 보너스, 직책명을 조회하기


```SQL
SELECT *
FROM EMPLOYEE E
    JOIN JOB J ON E.JOB_CODE=J.JOB_CODE;
```

- 이런식으로 별칭을 이용해서 사용도가능하지만
- <CODE>USING</CODE> 을 이용해서도 가능하다.
	- 중복되는 코드가 하나만 출력이된다.
	- 하나만 출력되기때문에 별칭부여해서 구분할필요가없다.
	- USING 을사용할때 식별자(별칭)를 쓰지않는다.

```SQL
SELECT * 
FROM EMPLOYEE
    JOIN JOB  USING(JOB_CODE)
WHERE JOB_CODE='J3'; 
SELECT * FROM JOB;
```
<BR/>

## JOIN 은 NULL값을 무시한다.
- JOIN 을 사용한다면 NULL이 나오지않는다.
- **NULL값을 조회할려면 OUTER JOIN사용해야한다.**

<BR/>

# 47. OUTER JOIN
- 컬럼에 대해 동일비교를 했을때 없는 ROW를 출력해주는 JOIN
- 기준이 되는 테이블(모든데이터를 출력함)을 설정해줘야한다.
- <CODE>LEFT OUTER JOIN</CODE> 와 <CODE>RIGHT OUTER JOIN</CODE> 을사용한다.

	- LEFT OUTER JOIN : JOIN을 기준으로 왼쪽에 있는 테이블을 기준으로 설정
	- RIGHT OUTER JOIN : JOIN을 기준으로 오른쪽에 있는 테이블을 기준으로 설정
- 일치되는 ROW가 없는 경우 모든 컬럼을 NULL로 표시한다
- OUTER 은 생략해도 상관없음

```SQL
-- LEFT OUTER JOIN
SELECT *
FROM EMPLOYEE LEFT  JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID;
----------------------------------------------------------
214	방명수	856795-1313513
216	차태연	770808-1364897
217	전지연	770808-2665412
219	임시환	660712-1212123
220	이중석	770823-1113111
221	유하진	800808-1123341
252	옛사람	320808-1123341
251	월드컵	320808-2123341
206	박나라	630709-2054321
207	하이유	690402-2040612
208	김해술	870927-1313564
209	심봉선	750206-1325546
210	윤은해	650505-2356985

-- RIGHT OUTER JOIN 
SELECT *
FROM EMPLOYEE RIGHT OUTER JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID;
--------------------------------------------------------------
214	방명수	856795-1313513
216	차태연	770808-1364897
217	전지연	770808-2665412
252	옛사람	320808-1123341
220	이중석	770823-1113111
219	임시환	660712-1212123
251	월드컵	320808-2123341
221	유하진	800808-1123341
NULL	NULL	NULL
NULL	NULL	NULL
210	윤은해	650505-2356985
```

<BR/>

# 48. CROSS JOIN

- 모든 ROW를 연결해주는 JOIN


```SQL
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE CROSS JOIN DEPARTMENT
ORDER BY 1;
-----------------------------------
김해술	인사관리부
김해술	회계관리부
김해술	마케팅부
김해술	국내영업부
김해술	총무부
김해술	해외영업2부
김해술	해외영업3부
김해술	기술지원부
김해술	해외영업1부
노옹철	회계관리부
노옹철	해외영업1부
노옹철	총무부
노옹철	국내영업부
노옹철	기술지원부
```

<BR/>


# 49.SELF JOIN

- 한개의 테이블에 다른 컬럼의 값을 가지고 있는 컬럼이 있는 경우 그두개 컬럼을 이용해서 JOIN

- MANAGER가 있는 사원의 이름, 매니저 아이디, 매니저 사원번호, 매니저 이름 조회

```SQL
SELECT E.EMP_NAME,E.MANAGER_ID,M.EMP_ID,M.EMP_NAME
FROM EMPLOYEE E
JOIN EMPLOYEE M ON E.MANAGER_ID=M.EMP_ID;
-------------------------------------------------------
송종기	200	200	선동일
전형돈	200	200	선동일
유재식	200	200	선동일
하이유	200	200	선동일
방명수	200	200	선동일
노옹철	201	201	송종기
정중하	204	204	유재식
송은희	204	204	유재식
윤은해	207	207	하이유
심봉선	207	207	하이유
김해술	207	207	하이유
박나라	207	207	하이유
장쯔위	211	211	전형돈
전지연	214	214	방명수
차태연	214	214	방명수
```

<BR/>

# 50. 비동등조인
- 동등 비교할 컬럼이없는경우
- 연결할 테이블이 범위값을 가져야한다.

```SQL
SELECT * 
FROM EMPLOYEE
       JOIN SAL_GRADE ON SALARY BETWEEN MIN_SAL AND  MAX_SAL;
```

<BR/>

# 51. 다중조인
- 3개이상의 테이블을 연결해서 사용하기
- 사원의 사원명, 직책명, 부서명을 조회하기
```SQL
SELECT EMP_NAME,JOB_NAME,DEPT_TITLE
FROM EMPLOYEE
        JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
        JOIN JOB  USING(JOB_CODE);
-----------------------------------------------	
전지연	대리	인사관리부
차태연	대리	인사관리부
방명수	사원	인사관리부
월드컵	부사장	회계관리부
옛사람	부사장	회계관리부
유하진	차장	회계관리부
이중석	차장	회계관리부
임시환	차장	회계관리부
```
# 52. 
