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
- 생성된 V_EMP를 출력해보면

```SQL
SELECT * FROM V_EMP;
-----------------------------------------------------

200	선동일	621235-1985634	sun_di@BS.or.kr	01099546325	D9	J1	S1	8000000	0.3		90/02/06		N
201	송종기	631156-1548654	song_jk@BS.or.kr	01045686656	D9	J2	S1	6000000		200	01/09/01		N
202	노옹철	861015-1356452	no_hc@BS.or.kr	01066656263	D9	J2	S4	3700000		201	01/01/01		N
203	송은희	631010-2653546	song_eh@BS.or.kr	01077607879	D6	J4	S5	2800000		204	96/05/03		N
204	유재식	660508-1342154	yoo_js@BS.or.kr	01099999129	D6	J3	S4	3400000	0.2	200	00/12/29		N
205	정중하	770102-1357951	jung_jh@BS.or.kr	01036654875	D6	J3	S4	3900000		204	99/09/09		N
206	박나라	630709-2054321	pack_nr@BS.or.kr	01096935222	D5	J7	S6	1800000		207	08/04/02		N

```

- 이렇게 VIEW를 사용할수가있다.

<BR/>



 



  
  







