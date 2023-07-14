# 🔖 목차


<br/>

## Log
실무에서는 println과같은 시스템 콘솔을 사용해서 정보를출력하지않는다.

별도의 log라이브러리를 이용해서 타임스탬프 등 정해진 양식에 맞춰서 화면상이나 파일 로그를 남길 목적으로 사용한다.


<br/>

# 1. Log설정
- 먼저 jar파일을 등록해야한다.
- log프레임워크는 다양하게있는데 log4j를 사용하겟다. boot는 log4back를 많이사용한다.
- porm.xml에 등록을하면된다.
- log4j도 하나의 프레임워크다 그래서 이것이 돌아가는 방식을 설정을해줘야한다. log4j.xml이라는 걸생성후 설정해줘야한다.
![image](https://github.com/inhoru/TIL/assets/126074577/5fcbe18b-bce0-491d-988b-2d59a2316b4c)


<br/>

## log4j.xml
- log4j를 이용하기위해 xml설정을해줘야한다.
- 로그를 어디에남길건지 어떻게남길건지를 설정해줘야한다.
- appender 안에 있는것들이 로그함수를 호출했을때 어디에다 출력할지 결정을해준다.

```xml
<appender name="console" class="org.apache.log4j.ConsoleAppender">
		<param name="Target" value="System.out" />
		<layout class="org.apache.log4j.PatternLayout">
    </layout>
</appender>
```

- appender : 클래스는 기본적으로 apache에서제공하는 클래스다 consoleAppender은 console창에출력해준다는뜻
- target : vlaue값인 System.out으로해서 로그를 찍겟다라는뜻
- layout : 로그를 어떤형태로 찍을건지 패턴을 선택할수있다.

<br/>

## logger
- appender을사용할 대상을 설정해준다.

```xml
<logger name="com.bs.spring">
		<level value="debug" />
		<appender-ref ref="fileAppender"/>
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
```
- logger : name값은 패키지명이들어있는데 로그를찍을떄 name값패키지는 어떻게찍어 라고 설정할수가있다.
- level : 로그를 찍을때 기록을하는데 오류면 오류 정보면 정보 이런 것들을 level에따라 나눠서 찍어준다.
- 로그의 level은 debug -> info -> warn -> error -> fatal 순으로 진행된다.
- warn은 설정했으면 warn부터 fatal까지만 나온다.

```xml
<logger name="org.springframework.core">
		<level value="info" />
</logger>
```

- 전체적인코드로 보며 설명하자면
- 이패키지안에서 구현체를 이용해서 로그를 남길떄 info부터 출력해 라는뜻이다.

  
<br/>

# root
```xml
<root>
		<priority value="warn" />
		<appender-ref ref="console" />
</root>
```
- root라는것은 이어플리케이션에서 log4j를 이용해서 로그를 남겨놨으면 appender을한다 console 창에다가


<br/>


# 2. log출력
- log4j를 이용해서 log를출력해보자
- log를 출력하기위해서 Logger인터페이스를 구현한 클래스를 이용한다.
- LoggerFactory클래스에 static메소드인 `getLogger(logger을가져오는 클래스명을지정한다)`; 을이용한다.
- log를 출력할떄는 logger가 제공하는 메소드를 이용한다
  - debug() : 개발시에 사용하는 로그를 출력할때 사용
  - info() : 프로그램 실행하는 정보를 출력할때 사용
  - warn() : 잘못된 사용을 했을때 출력할때 사용
  - error() : Exception 실행이 불가능한 기능에 대한 로그를 출력할때 사용
    - 메소드의 매개변수는 기본적으로 String만 가능, 객체나 다른 데이터를 출력하려면 ("{}",출력변변수) 



```java
@Controller
public class MainController {
	//log를 출력하기 위한 Logger가져오기
	private static final Logger logger=LoggerFactory.getLogger(MainController.class);

logger.debug("debug내용출력하기");
logger.info("info내용출력하기");
logger.warn("warn내용출력하기");
logger.error("error내용출력하기");

//출력결과
[2023-07-14 17:10:38] DEBUG : [com.bs.spring.MainController.main(MainController.java:63)] - debug내용출력하기
[2023-07-14 17:10:38] INFO  : [com.bs.spring.MainController.main(MainController.java:64)] - info내용출력하기
[2023-07-14 17:10:38] WARN  : [com.bs.spring.MainController.main(MainController.java:65)] - warn내용출력하기
[2023-07-14 17:10:38] ERROR : [com.bs.spring.MainController.main(MainController.java:66)] - error내용출력하기
```
- 기본적으로 log는 위에처럼 출력이된다.
- xml에서 level에 무슨값을 설정했느냐에따라 출력결과가 바뀔것이다.

<br/>

## Layout
- layout 찍을떄 다양한 패턴으로 찍는방법이있다.

```xml
<layout class="org.apache.log4j.SimpleLayout"/> //로그를 정말간단하게바꿔준다.
<layout class="org.apache.log4j.HTMLLayout"/> // 로그를 html로 찍어준다
<layout class="org.apache.log4j.xml.XMLLayout"/> //로그를 xml방식으로 출력해준다.
```

<br/>

# 3. 패턴설정
- log4j의 패턴을 가지고 로그를 출력해줄수있다.

 <br/>

 ```
기본 패턴설정 : %-5p: %c - %m%n
			이벤트명, 카테고리명, 로그전달메세지 개행

* %c : 카테고리명(logger이름)을 표시
	* 카테고리명이 a.b.c일때, %c{2}는 b.c를 출력
* %C : 클래스명을 표시함.	
	* 풀 클래스 명이 com.kh.logger일때, %C{2}는 kh.logger를 출력
* %d : 로그 시간을 출력한다. java.text.SimpleDateFormat에서 적절한 출력 포맷을 지정할 수 있다. 
	* %d{HH:mm:ss, SSS}
	* %d{yyyy MMM dd HH:mm:ss, SSS}
	* %d{ABSOLUTE} 
	* %d{DATE} 
	* %d{ISO8601}
* %F : 파일명을 출력. 로그시 수행한 메소드, 라인번호가 함께 출력된다.
* %l : 로깅이 발생한 caller의 위치정보. 자바파일명:라인번호(링크제공) 
* %L : 라인 번호만 출력한다(링크없음)
* %m : 로그로 전달된 메시지를 출력한다.
* %M : 로그를 수행한 메소드명을 출력한다. 
* %n : 플랫폼 종속적인 개행문자가 출력. rn 또는 n
* %p : 로그 이벤트명등의 priority 가 출력(debug, info, warn, error, fatal )
* %r : 로그 처리시간 (milliseconds)
* %t : 로그이벤트가 발생된 쓰레드의 이름을 출력
* %% : % 표시를 출력. escaping
* %r : 어플리케이션 시작 이후 부터 로깅이 발생한 시점의 시간(milliseconds)
* %X : 로깅이 발생한 thread와 관련된 MDC(mapped diagnostic context)를 출력합니다. %X{key} 형태.
```

## 패턴이용
- 패턴을이용해서 log를 출력해보자

```xml
<layout class="org.apache.log4j.PatternLayout">
	<param name="ConversionPattern" 
	value="[%d{yyyy-MM-dd HH:mm:ss}] %-5p : [%l] - %m%n"/>
	
</layout>
//출력결과
[2023-07-14 18:57:03] INFO  : [org.springframework.web.servlet.FrameworkServlet.initServletBean(FrameworkServlet.java:547)] - Completed initialization in 2834 ms
```
- 이렇게 패턴을 사용해서 몇시몇분 언제 어디서 발생했는지알수도있다.


<br/>

## 파일로 로그등록
- appender을 추가해서 파일로 로그를 출력하는 기능을 추가할수있다.

```xml
<appender name="fileAppender" class="org.apache.log4j.DailyRollingFileAppender">
	<param name="file" value="c:/logs/spring-log.log"/>
	<param name="append" value="true"/>
	<param name="datePattern" value="yyyy-MM-dd"/>
	<layout class="org.apache.log4j.PatternLayout">
		<param name="ConversionPattern" 
		value="[%d{yyyy-MM-dd HH:mm:ss}] %-5p : [%l] - %m%n"/>
	</layout>
</appender>
````
- layout은 어떤형식으로 출력할지를 정하는 태그다.
- appender의 class는 필요한것을 찾아서 사용하면된다.

<br/>
- 하나의 로고에서만 사용하고싶다면 아래처럼해주자
```xml
<logger name="com.bs.spring">
	<level value="error" />
	<appender-ref ref="fileAppender"/>
</logger>
```
![image](https://github.com/inhoru/TIL/assets/126074577/1ed1c27d-7984-4b58-a487-67e719a4435d)
- 이런식으로 로그가 파일로남는다.

<br/>

# 4. slf4j
- 우리가 모든 controller에서 일일이 Logger을 선언하지않고 lombok에있는 @Slf4j를 클래스위에 어노테이션 설정해주면 자동으로 만들어준다.

```java
@Slf4j
public class MemberController {
	@PostMapping("/insertMember.do")
	public String insertMember(@Validated Member m,BindingResult bindResult, Model model) {
		String oriPassword=m.getPassword();
		//System.out.println(oriPassword);
		log.debug(oriPassword);
```

- log.debug로 출력할수가있다.

<br/>








