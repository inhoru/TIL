# 🔖 목차 

1.
2.
3.
4.

<br/>


# 1. List
-  List인터페이스는 Collection인터페이스를 상속받은 인터페이스다.
-  클래스를 다수 저장/관리하는 기능을 정의한다.
-  자료들을 순차적으로 나열한 자료구주로 인덱스로 관리한다.
-  중복해서 객체 저장이가능하다



## 구현클래스

- <code>ArrayList</code>,<code>LinkedList</code>,<code>Vector</code> 세가지클래스로 구현이가능하다.

  - 선형자료구조를 갖는 클래스로 배열과 유사하다.
  - 인덱스번호와 순서가 있다.
  - 삽입 삭제 메소드가 구현이되어있다.
  - 결과적으로 **클래스가 제공하는 메소드를 이용해서 데이터를 관리한다.**

## ArrayList클래스 이용하기

- 생성된 List저장소에 데이터를 저장이가능하다.
- <code>ArrayList</code>객체에 **저장가능한 데이터는 자바에서 사용하는 모든데이터가 저장이가능하다.**
- 먼저 저장을 할려면 <code>add</code>(저장데이터) 메소드를 이용해서 저장한다.

```java
list.add(true);
list.add(19);
list.add("김아무");
list.add('남');
list.add(180.5);
list.add(new Date());
```
<br/>

## 저장된 데이터 가져오기
- <code>get()</code> 메소드를 사용한다.
- ()안에 인덱스번호를 적어 저장소를 불러온다.

```java
list.add(true);
list.add(19);
list.add("김아무");
list.add('남');
list.add(180.5);

System.out.println(list.get(0));
System.out.println(list.get(1));
System.out.println(list.get(2));
System.out.println(list.get(3));
System.out.println(list.get(4));
//출력결과
//true
//19
//유병승
//남
//180.5
```

<br/>

- 여기서 주의할점이 하나있다.
- 기본적으로 ArrayList에 저장되는 데이터는 **Object자료형으로 저장이된다.**
- 대입된 실제 데이터를 사용하려면 **형변환** 을해야한다.


<br>
