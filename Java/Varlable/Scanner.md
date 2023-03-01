# 🔖 목차

1.[Scanner](#1-Scanner의-특징) <br/>


<br/>

# Scanner란?

- 사용자로부터 입력되는 정수, 실수, 문자열을 처리하는 클래스

<br/>

# 1. Scanner의 특징
- 기본적인 데이터 타입들을 Scanner의 메소드를 사용하여 입력받을 수 있다.
- Scanner 을 사용할 시 util 패키지를 경로의 Scanner클래스를 호출해야한다.
- 띄어쓰기 또는 개행(줄바꿈)을 기준으로 읽는다.

<br/>

**Scanner 사용해보기**

1. <code><strong>import</code></strong> 작성

```java
package com.bs.varlable;

import java.util.Scanner;     // java.utll.Scanner 작성해줘야한다.

public class ScannerTest 
```
2. <code><strong>Scanner</code><Strong> 생성

```java
package com.bs.varlable;

import java.util.Scanner;

public class ScannerTest 

Scanner sc = new Scanner(System.in);
```
3. <code><strong>Scanner</code></strong> 가 제공하는 기능을 이용해서 데이터 받기

  - 자료형에 따라 기능제공
  - 정수형 : nextInt()
  - 실수형 : nextDounle()
  - 문자열 : next() or nextLint()

```java
    System.out.print("나이 : ");         //어떤정보로 입력해야하는지 출력해야한다
		int age = sc.nextInt();              //변수를 선언해서 저장시킨다.그래야 내려가서도 써진다.
		System.out.println(age);
		
		System.out.print("당신의 이름은 : ");
		String name = sc.next();             //next는 띄어쓰기 앞에잇는 글자까지만 출력한다.
		System.out.println("입력한 이름 : " + name);
		
		sc.nextLine(); //버퍼를 비워주는역할
		System.out.print("당신의 주소는 : ");
		String address = sc.nextLine();      //Line은 입력한 문자여을 개행을 기준으로 값으 가져옴.(엔터)=개행 
		System.out.println(address);         //버퍼를비워줘야한다 넥스트라인과 넥스트사이에써준다.
		
		System.out.print("키 : ");
		double height = sc.nextDouble();//실수형 입력
		System.out.println("입력키 : " + height);
```

	
4. <code><strong>char</code></strong> 타입
 
```java
    //성적등급, 성별
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		System.out.println("입력한 성별 : " + gender);
````
    




 
  
