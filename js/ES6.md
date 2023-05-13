# 🔖 목차
1. [문자열 탬플릿이용하기](#1-문자열-탬플릿이용하기)<br/>
2. [null undefinded형 처리하는 연산자](#2-null-undefinded형-처리하는-연산자)<br/>
3. [전개연산자](#3-전개연산자)<br/>
4. [구조분해할당](#4-구조분해할당)<br/>
5. [class예약어 사용하기](#5-class예약어-사용하기)<br/>



<br/>

# 1. 문자열 탬플릿이용하기
- 문자열과 변수를 같이 문자열로 출력할때 +연산을 이용해서 연결연산을 해야한다.<br>
- 예) "안녕 "+name+"아!";
- 문자열 템플릿을 이용해서 처리하면 간편하게 연결할 수 있다.<br>
- 백틱(``)을 이용해서 문자열을 표시할 수 있다.<br>
- 예) `안녕 ${name} 아!`;
- 주의! jsp에서는 문자열 템플릿을 사용할 수 없다! html페이지내부에서....
- 별도의 js파일에서는 사용이 가능

```javascript
 <div id="strContainer"></div>
    <script>
        //원래는 이렇게 +를사용했다.
        let name = "유지승";
        const $strContainer = document.getElementById("strContainer");
        $strContainer.innerHTML = "<h3>" + name + "</h3>";
        
        //백틱으로 사용가능
        $strContainer.innerHTML += `<h3>${name}</h3>`;
        let su = 10;
        let su2 = 20;
        $strContainer.innerHTML += `<h4>${su + su2}</h4>`;

        //객체, 배열에 값에 접근하기
        let obj = { name: "유지승", age: 19 };
        let arr = [1, 2, 3, 4, 5];
        $strContainer.innerHTML += `<h3>${obj.name}          ${obj['age']} </h3>`;
        $strContainer.innerHTML += `<h4>${arr[0]}          ${arr[1]}</h4>`;

        //문자열템플릿에서 함수호출하기
        const print = () => "함수반환하기";
        $strContainer.innerHTML += `<h4>${print()}</h4>`;
        $strContainer.innerHTML += `<h4>${su > 5 ? "크다" : "작다"}</h4>`;
    </script>
``` 

<br/>

# 2. null undefinded형 처리하는 연산자
- ?? : null, unfined형에 대해 대체값을 지정하는 연산자<br />
- 값(변수,함수반환값)??대체할값
- ?. : 객체에 접근했을때 속성에 접근했을때 속성이 없을때 undefinde로 처리할 수 있는 연산자

```javascript

 <script>
        let val;
        let val2 = null;
        console.log(val);
        console.log(val2);
        console.log(val ?? "값이 없음!");
        console.log(val2 ?? "홍길동");
        val = {
            name: "유지",
            hobby: ["코딩", "독서", "영화보기"],
            item: {
                name: "책",
                price: "18000"
            },
            toString: function () { alert('실행'); }

        }
        console.log(val.name);
        //console.log(val.toString());
        console.log(val.test?.());
        console.log(val.gender ?? "남");
    </script>

```

<br/>

# 3. 전개연산자
- 나열형 자료를 추출하거나 연결할때 사용하는 연산자 -> 배열, 객체에 활용
- 매개변수에 순차적으로 값을 대입할때 사용
- ...변수명

```javascript

let arr = [1, 2, 3, 4, 5];
 console.log(arr);
        console.log(...arr);

        function testFunc(su, su1, su2, su3, su4, su5) {
            console.log(`${su} ${su1} ${su2} ${su3} ${su4} ${su5}`);
        }
        testFunc(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
        //전개연산자를 이용하면 편리하게 대입할 수 있다.
        testFunc(...arr, 100);
        //배열을 복사할때 사용할 수 있음
        let arrcopy = [];
        arr.forEach(e => arrcopy.push(e));
        console.log(arrcopy);
        //간단한방식으로 전개연산이용
        let arrcopy2 = [...arr];
        console.log(arrcopy2);
        arrcopy2[0] = 100;
        console.log(arr);//얕은복사
        console.log(arrcopy2);//깉은복사

        let animal = ["강아지", "고양이", "사자", "호랑이"];
        arrcopy = [...arr, ...animal];
        console.log(arrcopy);

        //객체에서 전개연산 활용하기
        let person = { name: "유병승", age: 10, gender: "남" };
        let testObj = { title: "데이터", sample: [1, 2, 3, 4], item: { name: "연필", price: 100 } };
        //객체에 사본을 생성할때 ... 연산이용하기
        let copyPerson = { ...person };
        console.log(copyPerson);

        //두개이상의 객체를 복사할때도 사용할 수 있다.
        let manyObj = { ...person, ...testObj };
        console.log(manyObj);

        //객체를 복사하고 속성에 원하는 값으로 대입시키기
        copyPerson = {
            ...person,
            gender: "여"

        }
        console.log(copyPerson);
        copyPerson = {
            ...manyObj,
            sample: [10, 20, 30],
            item: function () { console.log("변경한 함수") }
        }
        copyPerson.item();
        console.log(copyPerson);

```

<br/>

# 4. 구조분해할당
- 배열, 객체의 값을 각 변수에 분할해서 저장하는 것
- 매개변수 순차적으로 들어간다
- 매개변수 default값을 설정할수가있다.
- 

```javascript

// 원래하던방식
  let height = [166.7, 172.3, 174.5, 178.2, 180.5, 190.2];
        let a = height[0];
        let b = height[1];
        let c = height[2];
        console.log(`${a} ${b} ${c}`);

//구조분해할당을 이용하면 쉽다.
        let [n1, n2, n3] = height;
        console.log(`${n1} ${n2} ${n3}`);
        [n1, n2, n3, ...other] = height;
        console.log(`${n1} ${n2} ${n3} ${other}`);
        //나머지값은 배열로 저장이된다.
        console.log(other);
        //구조분해할당당시 default값 선언하기

        let [first, second, third, fourth = "돼지", fifth = "도마뱀"] = animal;
        console.log(`${first} ${second} ${third} ${fourth} ${fifth}`);

        function Student(name, grade, classNum, num, gender) {
            this.name = name;
            this.gender = grade;
            this.classNum = classNum;
            this.num = num;
            this.gender = gender ?? "남";
        }
        let students = [
            new Student("이승준", 3, 2, 1),
            new Student("홍지가", 3, 2, 2),
            new Student("윤지남", 3, 2, 3),
            new Student("정전주", 3, 2, 4),
            new Student("윤지어", 3, 2, 5),
        ];
        
        //...아무거나 변수명  ...만잇음된다.
        // ... 은배열로 저장
        let [lee, hong, yoon, ...otherStudent] = students;
        console.log(lee);
        console.log(hong);
        console.log(yoon);
        console.log(otherStudent);

        //객체도 구조분해할당을 적용할 수 있다.
        //key와 동일한 이름에 대입한다.
        let { classNum, num, gender = '여' } = lee;
        console.log(`${classNum} ${num} ${gender}`);


```

<br/>

# 5. class예약어 사용하기
- 멤버변수(필드), 멤버함수, 생성자, static변수 , 메소드 등 설정
- java처럼 클래스를 선언할 수 있게 만들었음
```javascript
 class Shape {
            //생성자 선언
            constructor(x = 0, y = 0) {
                //필드,멤버변수선언() -> 속성
                this.x = x;
                this.y = y;
                console.log("생성자 실행");
            }
            //속성설정하기 -> let, const, var 예약어를 사용하지않는다.
            name = "유바조바";
            score = [100, 80, 70, 90];
            test = function () {
                console.log(`shape의 test함수`);
            }

            //멤버메소드선언 -> functio 예약어는 사용하지않는다.
            toString() {
                return `${name} ${score} ${this.x} ${this.y} `
            }
            move(x, y) {
                this.x = x;
                this.y = y;
            }
            getPosition() {
                return `${this.x} : ${this.y}`;
            }

            //클래스내부에 static선언하기
            static staticVar = "스테틱변수";
            static staticFunc() {
                return "스테틱함수";
            }
        }
        let s = new Shape(100, 200);
        console.log(s);
        //선언된 객체의 속성에 접근하기
        console.log(s.x);
        console.log(s['y']);
        console.log(s.name);
        s.x = 200;
        s.y = 600;
        s.name = " 안자";
        console.log(s);
        //함수 호출하기
        s.move(100, 200);
        console.log(s);
        let result = s.getPosition();
        console.log(result);

        // Shape.name="유바자";
        // console.log(Shape.name);
        console.log(Shape.staticVar);
        Shape.staticVar = "김기저";
        console.log(Shape.staticVar);
        result = Shape.staticFunc();
        console.log(result);
        Shape.staticFunc = "안녕";
        //값을넣어서 덮어쓰기가됨 더이상함수가 아니게된다.
        console.log(Shape.staticFunc);

```

<br/>

## 클래스를 상속하기

- extends 부모클래스명
- 자바의 상속이랑 비슷하다.
- 잘사용하지않으니 알고만있자


```javascript
 <script>
        class Circle extends Shape{
            constructor(x,y,radius){
                super(x,y);
                this.radius=radius;

            }
            area(){
                return this.x*this.y*this.radius;
            }
            toString(){
                return "자식꺼 실행";
            }
        }
        let circle =new Circle(10,20,3.2);
        console.log(circle);
        console.log(circle.area());
        console.log(circle.toString());
    </script>
```









