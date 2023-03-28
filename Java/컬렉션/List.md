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

## 전체 데이터 접근(순회)
- List는 배열과 비슷한점이많다.
- 배열은 전체조회를 반복문으로 이용을한다.
- 방법은 여러가지가있다.

  - <code>for문</code>
  - <code>forEach</code>
  - <code>iterator()</code> 메소드


<br/>

## for문

```java
for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i));
	}
```
- 우리가 자주쓰던 for반복문이다
- 한가지다른점은 List자료형의 길이는 <code>Size()</code>메소드를 이용한다.

<br/>

## forEach

```java
for(Object o: foods) {
	System.out.println(o);
}
```
- 배열에서도 사용한적 있는 녀석이다.
- 하지만 Object 는처음볼거다.
- **Object가 모든 자료형의 부모라는것만 알고있으면 이해하기쉬울거다**
- **원래 저기에 자료형이 들어와야하지만 Object는 최상위 부모이기때문에**
- **Object만쓴다면 아무 자료형이와도 반복을 돌릴수가있는것이다.**

<br/>

## iterator()

- 이방식은 Iterator객체를 이용하는것이다.
- Iterator는 자바의 컬렉션 프레임워크에서 컬렉션에 저장되어 있는 요소들을 읽어오는 방법을 표준화한 것이다.
- 자세히 어떻게 동작하는지 알필요없다.
- 어떤기능인지만 알고 쓰는방법만알고 넘어가자

	- hasNext() : 읽어올 요소가 남아있는지 확인하는 메소드. 요소가 있다면 true, 없다면 false
	- next() : 다음 데이터를 반환한다

```java
animals.add(new Animal("음메에",30.5,3,"양"));
Iterator it=animals.iterator();
while(it.hasNext()) {
			
			
	System.out.println(it.next());


}
//출력결과
//Animal [name=음메에, weight=30.5, age=3, type=양]
```

<br/>

## 원하는 인덱스 위치에 값 추가
- add를통해 추가하는건 이미알고있다.
- 이번엔 원하는 인덱스위치에 값을 추가할수가있다.
- 추가가된다면 알아서 자동으로 **그자리에있던값은 뒤로밀려나서 한칸씩밀린다.**
- <code>set(index, element)</code> 이런식으로 선언한다.



```java
ArrayList animals=new ArrayList();
animals.add(new Animal("뽀삐", 5.3,10,"강아지"));
animals.add(new Animal("야옹이", 4.2,5,"고양이"));
animals.add(new Animal("킥킥이", 15.3,3,"원숭이"));
animals.add(new Animal("하하", 200.2,9,"하마"));

animals.add(1,new Animal("부엉",4.3,3,"부엉이"));
		for(int i=0;i<animals.size();i++) {
			System.out.println(i+" "+animals.get(i));
		}
//출력결과
//0 Animal [name=뽀삐, weight=5.3, age=11, type=강아지]
//1 Animal [name=부엉, weight=4.3, age=3, type=부엉이]
//2 Animal [name=야옹이, weight=4.2, age=6, type=고양이]
//3 Animal [name=킥킥이, weight=15.3, age=4, type=원숭이]
//4 Animal [name=하하, weight=200.2, age=10, type=하마]
```

<br/>

## 원하는 인덱스의 값을 수정하기
- 이번에는 추가인add가아닌 set 를 이용한다.
- <code>set(index, element)</code>

```java
ArrayList animals=new ArrayList();
animals.add(new Animal("뽀삐", 5.3,10,"강아지"));
animals.add(new Animal("야옹이", 4.2,5,"고양이"));
animals.add(new Animal("킥킥이", 15.3,3,"원숭이"));
animals.add(new Animal("하하", 200.2,9,"하마"));

animals.set(1, new Animal("고라",20.2,1,"고라니"));
	for(int i=0;i<animals.size();i++) {
		System.out.println(i+" "+animals.get(i));
	}
//출력결과
//0 Animal [name=뽀삐, weight=5.3, age=11, type=강아지]
//1 Animal [name=고라, weight=20.2, age=1, type=고라니]
//2 Animal [name=야옹이, weight=4.2, age=6, type=고양이]
//3 Animal [name=킥킥이, weight=15.3, age=4, type=원숭이]
//4 Animal [name=하하, weight=200.2, age=10, type=하마]
```

<br/>

## 원하는 인덱스의 값 삭제
- 추가와 수정이가능하다면 삭제도가능하다.
- <code>remove(index);</code>

```java
ArrayList animals=new ArrayList();
animals.add(new Animal("뽀삐", 5.3,10,"강아지"));
animals.add(new Animal("야옹이", 4.2,5,"고양이"));
animals.add(new Animal("킥킥이", 15.3,3,"원숭이"));
animals.add(new Animal("하하", 200.2,9,"하마"));

animals.remove(1);
	for(int i=0;i<animals.size();i++) {
		System.out.println(i+" "+animals.get(i));
	}
//출력결과
//0 Animal [name=뽀삐, weight=5.3, age=11, type=강아지]
//1 Animal [name=킥킥이, weight=15.3, age=4, type=원숭이]
//2 Animal [name=하하, weight=200.2, age=10, type=하마]
```
<br/>

## 매개변수와 일치하는 값 삭제
- 매개변수와 일치하는 값을 삭제하는방법이있는데
- 단 주의할점은 **대상 클래스에 equals, hasCode가 오버라이딩 되어있어야한다.**



```java
ArrayList animals=new ArrayList();
animals.add(new Animal("뽀삐", 5.3,10,"강아지"));
animals.add(new Animal("야옹이", 4.2,5,"고양이"));
animals.add(new Animal("음메에",30.5,3,"양"));

animals.remove(new Animal("음메에",30.5,3,"양"));
	for(int i=0;i<animals.size();i++) {
		System.out.println(i+" "+animals.get(i));
	}
//출력결과
//0 Animal [name=뽀삐, weight=5.3, age=11, type=강아지]
//1 Animal [name=야옹이, weight=4.2, age=6, type=고양이]

```
<br/>

# 2. ArrayList의 데이터들을 관리할 수 있는 메소드
- List를 관리하기 수월하게만드는 메소드들을 소개하겠다.

<br/>


## 특정 객체가 리스트에 포함되어있는지 확인하는 메소드
- <code>contains(Object) : boolean</code>
- **boolena 값이기때문에 맞다면 true 틀리다면 false 를 반환한다.**

```java
ArrayList animals=new ArrayList();
animals.add(new Animal("야옹이", 4.2,5,"고양이"));

boolean result=animals.contains(new Animal("야옹이", 4.2,6,"고양이"));
System.out.println(result);
//출력결과
//true
```

## 동일한 객체를 찾아서 그 인덱스를 반환해주는 메소드
- <code>indexOf(Object)</code> : 앞에서부터 동일한객체를 찾으면 그객체를 반환 아니면 -1을 반환한다.
- <code>lastIndeOf(Object)</code> : 뒤에서부터 동일한객체를 찾으면 그객체를 반환 아니면 -1을 반환한다.

```java
ArrayList animals=new ArrayList();
animals.add(new Animal("야옹이", 4.2,5,"고양이"));

boolean result=animals.contains(new Animal("야옹이1", 4.2,6,"고양이"));
System.out.println(result);
//출력결과
//false
```
<br/>

## ArrayList로 저장된 데이터를 배열로 변화해주는 메소드
- List에 저장된데이터를 배열로 변경이가능하다.
- 그반대로 List에서 배열로 변경이가능하다.

	- Arrays클래스의 <code>asList()</code>메소드를 이용하면 변경할수있음

```java
//List로변경
Object[] objArr=animals.toArray();
for(Object o : objArr)
	System.out.println(o);
System.out.println(objArr[0]);

// 배열로변경
List animals2=Arrays.asList(objArr);
for(Object o:animals2) {
	System.out.println(o);
}

```
## ArrayList에 저장된 데이터를 한번에 전체삭제
- 어렵지않다 <code>clear()</code>메소드를 사용하면된다.

```java
animals.clear();
```

## List 선언과 동시에 초기화
- List도 배열과 마찬가지로 생성과 동시에 초기화가 가능하다.
- <code>List.of()</code> 메소드를 이용한다.

	- 한가지 주의할점은
	- List.of로 생성한 list는 불변의 리스트
	- 아무리값을 추가해도 추가되지않는다
	- final이라고 생각하자
```java

<br/>



 
# 3. List 사용
- List를 사용해서 저장된 내용에대한 분기처리도가능하다.
- 예를 들어 음식의 이름 가격 종류 를 List에 저장햇다고하다.

  - 전체 음식의 타입, 이름, 가격만 출력
  - 전체 음식중 5000원 이하인 음식만 타입 이름 가격 출력

- 이렇게 사용자가원하는 대로 분기처리해서 사용이가능하다.


<br/>

## 전체 음식의 타입, 이름, 가격만 출력

```java
ArrayList foods=new ArrayList();
		
foods.add(new Food("돈까스",10000,"일식",new Date()));
foods.add(new Food("초밥",2000,"일식",new Date()));
foods.add(new Food("컵라면",1400,"한식",new Date()));
foods.add(new Food("샐러드",12000,"건강식",new Date()));

for(int i=0;i<foods.size();i++) {
			Food f1=(Food)foods.get(i);
			System.out.println(f1.getType()+" "
			+f1.getName()+" "+f1.getPrice());
		}
//출력결과
//일식 돈까스 10000
//일식 초밥 2000
//한식 컵라면 1400
//건강식 샐러드 12000

```

- 위에 코드에서 한까지 의문인점이 있을거다
- <code>Food f=(Food)foods.get(1);</code> 이부분은 왜 Food로 형변환을 한걸까?

  - 이유는 간단하다 <code>Object</code>로 받기때문이다
  - **우리는 Food클래스에 getName()가 필요하기때문에 food클래스에접근하려면 형변환을 할수밖에없다.**
  - 그래서 형변환후 Food에접근해서 get()을 가져온거다.

<br/>

## 전체음식중 가격이 5000천원이하인 음식의 타입, 이름, 가격을 출력하기

```java
ArrayList foods=new ArrayList();
		
foods.add(new Food("돈까스",10000,"일식",new Date()));
foods.add(new Food("초밥",2000,"일식",new Date()));
foods.add(new Food("컵라면",1400,"한식",new Date()));
foods.add(new Food("샐러드",12000,"건강식",new Date()));

for(int i=0;i<foods.size();i++) {
			Food f1=(Food)foods.get(i);
			if(f1.getPrice()<=5000) {
				System.out.println(f1.getType()
						+" "+f1.getName()
						+" "+f1.getPrice());
			}
	}  
//출력결과
//일식 초밥 2000
//한식 컵라면 1400
```

- 위와 똑같이 Food로 형변환을해서 get()을가져온후 if문을 사용해서
- 사용자가 원하는 값만 출력을 할수가있다.

<br/>




    
    
	
