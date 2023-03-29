# 🔖 목차

1. [Map](#1-Map)<br/>
2. [HashMap](#2-HashMap)<br/>
3. [Map과 List 호환](#3-Map과-List-호환)<br/>
4. [Map 전체순회](#4-Map-전체순회)<br/>
5. [Map of메소드 사용](#5-Map-of메소드-사용)<br/>





<br/>

# 1. Map
- 키(key)와 값(value)으로 구성되어 있으며, 키와 값은 모두객체다.
- 키는 중복 저장을 허용하지 않고(set방식),값은 중복 저장가능(list방식)
- 키가 중복되는 경우, 기존에 있는 키에 해당하는 값을 덮어 씌움
- 구현 클래스는 <code>HashMap</code>,<code>Hashtable</code>,<code>LinkedHashMap</code>,<code>Properties</code>,<code>TreeMap</code> 가 있다.



<br/>

![Map](https://user-images.githubusercontent.com/126074577/228500355-961b675d-fd5c-4635-8aca-c7b5fb3485a5.png)

<br/>


# 2. HashMap

- 저장할때 key값과 value를 동시에설정한다.
- <code>put(key,value)</code>메소드를 이용한다.
- key : Object(기본) ->  String으로 많이 사용, Integer
- value : Object(기본) -> vo객체, String, Integer 

```java
map.put("bs", new Student("강태풍", 1, 1, '남'));
map.put("jy", new Student("강바람", 2, 1, '남'));
```

<br/>

## Map에 저장되어있는 데이터 가져오기
- key값으로 value를 가져올 수 있다.
- get(key) 메소드를 이용한다.

```java
map.put("bs", new Student("강태풍", 1, 1, '남'));
Object o = map.get("bs");
System.out.println(o);
//출력결과
//Student [name=강태풍, grade=1, classNumber=1, gender=남]
```
<br/>

## key 값은 중복이 불가능하다.
- 중복되는 키에 넣으면 나중에온값은 덮어쓰기를한다.

```java
map.put("bs", new Student("강태풍", 1, 1, '남'));
map.put("bs", "바보~");
System.out.println(map.get("bs"));
//출력결과
//바보
```

<br/>

## value값은 중복이 가능하다.
```java
map.put("bs", new Student("강태풍", 1, 1, '남'));
map.put("bs", "바보~");
System.out.println(map.get("bs"));

map.put("bs2", "바보~");
System.out.println(map.get("bs2"));

//출력결과
//바보~
//바보~
```

<br/>

## map에 저장된 데이터수 확인
- <code>size()</code>

```java
System.out.println(map.size());
```

<br/>

## map에 저장된 데이터 삭제하기
- <code>remove(key)</code>

```java
map.remove("bs2");
```

<br/>

## map에 특정키값이 있는지 확인하는 메소드
- <code>containskey</code> 
- 키값이 있으면 : true
- 키값이 없으면 : false

```java
map.put("bs", new Student("강태풍", 1, 1, '남'));

System.out.println(map.containsKey("bs"));
System.out.println(map.containsKey("js"));
//출력결과
//true
//false
```
<br/>

## map에 특정값이 있는지 확인하는 메소드

- <code>containsValue(값)</code>

```java
map.put("bs", new Student("강태풍", 1, 1, '남'));
map.put("bs", new Student("강아지));
System.out.println(map.containsValue(new Student("강태풍", 1, 1, '남')));
System.out.println(map.containsValue("강바람"));
//출력결과
//true
//false

```

<br/>


# 3. Map과 List 호환

- Map -> List반환하기
- <code>Map.values()</code>

```java
map.put("bs", new Student("강태풍", 1, 1, '남'));
List data = new ArrayList(map.values());
data.forEach((e) -> System.out.println(e));
//출력결과
//Student [name=강태풍, grade=1, classNumber=1, gender=남]
```

<br/>

# 4. Map 전체순회

- key전체를 가져오는 메소드를 이용하낟.
- <code>keySet()</code> -> Set으로 반환

```java
map.put("bs", new Student("강태풍", 1, 1, '남'));
Set keys = map.keySet();
for (Object key : keys) {
			System.out.println(key + " " + map.get(key));
		}
//출력결과
//bs Student [name=강태풍, grade=1, classNumber=1, gender=남]
```

## key와 value를 동시에 반환해주는 메소드
- <code>entrySet()</code>메소드 Map.Entry내부클래스이용

```java
HashMap map = new HashMap();
for (Object i : map.entrySet()) {
			Map.Entry  is = (Map.Entry) i; 
			System.out.println(is.getKey()+" "+is.getValue());
```

- map을 Map.Entry로 형변환을 해서
- getkey()와 getValue를 가져올수가있다.




<br/>

# 5. Map of메소드 사용
- Map도 of메소드를 이용해서 불변의 데이터를 생성할 수 있다.
- 수정이불가능하다는 특징이있다.

```java
Map data1 = Map.of("name","김아무","age",19,"gender",'M');
//data1.put("name", "경기도 시흥시");
//		System.out.println(data1);
//출력결과
//김아무 19
```
<br/>

 - Mapof는 List랑 많이쓴다.

```java
dataList.add(Map.of("name","김아무","age",19));
dataList.add(Map.of("name","김태풍","age",26));
for(Object o2 : dataList) {
			System.out.print(((Map)o2).get("name") + " ");
			System.out.println(((Map)o2).get("age"));

```



