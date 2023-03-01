# 🔖 목차

1.
2.
3.

<br/>

# 문자열
  - 컴퓨터에서 "기차","출력하세요"등과 같이 단어나 문장을 문자열이라고 표현한다.
  - ""로 묶여 잇으면 문자열로 인식하며  <code><strong>Java에서는 String</code></strong> 객체를 이용하여 저장한다.

<br/>

# 1. 문자열 자료형 이용하기

```java

public class StringTest {
	public static void main(String[] args) {
	
		String name = "김아무";    
		//String은 클래스다. ->원래..new연산자를 이용해서 생성해서 써야 하지만
		//java에서 기본자료형처럼 사용하수있게 해준다.
    
		//name = new String("김재훈");  원래는 이런식으로 써야한다.
		System.out.println(name);
      }
  }
  //출력결과
  //김아무
  ```
 
 **문자열 연산 결합
 ```
  
  
