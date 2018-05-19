<%--
  Created by IntelliJ IDEA.
  User: JuniePC
  Date: 22/12/17
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello world</title>
    <script language="javascript" src="/resources/js/comment.js"></script>
</head>
<body>

<p>Hello World</p>



<input type="text" placeholder="Write something" id="comment"/>
<label id="show">1</label>
<input type="button" value="click me" onclick="setTimeout(showMessage,3000)"/>
<form method="post" action="">
    Username: <input type="text" value="" name="username" id="username"/> <br/>
    Password: <input type="text" value="" name="password" id="password"/> <br/>
    Re Password: <input type="text" value="" name="re-password" id="re-password"/> <br/>
    <input type="submit" value="Register" onclick="return validate()" />
</form>
</body>
</html>
