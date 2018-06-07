$(document).ready(function () {
    var file = document.getElementById("upload-image");
    $('#upload-image').on('change', function () {
        alert(file.files.length);
        for (var i = 0; i < file.files.length; i++) {
            if (isImage(file.files.item(i)))
                continue;
            else {
                alert("File không hỗ trợ định dạng");
                $("#upload-image").val('');
                break;
            }


        }
        alert(file.files.length);

        // for (var i = 0; i < files.length; i++)
        // {
        //     alert(files[i].name);
        // }

    })
    $('#form-upload-post').submit(function (e) {
        var noidung = $('#content-post').val();
        var form = $('#form-upload-post');
        var formData = new FormData(form[0]);
        alert(file.files.length);
        for (var i = 0; i < file.files.length; i++) {
            alert(file.files.item(i).name)


        }

        e.preventDefault();
        if ((noidung != '') || (file.files.length != 0))
            var request = $.ajax({
                type: 'POST',
                url: '/dangbai',
                data: formData,
                cache: false,// serializes the form's elements.
                async: false,
                contentType: false,
                processData: false,
            }).done(function (data) {
                if (data != "") {
                    $('#form-upload-post')[0].reset();
                    $('#home').prepend('<div class="col-sm-9"><div class="alert alert-success ">\n' +
                        '    <strong>Thành công!</strong> Đăng bài thành công, bài viết sẽ được hiển thị ngay bây giờ.\n' +
                        '<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>' +
                        '  </div>' +
                        '</div>')
                    hienthibaidang(data);
                }
                else alert('có lỗi xảy ra.')
            });
        else alert('Bạn chưa nhập nội dung');

    })

});

function isImage(file) {
    return (file['type'].split('/')[0] == 'image');
}

function hienthibaidang(data) {
    var mabaidang = ObjectId(data.id).toString();
    var currentemail = $('#currentemail').val();
    var editpost='';
    if (data.hoSoTaiKhoan.email == currentemail) {
        editpost = '<a href="#" ><i class=" glyphicon glyphicon-edit"></i></a>' +
            '<a href="#" onclick="deletepost(event,\''+mabaidang+'\')"><i class="glyphicon glyphicon-trash"></i></a>';
    }

    var dshinhanh = data.dsHinhAnh;
    var image = '';
    if (dshinhanh.length > 0) {
        $.each(dshinhanh, function (index, item) {

            content = '       <div class="post-image">\n' +
                '\n' +
                '                                        <img  src="/resources/image/' + item.duongDan + '" class="img-rounded" >\n' +
                '                                    </div> \n';
            image += content;

        })

    }
    var post = '                    <div class="panel panel-white post panel-shadow" id="' + mabaidang + '">\n' +
        '                        <div class="post-heading">\n' +
        '                            <div class="pull-left image">\n' +
        '                                <img src="/resources/image/' + data.hoSoTaiKhoan.anhDaiDien.duongDan + '" class="img-circle avatar" alt="user profile image">\n' +
        '                            </div>\n' +
        '                            <div class="pull-left meta">\n' +
        '                                <div class="title h5">\n' +
        '                                    <a href="#"><b>' + data.hoSoTaiKhoan.tenHienThi + '</b></a>\n' +
        '                                    đăng một bài viết\n' +
        '                                </div>\n' +
        '                                <h6 class="text-muted time">' + hienthoigian(data.thoiGian) + '</h6>\n' +
        '                            </div>\n' +
        '                            <div class="pull-right ">\n' + editpost +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="post-description">\n' +
        '                            <p>' + data.noiDung + '</p>\n' +
        '                              <div class="image-area">\n' + image +
        '                              </div>' +
        '                            <div class="stats">\n' +
        '                                <a href="" class="btn btn-default stat-item" onclick=" onClick(this,\'' + mabaidang + '\')">\n' +
        '                                    <i class="fa fa-thumbs-up icon"></i><p>' + data.luotThich + '</p>\n' +
        '                                </a>\n' +
        '                                <a href="" class="btn btn-default stat-item" >\n' +
        '                                    <i class="fa fa-comment icon"></i><p>' + data.luotBinhLuan + '</p>\n' +
        '                                </a>\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <div class="post-footer">\n' +
        '                            <div class="input-group">\n' +
        '                                <input class="form-control" placeholder="Add a comment" type="text">\n' +
        '<a href="" onclick=" getallBinhLuan(this,\''+mabaidang+'\',event)">Xem tất cả bình luận</a>\n' +
        '                                <span class="input-group-addon">\n' +
        '                        <a href="" onclick="onComment(this,event,\'' + mabaidang + '\')"><i class="fa fa-edit"></i></a>\n' +
        '                    </span>\n' +
        '                            </div>\n' +
        '                            <ul class="comments-list">\n' +
        '                            </ul>\n' +
        '                        </div>\n' +
        '                    </div>';

    $('#post-area').prepend(post);


}

function hienthoigian(thoigian) {
    var currentDate = new Date();
    var currentTime = currentDate.getTime();
    var lastTime = currentTime - thoigian;
    if (lastTime < (60 * 1000)) return "vừa xong";
    else {
        if (lastTime < (60 * 60 * 1000)) return getMinutesFromMiliSecond(lastTime) + ' phút trước';
        else {
            if (lastTime < (60 * 60 * 24 * 1000)) return getHoursFromMiliseconds(lastTime) + ' giờ trước';
            else return 'vào lúc ' + getDateTimeString(thoigian);
        }


    }
}

function getMinutesFromMiliSecond(miliseconds) {
    var minutes = Math.round(miliseconds / (60 * 1000));
    return minutes;


}

function getHoursFromMiliseconds(miliseconds) {
    var hours = Math.round(miliseconds / (60 * 60 * 1000));
    return hours;

}

function getDateTimeString(thoigian) {
    var date = new Date(thoigian);
    var day = date.getDay();
    var month = date.getMonth();
    var year = date.getFullYear();
    return day + '-' + month + '-' + year;

}