# 🔖  목차

1.
2.
3.

<br/>

# 형변환(Casting)이란?

- #### 값(Data)의 자료형을 바꾸는것 (boolean 제외)

  - 컴퓨터의 값 처리 원칙<br/>
    1. 같은 종류형만 대입 가능  
    2. 같은 종류 자료형만 계산가능
    3. 계산의 결과도 같은 종류의 값이 나와야 함
    4. 이러한 원칙이 지켜지지 않은 경우에 형변환이 필요함

<br/>

# 1. 자동 형변환

  > **컴파일러가 자동으로 값의 범위가 작은자료형을**
  > 
  > **값의 범위가 큰 자료형으로 변환한다.**

<br/>

```java
public class ConvertTest {
	public static void main(String[] args) {
	
		int num = 100;
		long lnum = num;   
		System.out.println(lnum); //long는 8바이트 int는 4바이트 자동으로형변환해서 들어간다.
		float fnum = lnum;  
		System.out.println(10 + fnum);//int타입 10을 자동형변환으로 10.0으로바꿔준다.
    }
}
//출력결과
//100
//11.0
//특정연산을 실행할때는 피연사자의 타입이 동일해야한다.
```
<br/>

# 2. 강제 형변환

  > **값의 범위가 큰 자료형을 값의 범위가 작은 자료형으로 변환한다.**
  > 
  > **강제 형변환 시 데이터 손실이 발생할 수 있다.**
  > 
  > **데이터의 변형, 손실을 감수하고 강제 변환한다.**
  > 

<br/>

  - 강제 형변환 데이터 손실

```java
public class ConvertTest {
	public static void main(String[] args) {
	
		int num2 = (int) 180.5;
		System.out.println(num2);  // int 는 소수점을 표현하지 못한다.
		
		int test = 290;
		byte bnum = (byte) test;   //byte는 127까지밖에 포현을하지 못한다. 
		System.out.println(bnum);
    }
}
//출력결과
//180
//34
```

<br/>

  - 계산에서 강제적 형변환

```java
public class ConvertTest {
	public static void main(String[] args) {
	//성적 ,평균값 계산
	  int kor = 90, eng = 54, math = 49;   //나누기연산을할때 하나를 double로바꾼다.
	  System.out.println((kor +  eng +  math) / (double) 3.0); //int끼리연산하면 정수 만나온다 그래서 하나를 double로바꿔 소수로바꾼다.
    }
}
//출력결과
//64.333333333333
```

<br/>

  - 단일문자(char) 형변환
  - char 내부적으로 코드표에 있는 숫자를 저장한다.

```java
public class ConvertTest {
	public static void main(String[] args) {
	
    char ch = 'A';      //A는 유니코드표에서 65다.
		int chint = ch;
		System.out.println(chint);
		chint = 66;   //내부적으로 B라는 코드값으로변경
		System.out.println((char)chint); //강제타입변환하여 char타입으로 출력한다.
		ch++; //(ch+1)  //ch에 1을더하라는뜻 즉 66=B 이된다.
		System.out.println(ch);
		
    }
}
//출력결과
//65
//B
//B
```
<br/>
  
  










