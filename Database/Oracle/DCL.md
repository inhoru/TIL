# 🔖 목차

1. [GRANT](#1-GRANT)<BR/>
2. [ROLE](#2-ROLE)<BR/>

<br/>

## DCL
- 사용자의 권한을 관리하는 명령어
- SYSTEM계정이 수행을한다 (관리자)
- 관리자계정이있어야한다!
- 권한

  - CREATE VIEW, CREATE TABLE, INSERT, SELECT ,UPDATE 등등

- 역할(ROLE)

  - 권한의 묶음 
## 각 역할(ROLE)에 부여된 권한 확인하기
- 관리자 게정으로 볼수가있다.
```SQL 
RESOURCE권한 확인
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE='RESOURCE';
--------------------------------------------------
RESOURCE	CREATE TABLE	NO	YES	NO
RESOURCE	CREATE TYPE	NO	YES	NO
RESOURCE	CREATE OPERATOR	NO	YES	NO
RESOURCE	CREATE INDEXTYPE	NO	YES	NO
RESOURCE	CREATE CLUSTER	NO	YES	NO
RESOURCE	CREATE PROCEDURE	NO	YES	NO
RESOURCE	CREATE SEQUENCE	NO	YES	NO
RESOURCE	CREATE TRIGGER	NO	YES	NO
----------------------------------------------------

CONNECT권한 확인
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE='CONNECT';
---------------------------------------------------
CONNECT	CREATE SESSION	NO	YES	NO
CONNECT	SET CONTAINER	NO	YES	NO
```
<BR/>


# 1. GRANT
- 권한을부여하는명령이다.

```SQL
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

CREATE USER QWER IDENTIFIED BY QWER DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

GRANT CONNECT TO QWER;
```
- QWER계정의 접속할수있는 권한을 부여했다.
- 이계정은 접속만가능하고 아무것도 할권한이없다.
- 그래서 각각의 권한을 부여해줘야한다.

<BR/>

## 권한부여

- **SELECT 권한부여**


```SQL
GRANT SELECT ON BS.EMPLOYEE TO QWER;
```
- QWER 계정의 서 BS.EMPLOYEE 를 SELECT할수있는권한을 허락받은거다.
- SELECT 만가능하다. 다른건 불가능
- 왜?  권한을 주지않앗기때문이다.

<BR/>

- **UPDATE도 가능하다.**

```SQL
GRANT UPDATE ON BS.EMPLOYEE TO QWER;
```
- QWER계정의 BS.EMPLOYEE를 UPDATE를 할권한을 허락받앗다.
- SELECT랑 UNDATE 를 사용할수있게 된거다.

## 권한 회수
- 부여된 권한을 회수할수도있다.
- REVOKE 권한 | | ROLE FROM 사용자계정명

<BR/>

- **SELECT할 권한을 회수**

```SQL
REVOKE SELECT ON BS.EMPLOYEE FROM QWER;
```

<BR/>


- **UPDATE할 권한을 회수**

```SQL
REVOKE UPDATE ON BS.EMPLOYEE FROM QWER;
```

<BR/>

# 2. ROLE
- ROLE를 만들수도있다.

```SQL
CREATE ROLE MYROLE; <- ROLE을 만든거다.

GRANT CREATE TABLE, CREATE VIEW TO MYROLE; <-MYROLE에 CREATE TABLE,CREATE VIEW를부여한다.

GRANT MYROLE TO QWER; -< QWER에는 CREATE TABLE,CREATE VIEW 를 받은거다.

```

<BR/>
 




















