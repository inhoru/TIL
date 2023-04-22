# 🔖 목차
1. [특징](#1.-특징)<br/>
2. [주의사항](#2-주의사항)<br/>
3. [속성](#3-속성)<br/>
4. [기본구조](#4-기본구조)<br/>


<br/>


## HTML
- 웹에서 정보를 표현할 목적으로 만든 마크업 언어이다.
- 웹 페이지를 작성하기 위해 사용되는 언어다 
- 웹 브라우저에게 보일 문자열과이를 감싸는 일종의 해석 기호인 태그들로 이루어진다.

<BR/>

# 1. 특징

- 구조적 설계 지원(시멘틱) - 그래픽 및 멀티미디어 기능 강화
- CSS3 및 Javascript 지원
- 다양한 API 제공
- 모바일 웹 지원 및 장치 접근 가능(배터리 정보, 카메라, GPS 등) - 웹 브라우저가 서버와 양방향 통신 가능
- 인터넷이 연결되지 않은 상태에서도 애플리케이션 동작


![구성요소](https://user-images.githubusercontent.com/126074577/233774489-370ed1ac-98b2-4f2c-8a36-067a7b95028e.png)


<br/>

# 2. 주의사항
- 태그는 대 · 소문자를 구분하지 않으나 소문자를 권장함
- 시작 태그로 시작하면 반드시 종료 태그로 종료
- 파일 확장자는 반드시 html 또는 htm으로 설정
- 문자의 공백은 몇 개를 입력하든 한 개만 인식하므로공백을 추가하기 위해서 특수기호 &nbsp;를 이용해야 함

<br/>


# 3. 속성

- \<html> \</html>
- 문서 시작, 끝 표시 
- ang은 이 페이지가 어느 나라 언어로 되어있는지를 의미

  - html 뒤에 붙는 lang을 속성이라고 한다.
  - ex) html lang=“ko”                                     
  
  
  
  
![속성값](https://user-images.githubusercontent.com/126074577/233774583-52950864-fa1c-492f-aace-c789d335e4fe.png)
  
  
<br/>

  
# 4. 기본구조

## head

- 기본적인 html에 대한 정보를 작성하는 부분
- 정보 : \<meta>태그 이용 -> 내부적으로 통신시 필요한 내용설정
- **외부파일을 불러오기 : \<link>태그이용 * css파일을 불러올때 사용**
- **스타일코드작성 : \<style>태그이용  필수, boby에도 쓸 수 있음**
- **script문작성 및 불러오기: \<script>태그이용**
- **창에 대한 제목설정 : \<title>태그이용**       

<br/>

***
 <!-- 페이지에 대한 언어설정하기 -->
      <meta http-equiv="content-language" content="ko"/>
      <!-- 페이지에 문서형식(MIME TYPE),인코딩형식 설정하기 -->
      <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    </head>
        <!-- 페이지 인코딩은 http-equiv말고 charset속성을 이용할 수 있음 -->
        <meta charset="utf-8"/>
        <!-- 페이지 작성에 대한 정보를 설정 -->
        <meta name = "application-name" content="html"/>
        <meta name = "author" content="bsyoo"/>
        <meta name = "description" content="html에 대한 기본설정"/>
        <meta namme = "generator" content="vscode"/>
        <meta name = "keywords" content="html,화면,web,webpage구조"/>
        <!-- 반응형관련 사이즈설정 -->
        <meta name = "viewprot" content="width=device-width,inital-scale=1.0"/>

        <title>나의 첫페이지!!</title>
        
***

<br/>
![구조](https://user-images.githubusercontent.com/126074577/233774632-83d7375a-52fe-4156-897d-ba7e2cd89865.png)
  
  
  
  
  