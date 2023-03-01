# 🔖 목차

1.
2.
3.

< br/>

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

	- %d : 정수형




  

