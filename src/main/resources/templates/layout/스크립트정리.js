$(document).on("click", "#clickedImg", function (e) {
    var src = $(this).find("img").attr("src");
    var ogsrc = src.split("/")[3];
    console.log(ogsrc);
    $("#click-modal-slide-thumb").empty();
    $("#click-modal-slide").empty();
    $("#prev-next-btn").empty();
    $("#prev-next-btn").append(`<div class="swiper-button-prev"></div><div class="swiper-button-next"></div>`);
    makeNewSlider();
    clickedSwiperOpen();

    $("#click-modal-slide").append(`<div class="swiper-slide" id="main-image"><img src="` + src + `" alt=""/></div>`);
    $("#click-modal-slide-thumb").append(`<div class="swiper-slide"><img src="` + src + `" alt=""/></div>`);

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

    console.log("이미지 클릭중===============");
    imgModal.show();

    $.ajax({
        url: "/hitProcess",
        type: "post",
        dataType: "json",
        data: { original: ogsrc },
        success: function (data) {
            if (data == 0) {
            } else {
            }
        },
    });
});
