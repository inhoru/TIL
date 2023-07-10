## :bookmark: 목차

1. [pom](#1-pom)<br/>




<br/>



## Apache Maven

- 프로젝트에서 사용하는 관리도구로 XML을통해
- 프로그램 버전 정보와 라이브러정보 통합 관리를해준다.

- 쉽게말하자면 lib에 넣엇던 라이브러르들(jar) 들을 xml이넣어서 관리를 할수있다.
- spring 에서 자주사용하니 알아두자





<br/>





# 1 . pom

- POM(Project Object Model)은 하나의 프로젝트에서 사용하는 자바 버전, 라이브러리, 플러그인 구성을 통합하여 관리할 수 있게각 설정 정보를 XML로 문서화한 것이다.



<br/>



## 구성


![image](https://github.com/inhoru/TIL/assets/126074577/b88c2a46-2439-41f6-aae1-75425b00ea4f)

<br/>

# 2. 프로젝트생성
- Maven project로 생성해준다.

![image](https://github.com/inhoru/TIL/assets/126074577/84a28c4f-b9dd-46cc-920d-36c83b6fdbb4)

- 심플프로젝트는 아무것도없는상태에서 내가만들겟다라는뜻

![image](https://github.com/inhoru/TIL/assets/126074577/543f3552-4b29-4e30-8851-90c1864b0be9)

- 이렇게 생성할수가있다.

<br/>


## pom.xml설정

- 지금까지 라이브러리를 사용할때 lib에 jar파일을 넣어서 사용했지만
- pom.xml 문서 하나만으로 필요한 라이브러리를 자동으로 설치하고 관리할 수 있다.
![image](https://github.com/inhoru/TIL/assets/126074577/5b4e3cbc-3cf3-49a1-abc3-b2b959499c68)


```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.bs</groupId>
	<artifactId>maventest</artifactId>
	<version>0.1</version>
	<name>maventest</name>
	<packaging>jar</packaging>
	<properties>
		<java-version>17</java-version>
		<org.springframwork-version>5.3.28</org.springframwork-version>
	</properties>
	
	<!--라이브러리가져오기  -->
	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.28</version>
			<scope>provided</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${org.springframwork-version}</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${org.springframwork-version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-beans</artifactId>
			<version>${org.springframwork-version}</version>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.11.0</version>
				<configuration>
					<source>${java-version}</source>
					<target>${java-version}</target>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
```



