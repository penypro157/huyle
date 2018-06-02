$(document).ready(function () {
    var request = $.ajax({
        type: 'GET',
        url: '/getbaidang?email=',
        cache: false,// serializes the form's elements.
        contentType: 'json',
        processData: false,
    }).done(function (data) {
        if (data != null) {
            hienthitatcabaidang(data);
        }
        else alert('có lỗi xảy ra.')
    });


})

function hienthitatcabaidang(data) {
    $.each(data, function (index, item) {
        var post = '                    <div class="panel panel-white post panel-shadow" id="baidang">\n' +
            '                        <div class="post-heading">\n' +
            '                            <div class="pull-left image">\n' +
            '                                <img src="/resources/image/hinhdaidien/' + item.hoSoTaiKhoan.anhDaiDien.duongDan + '" class="img-circle avatar" alt="user profile image">\n' +
            '<input hidden="hidden" value="'+item.id+'">' +
            '                            </div>\n' +
            '                            <div class="pull-left meta">\n' +
            '                                <div class="title h5">\n' +
            '                                    <a href="#"><b>' + item.hoSoTaiKhoan.tenHienThi + '</b></a>\n' +
            '                                    đăng một bài viết\n' +
            '                                </div>\n' +
            '                                <h6 class="text-muted time">' + hienthoigian(item.thoiGian) + '</h6>\n' +
            '                            </div>\n' +
            '                        </div>\n' +
            '                        <div class="post-description">\n' +
            '                            <p>' + item.noiDung + '</p>\n' +
            '                            <div class="stats">\n' +
            '                                <a href="#" class="btn btn-default stat-item" id="btn-thich">\n' +
            '                                    <i class="fa fa-thumbs-up icon"></i>' + item.luotThich + '\n' +
            '                                </a>\n' +
            '                                <a href="#" class="btn btn-default stat-item">\n' +
            '                                    <i class="fa fa-share icon"></i>' + item.luotBinhLuan + '\n' +
            '                                </a>\n' +
            '                            </div>\n' +
            '                        </div>\n' +
            '                        <div class="post-footer">\n' +
            '                            <div class="input-group">\n' +
            '                                <input class="form-control" placeholder="Add a comment" type="text">\n' +
            '                                <span class="input-group-addon">\n' +
            '                        <a href="#"><i class="fa fa-edit"></i></a>\n' +
            '                    </span>\n' +
            '                            </div>\n' +
            '                            <ul class="comments-list">\n' +
            '                                <li class="comment">\n' +
            '                                    <a class="pull-left" href="#">\n' +
            '                                        <img class="avatar" src="https://bootdey.com/img/Content/user_1.jpg" alt="avatar">\n' +
            '                                    </a>\n' +
            '                                    <div class="comment-body">\n' +
            '                                        <div class="comment-heading">\n' +
            '                                            <h4 class="user">Gavino Free</h4>\n' +
            '                                            <h5 class="time">5 minutes ago</h5>\n' +
            '                                        </div>\n' +
            '                                        <p>Sure, oooooooooooooooohhhhhhhhhhhhhhhh</p>\n' +
            '                                    </div>\n' +
            '                                    <ul class="comments-list">\n' +
            '                                        <li class="comment">\n' +
            '                                            <a class="pull-left" href="#">\n' +
            '                                                <img class="avatar" src="https://bootdey.com/img/Content/user_3.jpg" alt="avatar">\n' +
            '                                            </a>\n' +
            '                                            <div class="comment-body">\n' +
            '                                                <div class="comment-heading">\n' +
            '                                                    <h4 class="user">Ryan Haywood</h4>\n' +
            '                                                    <h5 class="time">3 minutes ago</h5>\n' +
            '                                                </div>\n' +
            '                                                <p>Relax my friend</p>\n' +
            '                                            </div>\n' +
            '                                        </li>\n' +
            '                                        <li class="comment">\n' +
            '                                            <a class="pull-left" href="#">\n' +
            '                                                <img class="avatar" src="https://bootdey.com/img/Content/user_2.jpg" alt="avatar">\n' +
            '                                            </a>\n' +
            '                                            <div class="comment-body">\n' +
            '                                                <div class="comment-heading">\n' +
            '                                                    <h4 class="user">Gavino Free</h4>\n' +
            '                                                    <h5 class="time">3 minutes ago</h5>\n' +
            '                                                </div>\n' +
            '                                                <p>Ok, cool.</p>\n' +
            '                                            </div>\n' +
            '                                        </li>\n' +
            '                                    </ul>\n' +
            '                                </li>\n' +
            '                            </ul>\n' +
            '                        </div>\n' +
            '                    </div>';
        $('#post-area').prepend(post);

    })


}