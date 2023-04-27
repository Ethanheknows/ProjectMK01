# ProjectMK01

## Meme generator
> <b>일본 취업 it 6기 최종 프로젝트</b><br>
> <b>개발기간:2023.04월</b> <br>

## 배포 주소
><b>AWS: </b>

## 웹개발팀 소개
> + 김민상
> + 백명현
> + 장익규 

## 프로젝트 소개

> ### meme generator will help you make your own meme
> You can make your own memes through meme generator and make the latest fashionable memes<br>
> according to the guidelines.You can also download it as png or jpg

> ### You can show off your own meme on the meme generator
> The meme generator allows you to create and share memes that you have made and comment.</br>
> Also, you can distribute it to other friends through Kakao Talk.

## Stacks

<div>

### Development Enviroment
 <img src="https://img.shields.io/badge/vscode-007ACC?style=for-the-badge&logo=visualstudiocode&logoColor=white">
 <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
 <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">
</div>


<div>

### Used Language
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
    <img src="https://img.shields.io/badge/sass-CC6699?style=for-the-badge&logo=Sass&logoColor=white">
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
</div>

<div>

### Libraries
  <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
  <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
</div>

<div>

### Server
<img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=white">
<img src="https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white">
</div>

<div>

  ### Software Configuration Management

  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
</div>

## 화면 구상

|   메인   |   회원가입   |   로그인   |
|---|---|---|
|<img src="https://user-images.githubusercontent.com/57060166/234784654-508e59a0-3f38-408e-9e84-7be3188daac4.png" width="320" height="180">|<img src="https://user-images.githubusercontent.com/57060166/234784954-762edcbb-5790-45bb-bcd6-c616c56b7ed3.png" width="320" height="180">|<img src="https://user-images.githubusercontent.com/57060166/234785385-a4bb664d-c131-4cc5-9808-497cd6953f90.png" width="320" height="180">|

|   메인 이미지 클릭시   |   info   |   modify   |
|---|---|---|
|<img src="https://user-images.githubusercontent.com/57060166/234787579-77325310-131e-4bfd-b6a7-90d642c03933.png" width="320" height="180">|<img src="https://user-images.githubusercontent.com/57060166/234787716-8f79dd6f-e05d-423c-8fa8-b9b642f762e0.png" width="320" height="180">|<img src="https://user-images.githubusercontent.com/57060166/234787906-dfacd50e-f468-4f55-b22d-e04773ab3533.png" width="320" height="180">|


|   delete   |   generator   |   Customizing memes   |
|---|---|---|
|<img src="https://user-images.githubusercontent.com/57060166/234788172-6895998c-8237-4d57-8ebb-adfd94fd7d19.png" width="320" height="180">|<img src="https://user-images.githubusercontent.com/57060166/234788299-87e1d631-3b15-4bd5-be4d-6c5b6733a23c.png" width="320" height="180">|<img src="https://user-images.githubusercontent.com/57060166/234788417-d4a3ace1-dea9-46f1-880b-2b2adc02a3d6.png" width="320" height="180">|

|tags|   click tag   |   manage image   |    
|---|---|---|
|<img src="https://user-images.githubusercontent.com/57060166/234790199-526d78d2-3807-4b05-a73d-299c6e0ec61b.png" width="320" height="100">|<img src="https://user-images.githubusercontent.com/57060166/234789050-b31ebd75-673b-4d0f-8ac5-b80d6cea7793.png" width="320" height="180">|<img src="https://user-images.githubusercontent.com/57060166/234788891-86bedcc7-9af0-44a5-b9ce-3356baa4eb01.png" width="320" height="180">|



## Main Function
 
> ### 태그 클릭시 그 태그에 맞는 이미지들로 재정렬
>   + manager가 이미지를 삽입 할 때,tag를 입력 하면 mainpage에 tag가 띄워진다.
>   + 그 tag를 클릭 할 시 공통적으로 tag가 걸려있는 모든 이미지들이 newest 아래에 정렬되어 출력된다. 
   
>### 밈 생성기능
>   + 이미지를 클릭하여 generate page로 들어가면 클릭한 이미지에 대해서 편집할 수 있다.
>   + 편집한 후에는 png,jpg등으로 저장 할 수있으며 upload 버튼을 통해 서버에 저장해 그 이미지에 대한 예시 자료로 사용되고 자신의 info 화면에서 나중에 다시 다운받을 수 있습니다. 
>   + kakao 공유를 통해 자신이 만든 이미지와 홈페이지를 공유 할 수 있습니다
   
> ### 댓글 생성기능
>   + main page 에서 이미지를 선택하면 그 이미지에 대하여 댓글을 적을 수 있습니다.
>   + login 한후 적은 댓글인 경우 삭제 할 수 있습니다. 












