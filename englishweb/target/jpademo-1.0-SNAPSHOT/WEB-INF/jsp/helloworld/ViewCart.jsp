<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JuniePC
  Date: 29/12/17
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table>
   <tr>
       <td>Product</td>
       <td>Quantity</td>
   </tr>
    <c:forEach var="cart" items="${carts}">
        <tr>
        <td>
            <img src="/resources/image/${product.photo}" alt="" ><br>
            <a href="/detail?id=${product.id}" >${product.name}</a> <br>
                ${cart.product.description}<br>
                ${cart.product.price}<br>
                ${cart.product.warranty}<br></td>
        <td>${cart.quantity}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
