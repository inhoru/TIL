# 🔖 목차
1. [Gettet와Setter 메소드](#1-Gettet와Setter-메소드)<br/>




<br/>


# 1. Gettet와Setter 메소드

- 객체 지향 프로그래밍에서 객체의 데이터는 객체 외부에서 직접적으로 접근하는걸 막는다.
- 객체 데이터를 외부에서 일고 변경 시 객체의 무결성이 깨질 수 있기 때문이다.
- 따라서 객체 지향 프로그래밍에서는 **메소드를 통해 데이터를 변경**하는 방법을 사용한다


## Setter

- 데이터는 외부에서 접근하지 않도록 막고, 메소드든 공개해서
- 외부에서 메소드를 통해 데이터에 접근하도록 유도한다
- 이런 역할을 Setter 맡는다.
- 필드명을 작성할땐 camelcase를준수 해야한다.

```java
public class Employee {
	//필드선언
	private String name;

public void setName(String name) {
		this.name = name;
	}
```

- 대입할 데이터가 필요하기에 매개변수로 필드에 대입할값을 받는다.
- 이런식으로 private를 이용한 필드의값을
- Setter 메소드를 통해 값을 수정할수가 있다.


<br/>



## Getter
- 데이터를 수정했으면 이제 외부로 출력할수도있어야하겟지?
- 그럴때 getter을 사용한다.

```java

public String getName() {
		return this.name;
	}
```

- 이런식으로 필드에 기록된 값을 읽어서
- 요청한쪽으로 읽은 값을 넘기는 메소드이다.
