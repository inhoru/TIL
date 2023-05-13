# 🔖 목차
1. [새창만들기](#1-새창만들기)<br/>

<br/>

## 윈도우객체 이용하기

-  브라우저(창)가 실행되면 기본적으로 생성되는 객체<br/>
- 한개 창마다 한개의 window객체가 생성된다.<br/>
- window는 최상위객체 <br/>
- 자식으로 BOM객체, DOM객체를 가진다.<br/>
- BOM : 브라우저를 다루는 객체들 -> location,navigator, history,screen
- DOM : html문서를 다루는 객체 -> document, (Element)객체를 이용


# 1. 새창만들기
- window.open(param1,param2,param3);
- 창을 열었을때 연결될 url주소를 설정
- 창으로 여는 방법(새창,기존창을 이용) -> _self,_blank, 명칭
- 창에 대한 옵션(크기, 위치 ,창 메뉴설정 등)
- return : 생성된 창의 window객체를 반환
        

```javascript
<button onclick="createWin();">새창</button>
    <script>
        const createWin=()=>{
            //윈도우객체는 생략가능
            //window.open();
            //open();
            //원하는 주소로 새창열기
            //open("http://www.gdu.co.kr");
            // open("http://www.gdu.co.kr","_self");
            //open("http://naver.com","_blank","width=1440,height=1280,top=500,left=100");
            const childWin=open("12_ES6문법.html","_blank","width=500,height=900");
            //보통위에방식대로안하고 아래방식대로한다.
            // /프로젝트명/서비스주소.do
            //open함수는 window객체를 반환한다.
            console.log(childWin);
            childWin.document.write("<h1>우하하 내가 쓴 문구</h1>");

        }
    </script>
    ```
