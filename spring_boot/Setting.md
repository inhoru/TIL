## 🔖 목차
1. [boot프로젝트 생성하는 법](#1-boot프로젝트-생성하는-법)<br/>
2. [jasper](#2-jasper)<br/>
3. [yml](#3-yml)<br/>
4. [mybatis](#4-mybatis)<br/>






<br/>

# 1. boot프로젝트 생성하는 법

## spring.io 홈페이지에서 initializer기능을 이용한다 -> zip파일로 받아 import
- https://start.spring.io/ 사이트에서 다운이가능하다.

![image](https://github.com/inhoru/TIL/assets/126074577/bbcf94cd-f430-4ace-9261-259a8b4bb094)

<br/>

-
<br/>


## IDE 에서 strater프로젝트를 생성한다.

- 프로젝트 생성


![image](https://github.com/inhoru/TIL/assets/126074577/051c0d75-43dd-4657-a1cb-33b296fcc862)

<br/>

- 프로젝트 설정


![image](https://github.com/inhoru/TIL/assets/126074577/eb63eb06-aa39-4cca-9397-93a08496cafc)

- type : 빌드타입을 뜻한다.



<br/>


- 버전설정

![image](https://github.com/inhoru/TIL/assets/126074577/acd7632e-31b0-421a-9906-3ce41b8ae796)


- 사용자의 jdk에따라 버전을 설정해주자
- Spring boot DevToole : 개발의에 필요한 유용한기능을 넣어둔 라이브러리다
- 나중에 프로젝트만들떄 필요한 의존성 필요한 라이브러리가필요할떄 체크해서 넣어주면된다.

<br/>

- 자주쓰는 라이브러리

![image](https://github.com/inhoru/TIL/assets/126074577/442c9d62-2635-4d7e-8357-896185471cac)

- 프로젝트만들때 라이브러리를 설정하지못한게있다면
- add starters 를눌러서 넣어줄수있다.

![image](https://github.com/inhoru/TIL/assets/126074577/80cffaae-6c03-4868-8cc2-3c267f77f6ee)


<br/>


## application.properties
- 각종설정할수있는곳
- ![image](https://github.com/inhoru/TIL/assets/126074577/1f7705c8-0a16-417a-a63a-9d321f397d6f)


## boot서버관리
![image](https://github.com/inhoru/TIL/assets/126074577/0d825f33-1dab-4b21-a027-fb7f38ea0e5f)


<br/>

# 2. jasper
- 프론트페이지를 jsp로 연결하려면 추가 의존성 등록을 해줘야한다.
- tomcat-emded-jasper 모듈등록

![image](https://github.com/inhoru/TIL/assets/126074577/1b0b348e-2dac-4025-9dfe-7c11a86fc4f9)

- 버전은 아무거나상관없다 버전은 안쓸거기때문이다.
- 의존성등록을 완료했다면 될거같지만 그게끝이아니다.


<br/>

## jsp연결을 위한 viewresolver설정하기
- application.properties 에서 viewresolver에서 설정해줘야한다.

```
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

<br/>

# 3. yml
- yml은 개행 , 띄어쓰기와  : 개행 을 기준으로 계층을 구분한다.
- 불필요한 코드의 반복을 피할수가있다.

![image](https://github.com/inhoru/TIL/assets/126074577/d7d95566-693d-478d-951b-5c489cb22cc2)



- 왼쪽이 properties 오르쪽이 yml이다.
- 왼쪽이 한눈에보기도좋고 가독성이좋다
- 자기가 쓰기편한걸 사용하며된다.

<br/>

# 4. mybatis
- spring에서 mybatis를 사용할려면 라이브러리를 pom.xml에 의존성등록을해줘야하지만
- spring에서 제공하기때문에 위에서 프로젝트만들때 설정을해줫다면 의존성등록이되어있다.
- 따라 설정만해주면된다.

<br/>

## mybatis설정
- application.yml 에 먼mappers와 config를 설정해주자

```
#mybatis설정하기
mybatis: 
  mapper-locations: classpath:/mappers/**/*.xml
  config-location: classpath:/config/mybatis-config.xml
```

<br/>

- 설정을 마쳣다면 resources밑에 mppaers-xml과 config.xml 을만들어서 사용해주자


<br/>

- mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd" >
<configuration>
	
	<typeAliases>
		<typeAlias type="com.bs.hello.boot.dto.MemberDto" alias="memberDto"/>
	</typeAliases>


</configuration>

 ```
<br/>

- mapper.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="member">

	<select id="selectMemberAll" resultType="memberDto">
		SELECT * FROM MEMBER
	</select>
</mapper>
```

<br/>

![image](https://github.com/inhoru/TIL/assets/126074577/1f9172bc-453e-4775-8e55-fc66c5457ddb)

<br/>



 




