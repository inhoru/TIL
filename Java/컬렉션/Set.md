# 🔖 목차

1. [Set](#1-Set)<br/>
2. [Set메소드 이용](#2-Set메소드-이용)<br/>
3. [LinkedHashSet](#3-LinkedHashSet)<br/>
4. [Tree](#4-Tree)<br/>


<br/>


# 1. Set
- Set은 List와 크게 다르지않다.
- 저장 순서가 유지되지않고 
- 중복 객체도 저장하지 못하게하는 자료구조이다.
- 구현클래스로는 <code>HashSet</code>,<code>LinkedHashSet</code>,<code>TreeSet</code> 가 있다.

<br/>

## HashSet

- 선언방법

```java
HashSet set = new HashSet();
```
- 선언방법은 List와 다르지않다.
- 데이터를 저장하는 방법도 똑같다.

```java
//데이터 저장
set.add("강태풍");
set.add("강바람");
set.add("강지");
set.add("강다영");
System.out.println(set);
//출력결과
//강바람
//강다영
//강지
//강태풍
```

- List 와 다른점은 위에서말햇듯이 **저장순서를 정하지못한다.**

<br/>

## set출력

- set출력도 List에서 출력한 방법과 다르지않다.

  - <code>Iterator</code>,<code>forEach</code>,<code>forEach()</code> 사용이가능하다.

```java
//Iterator
Iterator it = set.iterator();
		while (it.hasNext()) {
			String value = (String) it.next();
			System.out.println(value);
      
---------------------------------------------
//forEach문
		for (Object o : set) {
			System.out.println(o);
----------------------------------------------
//람다식
System.out.println();
		set.forEach((o) -> System.out.println(o));


```

# 2. Set메소드 이용
- set도 List처럼 메소드를통해 여러가지기능을활용할수있다.

## set에 저장된 데이터 갯수확인
- <code>size()</code>

```java
System.out.println(set.size());
```

<br/>

## set에 저장된 데이터가 저장되있는지 확인하는메소드
- 데이터가 저장되어있으면 false
- 데이터가 비어있다면 true

```java
stem.out.println(set.isEmpty());
```

<br/>


## set에 특정값이 있는지 확인하는 메소드
- <code>ontains(Object)</code> 
- equals, hasCode가 오버라이딩 되어있어야한다.

```java
System.out.println(set.contains("강태풍");
System.out.println(set.contains("김아무"));
```

<br/>

## set에 저장되어있는 객체를 삭제하는 메소드
- <code>remover(Object)</code>

```java
set.remove("강태풍");
```

<br/>

## 중복 데이터는 저장이 되지않는다.
- 말그대로 중복값이 있다면 아무리 추가해도 저장이되지않는다.

```java
set.add("강태풍");
set.add("강태풍");
set.add("강태풍");
set.add("강태풍");
set.forEach((o)->System.out.println(o));
//출렬결과
//강태풍
```

## set과 list 호환
- set을 list에 넣어서 list처럼 사용이가능하다.

```java
HashSet students = new HashSet();
List studentList = new ArrayList(students);
System.out.println(studentList.get(0));
```

- 그반대로 list를에 set을 넣어서 사용이가능하다.
- 예를 들어 list에 중복값을 제거할수있다.

```java
List testData = List.of(1,2,3,4,5,6,6,7,7,8,8,10,10);
Set temp = new HashSet(testData);
testData=new ArrayList(temp);
```
- 이렇게 중복값을 제거할수가있다.

<br/>

# 3. LinkedHashSet 
- 저장순서를 유지시켜주는 set이다.

```java
LinkedHashSet liSet = new LinkedHashSet();
	liSet.add(1);
	liSet.add(3);
	liSet.add(2);
	liSet.add(2);
  for(Object i : liSet) {
			System.out.println(i);
		}
  
 //출력결과
 //1
 //3
 //2
 //2
 ```
		
<br/>


# 4. Tree
- Tree구조에 객체를 대입할때는 그 클래스에 compareTo()메소드가 재정의 되어 있어야한다.
- Comparable인터페이스 구현해야한다.
- tree구조에서는 중복값을 기준으로 선언하면안됨.

```java
public class Student implements Comparable{
	private String name;
	private int grade;
	private int classNumber;
	private char gender;
	
	public Student() {}
	@Override
	public int compareTo(Object o) {
		
		return this.name.compareTo(((Student)o).name);
	}
	
  ----------------------------------------------------------------------
TreeSet studentTree = new TreeSet();
	studentTree.add(new Student("유병승",1,1,'남'));
	studentTree.add(new Student("최주영",2,1,'남'));
  System.out.println("studentTree 출력");
		studentTree.forEach((e)-> System.out.println(e));
```

<br/>

