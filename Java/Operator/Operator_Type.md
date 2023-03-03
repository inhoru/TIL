# 🔖 목차

1.
2.
3.
4.
<br/>

# 연산자란?

  - 연산자는 주어진 변수나 리터럴에 대해 연산을 수행하기 위한 것이다.
  - 연산자에 의해 처리되는 대상을 피연산자 라고 한다.
  - 연산자는 **대입 연산자, 산술 연산자 ,비교연산자 ,논리연산자** 등으로 분류할 수있다.

<br/>

# 1. 대입 연산자

  - 대입 연산자는 변수와 같은 저장공간에 값 또는 수식의 연산결과를 저장한다.
  - 이연산자는 오른쪽 피연산자의 값을 왼쪽 피연산자에 저장한다.
  - 그리고 저장된값을 연산결과로 반환한다.

```java
int a =1; //변수 a에 1이 대입된다.

int b =1 + 2; //변수 a에 1+2를 하여 3이 대입된다.
```

 > 프로그래밍에서는 "같다"가 아니라 **"값을넣는다"** 라고 생각해야 정확하다.
 > 
 > 대입 연산자는 =(대입 연산자)의 오른쪽에 있는 값(리터럴)을
 > 
 > (대입 연산자)의 왼쪽에 있는 공간(변수)에 넣는 것으로의미한다.

<br/>

## 복합대입 연산자

  - 대입 연산자는 = 혼자만으로도 사용할수 있고 다른 연산자 기호뒤에 =를붙여서 += 이런형태로도 사용이 가능하다.
  - 이렇게 연산자 2개를 붙여놓은 것을 우리는 복합대입 연산자라고 부른다.
  - 대입 연산자에 다른연산자를 섞었기 때문에 복합이라는 말이 붙게 되는 것이다.
  - 형태는 =기호 앞에 다른 연산자를 붙여서 쓴다.

 ![복합대입 연산자](https://user-images.githubusercontent.com/126074577/222756816-2bf390a7-dbd3-4b5a-8bc5-cb9219281dfc.png)
 
 <br/>
 
 
## 용돈 기입장을 만들어보자.

```java
int total = 3000000;
total-=1000;
System.out.println(total);
total+=10000;
System.out.println(total);
//출력결과
//299000
//309000
```
<br/>

- 복합 대입 연산자는 우리가 값을 연산해서 누적시켜야할 때 사용하는 연산자다.

<br/>

# 2. 산술연산자

  - 우리가 가장 잘 알고 쓰는 연산자들이다.
  - 사칙연산에 쓰이는 +, -, *, / 이다.
  - 그리고 <code><strong>%</code></strong> 가 등장하는데 바로 **나머지를 구하는** 연산자다.

  - 간단한 예시를 들자면
  > 5%3 으로 연산하면 2가출력이 될것이다.
  > 
  > 5 나누기 3은 몫은 1이고 나머지는 2이기 때문이다.
  > 
  > % 연산으로 입력받은 값이 짝수인지 홀수인지 판단하는기능
  > 
  > 특정수의 배수가 맞는지 판단하는 기능등 가능하다.

<br/>

  ## 산술연산자를 활용해보자.

```java
int su=2;
int su2=10;
//더하기, 빼기
System.out.println("+연산 :" +(su+su2));
System.out.println("-연산 :" +(su-su2));
//곱하기, 나누기
System.out.println("*연산 :" +su*su2);
System.out.println("/연산 :" +su/(double)su2);
//출력결과
// +연산 :12
// -연산 :-8
// *연산 :20
// /연산 : 0.2
```

**스캐너를 이용한 계산기 만들기**
```java
Scanner sc = new Scanner(System.in);
		System.out.print("num : ");
		int suu1 = sc.nextInt();
		System.out.println("입력받은수 :" +  suu1);
		
		System.out.print("num : ");
		int suu2 = sc.nextInt();
		System.out.println("입력받은수 :" + suu2);
		
		System.out.println("더한값 :" + (suu1+suu2));
		System.out.println("뺀값 :" + (suu1-suu2));
		System.out.println("곱한값 :" + suu1*suu2);
		System.out.println("나눈값 :" + suu1/(double)suu2);//소수점 자리를 나타내기위해 둘중하나를 더블로 강제타입변환
		//출력결과
		//입력받은수 : 15
		//입력받은수 : 12
		//더한값 : 27
		//뺀값 : 3
		//곱한값 : 180
		//나눈값 :1.25
```

<br/>
		

# 3. 비교연산자

- 비교 연산자는 두 피연산자를 비교하는 데 사용되는 연산자다.
- 주로 조건문과 반복문의 조건식의 사용된다.
- 연산결과는 오직 <code><strong>true</code></strong>와<code><strong>false</code></strong> 둘 중의 하나이다.

<br/>

**동등비교**
```java
int num=13;
int num2=19;
int num3=13;
System.out.println(num==num2);
System.out.println(num==num3);
//불일치 여부 확인 연산자
//!=연산자 활용
System.out.println(num!=num2);//num2 는num하고 다르지? 물어보는것
System.out.println(num!=num3);//num3 는num하고 다르지? 물어보는것

//출력결과
//false
//true
//true
//false
```
<br/>

**실수형 비교**
```java
double dnum = 180.5;
double dnum1 = 190.5;
double dnum2 = 180.5;
int num=13;

System.out.println(dnum==dnum1);
System.out.println(dnum==dnum2);
System.out.println(dnum!=dnum1);
dnum=13;//int값은 double값에자동형변환으로들어갈수있다.
System.out.println(dnum==num);//int 와 double여도 값만 같으면 동등비교가능
//출력결과
//false
//true
//true
//true
```
<br/>

**문자 동등비교**
```java
char ch ='A';
char ch1 ='a';
char ch2 = 'A';
System.out.println("A==a :" +(ch==ch1));
System.out.println("A==a :" +(ch==ch2));
System.out.println("A!=a :" +(ch!=ch1));
int chInt =65;
//System.out.println((int)ch);//이렇게 강제변환해도 되지만 자동형변환이되기때문에 굳이 할필요가없다.
System.out.println(ch==chInt);//자동형변환으로 char타입은 인트로변경 유니코드동일
//출력결과
//A==a :false
//A==a :true
//A!=a :true
//true
```
<br/>


**문자열 동등비교**


- String(클래스) 동등비교할때 == 연산을 사용할 수 없다!
- String이 제공하는 <code><strong>equals()</code></strong>기능을 이용해서 동등비교를 한다.

```java
String name="김아무";
String name2= "김아무2";
String name3= "김아무";
//새로만든String는 0x01에저장된다.
String name4= new String("김아무2");//0x02에 저장이 된다. 
System.out.println("name==name2 :" +(name==name2));
System.out.println("name==name3 :" + (name==name3));//같은 상자(0x01)에 있는것들 끼리 동등비교를 ==비교가능하다.
System.out.println("nam2==name4 :" + (name2==name4));//0x01과0x02이 저장된 상자가 다르기때문에 ==사용하더라고 다르다고나온다.
//그래서이런경우equals사용한다.
//출력결과
//name==name2 :false
//name==name3 :true
//nam2==name4 :false
```
<br/>

**스캐너를 이용한 문자열 동등비교**

```java	
//문자열의 동등비교는 equals를써야한다. 
Scanner sc=new Scanner(System.in);
System.out.print("이름 : ");
String inputName=sc.nextLine();
System.out.println(inputName=="김아무"); //이렇게 ==사용하면 false가나온다.
System.out.println(inputName.equals("김아무"));
System.out.println("김아무".equals(inputName));
//불일치비교
System.out.println(!"김아무".equals(inputName));
//출력결과
//이름 : 김아무
//false
//true
//true
//false
```

<br/>

**대소비교**
- 숫자값만 가능하다.
- **<, >, <=, >=**

```java
num = 200;
num2 = 300;
num3 = 200;
System.out.println(num<num2);
System.out.println(num>num3);
System.out.println(num>=num3);
//출력결과
//true
//false
//true
```
<br/>


**문자타입 대소비교**

- char타입은 가능하다
- String 문자열은 불가능하다.

```java
char ch4='Z';
char ch5='E';
System.out.println("Z>E :" + (ch4>ch5));
//대문자(65~90), 소문자(97~122)를 확인할 수있음.
System.out.println("A<Z : " + ('A'<'Z')); //아스키코드 비교
//출력결과
//Z>E :true
//A<Z : true
```
<br/>


# 4. 논리 연산자







  

  
 
 

