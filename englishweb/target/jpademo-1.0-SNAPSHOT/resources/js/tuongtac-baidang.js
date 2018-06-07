function onComment(btnelement,e, mabaidang) {
    e.preventDefault();
    var parent= $(btnelement).parents()[1];
    var input=$(parent).children()[0];
    var noidung= $(input).val();
    commentActivity(mabaidang,noidung);
    $(input).val('');
    var luotbinhluan= getLuotBinhLuan(mabaidang);
    showLuotBinhLuan(btnelement,luotbinhluan,mabaidang);
}
function commentActivity(mabaidang,noidung) {

    $.ajax({
        type: 'POST',
        async: false,
        url: '/comment?mabaidang='+mabaidang+'&noidung='+noidung,
        cache: false,// serializes the form's elements.
        contentType: 'json',
        processData: false,
    }).done(function (data) {
    showBinhLuan(data,mabaidang);

    });
}
function onClick(btnelement, mabaidang) {
   if($(btnelement).hasClass('active')) {
       $(btnelement).removeClass('active')
   }
   else $(btnelement).addClass('active');
    likeActivity(mabaidang);
   var luotthich= getLuotThich(mabaidang);
    showLuotThich(btnelement,luotthich);
}
function likeActivity(maBaiDang) {
    $.ajax({
        type: 'GET',
        async: false,
        url: '/thich?mabaidang='+maBaiDang,
        cache: false,// serializes the form's elements.
        contentType: 'json',
        processData: false,
    }).done(function (data) {

    });
    
}
function getLuotThich(maBaiDang) {

var luotthich=0;
    $.ajax({
        type: 'GET',
        async : false ,
        url: '/luotthich?mabaidang='+maBaiDang,
        dataType: 'json'
    }).done(function (data) {
        luotthich=data;

    })

return luotthich;
    
}
function getLuotBinhLuan(mabaidang) {
    var luotbinhluan=0;
    $.ajax({
        type: 'GET',
        async : false ,
        url: '/luotbinhluan?mabaidang='+mabaidang,
        dataType: 'json'
    }).done(function (data) {
        luotbinhluan=data;

    })

    return luotbinhluan;
}

function showLuotThich( btnthich, luotthich) {
  var x= $(btnthich).children()[1];
  $(x).html(luotthich);
}
function showLuotBinhLuan(btnbinhluan, luotbinhluan, mabaidang) {
    var postelement= $(btnbinhluan).closest('#'+mabaidang+'');
    var postdescription= $(postelement).children()[1];
    var postdescriptionfrm=$(postdescription).find('.stats');
    var a= $(postdescriptionfrm).children()[1];
    var x= $(a).children()[1];

    $(x).html(luotbinhluan);


}
function showBinhLuan(data,mabaidang) {
    var content=' <li class="comment">\n' +
        '                                        <a class="pull-left" href="/profile?email='+data.taikhoan.email+'">\n' +
        ' <img class="avatar" src="/resources/image/'+data.taikhoan.anhDaiDien.duongDan+'" alt="avatar">'+
        '                                        </a>\n' +
        '                                        <div class="comment-body">\n' +
        '                                            <div class="comment-heading">\n' +
        '                                                <h4 class="user">'+data.taikhoan.tenHienThi+'</h4>\n' +
        '                                                <h5 class="time">'+hienthoigian(data.thoiGian)+'</h5>\n' +
        '                                            </div>\n' +
        '                                            <p>'+data.noiDung+'</p>\n' +
        '                                        </div>\n' +
        '                                    </li>';
    var post= $('#'+mabaidang+'');
    var postfooter= $(post).children()[2];
    var commentlist= $(postfooter).children()[2];
    $(commentlist).prepend(content);

    
}
function getallBinhLuan(btnelement,mabaidang,e) {
    e.preventDefault();

    $.ajax({
        type: 'GET',
        async : false ,
        url: '/getcomment?mabaidang='+mabaidang,
        dataType: 'json'
    }).done(function (data) {
        if(data.length!=0){

            showAllBinhLuan(data,btnelement);

        }

    })
}
function showAllBinhLuan(data,commentarea) {
    var postfooter= $(commentarea).parents()[0];
    var commentlist=$(postfooter).children()[2];
    $(commentlist).text('');
    $.each(data,function (index, item) {
        var content=' <li class="comment">\n' +
            '                                        <a class="pull-left" href="/profile?email='+item.taikhoan.email+'">\n' +
            ' <img class="avatar" src="/resources/image/'+item.taikhoan.anhDaiDien.duongDan+'" alt="avatar">'+
            '                                        </a>\n' +
            '                                        <div class="comment-body">\n' +
            '                                            <div class="comment-heading">\n' +
            '                                                <h4 class="user">'+item.taikhoan.tenHienThi+'</h4>\n' +
            '                                                <h5 class="time">'+hienthoigian(item.thoiGian)+'</h5>\n' +
            '                                            </div>\n' +
            '                                            <p>'+item.noiDung+'</p>\n' +
            '                                        </div>\n' +
            '                                    </li>';

        $(commentlist).prepend(content);
    })


}
function deletepost(e,id) {
    e.preventDefault();
    if (confirm("Xác nhận xóa!")) {
        $.ajax({
            type: 'GET',
            async: false,
            url: '/deletebaidang?mabaidang=' + id,
            dataType: 'json'

        }).done(function (data) {
            if (data == true) alert("xóa thành công");
            else alert("có lỗi xảy ra");

        })

        var postelement = $('#' + id + '');
        $(postelement).remove();
    }
}