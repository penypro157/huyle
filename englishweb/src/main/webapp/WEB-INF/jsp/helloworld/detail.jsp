<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JuniePC
  Date: 29/12/17
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<img src="/resources/image/${product.photo}"><br>
<p>${product.name}</p>
<p>${product.description}</p>
<a href="/addCart?id=${product.id}">Add To Cart</a>
<a href="/viewCart">View Cart</a>

</body>
</html>
