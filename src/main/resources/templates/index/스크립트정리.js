  /*<![CDATA[*/
  const msg = /*[[${msg}]]*/;
  const title = /*[[${msg}]]*/;
  const param = /*[[${param}]]*/;
  const no = /*[[${param.no}]]*/;
  const session = /*[[${session}]]*/;
  const allImages = /*[[${allImages}]]*/;
  const getAllcomment = /*[[${getAllcomment}]]*/;
  const allcomments = /*[[${allcomments}]]*/;
  const orderByHitImages = /*[[${orderByHitImages}]]*/;
  const alluploads = /*[[${alluploads}]]*/;
  const getUploadOrignalPath = /*[[${getUploadOrignalPath}]]*/;
  const headerS = document.querySelector(".headerS");
  const memoModal = new bootstrap.Modal("#memoModal");
  const deleteModal = new bootstrap.Modal("#deleteModal");
  const imgModal = new bootstrap.Modal("#imgModal")
  const commentsModal = new bootstrap.Modal("#commentsModal")
  const footerS = document.querySelector(".footerS");





function email_check(email) {

var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

return reg.test(email);

}









// Trigger the scroll event to execute the code when the page loads









                              $(document).on("click", "#clickedImg", function (e) {
                                $("#commentBoard").empty();
                                for(i=0;i<allcomments.length;i++){
                                  $("#commentBoard").append(`<div>`+allcomments[i].contents+`</div>`);

                                }
                                var src = $(this).find("img").attr("src");
                                var ogsrc = src.split("/")[3];
                                $(".clickedModalTitle").empty();
                                $("#click-modal-slide-thumb").empty();
                                $("#click-modal-slide").empty();
                                $("#prev-next-btn").empty();
                                $("#prev-next-btn").append(`   <div class="swiper-button-prev"></div>
                                <div class="swiper-button-next"></div>`);
                                makeNewSlider();
                                clickedSwiperOpen();

                                $('#click-modal-slide').append(`<div class="swiper-slide" id="main-image"><img src="` + src + `" alt=""/></div>`)
                                $('#click-modal-slide-thumb').append(`<div class="swiper-slide"><img src="` + src + `" alt=""/></div>`)

                                for(i = 0; i < allImages.length; i++) {
                                    if(allImages[i].original == ogsrc ){
                                  $(".clickedModalTitle").append(`<h5>`+ allImages[i].title + `</h5>`)
                                    }

                                }

                                for (i = 0; i < getUploadOrignalPath.length; i++) {

                                  if (getUploadOrignalPath[i].originalPath.split("/")[3] == ogsrc) {
                                    console.log(i + ogsrc);
                                    $("#click-modal-slide-thumb").append(
                                      `<div class="swiper-slide">
                                        <img src="/upload/upload/` +
                                        getUploadOrignalPath[i].renamed +
                                        `" alt="" />
                                      </div>`
                                    );

                                    $("#click-modal-slide").append(
                                      `<div class="swiper-slide">
                                        <img src="/upload/upload/` +
                                      getUploadOrignalPath[i].renamed +
                                      `" alt="" class="col-md-4"/>
                                      </div>`
                                    );
                                  }
                                }

                                e.preventDefault();


                                imgModal.show();
                          function getTimeDifference(timeString) {
                                const time = new Date(timeString);
                                const now = new Date();
                                const diff = Math.floor((now - time) / 60000);
                                if (diff === 0) {
                                  return "방금 전";
                                } else if (diff === 1) {
                                  return "1분 전";
                                } else {
                                  return `${diff}분 전`;
                                }
                              }
                              const timeDifference = getTimeDifference(timeString);
                              let timeString   = response[i].regDate;
                                $.when(
                                  $.ajax({
                                  type: "POST",
                                  url: "/getAllCommets",
                                  success: function(response) {


                                    $("#commentBoard").empty();


                                    for(i=0;i<response.length;i++){
                                      if(src==response[i].original && response[i].available==1){



                                        $("#commentBoard").append(`<tr id="comments-tr`+i+`"></tr>`);
                                        $(`#comments-tr`+i).append(`<td class="hidden" id="delNo">`+response[i].no+ `</td>`);
                                        $(`#comments-tr`+i).append(`<td>`+response[i].nickName+ `</td>`);
                                        $(`#comments-tr`+i).append(`<td>`+response[i].contents+ `</td>`);
                                        $(`#comments-tr`+i).append(`<td>`+timeDifference+ `</td>`);
                                        if(session.board!=null &&(session.board.nickName==response[i].nickName || session.board.userId=="manager")  ){
                                         $(`#comments-tr`+i).append(`<td id="del"><span style="cursor:pointer;" class="material-icons"> clear</span></td>`);
                                        }
                                        $("#category02").addClass("hidden");
                                      }
                                    }
                                    // 모달의 내용을 업데이트합니다.
                                    document.getElementById("replyComment").value = "";

                                  }
                                  }),
                                  $.ajax({
                                  url : "/hitProcess" ,
                                  type : "post",
                                  dataType : "json",
                                  data : {"original" : ogsrc},
                                  success : function(data){
                                  if(data == 0){

                                  }else{

                                    }
                                  }
                                  })
                                  ).done(function() {
                                  // 두 개의 ajax가 모두 성공적으로 실행되면 실행할 코드
                                  });







                  });

//
$(document).on('click','#del',function(e){
var delId= this.parentNode.id
var guest = this.parentNode.querySelector("#delNo").innerHTML;


$.ajax({
url : "/delReply" ,
  type : "post",
  dataType : "json",
  data:{"no":guest},
  success : function(data){


      }
})








$("#"+delId).addClass("hidden");

})

$(document).on('click','#sendBtn',function(e){
var nickName=""
var src=$(".modal-body").find("img").attr("src");
if(!session.board){
nickName="guest";
}
else{
nickName=session.board.nickName;
}
console.log($("#replyComment").val());

$.ajax({
url: "/updatereply",
type: "POST",
data: {
"contents":$("#replyComment").val(),
"nickName": nickName,
"original": src},
success: function(response) {

$("#commentBoard").empty();


for(i=0;i<response.length;i++){
if(src==response[i].original && response[i].available==1){

  $("#commentBoard").append(`<tr id="comments-tr`+i+`"></tr>`);
  $(`#comments-tr`+i).append(`<td class="hidden" id="delNo">`+response[i].no+ `</td>`);

$(`#comments-tr`+i).append(`<td>`+response[i].nickName+ `</td>`);
$(`#comments-tr`+i).append(`<td>`+response[i].contents+ `</td>`);
$(`#comments-tr`+i).append(`<td>`+response[i].regDate+ `</td>`);
if(session.board!=null &&(session.board.nickName==response[i].nickName || session.board.userId=="manager")  ){
$(`#comments-tr`+i).append(`<td id="del"><span style="cursor:pointer;" class="material-icons"> clear</span></td>`);
}
}
}
// 모달의 내용을 업데이트합니다.
document.getElementById("replyComment").value = "";
},
error: function(xhr, status, error) {
console.log(xhr.responseText);
}
});

})





$(document).on('click','#clickTag',function(e){
var selectTag=$(this).attr("value");
const element = document.getElementById('category02');

$(".swiper-slide").remove();

for(i = 0;i<allImages.length;i++){
var allTag= allImages[i].tag;

if(selectTag=="all"){
//addclass hidden
$("#category02").addClass("hidden");
if (!orderByHitImages[i].original.includes("gif")) {

$(".tag2").append(
// prettier-ignored
`<div class="swiper-slide"><a href="" id="clickedImg"><img src="/upload/jpg/` +
orderByHitImages[i].original +
`" alt="" /></a></div>`
);
}
//$(".category02").addClass("hidden");
if(!allImages[i].original.includes("gif")){

          $(".tag1").append(
              // prettier-ignored
              `<div class="swiper-slide"><a href="" id="clickedImg"><img src="/upload/jpg/` +
                  allImages[i].original +
                  `" alt="" /></a></div>`
                  );
        }else{
          $(".tagGif").append(
              // prettier-ignored
              `<div class="swiper-slide"><a href="" id="clickedImg"><img src="/upload/gif/` +
                  allImages[i].original +
                  `" alt="" /></a></div>`
                  );
              }

}else{

  if (element.classList.contains('hidden')) {
    $("#category02").removeClass("hidden");
      }
      const source = document.getElementById('selectTag');
      source.innerHTML = "#"+selectTag;
      if (!orderByHitImages[i].original.includes("gif")) {

        $(".tag2").append(
          // prettier-ignored
          `<div class="swiper-slide"><a href="" id="clickedImg"><img src="/upload/jpg/` +
            orderByHitImages[i].original +
            `" alt="" /></a></div>`
        );
      }
        if(!allImages[i].original.includes("gif")){
          if(allTag.includes(selectTag)){
          $(".tag3").append(
            // prettier-ignored
            `<div class="swiper-slide"><a href="" id="clickedImg"><img src="/upload/jpg/` +
                allImages[i].original +
                `" alt="" /></a></div>`
                );
            }
            $(".tag1").append(
              // prettier-ignored
              `<div class="swiper-slide"><a href="" id="clickedImg"><img src="/upload/jpg/` +
                  allImages[i].original +
                  `" alt="" /></a></div>`
                  );

        }else{

          if(allTag.includes(selectTag)){
          $(".tag3").append(
            // prettier-ignored
            `<div class="swiper-slide"><a href="" id="clickedImg"><img src="/upload/gif/` +
              allImages[i].original +
              `" alt="" /></a></div>`
          );}
          $(".tagGif").append(
                // prettier-ignored
            `<div class="swiper-slide"><a href="" id="clickedImg"><img src="/upload/gif/` +
                allImages[i].original +
                    `" alt="" /></a></div>`
                );
          }



      }


    }





   });








  if(msg){
    memoModal.show();

  }
  $("#btnDeleteAjax").on("click",function(e){

    //e.preventDefault();
    deleteModal.show();
    return false;
  });



  $("#generator").on("click",function(e){




    var src=$("#main-image").find("img").attr("src");
    const imageinfo = {
            src: src
    }
    localStorage.setItem("image-info", JSON.stringify(imageinfo));

//e.preventDefault();
});




  $(document).ready(function(){
    $(".nickName_confirm").on("focusout",function(){
      var id=$("#nickName").val();

             if(id==''||id.length==0){
               $('#nickName_div').html('<a" style="color:red">닉네임을 입력해 주세요.</a>')
               nickError="닉네임을 입력해 주세요.";
               return false;
             }

             $.ajax({
               url : "/nickNameCheck" ,
                   type : "post",
                   dataType : "json",
                   data : {"nickName" : $("#nickName").val()},
                   success : function(data){
                           if(data == 0){
                             $('#nickName_div').html('<a">사용가능한 닉네임입니다.</a>')
                           }else{

                             $('#nickName_div').html('<a" style="color:red">이미 사용중인 닉네임입니다.</a>')

   }
}
})
})

    $(".nickName_modify").on("focusout",function(){
      var id=$("#nickName").val();

             if(id==''||id.length==0){
               $('#nickName_div').html('<a" style="color:red">닉네임을 입력해 주세요.</a>')

return false;
}


             $.ajax({
               url : "/nickNameCheck" ,
                   type : "post",
                   dataType : "json",
                   data : {"nickName" : $("#nickName").val()},
                   success : function(data){
                           if(data == 0 ){
                             $('#nickName_div').html('<a">좋은 NICKNAME 이네요!</a>')

        }else if(id == session.board.nickName){
          $('#nickName_div').html('<a" >기존 사용하고 있는 닉네임입니다.</a>')
      }
        else{

                             $('#nickName_div').html('<a" style="color:red">이미 사용중인 닉네임입니다.</a>')
                             nickError="이미 사용중인 닉네임입니다."
                         }
                       }
             })
           })




    $(".id_confirm").on("focusout",function(){
      var id=$("#userId").val();

             if(id==''||id.length==0){
               $('#id_div').html('<a" style="color:red">아이디를 입력해 주세요.</a>')

               return false;
             }
             if(id.length<5){
               $('#id_div').html('<a" style="color:red">아이디를 5글자 이상 입력해 주세요.</a>')


return false;
}
$.ajax({
url : "/idCheck",
type : "post",
dataType : "json",
data : {"userId" : $("#userId").val()},
success : function(data){

        if(data == 0 ){
          $('#id_div').html('<a">사용가능한 ID입니다.</a>')

                    }else{
                      $('#id_div').html('<a" style="color:red">이미 사용중이거나 탈퇴한 ID입니다.</a>')

                  }
                }
      })
    })


    $(".userPw_confirm").on("focusout",function(){
      var id=$("#userPw").val();

console.log(id);




             if(id==''||id.length==0){
               $('#userPw_div').html('<a"  style="color:red" id="pw_null">비밀번호를 입력해 주세요.</a>')

               return false;
             }else{
               $('#userPw_div').html('<a" id="pw_null">비밀번호 입력이 완료되었습니다.</a>')



        return false
      }


    })
    $(".userPw_confirm").on("focusout",function(){
      var pwchk=$("#userPwCheck").val();
      var pw=$("#userPw").val();



             if(pw!= pwchk){
               $('#userPwCheck_div').html('<a" style="color:red" id="pwchk_diff">비밀번호가 일치하지 않습니다.</a>')


        return false

             }else{
               $('#userPwCheck_div').html('<a" id="pwchk_diff">비밀번호가 일치합니다.</a>')
               pwckError=""

        return true

      }


    })




    $(".userPwCheck_confirm").on("focusout",function(){
      var pwchk=$("#userPwCheck").val();
      var pw=$("#userPw").val();



             if(pw!= pwchk){
               $('#userPwCheck_div').html('<a" style="color:red" id="pwchk_diff">비밀번호가 일치하지 않습니다.</a>')


        return false

             }else{
               $('#userPwCheck_div').html('<a" id="pwchk_diff">비밀번호가 일치합니다.</a>')
               pwckError=""

        return true

             }
               if(pwchk==''||pwchk.length==0){
                 $('#userPwCheck_div').html('<a" style="color:red" id="pwchk_null">비밀번호를 입력해 주세요.</a>')
                 pwckError="비밀번호를 입력해 주세요."
               return false

               }else{
                 $('#userPwCheck_div').html('<a" id="pwchk_null">비밀번호 입력이 완료되었습니다.</a>')
                    pwckError=""

        return true


        }




    })

    $(".email_confirm").on("focusout",function(){
      var userEmail=$("#userEmail").val();


      if(userEmail==''||userEmail.length==0){
        $('#email_div').html('<a" style="color:red" id="email_null">이메일을 입력해 주세요.</a>')
        return false
      }else{
        $('#email_div').html('<a" id="email_null">이메일 입력이 완료되었습니다.</a>')

      }

      if(!email_check(userEmail)){
        $('#email_div').html('<a" style="color:red" id="email_null">이메일 양식을 지켜서 입력해 주세요.</a>')
        return false

      }else{
        $('#email_div').html('<a" id="email_null">이메일 입력이 완료되었습니다.</a>')
        return false

      }
    })




  })

$(".btnInfo").on("click",function(){
deleteModal.show();
const pw = session.board.userPw;
$("#deleteModal .modal-title").text("비밀번호를 입력해 주세요.");
$("#btnDeleteConfirm").on("click",function(e){
if($("#password").val()!=pw){

memoModal.show();
$("#memoModal .modal-title").text("비밀번호를 오류");
$("#memoModal .modal-body").text("비밀번호를 잘못 입력하셨습니다.");
return false;
}
$.ajax({
url : "/deleteAccountProcess" ,
type : "post",
dataType : "json",
data : {"nickName" : session.board.nickName,
        "userId" : session.board.userId,
        "userPw" : session.board.userPw
},
success : function(response){
  if(response.msg==="ok") {
      memoModal.show();
      $("#memoModal .modal-title").text("계정을삭제하였습니다.");
      $("#memoModal .modal-body").text("계정 삭제를 완료하였습니다.");
      $("#memoModal .memo-modal-button").on("click", function() {
        location.href = "/";
        });

  }else {
    memoModal.show();
    $("#memoModal .modal-title").text("계정삭제에 실패하였습니다.");
    $("#memoModal .modal-body").text("계정 삭제를 실패하였습니다. 다시 시도해주세요.");
  }
}
})




    })
  });



  // 모달 띄울때 맨 처음 사진으로 가게 하는 함수
  function makeNewSlider() {

    const clickedSwiperThumb = new Swiper(".clickedSwiperThumb", {
      spaceBetween: 10,
      slidesPerView: 4,
      watchSlidesProgress: true,
    });

    const clickedSwiper = new Swiper(".clickedSwiper", {
      slidesPerView: 1,
      spaceBetween: 10,
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },thumbs: {                       //added
        swiper:clickedSwiperThumb,

        //added
    },

    });

clickedSwiper.on('slideChange', function() {
console.log('현재 슬라이더 인덱스:', clickedSwiper.activeIndex);
});



    clickedSwiper.slideTo(0, 0, false)


  }
  function clickedSwiperOpen() {

      }
  /*]]>*/