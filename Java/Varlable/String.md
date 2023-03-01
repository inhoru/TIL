# 🔖 목차

1.[문자열 자료형 이용하기]{1#-문자열-자료형-이용하기) </br>
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
 
 **문자열 연산 결합**
 ```java
 public class StringTest {
	public static void main(String[] args) {
	
		//문자열 타입의 값에 + 연산하면 대상되는 값을 결합해줌
		String msg = "김아무" + "java 선생님";
		System.out.println(msg);
		//다른타입과 문자열타입에 + 연산을 하면?? -> 결합연산!
		msg = 19 + "살 유병승";
		System.out.println(msg);
		
		int age = 19;
		String name =  "김아무";
		msg = name+age;    //"김아무" + 19
		System.out.println(msg);
		msg = 20 + age +name;    //연산은왼쪽부터 오른쪽으로한다 그러므로 20int age int 인트들이더해지고 문자열이더해진다.
		System.out.println(msg);
		msg = 20 + (age +name);    //괄호 안부터 우선처리한다 
		System.out.println(msg);
      }
  }
 //출력결과
 //김아무java 선생님
 //19살 김아무
 //김아무 19
 //39김아무
 //2019김아무
 ```
 ```java
 public class StringTest {
	public static void main(String[] args) {
	
		String myName = "김아무"; // 이름
		String address = "장충동 53-1"; // 주소
		String phone = "010-1234-5678";// 번호
		char gender = 'M';// 성별
		int myAge = 19;// 나이
		double height = 190;// 키

		System.out.println("나의 이름은 " + myName + "이고 나이는 " + myAge + "살이고 " + "키는 " + height + "이고 "
		+ "주소는 " + address+ "이고 " + "성별은 " + gender + "이고 " + "전화번호는 " + phone + "이다.");
		}
}
//출력결과
//나의 이름은 김아무이고 나이는 19살이고 키는 190.0이고 주소는 장충동 53-1이고 성별은 M이고 전화번호는 010-1234-5678이다.
```
</br>

# 2. String  유용한 기능

- **length()**
- **charAT()**

</br>

# length()
	- String변수에 저장된 <code><strong>문자열의 길이</code></strong>를 알려주는 기능(메소드)
	
	
	- "문자열".length()
	
	

  
  
