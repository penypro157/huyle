<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: huyl4
  Date: 5/21/2018
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<head>
    <title>Social Network</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/statusbox.css">
    <link rel="stylesheet" href="/resources/css/profile-css.css">
    <link rel="stylesheet" href="/resources/css/postframe.css">
    <link rel="stylesheet" href="/resources/css/post.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
</head>
<body>
<input hidden="" value="${email}" id="currentemail"/>
<hr>

<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <div style="max-width: 100px">
                <a class="active" href="/profile"><img src="/resources/image/symbol.png"></a>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="search-container">
                <form action="/timkiemthanhvien">
                    <p>Tìm theo</p>
                    <select name="muctimkiem">
                        <option value="email">Email</option>
                        <option value="tenhienthi">Tên hiển thị</option>
                    </select>
                    <input type="text" placeholder="Tìm liên hệ" name="noidung">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>
        <div class="col-sm-3">
            <div>
                <a href="/profile?email=${email}">Tài khoản</a>
                <a href="/logout">Đăng xuất</a>
            </div>
        </div>


    </div>


</div>


<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-3"><!--left col-->


            <div class="text-center">
                <img src="/resources/image/${hosotaikhoan.anhDaiDien.duongDan}" id="avatar"
                     style="max-height: 100% ; max-width: 100%"
                     class="avatar img-rounded img-thumbnail"
                     alt="avatar">


                <form id="upload-avatar" action="/uploadimage" method="POST" enctype="multipart/form-data">
                    <input type="file" class="text-center center-block file-upload" name="avatar-file"
                           id="fileimage-avatar"
                           hidden>
                    <c:if test="${hosotaikhoan.email == email}">
                    <input type="button" value="Đổi ảnh đại diện" onclick="openFile()"/>
                    </c:if>
                    <script>
                        function openFile() {
                            $('#fileimage-avatar').click();
                        }

                    </script>

                </form>
            </div>
            <!-- Bootstrap Progress bar -->

            <!-- Alert -->
            <div id="alertMsg" style="color: red;font-size: 18px;"></div>
            </hr><br>


            <ul class="list-group">
                <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Bài đăng</strong></span> ${soluongbaidang}
                </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Hình ảnh</strong></span> ${soluonghinhanh}</li>
            </ul>
            <c:if test="${hosotaikhoan.email != email}">
            <button class="btn-default glyphicon-plus">Kết bạn</button>
            </c:if>

        </div><!--/col-3-->
        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li><a data-toggle="tab" href="#home">Home</a></li>
                <li><a data-toggle="tab" href="#profile">Profile </a></li>
                <c:if test="${hosotaikhoan.email == email}">
                    <li><a data-toggle="tab" href="#messages">Change Password</a></li>
                </c:if>
            </ul>


            <div class="tab-content">

                <div class="tab-pane active" id="home">
                    <c:if test="${hosotaikhoan.email == email}">
                    <div class="col-sm-9"><%--Đây là form đăng bài--%>
                        <div class="widget-area no-padding blank panel-shadow">
                            <div class="status-upload">
                                <form action="/dangbai" method="POST" enctype="multipart/form-data"
                                      id="form-upload-post" accept-charset="utf-8">
                                    <textarea placeholder="Bạn đang nghĩ gì?" id="content-post"
                                              name="noidung"></textarea>
                                    <input type="file" multiple name="fileanh" hidden="hidden" id="upload-image">
                                        <ul>
                                            <li>
                                                <button type="button" class="btn-info" onclick="uploadimage()">Thêm ảnh
                                                </button>
                                            </li>
                                            <script>
                                                function uploadimage() {
                                                    $('#upload-image').click();
                                                }
                                            </script>
                                        </ul>
                                        <button type="submit" class="btn btn-success green" id="btn-upload-post"><i
                                                class="fa fa-share"></i>
                                            Post
                                        </button>
                                </form>
                            </div><!-- Status Upload  -->
                        </div>
                    </div><!-- Widget Area --><%--Đây là form đăng bài--%>

                    </c:if>
                    <div class="col-sm-9" id="post-area">
                        <div class="panel panel-white post panel-shadow"><%--đây là vùng hiển thị bài đăng--%>
                            <div class="post-heading">
                                <div class="pull-left image">
                                    <img src="https://bootdey.com/img/Content/user_1.jpg" class="img-circle avatar"
                                         alt="user profile image">
                                </div>
                                <div class="pull-left meta">
                                    <div class="title h5">
                                        <a href="#"><b>Ryan Haywood</b></a>
                                        made a post.
                                    </div>
                                    <h6 class="text-muted time">1 minute ago</h6>
                                </div>
                            </div>
                            <div class="post-description">
                                <p>Bootdey is a gallery of free snippets resources templates and utilities for bootstrap
                                    css hmtl js framework. Codes for developers and web designers</p>
                                <div class="image-area">
                                    <div class="post-image">

                                        <img src="/resources/image/${hosotaikhoan.anhDaiDien.duongDan}"
                                             class="img-rounded" alt="Cinque Terre">
                                    </div>
                                    <div class="post-image">

                                        <img src="/resources/image/${hosotaikhoan.anhDaiDien.duongDan}"
                                             class="img-rounded" alt="Cinque Terre">
                                    </div>
                                    <div class="post-image">

                                        <img src="/resources/image/${hosotaikhoan.anhDaiDien.duongDan}"
                                             class="img-rounded" alt="Cinque Terre">
                                    </div>
                                    <div class="post-image">

                                        <img src="/resources/image/${hosotaikhoan.anhDaiDien.duongDan}"
                                             class="img-rounded" alt="Cinque Terre">
                                    </div>


                                </div>


                                <div class="stats">
                                    <a href="#" class="btn btn-default stat-item active">
                                        <i class="fa fa-thumbs-up icon"></i>2
                                    </a>
                                    <a href="#" class="btn btn-default stat-item">
                                        <i class="fa fa-share icon"></i>12
                                    </a>
                                </div>
                            </div>
                            <div class="post-footer">
                                <div class="input-group">
                                    <input class="form-control" placeholder="Add a comment" type="text">
                                    <span class="input-group-addon">
                        <a href="#"><i class="fa fa-edit"></i></a>
                    </span>
                                </div>
                                <ul class="comments-list">
                                    <li class="comment">
                                        <a class="pull-left" href="#">
                                            <img class="avatar" src="https://bootdey.com/img/Content/user_1.jpg"
                                                 alt="avatar">
                                        </a>
                                        <div class="comment-body">
                                            <div class="comment-heading">
                                                <h4 class="user">Gavino Free</h4>
                                                <h5 class="time">5 minutes ago</h5>
                                            </div>
                                            <p>Sure, oooooooooooooooohhhhhhhhhhhhhhhh</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel panel-white post panel-shadow"> <%--đây là vùng hiển thị bài đăng--%>
                            <div class="post-heading">
                                <div class="pull-left image">
                                    <img src="https://bootdey.com/img/Content/user_1.jpg" class="img-circle avatar"
                                         alt="user profile image">
                                </div>
                                <div class="pull-left meta">
                                    <div class="title h5">
                                        <a href="#"><b>Ryan Haywood</b></a>
                                        made a post.
                                    </div>
                                    <h6 class="text-muted time">1 minute ago</h6>
                                </div>
                            </div>
                            <div class="post-description">
                                <p>Bootdey is a gallery of free snippets resources templates and utilities for bootstrap
                                    css
                                    hmtl js framework. Codes for developers and web designers</p>
                                <div class="stats">
                                    <a href="#" class="btn btn-default stat-item">
                                        <i class="fa fa-thumbs-up icon"></i>2
                                    </a>
                                    <a href="#" class="btn btn-default stat-item">
                                        <i class="fa fa-share icon"></i>12
                                    </a>
                                </div>
                            </div>
                            <div class="post-footer">
                                <div class="input-group">
                                    <input class="form-control" placeholder="Add a comment" type="text">
                                    <span class="input-group-addon">
                        <a href="#"><i class="fa fa-edit"></i></a>
                    </span>
                                </div>
                                <ul class="comments-list">
                                    <li class="comment">
                                        <a class="pull-left" href="#">
                                            <img class="avatar" src="https://bootdey.com/img/Content/user_1.jpg"
                                                 alt="avatar">
                                        </a>
                                        <div class="comment-body">
                                            <div class="comment-heading">
                                                <h4 class="user">Gavino Free</h4>
                                                <h5 class="time">5 minutes ago</h5>
                                            </div>
                                            <p>Sure, oooooooooooooooohhhhhhhhhhhhhhhh</p>
                                        </div>
                                        <ul class="comments-list">
                                            <li class="comment">
                                                <a class="pull-left" href="#">
                                                    <img class="avatar" src="https://bootdey.com/img/Content/user_3.jpg"
                                                         alt="avatar">
                                                </a>
                                                <div class="comment-body">
                                                    <div class="comment-heading">
                                                        <h4 class="user">Ryan Haywood</h4>
                                                        <h5 class="time">3 minutes ago</h5>
                                                    </div>
                                                    <p>Relax my friend</p>
                                                </div>
                                            </li>
                                            <li class="comment">
                                                <a class="pull-left" href="#">
                                                    <img class="avatar" src="https://bootdey.com/img/Content/user_2.jpg"
                                                         alt="avatar">
                                                </a>
                                                <div class="comment-body">
                                                    <div class="comment-heading">
                                                        <h4 class="user">Gavino Free</h4>
                                                        <h5 class="time">3 minutes ago</h5>
                                                    </div>
                                                    <p>Ok, cool.</p>
                                                </div>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <%--Đây là vùng hiển thị bài đăng--%>
                    </div>

                </div>


                <div class="tab-pane " id="profile">
                    <hr>

                    <form:form class="form" action="#" method="post" id="updateinfo"
                               modelAttribute="hosotaikhoan">
                        <div class="form-group">

                            <div class="col-xs-6 ">
                                <label><h4>Tên hiển thị</h4></label>
                                <form:input
                                        type="text" class="form-control" name="tenHienThi" path="tenHienThi"
                                            value="${hosotaikhoan.tenHienThi}" title="enter your phone number if any."/>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Họ</h4></label>
                                <form:input type="text" class="form-control" name="ho"
                                            value="${hosotaikhoan.ho}" path="ho"
                                            title="enter your first name if any."/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label><h4>Tên</h4></label>
                                <form:input type="text" class="form-control" name="ten"
                                            value="${hosotaikhoan.ten}" path="ten"
                                            title="enter your last name if any."/>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Số điện thoại</h4></label>
                                <form:input type="text" class="form-control" name="sodienthoai"
                                            value="${hosotaikhoan.sodienthoai}" path="sodienthoai"
                                            id="phone" title="enter your phone number if any."/>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Email</h4></label>
                                <input type="email" class="form-control" value="${hosotaikhoan.email}" name="email"
                                       id="email" title="enter your email."
                                       readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Nơi sống</h4></label>
                                <input type="text" placeholder="Nơi sống" class="form-control" readonly="readonly"
                                       value="<c:if
                                        test="${(hosotaikhoan.noiSong.tentinhthanh != null)&&(hosotaikhoan.noiSong.quanhuyen.tenquanhuyen != null)}">${hosotaikhoan.noiSong.quanhuyen.tenquanhuyen} - ${hosotaikhoan.noiSong.tentinhthanh} </c:if>"/>
                                <c:if test="${hosotaikhoan.email == email}">
                                    <button type="button" class="btn btn-info btn-group-lg" data-toggle="modal"
                                            data-target="#myModal">Thay đổi nơi sống
                                    </button>
                                </c:if>
                            </div>


                        </div>


                        <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <label>Chọn Nơi Sống</label>
                                    </div>
                                    <div class="modal-body">
                                        <select id='tinhthanh' class="form-control form-control-lg">
                                            <option value="${hosotaikhoan.noiSong.tentinhthanh}"
                                                    selected>${hosotaikhoan.noiSong.tentinhthanh}</option>
                                            <c:forEach items="${tinhthanh}" var="tinh">
                                                <c:if test="${tinh.tenTinhThanh != hosotaikhoan.noiSong.tentinhthanh}">
                                                    <option value="${tinh.tenTinhThanh}">${tinh.tenTinhThanh}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                        <select id='quanhuyen' class="form-control form-control-lg">
                                            <option value="${hosotaikhoan.noiSong.quanhuyen.tenquanhuyen}"
                                                    selected>${hosotaikhoan.noiSong.quanhuyen.tenquanhuyen}</option>
                                        </select>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default " data-dismiss="modal">Close
                                        </button>
                                        <button type="button" class="btn  btn-block" onclick="choiceaddress()">Chọn
                                        </button>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Ngày sinh</h4></label>
                                <fmt:formatDate value="${hosotaikhoan.ngaySinh}" pattern="YYYY-MM-dd" var="ngaysinh"/>
                                <input type="date" class="form-control" id="dateofbirth" name="ngaySinh"
                                       value="${ngaysinh}"/>
                                <h1></h1>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6">
                                <label><h4>Giới tính</h4></label></br>
                                <div class="radio-inline">
                                    <label><input type="radio" path="gioiTinh" value="true" name="gioiTinh"
                                        ${hosotaikhoan.gioiTinh==true ? 'checked':''}
                                                  class="ng-pristine ng-untouched ng-valid"/> Nam</label>
                                </div>
                                <div class="radio-inline">
                                    <label><input type="radio" path="gioiTinh" value="false" name="gioiTinh"
                                        ${hosotaikhoan.gioiTinh==false ? 'checked':''}
                                                  class="ng-pristine ng-untouched ng-valid"/> Nữ</label>
                                </div>
                            </div>
                        </div>
                        <c:if test="${hosotaikhoan.email == email}">
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <button class="btn btn-lg btn-success" type="submit"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Save
                                    </button>
                                    <h1 id="status-updateinfo"></h1>
                                </div>
                            </div>
                        </c:if>
                    </form:form>

                    <hr>

                </div><!--/tab-pane-->
                <div class="tab-pane" id="messages">

                    <h2></h2>

                    <hr>
                    <c:if test="${hosotaikhoan.email == email}">
                        <form class="form" action="/changepassword" method="post" id="changepasswordform">
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="email"><h4>Mật khẩu cũ</h4></label>
                                    <input type="password" class="form-control" name="matkhaucu">
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label><h4>Mật khẩu mới</h4></label>
                                    <input type="password" class="form-control" name="matkhaumoi">
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label><h4>Nhập lại mật khẩu</h4></label>
                                    <input type="password" class="form-control" name="matkhaumoi1">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <button class="btn btn-lg btn-success" type="submit"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Save
                                    </button>
                                    <button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i>
                                        Reset
                                    </button>
                                </div>
                            </div>

                        </form>
                    </c:if>
                </div><!--/tab-pane-->

            </div><!--/tab-pane-->
        </div><!--/tab-content-->

    </div><!--/col-9-->
</div><!--/row-->

<script src="/resources/js/update-profile.js"></script>
<script src="/resources/js/tinhthanh-profile.js"></script>
<script src="/resources/js/upload-baidang.js"></script>
<script src="/resources/js/hienthibaidang.js"></script>
<script src="/resources/js/tuongtac-baidang.js"></script>
</body>
</html>