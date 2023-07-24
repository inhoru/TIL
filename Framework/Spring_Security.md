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
- 인증관 권한처리에대한 설정을해준다.
- 


