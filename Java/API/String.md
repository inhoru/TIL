# 🔖 목차

1.
2.
3.

<br/>

> 자바에서 문자열에 대한 클래스는 3가지가 있다.
> 
> String, StringBuffer, StringBuilder
> 
> String : 클래스지만 기본 자료형처럼 사용하게 설정되어 있다.
> 
> StringBuffer, StringBuilder : 클래스 사용방식으로 문자열을 다룰수있다.
> 
> String은 불변의 문자열 -> 수정이 불가능하다.
> 
> StringBuffer, StringBuilder : 가변의 문자열 -> 수정이 가능하다.
> 

<br/>

# 1. String
## 우리가 많이쓰는것들만 추려서 몇가지를 소개하겟다.

<br/>

- String.concat("문자열값") : 두개의 문자열을 합쳐주는 메소드

```java
String test = "abcd ";
	test = test.concat("아자아자 화이팅!"); // +=연산과 동의하다.
	System.out.println(test);
  //출력결과
  //abcd아자아자화이팅
  ```
  
  -  boolean String contains("문자열")

  - 문자열에 매개변수로 전달된 문자열이 포함되어있는지 확인해주는 기능

```java
if (test.contains("64")) {
			System.out.println("응 64포함됨");
		}
		;
```

- 
