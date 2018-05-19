<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: huyl4
  Date: 3/2/2018
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/custom.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body >
<div class="container main-section">
    <div class="row">

        <div class="col-md-3 col-sm-3 col-xs-12 left-sidebar">
            <div class="input-group searchbox">
                <input class="form-control" placeholder="Search" name="srch-term" id="srch-term" type="text">
                <div class="input-group-btn">
                    <button class="btn btn-default search-icon" type="submit" id="search-button" ><i class="glyphicon glyphicon-search"></i></button>
                </div>
            </div>
            <div class="custom-selet" style="width:200px;">
                <select name="language">
                    <option value="" >All Languages</option>



                    <c:forEach var="language" items="${languages}">
                        <option value="${language.countryId}" >${language.name}</option>
                    </c:forEach>



                </select>
            </div>

            <div class="custom-selet" style="width:200px;">
                <select name="country">
                    <option value="" >All Countries</option>
                    <c:forEach var="country" items="${countries}">
                        <option value="${country.countryId}" >${country.name}</option>

                    </c:forEach>


                </select>
            </div>
            <div>
                <input type="button" value="Search" name="search" onclick="finduser()">

            </div>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value="">
                    <span class="cr"><i class="cr-icon glyphicon glyphicon-arrow-right"></i></span>
                    <a>Online Now</a>
                </label>
            </div>


            <div class="left-chat" >
                <ul> <c:forEach var="user" items="${conntactList}">
                    <a  href="javascript:loadM();">
                    <li>
                        <div class="chat-left-img" >
                            <img src="/resources/image/1499345224_female1.png">
                        </div>
                        <div class="chat-left-detail">
                            <p>${user.username}</p>
                            <span><i class="fa fa-circle orange" aria-hidden="true"></i> ${user.timeUpdate}</span>
                        </div>
                    </li>
                    </a>
                </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 col-xs-12 right-sidebar">
            <div class="row">
                <div class="col-md-12 right-header">
                    <%--<div class="right-header-img">--%>
                        <%--<img src="/resources/image/businessman.png">--%>
                    <%--</div>--%>
                    <%--<div class="right-header-detail">--%>
                        <%--<p>${user.username}</p>--%>
                        <%--<span>${user.timeUpdate}</span>--%>
                    <%--</div>--%>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 right-header-contentChat">
                    <ul>
                        <li>
                            <div class="rightside-left-chat">
                                <span><i class="fa fa-circle" aria-hidden="true"></i> joi chak <small>10:00 AM,Today</small> </span><br><br>
                                <p>Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim mollit anim laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.</p>
                            </div>
                        </li>
                        <li>
                            <div class="rightside-right-chat">
                                <span> <small>10:00 AM,Today</small>  nik minaj <i class="fa fa-circle" aria-hidden="true"></i></span><br><br>
                                <p>Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.</p>
                            </div>
                        </li>
                        <li>
                            <div class="rightside-left-chat">
                                <span><i class="fa fa-circle" aria-hidden="true"></i> joi chak <small>10:00 AM,Today</small> </span><br><br>
                                <p>Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim mollit anim laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.</p>
                            </div>
                        </li>
                        <li>
                            <div class="rightside-right-chat">
                                <span> <small>10:00 AM,Today</small>  nik minaj <i class="fa fa-circle" aria-hidden="true"></i></span><br><br>
                                <p>Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.</p>
                            </div>
                        </li>
                        <li>
                            <div class="rightside-left-chat">
                                <span><i class="fa fa-circle" aria-hidden="true"></i> joi chak <small>10:00 AM,Today</small> </span><br><br>
                                <p>Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim mollit anim laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.</p>
                            </div>
                        </li>
                        <li>
                            <div class="rightside-right-chat">
                                <span> <small>10:00 AM,Today</small>  nik minaj <i class="fa fa-circle" aria-hidden="true"></i></span><br><br>
                                <p>Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.</p>
                            </div>
                        </li>
                        <li>
                            <div class="rightside-left-chat">
                                <span><i class="fa fa-circle" aria-hidden="true"></i> joi chak <small>10:00 AM,Today</small> </span><br><br>
                                <p>Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim mollit anim laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.</p>
                            </div>
                        </li>
                        <li>
                            <div class="rightside-right-chat">
                                <span> <small>10:00 AM,Today</small>  nik minaj <i class="fa fa-circle" aria-hidden="true"></i></span><br><br>
                                <p>Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.</p>
                            </div>
                        </li>
                        <li>
                            <div class="rightside-left-chat">
                                <span><i class="fa fa-circle" aria-hidden="true"></i> joi chak <small>10:00 AM,Today</small> </span><br><br>
                                <p>Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim mollit anim laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.</p>
                            </div>
                        </li>
                        <li>
                            <div class="rightside-right-chat">
                                <span> <small>10:00 AM,Today</small>  nik minaj <i class="fa fa-circle" aria-hidden="true"></i></span><br><br>
                                <p>Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.
                                    Lorem ipsum dolor sit ameeserunt mollit anim id est laborum.</p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 right-chat-textbox">
                    <input type="text"><a href="#"><i class="fa fa-arrow-right" aria-hidden="true"></i></a>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        var height = $(window).height();
        $('.left-chat').css('height', (height - 92) + 'px');
        $('.right-header-contentChat').css('height', (height - 163) + 'px');
    });
    function promt() {
        var name=promt("Enter Your Name","Guest");
    }
</script>
<%--<script src="/resources/js/room-checkonlineuser.js"></script>--%>
<script src="../../resources/js/searchAJAX.js"></script>
<script src="../../resources/js/loadMassage.js"></script>
<script src="../../resources/js/searchuser.js"></script>
<script src="../../resources/js/updatetime.js"></script>
</body>
</html>
