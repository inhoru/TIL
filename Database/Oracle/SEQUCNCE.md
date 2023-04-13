# 🔖 목차
1. [SEQUENCE생성하기](#1-SEQUENCE생성하기)<BR/>
2. [SEQUENCE 옵션값](#2-SEQUENCE-옵션값)<BR/>
3. [PK](#3-PK)<BR/>

<br/>


## SEQUENCE
- 순차적으로 정수 값을 자동으로 생성하는 객체로
- 자동 번호 발생기 역할을한다.
- 중복되지않는 숫자를 발급해주기 때문에 PK컬럼의 값으로 많이 사용한다.

<BR/>


# 1. SEQUENCE생성하기
- 기본으로 생성하면 번호가 1부터 1씩증가해서 발급해준다.

```sql
-- 1. SEQUENCE번호를 발급하려면 시퀀스명. NEXTVAL을 선언한다.
CREATE SEQUENCE SEQ_BASIC;

-- 실행할때마다 자동으로 1씩증가함
SELECT SEQ_BASIC.NEXTVAL FROM DUAL;
```
<BR/>

## 데이터를 입력해줄때 중복되지않는 숫자가 필요할때

```SQL
INSERT INTO BOARD VALUES(SEQ_BASIC.NEXTVAL,'첫번째게시글','첫번째','김아무',SYSDATE);

-------------------------------------------------------------------------------
24	첫번째게시글	첫번째   김아무 23/04/13
25	첫번째게시글	첫번째   김아무	23/04/13
26      첫번째게시글	첫번째   김아무	23/04/13
```

- 이제 여러번 등록해도 BOARD_NO는 중복되지않는다.

<BR/>

## 현재 SEQEUNCE 값을 확인하기

- 시퀀명.CURRVAL를 이용한다
```SQL
SELECT SEQ_BASIC.CURRVAL FROM DUAL;
```
<BR/>

# 2. SEQUENCE 옵션값
- START WITH 숫자 : 설정한 숫자부터 시작 DEFAULT 1 
- INCREMENT BY 숫자 :  증가하는 간격을 의미 DEFAULT 1 
- MAXVALUE 숫자 : 최대값을 설정
- MINVALUE 숫자 : 최소값을 설정
- CYCLE/NOCYCLE : 번호를 순환할지 말지 결정하는것 *MAXVALUE,MINVALUE가 설정되어있어야한다.
- CACHE : 미리번호를 생성하는 기능 DEFAULT 20

```SQL
-- 시작 숫자 100
CREATE SEQUENCE SEQ_01
START WITH 100;
SELECT SEQ_01.NEXTVAL FROM DUAL;

-- 시작 숫자 100 실행시마다 10증가
CREATE SEQUENCE SEQ_02
START WITH 100
INCREMENT BY 10;
SELECT SEQ_02.NEXTVAL FROM DUAL;

-- 시작 숫자 100 시작시마다 50씩 마이너스 0보다작아지면 끝
CREATE SEQUENCE SEQ_03
START WITH 100
INCREMENT BY -50
MAXVALUE 200
MINVALUE 0;

-- 시작 숫자 100 시작시마다 50증가 200넘으면 0으로돌아감
CREATE SEQUENCE SEQ_04
START WITH 100
INCREMENT BY 50
MAXVALUE 200
MINVALUE 0
CYCLE
NOCACHE;
```

<BR/>

## 주의사항
- CURRVAL를 호출하려면 같은 SESSION안에서 NEXTVAL을 한번이라도 호출하고 호출해야한다.

```SQL
CREATE SEQUENCE SEQ_05;
-- 무작정 CURRVAL을 실행하면안된다. NEXTVAL를 실행한후 호출해야함
SELECT SEQ_05.NEXTVAL,SEQ_05.CURRVAL FROM DUAL;
```

<BR/>

# 3. PK
-  SEQUENCE에 값을 추가해서 PK값으로 쓸 수 있다.

```SQL
-- P_001 , M_001
SELECT 'P_'||LPAD(SEQ_05.NEXTVAL,4,'0') FROM DUAL;

-- 20230413_4
SELECT TO_CHAR(SYSDATE,'YYYYMMDD')|| '_'||SEQ_05.NEXTVAL FROM DUAL;
```



