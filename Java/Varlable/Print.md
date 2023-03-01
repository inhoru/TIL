# 🔖 목차

1.
2.
3.

<br/>

# 1. 출력 메소드

**System.out.print()**
- ()안의 변수,문자,숫자,논리 값을 모니터에 출력해주는 메소드

  - ex) System.out.print("안녕하세요");
  - ex) System.out.print(123);
  - ex) System.out.print(변수명);

```java
public class PrintTest {

	public static void main(String[] args) {
		// console창에 데이타 출력하기
		// 개행없이 같은 라인에 출력하기
		System.out.print(" 안녕");
		System.out.print(" 점심은 맛있게 먹었나요");
		System.out.print(" 점심 먹고 졸면안돼요!!!");
  }
}
//출력결과
// 안녕 점심은 맛있게 먹었나요 점심 먹고 졸면안돼요!!!
```

**System.out.println()**
- print문과 동일하게 출력은 해주지만 출력 후 자동으로 출력창에 <code><strong>줄바꿈</code></strong>해주는 메소드

  - ex) System.out.println("안녕하세요");
  - ex) System.out.println(123);
  - ex) System.out.println(변수명);

```java
public class PrintTest {

	public static void main(String[] args) {
		// 개항하여 출력한다.
		System.out.println("안녕"); 
		System.out.println("점심은 맛잇게 먹엇나요");
		System.out.println("점심 먹고 졸면안돼요!!!");
  }
}
//출력결과
//안녕
//점심은 맛잇게 먹엇나요
//점심 먹고 졸며안돼요!!
```
**System.out.printf()**
- 정해져 있는 형식에 맞춰서 그형식에 맞는 값(변수)을 줄바꿈하지 않고 출력
- 지시자를 통해 변수의 값을 여러 가지 형식으로 변환 가능

	- %d : 정수형, %o : 8진수, %x :16진수
	- %c : 문자, %s : 문자열
	- %f : 실수(소수점 아래 6자리), %e : 지수형태표현, %g : 대입 값 그대로
	- %A : 16진수 실수
	- %b : 논리형

- 정렬 방법

	- %5d : 5칸을 확보하고 오른쪽으로 정렬
	- %-5d : 5칸을 확보하고 왼쪽으로 정렬
	- %.2f : 소수점 아래 2자리까지만 표시

```java
public class PrintTest {

	public static void main(String[] args) {
		System.out.printf("나의 이름은 %s이고, 나이는 %d이다", name, age);
		// 문자패턴
		// %s : 문자열
		// %d : 숫자
		// %f : 실수
		// %c : 문자
		System.out.println();
		System.out.printf("이름 %5s 나이 %-3d 키%.1f 성별%2c", "김아무", 19, 180.5, '남');
		// %.1f소수점 한자리까지만 출력해라 라는뜻 .2->두자리까지표시해라
		// -는 왼쪽정렬
  }
}
//출력결과
//나의 이름은 김아무이고, 나이는 19이다
//이름   김아무 나이 19  키180.5 성별 남
```
<br/>

# 2. escape 문자
- 문자열을 표시할때 escape문을 이용하면 문자열안에서만 
- 개행처리, tap(일정간격 띄어쓰기), 역슬래시, "", ', 표시가능

![escape문](https://user-images.githubusercontent.com/126074577/222139608-b1b6e604-fcc5-45a1-8fea-20dc6232a6cb.jpg)








  

