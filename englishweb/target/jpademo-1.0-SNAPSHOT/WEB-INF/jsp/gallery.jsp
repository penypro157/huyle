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
            <c:forEach items="${images}" var="image">
            <div class="post-image">
                <img src="/resources/image/baidang/${image.duongDan}" class="img-rounded" alt="Cinque Terre">
                </c:forEach>
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