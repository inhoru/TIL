# 🔖 목차

1. [screen](#1-screen)<br/>
2. [navigator객체](#2-navigator객체)<br/>
3. [history](#3-history)<br/>
4. [location](#4-location)<br/>



<br/>


## BOM : Browser에 대한 정보를 가지고 있는 객체들...

- 화면 : screen객체
- url : location객체
- 브라우저정보 : navigator객체
- 페이지이동이력 : history객체

<br/>

# 1. screen


- client의 화면에 대한 정보를 저장하는 객체

```javascript

<button onclick="screenInfo();">screen정보확인</button>
    <div id="screenInfo"></div>
    <script>
        const screenInfo = () => {
            console.log(window.screen);
            printData("screenInfo", screen);
            console.log(screen.width);
        }
        const printData = (id, obj) => {
            const container = document.getElementById(id);
            for (key in obj) {
                container.innerHTML += `${key} : ${obj[key]}<br>`;
                console.log(`${key} : ${obj[key]}`);
            }
        }
</script>
```

<br/>

# 2. navigator객체

```javascript
<button onclick="naviInfo();">navigator정보확인하기</button>
    <div id="naviinfo"></div>
    <p>클라이언트위 위치정보를 가져오는 기능을 제공 -> 좌표</p>
    <button onclick="positionPrint();">나의위치정보가져오기</button>
    <div id="myPosition"></div>
    <script>
        const positionPrint = () => {
            navigator.geolocation.getCurrentPosition((position) => {
                console.log(position);
                document.getElementById("myPosition").innerHTML = `<h2> 위도 : ${position.coords.latitude}, 경도 : ${position.coords.longitude}</h2>`;
            });
        }
        const naviInfo = () => {
            console.log(navigator);
            printData("naviinfo", navigator);
        }

```

<br/>


# 3. history
```javascript
 <button onclick="historyInfo();">페이지이동이력확인</button>
    <div id="historyInfo"></div>
    <script>
        const historyInfo = () => {
            printData("historyInfo", history);
        }
</script>

```

<br/>

# 4. location

-  url창에 대한 정보를 관리하는 객체
- 페이지를 이동(요청)시키거나, 갱신하는 기능을 제공함.
- 페이지를 이동하는 방식
- location.href속성을 변경하기 -> url주소
- location.assign("url주소"); -> 이전페이지로 이동할 수 있음
- location.replace("url주소"); -> 이전페이지로 이동을 못함.
- location.reload(); -> 페이지를 새로고침 (F5, ctrl+r);


<br/>

```javascript
<button onclick="locationInfo();">이동하기</button>
    <div class="locationInfo"></div>
    <h3>메뉴</h3>
    <nav>
        <ul>
            <li onclick="location.href='http://youtube.com'">
                <h4>유튜브</h4>
            </li>
            <li onclick="location.assign('http://google.com')">
                <h4>구글</h4>
            </li>
            <li onclick="location.replace('http://tmon.co.kr')">
                <h4>티몬</h4>
            </li>
            <li>
                <input type="search" id="keyword"><button onclick="searchNaver()">검색하기</button>
            </li>
        </ul>
    </nav>
    <script>
    // 검색하는 
        const searchNaver=()=>{
            const value=document.getElementById("keyword").value;
            location.assign(`http://search.naver.com/search.naver?query=${value}`);
        }
        const locationInfo = () => {
            printData("locationInfo", location);
        }
    </script>
    <style>
        nav>ul>li>h3,
        nav>ul>li:hover {
            cursor: pointer;
        }
    </style>
    <button onclick="location.reload();">새로고침</button>
    <!-- location.assign("http://localhost:9090/semiproject/boarddetail.do?no=1") -->
```

<br/>


