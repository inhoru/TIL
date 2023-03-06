# 🔖 목차
1. [switch문](#1-switch문)<br/>
2. [case](#2-case)<br/>
3. [break](#3-break)<br/>



<br/>

> if문에 대해 어느정도 알게되었다.
> 
> 하지만 아직 switch문에대해서는 자세히알지못한다.
> 
> 그래서 switch문을 정확하게 사용하고 이해하며
> 
> 어떤 경우에 사용하는지 어떻게 동작하는지 알아보자

<br/>




# 1. switch문
- 먼저 구조부터알아보자

```java
switch(값) {
    case 값1:
	      구현부;
	      break;
    case 값2:
	      구현부;
        break;
    default:
	      구현부;
	    break;
}
```

- if 문과의 차이점이라고 한다면
	- if문은 if, else if, else가 크게는 전부 한세트지만
	- 각각의 조건식과 구현부를 모두 지니고 있으면서 각각의 영역을 가지고 있다.
- 조건식에는 int, String, char 자료형만 가능하다.
	- 하지만 switch문은 switch라는 큰영역안에 각각의
	- case, default라는 작은영역을 지니고 있는것이다.


## switch문의 에시
```java
		System.out.println("=== 점심메뉴 ====");
		System.out.println("1. 윤쉐프");
		System.out.println("2. 중국집");
		System.out.println("3. 삼계탕");
		System.out.println("4. 육개장");
		System.out.print("선택 : ");
		int choice=sc.nextInt();
		switch(choice) {
			case 1 :
					String name="김아무";
					System.out.println(name+"구내식당 중 가장 맛있대요!");
					break;
			case 2 : System.out.println("B건물 중국집이 먹을만해요!");break;
			case 3 : System.out.println("C건물 삼계탕이 먹을만해요!");break;
			case 4 : System.out.println("A육개장이 먹을만 해요!");break;
			default : System.out.println("메뉴는 1~4번까지만 있습니다.");break;
		}
}
```

- switch 문의 가장 대표적인 예시라고 볼수있겟다.
- 1번 부터 4번까지 보기가 있는데 그중에서 번호 하나를 선택했을때
- 결과를 출력해주는 코드다.
- if문과 다르게 조건식이 사용되징않는다는 것을 알 수 있다.
- 정해진 값을 이용해서 해당하는 case를 찾아가 실행하는데 
- 여기서 중요한건 정해진값이다. 조건식이라는것이 들어갈수가없게 된다.

<br/>

# 2. case

- switch 의 하나의특징이라면 **case와break**의 존재를 뽑을수있다.

  - 예시를 들어보자

```java
int answer = 1;
switch(answer) {
case 1:
	System.out.println("1번을 선택했습니다.");
	break;
case 2:
	System.out.println("2번을 선택했습니다.");
	break;
case 3:
	System.out.println("3번을 선택했습니다.");
	break;
default:
	System.out.println("1 ~ 3번 중에 선택하세요.");
	break;
}
```
- case 뒤에 정수가 따라오는데 이숫자가 목적지이다.
- 목적지를 1이나 2 그리고 3을 선택하는냐에따라 목적지가달라진다.
- 그래서 case 뒤에 정수를 붙인것이다.
- 1,2,3 외에값은 필요가없기에 default로 예외처리 해버린거다.
- 여기서 중요한건 case에 뒤에따라오는값이 switch에서 받는 값의 타입과 동일해야 한다는점이다.

<br/>

# 3. break
- 말 뜻 그대로 멈추다 라는 의미를 지니고있다.
- 뭘 멈춘다는것일까?

  - 예시

```java
nt answer = 1;
switch(answer) {
case 1:
	System.out.println("1번을 선택했습니다.");
case 2:
	System.out.println("2번을 선택했습니다.");
case 3:
	System.out.println("3번을 선택했습니다.");
default:
	System.out.println("1 ~ 3번 중에 선택하세요.");
}
```

- 앞에 예시에서 break;를 전부 지웠다.
- 이렇게하고 프로그램을 실행한다면
- 1번을선택합니다 부터 1~3번 중에 선택하세요 까지 전부 출력된다.
- **break;** 가없으니 전부 실행된거다.
- 이로써 알게된것은 break;를 사용해 우리가 원하는 결과만 출력하고 
- 그 다음에 switch문을 종료 시키는 것이다.

<br/>

## 마무리
- switch문은 정해진 값으로 조건을 판단하기 때문에
- 넓은 범위의 조건보다는 선택지와 같이 한정된 좁은 범위에서 사용하는게 유용하다!



