## 🔖 목차


<br/>

## Spring Franeork
- 자바 플랫폼을 위한 오픈 소스 애플리케이션 프레임워크로간단하게 스프링(Spring)이라고도 부름
- 동적인 웹 사이트를 개발하기 위한 여러 가지 서비스를 제공하고 있으며대한민국 공공기간의 웹 서비스 개발 시 사용을 권장하고 있는전자정부 프레임워크의 기반 기술로 쓰인다.
- was위에 servlet가있고 그위에 Sprig을 덮어씌워서 사용을 편리하게만들어주는 프레임워크다.


<br/>

# 1. 특징
- spring 의 큰 특징의 대해 알아보자

- POJO : 우리가만들던 mvc패턴같은것들을 자동으로 만들어준다. 내가만든 구조들을 스프링안에서 사용할수있게 해준다.
- IoC : 제어권이 개발자가아니라 서버에게있는것 (스프링컨테이너)구동시 필요한 객체의 생성부터 생명주기까지 직접 관리를 해준다.
- DI : 설정 파일이나 어노테이션을 통해 객체 간의 의존 관계를설정하여 개발자가 직접 의존하는 객체를 생성할 필요 없음
- AOP : 트랜잭션, 로깅, 보안 등 여러 모듈, 여러 계층에서 공통으로필요로 하는 기능의 경우 해당 기능들을 분리하여 관리

- 크게 위에 4가지로 특징있고 나머지특징은 알아만두자

  ![image](https://github.com/inhoru/TIL/assets/126074577/82533826-8823-4149-8c17-7207f2239c44)


<br/>

# 2. spring 다운
- https://spring.io/tools 스프링 공식 사이트다. 여기서 스프링을 다운받을수있다.
![image](https://github.com/inhoru/TIL/assets/126074577/1c70bc95-b0e8-47d3-b978-57f495550dda)
![image](https://github.com/inhoru/TIL/assets/126074577/1d33a9a7-739e-4f49-b19f-d658886cb8e4)

- 자기의 운영체제의 맞는걸 다운받으면된다.

## spring boot
- spring boot를 쓸땐 Spring Tools 4 for Eclipse 을 다운받으면된다.
- 스프링 프레임 워크를 사용 하면 많은 XML 설정파일등을 작성 하는 등 설정하는 방법이 어려운 편이기 때문에 보통 검색을 통해 설정 내용을 복사 하거나, 기존 설정파일들을 복붙하기 일수였다.
- 하지만 스프링 부트는 반복되는 개발환경 구축을 위한 코드작성등의 노력을 줄여주고 쉽고 빠르게 프로젝트를 설정할 수 있도록 도와준다.

<br/>

- Spring Tools 4 for Eclipse 를 다운받으면 jar파일로 받는데
- 여기서 파워쉘에서 실행해주면된다.

![image](https://github.com/inhoru/TIL/assets/126074577/5ccea3b7-3f7f-4fbf-b83c-f28b7edcccfc)
- 이렇게 하면 설치가 완료가된거다.
 

<br/>

## legacy
- boot를 안쓰고 스프링 프레임워크를 사용하기위해서는 sts3를 다운받아서 사용하면된다.
- https://github.com/spring-attic/toolsuite-distribution/wiki/Spring-Tool-Suite-3
- ![image](https://github.com/inhoru/TIL/assets/126074577/87d480ec-bc81-4f8e-8f51-b54387094be5)
- 요걸 다운받으면된다.


<br/>

# 3. 프로젝트 생성
- 프로젝트를 생성할땐 maven 프로젝트를 만들어서 사용한다.

![image](https://github.com/inhoru/TIL/assets/126074577/cefe63c7-41bf-49a1-b760-e1fc7d78b3f3)

<br/>

## enterprise web
- boot에선 xml이나 jsp웹에 사용되는걸 지원하지않는다
- 그래서 우리가 마켓플레이스에서 다운을 받아서 사용할수가있다.

![image](https://github.com/inhoru/TIL/assets/126074577/516901e9-21a8-478e-851d-b70b7a0844e2)


# 4. log4j
- 스프링에서 로그를 출력하기위해 설정하는xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE log4j:configuration PUBLIC "-//APACHE//DTD LOG4J 1.2//EN" "http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/xml/doc-files/log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
	<!-- Appenders -->
	<appender name="console" class="org.apache.log4j.ConsoleAppender">
		<param name="Target" value="System.out" />
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="%-5p : %l - %m%n" />
		</layout>
	</appender>
		<!-- Application Loggers -->
	<logger name="com.bs.spring">
		<level value="debug" />
	</logger>
	
	<!-- 3rdparty Loggers -->
	<logger name="org.springframework.core">
		<level value="info" />
	</logger>
	
	<logger name="org.springframework.beans">
		<level value="info" />
	</logger>
	
	<logger name="org.springframework.context">
		<level value="info" />
	</logger>

	<logger name="org.springframework.web">
		<level value="info" />
	</logger>

	<!-- Root Logger -->
	<root>
		<priority value="warn" />
		<appender-ref ref="console" />
	</root>
</log4j:configuration>
```

<br/>



# 5. 폴더구조
![image](https://github.com/inhoru/TIL/assets/126074577/dacf334d-c09c-44e5-a40a-1be7dbdbfe5f)
- jvav에는 m,v,c가들어감
- resources에는 각종환경설정
- test 메인과같지만 테스트용 폴더
- libraires : 라이브러리들을 불러온다 자바ee관련 내용들이 들어온다.


## main
![image](https://github.com/inhoru/TIL/assets/126074577/62b8c689-7ff3-43bc-8c65-065739dde805)
![image](https://github.com/inhoru/TIL/assets/126074577/e36ad83e-bbeb-40da-8f0e-7c78ad248c5f)

- webapp/resources : views에서 필요한 css, js , upload , img 등등 이 들어간다.
- webapp아래에있  jsp파일은 외부에서 접근이불가능하다 그렇기때문에 이제부터 맵핑주소로 접속을해야한다.


```java
@Controller
public class HomController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}

}
```

<br/>

- 위에처럼 index를  잘모르겟데ㅏㅣ;;
- 
# 6. pom.xml
- maven 프로젝트 설정을해줘야한다.
- 각종 라이브러리 들을 설정해줄수있다.
- 코드 주석에 자세한 태그들의 기능들을 써놓을테니 잘읽어보자

<br/>

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.bs</groupId>
	<artifactId>spring</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>spring</name>
	<properties>
		//자바버전
		<java-version>17</java-version>
		//프레임워크 버전
		<org.springframework-version>5.3.28</org.springframework-version>
		//aspectj 버전
		<org.aspectj-version>1.9.19</org.aspectj-version>
		//slf4j 버전
		<org.slf4j-version>2.0.7</org.slf4j-version>
	</properties>
	<dependencies>
		<!-- Spring -->
		<dependency>
			<groupId>org.springframework</groupId>
			//context 모듈가져옴
			<artifactId>spring-context</artifactId>
			<version>${org.springframework-version}</version>
			<exclusions>
				<!-- Exclude Commons Logging in favor of SLF4j -->
				<exclusion>
					<groupId>commons-logging</groupId>
					<artifactId>commons-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

  		//AOP적용할때 필요함 웨이버도 필요함 나중에배움움
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>

		<!-- AspectJ -->
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjrt</artifactId>
			<version>${org.aspectj-version}</version>
		</dependency>


		//인터페이스 로그들을 찍는 기능
		<!-- Logging -->
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>${org.slf4j-version}</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>jcl-over-slf4j</artifactId>
			<version>${org.slf4j-version}</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>${org.slf4j-version}</version>
			<scope>runtime</scope>
		</dependency>
		//로그 프레임워크인 log4j
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
			<exclusions>
				<exclusion>
					<groupId>javax.mail</groupId>
					<artifactId>mail</artifactId>
				</exclusion>
				<exclusion>
					<groupId>javax.jms</groupId>
					<artifactId>jms</artifactId>
				</exclusion>
				<exclusion>
					<groupId>com.sun.jdmk</groupId>
					<artifactId>jmxtools</artifactId>
				</exclusion>
				<exclusion>
					<groupId>com.sun.jmx</groupId>
					<artifactId>jmxri</artifactId>
				</exclusion>
			</exclusions>
			<scope>runtime</scope>
		</dependency>

		//나중에 자바객체를 의존성 적용할때 쓰는데 잘쓰진않는다.
		<!-- @Inject -->
		<dependency>
			<groupId>javax.inject</groupId>
			<artifactId>javax.inject</artifactId>
			<version>1</version>
		</dependency>
		
	
		<dependency>
			<groupId>jakarta.servlet</groupId>
			<artifactId>jakarta.servlet-api</artifactId>
			<version>4.0.4</version>
			<scope>provided</scope>
		</dependency>
		<!--
		jsp -->
		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>javax.servlet.jsp-api</artifactId>
			<version>2.3.3</version>
			<scope>provided</scope>
		</dependency>
		<!-- jstl -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>

		<!-- Test -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.7</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
		<!--롬복-->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.28</version>
			<scope>provided</scope>
		</dependency>


	//이클립스 빌드관련된 태그들들
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<artifactId>maven-eclipse-plugin</artifactId>
				<version>2.9</version>
				<configuration>
					<additionalProjectnatures>
						<projectnature>
							org.springframework.ide.eclipse.core.springnature</projectnature>
					</additionalProjectnatures>
					<additionalBuildcommands>
						<buildcommand>
							org.springframework.ide.eclipse.core.springbuilder</buildcommand>
					</additionalBuildcommands>
					<downloadSources>true</downloadSources>
					<downloadJavadocs>true</downloadJavadocs>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.11.0</version>
				<configuration>
					<source>${java-version}</source>
					<target>${java-version}</target>
					<compilerArgument>-Xlint:all</compilerArgument>
					<showWarnings>true</showWarnings>
					<showDeprecation>true</showDeprecation>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>exec-maven-plugin</artifactId>
				<version>1.2.1</version>
				<configuration>
					<mainClass>org.test.int1.Main</mainClass>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
```

 - 이렇게 maven 레파지토리에 전부 설정들이 들어갈것이다.

## 라이브러리 등록
- 라이브러리 등록도 porm.xml에서 가능하다.
- 먼저 maven홈페이지에서 각종 라이브러리를 받을수있다.
- https://mvnrepository.com/

- 여기서 lombok을 찾아서 라이브러리에 넣어보겟다.

![image](https://github.com/inhoru/TIL/assets/126074577/6e5da0a9-7f63-4663-ad1c-48740346af91)

- 롬복을 검색후 원하는 버전을 선택하면 위에창이나온다.
- 우리는 지금까지 jar파일을 다운받아서 사용했지만
- 이제는 dependency 태그를 복사해서 사용할것이다.
- ![image](https://github.com/inhoru/TIL/assets/126074577/8b4d81fb-7c4c-4492-86d1-d367459f432e)
- 이거를 그대로 복사해서 xml에  <dependencies> 안에 붙여넣기만 하면된다.
- 

```xml
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
		<!--롬복-->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.28</version>
			<scope>provided</scope>
		</dependency>
```

<br/>

# 7. 스프링 실행 구조
![image](https://github.com/inhoru/TIL/assets/126074577/e56de315-0da4-4865-8018-fc0388e71e2a)

- 우리가 이렇게 폴더구조를 만들고 서버를 실행해서 웹을 실행하면
- http://localhost:8080/spring/ 주소로 들어가면 index.jsp 가 열린다
- 왤까? 그이유는 Homcontroller 클래스에잇다.

```java
package com.bs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.spring.beantest.Animal;

//spring ben 으로등록
@Controller
public class HomController {
	//springbean으로 등록된 객체는 필드로 가져와 사용할 수 있음
	@Autowired
	private Animal a;
	
	
	
	@RequestMapping("/")
	public String home() {
		System.out.println(a);
		return "index";
	}

}
```
- @Controller 스프링  ben으로 등록한거다
- 스프링안에서 저 클래스는 컨트롤러로 인식한다.
- 그후 핸들러에게 준다.
- http://localhost:8080/spring/ 를 요청하면
- @RequestMapping("/") 을실행하라는 뜻이다.
- 하지만 ViewResolver를 만들어준것도아닌데 어떻게 실행이될까?
- 그 답은 servlet-context 에있다.

<br/>

## servlet-context

- servlet-context로가보면
- beans:bean 이라는 태그가있다.
- 어떤 클래스를 생성해서 스프링이이용하게되야할때 ben으로 등록할때 쓰는 태그다.

```xml
// 자기가 가지고있는 폴더중에 리소스안에서 view를 찾아서 연결시켜주는 역할을하는 클래스다.
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		//클래스를 등록했을때 필요한값들은 beans:property로 설정가능
		<!--앞에 붙이는값  -->
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<!--뒤에 붙이는값  -->
		<beans:property name="suffix" value=".jsp" />
</beans:bean>
```

- 메소드에서 리턴되는값을 viewsResovler을에준다
- 그런후 prefix 와 suffix를 붙여서준다음 찾는다.
- 그렇게 index.jsp를 찾을수있는거다.
- 그래서 http://localhost:8080/spring/ 에들어가면 주소값이바뀌지않고 jsp로 바뀔수가있다.
- 이게 기본적으로 스프링이돌아가는 구조이다.

<br/>


	

# 5. spring di
- 사용자가 객체를 직접 생성하는게아니라 컨테이너가 빈을 가져와서 객체를 연결해줌
- 이렇게 의존성을 주입할수가 있다.
- 로컬변수에 집어 넣지않고 필드에 집어넣는다

![image](https://github.com/inhoru/TIL/assets/126074577/b4709eaa-cf10-41bc-8333-7b6b60a2fab6)

<br/>

![image](https://github.com/inhoru/TIL/assets/126074577/e343765c-ea0a-458c-ac30-3e9b916330d2)





