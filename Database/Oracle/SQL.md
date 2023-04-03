# 🔖 목차
1. [계정생성](#1-계정생성-및-권한)<BR/>
2. [전체조회 SELECT](#2-SELECT)<BR/>
3. [조건 WHERE](#3-WHERE)<BR/>
4. [문자열패턴 LIKE](#4-LIKE)<BR/>
5. [NULL](#5-NULL)<BR/>
6. [다중값비교 IN / NOT IN](#6-IN-,-NOT-IN)<BR/>
7. [날짜 SYSDATE](#7-SYSDATE)<BR/>
8. [함수 Function](#8-함수)<BR/>
9. 


<br/>




> 데이터베이스의 첫걸음이다.
> 
> 우리는 자바를 배울때 데이터를 일회성으로 관리하며 사용햇다.
> 
> 전기신호가 끊키면 그정보들은 모두사라졋엇다. 
> 
> 그렇기때문에 전기신호가 끊켜도 데이터가 사라지지않기 하기위해
> 
> 데이터베이스를 사용한다. 그 DB에서 사용하는 언어를 SQL이라고한다.
> 
> 그냥 데이터베이스용 언어라고생각하자.



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

        -- 계정생성하는 명령어
        CREATE USER BS IDENTIFIED BY BS DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
        -- 18C버전부터 사용자계정명에 ##을 붙여서 생성해야 한다.
        -- ##안붙일 수 있게 설정하기
        ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

- 이렇게 명령어를 실행하면
- BS라는 계정이 생겻다.

<BR/>

##  DB  사용자 조회

- 등록을 했으니 정상적으로 등록이됐는지 확인해보자

        -- DB에 등록되어 있는 사용자 조회하기
        SELECT * FROM DBA_USERS;   
  
  
![DB](https://user-images.githubusercontent.com/126074577/229294188-9c629864-cc14-49b2-8715-6880a7448b28.png)

- 이런식으로 27행에 정상적으로 생성된걸 확인할수가있다.
- **하지만 계정만생성 했을뿐 저계정은 아무것도할수가없다.**
- **왜? 관리자가 권한을 부여하지않앗기때문인다.**

<BR/>
  

## 권환부여

  
- 사용자를 생성하더라도 권환이 없으면 DB를 이용할 수 없다.
- 그렇다면 사용자에게 권한을 부여해보자.

        -- GRANT 권한 or 롤(역할) TO 사용자계정명
        GRANT CONNECT TO BS;
        
        -- 테이블을 이용할 수 있는 권한을 부여하기
        GRANT RESOURCE TO BS;
        
        -- 한꺼번에 두개다 부여할수도있다.
        GRANT CONNECT, RESOURCE TO BS;
        
   
- 정말쉽지않은가? 이로써 BS계정을 사용할수있는 권환이생겻다.

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

          -- SELECT문을 이용해서 EMPLOYEE테이블의 전체 컬럼 조회하기
          SELECT * 
          FROM EMPLOYEE;
          
- ( * ) 을사용하면 전체데이터를 확인할수가 있다.

<BR/>

- 컬럼 하나하나도 조회도가능하다.

          -- 전체 사원의 이름, 월급, 보너스 입사일을 조회하기
          SELECT EMP_NAME, SALARY, BONUS, HIRE_DATE
          FROM EMPLOYEE;        
          
- 이런식으로 자기가 원하는 내용을 따로 정보를 조회할수가있다.
- **모든 내용을 확인할때는 SELECT문을 사용한다.**

## SELECT문을 이용한 산술연산

- SELECT문을 사용해서 산술연산도 가능ㅎ다ㅏ.
- 사용법은 이렇다

  - +,-,*,/(사칙연산) -> 피연산자 리터럴, 컬럼값


        SELECT 10+20, 10-20, 20/3, 5*4
        FROM DUAL;
 
 <BR/>
 
 - 그렇다면 이산술연산을 다른데서도사용이가능할까?

  - 가능하다. 
  - 우리가 위에서 사용한 EMPLOYEE에 산술연산을 적용시켜보자

        SELECT EMP_NAME, SALARY+100, SALARY
        FROM EMPLOYEE;  
  
  
![산술연산](https://user-images.githubusercontent.com/126074577/229294970-c68320e3-5222-40d5-b337-d0c4219fef11.png)


- 이렇게 SALARY에 100이 추가된채로 정보를 출력한다.
- 그렇다면 리터럴 값이아닌 컬럼,컬럼 끼리도 연산이가능할까?

  - 가능하다.
  - 하지만 한가지 주의할점이있다.
  - **NULL값과 연산은 불가능하다** 
  - **결과가 무조건 NULL로 출력되기때문이다.**

        SELECT EMP_NAME, SALARY+BONUS
        FROM EMPLOYEE; 
        
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

        SELECT EMP_NAME AS 사원명, SALARY AS 월급, EMAIL AS 이메일
        FROM EMPLOYEE;
        
        -- AS 를 생략하고 띄어쓰기로 부여할 수 있다.
        SELECT EMP_NAME 사원명, SALARY 월급, EMAIL 이메일
        FROM EMPLOYEE;        

- 그렇다면 별칭에 띄어쓰기 특수기호가 가능할까?
- 가능 하다 
- **별칭명 앞뒤에 ( " " ) 를 사용해주면된다.

     
        SELECT EMP_NAME AS "사 원 명", SALARY AS "$월$급"
        FROM EMPLOYEE;
 
 
 ## 문자 연결
 - 위에서 산술연산에는 문자를 연산할수없다고 했는데
 - 그렇다면 문자연결하는법은 뭘까?
 - **자바에선 (" ") 를사용했다면 SQL 은(' ')  을사용한다.**

        
        SELECT '점심'+'맛있다' 
        FROM DUAL;
        
## || 연산
- || 연산은 컬럼을 합칠때 사용하거나 문자를 합칠때 사용한다.

        SELECT '점심'||'맛없다 FEAT 반장'
        FROM DUAL
        
        SELECT EMP_NAME||'님의 월급은 '||SALARY||' 보너스'||BONUS
        FROM EMPLOYEE;
  
  
  # 3. WHERE
  
  - 지정한 조건에 맞는 데이터만 가져올수가있다.
  - <CODE>WHERE</CODE> 조건식을 이용한다.
  - 사용방법

  - SELECT 컬럼, 컬럼...... OR *
  - FROM 테이블명
  - WHERE 조건식

        
        -- 사원 중 월급이 200만원이상인 사원을 조회하기
        SELECT * 
        FROM EMPLOYEE
        WHERE SALARY>=2000000;  
        
- 마치 JAVA에서의 IF문을 보는것같은느낌이다.


<BR/>

## 여러개 비교연산 처리

- 여기서도 <CODE>AND</CODE>,<CODE>OR</CODE> 를 사용한다.



         -- 사원 중 부서가 D5이고 월급이 300만원 이상인 사원의 이름, 부서코드, 월급 조회하기
         
        SELECT EMP_NAME, DEPT_CODE, SALARY
        FROM EMPLOYEE
        WHERE DEPT_CODE='D5' AND SALARY>=3000000;      
        
        <BR/>
        
        -- 사원 중 부서가 D5이거나 월급이 300만원 이상인 사원의 이름, 부서코드, 월급 조회하기
        
        SELECT EMP_NAME, DEPT_CODE, SALARY
        FROM EMPLOYEE
        WHERE DEPT_CODE='D5' OR SALARY>=3000000;
        

- 한가지 알아야 할점이 있다.
- **조건식에 말이안되는 걸 적어도 오라클은 오류를 내지않는다**
- **아무것도 출력이 안될뿐이다.**

<BR/>


## 날짜 대소비교

- **날짜를 대소비교할때는 문자로비교, 문자열 패턴을 맞춰준다.**
- **기본적이 날짜를 표시하는 문자열 패턴 : YY/MM/DD -> 'YY/MM/DD'**

        
        -- 입사일이 2000년 01월 01일 이전이 사원의 이름, 입사일을 조회하기
        SELECT EMP_NAME, HIRE_DATE
        FROM EMPLOYEE
        WHERE HIRE_DATE<'00/01/01';
        
        
- 이렇게 범위값을 조회할수있지만
- 더간단해서 명령어를 통해서 조회하는방법도있다.

## BETWEEN AND
- 범위의 값을 조회할때 BETWEEN AND 연산을 이용하기
- 사용방법
  - 컬럼명 BETWEEN 값 AND 값 ;

        -- 연봉 2000000 과 3000000 사이 조회
        SELECT EMP_NAME, SALARY, BONUS, HIRE_DATE
        FROM EMPLOYEE
        WHERE SALARY BETWEEN 2000000 AND 3000000;
        
        -- 입사일이 00년01월01부터 02년 12월 31일까지 사이 조회 그리고 D9인사람만
        SELECT *
        FROM EMPLOYEE
        WHERE HIRE_DATE BETWEEN '00/01/01' AND '02/12/31' AND DEPT_CODE ='D9';


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
        
        SELECT EMP_NAME, SALARY, DEPT_CODE
        FROM EMPLOYEE
        WHERE EMP_NAME LIKE '유__';

        -- 이메일 주소에 yo를 포함하고 있는 사원의 사원명, 이메일 조회하기
        
        SELECT EMP_NAME, EMAIL 
        FROM EMPLOYEE
        WHERE EMAIL LIKE '%yo%';
        

## NOT

- 명령어 앞에 NOT을 사용한다면
- **일치하지 않는 것들을 찾을수가있다.**
- **JAVA에서 사용했던 ( ! ) 랑같다.**

        SELECT *
        FROM EMPLOYEE
        WHERE EMP_NAME NOT LIKE '김%';
        
        
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
 
 
# 6. IN , NOT IN
  
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
        
# 8. 함수

## 단일행 함수
- 사용하는 위치

  - SELECT문의 컬럼을 작성하는부분
  - WHERE절
  - INSERT
  - UPDATE
  - DELETE

<BR/>


# 9. LENGTH
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

# 10. LENGTHB
- 차지하는 BYTE를 출력해준다.
- **EXPRESS버전에서 한글은 3BYTE로 저장된다. ENTERPRISE버전에서는 2BYTE로저장된다.**

        SELECT LENGTHB('ABCD'), LENGTHB('월요일')
        FROM EMPLOYEE;      
        //'ABCD/'월요일'
        //4     / 9

<BR/>

# 11. INSTR
- JAVA의 INDEXOF 와 유사한 기능을가지고있다.
- **지정한 위치부터 지정한 숫자 번째로 나타나는 문자의 시작 위치 반환**
- 사용방법

  -  **INSTR('문자열'||컬럼,'찾을 문자'[,시작위치, 찾을번째(횟수)]**
  -  오라클에서는  인덱스 번호는 1부터시작한다.
  -  없는 값을 찾을때는 0을 출력한다.



        
