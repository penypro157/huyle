<%--
  Created by IntelliJ IDEA.
  User: JuniePC
  Date: 22/12/17
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Vertical (basic) form</h2>
    <mvc:form action="">
        <div class="form-group">
            <mvc:label for="email">Email:</mvc:label>
            <mvc:input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
        </div>
        <div class="form-group">
            <mvc:label for="pwd">Password:</mvc:label>
            <mvc:input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
        </div>
        <div class="checkbox">
            <mvc:label><input type="checkbox" name="remember"> Remember me</mvc:label>
        </div>
        <mvc:button type="submit" class="btn btn-default">Submit</mvc:button>
    </mvc:form>
</div>

</body>
</html>
