<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10"><h1>User name</h1></div>
        <div class="col-sm-2"><a href="/users" class="pull-right"><img title="profile image"
                                                                       class="img-circle img-responsive"
                                                                       src="http://www.gravatar.com/avatar/28fd20ccec6865e2d5f0e1f4446eb7bf?s=100"></a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3"><!--left col-->


            <div class="text-center">
                <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail"
                     alt="avatar">
                <form id="upload-avatar"  action="/uploadimage" method="POST" enctype="multipart/form-data">
                <input type="file" class="text-center center-block file-upload" name="file" id="fileimage-avatar">
                    <input type="submit" value="chọn ảnh" />
                </form>
            </div>
            </hr><br>


            <ul class="list-group">
                <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Shares</strong></span> 125</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Likes</strong></span> 13</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Posts</strong></span> 37</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Followers</strong></span> 78</li>
            </ul>


        </div><!--/col-3-->
        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Profile</a></li>
                <li><a data-toggle="tab" href="#messages">Change Password</a></li>
                <li><a data-toggle="tab" href="#settings">Menu 2</a></li>
            </ul>


            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>
                    <form:form class="form" action="#" method="post" id="updateinfo"
                               modelAttribute="hosotaikhoan">
                        <div class="form-group">

                            <div class="col-xs-6 ">
                                <label><h4>Tên hiển thị</h4></label>
                                <form:input type="text" class="form-control" name="tenHienThi" path="tenHienThi"
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
                                <input type="email" class="form-control" id="location"
                                       title="enter a location">
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label><h4>Ngày sinh</h4></label>
                                <fmt:formatDate value="${hosotaikhoan.ngaySinh}" pattern="YYYY-MM-dd" var="ngaysinh"/>
                                <input type="date" class="form-control" id="dateofbirth" name="ngaySinh"
                                   value="${ngaysinh}" />
                                <h1>   </h1>
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
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success" type="submit"><i
                                        class="glyphicon glyphicon-ok-sign"></i> Save
                                </button>
                                <h1 id="status-updateinfo" > </h1>
                            </div>
                        </div>
                    </form:form>

                    <hr>

                </div><!--/tab-pane-->
                <div class="tab-pane" id="messages">

                    <h2></h2>

                    <hr>
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
                                <button class="btn btn-lg btn-success" type="submit" ><i
                                        class="glyphicon glyphicon-ok-sign"></i> Save
                                </button>
                                <button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset
                                </button>
                            </div>
                        </div>
                    </form>

                </div><!--/tab-pane-->

            </div><!--/tab-pane-->
        </div><!--/tab-content-->

    </div><!--/col-9-->
</div><!--/row-->
<script src="/resources/js/profile-uploadfile.js"></script>
<script src="/resources/js/update-profile.js"></script>
</body>
</html>