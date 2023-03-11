# 🔖 목차

1. [while](#1-while) <br/>
2. [do while문](#2-do-while문) <br/>
3. [분기문](#3-분기문) <br/>

<br/>

> 반복문의 두가지중 하나인 while에대해 자세히 알아보려고한다.
> 
> 반복문의 대해 아직 재대로알지 못하는거 같기에 
> 
> 정리하면서 다시한번 이해하겠다.

<br/>


# 1. while? 

- while는 반복문을 구현하는 방법중 하나이다.
- 특정조건에서 반복문을 실행할때 많이 사용한다.
- 의도적으로 무한루프를 실행하고싶을때 사용하기도한다.

  - 먼저 1부터 10까지를 출력하고싶다면 어떻게 할까?
 

```java
int i = 0;
		while (i <= 10) {
			System.out.println(i);
			i++;
  }
```
<br/>
 
- **while문을 사용해서 이런식으로 1부터 10까지 표현할수가있다.**

  - 하지만 1부터 10까지 출력하는거면 for문으로도 해도되지않나? 라고생각할수있지만
  - 1부터 10까지만 출력할거면 for문을 사용해두된다. 하지만 위에서말햇듯이 while문은 무한반복이가능하다
  - while문은 조건식즉 괄호안이  true일때 문장을 수행한다. 그리고 조건식이false가된다면 그대로반복문을종료한다.
  - 위에 조건식을 다시본다면 한번돌때마다 i가 ++ 가되서 i의 수가 점점증가하고 i 가 11이된다면 조건식이 false으로 변하여 반복문이 종료된다.

- 그렇다면 조건식이 절때로 false가 될수없도록 조건식을 설정한다면 어떻게될까?

```java 
while (true) {
			System.out.println("무한");
```

- **이런식으로 무한을  무한반복하게된다 조건식이 flase가 될수 없기때문이다.**

  - 이런식으로 무한반복이나 특정조건에 도달하게된다면 종료 하게만들고싶을때 사용하는것이 <code>while</code>이다.



<br/>

- **그렇다면 while로 무엇을 만들수가 있을까?**

  - 간단하게 계산기를 만들수도있다 
  - 우리가 사용하는 계산기도 우리가필요한 연산을한후 바로종료가되지않고 무한반복하지않는가?
  - 예시를 한번보겟다.

```java

boolean falg = true;
		Scanner sc = new Scanner(System.in);
		while (falg) {
			System.out.println("==== my 계산기 ====");
			System.out.print("정수입력 : ");
			int su = sc.nextInt();
			System.out.print("정수입력 : ");
			int su2 = sc.nextInt();
			System.out.print("연산자(+,-,*,/) : ");
			char op = sc.next().charAt(0);
			switch (op) {
			case '+':
				System.out.println("" + su + op + su2 + "=" + (su + su2));

				break;
			case '-':
				System.out.println("" + su + op + su2 + "=" + (su - su2));

				break;
			case '*':
				System.out.println("" + su + op + su2 + "=" + (su * su2));

				break;
			case '/':
				System.out.println("" + su + op + su2 + "=" + ((double) su / su2));

				break;
			}
			boolean fa = true;
			while (fa) {
				System.out.print("종료하시겠습니까?(Y/N)");
				char exit = sc.next().charAt(0);
				if (exit == 'Y') {
					System.out.println("프로그램을 종료합니다.");
					falg = false;
					fa = false;

				} else if (exit == 'N') {
					falg = true;
					fa = false;
				} else {
					System.out.println("잘못입력하셨습니다.");
					falg = false;
					fa = true;
				}
			}

		}
```

- **이런식으로 간단 계산기 기능도 만들어낼수가있다.**

# 3. do while문

- **while 문이랑 비슷하지만 차이점이있다**

	- do while 은 조건문이 true가아니더라도 무조건한번 수행한다는 특징이있다.
	- 예를들어본단면

```java
int i =1;
do {
	Sys.out.println(i + "출력");
	i++
} while(i <= 10);
```

- 이런식으로 do아래있는 문장이 무조건수행이되고
- while문의 조건식을 본후 다시시작할지안할지 판단하게되는것이다.
- 즉 while 안에 조건식에는 조건을 벗어나게할 연산(증감식,분기문)이필요하다.


<br/>
  

# 2. 분기문

- 분기문이란걸 두가지가있는데 하나는<code>continue</code>,<code>break</code> 가 있다.
- 특정 조건에서 반복문의 실행을 통제하기 위해 사용

<br/>


## continue
- 반복문에서 사용가능한데 실행시 continue아래부분은 실행하지않고 반복문을 다시실행한다.

	- for문의 경우 증감식으로이동
	- while(do~while)인경우 조건식으로 이동한다.

- 전체 반복 중 특정 조건을 만족하는 경우를 제외하고자 할때 유용하다.

	- 예를들어보자.

```java
for(int i = 1; i <= 10; i++) {
	if(i % 2 == 0) {
	continue;
	}
	System.out.println(i + " 출력");
}
```
- 이렇게 만든다면 홀수만 출력이될수가 있다.
- 하지만 잘쓰이지않으니 알고만있자

<br/>

## break
- **반복문에서 break문은 자신이 포함된 가장 가까운 반복문을 빠져나가는 구문이다.**

	- 예를들어보자


```java
Scanner sc = new Scanner(System.in);
	System.out.print("입력 : ");
	String target = sc.nextLine();
	boolean flag = false;
		for (int i = 0; i < target.length(); i++) {
			char c = target.charAt(i);
			System.out.println(c);
			if ('A' <= c && c <= 'Z') {
				flag = true;
				break;
		}
	}
	System.out.println(flag ? "있다" : "없다");
}
```

- 이런식으로 만든다면 하나의 영어단어중에 대문자가있는지알수있고
- break를 사용해서 그대문자가 나오면 중지해서 나머지뒤에 영문이 안나오게만들수가 있다.



 
 







		
    



  
  
  
 



  
  
  
  
  
  
  
  
  
  
  
  
  
