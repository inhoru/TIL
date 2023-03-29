# 🔖  목차

1. [Properties](#1-Properties)<br/>
2. [파일과연동](#2-파일과연동)<br/>




<br/>


# 1. Properties
- Map형식으로 데이터를 저장하는 클래스
- 파일과 연동해서 데이터를 저장 및 출력을한다.
- 문자열데이터를 저장하고 출력하는기능
- key=value형식으로 저장된다.


## 선언및활용
- <code>properties</code>객체에 값저장하기
- <code>put()</code> 메소드이용

```java
prop.put("name", "유병승");
prop.put("age", "19");
System.out.println(prop);
//출력결과
//{name=유병승, age=19}
```

- Map과 같이 key = value방식으로 저장된다.

<br/>

## 문자열 저장

- <code>setProperty()</code>메소드를 문자열을 저장할때 사용한다.

```java
prop.setProperty("userId", "admin");
prop.setProperty("password", "1234");
System.out.println(prop);
//출력결과
//{password=1234, name=유병승, userId=admin, age=19}

```

<br/>

# 2. 파일과연동

- 저장된 파일에 properties객체에 저장된 내용을 저장시킬수있다.
- <code>store(FileOutputStream)</code>메소드 이용
- <code>storeToXML()</code> 메소드 이용
- **먼저 XML파일저장부터알아보자**

```java
Properties prop2 = new Properties();
		System.out.println(prop2);
		try {
			prop.storeToXML(new FileOutputStream("first.xml"), "");
		}catch(IOException e) {
			e.printStackTrace();
		}
```
- first.xml  파일이 생성된후 그안에 저장이된다.

![first.xml](https://user-images.githubusercontent.com/126074577/228578203-27c13dc3-c7bd-48d0-b27e-178eff0231df.png)
![first.xml](https://user-images.githubusercontent.com/126074577/228578167-481369cb-c887-403c-a1a1-ffbf7ff34200.png)

<br/>

## 저장한 내용가져오기
 - 파일을 저장했으니 불러올수도있다.
 - <code>load(FileInputStream)</code> 메소드이용
 - XML파일은 <code>loadFromXML</code> 로 불러온다.



```java
try {
			
			prop2.loadFromXML(new FileInputStream("mydata.xml"));

		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop2);
//출력결과
//{password=1234, name=김아무, userId=admin, age=19}

```

- 이런식으로 xml 파일을 저장및 불러오기를한다.

<br/>

## properties에 저장및  데이터 불러오기
- 저장하는건 <code>load(FileInputStream)</code>
- 불러오기 <code>getProperty("key")</code>메소드 이용

```java
prop.setProperty("userId", "admin");
prop.setProperty("password", "1234");
System.out.println(prop);

try {
prop.store(new FileOutputStream("first.properties"), "first properties");
}catch(IOException e) {
			e.printStackTrace();
		}
```
- first.properties 파일이 생성및 저장이됐다.

- 이제불러와보자



```java
try {
			
			prop2.load(new FileInputStream("first.properties"));
      
  }catch(IOException e) {
			e.printStackTrace();
		}
  
  System.out.println(prop2.getProperty("userId"));
  
  //출력결과
  //admin
  ```
  
  - 이런식으로 properties파일을 저장및 불러오기를한다.
  
  
