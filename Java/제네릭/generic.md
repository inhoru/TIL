# 🔖 목차
1. [generic](#1-generic)<br/>
2. [인터페이스](#2-인터페이스)<br/>
3. [컬렉션에서사용](#3-컬렉션에서사용)<br/>




<br/>

# 1. generic
- 자바에서 동적타입을 선언하는 구문이다.
- <자료형>으로 제네릭으로 선언된 자료형을 경정한다.
- 데이터 형식에 의존하지 않고 하나의 값이 여려 데이터 타입들을 가진다.

<br/>

## 선언및 활용

- **제네릭표시 클래스 에< T >를 넣는다.**
- 생성할때 타입을 결정해준다.
- **int가될수도있고 String이될수도있다 아무거나될수가있다**
- 근대 < T > 뭐지라고 할수있다.
    - 그냥대중적으로 통하는 통상적인 선언이다.
    - 암묵적 규칙이라고보면된다.



![제네릭](https://user-images.githubusercontent.com/126074577/228588490-681e35cf-ffc7-468a-94b7-c06ff5c544b4.png)
  
  
```java
public class GenericBasic<T>{

private T data;

	
	public GenericBasic() {
	}
	public GenericBasic(T data) {
		this.data=data;
	}
	public T getData() {
		return this.data;
		
	}
	public void setData(T data) {
		this.data=data;
	}
```

- T 라는 문구로 전부 통일한거다.
- 이렇게만들었으니 클래스타입을만들어보자

```java
GenericBasic<String> gb=new GenericBasic<String>();
gb.setData("");
System.out.println(gb.getData());
//출력결과
//김아무
```
- 이렇게 제네릭을 선언해서 사용이가능하다.
- **String으로 선언했기에 String타입만들어갈수가있다.**

    - gb.setData(19); 은 불가능하다.
    - **int 를저장하고싶으면 제네릭에 Integer을 선언해야한다.**

```java
GenericBasic<Integer> gb1=new GenericBasic<Integer>();
gb1.setData(19);
System.out.println(gb1.getData());
//출력결과
//19
```

<br/>

## 제네릭은 한개만 가능한가?

- **제네릭은 한개도가능하지만 두개도가능하다.**

```java
public class GenericBasic<T,E>{

private T data;
private E element;
-------------------------------------------------------------
GenericBasic<String,Date> gb=new GenericBasic<String,Date>();

GenericBasic<Integer,Math> gb1=new GenericBasic<Integer,Math>();

```
- 이런식으로 2개 사용이가능하다.


# 2. 인터페이스
- 인터페이스에도 제네릭을 사용할수가있다.

```java
 public interface GenericInterface<E,T> {
	
	boolean check(E element ,T  value);
} 
-------------------------------------------

GenericInterface<String, String> stringFilter = (e,v)->e.equals(v);
//String, String 라서 문자열만들어간다.
stringFilter.check("dfds","Dfd");

GenericInterface<GenericBasic ,String> filter = (e,v)->e.equals(v);
//똑같은 인터페이스지만 제네릭의 의해서 들어가는값을다르게할수있다.
filter.check(new GenericBasic<>(),"sada"); 
 
```

<br/>

# 3. 컬렉션에서사용
- 컬렉션에서도 제네릭을사용한다.

## ArrayList
- 이름만저장한다 고한다면 제네릭을 String로선언

```java
ArrayList<String> names = new ArrayList();
names.add("강바람");
names.add("강지디");
for(String s : names) {
	System.out.println(s);
}
//출력결과
//강바람
//강지디
```
- names에는String만들어간다.
- names.add(10); 이렇게선언하면 오류가난다.
- 왜냐하면 String으로 제네릭을 선언했기때문이다.

<br/>

- 그렇다면 왜이렇게 사용하는걸까?
- 그냥 선언하지않고 Object로사용해두 되는거아닌가?
- **클래스 외부에서 타입을 지정해주기 때문에 따로 타입을 체크하고 변환해줄 필요가 없다.**

```java
ArrayList<Fruit> fruits =  new ArrayList();
fruits.add(new Fruit("딸기","논산",10,10000));
	//fruits.add(new Animal()); Fruit로 제네릭을 선언햇기에 다른건안된다.
fruits.add(new Fruit("포도","송산",10,20000));
fruits.add(new Fruit("사과","예산",20,35000));

for(int  i = 0;i<fruits.size();i++) {
	//원래는 ((Fruit)fruits.get(i).getName(); 이렇게 Object를 Fruit로 형변환후 가져와야햇지만
	//제네릭으로 Fruit를 선언햇으니 형변환을 할필요가없다.
			
	fruits.get(i).getName();
```
- 이런식으로 따로 형변환을 해주고 그럴필요가없다 
- 타입이정해져있기에 바로가져올수가있다.

<br/>

## HashSet
- Set도 제네릭이 사용이가능하다.
- **Iterator로 출력을할건데 Iterator도인터페이스이기때문에 제네릭이가능하다.**

```java
Set<Animal> animals = new HashSet();
animals.add(new Animal("바둑이",8.3,4,"강아지"));
animals.add(new Animal("꽤꽥이",4.6,3,"오리"));
//animals.add(new Fruit()); 똑같이 제네릭을 Animal을 저장햇기에 Fruit는 저장이안된다.
while(it.hasNext()) {
	Animal a =it.next();
	System.out.println(a.getName());
}
```
<br/>

## Map

- Map도 제네릭이 가능하다.
- **Map에는 key값과 value값이 있기에 제네릭을 2개를설정해야한다.**

- keySet()  를이용한 값가져오기
```java
Map<String,Food> foods = new HashMap();
foods.put("1", new Food("윤쉐프",7000,"급식",new Date()));
foods.put("2", new Food("족발",35000,"한식",new Date()));
foods.put("1", new Food("초밥",12000,"일식",new Date()));
//foods.put(10, null); key를 String로 고정했기떄문에 인트가들어갈수가없다. 타입이공정됫다.
		
Set<String> keys = foods.keySet();//키 들만가져와서 셋에저장 그키들은 모두String다.
Iterator<String> it2 = keys.iterator();
while(it2.hasNext()) {
	String key = it2.next();
	System.out.println(foods.get(key).getName());
}

<br/>

- entrySet()를 이용한 key값과 value값 반환받기

```java
Set<Map.Entry<String,Food>> entry = foods.entrySet();

for (Entry<String, Food> e : entry) {
	System.out.println(e.getKey());
	System.out.println(e.getValue().getName()+ " "+e.getValue().getPrice());
			
}
```
- 위에서는 모두 Iterator 사용했지만
- forEach문으로도 가능하다.
- 사실 forEach()메소드로도가능하다

```java
Map<String,Food> foods = new HashMap();
Set<Map.Entry<String,Food>> entry = foods.entrySet();
entry.forEach(food->System.out.println(food.getKey()+" "+food.getValue().getName()+" "+food.getValue().getPrice()));
```

<br/>




