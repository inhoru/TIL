## 🔖 목차


<br/>




# 1. spring 에서 security 적용
> 1. pom.xml에 security모듈을 적용해야 사용가능함
> 2. security관련설정을하기 : spring bean configuration.xml파일에 설정 ->  인증과 권한 처리를 한다.
> 3. security에서 제공하는 태그를 이용해서 설정함
> 4. 설정한 xml을 web.xml에 등록하기
> 5. security 를 적용하는 filter등록하기
> 6. 사용자인증 처리에 대한설정을 해주면된다.

<br/>

## 모듈적용
- pom.xml 파일에 모듈을 먼저 적용해주자

```xml
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-core</artifactId>
			<version>${org.springsecurity-version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-web</artifactId>
			<version>${org.springsecurity-version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-config</artifactId>
			<version>${org.springsecurity-version}</version>
		</dependency>
```

<br/>

## configuration.xml 설정
- security모듈로 클라이언트 인증처리하는 설정


```xml
<!--auto-config="true" : 자동으로 설정해주는 속성  -->
<security:http auto-config="true">

//로그인관련태그

</security:http>	
```
- security:http 태그안에서 인증처리할 서비스를 등록 하면된다.

<br/>

## 로그인 인증처리 서비스

- id, password를 입력받아서 DB나 저장소에 등록한것과 일치여부확인 session에 저장
- security 이 위임받음 로그인에대한 처리는 security가알아서 처리해준다.
- ecurity : form login태그를 이용한다. (login 로직을 만들지않아도된다.)
- 속성을 이용해서 설정을해준다.
		

