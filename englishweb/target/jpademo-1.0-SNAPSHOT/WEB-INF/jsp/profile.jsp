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
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/statusbox.css">
    <link rel="stylesheet" href="/resources/css/profile-css.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<hr>
<div class="container-fluid bootstrap snippet header">
    <div class="row">
        <div class="col-sm-2"><a href="/users" class="pull-right symbol"><img title="profile image"
                                                                              class="img-circle img-responsive"
                                                                              src="/resources/image/symbol.png"></a>
        </div>
        <div class="col-sm-10">
            <a href="/profile"><h1>${hosotaikhoan.tenHienThi}</h1>
            </a>

        </div>
    </div>
    <br>
</div>

<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-3"><!--left col-->


            <div class="text-center">
                <img src="/resources/image/hinhdaidien/${hosotaikhoan.anhDaiDien.duongDan}" id="avatar"
                     style="max-height: 100% ; max-width: 100%"
                     class="avatar img-rounded img-thumbnail"
                     alt="avatar">


                <form id="upload-avatar" action="/uploadimage" method="POST" enctype="multipart/form-data">
                    <input type="file" class="text-center center-block file-upload" name="avatar-file"
                           id="fileimage-avatar"
                           hidden>
                    <input type="button" value="Đổi ảnh đại diện" onclick="openFile()"/>
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
                <li class="list-group-item text-right"><span class="pull-left"><strong>Shares</strong></span> 125</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Likes</strong></span> 13</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Posts</strong></span> 37</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Followers</strong></span> 78</li>
            </ul>


        </div><!--/col-3-->
        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li><a data-toggle="tab" href="#home">Home</a></li>
                <li><a data-toggle="tab" href="#profile">Profile </a></li>
                <li><a data-toggle="tab" href="#messages">Change Password</a></li>
            </ul>


            <div class="tab-content">

                <div class="tab-pane active" id="home">
                    <div class="col-md-6">
                        <div class="widget-area no-padding blank">
                            <div class="status-upload">
                                <form>
                                    <textarea placeholder="What are you doing right now?"></textarea>
                                    <input type="file" multiple name="imagefile" hidden="hidden" id="upload-image">
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
                                    <button type="submit" class="btn btn-success green"><i class="fa fa-share"></i>
                                        Post
                                    </button>
                                </form>
                            </div><!-- Status Upload  -->
                        </div><!-- Widget Area -->
                    </div>

                </div>


                <div class="tab-pane " id="profile">
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
                                <input type="text" placeholder="Nơi sống" class="form-control" readonly="readonly"
                                       value="<c:if
                                        test="${(hosotaikhoan.noiSong.tentinhthanh != null)&&(hosotaikhoan.noiSong.quanhuyen.tenquanhuyen != null)}">${hosotaikhoan.noiSong.quanhuyen.tenquanhuyen} - ${hosotaikhoan.noiSong.tentinhthanh} </c:if>"/>
                                <button type="button" class="btn btn-info btn-group-lg" data-toggle="modal"
                                        data-target="#myModal">Thay đổi nơi sống
                                </button>

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
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success" type="submit"><i
                                        class="glyphicon glyphicon-ok-sign"></i> Save
                                </button>
                                <h1 id="status-updateinfo"></h1>
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
                                <button class="btn btn-lg btn-success" type="submit"><i
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

<script src="/resources/js/update-profile.js"></script>
<script src="/resources/js/tinhthanh-profile.js"></script>
</body>
</html>