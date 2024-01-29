# JavaScript / Mybatis

&nbsp; - React 프로젝트 전, 재정리 <br> <br>
&nbsp; ※ 기능 <br>
&nbsp; - 페이징, 검색 <br>
&nbsp; - 유저 (등록, 조회) / 게시글 (등록, 조회, 수정, 삭제) / 댓글 (등록, 조회, 수정, 삭제) <br><br>

<div align="center">
        <img width="100%" src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/a2906d77-951c-41af-a72d-d75d81499577"/>
</div>
<br> <br> <br> <br>
<div align="center">
        <img width="90%" src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/3d66ec7f-6190-4f98-92a2-978caa6a9ebc"/>
</div>

<br> <br>

## 기술 스택

### Front-End 
![HTML5](https://img.shields.io/badge/HTML5-%23E34F26.svg?style=flat-square&logo=html5&logoColor=white) 
![CSS3](https://img.shields.io/badge/CSS3-%231572B6.svg?style=flat-square&logo=css3&logoColor=white) 
![JavaScript](https://img.shields.io/badge/JavaScript-%23323330.svg?style=flat-square&logo=javascript&logoColor=%23F7DF1E) 
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F.svg?style=flat-square&logo=Thymeleaf&logoColor=white)

### Back-End
![Java](https://img.shields.io/badge/Java-007396.svg?style=flat-square&logo=openjdk&logoColor=white)
![SpringBoot](https://img.shields.io/badge/Spring_Boot-%236DB33F.svg?style=flat-square&logo=spring&logoColor=white) 
![SpringSecurity](https://img.shields.io/badge/Spring_Security-6DB33F?style=flat-square&logo=spring&logoColor=white)
![Mybatis](https://img.shields.io/badge/MyBatis-C70D2C.svg?style=flat-square)

### Tool
![IntelliJ](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?style=flat-square&logo=IntelliJ-IDEA&logoColor=white)


<br> <br>


## View / 소스코드

### 유저
<table>
  <tr>
    <th>내용</th>
    <th>사진</th>
  </tr>
  <tr>
    <td>회원가입 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
    <td><img src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/c1740bd7-2e2b-4a27-8179-34aba0a3917d" style="width:100%;height:auto;"></td>
  </tr>
  <tr>
    <td>&nbsp 로그인</td>
    <td><img src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/2b15d6e2-16f4-4f47-a61c-a8697322548d" style="width:100%;height:auto;"></td>
  </tr>
</table>

<br>

### 게시글
<table>
  <tr>
    <th>내용 &nbsp&nbsp&nbsp</th>
    <th>사진</th>
  </tr>
  <tr>
    <td>목록</td>
    <td><img src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/47476221-4e0d-4e5a-a11a-638279b36b51" style="width:100%;height:auto;"></td>
  </tr>
  <tr>
    <td>상세</td>
    <td><img src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/14ad804b-2eb7-4912-b895-a1b4d5f823df" style="width:100%;height:auto;"></td>
  </tr>
</table>

<br>

### 소스코드
<table>
  <tr>
    <th>내용 &nbsp&nbsp&nbsp</th>
    <th>사진</th>
  </tr>
  <tr>
    <td>패키지</td>
    <td>
      <div align="center">
        <img width="60%" src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/042063b4-afec-4346-872c-32104a429f62"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>mapper</td>
    <td>
      <div align="center">
        <img width="100%" src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/16bc98b5-3476-4a6a-8a30-29ac04884bed"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>페이징</td>
    <td>
      <div align="center">
        <img width="100%" src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/2123e4ca-79cf-4299-b013-ff016ca23ce7"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>&nbsp&nbsp검색</td>
    <td>
      <div align="center">
        <img width="80%" src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/f2c8004e-0f7d-4448-969b-b02d585b0573"/>
       </div>
    </td>
  </tr>
  <tr>
    <td>템플릿</td>
    <td>
      <div align="center"> 
        <img width="80%" src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/a6c3a047-857d-4dfa-9256-39d7a73ec336"/>
      </div> <br> 
      <div align="center"> 
          <img width="80%" src="https://github.com/aozp73/Js-Mybatis_Board-Paging-Searching/assets/122352251/180eb4a2-c9e6-4a61-b0ad-9aa26b49ee99"/> 
      </div>
    </td>
  </tr>
</table>

<br>

<br> <br>


## 라이브러리 

	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'

	// Security
	implementation 'org.springframework.boot:spring-boot-starter-security'

	// Validation
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springframework.security:spring-security-taglibs'

	// DB
	implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.3.0'
	runtimeOnly 'com.h2database:h2'

	// Template Engine
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect'
	implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'

	// Test
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter-test:2.2.2'
 
